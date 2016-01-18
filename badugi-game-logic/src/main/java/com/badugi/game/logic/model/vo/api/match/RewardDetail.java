package com.badugi.game.logic.model.vo.api.match;

/**
 * 赏金获得奖励内容
 * 
 * @author amin
 */
public class RewardDetail {

	private int ti;// 门票ID
	private int tt;// 门票张数
	private int oi;// 实物ID
	private int ot;// 实物个数
	private int m;// 大师分
	private int g;// 金块
	private double am;// 奖金

	public int getTi() {
		return ti;
	}

	public void setTi(int ti) {
		this.ti = ti;
	}

	public int getTt() {
		return tt;
	}

	public void setTt(int tt) {
		this.tt = tt;
	}

	public int getOi() {
		return oi;
	}

	public void setOi(int oi) {
		this.oi = oi;
	}

	public int getOt() {
		return ot;
	}

	public void setOt(int ot) {
		this.ot = ot;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public double getAm() {
		return am;
	}

	public void setAm(double am) {
		this.am = am;
	}

}
