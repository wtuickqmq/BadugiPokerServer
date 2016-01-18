package com.badugi.game.logic.model.vo.record;
/**
 * 初始数据___玩家信息封装
 * @author hcy
 *
 */
public class InitPlayerVo {
	private Integer p;
	private String nn;
	private Double chips;
	private String cards;
	private String state;
	private Double db;
	private Double nb;
	private Long h;
	
	public Double getDb() {
		return db;
	}
	public void setDb(Double db) {
		this.db = db;
	}
	public Double getNb() {
		return nb;
	}
	public void setNb(Double nb) {
		this.nb = nb;
	}
	public Integer getP() {
		return p;
	}
	public void setP(Integer p) {
		this.p = p;
	}
	public String getNn() {
		return nn;
	}
	public void setNn(String nn) {
		this.nn = nn;
	}
	
	public Double getChips() {
		return chips;
	}
	public void setChips(Double chips) {
		this.chips = chips;
	}
	public String getCards() {
		return cards;
	}
	public void setCards(String cards) {
		this.cards = cards;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getH() {
		return h;
	}
	public void setH(Long h) {
		this.h = h;
	}
	
	
	
}
