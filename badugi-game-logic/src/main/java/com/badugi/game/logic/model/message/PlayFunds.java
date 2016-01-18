package com.badugi.game.logic.model.message;

public class PlayFunds {

	/**
	 * fbid
	 */
	private Long id;
	/**
	 * vippoints
	 */
	private double vp;
	/**
	 * points
	 */
	private double pt;
	/**
	 * ExpValue
	 */
	private Double ev;
	/**
	 * viplevel
	 */
	private int vl;
	/**
	 * masterValue(改变值) 
	 */
	private int mv;
	
	public PlayFunds(){
		super();
	}
	

	public PlayFunds(Long id, double vp, double pt, Double ev) {
		super();
		this.id = id;
		this.vp = vp;
		this.pt = pt;
		this.ev = ev;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getVp() {
		return vp;
	}

	public void setVp(double vp) {
		this.vp = vp;
	}

	public double getPt() {
		return pt;
	}

	public void setPt(double pt) {
		this.pt = pt;
	}

	public Double getEv() {
		return ev;
	}

	public void setEv(Double ev) {
		this.ev = ev;
	}

	public int getVl() {
		return vl;
	}

	public void setVl(int vl) {
		this.vl = vl;
	}
	
	public int getMv() {
		return mv;
	}
	
	public void setMv(int mv) {
		this.mv = mv;
	}
	

}
