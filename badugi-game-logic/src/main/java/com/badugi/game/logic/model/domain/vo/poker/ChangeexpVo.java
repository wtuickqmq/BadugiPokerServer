package com.badugi.game.logic.model.domain.vo.poker;

public class ChangeexpVo {
	private Integer lv;
	private Integer exp;
	private Integer nextexp;
	public ChangeexpVo(Integer lv, Integer exp, Integer nextexp) {
		super();
		this.lv = lv;
		this.exp = exp;
		this.nextexp = nextexp;
	}
	public Integer getLv() {
		return lv;
	}
	public void setLv(Integer lv) {
		this.lv = lv;
	}
	public Integer getExp() {
		return exp;
	}
	public void setExp(Integer exp) {
		this.exp = exp;
	}
	public Integer getNextexp() {
		return nextexp;
	}
	public void setNextexp(Integer nextexp) {
		this.nextexp = nextexp;
	}
	
	@Override
	public String toString() {
		return "ChangeexpVo [lv=" + lv + ", exp=" + exp + ", nextexp="
				+ nextexp + "]";
	}
	
}
