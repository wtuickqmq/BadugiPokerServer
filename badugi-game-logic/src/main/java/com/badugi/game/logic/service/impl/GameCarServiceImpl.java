package com.badugi.game.logic.service.impl;

import io.nadron.client.util.ObjectBeanUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.badugi.game.logic.dao.DrawItemDao;
import com.badugi.game.logic.dao.DrawRecordDao;
import com.badugi.game.logic.dao.RacingCarBetChipsDao;
import com.badugi.game.logic.dao.RacingCarLogDao;
import com.badugi.game.logic.helper.LobbyUserHelper;
import com.badugi.game.logic.model.cache.CarCache;
import com.badugi.game.logic.model.cache.LocalCache;
import com.badugi.game.logic.model.callback.LogicMap;
import com.badugi.game.logic.model.callback.LogicRequest;
import com.badugi.game.logic.model.callback.RPCReponse;
import com.badugi.game.logic.model.domain.vo.flash.user.MsgSendVo;
import com.badugi.game.logic.model.entity.RacingcarBetChips;
import com.badugi.game.logic.model.entity.UserFund;
import com.badugi.game.logic.model.lobby.helper.GameCarHelper;
import com.badugi.game.logic.model.utils.common.DateUtils;
import com.badugi.game.logic.model.utils.common.Md5Utils;
import com.badugi.game.logic.model.vo.supreme.BetHitFull;
import com.badugi.game.logic.model.vo.supreme.BetHitMaxlimit;
import com.badugi.game.logic.model.vo.supreme.CollectionBetsVo;
import com.badugi.game.logic.model.vo.supreme.ConstantPool;
import com.badugi.game.logic.model.vo.supreme.DealerQueueResult;
import com.badugi.game.logic.model.vo.supreme.DealerQueueVo;
import com.badugi.game.logic.model.vo.supreme.DealerStatus;
import com.badugi.game.logic.model.vo.supreme.ExceptionVo;
import com.badugi.game.logic.model.vo.supreme.ImmediateChipsChange;
import com.badugi.game.logic.model.vo.supreme.PlayerImVo;
import com.badugi.game.logic.model.vo.supreme.PlayerInfoInSupremeRoom;
import com.badugi.game.logic.model.vo.supreme.PrizeEntry;
import com.badugi.game.logic.model.vo.supreme.PrizeItem;
import com.badugi.game.logic.model.vo.supreme.StartRacingcarVo;
import com.badugi.game.logic.model.vo.supreme.SupremeResultVo;
import com.badugi.game.logic.model.vo.supreme.SupremeRooms;
import com.badugi.game.logic.model.vo.supreme.SupremeVo;
import com.badugi.game.logic.service.GameCarService;
import com.badugi.game.logic.util.AppContext;
import com.badugi.game.logic.util.IdGenerator;
import com.badugi.game.logic.util.LogicChannelUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.joker.common.util.StringUtil;
import com.joker.game.common.constant.Definition;
import com.joker.game.common.constant.EventDefinition;
import com.joker.game.db.redis.RedisLogin;

@Service("carService")
public class GameCarServiceImpl implements GameCarService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GameCarServiceImpl.class);

	private AtomicBoolean isOpen;

//	private Set<String> waitList; // 等待列表

	private Set<String> sessionList; // 正式用户列表

	private String lotteryResults; // 开奖结果

	private Long begintime; // 服务器开始维护时间

	private Long endtime; // 服务器结束维护时间

	private AtomicBoolean randomResult; // 随机开奖
	
	public static final String NOTIFY_CHAR = "《极品豪车》将在%s至%s期间进行维护，届时将无法进入游戏。给您造成的不便，敬请谅解！"; //维护提示文字

	public static final String NOTIFY_EXIT = "《极品豪车》即将进行维护，现已暂停游戏。为保障您的账户安全，请及时退出房间。";
	
	public GameCarServiceImpl() {
//		waitList = Sets.newHashSet();
		sessionList = Sets.newHashSet();
		isOpen = new AtomicBoolean(true);
		randomResult = new AtomicBoolean(false);
	}

	@RPCReponse("call_stop")
	public void call_stop(LogicRequest request) {
		LOGGER.info("{}", request);
		isOpen.set(false);
		for (String session : sessionList) {
			this.removeUser(session);
		}
	}

	@RPCReponse(EventDefinition.EVENT_E_DOWN_DEALER)
	public void e_down_dealer(LogicRequest args) {
		SupremeVo sv = null;
		SupremeResultVo srVo = null;
		DealerStatus ds = null;
		// DealerQueueVo dev = null;
		try {
			sv = ObjectBeanUtil.JACKSON.readValue(args.getData(), SupremeVo.class);
			Long dealerId = null;
			ds = CarCache.CURRENTDEALER.peek();
			dealerId = ds.getFbId();
			if (sv != null && sv.getCmd().equalsIgnoreCase(EventDefinition.EVENT_E_DOWN_DEALER) && dealerId != null && sv.getFbId().longValue() == dealerId.longValue()) {
				srVo = new SupremeResultVo(sv.getFbId(), EventDefinition.EVENT_DOWN_DEALER, Definition.DOWN_DEALER_DESCRIPTION);
				sendToTargets(args.getSession(), srVo);// 通知申请下庄者该局结束后会自动下庄
				// ds = CarCache.CURRENTDEALER.peek();
				// CarCache.CURRENTDEALER.clear();
				// ds.setNextDownDealer(true);
				// CarCache.CURRENTDEALER.add(ds);
				CarCache.CURRENTDEALER.peek().setNextDownDealer(true);
			} else {
				StringBuffer content = new StringBuffer();
				if (sv == null) {
					content.append("申请下庄庄家信息为空     ");
				}
				if (!sv.getCmd().equalsIgnoreCase(EventDefinition.EVENT_E_DOWN_DEALER)) {
					content.append(" 申请下庄命令不对   ");
				}
				if (dealerId == null) {
					content.append(" 当前庄家ID为空      ");
				}
				if (sv.getFbId().longValue() != dealerId.longValue()) {
					content.append(" 申请下庄者不是当前庄家     ");
				}
				ExceptionVo ev = new ExceptionVo(sv.getFbId(), Definition.JOIN_RACINGCAR_ROOM_FAILED_CODE, EventDefinition.EVENT_DOWNDEALER_EXCEPTION, "申请下庄异常", content.toString());
				sendToTargets(args.getSession(), ev);
			}
		} catch (Exception e) {
			LOGGER.error("", e);
		}

	}

	@RPCReponse(EventDefinition.EVENT_PLAYER_IM_SEND)
	public void player_im_send(LogicRequest args) {
		PlayerImVo piv = null;
		try {
			piv = ObjectBeanUtil.JACKSON.readValue(args.getData(), PlayerImVo.class);
			if (piv != null && piv.getCmd().equals(EventDefinition.EVENT_PLAYER_IM_SEND) && piv.getFbId() != null) {
				// TODO
				// PlayerIm playerim = new PlayerIm(IdGenerator.getNextId(),
				// piv.getFbId(), piv.getMsg());
				// PlayerImDao.savePlayerIm(playerim);// 保存玩家发消息
				// UserFund uf =
				// AppContext.getBean(UserFundDao.class).getUserFundById(piv.getFbId());
				UserFund uf = LobbyUserHelper.getUserFund(piv.getFbId());
				piv = new PlayerImVo(EventDefinition.EVENT_PLAYER_IM_RECEIVE, piv.getMsg(), piv.getFbId(), uf.getFbname());
				// Enumeration<Long> keys = userChannel.keys();
				LogicChannelUtil.sendToAll(piv);
			}
		} catch (Exception e) {
			LOGGER.error("", e);
		}

	}

	@RPCReponse(EventDefinition.EVENT_START_BET)
	public void start_bet(LogicRequest args) {
		try {
			SupremeResultVo srVo = null;
			SupremeVo svo = null;
			LOGGER.debug("进入StartBetThread############");
			svo = ObjectBeanUtil.JACKSON.readValue(args.getData(), SupremeVo.class);
			if (svo == null || svo.getCmd().equals(EventDefinition.EVENT_START_BET)) {
				CarCache.BETDEADTIME = System.currentTimeMillis() + CarCache.LASTINGTIME; // 截止押注时间
				srVo = new SupremeResultVo(EventDefinition.EVENT_START_BET);
				sendToTargets(args.getSession(), srVo);
			}
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	@RPCReponse(EventDefinition.EVENT_EXIT_SUPREMECAR)
	public void escape_exit(LogicRequest args) {
		SupremeVo supremevo = null;
		try {
			supremevo = ObjectBeanUtil.JACKSON.readValue(args.getData(), SupremeVo.class);
			removeUser(supremevo.getFbId().toString());
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	/**
	 * 玩家退出房间
	 * 
	 * @param fbId
	 */
	public synchronized void removeUser(String fbId) {
		if (null != fbId) {
//			this.waitList.remove(fbId);
			// 移除小游戏房间的session
			boolean flag = this.removeSession(fbId);

			if (!flag) {
				return;
			}
			ConcurrentHashMap<Long, PlayerInfoInSupremeRoom> inRoomQueue = CarCache.PLAYER_INFO_IN_SUPREMEROOM;
			Long userId = Long.valueOf(fbId);

			DealerStatus ds = CarCache.CURRENTDEALER.peek();

			if (null != ds) {
				Long dealerId = ds.getFbId();
				if (dealerId.longValue() == userId.longValue()) {
					// if (ds.getInning() > ConstantPool.LIMITINNING) {
					ds.setNextDownDealer(true);
					// }

				}
			}
			if (inRoomQueue.containsKey(userId)) // 玩家是否在庄家队列
			{
				// 获取用户信息
				// PlayerInfoInSupremeRoom playerInfoInSupremeRoom =
				// inRoomQueue.get(userId);
				// 移除房间
				CarCache.PLAYER_INFO_IN_SUPREMEROOM.remove(userId);

				// ds.setNextDownDealer(true);
				ConcurrentLinkedQueue<DealerQueueVo> dealerQueueVoQueue = CarCache.DEALERQUEUE.get(ConstantPool.DEALERQUEUE);

				if (!dealerQueueVoQueue.isEmpty()) {
					Iterator<DealerQueueVo> iterator = dealerQueueVoQueue.iterator();
					while (iterator.hasNext()) {
						DealerQueueVo dv = iterator.next();
						if (dv.getFbId().longValue() == userId.longValue()) {
							LobbyUserHelper.updateUserFund(dv.getFbId(), +dv.getUpChips());
							iterator.remove();
							DealerQueueResult dqr = new DealerQueueResult(EventDefinition.EVENT_UP_DEALER_RETURN, Definition.RACINGCAR_SUCCESS_CODE, dealerQueueVoQueue);
							// sendToTargets(args.getSession(), dqr);
							sendToAll(dqr);
							break;
						}
					}
				}

			}
		}

	}

	private void bet_chip(CollectionBetsVo betsVo) {

		String item = betsVo.getItem();
		Map<Long, Map<String, String>> map1 = getBetSingle(item);
		Map<String, String> map2 = getChipsMap(item);

		if (null != map1) {
			chipEntry(map1, betsVo.getUpChips(), betsVo.getFbId());
		}
		if (null != map2) {
			chipKeep(map2, betsVo.getUpChips());
		}

	}

	private Map<String, String> getChipsMap(String item) {

		if (PrizeItem.MINVW.getItem().equals(item)) // 小大众
		{
			return CarCache.MINVWCHIPSMAP;// ;

		} else if (PrizeItem.MINBMW.getItem().equals(item)) // 小宝马
		{
			return CarCache.MINBMWCHIPSMAP;// ;

		} else if (PrizeItem.MINBENZ.getItem().equals(item)) // 小奔驰
		{
			return CarCache.MINBENZCHIPSMAP;// ;

		} else if (PrizeItem.MINPORSCHE.getItem().equals(item)) // 小保时捷
		{
			return CarCache.MINPORSCHECHIPSMAP;// ;

		} else if (PrizeItem.BIGVW.getItem().equals(item)) // 大大众
		{
			return CarCache.BIGVWCHIPSMAP;

		} else if (PrizeItem.BIGBMW.getItem().equals(item)) // 大宝马
		{
			return CarCache.BIGBMWCHIPSMAP;

		} else if (PrizeItem.BIGBENZ.getItem().equals(item)) // 大奔驰
		{
			return CarCache.BIGBENZCHIPSMAP;

		} else if (PrizeItem.BIGPORSCHE.getItem().equals(item)) // 大保时捷
		{
			return CarCache.BIGPORSCHECHIPSMAP;
		}

		Map<String, String> map = Maps.newConcurrentMap();

		return map;

	}

	private Map<Long, Map<String, String>> getBetSingle(String item) {

		if (PrizeItem.MINVW.getItem().equals(item)) // 小大众
		{
			return CarCache.MINVWCHIPS;

		} else if (PrizeItem.MINBMW.getItem().equals(item)) // 小宝马
		{
			return CarCache.MINBMWCHIPS;

		} else if (PrizeItem.MINBENZ.getItem().equals(item)) // 小奔驰
		{
			return CarCache.MINBENZCHIPS;

		} else if (PrizeItem.MINPORSCHE.getItem().equals(item)) // 小保时捷
		{
			return CarCache.MINPORSCHECHIPS;

		} else if (PrizeItem.BIGVW.getItem().equals(item)) // 大大众
		{
			return CarCache.BIGVWCHIPS;

		} else if (PrizeItem.BIGBMW.getItem().equals(item)) // 大宝马
		{
			return CarCache.BIGBMWCHIPS;

		} else if (PrizeItem.BIGBENZ.getItem().equals(item)) // 大奔驰
		{
			return CarCache.BIGBENZCHIPS;

		} else if (PrizeItem.BIGPORSCHE.getItem().equals(item)) // 大保时捷
		{
			return CarCache.BIGPORSCHECHIPS;
		}
		Map<Long, Map<String, String>> betSingle = Maps.newHashMap();
		return betSingle;
	}

	/**
	 * 进行押注
	 * 
	 * @param sessionId
	 * @param userfund
	 * @param betsVo
	 * @param betIsFull
	 * @param betLimits1
	 * @param betLimits2
	 * @param betIsExceeding1
	 * @param betIsExceeding2
	 */
	public void bet_item(String sessionId, UserFund userfund, CollectionBetsVo betsVo, Map<String, Boolean> betIsFull, Map<String, Long> betLimits1, Map<String, Long> betLimits2,
			Map<String, Boolean> betIsExceeding1, Map<String, Boolean> betIsExceeding2) {

		if (null == betIsFull) {
			betIsFull = Maps.newHashMap();
		}
		if (null == betLimits1) {
			betLimits1 = Maps.newHashMap();
		}
		if (null == betLimits2) {
			betLimits2 = Maps.newHashMap();
		}
		if (null == betIsExceeding1) {
			betIsExceeding1 = Maps.newHashMap();
		}
		if (null == betIsExceeding2) {
			betIsExceeding2 = Maps.newHashMap();
		}
		String item = betsVo.getItem();
		if (null == item || null == betsVo) {
			return;
		}
		PrizeItem[] prizeItemList = PrizeItem.values();
		boolean flag = false;
		for (PrizeItem prizeItem : prizeItemList) {
			if (prizeItem.getItem().equals(item)) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			sendToTargets(sessionId, (new ExceptionVo(betsVo.getFbId(), Definition.JOIN_RACINGCAR_ROOM_FAILED_CODE, Definition.COLLECTIONBET_EXCEPTION, Definition.COLLECTIONBET_EXCEPTION_TYPE,
					"当前押注不是8种押注门类中任意一种,为异常押注,不作任何处理,返回重新押注" + betsVo.getItem().toUpperCase())));
			return;
		}

		boolean betIsExceeding1Flag = false;

		boolean betIsExceeding2Flag = false;

		if (betIsExceeding1.containsKey(item)) {
			betIsExceeding1Flag = betIsExceeding1.get(item);
		}
		if (betIsExceeding1.containsKey(item)) {
			betIsExceeding2Flag = betIsExceeding2.get(item);
		}
		if (betIsFull.containsKey(item) && null != betIsFull.get(item) && true == betIsFull.get(item)) {// 押注满

			CarCache.BETFULLITEMS.put(item, betLimits2.get(item));// 记录到满的押注筹码量

			// this.bet_chip(betsVo);

			// betChipsPerPlayer(item, betsVo.getFbId(),
			// betsVo.getUpChips().longValue());

			// CarCache.CHIPSSET.put(item, CarCache.CHIPSSET.get(item) +
			// betsVo.getUpChips());

			// LobbyUserHelper.updateUserFund(betsVo.getFbId(),
			// -betsVo.getUpChips().doubleValue()); // 玩家押注更新玩家大厅筹码信息

			// CarCache.EACHWINSUMCHIPS.put(PrizeItem.SUMCHIPS.getItem(),
			// CarCache.EACHWINSUMCHIPS.get(PrizeItem.SUMCHIPS.getItem()) +
			// betsVo.getUpChips());

			sendToTargets(sessionId, new BetHitFull(EventDefinition.BET_HIT_FULL, betsVo.getFbId(), betLimits1.get(item), betIsFull));
		} else if (betIsExceeding1Flag || betIsExceeding2Flag) { // 若超过押注上限

			/**
			 *wtu.edit 2015-12-15 超过压注上限 
			 */
			//LobbyUserHelper.updateUserFund(betsVo.getFbId(), betsVo.getUpChips().doubleValue()); // 玩家押注更新玩家大厅筹码信息

			sendToTargets(sessionId, new BetHitMaxlimit(EventDefinition.BET_HIT_MAXLIMIT, betsVo.getFbId(), item, betsVo.getUpChips().longValue(), betLimits1.get(item), betIsExceeding2));
		} else { // 进入押注筹码处理

			this.bet_chip(betsVo);

			betChipsPerPlayer(item, betsVo.getFbId(), betsVo.getUpChips().longValue());

			CarCache.CHIPSSET.put(item, CarCache.CHIPSSET.get(item) + betsVo.getUpChips());

			Double userChips=LobbyUserHelper.updateUserFund(betsVo.getFbId(), -betsVo.getUpChips().doubleValue()); // 玩家押注更新玩家大厅筹码信息

			CarCache.EACHWINSUMCHIPS.put(PrizeItem.SUMCHIPS.getItem(), CarCache.EACHWINSUMCHIPS.get(PrizeItem.SUMCHIPS.getItem()) + betsVo.getUpChips());

			RacingcarBetChips racingcarbetchips = new RacingcarBetChips(betsVo.getUpChips(), betsVo.getFbId(), String.valueOf(GameCarHelper.getItemSort(item)),
					CarCache.RACINGCARID, CarCache.CURRENTDEALER.element().getFbId());
			// RacingcarBetChipsDao.saveRacingcarBetChips(racingcarbetchips);
			AppContext.getBean(RacingCarBetChipsDao.class).saveRacingcarBetChips(racingcarbetchips);

			Map<String, String> chipsMap = getChipsMap(item);

			Map<Long, Map<String, String>> betSingle = getBetSingle(item);
			
			
			LOGGER.info("---->{},betSingle:{},backchips:{}",betSingle.get(betsVo.getFbId()),chipCashes(betSingle.get(betsVo.getFbId())));
			/**
			 * wtu.edit 2015-12-15
			 * 原为广播发送，现改为发送给自己
			 * 
			 */
			sendToTargets(sessionId,new ImmediateChipsChange(EventDefinition.BET_CHIPS_CMD, betsVo.getFbId(), betsVo.getFbId(), betsVo.getUpChips(), item, chipsMap, userChips.longValue(), chipCashes(betSingle.get(betsVo.getFbId())), CarCache.CHIPSSET.get(item) + CarCache.ROBOTCHIPS.get(item), betIsExceeding2));
			// sendToTargets(
			// sessionId,
			// new ImmediateChipsChange(EventDefinition.BET_CHIPS_CMD,
			// betsVo.getFbId(), betsVo.getFbId(), betsVo.getUpChips(), item,
			// chipsMap, (long) (Math.floor(userfund.getChips()
			// - betsVo.getUpChips())),
			// chipCashes(betSingle.get(betsVo.getFbId())),
			// CarCache.CHIPSSET.get(item) + CarCache.ROBOTCHIPS.get(item),
			// betIsExceeding2));

			//GameCarHelper.betRtaCalc();
			GameCarHelper.betRankCalc(item, sessionId, userfund);
		}

	}

	

	

	@RPCReponse(EventDefinition.EVENT_E_BET)
	public void e_bet(LogicRequest args) {

		CollectionBetsVo betsVo = null;
		UserFund userfund = null;
		// UserBasic ub = null;
		try {
			betsVo = ObjectBeanUtil.JACKSON.readValue(args.getData(), CollectionBetsVo.class);

		} catch (Exception e) {
			// TODO: handle exception
		}
		if (System.currentTimeMillis() < CarCache.STARTRACINGCAR + CarCache.LASTINGTIME) {
			if (betsVo != null && betsVo.getCmd().equals(EventDefinition.EVENT_E_BET) && betsVo.getFbId() != null && betsVo.getUpChips() != null && betsVo.getItem() != null) {
				try {

					DealerStatus nowDealerStatus = CarCache.CURRENTDEALER.peek();

					if (null != nowDealerStatus) {
						if (nowDealerStatus.getFbId().longValue() == betsVo.getFbId().longValue()) {
							sendToTargets(args.getSession(), new ExceptionVo(betsVo.getFbId(), Definition.JOIN_RACINGCAR_ROOM_FAILED_CODE, Definition.COLLECTIONBET_EXCEPTION,
									Definition.COLLECTIONBET_EXCEPTION_TYPE, "当前为庄家, 不能押注!"));
							return;
						}
					}
					//userfund = LobbyUserHelper.getUserFund(betsVo.getFbId());

					// ub =
					// AppContext.getBean(UserBasicDao.class).findUserBasic(betsVo.getFbId());//
					// UserBasicDao.findUserBasic(betsVo.getFbId());
					Long userChips=LobbyUserHelper.getUserChips(betsVo.getFbId());
					if (userChips < betsVo.getUpChips()) {
						sendToTargets(args.getSession(), new SupremeResultVo(Definition.NO_ENOUTH_CHIPS_CODE, Definition.JOINRACINGCAR, betsVo.getFbId(), Definition.BET_INVALID_CHIPS));
						return;
					}

					if (CarCache.EACHWINSUMCHIPS.get(PrizeItem.SUMCHIPS.getItem()) == null) {
						CarCache.EACHWINSUMCHIPS.put(PrizeItem.SUMCHIPS.getItem(), 0L);
					} // 更新 每局游戏闲家押注总量
					Long sumChips = CarCache.EACHWINSUMCHIPS.get(PrizeItem.SUMCHIPS.getItem()) + CarCache.ROBOTSBETCHIPS;// 每局押注总筹码量=玩家押注总量+机器人押注总量
					Map<String, Long> betLimits1 = betLimit(sumChips);// 本局下注上限筹码
					Map<String, Boolean> betIsExceeding1 = betIsExceeding(betLimits1, 0L);// 判断本局下注是否达上限
					Map<String, Long> betLimits2 = betLimit(sumChips + betsVo.getUpChips().longValue());// 本局+新押注上限筹码
					Map<String, Boolean> betIsExceeding2 = betIsExceeding(betLimits2, betsVo.getUpChips().longValue());// 判断本局+新押注是否达上限
					Map<String, Boolean> betIsFull = betIsFull(betLimits2, betsVo.getUpChips().longValue());// 该门押注是否刚好达到上限,即该门押注满
					// System.out.println("#######################当前押注项是:" +
					// betsVo.getItem().toUpperCase());
					bet_item(args.getSession(), userfund, betsVo, betIsFull, betLimits1, betLimits2, betIsExceeding1, betIsExceeding2);

				} catch (Exception e) {
					e.printStackTrace();
					LOGGER.error("#####################deal with collection bet error  !!!", e);
					// System.out.println("#####################deal with collection bet error  !!!");
					sendToTargets(args.getSession(), new ExceptionVo(betsVo.getFbId(), Definition.JOIN_RACINGCAR_ROOM_FAILED_CODE, Definition.COLLECTIONBET_EXCEPTION,
							Definition.COLLECTIONBET_EXCEPTION_TYPE, "闲家押注处理过程中发生异常"));

					AppContext.getBean(RacingCarLogDao.class).saveSupremeCarLLog(betsVo.getFbId(), Definition.OPERTYPEERROR, Definition.OPERCONTENTERROR, Definition.OPERREMARKERROR);// 保存日志
					return;
				}
			} else { // 玩家未能进入押注,按系统异常处理
						// LobbyUserHelper.updateUserFund(betsVo.getFbId(),
						// betsVo.getUpChips().doubleValue()); //玩家押注更新玩家大厅筹码信息
						// LobbyUserHelper.sendLobbyUserFundChangeInfo(betsVo.getFbId(),
						// betsVo.getUpChips(),"异常押注,返回押注筹码");
				sendToTargets(args.getSession(), new ExceptionVo(betsVo.getFbId(), Definition.JOIN_RACINGCAR_ROOM_FAILED_CODE, Definition.COLLECTIONBET_EXCEPTION,
						Definition.COLLECTIONBET_EXCEPTION_TYPE, "玩家因押注命令,ID,或押注筹码,押注项异常未能进入押注,按系统异常处理"));
				AppContext.getBean(RacingCarLogDao.class).saveSupremeCarLLog(betsVo.getFbId(), Definition.OPERTYPEERROR, Definition.OPERCONTENTERROR, Definition.OPERREMARKERROR);// 保存日志
				return;
			}
		} else {
			// System.out.println("CollectionBetsThreadCarCache.STARTRACINGCAR ="
			// + CarCache.EACHWINSUMCHIPS);
			// new BetStopThread().start(); // 停止接收押注,开始跑灯
			// channel,"{\"cmd\":\""+
			// EventDefinition.EVENT_STOP_BET+"\"}"
			// (new
			// SupremeResultVo(EventDefinition.EVENT_STOP_BET,Definition.BETCOMPLETE_SUCCESS_CODE));//押注完成,开始跑灯
			// AppContext.getBean(RacingCarLogDao.class).saveSupremeCarLLog(betsVo.getFbId(),
			// Definition.OPERTYPE, Definition.OPERCONTENT,
			// Definition.OPERREMARK);// 保存日志
			return;
		}
	}

	@RPCReponse(EventDefinition.EVENT_UP_DEALER)
	public void e_up_dealer(LogicRequest args) {
		try {
			SupremeVo sv = ObjectBeanUtil.JACKSON.readValue(args.getData(), SupremeVo.class);
			DealerQueueVo dv = null;
			DealerQueueResult dqr = null;
			Iterator<DealerQueueVo> dvit = null;
			Iterator<DealerQueueVo> it = null;
			ConcurrentLinkedQueue<DealerQueueVo> alreadyDealer = null;

			if (sv != null && sv.getCmd().equals(EventDefinition.EVENT_UP_DEALER)) {
				if (sv.getFbId().longValue() == CarCache.CURRENTDEALER.peek().getFbId().longValue()) {
					dqr = new DealerQueueResult(EventDefinition.EVENT_UP_DEALER_RETURN, Definition.PLAYER_ALREADY_DEALER_CODE, "您已在庄上,下庄后才能重新申请上庄");
					sendToTargets(args.getSession(), dqr);
					return;
				}
				alreadyDealer = CarCache.DEALERQUEUE.get(ConstantPool.DEALERQUEUE);
				dvit = alreadyDealer.iterator();
				while (dvit.hasNext()) {
					dv = dvit.next();
					if (dv != null && dv.getFbId().longValue() == sv.getFbId().longValue()) { // 若申请上庄玩家已在上主庄队列,则不能上庄
						dqr = new DealerQueueResult(EventDefinition.EVENT_UP_DEALER_RETURN, Definition.PLAYER_ALREADY_DEALER_CODE, "您已在上庄队列,不能重复上庄");
						sendToTargets(args.getSession(), dqr);
						return;
					}
				}
				// UserFund userfund =
				// AppContext.getBean(UserFundDao.class).getUserFundById(sv.getFbId());
				//UserFund userfund = LobbyUserHelper.getUserFund(sv.getFbId());
				// com.joker.game.logic.model.entity.UserBasic ub =
				// AppContext.getBean(UserBasicDao.class).findUserBasic(sv.getFbId());

				// UserFundDetails userFundDetails =
				// LobbyUserHelper.getUserInfo(sv.getFbId());

				UserFund userfund = LobbyUserHelper.getUserFund(sv.getFbId());

				// Users user = UsersDao.findById(sv.getFbId());.
				LOGGER.debug("用户的筹码：{},[{}]",userfund.getChips(),ConstantPool.MINCHIPS);
				LOGGER.debug("发送的筹码：{},[{}]",sv.getUpChips(),ConstantPool.MINCHIPS);
				if (userfund.getChips() >= ConstantPool.MINCHIPS && sv.getUpChips() >= ConstantPool.MINCHIPS) {
					// dv = new DealerQueueVo(sv.getFbId(),
					// userfund.getFbname(), ub.getFigureurl(), false,
					// sv.getUpChips(), userfund.getChips() - sv.getUpChips(),
					// System.currentTimeMillis());
					dv = new DealerQueueVo(sv.getFbId(), userfund.getFbname(), userfund.getImgurl(), false, sv.getUpChips(), userfund.getChips() - sv.getUpChips(), System.currentTimeMillis());
					CarCache.DEALERQUEUE.get(ConstantPool.DEALERQUEUE).add(dv);
					// playerInfoInsupremerooms =
					// CarCache.PLAYER_INFO_IN_SUPREMEROOM; //当前游戏玩家人数
					// if(!playerInfoInsupremerooms.keySet().contains(sv.getFbId())){
					// CarCache.PLAYER_INFO_IN_SUPREMEROOM.put(sv.getFbId(), new
					// PlayerInfoInSupremeRoom(sv.getFbId(),
					// userfund.getFbname(), userfund.getIsRobot() == 1 ? true :
					// false, ub.getFigureurl(),
					// sv.getUpChips()));
					CarCache.PLAYER_INFO_IN_SUPREMEROOM.put(sv.getFbId(),
							new PlayerInfoInSupremeRoom(sv.getFbId(), userfund.getFbname(), userfund.getIsRobot() == 1 ? true : false, userfund.getImgurl(), sv.getUpChips()));
					// };
					ConcurrentLinkedQueue<DealerQueueVo> dealerQueue = CarCache.DEALERQUEUE.get(ConstantPool.DEALERQUEUE);// 上庄队列
					DealerQueueVo vo = null;
					List<DealerQueueVo> dealerList = new ArrayList<DealerQueueVo>();
					it = dealerQueue.iterator();
					while (it.hasNext()) {
						vo = it.next();
						dealerList.add(vo);
					}
					Collections.sort(dealerList, new Comparator<DealerQueueVo>() { // 按用户上庄时间降序排列
								@Override
								public int compare(DealerQueueVo o1, DealerQueueVo o2) {
									return o1.getDateTime().compareTo(o2.getDateTime());
								}
							});
					Collections.sort(dealerList, new Comparator<DealerQueueVo>() { // 按用户上庄筹码降序排列
								@Override
								public int compare(DealerQueueVo o1, DealerQueueVo o2) {
									return o2.getUpChips().compareTo(o1.getUpChips());
								}
							});
					CarCache.DEALERQUEUE.get(ConstantPool.DEALERQUEUE).clear();
					CarCache.DEALERQUEUE.get(ConstantPool.DEALERQUEUE).addAll(dealerList);
					// System.out.println("上庄前玩家大厅筹码值" + userfund.getChips());
					LobbyUserHelper.updateUserFund(sv.getFbId(), -sv.getUpChips());
					// //更新用户筹码值
					// System.out.println("上庄后玩家大厅筹码值" + userfund.getChips());
					// LobbyUserHelper.sendLobbyUserFundChangeInfo(sv.getFbId(),
					// -sv.getUpChips(),
					// "扣除本次玩家"+userfund.getFbName()+"小游戏申请上庄筹码");
					// UserApi.upduseramount(sv.getFbId(),
					// -(long)Math.floor(sv.getUpChips()),0,
					// "扣除本次玩家"+userfund.getFbName()+"小游戏申请上庄筹码");
					// System.out.println("#############扣除本次玩家" +
					LOGGER.debug( userfund.getFbname() + " -->小游戏申请上庄筹码:" + -sv.getUpChips());
					ConcurrentLinkedQueue<DealerQueueVo> ququelist = CarCache.DEALERQUEUE.get(ConstantPool.DEALERQUEUE);
					dqr = new DealerQueueResult(EventDefinition.EVENT_UP_DEALER_RETURN, Definition.RACINGCAR_SUCCESS_CODE, ququelist);
					// sendToTargets(args.getSession(), dqr);
					sendToAll(dqr);
				} else {// 上庄筹码不足
					LOGGER.debug("上庄筹码不足：{},传入id:{}",userfund,sv.getFbId());
					dqr = new DealerQueueResult(EventDefinition.EVENT_UP_DEALER_RETURN, Definition.NO_ENOUTH_CHIPS_CODE, Definition.ONDEALER_INVALID_CHIPS, sv.getFbId());
					sendToTargets(args.getSession(), dqr);
				}
				return;
			}
		} catch (Exception e) {
			LOGGER.error("", e);
		}

	}

	@RPCReponse(EventDefinition.EVENT_LAUNCH_RACING)
	public void e_launch_racing(LogicRequest args) {
		Long time = System.currentTimeMillis();
		boolean flag = begintime != null && endtime != null;
		if (flag && time.compareTo(begintime) != -1 && time.compareTo(endtime) != 1) {
			Map<String, Long> map = Maps.newHashMap();
			map.put("begintime", begintime);
			map.put("endtime", endtime);
			//
			String notify = String.format(NOTIFY_CHAR, DateUtils.dateToString(new Date(begintime),DateUtils.PATTERN_YMDHMS),DateUtils.dateToString(new Date(endtime),DateUtils.PATTERN_YMDHMS));
			
			MsgSendVo msgvo = new MsgSendVo(Definition.NOTICES, notify, DateUtils.dateToString(new Date(endtime), DateUtils.PATTERN_YMDHMS));
			// 发送
			LogicChannelUtil.sendToTarget(msgvo, args.getSession());
			return;
		}

		if (isOpen.get() == false) {
			StartRacingcarVo startRacingcarVo = new StartRacingcarVo(EventDefinition.EVENT_LAUNCH_RACING_RETURN, Definition.JOIN_RACINGCAR_ROOM_FULL_CODE, Definition.JOINRACINGCAR);
			startRacingcarVo.setCount(getUserCount());
			sendToTargets(args.getSession(), startRacingcarVo);

			return;
		}
		SupremeVo supremevo = null;
		com.badugi.game.logic.model.vo.supreme.PlayerInfoInSupremeRoom pISR = null;
		StartRacingcarVo startRacingcarVo = null;
		// WealthVo wealthVo = null;
		// List<PlayerInfoInSupremeRoom> pirList = null;
		// List<WealthVo> wealthlist = null;
		com.badugi.game.logic.model.vo.supreme.DealerQueueVo dv = null;
		ConcurrentLinkedQueue<DealerQueueVo> dealerqueue = null; // 上庄队列
		Iterator<DealerQueueVo> it = null;
		List<DealerQueueVo> dealerlist = null;

		LOGGER.info("car game login {}....", args.getSession());
		double aamount = 0;
		try {
			supremevo = ObjectBeanUtil.JACKSON.readValue(args.getData(), SupremeVo.class);

			// System.out.println("进入LaunchRacingcar玩家fbId=" + (supremevo !=
			// null ? supremevo.getFbId() : null));
/**
 * wtu.edit 2015-12-5 用户每次进入的时候取数据库，修改从进程缓存中读取数据
 */
			List<String> drawrecords =CarCache.getDrawRecords();// AppContext.getBean(DrawRecordDao.class).readUserDraw(); // 获奖记录
			// ConcurrentHashMap<Long,PlayerInfoInSupremeRoom>
			// playerInfoInsupremerooms = CarCache.PLAYER_INFO_IN_SUPREMEROOM;
			// //当前游戏内玩家

			if (CarCache.DEALERQUEUE.get(ConstantPool.DEALERQUEUE) == null) {
				CarCache.DEALERQUEUE.put(ConstantPool.DEALERQUEUE, new ConcurrentLinkedQueue<DealerQueueVo>());
			}
			dealerlist = new ArrayList<DealerQueueVo>(CarCache.DEALERQUEUE.get(ConstantPool.DEALERQUEUE));
			dealerqueue = dealerlist.size() > 10 ? new ConcurrentLinkedQueue<DealerQueueVo>(dealerlist.subList(0, 10)) : CarCache.DEALERQUEUE.get(ConstantPool.DEALERQUEUE);

			if (supremevo == null || (supremevo != null && supremevo.getCmd().equals(EventDefinition.EVENT_LAUNCH_RACING))) {
				/*
				 * if(CarCache.PLAYER_INFO_IN_SUPREMEROOM == null){
				 * CarCache.PLAYER_INFO_IN_SUPREMEROOM = new
				 * ConcurrentHashMap<Long,PlayerInfoInSupremeRoom>(); }
				 */
				ConcurrentLinkedQueue<DealerQueueVo> dealerVo = CarCache.DEALERQUEUE.get(ConstantPool.DEALERQUEUE); // 把庄家队列加入房间
				it = dealerVo.iterator();
				while (it.hasNext()) {
					dv = it.next();
					CarCache.PLAYER_INFO_IN_SUPREMEROOM.put(dv.getFbId(),
							new com.badugi.game.logic.model.vo.supreme.PlayerInfoInSupremeRoom(dv.getFbId(), dv.getFbName(), dv.isRobot(), dv.getImageUrl(), dv.getLobbyChips()));
				}

				if (supremevo != null) {
					// com.joker.game.logic.model.entity.UserFund userfund =
					// AppContext.getBean(UserFundDao.class).getUserFundById(supremevo.getFbId());
					// com.joker.game.logic.model.entity.UserBasic ub =
					// AppContext.getBean(UserBasicDao.class).findUserBasic(supremevo.getFbId());

					/*
					 * if(CarCache.PLAYER_INFO_IN_SUPREMEROOM.size() >= 1){
					 * for(PlayerInfoInSupremeRoom dvo
					 * :CarCache.PLAYER_INFO_IN_SUPREMEROOM.values()){
					 * if(dvo.getFbId().longValue() == supremevo.getFbId()){
					 * CarCache.PLAYER_INFO_IN_SUPREMEROOM.remove(dvo); } } }
					 */
					UserFund userFund = LobbyUserHelper.getUserFund(supremevo.getFbId());

					// UserFundDetails userFundDetails =
					// LobbyUserHelper.getUserInfo(supremevo.getFbId());

					// aamount =
					// (AppContext.getBean(RedisLogin.class).hincrBy(LocalCache.USER_FUND_CECHED_PRDFIX
					// + supremevo.getFbId(), "chips", 0L)).doubleValue();
					aamount = userFund.getChips();
					String uname = AppContext.getBean(RedisLogin.class).hget(LocalCache.USER_INFO_CECHED_PRDFIX + supremevo.getFbId(), "name");
					// pISR = new PlayerInfoInSupremeRoom(supremevo.getFbId(),
					// uname, false, ub != null ? ub.getFigureurl() : "",
					// aamount);// 构建userInRoom对象
					pISR = new PlayerInfoInSupremeRoom(supremevo.getFbId(), uname, false, userFund != null ? userFund.getImgurl() : "", aamount);// 构建userInRoom对象
					CarCache.PLAYER_INFO_IN_SUPREMEROOM.put(supremevo.getFbId(), pISR);// 将新用户加入房间内
				}
				if (CarCache.PLAYER_INFO_IN_SUPREMEROOM != null && CarCache.PLAYER_INFO_IN_SUPREMEROOM.size() >= ConstantPool.PLAYERCOUNTS.intValue()) { // 若玩家数大等于房间容纳人数,提示房间已满,用户不能进入房间
					startRacingcarVo = new StartRacingcarVo(EventDefinition.EVENT_LAUNCH_RACING_RETURN, Definition.JOIN_RACINGCAR_ROOM_FULL_CODE, Definition.JOINRACINGCAR);
					sendToTargets(args.getSession(), startRacingcarVo);
					// return startRacingcarVo;
					return;
				}
				loadWealthVos();// 设置财富榜数据

				DealerStatus currDealer = CarCache.CURRENTDEALER.peek();
				writeDateToChannel(args.getSession(), aamount, drawrecords, currDealer, dealerqueue);

				 addSession(args.getSession());
				// 添加到等待列表
//				addWaitSession(args.getSession());
				// return startRacingcarVo;
			}

		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	/**
	 * 添加到等待列表
	 * 
	 * @param session
	 */
//	public synchronized void addWaitSession(String session) {
//		if (null != session) {
//			waitList.add(session);
//		}
//	}
//
//	public synchronized Set<String> getWaitList() {
//		return waitList;
//	}

	/**
	 * 添加到正式的用户列表
	 * 
	 * @param session
	 */
	public synchronized void addSession(String session) {
		if (null != session) {
			if (StringUtil.isNumeric(session)) {
				sessionList.add(session);
			}
		}

	}

	/**
	 * 设置财富榜数据
	 * 
	 * @param pISR
	 */
	private void loadWealthVos() {
		com.badugi.game.logic.model.vo.supreme.WealthVo wv = null;
		PlayerInfoInSupremeRoom pISR = null;
		List<com.badugi.game.logic.model.vo.supreme.WealthVo> wealthlist = new ArrayList<com.badugi.game.logic.model.vo.supreme.WealthVo>();
		List<PlayerInfoInSupremeRoom> pirList = null;
		/*
		 * if(CarCache.WEALTHLIST.get(Definition.WEALTHKEY) == null){//获取土豪榜列表
		 * CarCache.WEALTHLIST.put(Definition.WEALTHKEY, wealthlist); }else{
		 * wealthlist = CarCache.WEALTHLIST.get(Definition.WEALTHKEY); }
		 */
		pirList = new ArrayList<PlayerInfoInSupremeRoom>(CarCache.PLAYER_INFO_IN_SUPREMEROOM.values());
		Collections.sort(pirList, new Comparator<PlayerInfoInSupremeRoom>() {// 按房间内玩家筹码量降序排列
					@Override
					public int compare(PlayerInfoInSupremeRoom o1, PlayerInfoInSupremeRoom o2) {
						return o2.getLobbyChips().compareTo(o1.getLobbyChips());
					}
				});
		if (pirList.size() <= 3) {// 若当前加入游戏的玩家数少于3个
			for (PlayerInfoInSupremeRoom pisr : pirList) {
				wv = new com.badugi.game.logic.model.vo.supreme.WealthVo(pisr.getFbId(), pisr.getFbName(), pisr.getImageUrl(), pisr.getLobbyChips(), System.currentTimeMillis(), pisr.isRobot());
				wealthlist.add(wv);
			}
		} else {
			for (int i = 0; i < 3; i++) {// 将游戏中筹码最多的前3个玩家加入土豪榜
				pISR = pirList.get(i);
				wv = new com.badugi.game.logic.model.vo.supreme.WealthVo(pISR.getFbId(), pISR.getFbName(), pISR.getImageUrl(), pISR.getLobbyChips(), System.currentTimeMillis(), pISR.isRobot());
				wealthlist.add(wv);
			}
		}
		List<com.badugi.game.logic.model.vo.supreme.WealthVo> nulls = new ArrayList<com.badugi.game.logic.model.vo.supreme.WealthVo>(); // 移除list中的空对象
		nulls.add(null);
		wealthlist.removeAll(nulls);
		CarCache.WEALTHLIST.put(Definition.WEALTHKEY, wealthlist);
	}

	/**
	 * 写数据到netty channel
	 * 
	 * @param startRacingcarVo
	 */
	public void sendToTargets(String channelId, Object data) {

		LogicChannelUtil.sendToTargets(data, Lists.newArrayList(channelId));
		// LogicChannelUtil.sendToAll(data);;
	}

	/**
	 * 写数据到netty channel
	 * 
	 * @param startRacingcarVo
	 */
	public void sendToAll(Object data) {

		if (!sessionList.isEmpty()) {
			LogicChannelUtil.sendToTargets(data, Lists.newArrayList(sessionList));
		} else {
		}
	}
	
	public void sendToServerAll(Object data) {

		
		LogicChannelUtil.sendToAll(data);
		
	}
	
	public synchronized int getUserCount()
	{
		if(sessionList!=null && sessionList.isEmpty())
			return sessionList.size();
		return 0;
	}

	/**
	 * 写数据到netty channel
	 * 
	 * @param startRacingcarVo
	 */
	private StartRacingcarVo writeDateToChannel(String session, double chips, List<String> drawrecords, com.badugi.game.logic.model.vo.supreme.DealerStatus curDealer,
			ConcurrentLinkedQueue<DealerQueueVo> dealerqueue) {
		// ChannelGroup channels = LobbyService.channels;
		StartRacingcarVo startRacingcarVo = null;
		// String dealers = null;
		// com.joker.game.logic.model.entity.UserFund uf = null;
		Integer status = null;
		// Long fbId = null;
		status = System.currentTimeMillis() >= CarCache.STARTRACINGCAR + CarCache.LASTINGTIME ? -1 : (int) (CarCache.STARTRACINGCAR + CarCache.LASTINGTIME - System.currentTimeMillis()) / 1000;
		// System.out.println((int) (CarCache.STARTRACINGCAR +
		// CarCache.LASTINGTIME - System.currentTimeMillis()) / 1000 +
		// "######status=" + status);
		status = -1;
		try {
			startRacingcarVo = new StartRacingcarVo(EventDefinition.EVENT_LAUNCH_RACING_RETURN, Definition.RACINGCAR_SUCCESS_CODE, Definition.JOINRACINGCAR, Long.valueOf(session),
					ConstantPool.MINCHIPS, chips, drawrecords, curDealer, dealerqueue, CarCache.WEALTHLIST.get(Definition.WEALTHKEY), status);

		} catch (Exception e) {
			startRacingcarVo = new StartRacingcarVo(EventDefinition.EVENT_LAUNCH_RACING_RETURN, Definition.RACINGCAR_SUCCESS_CODE, Definition.JOINRACINGCAR);
			LOGGER.error("", e);
		}
		startRacingcarVo.setCount(AppContext.getBean(GameCarService.class).getUserCount());
		LOGGER.info("send to client...");
		// sendToAll(startRacingcarVo);
		sendToTargets(session, startRacingcarVo);
		return startRacingcarVo;
	}

	/**
	 * 每门押注是否已满
	 * 
	 * @param map
	 * @return
	 */
	private Map<String, Boolean> betIsFull(Map<String, Long> map, Long chips) {
		Map<String, Boolean> betsIsFull = new HashMap<String, Boolean>();// 每门是否已经满,比如<minVW,true>,<bigVW,false>
		if (map.containsKey(PrizeItem.MINVW.getItem())) {
			betsIsFull.put(PrizeItem.MINVW.getItem(),
					CarCache.ROBOTCHIPS.get(PrizeItem.MINVW.getItem()) + CarCache.CHIPSSET.get(PrizeItem.MINVW.getItem()) + chips >= map.get(PrizeItem.MINVW.getItem()));
		}
		if (map.containsKey(PrizeItem.MINBMW.getItem())) {
			betsIsFull.put(PrizeItem.MINBMW.getItem(),
					CarCache.ROBOTCHIPS.get(PrizeItem.MINBMW.getItem()) + CarCache.CHIPSSET.get(PrizeItem.MINBMW.getItem()) + chips >= map.get(PrizeItem.MINBMW.getItem()));
		}
		if (map.containsKey(PrizeItem.MINBENZ.getItem())) {
			betsIsFull.put(PrizeItem.MINBENZ.getItem(),
					CarCache.ROBOTCHIPS.get(PrizeItem.MINBENZ.getItem()) + CarCache.CHIPSSET.get(PrizeItem.MINBENZ.getItem()) + chips >= map.get(PrizeItem.MINBENZ.getItem()));
		}
		if (map.containsKey(PrizeItem.MINPORSCHE.getItem())) {
			betsIsFull.put(PrizeItem.MINPORSCHE.getItem(),
					CarCache.ROBOTCHIPS.get(PrizeItem.MINPORSCHE.getItem()) + CarCache.CHIPSSET.get(PrizeItem.MINPORSCHE.getItem()) + chips >= map.get(PrizeItem.MINPORSCHE.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGVW.getItem())) {
			betsIsFull.put(PrizeItem.BIGVW.getItem(),
					CarCache.ROBOTCHIPS.get(PrizeItem.BIGVW.getItem()) + CarCache.CHIPSSET.get(PrizeItem.BIGVW.getItem()) + chips >= map.get(PrizeItem.BIGVW.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGBMW.getItem())) {
			betsIsFull.put(PrizeItem.BIGBMW.getItem(),
					CarCache.ROBOTCHIPS.get(PrizeItem.BIGBMW.getItem()) + CarCache.CHIPSSET.get(PrizeItem.BIGBMW.getItem()) + chips >= map.get(PrizeItem.BIGBMW.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGBENZ.getItem())) {
			betsIsFull.put(PrizeItem.BIGBENZ.getItem(),
					CarCache.ROBOTCHIPS.get(PrizeItem.BIGBENZ.getItem()) + CarCache.CHIPSSET.get(PrizeItem.BIGBENZ.getItem()) + chips >= map.get(PrizeItem.BIGBENZ.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGPORSCHE.getItem())) {
			betsIsFull.put(PrizeItem.BIGPORSCHE.getItem(),
					CarCache.ROBOTCHIPS.get(PrizeItem.BIGPORSCHE.getItem()) + CarCache.CHIPSSET.get(PrizeItem.BIGPORSCHE.getItem()) + chips >= map.get(PrizeItem.BIGPORSCHE.getItem()));
		}
		return betsIsFull;
	}

	/**
	 * 每门押注是否已超押注上限
	 * 
	 * @param map
	 * @return
	 */
	public Map<String, Boolean> betIsExceeding(Map<String, Long> map, Long chips) {
		Map<String, Boolean> betIsExceeding = new HashMap<String, Boolean>();// 每门是否达到押注上限,比如<minVW,true>,<bigVW,false>
		if (map.containsKey(PrizeItem.MINVW.getItem())) {
			betIsExceeding.put(PrizeItem.MINVW.getItem(),
					CarCache.ROBOTCHIPS.get(PrizeItem.MINVW.getItem()) + CarCache.CHIPSSET.get(PrizeItem.MINVW.getItem()) + chips > map.get(PrizeItem.MINVW.getItem()));
		}
		if (map.containsKey(PrizeItem.MINBMW.getItem())) {
			betIsExceeding.put(PrizeItem.MINBMW.getItem(),
					CarCache.ROBOTCHIPS.get(PrizeItem.MINBMW.getItem()) + CarCache.CHIPSSET.get(PrizeItem.MINBMW.getItem()) + chips > map.get(PrizeItem.MINBMW.getItem()));
		}
		if (map.containsKey(PrizeItem.MINBENZ.getItem())) {
			betIsExceeding.put(PrizeItem.MINBENZ.getItem(),
					CarCache.ROBOTCHIPS.get(PrizeItem.MINBENZ.getItem()) + CarCache.CHIPSSET.get(PrizeItem.MINBENZ.getItem()) + chips > map.get(PrizeItem.MINBENZ.getItem()));
		}
		if (map.containsKey(PrizeItem.MINPORSCHE.getItem())) {
			betIsExceeding.put(PrizeItem.MINPORSCHE.getItem(),
					CarCache.ROBOTCHIPS.get(PrizeItem.MINPORSCHE.getItem()) + CarCache.CHIPSSET.get(PrizeItem.MINPORSCHE.getItem()) + chips > map.get(PrizeItem.MINPORSCHE.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGVW.getItem())) {
			betIsExceeding.put(PrizeItem.BIGVW.getItem(),
					CarCache.ROBOTCHIPS.get(PrizeItem.BIGVW.getItem()) + CarCache.CHIPSSET.get(PrizeItem.BIGVW.getItem()) + chips > map.get(PrizeItem.BIGVW.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGBMW.getItem())) {
			betIsExceeding.put(PrizeItem.BIGBMW.getItem(),
					CarCache.ROBOTCHIPS.get(PrizeItem.BIGBMW.getItem()) + CarCache.CHIPSSET.get(PrizeItem.BIGBMW.getItem()) + chips > map.get(PrizeItem.BIGBMW.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGBENZ.getItem())) {
			betIsExceeding.put(PrizeItem.BIGBENZ.getItem(),
					CarCache.ROBOTCHIPS.get(PrizeItem.BIGBENZ.getItem()) + CarCache.CHIPSSET.get(PrizeItem.BIGBENZ.getItem()) + chips > map.get(PrizeItem.BIGBENZ.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGPORSCHE.getItem())) {
			betIsExceeding.put(PrizeItem.BIGPORSCHE.getItem(),
					CarCache.ROBOTCHIPS.get(PrizeItem.BIGPORSCHE.getItem()) + CarCache.CHIPSSET.get(PrizeItem.BIGPORSCHE.getItem()) + chips > map.get(PrizeItem.BIGPORSCHE.getItem()));
		}
		return betIsExceeding;
	}

	/**
	 * 获取押注上限
	 * 
	 * @param allChips
	 */
	public Map<String, Long> betLimit(Long allChips) {
		DealerStatus ds = CarCache.CURRENTDEALER.peek();

		Map<String, Long> betLimits = new HashMap<String, Long>();
		// 小大众押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.MINVW.getItem())) {
			long minvmBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + allChips) / PRIZESET.get(PrizeItem.MINVW.getItem()).getOdds() == 0l ? 1000L
					: (((ds != null ? ds.getUpDealerChips() : 0) + allChips) / PRIZESET.get(PrizeItem.MINVW.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.MINVW.getItem(), minvmBetLimit);
		} else {
			betLimits.put(PrizeItem.MINVW.getItem(), CarCache.BETFULLITEMS.get(PrizeItem.MINVW.getItem()));
		}
		// 小宝马押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.MINBMW.getItem())) {
			long minbmwBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + allChips) / PRIZESET.get(PrizeItem.MINBMW.getItem()).getOdds() == 0l ? 1000L
					: (((ds != null ? ds.getUpDealerChips() : 0) + allChips) / PRIZESET.get(PrizeItem.MINBMW.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.MINBMW.getItem(), minbmwBetLimit);
		} else {
			betLimits.put(PrizeItem.MINBMW.getItem(), CarCache.BETFULLITEMS.get(PrizeItem.MINBMW.getItem()));
		}
		// 小奔驰押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.MINBENZ.getItem())) {
			long minbenzBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + allChips) / PRIZESET.get(PrizeItem.MINBENZ.getItem()).getOdds() == 0l ? 1000L : (((ds != null ? ds.getUpDealerChips()
					: 0) + allChips) / PRIZESET.get(PrizeItem.MINBENZ.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.MINBENZ.getItem(), minbenzBetLimit);
		} else {
			betLimits.put(PrizeItem.MINBENZ.getItem(), CarCache.BETFULLITEMS.get(PrizeItem.MINBENZ.getItem()));
		}
		// 小宝时捷押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.MINPORSCHE.getItem())) {
			long minporscheBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + allChips) / PRIZESET.get(PrizeItem.MINPORSCHE.getItem()).getOdds() == 0l ? 1000L : (((ds != null ? ds
					.getUpDealerChips() : 0) + allChips) / PRIZESET.get(PrizeItem.MINPORSCHE.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.MINPORSCHE.getItem(), minporscheBetLimit);
		} else {
			betLimits.put(PrizeItem.MINPORSCHE.getItem(), CarCache.BETFULLITEMS.get(PrizeItem.MINPORSCHE.getItem()));
		}
		// 大大众押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.BIGVW.getItem())) {
			long bigvmBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + allChips) / PRIZESET.get(PrizeItem.BIGVW.getItem()).getOdds() == 0l ? 1000L
					: (((ds != null ? ds.getUpDealerChips() : 0) + allChips) / PRIZESET.get(PrizeItem.BIGVW.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.BIGVW.getItem(), bigvmBetLimit);
		} else {
			betLimits.put(PrizeItem.BIGVW.getItem(), CarCache.BETFULLITEMS.get(PrizeItem.BIGVW.getItem()));
		}
		// 大宝马押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.BIGBMW.getItem())) {
			long bigbmwBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + allChips) / PRIZESET.get(PrizeItem.BIGBMW.getItem()).getOdds() == 0l ? 1000L
					: (((ds != null ? ds.getUpDealerChips() : 0) + allChips) / PRIZESET.get(PrizeItem.BIGBMW.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.BIGBMW.getItem(), bigbmwBetLimit);
		} else {
			betLimits.put(PrizeItem.BIGBMW.getItem(), CarCache.BETFULLITEMS.get(PrizeItem.BIGBMW.getItem()));
		}
		// 大奔驰押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.BIGBENZ.getItem())) {
			long bigbenzBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + allChips) / PRIZESET.get(PrizeItem.BIGBENZ.getItem()).getOdds() == 0l ? 1000L : (((ds != null ? ds.getUpDealerChips()
					: 0) + allChips) / PRIZESET.get(PrizeItem.BIGBENZ.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.BIGBENZ.getItem(), bigbenzBetLimit);
		} else {
			betLimits.put(PrizeItem.BIGBENZ.getItem(), CarCache.BETFULLITEMS.get(PrizeItem.BIGBENZ.getItem()));
		}
		// 大宝时捷押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.BIGPORSCHE.getItem())) {
			long bigporscheBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + allChips) / PRIZESET.get(PrizeItem.BIGPORSCHE.getItem()).getOdds() == 0l ? 1000L : (((ds != null ? ds
					.getUpDealerChips() : 0) + allChips) / PRIZESET.get(PrizeItem.BIGPORSCHE.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.BIGPORSCHE.getItem(), bigporscheBetLimit);
		} else {
			betLimits.put(PrizeItem.BIGPORSCHE.getItem(), CarCache.BETFULLITEMS.get(PrizeItem.BIGPORSCHE.getItem()));
		}
		// System.out.println("CollectionBetThread当前押注筹码总额:" + allChips +
		// "庄家押注额为:" + (ds != null ? ds.getUpDealerChips() : 0) + "当前各门押注上限为:" +
		// betLimits.toString());
		return betLimits;
	}

	/**
	 * 返回给用户一个可加入的房间,若当前无可加入房间,则创建新房间
	 * 
	 * @return
	 */
	private SupremeRooms provideAvailableSupremeRoom() {
		SupremeRooms sr = null;
		try {
			ConcurrentHashMap<String, SupremeRooms> supremeroomsMap = CarCache.SUPREMEROOMS; // 当前已开房间数
			/*
			 * List<SupremeRooms> supremerooms =new
			 * ArrayList<SupremeRooms>(supremeroomsMap.values());
			 * Iterator<SupremeRooms> it = null; for(it =
			 * supremerooms.iterator();it.hasNext();){ //若房间用户已满,则在可加入的房间中移除
			 * SupremeRooms supremeroom = it.next(); if(supremeroom.getCc() ==
			 * supremeroom.getMc()){
			 * supremeroomsMap.remove(supremeroom.getRid()); } }
			 */
			if (supremeroomsMap != null && supremeroomsMap.size() >= 1) { // 若用户有可加入的房间
				sr = supremeroomsMap.elements().nextElement();
				/*
				 * if(supremeroomsMap.size() == 1){ }else{ supremerooms = new
				 * ArrayList<SupremeRooms>(supremeroomsMap.values());
				 * Collections.sort(supremerooms, new
				 * Comparator<SupremeRooms>(){
				 * 
				 * @Override public int compare(SupremeRooms o1, SupremeRooms
				 * o2) { //按房间人数降序 return o2.getCc() - o1.getCc(); } }); sr =
				 * supremerooms.get(0); }
				 */
			}/*
			 * else{//用户没有可加入的房间,创建一个 Long rid = new
			 * Random().nextInt()&0xFFFFFFFFFFFFFFl; //生成32的随机整数作为房间号 sr = new
			 * SupremeRooms(rid.toString(),"奔驰宝马小游戏",0,playerCounts); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sr;
	}

	/**
	 * 计算每个门类中每位玩家的押注额
	 * 
	 * @param item
	 * @param fbId
	 * @param chips
	 */
	private void betChipsPerPlayer(String item, Long fbId, Long chips) {
		Map<Long, Long> kindMaps = CarCache.BETKINDPERPLAYER.get(item);
		Map<Long, Long> sumMaps=CarCache.BETKINDPERPLAYER.get(PrizeItem.SUMCHIPS.getItem());
		
		if (Arrays.asList(Definition.CHIPSET).contains(chips.intValue())) {
			if (kindMaps.containsKey(fbId)) {
				kindMaps.put(fbId, kindMaps.get(fbId) + chips);
			} else {
				kindMaps.put(fbId, chips);
			}
			
			if (sumMaps.containsKey(fbId)) {
				sumMaps.put(fbId, sumMaps.get(fbId) + chips);
			} else {
				sumMaps.put(fbId, chips);
			}
		}
		
		CarCache.BETKINDPERPLAYER.put(item, kindMaps);
	}

	/**
	 * 计算单个玩家单门押注的筹码量
	 * 
	 * @param map
	 * @return
	 */
	private Long chipCashes(Map<String, String> map) {
		Long cashes = 0L;
		if (map != null) {
			Set<Entry<String, String>> set = map.entrySet();
			Iterator<Entry<String, String>> it = set.iterator();
			Entry<String, String> entry = null;
			while (it.hasNext()) {
				entry = it.next();
				cashes += Integer.valueOf(entry.getKey()) * Integer.valueOf(entry.getValue());
			}
		}
		return cashes;
	}

	/**
	 * 累加每位玩家每门的押注筹码量
	 * 
	 * @param map
	 * @param chips
	 * @param fbId
	 */
	private void chipEntry(Map<Long, Map<String, String>> map, Integer chips, Long fbId) {
		if (map.containsKey(fbId)) {
			map.put(fbId, chipKeep(map.get(fbId), chips));
		} else {
			map.put(fbId, chipKeep(new HashMap<String, String>(), chips));
		}
	}

	/**
	 * 计算单门押注的筹码量Map<筹码构成,构成的数量>
	 * 
	 * @param map
	 * @param chips
	 * @return
	 */
	private Map<String, String> chipKeep(Map<String, String> map, Integer chips) {
		if (null == map) {
			return map;
		}
		if (Arrays.asList(Definition.CHIPSET).contains(chips.intValue())) {
			if (map.containsKey(chips.toString())) {
				map.put(chips.toString(), (Integer.valueOf(map.get(chips.toString())) + 1) + "");
			} else {
				map.put(chips.toString(), "1");
			}
		}
		return map;
	}

	/**
	 * 返回用户下注的筹码段
	 * 
	 * @param chips
	 * @return
	 */
	private List<Integer> chooseChipLayers(Integer chips) {
		if (chips > 0 && chips <= 1e3) {
			return Definition.CHIPSLEVEL1;
		}
		if (chips > 1e3 && chips <= 1e4) {
			return Definition.CHIPSLEVEL2;
		}
		if (chips > 1e4 && chips <= 1e5) {
			return Definition.CHIPSLEVEL3;
		}
		if (chips > 1e5 && chips <= 1e6) {
			return Definition.CHIPSLEVEL4;
		}
		if (chips > 1e6) {
			return Definition.CHIPSLEVEL5;
		}
		return new ArrayList<Integer>();
	}

	/**
	 * 用户签名
	 * 
	 * @param uid
	 * @param ip
	 * @param pt
	 * @param rid
	 * @return
	 */
	public String getSign(String uid, String ip, int pt, String rid) {
		StringBuffer sb = new StringBuffer();
		sb.append(uid);
		sb.append(ip);
		sb.append(pt);
		sb.append(rid);
		sb.append(ConstantPool.FLASHKEY);
		return Md5Utils.md5(sb.toString());
	}

	public final static Map<String, PrizeEntry> PRIZESET = new HashMap<String, PrizeEntry>() {
		{// key=奖项,value=赔率
			put(PrizeItem.MINVW.getItem(), new PrizeEntry(PrizeItem.MINVW.getItem(), 5)); // 小大众赔率
			put(PrizeItem.MINBMW.getItem(), new PrizeEntry(PrizeItem.MINBMW.getItem(), 5)); // 小宝马赔率
			put(PrizeItem.MINBENZ.getItem(), new PrizeEntry(PrizeItem.MINBENZ.getItem(), 5)); // 小奔驰赔率
			put(PrizeItem.MINPORSCHE.getItem(), new PrizeEntry(PrizeItem.MINPORSCHE.getItem(), 5));// 小保时捷赔率
			put(PrizeItem.BIGVW.getItem(), new PrizeEntry(PrizeItem.BIGVW.getItem(), 10)); // 大大众赔率
			put(PrizeItem.BIGBMW.getItem(), new PrizeEntry(PrizeItem.BIGBMW.getItem(), 20));// 大宝马赔率
			put(PrizeItem.BIGBENZ.getItem(), new PrizeEntry(PrizeItem.BIGBENZ.getItem(), 30));// 大奔驰赔率
			put(PrizeItem.BIGPORSCHE.getItem(), new PrizeEntry(PrizeItem.BIGPORSCHE.getItem(), 40));// 大保时捷赔率
		}
	};
	public final static String[] PRIZEARRAY = new String[] { PrizeItem.MINVW.getItem(), PrizeItem.MINBMW.getItem(), PrizeItem.MINBENZ.getItem(), PrizeItem.MINPORSCHE.getItem(),
			PrizeItem.BIGVW.getItem(), PrizeItem.BIGBMW.getItem(), PrizeItem.BIGBENZ.getItem(), PrizeItem.BIGPORSCHE.getItem() };

	public Set<String> getSessionList() {
		return sessionList;
	}

	public boolean removeSession(String session) {
		if (null != session) {
			return this.sessionList.remove(session);
		}
		return false;
	}

	@RPCReponse("call_logout")
	public void call_logout(LogicRequest args) {
		this.removeUser(args.getSession());
		LOGGER.debug("session logout :{}", args.getSession());
	}

	public boolean getIsOpen() {
		return isOpen.get();
	}

	/**
	 * 设置开奖结果
	 */
	@RPCReponse("e_editLotteryResults")
	public void editLotteryResults(LogicRequest request) {
		LogicMap logicMap = request.getParames();
		try {
			String item = logicMap.get("item").toString();
			if (item != null && !("").equals(item)) {
				//设置当局开奖结果
				GameCarHelper.setCurRoundItem(item);
				//setLotteryResults(item);
			}
			// 添加随机开奖
			if (logicMap.containsKey("random")) {
				String random = logicMap.get("random").toString().trim();
				if ("true".equals(random) || "1".equals(random) || "open".endsWith(random)) {
					setRandomResult(true);
				} else {
					setRandomResult(false);
				}
			}
			LOGGER.info("setLotteryResults item: {}", item);
		} catch (Exception e) {
			LOGGER.warn("", e);
		}
	}

	/**
	 * 设置小游戏维护
	 */
	@RPCReponse("e_editCarMaintenance")
	public void e_editCarMaintenance(LogicRequest logicRequest) {
		LogicMap logicMap = logicRequest.getParames();
		try {
			begintime = Long.valueOf(logicMap.get("begintime").toString());
			endtime = Long.valueOf(logicMap.get("endtime").toString());

			if (begintime != null && endtime != null) {
				Map<String, Long> map = Maps.newHashMap();
				map.put("begintime", begintime);
				map.put("endtime", endtime);
				LogicChannelUtil.sendToAll(map);

				String notify = String.format(NOTIFY_CHAR, DateUtils.dateToString(new Date(begintime),DateUtils.PATTERN_YMDHMS),DateUtils.dateToString(new Date(endtime),DateUtils.PATTERN_YMDHMS));
				MsgSendVo msgvo = new MsgSendVo(Definition.NOTICES, notify, DateUtils.dateToString(new Date(System.currentTimeMillis()), DateUtils.PATTERN_YMDHMS));
				// 发送
				LogicChannelUtil.sendToAll(msgvo);
				
				
			}
		} catch (Exception e) {
			LOGGER.warn("", e);
		}
	}

	public synchronized String getLotteryResults() {
		return lotteryResults;
	}

	public synchronized void setLotteryResults(String lotteryResults) {
		this.lotteryResults = lotteryResults;
	}

	public Long getBegintime() {
		return begintime;
	}

	public Long getEndtime() {
		return endtime;
	}

	public boolean getRandomResult() {
		return randomResult.get();
	}

	public void setRandomResult(boolean randomResult) {
		this.randomResult.set(randomResult);
	}

}
