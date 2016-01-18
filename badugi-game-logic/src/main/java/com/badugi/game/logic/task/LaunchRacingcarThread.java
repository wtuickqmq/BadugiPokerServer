package com.badugi.game.logic.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.dao.DrawRecordDao;
import com.badugi.game.logic.model.cache.CarCache;
import com.badugi.game.logic.model.domain.vo.flash.user.MsgSendVo;
import com.badugi.game.logic.model.lobby.helper.GameCarHelper;
import com.badugi.game.logic.model.utils.common.DateUtils;
import com.badugi.game.logic.model.vo.supreme.ConstantPool;
import com.badugi.game.logic.model.vo.supreme.DealerQueueVo;
import com.badugi.game.logic.model.vo.supreme.DealerStatus;
import com.badugi.game.logic.model.vo.supreme.StartRacingcarVo;
import com.badugi.game.logic.service.GameCarService;
import com.badugi.game.logic.service.impl.GameCarServiceImpl;
import com.badugi.game.logic.util.AppContext;
import com.badugi.game.logic.util.LogicChannelUtil;
import com.google.common.collect.Maps;
import com.joker.game.common.constant.Definition;
import com.joker.game.common.constant.EventDefinition;
import com.joker.game.db.redis.RedisLogin;

/**
 * 玩家申请上庄处理线程
 * 
 * @author fred.zhao
 *
 */
public class LaunchRacingcarThread {

	private static final Logger LOGGER = LoggerFactory.getLogger(LaunchRacingcarThread.class);

	public LaunchRacingcarThread() {
	}

	/**
	 * 获取上庄队列
	 * 
	 * @param userfund
	 * @return
	 */
	public void start() {
		Long begintime = AppContext.getBean(GameCarService.class).getBegintime();
		Long endtime = AppContext.getBean(GameCarService.class).getEndtime();
		Long time = System.currentTimeMillis();
		boolean flag = begintime != null && endtime != null;
		if (flag && time.compareTo(begintime) != -1 && time.compareTo(endtime) != 1) {
			Iterator<String> sessionList = AppContext.getBean(GameCarService.class).getSessionList().iterator();
			while(sessionList.hasNext()){
				String id = sessionList.next();
				// 维护期间，在新一轮的开始之前强制所有玩家推出小游戏
				AppContext.getBean(GameCarService.class).removeUser(id);
				
				String notify = GameCarServiceImpl.NOTIFY_EXIT;
				
				MsgSendVo msgvo = new MsgSendVo(Definition.NOTICES, notify, DateUtils.dateToString(new Date(endtime), DateUtils.PATTERN_YMDHMS));
				// 发送
				LogicChannelUtil.sendToTarget(msgvo, id);
				
			}
			return;
		}
		
		                                   
		DealerStatus currDealer = CarCache.CURRENTDEALER.peek();
		StartRacingcarVo startRacingcarVo = new StartRacingcarVo(EventDefinition.EVENT_LAUNCH_RACING_RETURN, Definition.RACINGCAR_SUCCESS_CODE, Definition.JOINRACINGCAR);
		startRacingcarVo.setCurrDealer(currDealer);
		
		long now = System.currentTimeMillis();
		long lastTime = CarCache.STARTRACINGCAR + CarCache.LASTINGTIME;

		int status = now >= lastTime ? -1 : (int) (lastTime - now) / 1000;

		LOGGER.debug("============================>lastTime:{} ,now:{} ,left time: {}", new Object[] { lastTime, now, status });
		try {
			
			List<String> drawrecords =CarCache.getDrawRecords(); //AppContext.getBean(DrawRecordDao.class).readUserDraw();
			LOGGER.debug("开始历史记录：{},",drawrecords,System.currentTimeMillis());
			ArrayList<DealerQueueVo> dealerlist = new ArrayList<DealerQueueVo>(CarCache.DEALERQUEUE.get(ConstantPool.DEALERQUEUE));

			ConcurrentLinkedQueue<DealerQueueVo> dealerqueue = dealerlist.size() > 10 ? new ConcurrentLinkedQueue<DealerQueueVo>(dealerlist.subList(0, 10)) : CarCache.DEALERQUEUE
					.get(ConstantPool.DEALERQUEUE);

			startRacingcarVo = new StartRacingcarVo(EventDefinition.EVENT_LAUNCH_RACING_RETURN, Definition.RACINGCAR_SUCCESS_CODE, Definition.JOINRACINGCAR, 0L, ConstantPool.MINCHIPS, 0.0,
					drawrecords, currDealer, dealerqueue, CarCache.WEALTHLIST.get(Definition.WEALTHKEY), status);

			startRacingcarVo.setIsPush(1);
			startRacingcarVo.setCount(AppContext.getBean(GameCarService.class).getSessionList().size());
			LOGGER.debug("实时在线信息："+AppContext.getBean(GameCarService.class).getSessionList());
			LOGGER.debug("实时在线人数："+startRacingcarVo.getCount());
			//
//			Set<String> waitList = AppContext.getBean(GameCarService.class).getWaitList();
//			if (!waitList.isEmpty()) {
//				for (String wait : waitList) {
//					AppContext.getBean(GameCarService.class).addSession(wait);
//				}
//				AppContext.getBean(GameCarService.class).getWaitList().removeAll(waitList);
//			}
			
			
			
		} catch (Exception e) {
			startRacingcarVo = new StartRacingcarVo(EventDefinition.EVENT_LAUNCH_RACING_RETURN, Definition.RACINGCAR_SUCCESS_CODE, Definition.JOINRACINGCAR);
			LOGGER.error("exception:{}", e);
		}
		AppContext.getBean(GameCarService.class).sendToAll(startRacingcarVo);

	}
	
	
	
}
