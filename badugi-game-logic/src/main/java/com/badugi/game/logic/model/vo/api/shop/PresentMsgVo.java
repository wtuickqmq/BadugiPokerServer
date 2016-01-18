package com.badugi.game.logic.model.vo.api.shop;

public class PresentMsgVo {
	private String cmd;
	/**
	 * 返回码
	 */
	private Long code;
	
	private Long rid;
	
	private String roomName;
	
	private Long fbid;
	
	private String fbname;
	
	private Integer giftId;
	
	private String giftName;
	
	public PresentMsgVo() {
		super();
	}


	public PresentMsgVo(String cmd, Long code, Long fbid, String fbname, Integer giftId, String giftName) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.fbid = fbid;
		this.fbname = fbname;
		this.giftId = giftId;
		this.giftName = giftName;
	}
	


	@Override
	public String toString() {
		
		return "好友 "+fbname +"赠送了您礼物【" + giftName + "】！";
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


	public Integer getGiftId() {
		return giftId;
	}


	public void setGiftId(Integer giftId) {
		this.giftId = giftId;
	}
	
}
