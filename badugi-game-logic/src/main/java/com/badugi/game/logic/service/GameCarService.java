package com.badugi.game.logic.service;

import java.util.Map;
import java.util.Set;

import com.badugi.game.logic.model.callback.RPCService;

public interface GameCarService extends RPCService {

	void addSession(String session);
	
//	Set<String> getWaitList();

	Set<String> getSessionList();

	// void removeSession(String session);

	void removeUser(String fbId);

	void sendToAll(Object data);
	
	void sendToServerAll(Object data);
	
	void sendToTargets(String channelId, Object data);

	boolean getIsOpen();
	
	String getLotteryResults();
	
    void setLotteryResults(String lotteryResults);
    
    Long getBegintime();
    
    Long getEndtime();
    
    boolean getRandomResult();
    
    int getUserCount();
     
    Map<String, Long> betLimit(Long allChips);
    
    Map<String, Boolean> betIsExceeding(Map<String, Long> map, Long chips);
}
