package com.badugi.game.logic.model.vo.record;
/**
 * 总结数据___玩家信息封装
 * @author hcy
 *
 */
public class ResultPlayerVo {
	private Integer p;
	private String name;
	private Integer type;
	private Integer state;
	private Integer action;
	private Double betChips;
	private String cards;
	private String finalcards;
	private Integer cardtype;
	private Double win;
	public Integer getP() {
		return p;
	}
	public void setP(Integer p) {
		this.p = p;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getAction() {
		return action;
	}
	public void setAction(Integer action) {
		this.action = action;
	}
	
	public Double getBetChips() {
		return betChips;
	}
	public void setBetChips(Double betChips) {
		this.betChips = betChips;
	}
	public String getCards() {
		return cards;
	}
	public void setCards(String cards) {
		this.cards = cards;
	}
	public String getFinalcards() {
		return finalcards;
	}
	public void setFinalcards(String finalcards) {
		this.finalcards = finalcards;
	}
	public Double getWin() {
		return win;
	}
	public void setWin(Double win) {
		this.win = win;
	}
	public Integer getCardtype() {
		return cardtype;
	}
	public void setCardtype(Integer cardtype) {
		this.cardtype = cardtype;
	}

}
