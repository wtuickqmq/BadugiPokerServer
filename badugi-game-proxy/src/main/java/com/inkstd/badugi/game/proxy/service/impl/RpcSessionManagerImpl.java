package com.inkstd.badugi.game.proxy.service.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.inkstd.badugi.game.common.constant.Constant;
import com.inkstd.badugi.game.proxy.model.ConsistentHash;
import com.inkstd.badugi.game.proxy.model.RpcSessionBuilder;
import com.inkstd.badugi.game.proxy.service.RpcSessionManager;


@Service("rpcSessionManager")
public class RpcSessionManagerImpl implements RpcSessionManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(RpcSessionManagerImpl.class);

	private Map<Object, RpcSessionBuilder> rpcMap;

	private AtomicBoolean balance;

	private AtomicInteger nodeIndex;

	private RpcSessionBuilder thePriority;
	
	private ConsistentHash<RpcSessionBuilder> consistentHash;
	
	private static final int RPC_NODE_NUM = 200;
	
	public RpcSessionManagerImpl() {
		rpcMap = Maps.newConcurrentMap();
		balance = new AtomicBoolean(false);
		nodeIndex = new AtomicInteger(0);
		consistentHash =  new ConsistentHash<RpcSessionBuilder>(RPC_NODE_NUM,null);
	}
	
	public synchronized RpcSessionBuilder updateRPCSessionBuilder(Object id,Integer weight,Integer balance,String macAddress,String processId,String extension){
		RpcSessionBuilder rpc = null;
		if(null!=id&&rpcMap.containsKey(id)){
			rpc = rpcMap.get(id);
			RpcSessionBuilder old = null;
			try {
				old = rpc.clone();
			} catch (CloneNotSupportedException e) {
				LOGGER.warn("",e);
			}
			if(null!=weight){
				rpc.setWeight(weight);
			}
			if(null!=balance){
				rpc.setBalance(balance);
			}
			if(null!=macAddress){
				rpc.setMacAddress(macAddress);
			}
			if(null!=processId){
				rpc.setProcessId(processId);
			}
			if(null!=extension){
				rpc.setExtension(extension);
			}
			boolean isEnableBalanceNow = rpc.getBalance()>0;
			boolean isEnableBalanceOld = null!=old&&old.getBalance()>0;
			if(isEnableBalanceNow!=isEnableBalanceOld){
				if(isEnableBalanceNow){
					consistentHash.add(rpc);
				}else{
					consistentHash.remove(rpc);
				}
				nodeIndex.set(0);
			}
			if(null!=thePriority){
				if(id!=thePriority.getId()){
					if(rpc.getWeight()>thePriority.getWeight()){
						thePriority = rpc;
					}
				}else{
					this.balance.set(rpc.getBalance()>0);
				}
			}else{
				thePriority = rpc;
			}
		}
		return rpc;
	}

	public synchronized boolean addRPCSessionBuilder(RpcSessionBuilder rpcSessionBuilder) {
		if (null != rpcSessionBuilder) {
			boolean isEnableBalance = rpcSessionBuilder.getBalance() > 0;
			if(isEnableBalance){
				consistentHash.add(rpcSessionBuilder);
				nodeIndex.set(0);
			}
			Object rpcId = rpcSessionBuilder.getId();
			rpcMap.put(rpcId, rpcSessionBuilder);
			RpcSessionBuilder frist = getRpcByWeight(Constant.ORDER_BY_ASC);
			if (null != frist) {
				if (frist.getId().equals(rpcId)) {
					balance.set(isEnableBalance);
					thePriority = frist;
				}
			}
			LOGGER.info("add.rpc value={}", rpcSessionBuilder);
			return true;
		}
		return false;
	}

	public synchronized RpcSessionBuilder getRpcByWeight(final int orderType) {
		List<RpcSessionBuilder> list = getRpcList(orderType);
		RpcSessionBuilder rpc = list.isEmpty()?null:list.get(0);
		return rpc;
	}

	@Override
	public synchronized RpcSessionBuilder removeRPCSessionBuilder(Object id) {
		RpcSessionBuilder rpc =null;
		if (rpcMap.containsKey(id)) {
			LOGGER.info("remove.rpc id={}", id);
			rpc = rpcMap.remove(id);
			if (null != rpc) {
				boolean isEnableBalance = rpc.getBalance() > 0;
				if(isEnableBalance){
					consistentHash.remove(rpc);
					nodeIndex.set(0);
				}
				if (null != thePriority) {
					if (thePriority.getId() == rpc.getId()) {
						RpcSessionBuilder nextPriority = getRpcByWeight(Constant.ORDER_BY_ASC);
						thePriority = nextPriority;
						isEnableBalance = (null!=nextPriority)?(nextPriority.getBalance()>0):false;
						balance.set(isEnableBalance);
					}
				}
				return rpc;
			}
		}
		return rpc;
	}

	public synchronized RpcSessionBuilder builderRpc() {
		RpcSessionBuilder rpc = null;
		if (!rpcMap.isEmpty()) {
			if (balance.get()) {
				int index = nodeIndex.getAndIncrement();
				if(index >= Integer.MAX_VALUE-1){
					nodeIndex.set(0);
				}
				rpc = consistentHash.get(index);
				rpc = null != rpc ? rpc : thePriority;
			} else {
				rpc = thePriority;
			}
		}
		return rpc;
	}

	public synchronized List<RpcSessionBuilder> getRpcList(final int orderType) {
		List<RpcSessionBuilder> list = Lists.newArrayList(rpcMap.values());
		if(orderType > 0){
			final int base = Constant.ORDER_BY_DESC==orderType?1:-1;
			Ordering<RpcSessionBuilder> ORDER_BY_LOAD = Ordering.natural().nullsFirst().onResultOf(new Function<RpcSessionBuilder, Integer>() {
				public Integer apply(RpcSessionBuilder input) {
					return base * input.getWeight();
				}
			});
			List<RpcSessionBuilder> result = ORDER_BY_LOAD.compound(ORDER_BY_LOAD).nullsFirst().nullsLast().sortedCopy(list);
			list = result;
		}
		return list;
	}

	public boolean getBalance() {
		return balance.get();
	}

	public RpcSessionBuilder getThePriority() {
		return thePriority;
	}

	public Map<Object, RpcSessionBuilder> getRpcMap() {
		return rpcMap;
	}
	

}
