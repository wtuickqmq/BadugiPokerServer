package com.badugi.game.logic.model.domain.vo.api.match.matchplayinfo;

public class PauseListVo {

	private Integer ish;//开始人数
	private Integer htl;//结束人数
	
	public PauseListVo() {
		super();
	}

	public PauseListVo(Integer ish, Integer htl) {
		super();
		this.ish = ish;
		this.htl = htl;
	}

	public Integer getIsh() {
		return ish;
	}

	public void setIsh(Integer ish) {
		this.ish = ish;
	}

	public Integer getHtl() {
		return htl;
	}

	public void setHtl(Integer htl) {
		this.htl = htl;
	}
	
	
}
