package com.inkstd.badugi.game.proxy.config;

import io.nadron.app.Game;
import io.nadron.app.GameRoom;
import io.nadron.app.impl.GameRoomSession.GameRoomSessionBuilder;
import io.nadron.app.impl.SimpleGame;
import io.nadron.protocols.Protocol;
import io.nadron.protocols.impl.MessageBufferProtocol;
import io.nadron.protocols.impl.NettyObjectProtocol;
import io.nadron.protocols.impl.StringProtocol;
import io.nadron.service.LookupService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.google.common.collect.Maps;
import com.inkstd.badugi.game.proxy.proxy.app.MallServiceRoom;
import com.inkstd.badugi.game.proxy.proxy.app.PlayerServiceRoom;
import com.inkstd.badugi.game.proxy.proxy.app.RpcServiceRoom;
import com.inkstd.badugi.game.proxy.service.MallSessionManager;
import com.inkstd.badugi.game.proxy.service.PlayerSessionManager;
import com.inkstd.badugi.game.proxy.service.RpcSessionManager;
import com.inkstd.badugi.game.proxy.service.impl.RouteLookupServiceImpl;





/**
 * spring 注解配置类
 */
@Configuration
@ImportResource("classpath:/spring/proxy-config.xml")
public class ProxyConfig {

	@Autowired
	@Qualifier("messageBufferProtocol")
	private Protocol messageBufferProtocol;
	
	@Autowired
	@Qualifier("messageBufferProtocolWithTimeOut")
	private MessageBufferProtocol messageBufferProtocolWithTimeOut;


	@Autowired
	@Qualifier("webSocketProtocol")
	private Protocol webSocketProtocol;
	//
	// @Autowired
	// @Qualifier("textWebsocketEncoder")
	// private TextWebsocketEncoder textWebsocketEncoder;

	@Autowired
	@Qualifier("nettyObjectProtocol")
	private NettyObjectProtocol nettyObjectProtocol;
	@Autowired
	@Qualifier("stringProtocol")
	private StringProtocol stringProtocol;

	@Autowired
	@Qualifier("rpcSessionManager")
	private RpcSessionManager rpcSessionManager;

	@Autowired
	@Qualifier("mallSessionManager")
	private MallSessionManager mallSessionManager;

	@Autowired
	@Qualifier("playerSessionManager")
	private PlayerSessionManager playerSessionManager;

	
	public GameRoom getMallRoom(Game game, String roomName) {
		GameRoomSessionBuilder sessionBuilder = new GameRoomSessionBuilder();
		sessionBuilder.parentGame(game).gameRoomName(roomName).protocol(messageBufferProtocol);
		MallServiceRoom room = new MallServiceRoom(sessionBuilder, mallSessionManager);
		return room;
	}
	
	public GameRoom getRpcRoom(Game game, String roomName) {
		GameRoomSessionBuilder sessionBuilder = new GameRoomSessionBuilder();
		sessionBuilder.parentGame(game).gameRoomName(roomName).protocol(messageBufferProtocol);
		RpcServiceRoom room = new RpcServiceRoom(sessionBuilder, rpcSessionManager);
		return room;
	}
	
	public GameRoom getPlayerRoom(Game game, String roomName) {
		GameRoomSessionBuilder sessionBuilder = new GameRoomSessionBuilder();
		sessionBuilder.parentGame(game).gameRoomName(roomName).protocol(messageBufferProtocolWithTimeOut);
		PlayerServiceRoom room = new PlayerServiceRoom(sessionBuilder, playerSessionManager);
		return room;
	}

	
	public Game getGame(String name) {
		Game game = new SimpleGame(name, name);
		return game;
	}

	public Map<String, Game> getGameMap() {
		
		Game mall = getGame("mall");
		Game rpc = new SimpleGame("rpc", "rpc");
		Game user = new SimpleGame("user", "user");
		
		
		mall.addGameRoom(getMallRoom(mall, "mall"));
		rpc.addGameRoom(getRpcRoom(rpc, "rpc"));
		user.addGameRoom(getPlayerRoom(user, "user"));
	
		Map<String, Game> map = Maps.newHashMap();

		addGameMap(map, mall);
		addGameMap(map, rpc);
		addGameMap(map, user);
		
		return map;
	}

	private void addGameMap(Map<String, Game> src, Game game) {
		if (null != src) {
			src.put(game.getGameName(), game);
		}
	}

	public @Bean(name = "lookupService") LookupService lookupService() {

		// LookupService service = new SimpleLookupService(refKeyGameRoomMap);
		// LookupService service = new RouteLookupServiceImpl(getGame(),
		// refKeyGameRoomMap);
		LookupService service = new RouteLookupServiceImpl(getGameMap());
		return service;
	}
	//
	// public @Bean(name = "lookupService") LookupService lookupService() {
	// Map<String, GameRoom> refKeyGameRoomMap = new HashMap<String,
	// GameRoom>();
	// refKeyGameRoomMap.put("proxy", getProxyRoom("proxy"));
	// refKeyGameRoomMap.put("game", getCallRoom("game"));
	// refKeyGameRoomMap.put("robot", getRobotRoom("robot"));
	// refKeyGameRoomMap.put("mall", getMallRoom("mall"));
	// LookupService service = new RouteLookupServiceImpl(getGame(),
	// refKeyGameRoomMap);
	// return service;
	// }

}
