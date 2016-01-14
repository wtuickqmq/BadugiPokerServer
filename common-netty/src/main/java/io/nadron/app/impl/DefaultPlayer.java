package io.nadron.app.impl;

import io.nadron.app.Player;
import io.nadron.app.PlayerSession;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultPlayer implements Player {
	/**
	 * 
	 */
	private String uuid;
	/**
	 * This variable could be used as a database key.
	 */
	private Object id;
	/**
	 * The name of the gamer.
	 */
	private String name;
	/**
	 * The password
	 */
	private String password;
	/**
	 * Email id of the gamer.
	 */
	private String emailId;

	/**
	 * One player can be connected to multiple games at the same time. Each
	 * session in this set defines a connection to a game. TODO, each player
	 * should not have multiple sessions to the same game.
	 */
	private Set<PlayerSession> playerSessions;

	private Map<String, Object> property;

	public DefaultPlayer() {
		playerSessions = new HashSet<PlayerSession>();
		property = new ConcurrentHashMap<String, Object>();
	}

	public DefaultPlayer(Object id, String name, String password) {
		this();
		this.id = id;
		this.name = name;
		this.emailId = password;
	}

	public DefaultPlayer(Object id, String name, String password, String uuid) {
		this();
		this.id = id;
		this.name = name;
		this.password = password;
		this.uuid = uuid;
	}

	public DefaultPlayer(Object id, String name, String password, String uuid, String emailId) {
		this();
		this.id = id;
		this.name = name;
		this.password = password;
		this.uuid = uuid;
		this.emailId = emailId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((playerSessions == null) ? 0 : playerSessions.hashCode());
		result = prime * result + ((property == null) ? 0 : property.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DefaultPlayer other = (DefaultPlayer) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (playerSessions == null) {
			if (other.playerSessions != null)
				return false;
		} else if (!playerSessions.equals(other.playerSessions))
			return false;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	@Override
	public Object getId() {
		return id;
	}

	@Override
	public void setId(Object id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getEmailId() {
		return emailId;
	}

	@Override
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public synchronized boolean addSession(PlayerSession session) {
		return playerSessions.add(session);
	}

	@Override
	public synchronized boolean removeSession(PlayerSession session) {
		boolean remove = playerSessions.remove(session);
		if (playerSessions.size() == 0) {
			logout(session);
		}
		return remove;
	}

	@Override
	public synchronized void logout(PlayerSession session) {
		session.close();
		if (null != playerSessions) {
			playerSessions.remove(session);
		}
	}

	public Set<PlayerSession> getPlayerSessions() {
		return playerSessions;
	}

	public void setPlayerSessions(Set<PlayerSession> playerSessions) {
		this.playerSessions = playerSessions;
	}

	@Override
	public boolean containskey(String key) {
		return property.containsKey(key);
	}

	@Override
	public Object getProperty(String key) {
		if (null != property) {
			return property.get(key);
		}
		return null;
	}

	@Override
	public void setProperty(String key, Object value) {
		if (null != key) {
			property.put(key, value);
		}
	}

	@Override
	public void setPropertyMap(Map<String, Object> map) {
		if (null != map) {
			property = map;
		}
	}

	@Override
	public void addPropertyMap(Map<String, Object> map) {
		if (null != map) {
			property.putAll(map);
		}
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
