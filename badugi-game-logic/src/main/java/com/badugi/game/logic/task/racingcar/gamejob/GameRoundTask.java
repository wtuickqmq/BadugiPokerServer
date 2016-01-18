package com.badugi.game.logic.task.racingcar.gamejob;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;





import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;
import org.quartz.Scheduler;

import com.badugi.game.logic.task.GameTimerFactory;
import com.badugi.game.logic.task.racingcar.RacingCarGame;
import com.badugi.game.logic.task.racingcar.constants.GameStateName;
import com.badugi.game.logic.task.racingcar.state.StartState;

@PersistJobDataAfterExecution  
@DisallowConcurrentExecution
public class GameRoundTask implements Job{

	public GameRoundTask() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		// TODO 自动生成的方法存根
		StartState startState=(StartState) RacingCarGame.getIns().getGameStateMap().get(GameStateName.Start);
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		Integer count = (Integer) jobDataMap.get("count");  
        if(count==null){  
            count=0;  
        }  
        count++;
        if(count<25)
        {
        	startState.RobotBet();
        }
    		 
        startState.RoundSend(count);
       
       
        if(count>=30)
        {
        	count=0;
        	try {
        		Scheduler scheduler = GameTimerFactory.getDefaultScheduler();
            	scheduler.deleteJob(JobKey.jobKey("carGameTask"));
            	
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
        	
        	startState.getRacingCarGame().turnNextState(startState.getNextGameState());
        }
        jobDataMap.put("count", count);  
	}

}
