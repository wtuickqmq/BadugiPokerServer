package com.badugi.game.logic.task.racingcar.state;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.dao.RacingCarBetChipsDao;
import com.badugi.game.logic.model.cache.CarCache;
import com.badugi.game.logic.model.entity.RacingcarBetChips;
import com.badugi.game.logic.model.lobby.helper.GameCarHelper;
import com.badugi.game.logic.model.vo.supreme.PrizeItem;
import com.badugi.game.logic.model.vo.supreme.SimulateBet;
import com.badugi.game.logic.model.vo.supreme.SimulateBetMap;
import com.badugi.game.logic.service.GameCarService;
import com.badugi.game.logic.service.impl.GameCarServiceImpl;
import com.badugi.game.logic.task.GameTimerFactory;
import com.badugi.game.logic.task.racingcar.RacingCarGame;
import com.badugi.game.logic.task.racingcar.constants.GameStateName;
import com.badugi.game.logic.task.racingcar.gamejob.GameRoundTask;
import com.badugi.game.logic.util.AppContext;
import com.joker.game.common.constant.Definition;
import com.joker.game.common.constant.EventDefinition;


public class StartState extends GameState {
	private static final Logger LOGGER = LoggerFactory.getLogger(StartState.class);

	public StartState(RacingCarGame carGame) {
		super(carGame);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void init() {
		
	}

	public void begin() {
		LOGGER.debug("游戏开始状态【开始】");
		try {
			Scheduler scheduler = GameTimerFactory.getDefaultScheduler();
			scheduler.start();
			
			JobDetail job = JobBuilder.newJob(GameRoundTask.class).withIdentity("carGameTask").build();
			CronScheduleBuilder cb = CronScheduleBuilder.cronSchedule("0/1 * * * * ?");
			CronTrigger trigger = TriggerBuilder.newTrigger().withSchedule(cb).build();
			
			scheduler.scheduleJob(job, trigger);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		LOGGER.debug("游戏开始状态【结束】");
	}
	
	/**
	 * 机器人下注
	 */
	public void RobotBet(){
		Long[] fbIds = new Long[CarCache.BETCHIPSROBOTS.size()];
		final Long[] fbIdArray = CarCache.BETCHIPSROBOTS.keySet().toArray(fbIds);// 押注者FbId
		
		Random rd = new Random();
		int random = -1;
		String item = "";
		Long chip = 0L;
		Long fbId = null;
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
		};
		
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
		RacingcarBetChips racingcarbetchips = new RacingcarBetChips( chip.intValue(), fbId , String.valueOf(GameCarHelper.getItemSort(item)),
				CarCache.RACINGCARID, CarCache.CURRENTDEALER.element().getFbId());
		AppContext.getBean(RacingCarBetChipsDao.class).saveRacingcarBetChips(racingcarbetchips);
		
		//GameCarHelper.betRtaCalc();
		
		
	}
	/**
	 * 定时发送筹码变化到客户端
	 */
	public void RoundSend(int count)
	{
		LOGGER.debug("{} 系统----向-----客户端------>发送筹码",count);
		Map<String, Long> itemChips = GameCarHelper.itemChips();
		Map<String, Long> simulateBetLimit = GameCarHelper.simulateBetLimit();
		Long sumChips = CarCache.EACHWINSUMCHIPS.get(PrizeItem.SUMCHIPS.getItem()) + CarCache.ROBOTSBETCHIPS;// 每局押注总筹码量=玩家押注总量+机器人押注总量
		GameCarService gcs=AppContext.getBean(GameCarService.class);
		Map<String, Long> betLimits1 =gcs.betLimit(sumChips);// 本局下注上限筹码
		Map<String, Boolean> betIsExceeding1 = gcs.betIsExceeding(betLimits1, 0L);// 判断本局下注是否达上限
		SimulateBetMap simulatebetMap = new SimulateBetMap("", 0L , 0L ,itemChips, betIsExceeding1, betIsExceeding1);
		GameCarHelper.writeDateToChannel(new SimulateBet(EventDefinition.EVENT_SYSTEM_BET, simulatebetMap));
		
		GameCarHelper.betRtaCalc();
	}
	
	public RacingCarGame getRacingCarGame()
	{
		return this.getCarGame();
	}
	
	public GameStateName getGameStateName() {
		return GameStateName.Start;
	}


	@Override
	public void clear() {
		
	}
	
}
