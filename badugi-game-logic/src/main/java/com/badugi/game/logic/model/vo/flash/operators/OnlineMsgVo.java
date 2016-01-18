package com.badugi.game.logic.model.vo.flash.operators;

/**
 * 上线返回值返回值
 * 
 * @version 1.0
 */
public class OnlineMsgVo {

	private String cmd;
	/**
	 * 返回码
	 */
	private Long code;

	/**
	 * 0:游戏牌友 1:鱼 2:敌人100:fb好友
	 */
	private int type;
	private Long fbid;
	private String fbname;

	public OnlineMsgVo() {
		super();
	}
	
	public OnlineMsgVo(int type, Long fbid, String fbname) {
		super();
		this.type = type;
		this.fbid = fbid;
		this.fbname = fbname;
	}
	
	public OnlineMsgVo(String cmd, Long code, int type, Long fbid, String fbname) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.type = type;
		this.fbid = fbid;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

}
