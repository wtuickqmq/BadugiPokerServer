package com.badugi.game.logic.task;

import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.joker.common.util.MathUtil;

public class GameTimerFactory {

	private static final Logger LOGGER = LoggerFactory.getLogger(GameTimerFactory.class);

	private static Scheduler scheduler = null;

	static {
		init();
	}

	public static void init() {
		try {
			StringBuffer name = new StringBuffer();
			name.append("logic_cron_");
			name.append(MathUtil.randInt(10000));
			scheduler = StdSchedulerFactory.getDefaultScheduler();
		} catch (Exception e) {
			LOGGER.warn("init exception:{}", e);
		}
	}

	public static Scheduler getDefaultScheduler() {
		return scheduler;
	}
}
