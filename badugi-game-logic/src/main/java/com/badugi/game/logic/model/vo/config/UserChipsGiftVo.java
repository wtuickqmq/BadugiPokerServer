package com.badugi.game.logic.model.vo.config;

/**
 *
* 项目名称：qq1.0
* 类名称：UserChipsGiftVo
* 创建人：huangcaiyuan
* emial: caiyuan.huang@gmail.com
* 创建时间：May 29, 2013 4:54:18 PM
* @version 1.0
 */
public class UserChipsGiftVo {
	private int weekmax;// 每周最多赠送
	private int permax;// 单笔最多赠送
	private int permin;//单笔最少赠送
	private Double rebate;//折扣
	private Float tax; // 交易税

	public UserChipsGiftVo() {
		super();
	}

	public UserChipsGiftVo(int weekmax, int permax,int permin,Double rebate) {
		super();
		this.weekmax = weekmax;
		this.permax = permax;
		this.permin = permin;
		this.rebate = rebate;
	}



	public int getWeekmax() {
		return weekmax;
	}


	public void setWeekmax(int weekmax) {
		this.weekmax = weekmax;
	}


	public int getPermax() {
		return permax;
	}


	public void setPermax(int permax) {
		this.permax = permax;
	}

	public int getPermin() {
		return permin;
	}

	public void setPermin(int permin) {
		this.permin = permin;
	}

	public Double getRebate() {
		return rebate;
	}

	public void setRebate(Double rebate) {
		this.rebate = rebate;
	}

	public void setTax(Float tax) {
		this.tax = tax;
	}

	public Float getTax() {
		return tax;
	}
}
