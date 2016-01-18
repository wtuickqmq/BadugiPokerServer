package com.badugi.game.logic.model.domain.vo.flash.api;

public class ShakeTypeVo {
	
	private Integer type;
	private Long chip;
	
	
	public ShakeTypeVo() {
		super();
	}
	
	public ShakeTypeVo(Integer type, Long chip) {
		super();
		this.type = type;
		this.chip = chip;
	}

	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getChip() {
		return chip;
	}
	public void setChip(Long chip) {
		this.chip = chip;
	}

}
