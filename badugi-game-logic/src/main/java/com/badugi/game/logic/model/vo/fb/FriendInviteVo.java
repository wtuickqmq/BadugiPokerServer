package com.badugi.game.logic.model.vo.fb;

import java.io.Serializable;

public class FriendInviteVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8099178562319602956L;
	
	private String request;
	private String[] to;
	
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String[] getTo() {
		return to;
	}
	public void setTo(String[] to) {
		this.to = to;
	}
	
}
