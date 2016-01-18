package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;
import java.util.Map;

public class SimulateBetMap implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String,Boolean> isFull;
	private Map<String,Boolean> isExceeding;
    private String item;
    private Long sumChips;
    private Map<String,Long> itemChips;
    private Long chips;
    private Map<Long,Long> chipDetails;
    public SimulateBetMap(){}
    
    public SimulateBetMap(String item,Long chips,Long sumChips,Map<String,Long> itemChips,Map<String,Boolean> isFull,Map<String,Boolean> isExceeding){
    	this.isExceeding = isExceeding;
    	this.isFull = isFull;
    	this.item = item;
    	this.sumChips = sumChips;
    	this.itemChips = itemChips;
    	this.chips = chips;
    	//this.chipDetails = chipDetails;
    }
    
    public SimulateBetMap(String item,Long chips,Long sumChips,Map<String,Boolean> isFull,Map<String,Boolean> isExceeding){
    	this.isExceeding = isExceeding;
    	this.isFull = isFull;
    	this.item = item;
    	this.sumChips = sumChips;
    	
    	this.chips = chips;
    	//this.chipDetails = chipDetails;
    }
	public Map<String, Boolean> getIsFull() {
		return isFull;
	}

	public void setIsFull(Map<String, Boolean> isFull) {
		this.isFull = isFull;
	}

	public Map<String, Boolean> getIsExceeding() {
		return isExceeding;
	}

	public void setIsExceeding(Map<String, Boolean> isExceeding) {
		this.isExceeding = isExceeding;
	}

	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Long getSumChips() {
		return sumChips;
	}

	public void setSumChips(Long sumChips) {
		this.sumChips = sumChips;
	}

	public Long getChips() {
		return chips;
	}
	public void setChips(Long chips) {
		this.chips = chips;
	}
	public Map<Long, Long> getChipDetails() {
		return chipDetails;
	}
	public void setChipDetails(Map<Long, Long> chipDetails) {
		this.chipDetails = chipDetails;
	}
	public Map<String, Long> getItemChips() {
		return itemChips;
	}
	public void setItemChips(Map<String, Long> itemChips) {
		this.itemChips = itemChips;
	}
    
}
