package com.inkstd.badugi.game.proxy;

import io.nadron.server.ServerManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.inkstd.badugi.game.proxy.config.ProxyConfig;
import com.inkstd.badugi.game.proxy.utils.ProxyBeanUtil;
import com.inkstd.badugi.game.proxy.utils.ProxyPropertyUtil;
import com.joker.common.util.MacUtil;
import com.joker.common.util.RootUtil;


public final class GameProxy {

	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(GameProxy.class);

	public static void main(String[] args) throws Exception {
		LOGGER.info("start init...");
		long start = System.currentTimeMillis();
		startInit();
		startRouteServer();
		long end = System.currentTimeMillis();
		LOGGER.info("pid={}, mac={}, use={}ms", new Object[] { RootUtil.getProcessID(), MacUtil.getMacAddress(), (end - start) });
	}

	@SuppressWarnings("resource")
	private static void startInit() {
		// AbstractApplicationContext context = new
		// AnnotationConfigApplicationContext(RouteConfig.class);
		// context.registerShutdownHook();
		new AnnotationConfigApplicationContext(ProxyConfig.class).registerShutdownHook();
	}

	private static void startRouteServer() throws Exception {
		// ServerManager serverManager = context.getBean(ServerManager.class);
		ServerManager serverManager = ProxyBeanUtil.get(ServerManager.class);
		int tcpPort = ProxyPropertyUtil.getInteger("proxy.tcp.port", 20001);
		int flashPort = ProxyPropertyUtil.getInteger("proxy.flash.port", 8843);
		int udpPort = ProxyPropertyUtil.getInteger("proxy.udp.port", 0);
		int httpPort = ProxyPropertyUtil.getInteger("proxy.http.port", 8000);
		try {// Start the main game server
			serverManager.startServers(tcpPort, flashPort, udpPort, httpPort);
		} catch (Exception e) {
			LOGGER.error("Unable to start servers cleanly:", e);
		}
	}


}
