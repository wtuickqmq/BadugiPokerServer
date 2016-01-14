package io.nadron.service.impl;

import io.nadron.app.Game;
import io.nadron.app.GameRoom;
import io.nadron.service.GameAdminService;
import io.netty.channel.group.ChannelGroupFuture;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleGameAdminService implements GameAdminService<Long> {
	private Collection<Game> games;
	private Map<Long, Game> gameMapId;
	private Map<String, Game> gameMapName;

	public SimpleGameAdminService() {
		games = new ArrayList<Game>();
		gameMapId = new ConcurrentHashMap<Long, Game>();
		gameMapName = new ConcurrentHashMap<String, Game>();
	}

	@Override
	public boolean registerGame(Game game) {
		boolean flag = games.add(game);
		if (flag) {
			gameMapId.put((Long) game.getId(), game);
			gameMapName.put(game.getGameName(), game);
		}
		return games.add(game);
	}

	@Override
	public Object loadGame(Long gameId, String gameName) {
		if (gameMapId.containsKey(gameId)) {
			Game game = gameMapId.get(gameId);
			if (game.getGameName().equalsIgnoreCase(gameName)) {
				return game;
			}
		}
		return null;
	}

	@Override
	public Object loadGameRoom(Game game, Long gameRoomId, String gameRoomName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object unLoadGame(Long gameId, String gameName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object unLoadGame(Game game) {
		if (null != game) {
			ChannelGroupFuture groupFuture = (ChannelGroupFuture) game.unload();
			return groupFuture;
		}
		return null;
	}

	@Override
	public void unloadGameRoom(GameRoom gameRoom) {
		if (null != gameRoom) {
			gameRoom.close();
		}
	}

	@Override
	public Object unloadGameRoom(Game game, Long gameRoomId) {
		return null;
	}

	@Override
	public Object unloadGameRoom(Game game, String gameRoomId) {
		return null;
	}

	@Override
	public synchronized void shutdown() {
		if (null != games) {
			for (Game game : games) {
				unLoadGame(game);
			}
		}
	}

	public Collection<Game> getGames() {
		return games;
	}

	public void setGames(Collection<Game> games) {
		this.games = games;
	}

}
