package com.badugi.game.logic.model.vo.api.match.matchplayinfo.acgl;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class CuragentVo extends ResultVo{

	private Long code;
	private String desc;
	private Long cfbid;//:当前代理商ID long
	private String cun;//: 当前代理商名称 string
	private String cph;//: 当前电话 string
	private Long ccp;//: 当前筹码(int)
	private Integer sm;//:出售金额(int)
	private Integer sc;//:出售筹码量(int)
	private Integer bm;//:收购金额(int)
	private Integer bc;//:收购筹码量(int)
	private Integer st;//:代理描述说明风格(int) 1、2、3

	
	public Long getCfbid() {
		return cfbid;
	}
	public void setCfbid(Long cfbid) {
		this.cfbid = cfbid;
	}
	public String getCun() {
		return cun;
	}
	public void setCun(String cun) {
		this.cun = cun;
	}
	public String getCph() {
		return cph;
	}
	public void setCph(String cph) {
		this.cph = cph;
	}
	public Long getCcp() {
		return ccp;
	}
	public void setCcp(Long ccp) {
		this.ccp = ccp;
	}
	
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getSm() {
		return sm;
	}
	public void setSm(Integer sm) {
		this.sm = sm;
	}
	public Integer getSc() {
		return sc;
	}
	public void setSc(Integer sc) {
		this.sc = sc;
	}
	public Integer getBm() {
		return bm;
	}
	public void setBm(Integer bm) {
		this.bm = bm;
	}
	public Integer getBc() {
		return bc;
	}
	public void setBc(Integer bc) {
		this.bc = bc;
	}
	public Integer getSt() {
		return st;
	}
	public void setSt(Integer st) {
		this.st = st;
	}
	
	

}
