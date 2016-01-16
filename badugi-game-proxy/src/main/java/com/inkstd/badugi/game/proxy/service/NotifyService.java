package com.inkstd.badugi.game.proxy.service;

import java.util.Map;

public interface NotifyService {

	Object call_new_achieve(Map<String,String> request);
	
	Object call_new_level(Map<String,String> request);
	
	Object call_new_viplv(Map<String,String> request);
	
	Object call_new_msg(Map<String,String> request);
	
	Object call_change_exp(Map<String,String> request);
	
	Object call_change_amt(Map<String,String> request);
	
	Object call_present_chips(Map<String,String> request);

	Object call_friend_req(Map<String,String> request);
	
	Object call_horn(Map<String,String> request);

	Object call_dragon_buy(Map<String, String> request);

	Object call_plotline(Map<String, String> request);
	
	void sendToTargetsUser(String uid, Object msgObj);
	
    void sendToAllUsers(Object msgObj);
}
