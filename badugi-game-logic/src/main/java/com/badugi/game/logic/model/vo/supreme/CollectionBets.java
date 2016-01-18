package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;

public class CollectionBets  implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String item;
	private Double upChips;
	
	public CollectionBets(){
	}
	public CollectionBets(String item,Double upChips){
		this.item = item;
		this.upChips = upChips;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Double getUpChips() {
		return upChips;
	}
	public void setUpChips(Double upChips) {
		this.upChips = upChips;
	}
	
	

}
