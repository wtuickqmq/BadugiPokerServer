package io.nadron.service.impl;

import io.nadron.app.Game;
import io.nadron.app.GameRoom;
import io.nadron.app.Player;
import io.nadron.app.impl.DefaultPlayer;
import io.nadron.service.LookupService;
import io.nadron.util.Credentials;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.joker.common.util.MD5Util;

/**
 * The lookup service abstracts away the implementation detail on getting the
 * game objects from the reference key provided by the client. This lookup is
 * now done from a hashmap but can be done from database or any other manner.
 * 
 * @author Abraham Menacherry
 * 
 */
public class SimpleLookupService implements LookupService {

	private final Map<String, Game> gameMap;

	public SimpleLookupService() {
		gameMap = new HashMap<String, Game>();
	}

	public SimpleLookupService(Map<String, Game> game) {
		super();
		this.gameMap = game;
	}

	@Override
	public Game gameLookup(Object gameContextKey) {
		return gameMap.get(gameContextKey);
	}

	@Override
	public Player playerLookup(Credentials loginDetail) {
		if (null != loginDetail) {
			return new DefaultPlayer(loginDetail.getId(), loginDetail.getUsername(), loginDetail.getPassword(),MD5Util.md5(UUID.randomUUID().toString()));
		}
		return new DefaultPlayer();
	}

	@Override
	public GameRoom gameRoomLookup(Game game, Object gameContextKey) {
		if (null != game) {
			GameRoom room = game.getRoom(gameContextKey);
			return room;
		}
		return null;
	}

	@Override
	public GameRoom gameRoomLookup(Object gameContextKey) {
		Game game = gameMap.get(gameContextKey);
		if (null != game) {
			GameRoom room = game.getRoom(gameContextKey);
			return room;
		}
		return null;

	}

}
