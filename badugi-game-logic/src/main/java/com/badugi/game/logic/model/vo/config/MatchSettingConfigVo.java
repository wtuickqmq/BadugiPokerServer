package com.badugi.game.logic.model.vo.config;

public class MatchSettingConfigVo {
	/***
	 * 周期 1天 2周 3月
	 */
	private Integer c;
	/***
	 * 延后几天开赛
	 */
	private Integer a;
	/*****
	 * 每周星期几 1~7
	 */
	private Integer w;
	/****
	 * 每月几号
	 */
	private Integer d;
	/***
	 * 报名开始时间
	 */
	private String ot;
	/***
	 * 报名结束时间
	 */
	private String ct;
	/***
	 * 比赛开始时间
	 */
	private String bt;
	
	
	
	
	
	
	
	public Integer getA() {
		return a;
	}
	public void setA(Integer a) {
		this.a = a;
	}
	public Integer getC() {
		return c;
	}
	public void setC(Integer c) {
		this.c = c;
	}
	public Integer getW() {
		return w;
	}
	public void setW(Integer w) {
		this.w = w;
	}
	public Integer getD() {
		return d;
	}
	public void setD(Integer d) {
		this.d = d;
	}
	public String getOt() {
		return ot;
	}
	public void setOt(String ot) {
		this.ot = ot;
	}
	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}
	public String getBt() {
		return bt;
	}
	public void setBt(String bt) {
		this.bt = bt;
	}
	
	
	
	
	
	
}
