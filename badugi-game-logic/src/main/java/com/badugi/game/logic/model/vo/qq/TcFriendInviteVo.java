package com.badugi.game.logic.model.vo.qq;

import java.io.Serializable;

public class TcFriendInviteVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8099178562319602956L;
	
	private String inviter;
	private String[] invitees;
	private Long timestamp;
	private String context;
	public String getInviter() {
		return inviter;
	}
	public void setInviter(String inviter) {
		this.inviter = inviter;
	}
	public String[] getInvitees() {
		return invitees;
	}
	public void setInvitees(String[] invitees) {
		this.invitees = invitees;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	
	
}
