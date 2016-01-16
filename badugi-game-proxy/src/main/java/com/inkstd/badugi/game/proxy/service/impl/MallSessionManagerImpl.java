package com.inkstd.badugi.game.proxy.service.impl;

import io.nadron.app.PlayerSession;
import io.nadron.event.Events;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.inkstd.badugi.game.proxy.service.MallSessionManager;

@Service("mallSessionManager")
public class MallSessionManagerImpl implements MallSessionManager {

	private Map<String, PlayerSession> sessions;

	public MallSessionManagerImpl() {
		sessions = Maps.newConcurrentMap();
	}

	@Override
	public void addSession(PlayerSession session) {
		if (null != session) {
			sessions.put(session.getPlayer().getUuid().toString(), session);
		}
	}

	@Override
	public Map<String, PlayerSession> getSessions() {
		return sessions;
	}

	@Override
	public void sendAll(Object request) {
		Set<String> keys = sessions.keySet();
		for (String key : keys) {
			PlayerSession session = sessions.get(key);
			if (null != session) {
				//RouteChannelUtil.writeObjectToChannel(session, Events.dataInEvent(request));
			}
		}
	}

	@Override
	public void removeSession(PlayerSession session) {
		if (null != session) {
			sessions.remove(session.getPlayer().getUuid().toString());
		}
	}
}
