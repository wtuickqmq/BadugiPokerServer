package io.nadron.app.impl;

import io.nadron.app.Game;
import io.nadron.app.GameRoom;
import io.nadron.app.MultiSession;
import io.nadron.app.Player;
import io.nadron.app.PlayerSession;
import io.nadron.app.Session;
import io.nadron.app.SessionFactory;
import io.nadron.common.http.Request;
import io.nadron.communication.MessageSender.Reliable;
import io.nadron.concurrent.LaneStrategy;
import io.nadron.concurrent.LaneStrategy.LaneStrategies;
import io.nadron.event.Event;
import io.nadron.event.EventHandler;
import io.nadron.event.Events;
import io.nadron.event.NetworkEvent;
import io.nadron.event.impl.EventDispatchers;
import io.nadron.event.impl.NetworkEventListener;
import io.nadron.extension.data.ISFSObject;
import io.nadron.extension.util.SamrtFoxServerUtil;
import io.nadron.extension.variables.RoomVariable;
import io.nadron.extension.variables.UserVariable;
import io.nadron.protocols.Protocol;
import io.nadron.service.GameStateManagerService;
import io.nadron.service.impl.GameStateManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GameRoomSession extends DefaultSession implements GameRoom {

	private static final Logger LOG = LoggerFactory.getLogger(GameRoomSession.class);

	protected Long gameRoomId;
	/**
	 * The name of the game room, preferably unique across multiple games.
	 */
	protected String gameRoomName;
	/**
	 * The parent {@link SimpleGame} reference of this game room.
	 */
	protected Game parentGame;
	/**
	 * Each game room has separate state manager instances. This variable will
	 * manage the state for all the {@link DefaultPlayer}s connected to this
	 * game room.
	 */
	protected GameStateManagerService stateManager;

	/**
	 * The set of sessions in this object.
	 */
	protected Set<PlayerSession> sessions;

	/**
	 * Each game room has its own protocol for communication with client.
	 */
	protected Protocol protocol;

	protected SessionFactory sessionFactory;

	protected Map<String, GameRoom> gameRooms;

	protected Map<String, RoomVariable> roomVariables;

	protected Map<String, RoomVariable> oldVariables;

	protected Map<String, Object> propertys;

	protected Map<Object, PlayerSession> sessionMapKey;

	protected GameRoomSession(GameRoomSessionBuilder gameRoomSessionBuilder) {
		super(gameRoomSessionBuilder);
		this.sessions = gameRoomSessionBuilder.sessions;
		this.parentGame = gameRoomSessionBuilder.parentGame;
		this.gameRoomName = gameRoomSessionBuilder.gameRoomName;
		this.gameRoomId = gameRoomSessionBuilder.gameRoomId;
		this.protocol = gameRoomSessionBuilder.protocol;
		this.stateManager = gameRoomSessionBuilder.stateManager;
		this.sessionFactory = gameRoomSessionBuilder.sessionFactory;
		this.gameRooms = new ConcurrentHashMap<String, GameRoom>();
		roomVariables = new ConcurrentHashMap<String, RoomVariable>();
		oldVariables = new ConcurrentHashMap<String, RoomVariable>();
		propertys = new ConcurrentHashMap<String, Object>();
		sessionMapKey = new ConcurrentHashMap<Object, PlayerSession>();
		if (null == gameRoomSessionBuilder.eventDispatcher) {
			this.eventDispatcher = EventDispatchers.newJetlangEventDispatcher(this, gameRoomSessionBuilder.laneStrategy);
		}
	}

	public static class GameRoomSessionBuilder extends SessionBuilder {
		protected Set<PlayerSession> sessions;
		protected Game parentGame;
		protected String gameRoomName;
		protected Long gameRoomId;
		protected Protocol protocol;
		protected LaneStrategy<String, ExecutorService, GameRoom> laneStrategy;
		protected GameStateManagerService stateManager;
		protected SessionFactory sessionFactory;

		@Override
		protected void validateAndSetValues() {
			if (null == id) {
				id = String.valueOf(ID_GENERATOR_SERVICE.generateFor(GameRoomSession.class));
			}
			if (null == sessionAttributes) {
				sessionAttributes = new HashMap<String, Object>();
			}
			if (null == sessions) {
				sessions = new HashSet<PlayerSession>();
			}
			if (null == laneStrategy) {
				laneStrategy = LaneStrategies.GROUP_BY_ROOM;
			}
			if (null == stateManager) {
				stateManager = new GameStateManager();
			}
			if (null == sessionFactory) {
				sessionFactory = Sessions.INSTANCE;
			}
			creationTime = System.currentTimeMillis();
		}

		public GameRoomSessionBuilder sessions(Set<PlayerSession> sessions) {
			this.sessions = sessions;
			return this;
		}

		public GameRoomSessionBuilder parentGame(Game parentGame) {
			this.parentGame = parentGame;
			return this;
		}

		public GameRoomSessionBuilder gameRoomName(String gameRoomName) {
			this.gameRoomName = gameRoomName;
			return this;
		}

		public GameRoomSessionBuilder gameRoomId(Long gameRoomId) {
			this.gameRoomId = gameRoomId;
			return this;
		}

		public GameRoomSessionBuilder protocol(Protocol protocol) {
			this.protocol = protocol;
			return this;
		}

		public GameRoomSessionBuilder laneStrategy(LaneStrategy<String, ExecutorService, GameRoom> laneStrategy) {
			this.laneStrategy = laneStrategy;
			return this;
		}

		public GameRoomSessionBuilder stateManager(GameStateManagerService gameStateManagerService) {
			this.stateManager = gameStateManagerService;
			return this;
		}

		public GameRoomSessionBuilder sessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
			return this;
		}
	}

	@Override
	public PlayerSession createPlayerSession(Player player) {
		PlayerSession playerSession = getSessionInstance(player);
		return playerSession;
	}

	@Override
	public MultiSession createMultiSession(Player player) {
		MultiSession playerSession = getMultiSessionInstance(player);
		return playerSession;
	}

	@Override
	public abstract void onLogin(PlayerSession playerSession);

	@Override
	public synchronized boolean connectSession(PlayerSession playerSession) {
		if (!isShuttingDown) {
			playerSession.setStatus(Session.Status.CONNECTING);
			// sessions.add(playerSession);
			addSession(playerSession);
			playerSession.setGameRoom(this);
			LOG.trace("Protocol to be applied is: {}", protocol.getClass().getName());
			protocol.applyProtocol(playerSession, true);
			createAndAddEventHandlers(playerSession);
			playerSession.setStatus(Session.Status.CONNECTED);
			afterSessionConnect(playerSession);
			return true;
			// TODO send event to all other sessions?
		} else {
			LOG.warn("Game Room is shutting down, playerSession {} {}", playerSession, "will not be connected!");
			return false;
		}
	}

	public void addSession(PlayerSession session) {
		if (null != session) {
			sessions.add(session);
			sessionMapKey.put(session.getKey(), session);
		}
	}

	public boolean removeSession(PlayerSession session) {
		if (null != session) {
			sessionMapKey.remove(session.getKey());
			return sessions.remove(session);
		}
		return false;
	}

	@Override
	public boolean addToRoom(PlayerSession playerSession) {
		if (!isShuttingDown) {
			sessions.add(playerSession);
			playerSession.addGameRoom(this);
			createAndAddEventHandlers(playerSession);
			return true;
		} else {
			LOG.warn("Game Room is shutting down, playerSession {} {}", playerSession, "will not be connected!");
			return false;
		}
	}

	@Override
	public void afterSessionConnect(PlayerSession playerSession) {
		GameStateManagerService manager = getStateManager();
		if (null != manager) {
			Object state = manager.getState();
			if (null != state) {
				playerSession.onEvent(Events.networkEvent(state));
			}
		}
	}

	public synchronized boolean disconnectSession(PlayerSession playerSession) {
		final boolean removeHandlers = this.eventDispatcher.removeHandlersForSession(playerSession);
		// playerSession.getEventDispatcher().clear(); // remove network
		// handlers of the session.
		return (removeHandlers && removeSession(playerSession));
	}

	@Override
	public void send(Event event) {
		onEvent(event);
	}

	@Override
	public void sendBroadcast(NetworkEvent networkEvent) {
		onEvent(networkEvent);
	}

	@Override
	public synchronized void close() {
		isShuttingDown = true;
		for (PlayerSession session : sessions) {
			session.close();
		}
	}

	public PlayerSession getSessionInstance(Player player) {
		PlayerSession playerSession = sessionFactory.newPlayerSession(this, player);
		return playerSession;
	}

	public MultiSession getMultiSessionInstance(Player player) {
		MultiSession playerSession = null;// sessionFactory.newMultiPlayerSession(this,
											// player);
		return playerSession;
	}

	public int sessionSize() {
		return getSessions().size();
	}

	@Override
	public Set<PlayerSession> getSessions() {
		return sessions;
	}

	@Override
	public void setSessions(Set<PlayerSession> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String getGameRoomName() {
		return gameRoomName;
	}

	@Override
	public void setGameRoomName(String gameRoomName) {
		this.gameRoomName = gameRoomName;
	}

	@Override
	public Game getParentGame() {
		return parentGame;
	}

	@Override
	public void setParentGame(Game parentGame) {
		this.parentGame = parentGame;
	}

	@Override
	public void setStateManager(GameStateManagerService stateManager) {
		this.stateManager = stateManager;
	}

	@Override
	public GameStateManagerService getStateManager() {
		return stateManager;
	}

	@Override
	public Protocol getProtocol() {
		return protocol;
	}

	@Override
	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
	}

	@Override
	public SessionFactory getFactory() {
		return sessionFactory;
	}

	@Override
	public void setFactory(SessionFactory factory) {
		this.sessionFactory = factory;
	}

	@Override
	public boolean isShuttingDown() {
		return isShuttingDown;
	}

	public void setShuttingDown(boolean isShuttingDown) {
		this.isShuttingDown = isShuttingDown;
	}

	/**
	 * Method which will create and add event handlers of the player session to
	 * the Game Room's EventDispatcher.
	 * 
	 * @param playerSession
	 *            The session for which the event handlers are created.
	 */
	protected void createAndAddEventHandlers(PlayerSession playerSession) {
		// Create a network event listener for the player session.
		EventHandler networkEventHandler = new NetworkEventListener(playerSession);
		// Add the handler to the game room's EventDispatcher so that it will
		// pass game room network events to player session session.
		this.eventDispatcher.addHandler(networkEventHandler);
		LOG.trace("Added Network handler to " + "EventDispatcher of GameRoom {}, for session: {}", this, playerSession);
	}

	public Long getGameRoomId() {
		return gameRoomId;
	}

	public void setGameRoomId(Long gameRoomId) {
		this.gameRoomId = gameRoomId;
	}

	@Override
	public RoomVariable getVariable(String key) {
		if (null != roomVariables) {
			return roomVariables.get(key);
		}
		return null;
	}

	@Override
	public List<RoomVariable> getVariables() {
		List<RoomVariable> list = new ArrayList<RoomVariable>(roomVariables.values());
		return list;
	}




	public List<Object> getVariableList() {
		List<RoomVariable> list = new ArrayList<RoomVariable>(roomVariables.values());
		List<Object> vars = new ArrayList<Object>(list.size());
		for (RoomVariable var : list) {
			vars.add(SamrtFoxServerUtil.getVariable(var));
		}
		return vars;
	}

	public Map<String, Object> getVariableMap() {
		List<RoomVariable> list = new ArrayList<RoomVariable>(roomVariables.values());
		Map<String, Object> vars = new HashMap<String, Object>(list.size());
		for (RoomVariable var : list) {
			vars.putAll(SamrtFoxServerUtil.getVariable(var));
		}
		return vars;
	}

	@Override
	public void setRoomVariables(List<RoomVariable> roomVariables) {

		if (null != roomVariables && !roomVariables.isEmpty()) {
			List<RoomVariable> changes = new ArrayList<RoomVariable>();
			for (RoomVariable roomVariable : roomVariables) {
				boolean update = changeVariable(roomVariable);
				if (update) {
					changes.add(roomVariable);
				}
			}
			if (!changes.isEmpty()) {
				notifyRoomVariableChange(changes);
			}
		}
	}

	@Override
	public void addRoomVariables(List<RoomVariable> roomVariables) {
		setRoomVariables(roomVariables);
	}

	@Override
	public Object onHTTPRequest(Request request) {
		return null;
	}

	@Override
	public void setVariable(RoomVariable roomVariable) {
		boolean update = changeVariable(roomVariable);
		if (update) {
			notifyRoomVariableChange(roomVariable);
		}
	}

	protected void notifyRoomVariableChange(RoomVariable roomVariable) {

	}

	protected void notifyRoomVariableChange(List<RoomVariable> roomVariable) {

	}

	private boolean changeVariable(RoomVariable roomVariable) {
		if (null != roomVariable) {
			String key = roomVariable.getName();

			boolean flag = false;
			if (oldVariables.containsKey(key)) {
				RoomVariable oldValue = oldVariables.get(key);
				if (null != oldValue) {
					if (oldValue.equals(roomVariable)) {
						flag = true;
					}
				} else {
					if (null != roomVariable) {
						flag = true;
					}
				}
			} else {
				flag = true;
			}
			roomVariables.put(key, roomVariable);
			oldVariables.put(key, roomVariable);
			return flag;
		}
		return false;
	}

	public boolean containsVariable(String key) {
		return roomVariables.containsKey(key);
	}

	@Override
	public Object getProperty(String propName) {
		if (null != propName) {
			return propertys.get(propName);
		}
		return null;
	}

	@Override
	public void setProperty(String propName, Object value) {
		if (null != propName) {
			propertys.put(propName, value);
		}
	}

	@Override
	public void sendToTargets(Event event, List<PlayerSession> sessions) {
		if (null != event && null != sessions && !sessions.isEmpty()) {
			for (PlayerSession session : sessions) {
				sendToTarget(event, session);
			}
		}
	}

	@Override
	public void sendToTarget(Event event, PlayerSession session) {
		if (null != event && null != sessions) {
			Reliable reliable = session.getTcpSender();
			if (null != reliable) {
				reliable.sendMessage(event);
			}
		}
	}

	@Override
	public void sendToTargetByKey(Event event, Object sessionKey) {
		if (this.sessionMapKey.containsKey(sessionKey)) {
			PlayerSession session = getPlayerByKey(sessionKey);
			sendToTarget(event, session);
		}
	}

	@Override
	public void sendToTargetByKeyList(Event event, List<?> sessionKeyList) {
		if (null != event && null != sessionKeyList && !sessionKeyList.isEmpty()) {
			for (Object sessionKey : sessionKeyList) {
				sendToTargetByKey(event, sessionKey);
			}
		}
	}

	@Override
	public PlayerSession getPlayerByKey(Object sessionKey) {
		return sessionMapKey.get(sessionKey);
	}

	@Override
	public void setUserVariables(PlayerSession session, List<UserVariable> uvList) {
		if (null != session && null != uvList) {
			if (!uvList.isEmpty()) {
				session.setUserVariables(uvList);
			}
		}
	}
}
