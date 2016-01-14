package io.nadron.util;

import io.nadron.app.PlayerSession;
import io.nadron.app.impl.GameRoomSession;
import io.nadron.common.http.Request;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;



public class TestGameRoom extends GameRoomSession {

	private final AtomicLong counter;
	private final CountDownLatch latch;

	public TestGameRoom(GameRoomSessionBuilder gameRoomSessionBuilder,
			AtomicLong counter, CountDownLatch latch) {
		super(gameRoomSessionBuilder);
		this.counter = counter;
		this.latch = latch;
	}

	@Override
	public void onLogin(PlayerSession playerSession) {
		SessionHandlerLatchCounter handler = new SessionHandlerLatchCounter(
				playerSession, counter, latch);
		playerSession.addHandler(handler);
	}

	@Override
	public String onHTTPRequest(Request request) {
		return null;
	}

	@Override
	public boolean addToRoom(PlayerSession playerSession) {
		// TODO Auto-generated method stub
		return false;
	}

}
