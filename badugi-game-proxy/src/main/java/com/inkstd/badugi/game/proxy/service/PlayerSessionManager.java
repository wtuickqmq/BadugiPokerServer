package com.inkstd.badugi.game.proxy.service;

import io.nadron.app.PlayerSession;

import java.util.List;
import java.util.Map;

public interface PlayerSessionManager {

	void addPlayerSession(PlayerSession playerSession);

	Map<String, PlayerSession> getSessions();

	PlayerSession removePlayerSession(PlayerSession playerSession);

	PlayerSession getPlayerSession(String playerId);

	Map<String, String> getCh2pid();

	int getOnlineSize();

	List<String> getOnlineList();

//	void removePlayerSession(String channelId);
	
	void sendToAll(Object source);
	
	void sendToTargets(Object source, String... sessionIds) ;

	void sendToTargets(Object source, List<String> sessionIds) ;
}
