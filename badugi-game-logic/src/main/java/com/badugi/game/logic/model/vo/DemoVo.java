package com.badugi.game.logic.model.vo;

public class DemoVo {
	
	public Long id;
	/**
	 * 用户名称name
	 */
	public String name;
	/**
	 * 筹码chips
	 */
	public double chips;
	
	
	
	
	public DemoVo(Long id, String name, double chips) {
		super();
		this.id = id;
		this.name = name;
		this.chips = chips;
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getChips() {
		return chips;
	}
	public void setChips(double chips) {
		this.chips = chips;
	}
	
	
	
	
}
