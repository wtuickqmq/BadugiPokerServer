package com.badugi.game.logic.model.vo.record;


/**
 * 初始数据_总数据
 * @author hcy
 *
 */
public class ResultTotalVo {
	private ResultPlayerVo[] result;
	private Double pot;
	private Double subpot;
	private String rake;
	private String cards;
	
	public ResultPlayerVo[] getResult() {
		return result;
	}
	public void setResult(ResultPlayerVo[] result) {
		this.result = result;
	}
	
	public Double getPot() {
		return pot;
	}
	public void setPot(Double pot) {
		this.pot = pot;
	}
	public Double getSubpot() {
		return subpot;
	}
	public void setSubpot(Double subpot) {
		this.subpot = subpot;
	}
	public String getRake() {
		return rake;
	}
	public void setRake(String rake) {
		this.rake = rake;
	}
	public String getCards() {
		return cards;
	}
	public void setCards(String cards) {
		this.cards = cards;
	}
	
}
