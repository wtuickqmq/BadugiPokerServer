package com.badugi.game.logic.model.vo.api.poker;

public class NewLevelVo {
	private Integer lv;
	private Integer chips;
	public Integer getLv() {
		return lv;
	}
	public void setLv(Integer lv) {
		this.lv = lv;
	}
	public Integer getChips() {
		return chips;
	}
	public void setChips(Integer chips) {
		this.chips = chips;
	}
	@Override
	public String toString() {
		return "GameOverExpLevelSubVo [lv=" + lv + ", chips=" + chips + "]";
	}

}
