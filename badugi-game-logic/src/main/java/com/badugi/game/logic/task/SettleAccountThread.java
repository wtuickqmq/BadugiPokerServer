package com.badugi.game.logic.task;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.dao.DrawItemDao;
import com.badugi.game.logic.dao.DrawRecordDao;
import com.badugi.game.logic.dao.RacingCarDao;
import com.badugi.game.logic.dao.RacingCarInitDao;
import com.badugi.game.logic.dao.RacingCarWinLogDao;
import com.badugi.game.logic.helper.LobbyUserHelper;
import com.badugi.game.logic.model.cache.CarCache;
import com.badugi.game.logic.model.domain.vo.flash.user.UserFundDetails;
import com.badugi.game.logic.model.entity.DrawRecord;
import com.badugi.game.logic.model.entity.RacingCar;
import com.badugi.game.logic.model.entity.RacingCarWinLog;
import com.badugi.game.logic.model.entity.RacingcarInit;
import com.badugi.game.logic.model.entity.UserFund;
import com.badugi.game.logic.model.lobby.helper.GameCarActiveHelper;
import com.badugi.game.logic.model.lobby.helper.GameCarHelper;
import com.badugi.game.logic.model.vo.supreme.ConstantPool;
import com.badugi.game.logic.model.vo.supreme.DealerResultVo;
import com.badugi.game.logic.model.vo.supreme.DealerStatus;
import com.badugi.game.logic.model.vo.supreme.DealerWinVo;
import com.badugi.game.logic.model.vo.supreme.ExceptionVo;
import com.badugi.game.logic.model.vo.supreme.PlayerDealerCnt;
import com.badugi.game.logic.model.vo.supreme.PlayerInfoInSupremeRoom;
import com.badugi.game.logic.model.vo.supreme.PlayerWinVo;
import com.badugi.game.logic.model.vo.supreme.PrizeEntry;
import com.badugi.game.logic.model.vo.supreme.PrizeItem;
import com.badugi.game.logic.model.vo.supreme.SettleAccountVo;
import com.badugi.game.logic.model.vo.supreme.WealthVo;
import com.badugi.game.logic.service.GameCarService;
import com.badugi.game.logic.service.impl.GameCarServiceImpl;
import com.badugi.game.logic.util.AppContext;
import com.badugi.game.logic.util.DateUtils;
import com.badugi.game.logic.util.IdGenerator;
import com.badugi.game.logic.util.LogicExecutorUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.joker.common.util.MathUtil;
import com.joker.game.common.constant.Definition;
import com.joker.game.common.constant.EventDefinition;

/**
 * 游戏跑灯结束,得出中奖奖项,计算并返回庄家闲家输赢筹码量
 */
public class SettleAccountThread {

	private static final Logger LOGGER = LoggerFactory.getLogger(SettleAccountThread.class);

	public SettleAccountThread() {
	};

	public void start() {
		this.run();
	}

	public void run() {
		long entryTime = System.currentTimeMillis();
		// DealerQueueVo vo = null;
		// SupremeVo sv = null;
		SettleAccountVo sav = null;
		// List<WealthVo> wealthlist = null;
		// List<PlayerInfoInSupremeRoom> pirList = null;
		// WealthVo wv = null;
		PlayerWinVo playerWin = null;
		PrizeEntry entry = null;
		// Long lossRateChips = 0L;
		Integer odds = null;
		String winItem = null;
		// String item = "";
		Long dealerWinChips = 0L;
		UserFund playerfund = null;
		// UserBasic playerBasic = null;
		UserFundDetails userFundDetails = null;
		// PlayerDealerCnt playerdealercnt = null;
		// List<PlayerDealerCnt> pdcntList = null;
		DrawRecord dr = null;
		Long playerwinChips = null;
		Long dealerFbId = null;
		Long fbId = null;
		UserFund dealerfund = null;
		DealerResultVo dw = null;
		List<String> drawRecords = null;
		Map<Long, Map<String, String>> prizeSet = null;
		Set<Entry<Long, Map<String, String>>> winset = null;
		Iterator<Entry<Long, Map<String, String>>> it = null;
		Map<Long, Long> map = null;
		Map.Entry<Long, Long> pos = null;
		List<Map.Entry<Long, Long>> winlist = null;
		List<PlayerWinVo> playerWins = null;
		Integer winnerlimit = null;
		// Long returnSystemChips = 0L;
		Long perbetChips = 0L;// 每位玩家押注额
		Long countBetChips = 0L; // 计算玩家总押注
		Entry<Long, Map<String, String>> itentry = null;
		DealerStatus currentdealer = null;
		Long rewarePool = null;
		// Long initPool = 0L;
		// Long sumBetChips = null;
		// Map<String, Long> chipsset = null;
		Map<String, String> perplayerChips = null;
		ConcurrentHashMap<Long, Long> settleAccount = null;
		ConcurrentHashMap<Long, Map<String, String>> playerChips = null;
		List<Map.Entry<Long, Long>> finalWinChipPlayers = null;
		// RacingcarInit racingcarinit = null;
		// Long leftChips = 0L;
		Iterator<String> iterator = null;
		Enumeration<Long> chipsFbIds = null;
		try {
			// sv = (SupremeVo)JsonUtils.json2Object(msg, SupremeVo.class);
			// if(System.currentTimeMillis() >= CarCache.BETDEADTIME &&
			// sv.getCmd().equals(EventDefinition.EVENT_STOP_BET)){
			currentdealer = CarCache.CURRENTDEALER.peek();// 上庄庄家
			if (currentdealer != null) {
				dealerFbId = currentdealer.getFbId();// 庄家FBId
				dealerfund = LobbyUserHelper.getUserFund(dealerFbId);// 庄家信息
				// racingcarinit = RacingcarInitDao.initRobotData(); //
				// CarCache.SYSTEMREWARDPOOL.get("systemRewardPool");//系统奖池筹码量
				// rewarePool = racingcarinit.getSystemPoolInitChips();
				/*
				 * initPool = racingcarinit.getSystemPoolInitChips();
				 * while(initPool < ConstantPool.MININITPOOL){
				 * RacingcarInitDao.resetRacingSystemPool(); racingcarinit =
				 * RacingcarInitDao.initRobotData(); }
				 */
				// rewarePool = RacingcarInitDao.initRobotData() ;
				// Long dealerchips = currentdealer.elements().nextElement();
				// //庄家总筹码量
				// ConcurrentLinkedQueue<DealerQueueVo> dealerqueue =
				// CarCache.DEALERQUEUE.get(CommonConstantPool.DEALERQUEUE);
				// //上庄队列
				dealerWinChips = CarCache.EACHWINSUMCHIPS.get(PrizeItem.SUMCHIPS.getItem()) + CarCache.ROBOTSBETCHIPS; // 初始化庄家盈利为闲家总押注

				LOGGER.debug("=========庄家总获得:{}", dealerWinChips);
				// chipsset = CarCache.CHIPSSET;//8个门类中的筹码<bettype,chips>
				// Long allChips = dealerchips+sumBetChips;//
				// 当前局庄家上庄携带金额+当前总押注量（实时变量）
				// long date = Calendar.getInstance().getTimeInMillis();
				// String datestr =
				// DateUtils.getSimpleDateFormat2ymdhms().format(Calendar.getInstance().getTime());
				// String datestr =
				// DateUtils.getSimpleDateFormat2ymd().format(Calendar.getInstance().getTime());
				if (dealerfund.getIsRobot() == 1) {// 机器人坐庄
					
					/**
					 * wtu.edit 2015-11-24 注解原开奖方案
					 * 
					 * 
					 * entry = systemPrizeRules() == null ? systemChipsNullPrize() : systemPrizeRules(); // 得到机器人坐庄的开奖奖项
					 */
					if(GameCarHelper.isPlayerBet())
					{//系统做庄有玩家参与
						entry=GameCarHelper.robotOpenLottery();
					}
					else
					{//没有玩家参与,随机基本赔率开奖
						entry=GameCarHelper.randOpenLottery();
					}
				}
				else
				{//玩家坐庄随机开奖
					entry=GameCarHelper.randOpenLottery();
				}
				
				winItem = entry.getItem(); // 获胜门类
				odds = entry.getOdds(); // 获胜那门赔率
				
				/**
				 * wtu.edit 2015-11-24 注解掉玩家坐庄开奖
				 * 采用新开奖方案
				 * 
				boolean hasRobots = false;
				if (dealerfund.getIsRobot() == 0) {// 玩家坐庄
					// System.out.println("############进入玩家坐庄结算");
					Collection<PlayerInfoInSupremeRoom> collection = CarCache.PLAYER_INFO_IN_SUPREMEROOM.values();
					Iterator<PlayerInfoInSupremeRoom> pits = collection.iterator();

					PlayerInfoInSupremeRoom pis = null;
					while (pits.hasNext()) {// 检测玩家中是否有机器人
						pis = pits.next();
						if (pis.isRobot()) {
							hasRobots = true;
							break;
						}
					}
					if (hasRobots) {// 玩家坐庄时若有机器人玩家
						entry = robotLossRation();
						winItem = entry.getItem(); // 玩家获胜那门奖项
						odds = entry.getOdds(); // 玩家获胜赔率
						
					} else { // 若为纯真人玩家
						entry = prizeRules(); // 真人玩家自然获奖开奖奖项
						
						winItem = entry.getItem(); // 玩家获胜那门奖项
						odds = entry.getOdds(); // 玩家获胜赔率
						
					}
				}
				 */
				
				// winItem =
				// GameCarServiceImpl.PRIZESET.get("minBMW").getItem();
				// odds =
				// GameCarServiceImpl.PRIZESET.get("minBMW").getOdds();

				// 后台设置开奖结果
				String lotteryItem = CarCache.OpenItem; //AppContext.getBean(GameCarService.class).getLotteryResults();
				if (lotteryItem != null && !("").equals(lotteryItem)) {
					winItem = lotteryItem; // 开奖奖项
					// 容错
					if (GameCarServiceImpl.PRIZESET.containsKey(winItem)) {
						entry = GameCarServiceImpl.PRIZESET.get(winItem);
						odds = GameCarServiceImpl.PRIZESET.get(winItem).getOdds(); // 赔率
					} else {
						entry = GameCarServiceImpl.PRIZESET.get("minBMW");
						winItem = entry.getItem();
						odds = entry.getOdds();
					}
				} else {
					// 是否有随机开奖
					boolean randomResult = AppContext.getBean(GameCarService.class).getRandomResult();
					if (randomResult) {
						List<String> keys = Lists.newArrayList(GameCarServiceImpl.PRIZESET.keySet());
						Collections.shuffle(keys);
						if (!keys.isEmpty()) {
							// 随机开奖的结果
							winItem = keys.get(0);
							entry = GameCarServiceImpl.PRIZESET.get(winItem);
							odds = GameCarServiceImpl.PRIZESET.get(winItem).getOdds(); // 赔率
						}

					}

				}
				
				/**
				 * 测试
				 
				winItem = PrizeItem.BIGBENZ.getItem();
				entry = GameCarServiceImpl.PRIZESET.get(winItem);
				odds = GameCarServiceImpl.PRIZESET.get(winItem).getOdds(); // 赔率
				*/

				if (winItem != null && Arrays.asList(GameCarServiceImpl.PRIZEARRAY).contains(winItem)) {
					dr = new DrawRecord(IdGenerator.getNextId(), AppContext.getBean(DrawItemDao.class).findItemId(winItem), CarCache.RACINGCARID);
					AppContext.getBean(DrawRecordDao.class).addUserDraw(dr); // 记录中奖信息到数据库
					prizeSet = CarCache.PRIZESET.get(winItem); // 获取中奖那一门的玩家下注明细<fbId,<chiptype,chiptypecount>>
					winset = prizeSet.entrySet();
					map = new HashMap<Long, Long>(); // 每位押注者的<fbId,betChips>
					it = winset.iterator();
					while (it.hasNext()) { // 每位玩家的押注筹码量
						itentry = it.next();
						perbetChips = chipCashes(itentry.getValue());
						map.put(itentry.getKey(), perbetChips);
						countBetChips += perbetChips;
					}
					winlist = new ArrayList<Map.Entry<Long, Long>>(map.entrySet());// 每位玩家押注筹码值<fbId,winbetChips>

					LOGGER.debug("=========获奖列表玩家:{}",winlist);
					Collections.sort(winlist, new Comparator<Map.Entry<Long, Long>>() { // 按押注筹码降序
								@Override
								public int compare(Entry<Long, Long> o1, Entry<Long, Long> o2) {
									return o2.getValue().compareTo(o1.getValue());
								}
							});
	
					playerWins = new ArrayList<PlayerWinVo>(); // 获胜玩家集合,用于获取赢取筹码最多的前五位玩家信息
				
					for (Map.Entry<Long, Long> winentry : winlist) {// <fbId,Chips>

						long out = odds * winentry.getValue();

						LOGGER.debug("=========庄家赔付玩家:{} ,金额:{}", winentry.getKey(), out);

						dealerWinChips = dealerWinChips - out;// 庄家总赔付筹码-每位获胜赢玩家赔付筹码量
						// System.out.println("减去押中玩家fbId=" + winentry.getKey()
						// + "的赢取筹码dealerWinChips=" + dealerWinChips);
						playerfund = LobbyUserHelper.getUserFund(winentry.getKey());// 获胜玩家信息
						// playerBasic =
						// AppContext.getBean(UserBasicDao.class).findUserBasic(winentry.getKey());

						userFundDetails = LobbyUserHelper.getUserInfo(winentry.getKey());

						playerwinChips = odds * winentry.getValue();//
						CarCache.WINPLAYERSINFO.put(winentry.getKey(), playerwinChips); // 赢家单门赢取的筹码额
						// LobbyUserHelper.updateUserFund(winentry.getKey(),
						// playerwinChips.doubleValue()); //玩家获胜,按赔率返回给玩家下注筹码*赔率
					}
					
					LOGGER.debug("=========庄家赔付玩家后应得金额:{}", dealerWinChips);
					// Set<Long> betrobotsIds =
					// CarCache.BETCHIPSROBOTS.keySet();//押注的机器人fbIds
					Long betrobotchips = CarCache.ROBOTCHIPS.get(winItem);// 机器人押中门类的总押注
					// System.out.println("机器人押中门类的总押注##" + betrobotchips);
					// System.out.println("获胜的每个玩家信息######CarCache.WINPLAYERSINFO="
					// + CarCache.WINPLAYERSINFO.toString());
					//
					LOGGER.debug("=========机器人总押注金额:{}", CarCache.ROBOTCHIPS);
					long robotOut = betrobotchips * odds;
					dealerWinChips = dealerWinChips - robotOut;
					LOGGER.debug("=========机器人押注金额:{}, 赔付比例:{}", betrobotchips, odds);
					LOGGER.debug("=========庄家赔付机器人金额:{}, 赔付后:{}", robotOut, dealerWinChips);
					// System.out.println("除去机器人押中门类赔付后抽水前庄家赢取筹码为:" +
					// dealerWinChips);

					// 减去机器人押注金额后真实的金额
					Long realWin = dealerWinChips;// - CarCache.ROBOTSBETCHIPS;

					Long dealerCommission = 0L;
					if (realWin > ConstantPool.DRAWWATER) // 需要扣税
					{
						// realWin = realWin * (1 -
						// ConstantPool.DEALERDRAWWATERRATE);
						// 需要扣除的金额
						double need = realWin * ConstantPool.DEALERDRAWWATERRATE;
						dealerWinChips -= (long) Math.floor(need);
						dealerCommission = (long) Math.floor(need);
						LOGGER.debug("=========抽水后总金额:{}, 抽水:{}", dealerWinChips,need);
					}
					
					// dealerWinChips = dealerWinChips - CarCache.ROBOTSBETCHIPS
					// > ConstantPool.DRAWWATER ? (long)
					// (Math.floor((dealerWinChips - CarCache.ROBOTSBETCHIPS)
					// * (1 - ConstantPool.DEALERDRAWWATERRATE) +
					// CarCache.ROBOTSBETCHIPS)) : dealerWinChips;// 庄家赢取筹码抽水

					// System.out.println("抽水前庄家赢取筹码为:" + dealerWinChips);
					
					
					
					if (dealerfund.getIsRobot() == 1) {
						/**
						 * wtu.edit 2015-11-24 把系统庄赢得的90%，入到系统奖池中
						 * 10%系统吸收掉，
						 * 2015-11-24 如果赢得为负则直接传给池扣除
						 * 2015-12-2  注解存入方式，改为新的奖池变动过程
						 */
						/*Long updateChips = dealerWinChips;
						if(dealerWinChips>0)
						{//为正时存入90%，如果为负则不变
							updateChips=Double.valueOf(dealerWinChips*0.9).longValue();// -
						}

						Long playerBetNum = CarCache.EACHWINSUMCHIPS.get(PrizeItem.SUMCHIPS.getItem());

						if (playerBetNum > 0) {
							RacingcarInit sic = new RacingcarInit(updateChips);
							AppContext.getBean(RacingCarInitDao.class).updateRacing(sic);// 更新系统奖池
						}*/

					
					}
					GameCarHelper.savePools(CarCache.RACINGCARID, dealerfund.getFbid(), winItem, odds, dealerfund.getIsRobot(),dealerWinChips,dealerCommission);
				
					if (dealerfund.getIsRobot() == 0 && dealerWinChips != null) { // 若庄家是玩家,则将赢取的筹码返还给玩家上庄筹码
						// if(dealerfund.getFbid().toString().length()>6){
						CarCache.CURRENTDEALER.peek().setUpDealerChips(CarCache.CURRENTDEALER.peek().getUpDealerChips() + dealerWinChips.longValue());
						// }
					}
					
					CarCache.setDrawRecords(AppContext.getBean(DrawRecordDao.class).readUserDraw());
					
					drawRecords = CarCache.getDrawRecords(); // 获奖记录
					Map<Long, Double> updateMap = Maps.newHashMap(); // 更新表
					Map<Long, Long> commissionMap = Maps.newHashMap(); // 抽水表
					Map<Long, Long> allOutMap = Maps.newHashMap(); // 总分成
					boolean pushFlush = false;
					settleAccount = settleAccount(pushFlush, updateMap, commissionMap, allOutMap);// 每个玩家的结算信息

					LOGGER.debug("=============={}", settleAccount);

					// System.out.println("最终结算的每个玩家信息######settleAccount=" +
					// allOutMap.toString());
					finalWinChipPlayers = new ArrayList<Map.Entry<Long, Long>>(settleAccount.entrySet());// 押中者减去押注的玩家信息
					Collections.sort(finalWinChipPlayers, new Comparator<Map.Entry<Long, Long>>() {
						@Override
						public int compare(Entry<Long, Long> o1, Entry<Long, Long> o2) {// 按最终筹码降序排列
							return o2.getValue().compareTo(o1.getValue());
						}
					});

					List<PlayerWinVo> allWinList = Lists.newArrayList(); // 玩家输赢的概况

					for (int i = 0; i < finalWinChipPlayers.size(); i++) {// 最终结算得到赢取筹码最多前五位玩家
						pos = finalWinChipPlayers.get(i);
						// System.out.println("闲家赢取筹码finalWinChipPlayers.pos=" +
						// pos.getValue());
						if (pos.getValue() > 0) { // 只取最终结算筹码为正的玩家显示给财富榜
							playerfund = LobbyUserHelper.getUserFund(pos.getKey());// 获胜玩家信息
							// playerBasic =
							// AppContext.getBean(UserBasicDao.class).findUserBasic(pos.getKey());//
							// 获胜玩家头像信息
							userFundDetails = LobbyUserHelper.getUserInfo(pos.getKey());
							// leftChips = pos.getValue() >
							// ConstantPool.DRAWWATER ?
							// (long)(Math.floor(pos.getValue()*(1-ConstantPool.DRAWWATERRATE)))
							// : pos.getValue();
							// playerWin = new PlayerWinVo(pos.getKey(),
							// playerfund.getFbname(),
							// playerBasic.getFigureurl(), pos.getValue());//
							// 玩家赢取筹码抽水));
							playerWin = new PlayerWinVo(pos.getKey(), playerfund.getFbname(), userFundDetails.getImgurl(), pos.getValue());// 玩家赢取筹码抽水));
							playerWins.add(playerWin);
						}
						PlayerWinVo win = null;
						if (pos.getValue() < 0 || !allOutMap.containsKey(pos.getKey())) {
							win = new PlayerWinVo(pos.getKey(), null, null, pos.getValue());
						} else {
							/**
							 * wtu.edit 2015-11-18 存入数据库为前端显示的赢利结果
							 */
							win = new PlayerWinVo(pos.getKey(), null, null, pos.getValue());
							//win = new PlayerWinVo(pos.getKey(), null, null, allOutMap.get(pos.getKey()));
						}
						win.setIsRobot(0);
						if (commissionMap.containsKey(pos.getKey().longValue())) {
							win.setCommission(commissionMap.get(pos.getKey()));
						} else {
							win.setCommission(0L);
						}
						allWinList.add(win);
					}

					// 是否是玩家坐庄
					boolean isPlayer = dealerfund.getIsRobot() == 0;
					playerWins = robotSettleChips(entry.getItem(), playerWins, allWinList, isPlayer);// 机器人押注筹码结算结果
					writeWinLog(CarCache.RACINGCARID, allWinList);

					winnerlimit = playerWins.size() >= 5 ? 5 : playerWins.size(); // 获取赢取筹码量最大的前5位玩家,若赢家数小于5,则返回所有赢家
					sav = new SettleAccountVo(EventDefinition.EVENT_WIN_RESULT, entry.getItem(), playerWins.subList(0, winnerlimit), wealthList(), drawRecords);
					/**
					 * wtu.edit 2015-11-18 取消原庄家下注面板
					 * 恢复为手机端提供数据
					 */
					dw = new DealerResultVo(EventDefinition.EVENT_DEALER_RESULT, dealerFbId, dealerWinChips, dealerWinItems(entry));
					if (entryTime + CarCache.SETTLEACCOUNTSLEEP - System.currentTimeMillis() > 0) {
						Thread.sleep(entryTime + CarCache.SETTLEACCOUNTSLEEP - System.currentTimeMillis());
					}
					

					/*
					 *  计算bug-------------------------------------
					 */
					Long playerAllWin = getPlayerWinNum(allWinList, 0);
					
					Long robotAllWin = getPlayerWinNum(allWinList, 1);
					RacingCar racingcar = new RacingCar(CarCache.RACINGCARID, DateUtils.formatDate(new Date(CarCache.STARTRACINGCAR)), dealerFbId, CarCache.PLAYER_INFO_IN_SUPREMEROOM.size(),
							dealerWinChips, AppContext.getBean(DrawItemDao.class).findItemId(winItem), Double.valueOf(dealerWinChips*CarCache.SYS_POOLS).longValue(), CarCache.EACHWINSUMCHIPS.get(PrizeItem.SUMCHIPS.getItem()), CarCache.ROBOTSBETCHIPS);
					// RacingcarDao.saveRacingCar(racingcar);
					racingcar.setPlayerWin(playerAllWin);
					racingcar.setRobotWin(robotAllWin);
					racingcar.setDealerCommission(dealerCommission);

					Long playerBet = CarCache.EACHWINSUMCHIPS.get(PrizeItem.SUMCHIPS.getItem());
					//wtu.edit 2015-11-17 注解掉是否是真人存入数据
					//if (playerBet > 0 || isPlayer) 
					{
						AppContext.getBean(RacingCarDao.class).saveRacingCar(racingcar);
					}
					writeDataToChannel(sav);// 发送结算公共信息到每一个客户端
					writeDataToChannel(dw); // 发送庄家结算信息
					writeDateToChannel(dealerFbId, dealerWinChips, (playerAllWin+robotAllWin),settleAccount,winItem,odds,drawRecords,playerWins);// 发送给每位玩家自己与庄家的输赢对比信息
					// System.out.println("发送结算信息到每一个客户端####" +
					// (dealerfund.getIsRobot() == 1 ? "系统" : "玩家") +
					// "玩家坐庄结算执行时间(包含线程睡眠):" + (System.currentTimeMillis() -
					// entryTime));

					// 计算玩家当前连赢局数
					if (dealerWinChips > 0) {
						LOGGER.debug("庄家连赢局数：{}",currentdealer.getWining() + 1);
						CarCache.CURRENTDEALER.peek().setWining(currentdealer.getWining() + 1);
					} else {
						LOGGER.debug("庄家连赢局数重置为0");
						CarCache.CURRENTDEALER.peek().setWining(0);
					}

					if (!pushFlush) {
						// 更新所有用户大厅的筹码
						if (null != updateMap && !updateMap.isEmpty()) {
							Set<Long> keys = updateMap.keySet();
							for (long key : keys) {
								Double updateNum = updateMap.get(key);
								LobbyUserHelper.updateUserFund(key, updateNum);
								LOGGER.debug("+++++++++++++key:{}, value:{}", key, updateNum);
							}
						}
					}
					
					GameCarActiveHelper.SendNoticesForTips();
					
				}

				// 清除系统设置的开奖结果
				AppContext.getBean(GameCarService.class).setLotteryResults("");
				
				LOGGER.debug("结束历史记录：{},",drawRecords,System.currentTimeMillis());

				return;
			}
			/*
			 * }else{ System.out.println("未收到结算指令,进入结算异常"); }
			 */

		} catch (Exception e) {
			// System.out.println("###########进入结算异常,本局游戏作废,所有玩家押注筹码将原额返还.");
			Map<String, ConcurrentHashMap<Long, Map<String, String>>> prizeset = CarCache.PRIZESET;
			iterator = prizeset.keySet().iterator();
			while (iterator.hasNext()) {
				winItem = iterator.next();
				playerChips = prizeset.get(winItem);
				chipsFbIds = playerChips.keys();
				while (chipsFbIds.hasMoreElements()) {
					fbId = chipsFbIds.nextElement();
					perplayerChips = playerChips.get(fbId);
					perbetChips = chipCashes(perplayerChips);
					LobbyUserHelper.updateUserFund(fbId, perbetChips.doubleValue());
					// System.out.println("玩家fbId=" + fbId + "在" + item +
					// "押注门类押注异常返还押注筹码" + perbetChips);
				}
			}
			ExceptionVo exceptionvo = new ExceptionVo(Definition.JOIN_RACINGCAR_ROOM_FAILED_CODE, EventDefinition.EVENT_WIN_EXCEPTION, "开奖结算异常", "进入系统结算异常,该局游戏作废,所有玩家的押注将原额返回,请等待下一局游戏或重新进入游戏");
			writeDataToChannel(exceptionvo);
			e.printStackTrace();
			return;
		}
	}

	/**
	 * 机器要押注结算后返回赢取筹码玩家(降序排列)
	 * 
	 * @param winItem
	 * @param playerWins
	 * @return
	 */
	private List<PlayerWinVo> robotSettleChips(String winItem, List<PlayerWinVo> playerWins, List<PlayerWinVo> allWinList, boolean isPlayer) {
		ConcurrentHashMap<String, Map<Long, Long>> betrobotchips = CarCache.BETROBOTCHIPS;

		LOGGER.debug("=========机器人押中的记录:{}", betrobotchips.get(winItem));
		// UserBasic playerBasic = null;

		Set<String> betItemList = betrobotchips.keySet();
		  Map<Long, Long> allsum = CarCache.BETROBOTCHIPS.get(PrizeItem.SUMCHIPS.getItem());
		  Iterator<Entry<Long, Long>> itrs=allsum.entrySet().iterator();
		  Long sumchips=0L;
		  while(itrs.hasNext())
		  {
			   Entry<Long, Long> item = itrs.next();
			   sumchips+=item.getValue();
		  }
		LOGGER.debug("-----总下注1：{}  --总下注2:{} ",CarCache.ROBOTSBETCHIPS,sumchips);
		for (String betItem : betItemList) {
			
			if(betItem.equals(PrizeItem.SUMCHIPS.getItem()))
			{
				continue;
			}

			// 押注详情
			Map<Long, Long> betDetial = betrobotchips.get(betItem);

			Set<Long> robotFbIdList = betDetial.keySet();

			boolean isWin = betItem.equals(winItem);

			int odds = 1; // 赔付的比率

			if (isWin) // 机器人押中
			{
				odds = GameCarServiceImpl.PRIZESET.get(betItem).getOdds();
			} else // 没有押中
			{
				odds = 1;
			}
			for (Long robotFbId : robotFbIdList) {
				// 押注的金额
				Long betNum = betDetial.get(robotFbId);
				Long allBetNum=allsum.get(robotFbId);

				if (isWin) {
					
					// 纯收入
					Long juestGet = betNum * odds-allBetNum;
					// 抽水的金额
					Long drawwaterChip = 0L;
					if (juestGet > ConstantPool.DRAWWATER) // 纯收入大于指定的金额
					{
						float num = ConstantPool.DRAWWATERRATE; // 需要扣除的比例
						drawwaterChip = (long) Math.floor(juestGet * (num));// 抽水筹码
						// commissionMapRobot.put(robotFbId, drawwaterChip);
					}
					// 实际获得的总额
					juestGet -= drawwaterChip;

					Long allGet = juestGet+allBetNum-betNum;

					PlayerWinVo win = new PlayerWinVo(robotFbId.longValue(), "", "", allGet);// 玩家赢取筹码抽水));
					win.setIsRobot(1);
					/**
					 * wtu.edit 2015-11-23 
					 * 当没有玩存在时不记录机器人赢得的值，
					 * 修改都记录，不然账会出现核算不正确
					 */
					//if (!allWinList.isEmpty() || isPlayer)
					{
						win.setCommission(drawwaterChip);
						allWinList.add(win);
					}
					// //////////////////////
					UserFund playerfund = LobbyUserHelper.getUserFund(robotFbId);// 获胜玩家信息
					UserFundDetails userFundDetails = LobbyUserHelper.getUserInfo(robotFbId);
					PlayerWinVo playerWin = null;

					playerWin = new PlayerWinVo(robotFbId.longValue(), (playerfund != null ? playerfund.getFbname() : ""), (userFundDetails != null ? userFundDetails.getImgurl() : ""), juestGet);// 玩家赢取筹码抽水));
					playerWins.add(playerWin);
				} else {
					PlayerWinVo win = new PlayerWinVo(robotFbId.longValue(), "", "", -betNum);// 玩家赢取筹码抽水));
					win.setIsRobot(1);
					win.setCommission(0L);
					allWinList.add(win);
				}
				// /////////
			}

		}
		// while (items.hasMoreElements()) {
		// item = items.nextElement();
		// fbIds = betrobotchips.get(item).keySet().iterator();
		// if (!item.equalsIgnoreCase(winItem)) {
		// while (fbIds.hasNext()) {
		// fbId = fbIds.next();
		// if (robotSettles.get(fbId) == null) {
		// robotSettles.put(fbId, -betrobotchips.get(item).get(fbId));
		// } else {
		// robotSettles.put(fbId, robotSettles.get(fbId) -
		// betrobotchips.get(item).get(fbId));
		// }
		// }
		// } else {
		// while (fbIds.hasNext()) {
		// fbId = fbIds.next();
		// if (robotSettles.get(fbId) == null) {
		// robotSettles.put(fbId, betrobotchips.get(item).get(fbId) *
		// GameCarServiceImpl.PRIZESET.get(item).getOdds());
		// } else {
		// robotSettles.put(fbId, robotSettles.get(fbId) +
		// betrobotchips.get(item).get(fbId) *
		// GameCarServiceImpl.PRIZESET.get(item).getOdds());
		// }
		// }
		// }
		// }
		// // ConcurrentHashMap<Long,PlayerInfoInSupremeRoom> betchipsrobots =
		// // CarCache.BETCHIPSROBOTS;
		// // Enumeration<Long> betIds = betchipsrobots.keys();
		// Iterator<Long> betIds = robotSettles.keySet().iterator();
		//
		// while (betIds.hasNext()) {
		// fbId = betIds.next();
		// if (fbId == null)
		// continue;
		// if (robotSettles.get(fbId) != null) {
		// if (robotSettles.get(fbId) > 0) {
		// playerfund = LobbyUserHelper.getUserFund(fbId);// 获胜玩家信息
		// // playerBasic =
		// // AppContext.getBean(UserBasicDao.class).findUserBasic(fbId);//
		// // 获胜玩家头像信息
		// UserFundDetails userFundDetails = LobbyUserHelper.getUserInfo(fbId);
		// // playerWin = new PlayerWinVo(fbId.longValue(), (playerfund
		// // !=
		// // null ? playerfund.getFbname() : ""), (playerBasic != null
		// // ?
		// // playerBasic.getFigureurl() : ""),
		// // robotSettles.get(fbId));//
		// // 玩家赢取筹码抽水));
		// playerWin = new PlayerWinVo(fbId.longValue(), (playerfund != null ?
		// playerfund.getFbname() : ""), (userFundDetails != null ?
		// userFundDetails.getImgurl() : ""),
		// robotSettles.get(fbId));// 玩家赢取筹码抽水));
		// playerWins.add(playerWin);
		//
		// Long allGet = robotSettles.get(fbId);
		//
		// if (allGet > ConstantPool.DRAWWATER) {
		// float num = ConstantPool.DRAWWATERRATE; // 需要扣除的比例
		// // num = 0;
		// // Long allCost = betChipsInfo.get(winbet.getKey());
		// Long getCash = allGet;
		// // Long drawwaterChip = (long) Math.floor(( - ) *
		// // (num));// 抽水筹码
		// Long drawwaterChip = (long) Math.floor(getCash * (num));// 抽水筹码
		// commissionMapRobot.put(fbId, drawwaterChip);
		// commissionMapOut.put(fbId, drawwaterChip +
		// betrobotchips.get(winItem).get(fbId));
		// } else {
		// commissionMapOut.put(fbId, allGet +
		// betrobotchips.get(winItem).get(fbId));
		// }
		// } else {
		// commissionMapOut.put(fbId, robotSettles.get(fbId));
		// }
		//
		// PlayerWinVo win = new PlayerWinVo(fbId.longValue(), "", "",
		// commissionMapOut.get(fbId));// 玩家赢取筹码抽水));
		// win.setIsRobot(1);
		// if (!allWinList.isEmpty() || isPlayer) {
		// if (null != fbId) {
		// if (commissionMapRobot.containsKey(fbId.longValue())) {
		// Long commission = commissionMapRobot.get(fbId.longValue());
		// win.setCommission(commission);
		// } else {
		// win.setCommission(0L);
		// }
		// }
		//
		// allWinList.add(win);
		// }
		// }
		// }
		Collections.sort(playerWins, new Comparator<PlayerWinVo>() {
			@Override
			public int compare(PlayerWinVo o1, PlayerWinVo o2) {
				return o2.getWinChips().compareTo(o1.getWinChips());
			}
		});
		return playerWins;
	}

	/**
	 * 获取财富列表
	 * 
	 * @return
	 */
	private List<WealthVo> wealthList() {
		WealthVo wv = null;
		List<WealthVo> nulls = new ArrayList<WealthVo>(); // 移除list中的空对象
		nulls.add(null);
		List<PlayerInfoInSupremeRoom> pirList = null;
		List<WealthVo> wealthlist = null;
		wealthlist = new ArrayList<WealthVo>();
		pirList = new ArrayList<PlayerInfoInSupremeRoom>(CarCache.PLAYER_INFO_IN_SUPREMEROOM.values());
		Collections.sort(pirList, new Comparator<PlayerInfoInSupremeRoom>() {// 按房间内玩家筹码量降序排列
					@Override
					public int compare(PlayerInfoInSupremeRoom o1, PlayerInfoInSupremeRoom o2) {
						return o2.getLobbyChips().compareTo(o1.getLobbyChips());
					}
				});
		if (pirList.size() <= 3) {// 若当前加入游戏的玩家数少于3个
			for (PlayerInfoInSupremeRoom pisr : pirList) {
				wv = new WealthVo(pisr.getFbId(), pisr.getFbName(), pisr.getImageUrl(), pisr.getLobbyChips(), System.currentTimeMillis(), pisr.isRobot());
				wealthlist.add(wv);
			}
		} else {
			PlayerInfoInSupremeRoom pisr = null;
			for (int i = 0; i < 3; i++) {// 将游戏中筹码最多的前3个玩家加入土豪榜
				pisr = pirList.get(i);
				wv = new WealthVo(pisr.getFbId(), pisr.getFbName(), pisr.getImageUrl(), pisr.getLobbyChips(), System.currentTimeMillis(), pisr.isRobot());
				wealthlist.add(wv);
			}
		}
		wealthlist.removeAll(nulls);
		CarCache.WEALTHLIST.put(Definition.WEALTHKEY, wealthlist);
		return CarCache.WEALTHLIST.get(Definition.WEALTHKEY);
	}

	/**
	 * 构建庄家每门押注输赢金额
	 * 
	 * @param entry
	 * @param chipsset
	 * @return
	 */
	private List<DealerWinVo> dealerWinItems(PrizeEntry entry) {
		Map<String, Long> chipsset = CarCache.CHIPSSET;// 玩家押注<item,chips>
		ConcurrentHashMap<String, Long> robotchips = CarCache.ROBOTCHIPS;// 机器人押注<item,Chips>
		List<DealerWinVo> dealerWinList = new ArrayList<DealerWinVo>();
		if (!entry.getItem().equals(PrizeItem.MINVW.getItem())) {
			dealerWinList.add(new DealerWinVo(PrizeItem.MINVW.getItem(), robotchips.get(PrizeItem.MINVW.getItem()) + chipsset.get(PrizeItem.MINVW.getItem()), robotchips.get(PrizeItem.MINVW.getItem())
					+ chipsset.get(PrizeItem.MINVW.getItem())));
		} else {
			dealerWinList.add(new DealerWinVo(PrizeItem.MINVW.getItem(), robotchips.get(PrizeItem.MINVW.getItem()) + chipsset.get(PrizeItem.MINVW.getItem()), (1 - entry.getOdds())
					* (robotchips.get(PrizeItem.MINVW.getItem()) + chipsset.get(PrizeItem.MINVW.getItem()))));
		}

		if (!entry.getItem().equals(PrizeItem.MINBMW.getItem())) {
			dealerWinList.add(new DealerWinVo(PrizeItem.MINBMW.getItem(), robotchips.get(PrizeItem.MINBMW.getItem()) + chipsset.get(PrizeItem.MINBMW.getItem()), robotchips.get(PrizeItem.MINBMW
					.getItem()) + chipsset.get(PrizeItem.MINBMW.getItem())));
		} else {
			dealerWinList.add(new DealerWinVo(PrizeItem.MINBMW.getItem(), robotchips.get(PrizeItem.MINBMW.getItem()) + chipsset.get(PrizeItem.MINBMW.getItem()), (1 - entry.getOdds())
					* (robotchips.get(PrizeItem.MINBMW.getItem()) + chipsset.get(PrizeItem.MINBMW.getItem()))));
		}

		if (!entry.getItem().equals(PrizeItem.MINBENZ.getItem())) {
			dealerWinList.add(new DealerWinVo(PrizeItem.MINBENZ.getItem(), robotchips.get(PrizeItem.MINBENZ.getItem()) + chipsset.get(PrizeItem.MINBENZ.getItem()), robotchips.get(PrizeItem.MINBENZ
					.getItem()) + chipsset.get(PrizeItem.MINBENZ.getItem())));
		} else {
			dealerWinList.add(new DealerWinVo(PrizeItem.MINBENZ.getItem(), robotchips.get(PrizeItem.MINBENZ.getItem()) + chipsset.get(PrizeItem.MINBENZ.getItem()), (1 - entry.getOdds())
					* (robotchips.get(PrizeItem.MINBENZ.getItem()) + chipsset.get(PrizeItem.MINBENZ.getItem()))));
		}

		if (!entry.getItem().equals(PrizeItem.MINPORSCHE.getItem())) {
			dealerWinList.add(new DealerWinVo(PrizeItem.MINPORSCHE.getItem(), robotchips.get(PrizeItem.MINPORSCHE.getItem()) + chipsset.get(PrizeItem.MINPORSCHE.getItem()), robotchips
					.get(PrizeItem.MINPORSCHE.getItem()) + chipsset.get(PrizeItem.MINPORSCHE.getItem())));
		} else {
			dealerWinList.add(new DealerWinVo(PrizeItem.MINPORSCHE.getItem(), robotchips.get(PrizeItem.MINPORSCHE.getItem()) + chipsset.get(PrizeItem.MINPORSCHE.getItem()), (1 - entry.getOdds())
					* (robotchips.get(PrizeItem.MINPORSCHE.getItem()) + chipsset.get(PrizeItem.MINPORSCHE.getItem()))));
		}

		if (!entry.getItem().equals(PrizeItem.BIGVW.getItem())) {
			dealerWinList.add(new DealerWinVo(PrizeItem.BIGVW.getItem(), robotchips.get(PrizeItem.BIGVW.getItem()) + chipsset.get(PrizeItem.BIGVW.getItem()), robotchips.get(PrizeItem.BIGVW.getItem())
					+ chipsset.get(PrizeItem.BIGVW.getItem())));
		} else {
			dealerWinList.add(new DealerWinVo(PrizeItem.BIGVW.getItem(), robotchips.get(PrizeItem.BIGVW.getItem()) + chipsset.get(PrizeItem.BIGVW.getItem()), (1 - entry.getOdds())
					* (robotchips.get(PrizeItem.BIGVW.getItem()) + chipsset.get(PrizeItem.BIGVW.getItem()))));
		}

		if (!entry.getItem().equals(PrizeItem.BIGBMW.getItem())) {
			dealerWinList.add(new DealerWinVo(PrizeItem.BIGBMW.getItem(), robotchips.get(PrizeItem.BIGBMW.getItem()) + chipsset.get(PrizeItem.BIGBMW.getItem()), robotchips.get(PrizeItem.BIGBMW
					.getItem()) + chipsset.get(PrizeItem.BIGBMW.getItem())));
		} else {
			dealerWinList.add(new DealerWinVo(PrizeItem.BIGBMW.getItem(), robotchips.get(PrizeItem.BIGBMW.getItem()) + chipsset.get(PrizeItem.BIGBMW.getItem()), (1 - entry.getOdds())
					* (robotchips.get(PrizeItem.BIGBMW.getItem()) + chipsset.get(PrizeItem.BIGBMW.getItem()))));
		}

		if (!entry.getItem().equals(PrizeItem.BIGBENZ.getItem())) {
			dealerWinList.add(new DealerWinVo(PrizeItem.BIGBENZ.getItem(), robotchips.get(PrizeItem.BIGBENZ.getItem()) + chipsset.get(PrizeItem.BIGBENZ.getItem()), robotchips.get(PrizeItem.BIGBENZ
					.getItem()) + chipsset.get(PrizeItem.BIGBENZ.getItem())));
		} else {
			dealerWinList.add(new DealerWinVo(PrizeItem.BIGBENZ.getItem(), robotchips.get(PrizeItem.BIGBENZ.getItem()) + chipsset.get(PrizeItem.BIGBENZ.getItem()), (1 - entry.getOdds())
					* (robotchips.get(PrizeItem.BIGBENZ.getItem()) + chipsset.get(PrizeItem.BIGBENZ.getItem()))));
		}

		if (!entry.getItem().equals(PrizeItem.BIGPORSCHE.getItem())) {
			dealerWinList.add(new DealerWinVo(PrizeItem.BIGPORSCHE.getItem(), robotchips.get(PrizeItem.BIGPORSCHE.getItem()) + chipsset.get(PrizeItem.BIGPORSCHE.getItem()), robotchips
					.get(PrizeItem.BIGPORSCHE.getItem()) + chipsset.get(PrizeItem.BIGPORSCHE.getItem())));
		} else {
			dealerWinList.add(new DealerWinVo(PrizeItem.BIGPORSCHE.getItem(), robotchips.get(PrizeItem.BIGPORSCHE.getItem()) + chipsset.get(PrizeItem.BIGPORSCHE.getItem()), (1 - entry.getOdds())
					* (robotchips.get(PrizeItem.BIGPORSCHE.getItem()) + chipsset.get(PrizeItem.BIGPORSCHE.getItem()))));
		}
		return dealerWinList;
	}

	/**
	 * 计算每个玩家的结算信息(减去该局押注筹码的净盈利)
	 * 
	 * @param winItem
	 * @return
	 */
	private ConcurrentHashMap<Long, Long> settleAccount(boolean update, Map<Long, Double> updateMap, Map<Long, Long> commissionMap, Map<Long, Long> allOutMap) {
		ConcurrentHashMap<String, Map<Long, Long>> betkindperplayer = CarCache.BETKINDPERPLAYER; // 每个门类中每位玩家的押注额
		// System.out.println("当前CarCache.BETKINDPERPLAYER=" +
		// CarCache.BETKINDPERPLAYER.toString());
		Map<Long, Long> betPlayers = null; // <fbId,betchips>
		Iterator<Long> fbIds = null;
		ConcurrentHashMap<Long, Long> remittinfo = CarCache.REMITTINFO; // 当前局所有闲家押注信息(包括押中奖者和未押中奖者)
		ConcurrentHashMap<Long, Long> winplayersinfo = CarCache.WINPLAYERSINFO; // 押中开奖那门的玩家该门的赢取筹码量
		ConcurrentHashMap<Long, Long> betChipsInfo = new ConcurrentHashMap<Long, Long>();// 每位玩家总押注信息<fbId,chips>
		//Enumeration<String> items = betkindperplayer.keys();
		Long fbId = null;
		
		//LOGGER.info("=======>"+betkindperplayer.toString());
		/**
		 * wtu.edit 2015-11-27 修改为新的循环方式，原旧while循环遍历，可能存在问题
		 * 
		 */
		PrizeItem[] items = PrizeItem.values();
		String item="";
		for (PrizeItem pi : items) {
			// if(!item.equals(winItem)){
			item=pi.getItem();
			if(item.equals(PrizeItem.SUMCHIPS.getItem()))
			{//不计算总和值
				continue;
			}
			betPlayers = betkindperplayer.get(item);
			LOGGER.debug("----->item:{},当前betPlayers=",item, betPlayers.toString());
			fbIds = betPlayers.keySet().iterator();
			while (fbIds.hasNext()) {
				fbId = fbIds.next();
				if (winplayersinfo.containsKey(fbId)) {
					// CarCache.WINPLAYERSINFO.put(fbId,CarCache.WINPLAYERSINFO.get(fbId)-betPlayers.get(fbId));//减去押注筹码
					if (betChipsInfo.containsKey(fbId)) {// 押中者总押注信息
						betChipsInfo.put(fbId, betChipsInfo.get(fbId) + betPlayers.get(fbId));
					} else {
						betChipsInfo.put(fbId, betPlayers.get(fbId));
					}
					winplayersinfo.put(fbId, winplayersinfo.get(fbId) - betPlayers.get(fbId));
					remittinfo.put(fbId, winplayersinfo.get(fbId));
				} else {
					if (remittinfo.containsKey(fbId)) {
						remittinfo.put(fbId, remittinfo.get(fbId) - betPlayers.get(fbId));
					} else {
						remittinfo.put(fbId, -betPlayers.get(fbId));
					}
				}
			}
			// }
		}
		// System.out.println("当前押中者的总押注信息为:betChipsInfo=" +
		// betChipsInfo.toString());
		for (Map.Entry<Long, Long> winbet : betChipsInfo.entrySet()) { // 更新押中玩有的筹码信息
			Long allGet = CarCache.WINPLAYERSINFO.get(winbet.getKey());
			// Long diff = allGet - betChipsInfo.get(winbet.getKey());
			if (allGet > ConstantPool.DRAWWATER) {
				float num = ConstantPool.DRAWWATERRATE; // 需要扣除的比例
				// num = 0;
				// Long allCost = betChipsInfo.get(winbet.getKey());
				Long getCash = allGet;
				// Long drawwaterChip = (long) Math.floor(( - ) * (num));// 抽水筹码
				Long drawwaterChip = (long) Math.floor(getCash * (num));// 抽水筹码
				// Long uiChip = (long)
				// Math.floor((CarCache.WINPLAYERSINFO.get(winbet.getKey()) -
				// betChipsInfo.get(winbet.getKey())) * (1 - num));// 显示到前台的结算筹码
				Long uiChip = (long) Math.floor(getCash * (1 - num));// 显示到前台的结算筹码

				commissionMap.put(winbet.getKey(), drawwaterChip);
				remittinfo.put(winbet.getKey(), uiChip);
				uiChip += betChipsInfo.get(winbet.getKey());
				Double value = Math.floor(uiChip);
				updateMap.put(winbet.getKey(), value);
				allOutMap.put(winbet.getKey(), value.longValue());
				if (update) {
					LobbyUserHelper.updateUserFund(winbet.getKey(), value);
					// System.out.println("闲家fbId=" + winbet.getKey() +
					// "抽水后本次赢取筹码" +
					// (CarCache.WINPLAYERSINFO.get(winbet.getKey()) -
					// drawwaterChip));
				}
			} else {
				Double value = betChipsInfo.get(winbet.getKey()) + allGet.doubleValue();

				allOutMap.put(winbet.getKey(), value.longValue());
				updateMap.put(winbet.getKey(), value);
				if (update) {
					LobbyUserHelper.updateUserFund(winbet.getKey(), value);
					// System.out.println("闲家fbId=" + winbet.getKey() +
					// "不用抽水,本次赢取筹码" + allGet);
				}
			}
		}
		return remittinfo;
	}

	/**
	 * 写数据到庄家netty channel
	 * 
	 * @param dealerresultvo
	 */
	private void writeDataToChannel(Object data) {
		// LogicChannelUtil.sendToAll(dealerresultvo);
		AppContext.getBean(GameCarService.class).sendToAll(data);
	}

	/**
	 * 写每位玩家与庄家输赢对比数据到netty channel
	 * 
	 * @param dealerFbId
	 *            ,playerWins,dealerWinChips
	 */
	private void writeDateToChannel(Long dealerFbId, Long dealerWinChips ,Long allWinChips, ConcurrentHashMap<Long, Long> remittinfo,String winItem,Integer mul,List<String> drawRecords,List<PlayerWinVo> plist) {
		
		
		int linkMul=GameCarActiveHelper.getMulForItem(drawRecords, winItem);
		LOGGER.debug("显示连开：{}",linkMul);
		LOGGER.debug("历史记录：{},{}",drawRecords,winItem);
		
		Set<String> sessionList = AppContext.getBean(GameCarService.class).getSessionList();

		for (String session : sessionList) {
			Long fbId = Long.valueOf(session);
			Long mulChips=0L;
			if(!GameCarActiveHelper.isMulActiveOff())
			{
				if(linkMul>0 && GameCarActiveHelper.checkOpenMulTime())
				{
					mulChips=linkMul*GameCarHelper.getOnePlayerWin(fbId, winItem, mul);
					if(mulChips!=0)
					{//更新玩家筹码
						LobbyUserHelper.updateUserFund(fbId, mulChips.doubleValue(),10,"小游戏翻倍活动");
					}
				}
			}
			PlayerDealerCnt pdc = new PlayerDealerCnt(EventDefinition.EVENT_PLAYER_DEALER, dealerFbId, fbId, remittinfo.get(fbId), dealerWinChips,allWinChips,mulChips);
			AppContext.getBean(GameCarService.class).sendToTargets(session, pdc);
		}
		
		if(plist!=null && plist.size()>0)
		{
			LOGGER.debug("显示最高玩家：{}",plist.get(0));
			if(!GameCarActiveHelper.isMulActiveOff())
			{
				if(linkMul>0 && GameCarActiveHelper.checkOpenMulTime())
				{
					PlayerWinVo pv=plist.get(0);
					Long mulChips = linkMul*GameCarHelper.getOneWin(pv.getPlayerfbId(), winItem, mul);
					GameCarActiveHelper.SendNoticesForWin(pv.getFbName(), mulChips, linkMul);
				}
			}		
		}
	}

	/**
	 * 根据奖池金额设置系统返奖率
	 * 
	 * @param rewarePool
	 * @return
	 */
	private Float rewardRate(Long rewarePool, Float minRate, Float maxRate) {
		if (rewarePool < 1e7) {
			return minRate;
		}
		if (rewarePool >= 1e7 && rewarePool < 2e7) {
			return ConstantPool.BETRATE1;// 0.7f;
		}
		if (rewarePool >= 2e7 && rewarePool < 4e7) {
			return ConstantPool.BETRATE2;// 0.9f;
		}
		if (rewarePool >= 4e7 && rewarePool < 6e7) {
			return ConstantPool.BETRATE3; // 1.2f;
		}
		if (rewarePool >= 6e7) {
			return maxRate;
		}
		return null;
	}

	/**
	 * 当所有押注筹码为空(0)时,随机出一个奖项
	 * 
	 * @return
	 */
	private PrizeEntry systemChipsNullPrize() {
		Random rd = new Random();
		Integer random = -1;
		do {
			random = rd.nextInt(8);
		} while (random < 0 && random > 7);
		// System.out.println("systemChipsNullPrize random=" + random +
		// "Definition.PRIZEARRAY=" +
		// Arrays.asList(GameCarServiceImpl.PRIZEARRAY).toString());
		String prize = GameCarServiceImpl.PRIZEARRAY[random];// Arrays.asList(Definition.PRIZEARRAY).get(random);//
																// [random-1];
		PrizeEntry entry = GameCarServiceImpl.PRIZESET.get(prize);
		// System.out.println("当前押注筹码为空(0)时,随机出一个奖项为:" + prize);
		return entry;
	}

	/**
	 * 返回赔付比率最接近系统返奖率的一项,即开奖
	 * 
	 * @param chipsset
	 * @param sumBetChips
	 * @return
	 */
	private PrizeEntry systemPrizeRules() {
		Long sumBetChips = CarCache.EACHWINSUMCHIPS.get(PrizeItem.SUMCHIPS.getItem()) + CarCache.ROBOTSBETCHIPS / 1; // 当前局总押注筹码量
		Long rewarePool = CarCache.REWAREPOOL;// 系统奖池
		// Float rewardrate = CommonConstantPool.rewardrate;//系统回收率
		DecimalFormat df = new DecimalFormat("####.0000");
		PrizeEntry prize = new PrizeEntry();
		// Set<Entry<String, Float>> entrys = null;
		// Iterator<Entry<String, Float>> it = null;
		// Entry<String, Float> entry = null;
		// List<Float> list = null;
		// Float choseValue = 0f;
		// // BigDecimal bd = new BigDecimal("0.##");
		// List<Float> neglist = null;
		// List<Float> poslist = null;
		List<Float> rationList = new ArrayList<Float>();
		ConcurrentHashMap<String, Long> chipsset = CarCache.CHIPSSET;
		ConcurrentHashMap<String, Long> robotchips = CarCache.ROBOTCHIPS;
		// Logger.info("================sumBetChips:{}",sumBetChips);
		// Logger.info("================chipsset:{}",chipsset);
		// Logger.info("================robotchips:{}",robotchips);
		Long itemChips = 0L;
		// System.out.println("chipsset =" +
		// chipsset.get(PrizeItem.MINVW.getItem()));
		if (sumBetChips != null && sumBetChips != 0L) {
			// 小大众赔付比率
			itemChips = chipsset.get(PrizeItem.MINVW.getItem()) + robotchips.get(PrizeItem.MINVW.getItem()) / 1;
			// System.out.println("小大众赔付比率:" + (itemChips) *
			// GameCarServiceImpl.PRIZESET.get(PrizeItem.MINVW.getItem()).getOdds()
			// / sumBetChips);
			Float minvmLossRation = Float.parseFloat(df.format((float) itemChips * GameCarServiceImpl.PRIZESET.get(PrizeItem.MINVW.getItem()).getOdds() / (float) sumBetChips));
			rationList.add(minvmLossRation);
			// 小宝马赔付比率
			itemChips = chipsset.get(PrizeItem.MINBMW.getItem()) + robotchips.get(PrizeItem.MINBMW.getItem()) / 1;
			// System.out.println("小宝马赔付比率:" + itemChips *
			// GameCarServiceImpl.PRIZESET.get(PrizeItem.MINBMW.getItem()).getOdds()
			// / sumBetChips);
			Float minbmwLossRation = Float.parseFloat(df.format((float) itemChips * GameCarServiceImpl.PRIZESET.get(PrizeItem.MINBMW.getItem()).getOdds() / (float) sumBetChips));
			rationList.add(minbmwLossRation);
			// 小奔驰赔付比率
			itemChips = chipsset.get(PrizeItem.MINBENZ.getItem()) + robotchips.get(PrizeItem.MINBENZ.getItem()) / 1;
			// System.out.println("小奔驰赔付比率:" + itemChips *
			// GameCarServiceImpl.PRIZESET.get(PrizeItem.MINBENZ.getItem()).getOdds()
			// / sumBetChips);
			Float minbenzLossRation = Float.parseFloat(df.format((float) itemChips * GameCarServiceImpl.PRIZESET.get(PrizeItem.MINBENZ.getItem()).getOdds() / (float) sumBetChips));
			rationList.add(minbenzLossRation);
			// 小保时捷赔付比率
			itemChips = chipsset.get(PrizeItem.MINPORSCHE.getItem()) + robotchips.get(PrizeItem.MINPORSCHE.getItem()) / 1;
			// System.out.println("小保时捷赔付比率:" + itemChips *
			// GameCarServiceImpl.PRIZESET.get(PrizeItem.MINPORSCHE.getItem()).getOdds()
			// / sumBetChips);
			Float minporscheLossRation = Float.parseFloat(df.format((float) itemChips * GameCarServiceImpl.PRIZESET.get(PrizeItem.MINPORSCHE.getItem()).getOdds() / (float) sumBetChips));
			rationList.add(minporscheLossRation);
			// 大大众赔付比率
			itemChips = chipsset.get(PrizeItem.BIGVW.getItem()) + robotchips.get(PrizeItem.BIGVW.getItem()) / 1;
			// System.out.println("大大众赔付比率:" + itemChips *
			// GameCarServiceImpl.PRIZESET.get(PrizeItem.BIGVW.getItem()).getOdds()
			// / sumBetChips);
			Float bigvmLossRation = Float.parseFloat(df.format((float) itemChips * GameCarServiceImpl.PRIZESET.get(PrizeItem.BIGVW.getItem()).getOdds() / (float) sumBetChips));
			rationList.add(bigvmLossRation);
			// 大宝马赔付比率
			itemChips = chipsset.get(PrizeItem.BIGBMW.getItem()) + robotchips.get(PrizeItem.BIGBMW.getItem()) / 1;
			// System.out.println("大宝马赔付比率:" + itemChips *
			// GameCarServiceImpl.PRIZESET.get(PrizeItem.BIGBMW.getItem()).getOdds()
			// / sumBetChips);
			Float bigbmwLossRation = Float.parseFloat(df.format((float) itemChips * GameCarServiceImpl.PRIZESET.get(PrizeItem.BIGBMW.getItem()).getOdds() / (float) sumBetChips));
			rationList.add(bigbmwLossRation);
			// 大奔驰赔付比率
			itemChips = chipsset.get(PrizeItem.BIGBENZ.getItem()) + robotchips.get(PrizeItem.BIGBENZ.getItem()) / 1;
			// System.out.println("大奔驰赔付比率:" + itemChips *
			// GameCarServiceImpl.PRIZESET.get(PrizeItem.BIGBENZ.getItem()).getOdds()
			// / sumBetChips);
			Float bigbenzLossRation = Float.parseFloat(df.format((float) itemChips * GameCarServiceImpl.PRIZESET.get(PrizeItem.BIGBENZ.getItem()).getOdds() / (float) sumBetChips));
			rationList.add(bigbenzLossRation);
			// 大保时捷赔付比率
			itemChips = chipsset.get(PrizeItem.BIGPORSCHE.getItem()) + robotchips.get(PrizeItem.BIGPORSCHE.getItem()) / 1;
			// System.out.println("大保时捷赔付比率:" + itemChips *
			// GameCarServiceImpl.PRIZESET.get(PrizeItem.BIGPORSCHE.getItem()).getOdds()
			// / sumBetChips);
			Float bigporscheLossRation = Float.parseFloat(df.format((float) itemChips * GameCarServiceImpl.PRIZESET.get(PrizeItem.BIGPORSCHE.getItem()).getOdds() / (float) sumBetChips));
			rationList.add(bigporscheLossRation);
			// System.out.println("赔付比率rationList=" + rationList);
			Collections.sort(rationList, new Comparator<Float>() { // 升序排列
						@Override
						public int compare(Float o1, Float o2) {
							return o1.compareTo(o2);
						}
					});
			// Logger.info("=================rationList:{}",rationList);
			Float systemLossRation = rewardRate(rewarePool, rationList.get(0), rationList.get(rationList.size() - 1)); // 1-rewardrate;
																														// //系统返奖率

			// Logger.info("=================systemLossRation:{}",systemLossRation);
			// Long systemRateChips = (long) Math.floor(systemLossRation *
			// sumBetChips);// 该局因系统回收率的回收额
			// System.out.println("该局系统坐庄因系统回收率被系统回收的筹码=" + systemRateChips);
			Map<String, Float> negrates = new HashMap<String, Float>();// 赔付比-返奖率为负
			Map<String, Float> posrates = new HashMap<String, Float>();// 赔付比-返奖率为正值
			Map<String, Float> equalrates = new HashMap<String, Float>();// 赔付比等于返奖率
			chooseRateList(negrates, posrates, equalrates, minvmLossRation - systemLossRation, PrizeItem.MINVW.getItem());
			chooseRateList(negrates, posrates, equalrates, minbmwLossRation - systemLossRation, PrizeItem.MINBMW.getItem());
			chooseRateList(negrates, posrates, equalrates, minbenzLossRation - systemLossRation, PrizeItem.MINBENZ.getItem());
			chooseRateList(negrates, posrates, equalrates, minporscheLossRation - systemLossRation, PrizeItem.MINPORSCHE.getItem());
			chooseRateList(negrates, posrates, equalrates, bigvmLossRation - systemLossRation, PrizeItem.BIGVW.getItem());
			chooseRateList(negrates, posrates, equalrates, bigbmwLossRation - systemLossRation, PrizeItem.BIGBMW.getItem());
			chooseRateList(negrates, posrates, equalrates, bigbenzLossRation - systemLossRation, PrizeItem.BIGBENZ.getItem());
			chooseRateList(negrates, posrates, equalrates, bigporscheLossRation - systemLossRation, PrizeItem.BIGPORSCHE.getItem());

			Map<String, Float> afterMap = Maps.newHashMap();
			afterMap.putAll(negrates);
			afterMap.putAll(posrates);
			afterMap.putAll(equalrates);
			// Logger.info("=================="+afterMap);
			// Set<String> afterMapKeys = afterMap.keySet();

			// Map<String, Float> diffMap = Maps.newHashMap();
			//
			// for (String afterMapKey : afterMapKeys) {
			// // 获取的差值
			// Float value = afterMap.get(afterMapKey);
			// Float diff = Math.abs(systemLossRation - value);
			// diffMap.put(afterMapKey, diff);
			// }

			LinkedHashMap<String, Float> sortMap = SettleAccountThread.sortMapByValue(afterMap, true);
			List<String> sortKeys = Lists.newArrayList(sortMap.keySet());
			List<String> sameList = Lists.newArrayList();
			if (!sortKeys.isEmpty()) {
				String theNearKey = null;
				Float theNearValue = null;
				for (String sortKey : sortKeys) {
					if (null == theNearKey) {
						// 设置最近的一个
						theNearKey = sortKey;
						theNearValue = sortMap.get(sortKey);
						sameList.add(sortKey);
					} else {
						Float value = sortMap.get(sortKey);
						if (value == theNearValue) {
							sameList.add(sortKey);
						}
					}
				}
			}

			// Logger.info("==================sortKeys:{}",sortKeys);
			// Logger.info("==================sameList:{}",sameList);
			if (!sameList.isEmpty()) {
				int allSize = sameList.size();
				String item = sameList.get(MathUtil.random(0, allSize - 1));
				prize.setItem(item);
				prize.setOdds(GameCarServiceImpl.PRIZESET.get(item).getOdds());
				return prize;
			}

		} else {
			// System.out.println("该局总押注筹码sumBetChips== " + sumBetChips +
			// ",此时应随机开出一个奖项");
		}
		return null;
	}

	/**
	 * 使用 Map按value进行排序
	 * 
	 * @param map
	 * @return
	 */
	public static LinkedHashMap<String, Float> sortMapByValue(final Map<String, Float> map, final boolean des) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		LinkedHashMap<String, Float> sortedMap = new LinkedHashMap<String, Float>();
		List<Map.Entry<String, Float>> entryList = new ArrayList<Map.Entry<String, Float>>(map.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<String, Float>>() {
			@Override
			public int compare(Entry<String, Float> o1, Entry<String, Float> o2) {
				return (des ? -1 : 1) * (int) (o2.getValue() * 10000 - o1.getValue() * 10000);
			}
		});
		Iterator<Map.Entry<String, Float>> iter = entryList.iterator();
		Map.Entry<String, Float> tmpEntry = null;
		while (iter.hasNext()) {
			tmpEntry = iter.next();
			sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
		}
		return sortedMap;
	}

	/**
	 * 根据赔付比-返奖率的正负值选择
	 * 
	 * @param negrates
	 * @param posrates
	 * @param rate
	 */
	private void chooseRateList(Map<String, Float> negrates, Map<String, Float> posrates, Map<String, Float> equalrates, Float rate, String item) {
		if (rate > 0) {
			posrates.put(item, rate);
		} else if (rate < 0) {
			negrates.put(item, -rate);
		} else if (rate == 0) {
			equalrates.put(item, 0f);
		}
	}

	/**
	 * 计算单个玩家单门押注的筹码量
	 * 
	 * @param map
	 * @return
	 */
	private Long chipCashes(Map<String, String> map) {
		Set<Entry<String, String>> set = map.entrySet();
		Iterator<Entry<String, String>> it = set.iterator();
		Entry<String, String> entry = null;
		Long cashes = 0L;
		while (it.hasNext()) {
			entry = it.next();
			cashes += Integer.valueOf(entry.getKey()) * Integer.valueOf(entry.getValue());
		}
		return cashes;
	}

	/**
	 * 计算机器人单门押注的筹码量
	 * 
	 * @param map
	 * @return
	 */
	private Long chipStatics(Map<Long, Long> map) {
		Set<Entry<Long, Long>> set = map.entrySet();
		Iterator<Entry<Long, Long>> it = set.iterator();
		Entry<Long, Long> entry = null;
		Long cashes = 0L;
		while (it.hasNext()) {
			entry = it.next();
			cashes += entry.getKey() * entry.getValue();
		}
		return cashes;
	}

	/**
	 * 计算单门押注的筹码量Map<筹码构成,构成的数量>
	 * 
	 * @param map
	 * @param chips
	 * @return
	 */
	Map<String, String> chipKeep(Map<String, String> map, Integer chips) {
		if (Arrays.asList(Definition.CHIPSET).contains(chips)) {
			if (map.get(chips) != null) {
				map.put(chips.toString(), (Integer.valueOf(map.get(chips)) + 1) + "");
			} else {
				map.put(chips.toString(), 1 + "");
			}
		}
		return map;
	}

	/**
	 * 真人玩家自然开奖概率(随机)
	 * 
	 * @return
	 */
	private PrizeEntry prizeRules() {
		Map<String, PrizeEntry> entry = GameCarServiceImpl.PRIZESET;
		Random random = new Random();
		// Integer rcount = 0;
		Integer result = random.nextInt(1000);
		while (result < 1 || result > 1000) {
			result = random.nextInt(1000);
			// System.out.println("随机次数为" + ++rcount);
		}
		if (result >= 1 && result <= 199) {
			return entry.get(PrizeItem.MINVW.getItem());
		}
		if (result >= 200 && result <= 398) {
			return entry.get(PrizeItem.MINBMW.getItem());
		}
		if (result >= 399 && result <= 597) {
			return entry.get(PrizeItem.MINBENZ.getItem());
		}
		if (result >= 598 && result <= 796) {
			return entry.get(PrizeItem.MINPORSCHE.getItem());
		}
		if (result >= 797 && result <= 895) {
			return entry.get(PrizeItem.BIGVW.getItem());
		}
		if (result >= 896 && result <= 944) {
			return entry.get(PrizeItem.BIGBMW.getItem());
		}
		if (result >= 945 && result <= 976) {
			return entry.get(PrizeItem.BIGBENZ.getItem());
		}
		if (result >= 977 && result <= 1000) {
			return entry.get(PrizeItem.MINPORSCHE.getItem());
		}
		return null;
	}

	/**
	 * 玩家坐庄,闲家有机器人时,返回随机出现的庄家返奖率
	 * 
	 * @return
	 */
	private Float returnRewardRate(Float min, Float max) {
		Integer num = MathUtil.random(1, 100);
		Float result = num * 0.01f;
		Float interzone1 = ConstantPool.BETPROBABLY1 + ConstantPool.BETPROBABLY2;
		Float interzone2 = interzone1 + ConstantPool.BETPROBABLY3;
		Float interzone3 = interzone2 + ConstantPool.BETPROBABLY4;
		Float interzone4 = interzone3 + ConstantPool.BETPROBABLY5;
		Float interzone5 = interzone4 + ConstantPool.BETPROBABLY6;
		if (result > 0 && result <= ConstantPool.BETPROBABLY1) {
			return min;
		}
		if (result > ConstantPool.BETPROBABLY1 && result <= interzone1) {
			return ConstantPool.ROBOTINRATE1;
		}
		if (result > interzone1 && result <= interzone2) {
			return ConstantPool.ROBOTINRATE2;
		}
		if (result > interzone2 && result <= interzone3) {
			return ConstantPool.ROBOTINRATE3;
		}
		if (result > interzone3 && result <= interzone4) {
			return ConstantPool.ROBOTINRATE4;
		}
		if (result > interzone4 && result <= interzone5) {
			return max;
		}
		return min;
	}

	/**
	 * 玩家坐庄中玩家中有机器人的开奖规则
	 * 
	 * @return
	 */
	private PrizeEntry robotLossRation() {
		ConcurrentHashMap<String, Map<Long, Long>> robotbetsmap = CarCache.ROBOTBETSMAP;
		Iterator<Entry<String, Map<Long, Long>>> iterator = robotbetsmap.entrySet().iterator();
		TreeMap<Float, String> lossRations = new TreeMap<Float, String>();
		Entry<String, Map<Long, Long>> entry = null;
		Entry<Float, String> sortentry = null;
		PrizeEntry prizeEntry = null;
		Map<Long, Long> map = null;
		Float lossRation = 0f;
		String item = "";
		Long staticsChips = 0L;
		while (iterator.hasNext()) {
			entry = iterator.next();
			item = entry.getKey();
			map = entry.getValue();
			staticsChips = chipStatics(map);
			lossRation = (float) staticsChips * GameCarServiceImpl.PRIZESET.get(item).getOdds() / (float) CarCache.ROBOTSBETCHIPS;
			lossRations.put(lossRation, item);
		}
		Float rewardRate = returnRewardRate(lossRations.firstKey(), lossRations.lastKey());
		if (rewardRate.floatValue() == lossRations.firstKey().floatValue()) {
			prizeEntry = GameCarServiceImpl.PRIZESET.get(lossRations.firstEntry().getValue());
		}
		if (rewardRate.floatValue() == lossRations.lastKey().floatValue()) {
			prizeEntry = GameCarServiceImpl.PRIZESET.get(lossRations.lastEntry().getValue());
		}
		Iterator<Entry<Float, String>> it = lossRations.entrySet().iterator();
		TreeMap<Float, String> positiveMap = new TreeMap<Float, String>();
		TreeMap<Float, String> negativeMap = new TreeMap<Float, String>();
		Float temp = 0f;
		while (it.hasNext()) {
			sortentry = it.next();
			temp = sortentry.getKey() - rewardRate;
			if (temp >= 0) {
				positiveMap.put(temp, sortentry.getValue());
			} else {
				negativeMap.put(-temp, sortentry.getValue());
			}
		}
		if (!positiveMap.isEmpty() && !negativeMap.isEmpty()) {
			if (positiveMap.firstKey() <= negativeMap.firstKey()) {
				prizeEntry = GameCarServiceImpl.PRIZESET.get(positiveMap.firstEntry().getValue());
			} else {
				prizeEntry = GameCarServiceImpl.PRIZESET.get(negativeMap.firstEntry().getValue());
			}
		}
		if (!positiveMap.isEmpty() && negativeMap.isEmpty()) {
			prizeEntry = GameCarServiceImpl.PRIZESET.get(positiveMap.firstEntry().getValue());
		}
		if (positiveMap.isEmpty() && !negativeMap.isEmpty()) {
			prizeEntry = GameCarServiceImpl.PRIZESET.get(negativeMap.firstEntry().getValue());
		}
		return prizeEntry;
	}

	/**
	 * 玩家坐庄,闲家有机器人时,根据返奖率返回押注金额
	 * 
	 * @param rewardRate
	 * @return
	 */
	public Integer returnBetChips(Float rewardRate, Float min, Float max) {
		Random random = new Random();
		Integer num = null;
		if (rewardRate == min) {
			return ConstantPool.INTERZONE1;
		}
		if (rewardRate == ConstantPool.ROBOTINRATE1) {
			num = random.nextInt(20);
			return ConstantPool.INTERZONE1 + num * 1000;
		}
		if (rewardRate == ConstantPool.ROBOTINRATE2) {
			num = random.nextInt(20);
			return ConstantPool.INTERZONE2 + num * 1000;
		}
		if (rewardRate == ConstantPool.ROBOTINRATE3) {
			num = random.nextInt(20);
			return ConstantPool.INTERZONE3 + num * 1000;
		}
		if (rewardRate == ConstantPool.ROBOTINRATE4) {
			num = random.nextInt(30);
			return ConstantPool.INTERZONE4 + num * 1000;
		}
		if (rewardRate == max) {
			return ConstantPool.INTERZONE5;
		}
		return 0;
	}

	/**
	 * 投注随机概率,获取投注额占比
	 * 
	 * @return
	 */
	public Float itemBetrate() {
		Random random = new Random();
		Float num = random.nextInt(100) * 0.01f;
		Float level1 = ConstantPool.MINVWPROBABLY + ConstantPool.MINBMWPROBABLY;
		Float level2 = level1 + ConstantPool.MINBENZPROBABLY;
		Float level3 = level2 + ConstantPool.MINPORSCHEPROBABLY;
		Float level4 = level3 + ConstantPool.BIGVWPROBABLY;
		Float level5 = level4 + ConstantPool.BIGBMWPROBABLY;
		Float level6 = level5 + ConstantPool.BIGBENZPROBABLY;
		Float level7 = level6 + ConstantPool.BIGPORSCHEPROBABLY;
		if (num > 0 && num <= ConstantPool.MINVWPROBABLY) {
			return ConstantPool.MINVWRATE;
		}
		if (num > ConstantPool.MINVWPROBABLY && num <= level1) {
			return ConstantPool.MINBMWRATE;
		}
		if (num > level1 && num <= level2) {
			return ConstantPool.MINBENZRATE;
		}
		if (num > level2 && num <= level3) {
			return ConstantPool.MINPORSCHERATE;
		}
		if (num > level3 && num <= level4) {
			return ConstantPool.BIGVWRATE;
		}
		if (num > level4 && num <= level5) {
			return ConstantPool.BIGBMWRATE;
		}
		if (num > level5 && num <= level6) {
			return ConstantPool.BIGBENZRATE;
		}
		if (num > level6 && num <= level7) {
			return ConstantPool.BIGPORSCHERATE;
		}
		return null;
	}

	public Long getPlayerWinNum(List<PlayerWinVo> winList, int robot) {
		Long num = 0L;
		
		if (null != winList) {
			Map<Long, Long> robotAllSum = CarCache.BETROBOTCHIPS.get(PrizeItem.SUMCHIPS.getItem());
			Map<Long, Long> playerAllSum = CarCache.BETKINDPERPLAYER.get(PrizeItem.SUMCHIPS.getItem());
			for (PlayerWinVo winItem : winList) {
				if (null != winItem) {
					
					if (robot == winItem.getIsRobot()) {
						/**
						 * wtu.edit 2015-11-13 racing_car 表 playerWin结果为负时记录错误
						 * 
						 * 
						 */
						if (winItem.getWinChips() > 0)
						{
							num += winItem.getWinChips();
						}
						else
						{//结果为负数，用     总压注+ 纯利
							Long allBet=0L;
							try {
							/*if(robot==0)
							{
								allBet=playerAllSum.get(winItem.getPlayerfbId());
							}
							else
							{
								allBet=robotAllSum.get(winItem.getPlayerfbId());
							}*/
							
								num +=winItem.getWinChips();
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
							
							
						}
							
					}

				}
			}
		}
		return num;
	}

	/**
	 * 结算信息写入
	 * 
	 * @param winList
	 */
	public void writeWinLog(final String key, final List<PlayerWinVo> winList) {
		if (null != winList && !winList.isEmpty()) {
			LogicExecutorUtil.getLogicService().execute(new Runnable() {
				@Override
				public void run() {
					for (PlayerWinVo playerWinVo : winList) {
						if (null == playerWinVo)
							continue;
						try {
							Long num = playerWinVo.getWinChips();
							int isWin = num >= 1 ? 1 : 0;
							if (num != 0) {
								RacingCarWinLog log = new RacingCarWinLog();
								log.setFbId(playerWinVo.getPlayerfbId());
								log.setTime(new Date());
								log.setGameId(key);
								log.setNum(num);
								log.setIsRobot((null != playerWinVo.getIsRobot()) ? playerWinVo.getIsRobot() : 0);
								log.setIsWin(isWin);
								log.setCommission(null != playerWinVo.getCommission() ? playerWinVo.getCommission() : 0);
								AppContext.getBean(RacingCarWinLogDao.class).save(log);
							}
						} catch (Exception e) {
							e.printStackTrace();
							LOGGER.warn("playerWinVo:{},{}", playerWinVo.getPlayerfbId(), playerWinVo.getIsRobot());
							LOGGER.error("", e);
							continue;
						}

					}
				}
			});
		}

	}
}
