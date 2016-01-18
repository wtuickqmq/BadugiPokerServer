package com.badugi.game.logic.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

public final class LogicExecutorUtil {
	// private static final ThreadFactory logicThreadFactory = ;
	// private static final ThreadFactory channelThreadFactory = ;
	// private static final Executor defaultAdapterExecutor =
	// Executors.newCachedThreadPool(threadFactory);

	private static final ExecutorService LOGIC_SERVICE = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(),new ThreadFactoryBuilder().setNameFormat("route-logic-service-%d").build());

	private static final ExecutorService CHANNEL_SERVICE = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), new ThreadFactoryBuilder().setNameFormat("route-channel-service-%d")
			.build());

	public static final ExecutorService getLogicService() {
		return LOGIC_SERVICE;
	}

	public static final ExecutorService getChannelService() {
		return CHANNEL_SERVICE;
	}

}
