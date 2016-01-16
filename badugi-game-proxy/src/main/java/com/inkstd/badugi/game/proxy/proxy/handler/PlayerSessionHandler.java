package com.inkstd.badugi.game.proxy.proxy.handler;

import io.nadron.app.GameCommandInterpreter;
import io.nadron.app.Player;
import io.nadron.app.PlayerSession;
import io.nadron.app.impl.InvalidCommandException;

import io.nadron.event.Event;
import io.nadron.event.impl.DefaultSessionEventHandler;
import io.nadron.util.ObjectBeanUtil;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;
import com.inkstd.badugi.game.common.constant.SessionKeys;
import com.inkstd.badugi.game.proxy.service.PlayerSessionManager;
import com.inkstd.badugi.game.proxy.utils.ProxyBeanUtil;
import com.joker.common.util.Base64Util;


public class PlayerSessionHandler extends DefaultSessionEventHandler implements GameCommandInterpreter<String> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlayerSessionHandler.class);

	private PlayerSession session;

	public PlayerSessionHandler(PlayerSession session) {
		super(session);
		this.session = session;
	}

	@Override
	protected void onDisconnect(Event event) {

		Player player = session.getPlayer();

		String name = player.getName();
		String channelId = player.getUuid();
		String sessionId = session.getKey().toString();

		LOGGER.info("onDisconnect , name:{} ,sessionId:{}", name, sessionId);
		{
			// rpc进行通知处理
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("request", Base64Util.encode(String.format("{\"event\":\"e_logout\",\"fbid\":\"%s\",\"flag\":0}", sessionId)));
			map.put("name", name);
			map.put("session", sessionId);
			map.put("channelId", channelId);
			Event response = io.nadron.event.Events.dataInEvent(map);
			// Object object = RouteChannelUtil.writeObjectToChannel(session,
			// response);
			//boolean proxy2logic = GameProxyUtil.routeRpcRequest(response);
			//
			//LOGGER.trace("logout rpc:{}", proxy2logic);
		}
		{
			// extension进行通知处理
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("request", Base64Util.encode(String.format("{\"cmd\":\"call_logout\",\"fbid\":\"%s\",\"flag\":0}", sessionId)));
			map.put("name", name);
			map.put("session", sessionId);
			map.put("channelId", channelId);
			Event response = io.nadron.event.Events.dataInEvent(map);
			// Object object = RouteChannelUtil.writeObjectToChannel(session,
			// response);
			//boolean proxy2logic = ProxyBeanUtil.get(ExtensionSessionManager.class).sendAll(response);
			//
			//LOGGER.trace("logout extension:{}", proxy2logic);
		}
		{
			// 通知route有用户下线
			Map<String, Object> playerInfo = Maps.newHashMap();
			playerInfo.put("name", name);
			playerInfo.put("channelId", channelId);
			playerInfo.put("session", sessionId);

			Map<String, Object> map = Maps.newHashMap();
			map.put("event", "roleLogout"); //
			map.put("data", playerInfo); //
			//ProxyRouteUtil.routeEvent(Events.dataInEvent(map));

		}
		ProxyBeanUtil.get(PlayerSessionManager.class).removePlayerSession(session);
		super.onDisconnect(event);
	}

	@Override
	public void interpretCommand(String request) throws InvalidCommandException {

		if (null != request) {
			LOGGER.debug("Received Player Request:{}", request);
			// 将客户端请求进行转发

			Object clientIp = session.getAttribute(SessionKeys.CLIENT_IP);

			

		}
	}

	@Override
	public void onDataIn(Event event) {
		try {
			Object source = event.getSource();
			if (source instanceof io.nadron.communication.NettyMessageBuffer) {
				io.nadron.communication.NettyMessageBuffer buffer = (io.nadron.communication.NettyMessageBuffer) source;
				String readString = new String(buffer.array());
				if (!(readString.startsWith("{") && readString.endsWith("}"))) {
					readString = buffer.readString();
				}
				interpretCommand(readString);
			} else if (source instanceof String) {
				String readString = (String) source;
				interpretCommand(readString);
			} else if (source instanceof Map) {
				String readString = ObjectBeanUtil.JACKSON.writeValueAsString(source);
				interpretCommand(readString);
			}
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	@Override
	protected void onIdleState(Event event) {
		Object source = event.getSource();
		if (source instanceof IdleStateEvent) {
			IdleStateEvent idleStateEvent = (IdleStateEvent) source;
			if (idleStateEvent.state().equals(IdleState.ALL_IDLE)) {
				// System.out.println("ALL_IDLE");
				LOGGER.debug("ALL_IDLE :{}", session.getTcpSender().getChannel());
				// 关闭链接
				onDisconnect(event);
			}else if (idleStateEvent.state().equals(IdleState.READER_IDLE)) {
				// long lastTime = this.session.getLastReadWriteTime();
				// if ((System.currentTimeMillis() - lastTime) <= 1000 * 30) {
				// 发送心跳
				/**
				 * onIdleState 状态是60s检测一次
				 * 
				 * wtu.edit 2015-12-09  在没有客户端向服务器发送数据时，断开服务器连接
				 * 
				 * 客户端定时30s发送心跳，在没有收到心跳，则认为是客户端网络异常
				 * 
				 * 
				 */
				//ProxyChannelUtil.writeObjectToChannel(this.session, io.nadron.event.Events.event(null, io.nadron.event.Events.PING));
				LOGGER.debug("ping session:{}", session.getTcpSender().getChannel());
				onDisconnect(event);
				// } else {
				// onDisconnect(event);
				// }
//				onDisconnect(event);
			} else if (idleStateEvent.state().equals(IdleState.WRITER_IDLE)) {
				// System.out.println("WRITER_IDLE");
			}
		}
	}

	public String getPlayerId() {
		String playerId = null;
		if (null != this.session) {
			playerId = session.getKey().toString();
		}
		return playerId;
	}

}
