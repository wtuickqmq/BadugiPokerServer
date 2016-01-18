package com.badugi.game.logic.model.vo.flash.match;

public class BlindInfoConfig {
	
	private Long blindLevel;
	private Double smallBlind;
	private Double bigBlind;
	private Double ante;
	
	public BlindInfoConfig(){
		super();
	}

	public BlindInfoConfig(Long blindLevel, Double smallBlind,
			Double bigBlind, Double ante) {
		super();
		this.blindLevel = blindLevel;
		this.smallBlind = smallBlind;
		this.bigBlind = bigBlind;
		this.ante = ante;
	}
	
	
	public Long getBlindLevel() {
		return blindLevel;
	}
	public void setBlindLevel(Long blindLevel) {
		this.blindLevel = blindLevel;
	}
	public Double getSmallBlind() {
		return smallBlind;
	}
	public void setSmallBlind(Double smallBlind) {
		this.smallBlind = smallBlind;
	}
	public Double getBigBlind() {
		return bigBlind;
	}
	public void setBigBlind(Double bigBlind) {
		this.bigBlind = bigBlind;
	}
	public Double getAnte() {
		return ante;
	}
	public void setAnte(Double ante) {
		this.ante = ante;
	}
	
	
	
	
}
