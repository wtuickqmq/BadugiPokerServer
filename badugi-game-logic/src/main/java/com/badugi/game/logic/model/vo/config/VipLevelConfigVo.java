package com.badugi.game.logic.model.vo.config;
/**
 * @copyright：Copyright 2011  highesthelp.com All Rights Reserved
 * @author: weijie
 * @email: <a href="mailto:jackstudiomaster@gmail.com">jackie</a>
 * @createTime: 2012-10-23
 * @description：
 */
public class VipLevelConfigVo {
	
	private int viplevel;
	private String viplevelname;
	private Double vipvalue;
	private Double expvaluetimes;
	private int period;
	private Double keepvipvalue;

	public VipLevelConfigVo() {}

	public VipLevelConfigVo(int viplevel, String viplevelname, Double vipvalue,
			Double expvaluetimes, int period, Double keepvipvalue) {
		super();
		this.viplevel = viplevel;
		this.viplevelname = viplevelname;
		this.vipvalue = vipvalue;
		this.expvaluetimes = expvaluetimes;
		this.period = period;
		this.keepvipvalue = keepvipvalue;
	}

	public int getViplevel() {
		return viplevel;
	}
	public void setViplevel(int viplevel) {
		this.viplevel = viplevel;
	}

	public String getViplevelname() {
		return viplevelname;
	}

	public void setViplevelname(String viplevelname) {
		this.viplevelname = viplevelname;
	}

	public Double getVipvalue() {
		return vipvalue;
	}

	public void setVipvalue(Double vipvalue) {
		this.vipvalue = vipvalue;
	}

	public Double getExpvaluetimes() {
		return expvaluetimes;
	}

	public void setExpvaluetimes(Double expvaluetimes) {
		this.expvaluetimes = expvaluetimes;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public Double getKeepvipvalue() {
		return keepvipvalue;
	}

	public void setKeepvipvalue(Double keepvipvalue) {
		this.keepvipvalue = keepvipvalue;
	}
	
	
	
	
	
}
