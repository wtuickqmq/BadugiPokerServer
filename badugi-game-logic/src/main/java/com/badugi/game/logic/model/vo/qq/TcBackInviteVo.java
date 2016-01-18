package com.badugi.game.logic.model.vo.qq;

import java.io.Serializable;

public class TcBackInviteVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8140819038825540611L;
	/**
	 * 
	 */
	
	private String msg;
	private String[] receiver;
	private Long timestamp;
	private String context;
	
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
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String[] getReceiver() {
		return receiver;
	}
	public void setReceiver(String[] receiver) {
		this.receiver = receiver;
	}
	
	
	
}
