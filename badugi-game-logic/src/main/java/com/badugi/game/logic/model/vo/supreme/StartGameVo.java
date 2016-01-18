package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;

/**
 * 
 * @author qazwsxedc
 *
 */
public class StartGameVo  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cmd;
	private long terminalTime;

	public StartGameVo(){}
	public StartGameVo(String cmd,long terminalTime){
		this.terminalTime = terminalTime;
	}
	
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public long getTerminalTime() {
		return terminalTime;
	}
	public void setTerminalTime(long terminalTime) {
		this.terminalTime = terminalTime;
	}
	
}
