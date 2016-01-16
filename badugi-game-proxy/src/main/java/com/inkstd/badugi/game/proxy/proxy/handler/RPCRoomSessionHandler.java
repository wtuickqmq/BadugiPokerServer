package com.inkstd.badugi.game.proxy.proxy.handler;

import io.nadron.app.GameRoom;
import io.nadron.app.impl.GameRoomSession;
import io.nadron.event.Event;
import io.nadron.event.impl.SessionMessageHandler;
import io.nadron.service.GameStateManagerService;

/**
 * This handler is attached to the GameRoom and all game related logic is
 * embedded in it. Its a SESSION_MESSAGE handler and does not take care of other
 * events which are sent to the room.
 */
public class RPCRoomSessionHandler extends SessionMessageHandler {

	GameRoom room;

	GameStateManagerService GameStateManagerService;

	public RPCRoomSessionHandler(GameRoomSession session) {
		super(session);
		this.room = session;
	}

	@Override
	public void onEvent(Event event) {
	}

}
