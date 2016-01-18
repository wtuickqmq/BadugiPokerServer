package com.badugi.game.logic.model.vo.flash.match;

import java.util.List;

public class MatchReturnVo {

	private String cmd;
	private List<String> mn;
	private long code;
	public MatchReturnVo() {
		super();
	}

	public MatchReturnVo(String cmd, long code, List<String> mn) {
		super();
		this.cmd = cmd;
		this.code=code;
		this.mn = mn;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public  List<String> getMn() {
		return mn;
	}

	public void setMn( List<String> mn) {
		this.mn = mn;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	
}
