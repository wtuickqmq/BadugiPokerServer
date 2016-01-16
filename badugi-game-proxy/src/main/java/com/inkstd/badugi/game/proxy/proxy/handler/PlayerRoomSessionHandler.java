package com.inkstd.badugi.game.proxy.proxy.handler;

import java.util.Set;


import io.nadron.app.GameRoom;
import io.nadron.app.PlayerSession;
import io.nadron.app.impl.GameRoomSession;
import io.nadron.event.Event;
import io.nadron.event.impl.SessionMessageHandler;
import io.nadron.service.GameStateManagerService;

/**
 * This handler is attached to the GameRoom and all game related logic is
 * embedded in it. Its a SESSION_MESSAGE handler and does not take care of other
 * events which are sent to the room.
 */
public class PlayerRoomSessionHandler extends SessionMessageHandler {

	GameRoom room;// not really required. It can be accessed as getSession()
					// also.
	GameStateManagerService GameStateManagerService; // manage this room global
														// variable

	public PlayerRoomSessionHandler(GameRoomSession session) {
		super(session);
		this.room = session;
		// GameStateManagerService manager = room.getStateManager();

		// TestGameState state = (TestGameState) manager.getState();
		// Initialize the room state.
		// state = new TestGameState();
		// state.setEntities(new HashSet<Entity>());
		// state.setMonster(createMonster());
		// manager.setState(state); // set it back on the room
	}

	@Override
	public void onEvent(Event event) {
		// 广播给当前房间的用户
		Set<PlayerSession> sessions = room.getSessions();
		for (PlayerSession session : sessions) {
			if (null != session) {
				//ProxyChannelUtil.writeObjectToChannel(session, event);
			}
		}
	}

}
