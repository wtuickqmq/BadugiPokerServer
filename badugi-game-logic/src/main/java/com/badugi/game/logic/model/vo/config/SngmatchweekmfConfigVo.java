package com.badugi.game.logic.model.vo.config;

/**
 * 
 * @author Administrator
 *
 *SNG每周比赛奖励 [{'tl':总奖金数,'f':第一名奖金数,'s':第二名奖金数,'t':第三名奖金数,'l':每场比赛奖金
 */
public class SngmatchweekmfConfigVo {

	private int tl;
	private int f;
	private int s;
	private int t;
	private int l;
	private Integer pe;//	每积累X张换一张Y泰珠充值卡的X	int
	private Integer tj;//	每积累X张换一张Y泰珠充值卡的Y	int
	

	public SngmatchweekmfConfigVo() {
		super();
	}


	public int getTl() {
		return tl;
	}


	public void setTl(int tl) {
		this.tl = tl;
	}


	public int getF() {
		return f;
	}


	public void setF(int f) {
		this.f = f;
	}


	public int getS() {
		return s;
	}


	public void setS(int s) {
		this.s = s;
	}


	public int getL() {
		return l;
	}


	public void setL(int l) {
		this.l = l;
	}


	public Integer getPe() {
		return pe;
	}


	public void setPe(Integer pe) {
		this.pe = pe;
	}


	public Integer getTj() {
		return tj;
	}


	public void setTj(Integer tj) {
		this.tj = tj;
	}


	public int getT() {
		return t;
	}


	public void setT(int t) {
		this.t = t;
	}


	


}
