package com.badugi.game.logic.model.vo.api.shop;

public class HornMsgVo {
	private String cmd;
	/**
	 * 返回码
	 */
	private Long code;
	
	private Long fbid;
	
	private String fbname;

	private String msg;
	
	private Integer roomLevel;
	
	private Integer hornType;
	
	private String roomId;
	
	public HornMsgVo() {
		super();
	}

	public HornMsgVo(String cmd, Long code, Long fbid, String fbname, String msg, Integer roomLevel, Integer hornType, String roomId) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.fbid = fbid;
		this.fbname = fbname;
		this.msg = msg;
		this.roomLevel = roomLevel;
		this.hornType = hornType;
		this.roomId = roomId;
	}
	


	@Override
	public String toString() {
		
		return msg;
	}


	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}


	public Long getCode() {
		return code;
	}


	public void setCode(Long code) {
		this.code = code;
	}


	public Long getFbid() {
		return fbid;
	}


	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}


	public String getFbname() {
		return fbname;
	}


	public void setFbname(String fbname) {
		this.fbname = fbname;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Integer getRoomLevel() {
		return roomLevel;
	}


	public void setRoomLevel(Integer roomLevel) {
		this.roomLevel = roomLevel;
	}


	public Integer getHornType() {
		return hornType;
	}


	public void setHornType(Integer hornType) {
		this.hornType = hornType;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	
}
