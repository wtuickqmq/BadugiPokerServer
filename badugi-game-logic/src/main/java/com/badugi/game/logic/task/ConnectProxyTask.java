package com.badugi.game.logic.task;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.conf.LogicConfig;
import com.badugi.game.logic.model.proxy.LogicProxyClient;
import com.badugi.game.logic.util.LogicPropertyUtil;

public class ConnectProxyTask implements Job {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConnectProxyTask.class);;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			LOGGER.info("try reconnect to route server ...");
			LogicProxyClient.connect(LogicConfig.PROXY_TCP_HOST, LogicConfig.PROXY_TCP_PORT);;
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	public static void startCrontab() throws SchedulerException {
		Scheduler scheduler = GameTimerFactory.getDefaultScheduler();
		scheduler.start();
		boolean jobWork = LogicPropertyUtil.getBoolean("server.jobwork", true);
		if (jobWork) {
			{
				JobDetail job = JobBuilder.newJob(ConnectProxyTask.class).withIdentity("proxyTask").build();
				CronScheduleBuilder cb = CronScheduleBuilder.cronSchedule("0/15 * * * * ?");
				CronTrigger trigger = TriggerBuilder.newTrigger().withSchedule(cb).build();
				scheduler.scheduleJob(job, trigger);
			}

		}
	}

	public static void stopCrontab() throws SchedulerException {
		Scheduler scheduler = GameTimerFactory.getDefaultScheduler();
//		scheduler.shutdown();
		scheduler.deleteJob(JobKey.jobKey("proxyTask"));
		GameTimerFactory.init();
	}

}
