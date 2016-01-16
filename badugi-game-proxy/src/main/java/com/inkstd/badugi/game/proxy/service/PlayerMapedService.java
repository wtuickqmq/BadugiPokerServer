package com.inkstd.badugi.game.proxy.service;

import java.util.Map;

import com.inkstd.badugi.game.proxy.model.PlayerMaped;


public interface PlayerMapedService {

	void register(String proxyId);

	void destroy(String proxyId);

	String getProxyId(String playerSessionId);

	String getChannelId(String playerSessionId);

	void addPlayerList(String proxyId, Map<String, Object> map);

	void addPlayer(String proxyId, String channelId, String sessionId);

	void addPlayer(String proxyId, Map<String, Object> map);

	void removePlayer(String proxyId, String channelId, String sessionId);

	void removePlayer(String proxyId, Map<String, Object> map);

	int getOnlineSize();

	Map<String, String> getSessionMapFromRedis(String sessionId);

	int isOnline(String sessionId);

	Map<String, String> getPlayerId2proxyId();
	
	Map<String, PlayerMaped> getMapped();
}
