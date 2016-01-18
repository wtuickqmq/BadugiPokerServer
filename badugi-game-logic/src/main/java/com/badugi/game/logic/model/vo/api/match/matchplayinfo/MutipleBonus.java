package com.badugi.game.logic.model.vo.api.match.matchplayinfo;

import java.util.List;

public class MutipleBonus {

	private Integer from;//阶段最小人数
	private Integer to;//阶段最大人数
	private List<UndeterminedBonus> rs;//奖金集合
	public Integer getFrom() {
		return from;
	}
	public void setFrom(Integer from) {
		this.from = from;
	}
	public Integer getTo() {
		return to;
	}
	public void setTo(Integer to) {
		this.to = to;
	}
	public List<UndeterminedBonus> getRs() {
		return rs;
	}
	public void setRs(List<UndeterminedBonus> rs) {
		this.rs = rs;
	}
	
	
	
}
