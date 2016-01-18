package com.badugi.game.logic.model.vo.api.match.matchplayinfo;

public class BonusSaiQian extends Bonus {

	
	public BonusSaiQian() {
		
	}
	

	private Integer rk;//名次
	private Integer am;//资金
	private Integer mrc;//资格赛参赛券
	private Integer pr;//奖金所占比例
	private String otp;//其他奖品
	
	public Integer getMrc() {
		return mrc;
	}
	public void setMrc(Integer mrc) {
		this.mrc = mrc;
	}
	public Integer getRk() {
		return rk;
	}
	public void setRk(Integer rk) {
		this.rk = rk;
	}
	public Integer getAm() {
		return am;
	}
	public void setAm(Integer am) {
		this.am = am;
	}
	public Integer getPr() {
		return pr;
	}
	public void setPr(Integer pr) {
		this.pr = pr;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	

}
