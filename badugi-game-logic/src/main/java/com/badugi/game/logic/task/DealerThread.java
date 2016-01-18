package com.badugi.game.logic.task;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.dao.RacingCarDealerDao;
import com.badugi.game.logic.helper.LobbyUserHelper;
import com.badugi.game.logic.model.cache.CarCache;
import com.badugi.game.logic.model.entity.RacingcarDealer;
import com.badugi.game.logic.model.lobby.helper.GameCarHelper;
import com.badugi.game.logic.model.vo.robot.RobotVo;
import com.badugi.game.logic.model.vo.supreme.ConstantPool;
import com.badugi.game.logic.model.vo.supreme.DealerQueueVo;
import com.badugi.game.logic.model.vo.supreme.DealerStatus;
import com.badugi.game.logic.model.vo.supreme.PlayerInfoInSupremeRoom;
import com.badugi.game.logic.service.GameCarService;
import com.badugi.game.logic.util.AppContext;
import com.badugi.game.logic.util.IdGenerator;
import com.joker.game.common.constant.EventDefinition;

/**
 * 坐庄庄家处理线程
 * 
 * @author qazwsxedc
 *
 */
public class DealerThread  {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerThread.class);

	public DealerThread() {
	}

	
	public void Start() {
		constructCurrentDealer();
		constructDealerQueue();
		DealerStatus ds = CarCache.CURRENTDEALER.peek(); // 当前庄家信息
		ds.setInning(ds.getInning() + 1);// 进入坐庄处理
		ConcurrentLinkedQueue<DealerQueueVo> dealerqueue = CarCache.DEALERQUEUE.get(ConstantPool.DEALERQUEUE);

		DealerQueueVo dev = dealerqueue.peek();
		if (ds.isRobot()) {
			if (dev != null && !dev.isRobot()) {// 若上庄队列中第一位为非机器人
				if (ds.getUpDealerChips() > ConstantPool.MINCHIPS) {
					// RacingcarInit sic = new RacingcarInit((long)
					// Math.floor(ds.getUpDealerChips() -
					// ConstantPool.MINCHIPS));
					// LOGGER.debug("机器人坐庄更新系统奖池" + (ds.getUpDealerChips() -
					// ConstantPool.MINCHIPS));
					// AppContext.getBean(RacingCarInitDao.class).updateRacing(sic);//
					// 更新系统奖池
				}
				ds = new DealerStatus(dev.getFbId(), dev.getFbName(), dev.getImageUrl(), dev.isRobot(), dev.getLobbyChips(), (long) Math.floor(dev.getUpChips()), 1, ConstantPool.LIMITINNING, false,
						false);
				CarCache.CURRENTDEALER.clear();
				CarCache.CURRENTDEALER.add(ds);
				CarCache.DEALERQUEUE.get(ConstantPool.DEALERQUEUE).poll();
				CarCache.PLAYER_INFO_IN_SUPREMEROOM.put(dev.getFbId(), new PlayerInfoInSupremeRoom(dev.getFbId(), dev.getFbName(), dev.isRobot(), dev.getImageUrl(), dev.getLobbyChips()));
			} else {
				if (ds.getInning() > ds.getLimitInning()) {
					ds.setInning(1);
				}
				if (ds.getUpDealerChips() < ConstantPool.MINCHIPS) {
					DealerQueueVo dq = constructRobot();
					CarCache.CURRENTDEALER.clear();
					ds = new DealerStatus(dq.getFbId(), dq.getFbName(), dq.getImageUrl(), dq.isRobot(), dq.getLobbyChips(), (long) Math.floor(dq.getUpChips()), 1, ConstantPool.LIMITINNING, false,
							false);
					CarCache.CURRENTDEALER.add(ds);
					CarCache.PLAYER_INFO_IN_SUPREMEROOM.put(dq.getFbId(), new PlayerInfoInSupremeRoom(dq.getFbId(), dq.getFbName(), dq.isRobot(), dq.getImageUrl(), dq.getLobbyChips()));
				}
			}
			// ds = null;
		} else {

			boolean isNotOpen = !AppContext.getBean(GameCarService.class).getIsOpen();

			boolean isDown = ds != null && ds.getUpDealerChips() < ConstantPool.MINCHIPS || ds.getInning() > ConstantPool.LIMITINNING || ds.isNextDownDealer();
			if (isNotOpen || isDown) {// 用户连续坐庄超过30庄
										// 或若庄家剩余上庄筹码小于最低上庄筹码,则当前庄家下庄,队列中下一个待上庄庄家上庄
				CarCache.CURRENTDEALER.clear();
				LOGGER.debug("玩家或者大厅筹码不够,或者坐庄超过30局,或者点击了下庄按钮,下局自动下庄");
				LobbyUserHelper.updateUserFund(ds.getFbId(), ds.getUpDealerChips().doubleValue());
				// LobbyUserHelper.sendLobbyUserFundChangeInfo(ds.getFbId(),
				// ds.getUpDealerChips(),
				// "庄家fbId="+ds.getFbId()+"本次坐庄下庄时赢取筹码"+ds.getUpDealerChips());
				if (CarCache.DEALERQUEUE.get(ConstantPool.DEALERQUEUE).size() > 0) {
					dev = CarCache.DEALERQUEUE.get(ConstantPool.DEALERQUEUE).poll();
				} else {
					dev = constructRobot();
				}
				ds = new DealerStatus(dev.getFbId(), dev.getFbName(), dev.getImageUrl(), dev.isRobot(), dev.getLobbyChips(), (long) Math.floor(dev.getUpChips()), 1, ConstantPool.LIMITINNING, false,
						false);
				CarCache.CURRENTDEALER.add(ds); // 当前庄家上庄信息,当前庄家上庄次数,仅保存当前唯一庄家信息
				CarCache.PLAYER_INFO_IN_SUPREMEROOM.put(dev.getFbId(), new PlayerInfoInSupremeRoom(dev.getFbId(), dev.getFbName(), dev.isRobot(), dev.getImageUrl(), dev.getLobbyChips()));
				LOGGER.debug("换庄ds.isNotRobot()###CarCache.CURRENTDEALER=" + CarCache.CURRENTDEALER.peek());
				// ds = null;
			} else if (ds != null && ds.getInning() >= ConstantPool.ENABLEINNING && ds.getInning() < ConstantPool.LIMITINNING) { // 用户在3庄到30庄之间,下庄按钮可用
				CarCache.CURRENTDEALER.clear();
				LOGGER.debug("用户在3庄到30庄之间,下庄按钮可用,下局不会自动下庄");
				ds = new DealerStatus(ds.getFbId(), ds.getFbName(), ds.getImageUrl(), ds.isRobot(), ds.getLobbyLeftChips(), (long) Math.floor(ds.getUpDealerChips()), ds.getInning(),
						ConstantPool.LIMITINNING, true, false,ds.getWining());
				CarCache.CURRENTDEALER.add(ds); // 当前庄家上庄信息,当前庄家上庄次数,仅保存当前唯一庄家信息
				LOGGER.debug("用户在3庄到30庄之间ds.isNotRobot()###CarCache.CURRENTDEALER=" + CarCache.CURRENTDEALER.peek());
				// ds = null;
			} else if (ds != null && ds.getInning() >= 1 && ds.getInning() < ConstantPool.ENABLEINNING) {
				CarCache.CURRENTDEALER.clear();
				LOGGER.debug("用户在1庄到3庄之间,下庄按钮不可用,下局不会自动下庄");
				ds = new DealerStatus(ds.getFbId(), ds.getFbName(), ds.getImageUrl(), ds.isRobot(), ds.getLobbyLeftChips(), (long) Math.floor(ds.getUpDealerChips()), ds.getInning(),
						ConstantPool.LIMITINNING, false, false,ds.getWining());
				CarCache.CURRENTDEALER.add(ds); // 当前庄家上庄信息,当前庄家上庄次数,仅保存当前唯一庄家信息
				LOGGER.debug("用户在1庄到3庄之间ds.isNotRobot()###CarCache.CURRENTDEALER=" + CarCache.CURRENTDEALER.peek());
				// ds = null;
			}
		}
		LOGGER.debug("当前庄家fbName=" + CarCache.CURRENTDEALER.peek().getFbName() + "###" + CarCache.CURRENTDEALER.peek().getInning() + "###" + CarCache.CURRENTDEALER.peek().isButtonEnable() + "###"
				+ CarCache.CURRENTDEALER.peek().isNextDownDealer()+" ###"+ds.getWining());
		RacingcarDealer rd = new RacingcarDealer(IdGenerator.getNextId(), CarCache.CURRENTDEALER.peek().getFbId(), CarCache.CURRENTDEALER.peek().getUpDealerChips(), CarCache.RACINGCARID);
		// RacingcarDealerDao.saveRacingCarDealer(rd); //保存庄家信息
		AppContext.getBean(RacingCarDealerDao.class).saveRacingCarDealer(rd);// 保存庄家信息
		// writeDateToChannel(CarCache.CURRENTDEALER.peek());

		new LaunchRacingcarThread().start();
		//实时监控获取庄家信息
		GameCarHelper.setDealerStatusInfo(ds);
		LOGGER.debug("DealerThread was run finish");
	}

	/**
	 * 写数据到netty channel
	 * 
	 * @param srVo
	 */
	void writeDateToChannel(DealerStatus ds) {
		ds.setCmd(EventDefinition.EVENT_UPDATE_DEALER);// update_dealer
		// String json = JSON.toJSONString(ds);
		// LogicChannelUtil.sendToAll(ds);
		AppContext.getBean(GameCarService.class).sendToAll(ds);
		// LobbyService.channels.writeAndFlush(json + "\n");
		LOGGER.debug("当前庄家为:" + CarCache.CURRENTDEALER.peek().getFbName() + ",当前上庄队列为:" + CarCache.DEALERQUEUE.get(ConstantPool.DEALERQUEUE).toString());
		// LOGGER.debug("############DealerThread channel.closeFuture()"+channel.closeFuture());
	}
	/**
	 * 构造当前庄家
	 */
	private void constructCurrentDealer() {
		DealerStatus ds = null;
		DealerQueueVo dqvo = null;
		ds = CarCache.CURRENTDEALER.peek();
		CarCache.CURRENTDEALER.clear();
		if (ds != null) {
			CarCache.CURRENTDEALER.add(ds);
		} else {
			dqvo = constructRobot();
			CarCache.CURRENTDEALER.add(new DealerStatus(dqvo.getFbId(), dqvo.getFbName(), dqvo.getImageUrl(), true, dqvo.getLobbyChips(), dqvo.getUpChips().longValue(), (Integer) 0,
					ConstantPool.LIMITINNING, false, false));
		}
	}

	/**
	 * 构造上庄队列
	 * 
	 * @return
	 */
	private void constructDealerQueue() {
		ConcurrentLinkedQueue<DealerQueueVo> dealerqueue = CarCache.DEALERQUEUE.get(ConstantPool.DEALERQUEUE);// 游戏上庄队列
		if (dealerqueue == null) {// 若上庄队列为空
			dealerqueue = new ConcurrentLinkedQueue<DealerQueueVo>();
			CarCache.DEALERQUEUE.put(ConstantPool.DEALERQUEUE, dealerqueue);
		}/*
		 * else if(dealerqueue.size() > 10){//上庄队列取前10个返回显示 dealerqueue = new
		 * ConcurrentLinkedQueue<DealerQueueVo>(new
		 * ArrayList<DealerQueueVo>(dealerqueue).subList(0, 10));
		 * CarCache.DEALERQUEUE.put(ConstantPool.DEALERQUEUE,dealerqueue); }
		 */
	}

	/**
	 * 构建robot dealer对象
	 * 
	 * @return
	 */
	private DealerQueueVo constructRobot() {
		DealerQueueVo dealer = null;
		ConcurrentHashMap<Long, RobotVo> robots = CarCache.ROBOTSVO;
		// String dealerId = UUID.randomUUID().toString();//UUID生成庄家ID
		/**
		 * wtu.edit 2015-11-26 机器人上庄金额和最小上庄金额分开
		 * 
		 */
		Double minChips =10000000.0;// ConstantPool.MINCHIPS == null ? 1000000 : ConstantPool.MINCHIPS;
		// UserBasic ub = null;
		RobotVo robot = null;
		// Iterator<RobotVo> it = null;
		try {// 小游戏上庄最低筹码
			if (robots != null && robots.size() >= 1) {

				// List<RobotVo> list = new ArrayList<RobotVo>(robots.values());
				// Random random = new Random();
				// int number = -1;
				// do {
				// number = random.nextInt(CarCache.ROBOTSVO.size());
				// } while (number < 0 && number >= CarCache.ROBOTSVO.size());
				// robot = list.get(number);
				if (null == robot) {
					robot = CarCache.ROBOTSVO.get(3000000000001529L);// 取fbId=2000000000001127,nickname=飞鸟与鱼的爱情作为机器人坐庄
					// robot.setNickName("官庄");
				}
				if (robot != null) {
					// RacingcarInit sic = new
					// RacingcarInit(-minChips.longValue());
					// LOGGER.debug("构造机器人坐庄从系统奖池中取出200W筹码:" +
					// -minChips.longValue());
					// AppContext.getBean(RacingCarInitDao.class).updateRacing(sic);//
					// 更新系统奖池
					/**
					 * 
					 * wtu.edit 2015-11-26 
					 * 系统庄名称改为  JOKER （原为 robot.getNickName()）
					 * 
					 */
					dealer = new DealerQueueVo(robot.getRobotFbId(), "JOKER" , robot.getImageUrl(), true, minChips, robot.getChips(), System.currentTimeMillis());
				}
			}/*
			 * else{ ub = UserBasicDao.findRobotUSer();// new
			 * Random().nextInt()&0xFFFFFFFF; //生成16位随机整数 RacingcarInit
			 * supInitConf = RacingcarInitDao.initRobotData();
			 * while(supInitConf.getRobotInitChips().longValue() <
			 * ConstantPool.MINROBOTCHIPS.longValue()){
			 * RacingcarInitDao.resetRacingRobotChips(); supInitConf =
			 * RacingcarInitDao.initRobotData(); } robot = new
			 * RobotVo(robot.getRobotFbId
			 * (),robot.getNickName(),minChips,supInitConf
			 * .getRobotInitChips()-minChips
			 * ,robot.getImageUrl(),0,System.currentTimeMillis()); LOGGER.debug
			 * ("DealerThread robot="+robot.getRobotFbId()+"##"
			 * +robot.getNickName()+"##"+robot.getImageUrl()); LOGGER.debug
			 * ("DealerThread supInitConf="+supInitConf.getRobotInitChips
			 * ()+"minChips="+minChips);
			 * CarCache.ROBOTSVO.put(robot.getRobotFbId(), robot); dealer = new
			 * DealerQueueVo
			 * (robot.getRobotFbId(),robot.getNickName(),robot.getImageUrl
			 * (),true,minChips,robot.getInitChips()-minChips); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dealer;
	}

}
