package com.badugi.game.logic.model.domain.vo.game;
/**
 * @copyright：Copyright 2011  highesthelp.com All Rights Reserved
 * @author: weijie
 * @email: <a href="mailto:jackstudiomaster@gmail.com">jackie</a>
 * @createTime: 2012-11-9
 * @description：
 */
public class RoomsAsBB {

    	
	/***
	 * 游戏分组
	 */
	private String gr;
	
	/****
	 * 大盲
	 */
	private double bb;
	/***
	 * 小盲
	 */
	private double sb;
	/**
	 * 当前用户
	 */
	private int cc;

	
	// 默认带入房间的筹码
	private double defc;
	// add by fengpeijie 20150420 end
	
	// 默认带入房间的筹码
	
	private String rn;

	public RoomsAsBB(){
		super();
	}

	public RoomsAsBB(int gl, String gr, String rn, double bb, double sb, int cc,
			int cl, int sc, double eb, double defc) {
		super();
		
		this.gr = gr;
		
		this.bb = bb;
		this.sb = sb;
		this.cc = cc;
		
		this.defc = defc;
	}

	
	

	public String getGr() {
		return gr;
	}

	public void setGr(String gr) {
		this.gr = gr;
	}

	
	public double getBb() {
		return bb;
	}

	public void setBb(double bb) {
		this.bb = bb;
	}

	public double getSb() {
		return sb;
	}

	public void setSb(double sb) {
		this.sb = sb;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	

	public double getDefc() {
		return defc;
	}

	public void setDefc(double defc) {
		this.defc = defc;
	}

	/**
	 * @return rn
	 */
	public String getRn() {
		return rn;
	}

	/**
	 * @param rn 要设置的 rn
	 */
	public void setRn(String rn) {
		this.rn = rn;
	}

	
}
