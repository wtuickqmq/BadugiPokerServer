package com.badugi.game.logic.model.domain.vo.flash.user;

import com.joker.common.util.Base64Util;

public class InvitationsRoomVo {
	private String cmd;
	/**
	 * 返回码
	 */
	private Long code;
	
	private Long rid; //房间id
	
	private String roomName;//房间名称
	
	private Long fbid;//邀请人id
	
	private String fbname;//邀请人 呢称
	

	public InvitationsRoomVo() {
		super();
	}


	public InvitationsRoomVo(String cmd, Long code, Long rid, String roomName,
			Long fbid, String fbname) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.rid = rid;
		this.roomName = roomName;
		this.fbid = fbid;
		this.fbname = fbname;
	}
	


	@Override
	public String toString() {
		
		return "好友 "+fbname +"邀请您到 " + Base64Util.decode2string(roomName) + " 打牌!|" + rid;
	}


	public String getRoomName() {
		return roomName;
	}


	public void setRoomName(String roomName) {
		this.roomName = roomName;
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

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	
	

}
