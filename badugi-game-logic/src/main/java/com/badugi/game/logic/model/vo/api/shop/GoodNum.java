package com.badugi.game.logic.model.vo.api.shop;

import java.io.Serializable;

public class GoodNum implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer gp ;
	private Integer gc;
	public Integer getGp() {
		return gp;
	}
	public void setGp(Integer gp) {
		this.gp = gp;
	}
	public Integer getGc() {
		return gc;
	}
	public void setGc(Integer gc) {
		this.gc = gc;
	}
	public GoodNum(Integer gp, Integer gc) {
		super();
		this.gp = gp;
		this.gc = gc;
	}
	public GoodNum() {
		super();
		// TODO Auto-generated constructor stub
	}
}
