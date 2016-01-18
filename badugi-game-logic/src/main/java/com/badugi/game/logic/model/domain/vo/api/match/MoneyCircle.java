package com.badugi.game.logic.model.domain.vo.api.match;

/**
 * 钱圈
 * 
 * @author amin
 */
public class MoneyCircle {

	private int rk;// 排名
	private int erk;//结束排名
	private int tt;//门票张数
	private int ti;//门票ID
	private int ot;//实物个数
	private int oi;//实物ID
	private int m;//大师分
	private int g;//金块
	private int etp;//门票类型
	private int mf;// 比赛积分
	private int ttp;//奖品类型(1：实物 0：门票/无)
	private String timn;//奖品图片
	private String tkn;//门票名称
	private double am;// 奖金

	public MoneyCircle() {
		super();
	}

	public MoneyCircle(int rk, double am) {
		super();
		this.rk = rk;
		this.am = am;
	}
	
	public MoneyCircle(int rk, int tt, int ti, int etp, int ttp, String tkn, double am) {
		super();
		this.rk = rk;
		this.tt = tt;
		this.ti = ti;
		this.etp = etp;
		this.ttp = ttp;
		this.tkn = tkn;
		this.am = am;
	}

	public int getRk() {
		return rk;
	}

	public void setRk(int rk) {
		this.rk = rk;
	}
	
	public int getErk() {
		if(erk < rk){
			return rk;
		}
		return erk;
	}

	public void setErk(int erk) {
		this.erk = erk;
	}

	public int getTt() {
		return tt;
	}

	public void setTt(int tt) {
		this.tt = tt;
	}

	public int getTi() {
		return ti;
	}

	public void setTi(int ti) {
		this.ti = ti;
	}
	
	public int getOt() {
		return ot;
	}

	public void setOt(int ot) {
		this.ot = ot;
	}

	public int getOi() {
		return oi;
	}

	public void setOi(int oi) {
		this.oi = oi;
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

	public int getEtp() {
		return etp;
	}

	public void setEtp(int etp) {
		this.etp = etp;
	}
	
	public int getTtp() {
		return ttp;
	}

	public void setTtp(int ttp) {
		this.ttp = ttp;
	}
	
	public String getTimn() {
		return timn;
	}

	public void setTimn(String timn) {
		this.timn = timn;
	}

	public String getTkn() {
		return tkn;
	}
	
	public int getMf() {
		return mf;
	}
	
	public void setMf(int mf) {
		this.mf = mf;
	}

	public void setTkn(String tkn) {
		this.tkn = tkn;
	}

	public double getAm() {
		return am;
	}

	public void setAm(double am) {
		this.am = am;
	}

}
