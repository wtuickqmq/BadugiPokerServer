package com.badugi.game.logic.model.vo.api.match;

/**
 * 支付方式
 * @author amin
 */
public class PayWays {

	private int tp;// 支付方式类型
	private double am;// 支付数量
	private String ar;// 支付信息描述

	public PayWays() {
		super();
	}

	public PayWays(int tp, double am) {
		super();
		this.tp = tp;
		this.am = am;
	}
	
	public PayWays(int tp, double am, String ar) {
		super();
		this.tp = tp;
		this.am = am;
		this.ar = ar;
	}

	public int getTp() {
		return tp;
	}

	public void setTp(int tp) {
		this.tp = tp;
	}

	public double getAm() {
		return am;
	}

	public void setAm(double am) {
		this.am = am;
	}

	public String getAr() {
		return ar;
	}

	public void setAr(String ar) {
		this.ar = ar;
	}
	
}
