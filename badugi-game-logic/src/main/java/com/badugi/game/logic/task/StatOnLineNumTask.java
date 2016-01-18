package com.badugi.game.logic.task;

import java.sql.Timestamp;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.dao.UserOnLineNumDao;
import com.badugi.game.logic.model.entity.UserOnLineNum;
import com.badugi.game.logic.service.GameCarService;
import com.badugi.game.logic.util.AppContext;

public class StatOnLineNumTask implements Job{
	private static final Logger LOGGER = LoggerFactory.getLogger(StatOnLineNumTask.class);

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		try {
			int size = AppContext.getBean(GameCarService.class).getSessionList().size();
			
			UserOnLineNum useronline = new UserOnLineNum(); 
			useronline.setNum(size);
			useronline.setCreate_time(new Timestamp(System.currentTimeMillis()));
			
			AppContext.getBean(UserOnLineNumDao.class).save(useronline);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		
	}
	
	public static void statOnLineNum() throws SchedulerException {
		Scheduler scheduler = GameTimerFactory.getDefaultScheduler();
		scheduler.start();
	    JobDetail job = JobBuilder.newJob(StatOnLineNumTask.class).withIdentity("carGameOnline").build();
		CronScheduleBuilder cb = CronScheduleBuilder.cronSchedule("0 0/5 * * * ?");
		CronTrigger trigger = TriggerBuilder.newTrigger().withSchedule(cb).build();
		scheduler.scheduleJob(job, trigger);
	}
	
	
	

}
