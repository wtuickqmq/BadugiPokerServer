package com.badugi.game.logic.model.domain.vo.api.match.matchplayinfo;


public class PauseVo {

	private Integer ish;
	private PauseListVo ct;
	
	public PauseVo() {
		super();
	}

	public PauseVo(Integer ish, PauseListVo ct) {
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

	public PauseListVo getCt() {
		return ct;
	}

	public void setCt(PauseListVo ct) {
		this.ct = ct;
	}

	
}
