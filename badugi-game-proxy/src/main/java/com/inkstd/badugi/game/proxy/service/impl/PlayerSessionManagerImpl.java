package com.inkstd.badugi.game.proxy.service.impl;

import io.nadron.app.Player;
import io.nadron.app.PlayerSession;
import io.nadron.event.Events;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.inkstd.badugi.game.proxy.service.PlayerSessionManager;


@Service("playerSessionManager")
public class PlayerSessionManagerImpl implements PlayerSessionManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlayerSessionManagerImpl.class);

	private Map<String, PlayerSession> sessions;

	private Multimap<String, String> playerId2ChannelId;

	// private ChannelGroup sessionGroup;

	private PlayerSessionManagerImpl() {
		this.sessions = Maps.newConcurrentMap();
		playerId2ChannelId = ArrayListMultimap.create();
		// this.sessionGroup = new
		// DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	}

	public Map<String, PlayerSession> getSessions() {
		return sessions;
	}

	public void setSessions(Map<String, PlayerSession> sessions) {
		this.sessions = sessions;
	}

	public synchronized void addPlayerSession(PlayerSession playerSession) {
		if (null != playerSession) {
			Player player = playerSession.getPlayer();
			// Object id = player.getEmailId();
			Object id = player.getUuid();
			sessions.put(id.toString(), playerSession);
			playerId2ChannelId.put(playerSession.getKey().toString(), id.toString());
			// sessionGroup.add(playerSession.getTcpSender().getChannel());
		}
	}

	public synchronized PlayerSession removePlayerSession(PlayerSession session) {
		if (null != session) {
			PlayerSession playerSession = sessions.remove(session.getPlayer().getUuid().toString());
			playerId2ChannelId.remove(session.getKey().toString(), session.getPlayer().getUuid().toString());
			return playerSession;
		}
		return null;
	}

//	@Override
//	public void removePlayerSession(String channelId) {
//		if (null != channelId) {
//			PlayerSession session = sessions.get(channelId);
//			removePlayerSession(session);
//		}
//	}

	public PlayerSession getPlayerSession(String playerId) {
		if (null == playerId)
			return null;
		return sessions.get(playerId);
	}

	// public ChannelGroup getSessionGroup() {
	// return sessionGroup;
	// }
	//
	// public void setSessionGroup(ChannelGroup sessionGroup) {
	// this.sessionGroup = sessionGroup;
	// }

	@Override
	public List<String> getOnlineList() {
		List<String> list = Lists.newArrayList(sessions.keySet());
		Collections.sort(list);
		return list;
	}

	@Override
	public int getOnlineSize() {
		return this.sessions.size();
	}

	public Map<String, String> getCh2pid() {
		Map<String, String> mapped = Maps.newHashMap();
		Set<String> keys = sessions.keySet();

		for (String key : keys) {
			PlayerSession session = sessions.get(key);
			if (null != session) {
				String playerId = session.getKey().toString();
				mapped.put(key, playerId);
			}
		}
		return mapped;
	};

	public void sendToAll(Object source) {
		Set<String> channelIdSet = this.sessions.keySet();

		for (String channelId : channelIdSet) {
			PlayerSession session = sessions.get(channelId);
			if (null != session) {
				//ProxyChannelUtil.writeObjectToChannel(session, Events.dataInEvent(source));
			}
		}
	}

	public void sendToTargets(Object source, String... sessionIds) {
		if (null != sessionIds) {
			List<String> list = Lists.newArrayList(sessionIds);
			sendToTargets(source, list);
		}
	}

	public void sendToTargets(Object source, List<String> sessionIds) {
		if (null != sessionIds) {
			for (String sessionId : sessionIds) {
				try {
					List<String> targetChannelIdList = Lists.newArrayList(playerId2ChannelId.get(sessionId));
					if (null != targetChannelIdList && !targetChannelIdList.isEmpty()) {
						for (String targetChannelId : targetChannelIdList) {
							PlayerSession session = getPlayerSession(targetChannelId);
							if (null == session)
								continue;
							//ProxyChannelUtil.writeObjectToChannel(session, Events.dataInEvent(source));
						}
					}
				} catch (Exception e) {
					LOGGER.error("", e);
				}

			}
		}
	}
}
