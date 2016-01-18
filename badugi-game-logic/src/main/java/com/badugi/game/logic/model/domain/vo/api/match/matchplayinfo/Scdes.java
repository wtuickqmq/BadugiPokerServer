package com.badugi.game.logic.model.domain.vo.api.match.matchplayinfo;
/**
 * 实物/筹码定时赛
* 项目名称：qq1.0   
* 类名称：Scdes   
* 创建人：huangcaiyuan 
* emial: caiyuan.huang@gmail.com   
* 创建时间：Apr 10, 2013 5:37:59 PM    
* @version 1.0
 */
public class Scdes {

	private Integer ty;//0为筹码，1为实物
	private Integer ck;//玩家人数
	private Integer mgc;//累积筹码
	private String tn;//门票名称
	
	
	public Scdes() {
		super();
	}
	public Scdes(Integer ty, Integer ck, Integer mgc, String tn) {
		super();
		this.ty = ty;
		this.ck = ck;
		this.mgc = mgc;
		this.tn = tn;
	}
	public Integer getTy() {
		return ty;
	}
	public void setTy(Integer ty) {
		this.ty = ty;
	}
	public Integer getCk() {
		return ck;
	}
	public void setCk(Integer ck) {
		this.ck = ck;
	}
	public Integer getMgc() {
		return mgc;
	}
	public void setMgc(Integer mgc) {
		this.mgc = mgc;
	}
	public String getTn() {
		return tn;
	}
	public void setTn(String tn) {
		this.tn = tn;
	}
	
}
