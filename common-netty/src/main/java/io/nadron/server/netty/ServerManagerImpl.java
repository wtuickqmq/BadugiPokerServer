package io.nadron.server.netty;

import io.nadron.context.AppContext;
import io.nadron.server.ServerManager;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerManagerImpl implements ServerManager {

	private Set<AbstractNettyServer> servers;

	private static final Logger LOG = LoggerFactory.getLogger(ServerManagerImpl.class);

	public ServerManagerImpl() {
		servers = new HashSet<AbstractNettyServer>();
	}

	@Override
	public void startServers(int tcpPort, int flashPort, int udpPort, int httpPort) throws Exception {

		if (tcpPort > 0) {
			start(AppContext.TCP_SERVER, tcpPort);
		}
		if (flashPort > 0) {
			start(AppContext.FLASH_POLICY_SERVER, flashPort);
		}
		if (udpPort > 0) {
			start(AppContext.UDP_SERVER, udpPort);
		}
		if (httpPort > 0) {
			start(AppContext.HTTP_SERVER, httpPort);
		}

	}

	private void start(String instance) {
		start(instance, 0);
	}

	private void start(String instance, int port) {
		AbstractNettyServer server = null;
		try {
			server = (AbstractNettyServer) AppContext.getBean(instance);
			if (0 < port) {
				server.startServer(port);
				LOG.info("{} is running ,[port:{}]", instance, port);
			} else {
				server.startServer();
				LOG.info("{} is start ,port={}! ", instance, server.getSocketAddress().getPort());
			}
			servers.add(server);
		} catch (Exception e) {
			LOG.warn("{} boot is fail ! e {} ", instance, e.getMessage());
		}
	}

	@Override
	public void startServers() throws Exception {
		start(AppContext.TCP_SERVER);
		start(AppContext.FLASH_POLICY_SERVER);
		start(AppContext.UDP_SERVER);
		start(AppContext.HTTP_SERVER);
	}

	@Override
	public void stopServers() throws Exception {
		for (AbstractNettyServer nettyServer : servers) {
			try {
				nettyServer.stopServer();
			} catch (Exception e) {
				LOG.error("Unable to stop server {} due to error {}", nettyServer, e);
				throw e;
			}
		}
	}

}
