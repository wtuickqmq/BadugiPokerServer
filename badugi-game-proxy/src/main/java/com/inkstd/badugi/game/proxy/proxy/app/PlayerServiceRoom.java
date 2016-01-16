package com.inkstd.badugi.game.proxy.proxy.app;

import io.nadron.app.PlayerSession;
import io.nadron.app.impl.GameRoomSession;

import io.nadron.common.http.Request;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;
import com.inkstd.badugi.game.proxy.proxy.handler.PlayerRoomSessionHandler;
import com.inkstd.badugi.game.proxy.proxy.handler.PlayerSessionHandler;
import com.inkstd.badugi.game.proxy.service.PlayerSessionManager;


public class PlayerServiceRoom extends GameRoomSession {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlayerServiceRoom.class);

	private PlayerSessionManager playerSessionManager;

	public PlayerServiceRoom(GameRoomSessionBuilder sessionBuilder, PlayerSessionManager playerSessionManager) {
		super(sessionBuilder);
		addHandler(new PlayerRoomSessionHandler(this));
		this.playerSessionManager = playerSessionManager;
	}
	
	@Override
	public void onLogin(PlayerSession playerSession) {
		PlayerSessionHandler listener = new PlayerSessionHandler(playerSession);
		playerSession.addHandler(listener);
		playerSessionManager.addPlayerSession(playerSession);
		{
			// 通知route有用户上线
			Map<String, Object> playerInfo = Maps.newHashMap();
			playerInfo.put("channelId", playerSession.getPlayer().getUuid());
			playerInfo.put("session", playerSession.getKey());
			playerInfo.put("name", playerSession.getPlayer().getName().toString());

		}
		try {
			String ip = playerSession.getTcpSender().getChannel().remoteAddress().toString();
			ip = null != ip ? ip.replace("/", "").split(":")[0] : null;
			
		} catch (Exception e) {
			LOGGER.warn("", e);
		}
		LOGGER.info("player login success...");
	}

	@Override
	public String onHTTPRequest(Request request) {
		return null;
	}

}
