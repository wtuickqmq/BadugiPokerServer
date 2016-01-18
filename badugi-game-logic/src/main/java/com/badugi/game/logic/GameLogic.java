package com.badugi.game.logic;

import java.io.IOException;
import java.net.UnknownHostException;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.badugi.game.logic.conf.SpringConfig;
import com.badugi.game.logic.helper.ExpHelper;
import com.badugi.game.logic.helper.LobbyUserHelper;
import com.badugi.game.logic.helper.MatchInit;
import com.badugi.game.logic.model.lobby.helper.GameCarActiveHelper;
import com.badugi.game.logic.model.proxy.LogicProxyClient;
import com.badugi.game.logic.task.ConnectProxyTask;
import com.badugi.game.logic.task.RacingcarMainThread;
import com.badugi.game.logic.task.StatOnLineNumTask;
import com.badugi.game.logic.task.racingcar.RacingCarGame;
import com.badugi.game.logic.util.AppContext;
import com.badugi.game.logic.util.CacheUtil;
import com.badugi.game.logic.util.CallBackUtil;
import com.badugi.game.logic.util.LogicPropertyUtil;
import com.joker.common.util.MacUtil;
import com.joker.common.util.RootUtil;
import com.joker.common.util.SocketUtil;
import com.joker.game.db.redis.RedisLogin;

public final class GameLogic {

	private static final Logger LOGGER = LoggerFactory.getLogger(GameLogic.class);

	public static void main(String[] args) throws Exception {
		LOGGER.info("client init...");
		long start = System.currentTimeMillis();
		startInit();
		startRPC();
		initLocalCache();
		initThread();
		CallBackUtil.initCallBack();
		testdb();
		//Long oldchips=-1L;
		//String nick=LobbyUserHelper.getUserNick("2000000000001001");
		//LOGGER.info(" -->"+nick);
	LOGGER.info("active {}",	GameCarActiveHelper.isMulActiveOff());
		long end = System.currentTimeMillis();
		LOGGER.info("pid={}, mac={}, use={}ms", new Object[] { RootUtil.getProcessID(), MacUtil.getMacAddress(), (end - start) });
	}

	private static boolean isExtension() {
		String room = LogicPropertyUtil.getString("logic.room", "rpc");
		
		if ("extension".equalsIgnoreCase(room)) {
			return true;
		}
		return false;
	}

	private static void initThread() {
		//
		
		
		if (isExtension()) {
			/**
			 * wtu.edit 2015-12-11 改用新的结构执行小游戏
			 */
			MatchInit.initRacingCarRobots();
			RacingCarGame.getIns();
			//new RacingcarMainThread().start();
			try {
				StatOnLineNumTask.statOnLineNum();
			} catch (SchedulerException e) {
				LOGGER.warn("", e);
			}
		}
	}

	

	@SuppressWarnings("resource")
	private static void startInit() {
		// AbstractApplicationContext context = new
		// AnnotationConfigApplicationContext(RouteConfig.class);
		// context.registerShutdownHook();
		new AnnotationConfigApplicationContext(SpringConfig.class).registerShutdownHook();
	}

	private static void startRPC() throws UnknownHostException, Exception {
		String host = LogicPropertyUtil.getString("proxy.tcp.host", "127.0.0.1");
		int port = LogicPropertyUtil.getInteger("proxy.tcp.port", 20001);
		if (!SocketUtil.isStart(host, port)) {
			LOGGER.error("can't connect to proxy server host={} ,port={} !", host, port);
			ConnectProxyTask.startCrontab();
		} else {
			LogicProxyClient.connect(host, port);
		}
	}
	

	private static void initLocalCache() {
		try {
			CacheUtil.init();
			ExpHelper.initExp();
		} catch (IOException e) {
			LOGGER.warn("", e);
		}
	}
	
	private static void testdb()
	{
		RedisLogin redisBet = AppContext.getBean(RedisLogin.class);
		redisBet.del("playersBetRank");
		
		redisBet.delKeys("playerBetInfo:*");
	}

}
