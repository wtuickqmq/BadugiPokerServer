package com.badugi.game.logic.model.vo.fb.newpay;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HubVo implements Serializable {
	
//	http://www.tp5.co/paycall?hub.mode=subscribe&hub.challenge=1409112829&hub.verify_token=xxx
	private String mode;
	private String challenge;
	private String verify_token;
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getChallenge() {
		return challenge;
	}
	public void setChallenge(String challenge) {
		this.challenge = challenge;
	}
	public String getVerify_token() {
		return verify_token;
	}
	public void setVerify_token(String verifyToken) {
		verify_token = verifyToken;
	}
	
	
}
