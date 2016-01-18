package com.badugi.game.logic.model.vo.api.match.matchplayinfo;

public class ConInfo {

	private Integer ish;
	private String ct;
	
	public ConInfo() {
		super();
	}
	
	public ConInfo(Integer ish, String ct) {
		super();
		this.ish = ish;
		this.ct = ct;
	}
	
	public Integer getIsh() {
		return ish;
	}

	public void setIsh(Integer ish) {
		this.ish = ish;
	}

	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}
	
	
}
