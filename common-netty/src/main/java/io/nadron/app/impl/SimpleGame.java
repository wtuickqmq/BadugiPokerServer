package io.nadron.app.impl;

import io.nadron.app.Game;
import io.nadron.app.GameCommandInterpreter;
import io.nadron.app.GameRoom;
import io.nadron.event.Event;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Domain object representing a game. This is a convenience implementation of
 * the {@link Game} interface so that simple games need not implement their own.
 * <b>Note</b> This implementation will throw exception if any of the setter
 * methods are invoked. All variables are final in this class and expected to be
 * set at object construction.
 * 
 * @author Abraham Menacherry
 * 
 */
public class SimpleGame implements Game {

	/**
	 * This variable could be used as a database key.
	 */
	private final Object id;

	/**
	 * The name of the game.
	 */
	private final String gameName;
	/**
	 * Each game has its own specific commands. This instance will be used to
	 * transform those commands(most probably in the form of bytes) to actual
	 * java method calls.
	 */
	private final GameCommandInterpreter<Object> gameCommandInterpreter;

	private Map<String, GameRoom> gameRoomMapName;

	private Map<Long, GameRoom> gameRoomMapId;

	// private Map<Integer, GameRoom> gameRoom;

	public SimpleGame(Object id, String gameName) {
		this(id, gameName, null);
	}

	public SimpleGame(Object id, String gameName, GameCommandInterpreter<Object> gameCommandInterpreter) {
		super();
		this.id = id;
		this.gameName = gameName;
		this.gameCommandInterpreter = gameCommandInterpreter;
		this.gameRoomMapName = new HashMap<String, GameRoom>();
		this.gameRoomMapId = new HashMap<Long, GameRoom>();
	}

	/**
	 * Meant as a database access key.
	 * 
	 * @return The unique identifier of this Game.
	 */
	@Override
	public Object getId() {
		return id;
	}

	/**
	 * Meant as a database access key.
	 * 
	 * @param id
	 *            Set the unique identifier for this game.
	 */
	@Override
	public void setId(Object id) {
		throw new RuntimeException(new IllegalAccessException("Game id is a final variable to be set at Game construction. " + "It cannot be set again."));
	}

	@Override
	public String getGameName() {
		return gameName;
	}

	@Override
	public void setGameName(String gameName) {
		throw new RuntimeException(new IllegalAccessException("GameName is a final variable to be set at Game construction. " + "It cannot be set again."));
	}

	@Override
	public GameCommandInterpreter<Object> getGameCommandInterpreter() {
		return gameCommandInterpreter;
	}

	@SuppressWarnings("hiding")
	@Override
	public <Object> void setGameCommandInterpreter(GameCommandInterpreter<Object> interpreter) {
		throw new RuntimeException(new IllegalAccessException("Game id is a final variable to be set at Game construction. " + "It cannot be set again."));
	}

	@Override
	public synchronized Object unload() {
		return null;
	}

	public void setGameRoom(Map<String, GameRoom> gameRoom) {
		this.gameRoomMapName = gameRoom;
	}

	// @Override
	// public Map<String, GameRoom> getGameRoom() {
	// return gameRoomMapName;
	// }

	@Override
	public void send(Event event) {
		if (!gameRoomMapName.isEmpty()) {
			Set<String> keys = gameRoomMapName.keySet();
			for (String key : keys) {
				gameRoomMapName.get(key).send(event);
			}
		}
	}

	@Override
	public void addGameRoom(GameRoom gameRoom) {
		if (null != gameRoom) {
			String roomName = gameRoom.getGameRoomName();
			Long roomId = gameRoom.getGameRoomId();
			
			if(null!=roomName){
				this.gameRoomMapName.put(roomName, gameRoom);
			}
			if(null!=roomId){
				this.gameRoomMapId.put(roomId, gameRoom);
			}
		}
	}

	public void removeGameRoom(GameRoom room) {
		if (null != room) {
			String roomName = room.getGameRoomName();
			Long roomId = room.getGameRoomId();
			if (null != roomName) {
				gameRoomMapName.remove(roomName);
			}
			if (null != roomId) {
				gameRoomMapId.remove(roomId);
			}
			room.close();
		}
	}

	public void removeGameRoomByName(String gameRoomName) {
		if (null != gameRoomName) {
			GameRoom room = gameRoomMapName.get(gameRoomName);
			removeGameRoom(room);
		}
	}

	@Override
	public void removeGameRoomById(Long gameRoomId) {
		if (null != gameRoomId) {
			GameRoom room = gameRoomMapId.get(gameRoomId);
			removeGameRoom(room);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gameCommandInterpreter == null) ? 0 : gameCommandInterpreter.hashCode());
		result = prime * result + ((gameName == null) ? 0 : gameName.hashCode());
		result = prime * result + ((gameRoomMapName == null) ? 0 : gameRoomMapName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleGame other = (SimpleGame) obj;
		if (gameCommandInterpreter == null) {
			if (other.gameCommandInterpreter != null)
				return false;
		} else if (!gameCommandInterpreter.equals(other.gameCommandInterpreter))
			return false;
		if (gameName == null) {
			if (other.gameName != null)
				return false;
		} else if (!gameName.equals(other.gameName))
			return false;
		if (gameRoomMapName == null) {
			if (other.gameRoomMapName != null)
				return false;
		} else if (!gameRoomMapName.equals(other.gameRoomMapName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public boolean containsKey(java.lang.Object key) {
		if (null != key) {
			if (key instanceof Number) {
				return gameRoomMapId.containsKey(key);
			}
			if (key instanceof String) {
				return gameRoomMapName.containsKey(key);
			}
		}
		return false;
	}

	@Override
	public GameRoom getRoom(java.lang.Object key) {
		if (null != key) {
			if (key instanceof Number) {
				return getRoomById(Long.valueOf(key.toString()));
			} else if (key instanceof String) {
				return getRoomByName((String) key);
			}
		}
		return null;
	}

	@Override
	public GameRoom getRoomByName(String roomName) {
		return gameRoomMapName.get(roomName);
	}

	@Override
	public GameRoom getRoomById(Long roomId) {
		return gameRoomMapId.get(roomId);
	}

	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// SimpleGame other = (SimpleGame) obj;
	// if (gameName == null) {
	// if (other.gameName != null)
	// return false;
	// } else if (!gameName.equals(other.gameName))
	// return false;
	// if (id == null) {
	// if (other.id != null)
	// return false;
	// } else if (!id.equals(other.id))
	// return false;
	// return true;
	// }

}
