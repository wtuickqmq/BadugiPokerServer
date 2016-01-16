package com.inkstd.badugi.game.proxy.proxy.handler;

import io.nadron.app.PlayerSession;
import io.nadron.event.ConnectEvent;
import io.nadron.event.Event;
import io.nadron.event.impl.DefaultSessionEventHandler;
import io.netty.handler.timeout.IdleStateEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inkstd.badugi.game.proxy.service.MallSessionManager;
import com.inkstd.badugi.game.proxy.utils.ProxyBeanUtil;


public class MallServiceHandler extends DefaultSessionEventHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(MallServiceHandler.class);

	protected PlayerSession session;

	public MallServiceHandler(PlayerSession session) {
		super(session);
		this.session = session;
	}

	@Override
	protected void onDisconnect(Event event) {
		super.onDisconnect(event);
		ProxyBeanUtil.get(MallSessionManager.class).removeSession(session);
		LOGGER.info("client close event={}", event);
	}

	@Override
	protected void onConnect(ConnectEvent event) {
		super.onConnect(event);
		LOGGER.info("client connect event={}", event);
	}

	@Override
	protected void onCustomEvent(Event event) {
	}

	@Override
	public void onDataIn(Event event) {
	}

	@Override
	protected void onException(Event event) {
		if (event.getSource() instanceof IdleStateEvent) {
			getSession().close();
			LOGGER.info("time out ..", session.getKey());
		}
	}

}
