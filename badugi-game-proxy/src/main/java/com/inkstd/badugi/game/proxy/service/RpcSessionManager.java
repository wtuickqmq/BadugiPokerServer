package com.inkstd.badugi.game.proxy.service;

import java.util.List;
import java.util.Map;

import com.inkstd.badugi.game.proxy.model.RpcSessionBuilder;


public interface RpcSessionManager {

	List<RpcSessionBuilder> getRpcList(final int orderType);
	
	RpcSessionBuilder builderRpc();

	RpcSessionBuilder getRpcByWeight(final int orderType);
	
	RpcSessionBuilder updateRPCSessionBuilder(Object id,Integer weight,Integer balance,String macAddress,String processId,String extension);
	
	boolean addRPCSessionBuilder(RpcSessionBuilder rpcSessionBuilder);

	RpcSessionBuilder removeRPCSessionBuilder(Object id);
	
	boolean getBalance();
	
	Map<Object, RpcSessionBuilder> getRpcMap() ;
	
	RpcSessionBuilder getThePriority() ;
}
