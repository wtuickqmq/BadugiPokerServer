package com.inkstd.badugi.game.proxy.proxy.app;

import io.nadron.app.Player;
import io.nadron.app.PlayerSession;
import io.nadron.app.impl.GameRoomSession;
import io.nadron.common.http.Request;
import io.nadron.util.ObjectBeanUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inkstd.badugi.game.proxy.model.RpcSessionBuilder;
import com.inkstd.badugi.game.proxy.proxy.handler.RPCRoomSessionHandler;
import com.inkstd.badugi.game.proxy.proxy.handler.RPCServiceHandler;
import com.inkstd.badugi.game.proxy.service.RpcSessionManager;



public class RpcServiceRoom extends GameRoomSession {

	private static final Logger LOGGER = LoggerFactory.getLogger(RpcServiceRoom.class);

	private RpcSessionManager rpcSessionManager;

	public RpcServiceRoom(GameRoomSessionBuilder sessionBuilder, RpcSessionManager rpcSessionManager) {
		super(sessionBuilder);
		this.rpcSessionManager = rpcSessionManager;
		addHandler(new RPCRoomSessionHandler(this));
	}

	@Override
	public void onLogin(PlayerSession session) {
//		Player rpcPlayer = session.getPlayer();
		String rcpDetail = session.getKey().toString();
		RpcSessionBuilder rpc = null;
		try {
			rpc = ObjectBeanUtil.JACKSON.readValue(rcpDetail, RpcSessionBuilder.class);
			rpc.setSession(session);
			rpc.setId(session.getId());
		} catch (Exception e) {
			rpc = new RpcSessionBuilder(session);
			LOGGER.warn("convert exception:", e);
			LOGGER.warn("convert rcpDetail:", rcpDetail);
		} finally {
			RPCServiceHandler listener = new RPCServiceHandler(session);
			session.addHandler(listener);
			rpcSessionManager.addRPCSessionBuilder(rpc);
		}

	}

	@Override
	public String onHTTPRequest(Request request) {
		return null;
	}


}
