package com.badugi.game.logic.model.vo.record;
/**
 * 玩家亮埋牌
 * @author hcy
 *
 */
public class ShowHideCardVo {
	private String cards;
	private String finalcards;
	private Double win;
	private Integer pt;
	private Integer cardtype;
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
	public Integer getPt() {
		return pt;
	}
	public void setPt(Integer pt) {
		this.pt = pt;
	}
	public Integer getCardtype() {
		return cardtype;
	}
	public void setCardtype(Integer cardtype) {
		this.cardtype = cardtype;
	}
	
}
