package com.badugi.game.logic.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.dao.RacingCarBetChipsDao;
import com.badugi.game.logic.dao.RacingCarInitDao;
import com.badugi.game.logic.model.cache.CarCache;
import com.badugi.game.logic.model.entity.RacingcarBetChips;
import com.badugi.game.logic.model.entity.RacingcarInit;
import com.badugi.game.logic.model.lobby.helper.GameCarHelper;
import com.badugi.game.logic.model.vo.robot.RobotVo;
import com.badugi.game.logic.model.vo.supreme.DealerStatus;
import com.badugi.game.logic.model.vo.supreme.PlayerInfoInSupremeRoom;
import com.badugi.game.logic.model.vo.supreme.PrizeEntry;
import com.badugi.game.logic.model.vo.supreme.PrizeItem;
import com.badugi.game.logic.model.vo.supreme.SimulateBet;
import com.badugi.game.logic.model.vo.supreme.SimulateBetMap;
import com.badugi.game.logic.service.GameCarService;
import com.badugi.game.logic.service.impl.GameCarServiceImpl;
import com.badugi.game.logic.util.AppContext;
import com.badugi.game.logic.util.IdGenerator;
import com.google.common.collect.Maps;
import com.joker.game.common.constant.Definition;
import com.joker.game.common.constant.EventDefinition;
import com.joker.game.db.redis.RedisLogin;

public class RacingcarMainThread extends Thread {

	private static final Logger Logger = LoggerFactory.getLogger(RacingcarMainThread.class);

	ScheduledExecutorService ses = Executors.newScheduledThreadPool(15);

	ScheduledExecutorService look = Executors.newScheduledThreadPool(10);

	@Override
	public void run() {
		// CarCache.BETDEADTIME = 0;
		//System.out.println("######进入小游戏控制主线程RacingcarMainThread");
		/*
		 * timer.schedule(new TimerTask() {
		 * 
		 * @Override public void run() {
		 * System.out.println("------开始小游戏,进入停止押注倒计时28秒-------"); new
		 * StartGameThread().start(); } },2000,40000);
		 */
		// Timer timer = new Timer(false);
		CarCache.STARTRACINGCAR = System.currentTimeMillis();

		// EventLoopGroup ses = new NioEventLoopGroup(2);
		ses.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				CarCache.RACINGCARID = IdGenerator.getNextId();
				Logger.info("游戏初始ID[{}]",CarCache.RACINGCARID);
				CarCache.STARTRACINGCAR = System.currentTimeMillis();
				RacingcarInit racingcarinit = AppContext.getBean(RacingCarInitDao.class).initRobotData(); // CarCache.SYSTEMREWARDPOOL.get("systemRewardPool");//系统奖池筹码量
				CarCache.REWAREPOOL = racingcarinit.getSystemPoolInitChips();
//				System.out.println("------重新设置每局游戏开始-------");
				CarCache.SUPREMEROOMS.clear(); // 清空游戏房间信息
				CarCache.MINVWCHIPS.clear(); // 清空小大众押注筹码信息
				CarCache.MINVWCHIPSMAP.clear();// 清空小大众押注筹码
				CarCache.MINBMWCHIPS.clear();// 清空小大众押注筹码
				CarCache.MINBMWCHIPSMAP.clear();// 清空小宝马单门押注筹码构成及数量
				CarCache.MINBENZCHIPS.clear(); // 清空小奔驰押注筹码数
				CarCache.MINBENZCHIPSMAP.clear();// 清空小奔驰单门押注筹码构成及数量
				CarCache.MINPORSCHECHIPS.clear();// 清空小保时捷押注筹码数
				CarCache.MINPORSCHECHIPSMAP.clear();// 清空小宝时捷单门押注筹码构成及数量
				CarCache.BIGVWCHIPS.clear();// 清空大大众押注筹码数
				CarCache.BIGVWCHIPSMAP.clear();// 清空大大众单门押注筹码构成及数量
				CarCache.BIGBMWCHIPS.clear();// 清空大宝马押注筹码数
				CarCache.BIGBMWCHIPSMAP.clear();// 清空大宝马单门押注筹码构成及数量
				CarCache.BIGBENZCHIPS.clear();// 清空大奔驰押注筹码数
				CarCache.BIGBENZCHIPSMAP.clear();// 清空大奔驰单门押注筹码构成及数量
				CarCache.BIGPORSCHECHIPS.clear();// 清空大保时捷押注筹码数
				CarCache.BIGPORSCHECHIPSMAP.clear();// 清空大宝时捷单门押注筹码构成及数量
				// CarCache.CHIPSSET.values().clear(); //清空8个门类中每门的押注筹码量
				CarCache.CHIPSSET.put(PrizeItem.MINVW.getItem(), 0L);
				CarCache.CHIPSSET.put(PrizeItem.MINBMW.getItem(), 0L);
				CarCache.CHIPSSET.put(PrizeItem.MINBENZ.getItem(), 0L);
				CarCache.CHIPSSET.put(PrizeItem.MINPORSCHE.getItem(), 0L);
				CarCache.CHIPSSET.put(PrizeItem.BIGVW.getItem(), 0L);
				CarCache.CHIPSSET.put(PrizeItem.BIGBMW.getItem(), 0L);
				CarCache.CHIPSSET.put(PrizeItem.BIGBENZ.getItem(), 0L);
				CarCache.CHIPSSET.put(PrizeItem.BIGPORSCHE.getItem(), 0L);
				// 清空每个门类中每位玩家的押注额
				CarCache.BETKINDPERPLAYER.put(PrizeItem.MINVW.getItem(), new HashMap<Long, Long>());
				CarCache.BETKINDPERPLAYER.put(PrizeItem.MINBMW.getItem(), new HashMap<Long, Long>());
				CarCache.BETKINDPERPLAYER.put(PrizeItem.MINBENZ.getItem(), new HashMap<Long, Long>());
				CarCache.BETKINDPERPLAYER.put(PrizeItem.MINPORSCHE.getItem(), new HashMap<Long, Long>());
				CarCache.BETKINDPERPLAYER.put(PrizeItem.BIGVW.getItem(), new HashMap<Long, Long>());
				CarCache.BETKINDPERPLAYER.put(PrizeItem.BIGBMW.getItem(), new HashMap<Long, Long>());
				CarCache.BETKINDPERPLAYER.put(PrizeItem.BIGBENZ.getItem(), new HashMap<Long, Long>());
				CarCache.BETKINDPERPLAYER.put(PrizeItem.BIGPORSCHE.getItem(), new HashMap<Long, Long>());
				CarCache.BETKINDPERPLAYER.put(PrizeItem.SUMCHIPS.getItem(), new HashMap<Long, Long>());
				
				
				CarCache.EACHWINSUMCHIPS.put(PrizeItem.SUMCHIPS.getItem(), 0L);// 清空每局游戏闲家押注总量
				CarCache.WINPLAYERSINFO.clear(); // 清空当前局获胜赢闲家信息
				CarCache.WEALTHLIST.clear(); // 清空该局押中奖项的闲家信息
				// CarCache.ROBOTVO.clear(); //清空当前局机器人
				CarCache.REMITTINFO.clear();// 清空该局所有闲家押注信息(包括押中奖者和未押中奖者)
				CarCache.BETFULLITEMS.clear();// 清空当前局中押注满的门类
				Definition.TIMEPOINTS.clear();
				CarCache.ROBOTSBETCHIPS = 0L;
				CarCache.BETCHIPSROBOTS.clear();// 清空每局押注机器人
				CarCache.BETROBOTCHIPS.put(PrizeItem.MINVW.getItem(), new HashMap<Long, Long>()); // 清空押注机器人下注明细<item,<fbId,chips>>
				CarCache.BETROBOTCHIPS.put(PrizeItem.MINBMW.getItem(), new HashMap<Long, Long>());
				CarCache.BETROBOTCHIPS.put(PrizeItem.MINBENZ.getItem(), new HashMap<Long, Long>());
				CarCache.BETROBOTCHIPS.put(PrizeItem.MINPORSCHE.getItem(), new HashMap<Long, Long>());
				CarCache.BETROBOTCHIPS.put(PrizeItem.BIGVW.getItem(), new HashMap<Long, Long>());
				CarCache.BETROBOTCHIPS.put(PrizeItem.BIGBMW.getItem(), new HashMap<Long, Long>());
				CarCache.BETROBOTCHIPS.put(PrizeItem.BIGBENZ.getItem(), new HashMap<Long, Long>());
				CarCache.BETROBOTCHIPS.put(PrizeItem.BIGPORSCHE.getItem(), new HashMap<Long, Long>());
				CarCache.BETROBOTCHIPS.put(PrizeItem.SUMCHIPS.getItem(), new HashMap<Long, Long>());
				
				CarCache.ROBOTCHIPS.put(PrizeItem.MINVW.getItem(), 0L);
				CarCache.ROBOTCHIPS.put(PrizeItem.MINBMW.getItem(), 0L);
				CarCache.ROBOTCHIPS.put(PrizeItem.MINBENZ.getItem(), 0L);
				CarCache.ROBOTCHIPS.put(PrizeItem.MINPORSCHE.getItem(), 0L);
				CarCache.ROBOTCHIPS.put(PrizeItem.BIGVW.getItem(), 0L);
				CarCache.ROBOTCHIPS.put(PrizeItem.BIGBMW.getItem(), 0L);
				CarCache.ROBOTCHIPS.put(PrizeItem.BIGBENZ.getItem(), 0L);
				CarCache.ROBOTCHIPS.put(PrizeItem.BIGPORSCHE.getItem(), 0L);
				;// 清空机器人的每门押注
				Definition.TIMEPOINTS.putAll(Definition.TIMEPOINTSBACKUP); // 重置30个下注时间点下注数
				CarCache.ROBOTBETSMAP.put(PrizeItem.MINVW.getItem(), new HashMap<Long, Long>()); // 重置系统押注筹码详细信息
				CarCache.ROBOTBETSMAP.put(PrizeItem.MINBMW.getItem(), new HashMap<Long, Long>());
				CarCache.ROBOTBETSMAP.put(PrizeItem.MINBENZ.getItem(), new HashMap<Long, Long>());
				CarCache.ROBOTBETSMAP.put(PrizeItem.MINPORSCHE.getItem(), new HashMap<Long, Long>());
				CarCache.ROBOTBETSMAP.put(PrizeItem.BIGVW.getItem(), new HashMap<Long, Long>());
				CarCache.ROBOTBETSMAP.put(PrizeItem.BIGBMW.getItem(), new HashMap<Long, Long>());
				CarCache.ROBOTBETSMAP.put(PrizeItem.BIGBENZ.getItem(), new HashMap<Long, Long>());
				CarCache.ROBOTBETSMAP.put(PrizeItem.BIGPORSCHE.getItem(), new HashMap<Long, Long>());
				// System.out.println("CarCache.STARTRACINGCAR = System.currentTimeMillis()="
				// + CarCache.STARTRACINGCAR);
				/*
				 * if(CarCache.PLAYER_INFO_IN_SUPREMEROOM == null){//当前游戏内玩家
				 * CarCache.PLAYER_INFO_IN_SUPREMEROOM = new
				 * ConcurrentHashMap<Long,PlayerInfoInSupremeRoom>(); }
				 */
//				System.out.println("##进行庄家队列,庄家信息管理");
				new DealerThread().Start();

				CarCache.ROBOTINNING++;
				if (CarCache.ROBOTINNING > 3) {// 连续超过3局,重置局数设置,清空房间内所有玩家(包括机器人),(机器人每3局换一批)
					CarCache.PLAYER_INFO_IN_SUPREMEROOM.clear();
					CarCache.ROBOTINNING = 0;
				}
				PlayerInfoInSupremeRoom player = null;
				Enumeration<PlayerInfoInSupremeRoom> elements = CarCache.PLAYER_INFO_IN_SUPREMEROOM.elements();
				while (elements.hasMoreElements()) {// 若房间内有玩家(即在3局以内),则移除真实玩家,保留机器人
					player = elements.nextElement();
					if (!player.isRobot()) {
						CarCache.PLAYER_INFO_IN_SUPREMEROOM.remove(player.getFbId());
					}
				}
				Random rd = new Random();
				int random = -1;
				int playerSize = CarCache.PLAYER_INFO_IN_SUPREMEROOM.size();
				if (playerSize == 0) { // 若游戏房间有空,即连续超过3局,已清空房间,则重新生成机器人
					Integer size = CarCache.ROBOTSVO.size();
					List<RobotVo> list = new ArrayList<RobotVo>(CarCache.ROBOTSVO.values());
					Set<Integer> set = new HashSet<Integer>();
					RobotVo robot = null;
					do {
						do {
							random = rd.nextInt(size);
						} while (random < 0 || random >= size || set.contains(random));
						robot = list.get(random);
						if (robot != null && !CarCache.PLAYER_INFO_IN_SUPREMEROOM.containsKey(robot.getRobotFbId())) {
							CarCache.PLAYER_INFO_IN_SUPREMEROOM.put(robot.getRobotFbId(),
									new PlayerInfoInSupremeRoom(robot.getRobotFbId(), robot.getNickName(), true, robot.getImageUrl(), robot.getChips()));
							set.add(random);
						}
					} while (CarCache.PLAYER_INFO_IN_SUPREMEROOM.size() < 20);
				}
				Collection<PlayerInfoInSupremeRoom> betplayers = CarCache.PLAYER_INFO_IN_SUPREMEROOM.values();
				PlayerInfoInSupremeRoom[] playersArray = new PlayerInfoInSupremeRoom[6];// 取游戏房间内的6个机器人为下注者
				PlayerInfoInSupremeRoom plsr = null;
				playersArray = betplayers.toArray(playersArray);
				do {
					random = rd.nextInt(betplayers.size());
					plsr = playersArray[random];
					CarCache.BETCHIPSROBOTS.put(plsr.getFbId(), plsr);
				} while (CarCache.BETCHIPSROBOTS.size() <= 6);
				Long[] fbIds = new Long[CarCache.BETCHIPSROBOTS.size()];
				final Long[] fbIdArray = CarCache.BETCHIPSROBOTS.keySet().toArray(fbIds);// 押注者FbId
				List<Integer> seconds = new ArrayList<Integer>(); // 15个下注定时时间
				do {
					do {
						random = rd.nextInt(20);
					} while (random < 2 || random >= 20);
					seconds.add(random);
				} while (seconds.size() < 15);
				for (Integer second : seconds) {// 确定投注点及投注点投注次数
					if (Definition.TIMEPOINTS.containsKey(second)) {
						Definition.TIMEPOINTS.put(second, Definition.TIMEPOINTS.get(second) + 1);
					}
				}
				Iterator<Integer> it = Definition.TIMEPOINTS.values().iterator();// 移除没有投注的时间点
				while (it.hasNext()) {
					if (it.next() == 0) {
						it.remove();
					}
				}
				Set<Integer> keysets = Definition.TIMEPOINTS.keySet();
				Integer[] keyarray = new Integer[keysets.size()];
				keyarray = keysets.toArray(keyarray);
                //wtu.add
				GameCarHelper.InitItem();
				// EventLoopGroup sese = new NioEventLoopGroup(15);

				int robotSize = 1;// 模拟下注的人数

				for (int i = 0; i < robotSize; i++) {
					Runnable innerRunnable = null;
					for (final Integer time : keyarray) { // && count <
															// keysets.size()
						innerRunnable = new Runnable() {
							@Override
							public void run() {
								Random rd = new Random();
								int random = -1;
								String item = "";
								Long chip = 0L;
								Long fbId = null;
								SimulateBetMap simulatebetMap = null;
								for (int i = 0; i < Definition.TIMEPOINTS.get(time) * 4; i++) {
									do {
										random = rd.nextInt(8); // 随机产生8种投注门中的一门
										if (random >= 4) {// 若产生投注为大门类,则再随机(优先产生小门类,小门类概率为大门类两倍)
											random = rd.nextInt(8);
										}
									} while (random < 0 || random >= 8);
									item = GameCarServiceImpl.PRIZEARRAY[random];
									do {
										random = rd.nextInt(10);
									} while (random < 0 || random >= 10);
									chip = Definition.SUBCHIPSET[random].longValue();
									CarCache.ROBOTSBETCHIPS += chip;
									if (CarCache.ROBOTCHIPS.get(item) == null) {
										CarCache.ROBOTCHIPS.put(item, 0L);
									} else {
										CarCache.ROBOTCHIPS.put(item, CarCache.ROBOTCHIPS.get(item) + chip);
									}
									
									do {
										random = rd.nextInt(CarCache.BETCHIPSROBOTS.size());
									} while (random < 0 || random >= CarCache.BETCHIPSROBOTS.size());
									
									
									Map<Long, Long> map = CarCache.BETROBOTCHIPS.get(item);
									if (map != null) {
										fbId = fbIdArray[random];
										if (map.get(fbId) != null) {
											map.put(fbId, map.get(fbId) + chip);
										} else {
											map.put(fbId, chip);
										}
									} else {
										map = new HashMap<Long, Long>();
										map.put(fbId, chip);
									}
									;
									
									CarCache.BETROBOTCHIPS.put(item, map);// 押注机器人筹码明细
									Map<Long, Long> sumMap=CarCache.BETROBOTCHIPS.get(PrizeItem.SUMCHIPS.getItem());
									if (sumMap.get(fbId) != null) {
										sumMap.put(fbId, sumMap.get(fbId) + chip);
									}
									else
									{
										sumMap.put(fbId, chip);
									}

									if (CarCache.ROBOTBETSMAP.get(item) == null) {
										CarCache.ROBOTBETSMAP.put(item, new HashMap<Long, Long>());
									}
									if (CarCache.ROBOTBETSMAP.get(item).get(chip) == null) {
										CarCache.ROBOTBETSMAP.get(item).put(chip, 1L);
									} else {
										CarCache.ROBOTBETSMAP.get(item).put(chip, CarCache.ROBOTBETSMAP.get(item).get(chip) + 1L);
									}
									
									//GameCarHelper.betRtaCalc();
									
									
									Map<String, Long> itemChips = itemChips();
									Map<String, Long> simulateBetLimit = simulateBetLimit();
									simulatebetMap = new SimulateBetMap(item, chip, itemChips.get(item), betIsFull(simulateBetLimit, chip), betIsExceeding(simulateBetLimit, chip));
									writeDateToChannel(new SimulateBet(EventDefinition.EVENT_SYSTEM_BET, simulatebetMap));
									
									
									RacingcarBetChips racingcarbetchips = new RacingcarBetChips( chip.intValue(), fbId , String.valueOf(GameCarHelper.getItemSort(item)),
											CarCache.RACINGCARID, CarCache.CURRENTDEALER.element().getFbId());
								
									AppContext.getBean(RacingCarBetChipsDao.class).saveRacingcarBetChips(racingcarbetchips);
								}
							}
						};
						ses.schedule(innerRunnable, time, TimeUnit.SECONDS);
					}
				}
				// 广播游戏开始消息到所有客户端
				// look.scheduleAtFixedRate(new Runnable() {
				// @Override
				// public void run() {
				// if (!DealerThread.currentThread().isAlive()) {
				// new LaunchRacingcarThread().start(); // 广播游戏开始消息到所有客户端
				// }
				// }
				// }, 0, 1, TimeUnit.SECONDS);

				// List<Integer> chipbets = new
				// ArrayList<Integer>();//30秒内随机60个投注筹码
				// List<String> items = new
				// ArrayList<String>();//模拟下注的筹码类别60个,随机产生60个11种筹码值中一个
				// }},1L,45L,TimeUnit.SECONDS);
			}
		}, 1L, 45L, TimeUnit.SECONDS);
		// ses.scheduleAtFixedRate(new LaunchThread(),new
		// Date(CarCache.STARTRACINGCAR),45000,TimeUnit.MILLISECONDS;
		// Timer stopTimer = new Timer(false);
		ses.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				Logger.debug("该局机器人总押注为:" + CarCache.ROBOTSBETCHIPS + "模拟下注完成,每门押注筹码为:" + itemChips() + "每门是否满:" + betIsFull(simulateBetLimit(), 0l) + "每门是否超限:"
						+ betIsExceeding(simulateBetLimit(), 0l));
				new BetStopThread().start();
				Logger.debug("-------BetStopThread停止接收筹码,开始跑灯--------");
				new SettleAccountThread().start();
				// }},/*CarCache.STARTRACINGCAR+*/31L,45L,TimeUnit.SECONDS);//
				// 设定指定的时间time,此处为30000毫秒
			}
		},/* CarCache.STARTRACINGCAR+ */31L, 45L, TimeUnit.SECONDS);// 设定指定的时间time,此处为30000毫秒
		/*
		 * stopTimer.schedule(new TimerTask(){
		 * 
		 * @Override public void run() {
		 * 
		 * } }, new Date(CarCache.STARTRACINGCAR + 32000),45000);
		 */
		/*
		 * timer.schedule(new TimerTask(){
		 * 
		 * @Override public void run() {
		 * System.out.println("-------SettleAccountThread停止跑灯,接收开奖结算结果--------"
		 * ); //LobbyService.channels.size(); //LobbyService.userChannel.size();
		 * System
		 * .out.println("LobbyService.channels.size()="+LobbyService.channels
		 * .size
		 * ()+"###LobbyService.userChannel.size()"+LobbyService.userChannel.
		 * size()); } }, new Date(CarCache.STARTRACINGCAR +35000),40000);
		 */
	}

	/**
	 * 计算每门押注上限
	 * 
	 * @param item
	 * @param chip
	 * @return
	 */
	protected Map<String, Long> simulateBetLimit() {
		Map<String, Long> betLimits = new HashMap<String, Long>();
		Iterator<DealerStatus> it = CarCache.CURRENTDEALER.iterator();
		Map<String, PrizeEntry> prizeset = GameCarServiceImpl.PRIZESET;
		Long sumChips = CarCache.EACHWINSUMCHIPS.get(PrizeItem.SUMCHIPS.getItem()) + CarCache.ROBOTSBETCHIPS;// 每局押注总筹码量
		DealerStatus ds = null;
		// Long dealerId = null;
		if (it.hasNext()) {
			ds = it.next();
			// dealerId = ds.getFbId();
		}
		;
		// 小大众押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.MINVW.getItem())) {
			long minvmBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.MINVW.getItem()).getOdds() == 0l ? 1000L
					: (((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.MINVW.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.MINVW.getItem(), minvmBetLimit);
		}
		// 小宝马押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.MINBMW.getItem())) {
			long minbmwBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.MINBMW.getItem()).getOdds() == 0l ? 1000L
					: (((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.MINBMW.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.MINBMW.getItem(), minbmwBetLimit);
		}
		// 小奔驰押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.MINBENZ.getItem())) {
			long minbenzBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.MINBENZ.getItem()).getOdds() == 0l ? 1000L : (((ds != null ? ds.getUpDealerChips()
					: 0) + sumChips) / prizeset.get(PrizeItem.MINBENZ.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.MINBENZ.getItem(), minbenzBetLimit);
		}
		// 小宝时捷押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.MINPORSCHE.getItem())) {
			long minporscheBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.MINPORSCHE.getItem()).getOdds() == 0l ? 1000L : (((ds != null ? ds
					.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.MINPORSCHE.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.MINPORSCHE.getItem(), minporscheBetLimit);
		}
		// 大大众押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.BIGVW.getItem())) {
			long bigvmBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.BIGVW.getItem()).getOdds() == 0l ? 1000L
					: (((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.BIGVW.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.BIGVW.getItem(), bigvmBetLimit);
		}
		// 大宝马押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.BIGBMW.getItem())) {
			long bigbmwBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.BIGBMW.getItem()).getOdds() == 0l ? 1000L
					: (((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.BIGBMW.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.BIGBMW.getItem(), bigbmwBetLimit);
		}
		// 大奔驰押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.BIGBENZ.getItem())) {
			long bigbenzBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.BIGBENZ.getItem()).getOdds() == 0l ? 1000L : (((ds != null ? ds.getUpDealerChips()
					: 0) + sumChips) / prizeset.get(PrizeItem.BIGBENZ.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.BIGBENZ.getItem(), bigbenzBetLimit);
		}
		// 大宝时捷押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.BIGPORSCHE.getItem())) {
			long bigporscheBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.BIGPORSCHE.getItem()).getOdds() == 0l ? 1000L : (((ds != null ? ds
					.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.BIGPORSCHE.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.BIGPORSCHE.getItem(), bigporscheBetLimit);
		}
		// System.out.println("RacingcarMainThread机器人模拟玩家押注+真人玩家押注当前押注筹码总额:"+sumChips+"庄家押注额为:"+(ds
		// != null ? ds.getUpDealerChips() :
		// 0)+"当前各门押注上限为:"+betLimits.toString());
		return betLimits;
	}

	/**
	 * 每门押注是否已满
	 * 
	 * @param map
	 * @return
	 */
	private Map<String, Boolean> betIsFull(Map<String, Long> map, Long chips) {
		Map<String, Boolean> betsIsFull = new HashMap<String, Boolean>();// 每门是否已经满,比如<minVW,true>,<bigVW,false>
		ConcurrentHashMap<String, Long> robotchips = CarCache.ROBOTCHIPS;
		ConcurrentHashMap<String, Long> chipsset = CarCache.CHIPSSET;
		if (map.containsKey(PrizeItem.MINVW.getItem())) {
			betsIsFull.put(PrizeItem.MINVW.getItem(), robotchips.get(PrizeItem.MINVW.getItem()) + chipsset.get(PrizeItem.MINVW.getItem()) + chips == map.get(PrizeItem.MINVW.getItem()));
		}
		if (map.containsKey(PrizeItem.MINBMW.getItem())) {
			betsIsFull.put(PrizeItem.MINBMW.getItem(), robotchips.get(PrizeItem.MINBMW.getItem()) + chipsset.get(PrizeItem.MINBMW.getItem()) + chips == map.get(PrizeItem.MINBMW.getItem()));
		}
		if (map.containsKey(PrizeItem.MINBENZ.getItem())) {
			betsIsFull.put(PrizeItem.MINBENZ.getItem(), robotchips.get(PrizeItem.MINBENZ.getItem()) + chipsset.get(PrizeItem.MINBENZ.getItem()) + chips == map.get(PrizeItem.MINBENZ.getItem()));
		}
		if (map.containsKey(PrizeItem.MINPORSCHE.getItem())) {
			betsIsFull.put(PrizeItem.MINPORSCHE.getItem(),
					robotchips.get(PrizeItem.MINPORSCHE.getItem()) + chipsset.get(PrizeItem.MINPORSCHE.getItem()) + chips == map.get(PrizeItem.MINPORSCHE.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGVW.getItem())) {
			betsIsFull.put(PrizeItem.BIGVW.getItem(), robotchips.get(PrizeItem.BIGVW.getItem()) + chipsset.get(PrizeItem.BIGVW.getItem()) + chips == map.get(PrizeItem.BIGVW.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGBMW.getItem())) {
			betsIsFull.put(PrizeItem.BIGBMW.getItem(), robotchips.get(PrizeItem.BIGBMW.getItem()) + chipsset.get(PrizeItem.BIGBMW.getItem()) + chips == map.get(PrizeItem.BIGBMW.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGBENZ.getItem())) {
			betsIsFull.put(PrizeItem.BIGBENZ.getItem(), robotchips.get(PrizeItem.BIGBENZ.getItem()) + chipsset.get(PrizeItem.BIGBENZ.getItem()) + chips == map.get(PrizeItem.BIGBENZ.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGPORSCHE.getItem())) {
			betsIsFull.put(PrizeItem.BIGPORSCHE.getItem(),
					robotchips.get(PrizeItem.BIGPORSCHE.getItem()) + chipsset.get(PrizeItem.BIGPORSCHE.getItem()) + chips == map.get(PrizeItem.BIGPORSCHE.getItem()));
		}
		return betsIsFull;
	}

	/**
	 * 每门押注是否已超押注上限
	 * 
	 * @param map
	 * @return
	 */
	private Map<String, Boolean> betIsExceeding(Map<String, Long> map, Long chips) {
		Map<String, Boolean> betIsExceeding = new HashMap<String, Boolean>();// 每门是否达到押注上限,比如<minVW,true>,<bigVW,false>
		ConcurrentHashMap<String, Long> robotchips = CarCache.ROBOTCHIPS;
		ConcurrentHashMap<String, Long> chipsset = CarCache.CHIPSSET;
		if (map.containsKey(PrizeItem.MINVW.getItem())) {
			betIsExceeding.put(PrizeItem.MINVW.getItem(), robotchips.get(PrizeItem.MINVW.getItem()) + chipsset.get(PrizeItem.MINVW.getItem()) + chips > map.get(PrizeItem.MINVW.getItem()));
		}
		if (map.containsKey(PrizeItem.MINBMW.getItem())) {
			betIsExceeding.put(PrizeItem.MINBMW.getItem(), robotchips.get(PrizeItem.MINBMW.getItem()) + chipsset.get(PrizeItem.MINBMW.getItem()) + chips > map.get(PrizeItem.MINBMW.getItem()));
		}
		if (map.containsKey(PrizeItem.MINBENZ.getItem())) {
			betIsExceeding.put(PrizeItem.MINBENZ.getItem(), robotchips.get(PrizeItem.MINBENZ.getItem()) + chipsset.get(PrizeItem.MINBENZ.getItem()) + chips > map.get(PrizeItem.MINBENZ.getItem()));
		}
		if (map.containsKey(PrizeItem.MINPORSCHE.getItem())) {
			betIsExceeding.put(PrizeItem.MINPORSCHE.getItem(),
					robotchips.get(PrizeItem.MINPORSCHE.getItem()) + chipsset.get(PrizeItem.MINPORSCHE.getItem()) + chips > map.get(PrizeItem.MINPORSCHE.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGVW.getItem())) {
			betIsExceeding.put(PrizeItem.BIGVW.getItem(), robotchips.get(PrizeItem.BIGVW.getItem()) + chipsset.get(PrizeItem.BIGVW.getItem()) + chips > map.get(PrizeItem.BIGVW.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGBMW.getItem())) {
			betIsExceeding.put(PrizeItem.BIGBMW.getItem(), robotchips.get(PrizeItem.BIGBMW.getItem()) + chipsset.get(PrizeItem.BIGBMW.getItem()) + chips > map.get(PrizeItem.BIGBMW.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGBENZ.getItem())) {
			betIsExceeding.put(PrizeItem.BIGBENZ.getItem(), robotchips.get(PrizeItem.BIGBENZ.getItem()) + chipsset.get(PrizeItem.BIGBENZ.getItem()) + chips > map.get(PrizeItem.BIGBENZ.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGPORSCHE.getItem())) {
			betIsExceeding.put(PrizeItem.BIGPORSCHE.getItem(),
					robotchips.get(PrizeItem.BIGPORSCHE.getItem()) + chipsset.get(PrizeItem.BIGPORSCHE.getItem()) + chips > map.get(PrizeItem.BIGPORSCHE.getItem()));
		}
		return betIsExceeding;
	}

	/**
	 * 模拟玩家下注
	 * 
	 * @param simulatebet
	 */
	private void writeDateToChannel(SimulateBet simulatebet) {
		AppContext.getBean(GameCarService.class).sendToAll(simulatebet);
		;
		// ChannelGroup channels = LobbyService.channels;
		//
		// // ConcurrentHashMap<Long,Channel> userChannel =
		// LobbyService.userChannel;
		// String msg = JSON.toJSONString(simulatebet);
		//
		// channels.writeAndFlush(msg).addListener(new ChannelFutureListener() {
		// @Override
		// public void operationComplete(ChannelFuture future) throws Exception
		// {
		// if (future.isSuccess()) {
		// Logger.debug(future.channel()+"RacingcarMainThread向玩家发送模拟押注消息成功");
		// System.out.println(future.channel()+"RacingcarMainThread向玩家发送模拟押注消息成功");
		// } else {
		// Channel channel = future.channel();
		// Throwable cause = future.cause();
		// Logger.error("RacingcarMainThread当前channel[{"+channel+"}]向玩家发送模拟押注消息失败.",cause);
		// System.out.println("RacingcarMainThread当前channel[{"+channel+"}]向玩家发送模拟押注消息失败."+cause);
		// //channel.close();
		// }
		// }
		// });

		// if(userChannel.size() > channels.size()){
		// Collection<Channel> channel = userChannel.values();
		// Iterator<Channel> it = channel.iterator();
		// while(it.hasNext()){
		// it.next().writeAndFlush(msg+"\n").addListener(new
		// ChannelFutureListener() {
		// @Override
		// public void operationComplete(ChannelFuture future) throws Exception
		// {
		// if (future.isSuccess()) {
		// Logger.debug(future.channel()+"RacingcarMainThread向玩家发送模拟押注消息成功");
		// System.out.println(future.channel()+"RacingcarMainThread向玩家发送模拟押注消息成功");
		// } else {
		// Channel channel = future.channel();
		// Throwable cause = future.cause();
		// Logger.error("RacingcarMainThread当前channel[{"+channel+"}]向玩家发送模拟押注消息失败.",cause);
		// System.out.println("RacingcarMainThread当前channel[{"+channel+"}]向玩家发送模拟押注消息失败."+cause);
		// //channel.close();
		// }
		// }
		// });;
		// }
		// }else{
		// channels.writeAndFlush(msg+"\n").addListener(new
		// ChannelFutureListener() {
		// @Override
		// public void operationComplete(ChannelFuture future) throws Exception
		// {
		// if (future.isSuccess()) {
		// Logger.debug(future.channel()+"RacingcarMainThread向玩家发送模拟押注消息成功");
		// System.out.println(future.channel()+"RacingcarMainThread向玩家发送模拟押注消息成功");
		// } else {
		// Channel channel = future.channel();
		// Throwable cause = future.cause();
		// Logger.error("RacingcarMainThread当前channel[{"+channel+"}]向玩家发送模拟押注消息失败.",cause);
		// System.out.println("RacingcarMainThread当前channel[{"+channel+"}]向玩家发送模拟押注消息失败."+cause);
		// //channel.close();
		// }
		// }
		// });;
		// }
	}
	
	

	/**
	 * 计算每门押注玩家筹码量+机器人押注筹码量
	 * 
	 * @param item
	 * @return
	 */
	private Map<String, Long> itemChips() {
		Map<String, Long> chipsMap = new HashMap<String, Long>();
		String[] prizearray = GameCarServiceImpl.PRIZEARRAY;
		Long chips = 0L;
		for (String key : prizearray) {
			chips = (CarCache.ROBOTCHIPS.get(key) != null ? CarCache.ROBOTCHIPS.get(key) : 0) + (CarCache.CHIPSSET.get(key) != null ? CarCache.CHIPSSET.get(key) : 0);
			chipsMap.put(key, chips);
		}
		return chipsMap;
	}

}
