package com.inkstd.badugi.game.proxy.proxy.handler;

import io.nadron.app.GameCommandInterpreter;
import io.nadron.app.PlayerSession;
import io.nadron.app.impl.InvalidCommandException;
import io.nadron.event.Event;
import io.nadron.event.Events;
import io.nadron.event.impl.DefaultSessionEventHandler;
import io.nadron.util.ObjectBeanUtil;
import io.netty.handler.timeout.IdleStateEvent;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;
import com.inkstd.badugi.game.common.constant.Constant;
import com.inkstd.badugi.game.proxy.model.RPCResponse;
import com.inkstd.badugi.game.proxy.service.PlayerSessionManager;
import com.inkstd.badugi.game.proxy.service.RpcSessionManager;
import com.inkstd.badugi.game.proxy.utils.EventSourceUtil;
import com.inkstd.badugi.game.proxy.utils.ProxyBeanUtil;
import com.joker.common.util.Base64Util;


public class RPCServiceHandler extends DefaultSessionEventHandler implements GameCommandInterpreter<RPCResponse> {

	private static final Logger LOGGER = LoggerFactory.getLogger(RPCServiceHandler.class);

	protected PlayerSession session;

	public RPCServiceHandler(PlayerSession session) {
		super(session);
		this.session = session;
	}

	@Override
	protected void onDisconnect(Event event) {
		super.onDisconnect(event);
		ProxyBeanUtil.get(RpcSessionManager.class).removeRPCSessionBuilder(session.getId());
	}

	@Override
	protected void onCustomEvent(Event event) {
		try {

			LOGGER.info("onCustomEvent Event:{}", event);
			int eventType = event.getType();
			if (eventType == Constant.EVENT_TYPE_BROADCAST) {
				
			} else if (eventType == Constant.EVENT_TYPE_ROBOT) {
				
			}
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	@Override
	public void onDataIn(Event event) {
		try {
			RPCResponse rpcResponse = EventSourceUtil.buffer2Object(event, RPCResponse.class);
			interpretCommand(rpcResponse);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	@Override
	protected void onException(Event event) {
		if (event.getSource() instanceof IdleStateEvent) {
			ProxyBeanUtil.get(RpcSessionManager.class).removeRPCSessionBuilder(session.getId());
			getSession().close();
			LOGGER.info("rpc time out ..", session.getKey());
		}
	}

	@Override
	public void interpretCommand(RPCResponse rpcResponse) throws InvalidCommandException {
		if (null == rpcResponse)
			return;

		try {
			LOGGER.info("RPCResponse :{}", ObjectBeanUtil.JACKSON.writeValueAsString(rpcResponse));
		} catch (Exception e) {
		}
		// 是否指定处理的代理服务器
		String proxy = rpcResponse.getProxy();
		// 是否是广播消息
		int broadcast = rpcResponse.getBroadcast();
		if (broadcast == 1) // 委托广播
		{
			// TODO
		
		} else // 本地执行
		{
			
		}
	}

}
