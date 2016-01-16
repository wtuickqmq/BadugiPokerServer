package com.inkstd.badugi.game.proxy.service;

import io.nadron.app.PlayerSession;

import java.util.Map;

public interface MallSessionManager {
	
	void addSession(PlayerSession session);

	void removeSession(PlayerSession session);

	Map<String, PlayerSession> getSessions();

	void sendAll(Object request);
	
}
