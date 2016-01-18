package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;

public class StopBetVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cmd;
	
	public StopBetVo(){}
	public StopBetVo(String cmd){
		this.cmd = cmd;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	
}
