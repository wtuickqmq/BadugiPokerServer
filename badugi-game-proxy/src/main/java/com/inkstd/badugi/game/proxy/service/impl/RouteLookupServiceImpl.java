package com.inkstd.badugi.game.proxy.service.impl;

import io.nadron.app.Game;
import io.nadron.app.GameRoom;
import io.nadron.app.Player;
import io.nadron.app.impl.DefaultPlayer;
import io.nadron.service.GameAdminService;
import io.nadron.service.LookupService;
import io.nadron.util.Credentials;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.inkstd.badugi.game.common.constant.Constant;
import com.joker.common.util.MD5Util;
import com.joker.common.util.MathUtil;


public class RouteLookupServiceImpl implements LookupService {

	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(RouteLookupServiceImpl.class);

	private Map<String, Game> gameMap;

	@Autowired
	private GameAdminService  gameAdminService;
	
	public RouteLookupServiceImpl(Map<String, Game> gameMap) {
		super();
		this.gameMap = gameMap;
	}

	@Override
	public Game gameLookup(Object gameContextKey) { // 目前是单游戏机制
		return gameMap.get(gameContextKey);
	}

	@Override
	public GameRoom gameRoomLookup(Object gameContextKey) { // 随机返回房间
		if (gameContextKey == null) {
			gameContextKey = "guest";
		} else if (gameContextKey.toString().startsWith("v")) {
			gameContextKey = "guest";
		}
		if (gameContextKey instanceof String) {
			try {
				GameRoom gameRoom = gameMap.get(gameContextKey).getRoom((String) gameContextKey + MathUtil.randInt(Constant.ROOM_MAX_NUM));
				if (gameRoom != null)
					return gameRoom;
			} catch (Exception e) {
				LOGGER.warn("gameContextKey = [{}]", gameContextKey);
			}
			return gameMap.get(gameContextKey).getRoom((String) gameContextKey);
		}
		return null;
	}

	/**
	 * 获取登录用户游戏数据, 并进行简单的安全验证 第一次创角统一走设备号绑定, 后面逻辑进行绑定,可以使用合作号登陆
	 */
	@Override
	public Player playerLookup(Credentials loginDetail) {
		if(null!=loginDetail){
			return new DefaultPlayer(loginDetail.getId(), loginDetail.getUsername(), loginDetail.getPassword(),MD5Util.md5(UUID.randomUUID().toString()));
		}
		return null;
	}


	@Override
	public GameRoom gameRoomLookup(Game game, Object gameContextKey) {
		if (null != game) {
			GameRoom gameRoom = game.getRoom(gameContextKey);
			return gameRoom;
		}
		return null;
	}

}
