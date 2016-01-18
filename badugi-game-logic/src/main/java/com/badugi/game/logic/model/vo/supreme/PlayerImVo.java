package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;

public class PlayerImVo  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cmd;
	private String msg;
	private Long fbId;
	private String fbName;
	
	public PlayerImVo(){}
	
	public PlayerImVo(String cmd,String msg,Long fbId,String fbName){
		this.cmd = cmd;
		this.msg = msg;
		this.fbId =fbId;
		this.fbName = fbName;
	}
	
	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getFbId() {
		return fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	public String getFbName() {
		return fbName;
	}

	public void setFbName(String fbName) {
		this.fbName = fbName;
	}
	
}
