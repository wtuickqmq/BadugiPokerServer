package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;

public class PrizeEntry  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String item;  //奖项
	private Integer odds;//赔率
	public PrizeEntry(){}
	public PrizeEntry(String item,Integer odds){
		this.item = item;
		this.odds = odds;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Integer getOdds() {
		return odds;
	}
	public void setOdds(Integer odds) {
		this.odds = odds;
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PrizeEntry [item=" + item + ", odds=" + odds + "]";
	}
	
	
	
}
