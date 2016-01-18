package com.badugi.game.logic.model.vo.flash.match;

public class SyscancelMatchVo {

	private String cmd;
	private long code;
	private int type;
	private int mi;
	private String mn;
	private String mt;

	public SyscancelMatchVo() {
		super();
	}

	public SyscancelMatchVo(String cmd, long code, int type, int mi, String mn, String mt) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.type = type;
		this.mi = mi;
		this.mn = mn;
		this.mt = mt;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getMi() {
		return mi;
	}

	public void setMi(int mi) {
		this.mi = mi;
	}

	public String getMn() {
		return mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}

	public String getMt() {
		return mt;
	}

	public void setMt(String mt) {
		this.mt = mt;
	}

}
