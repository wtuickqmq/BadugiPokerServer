package com.badugi.game.logic.model.domain.vo.flash.operators;

/**
 * 帅列表
 * 
 * @author amin
 */
public class SmartResult {

	private String fbid;
	private Double profit;

	public SmartResult() {
		super();
	}

	public SmartResult(String fbid, Double profit) {
		super();
		this.fbid = fbid;
		this.profit = profit;
	}

	public String getFbid() {
		return fbid;
	}

	public void setFbid(String fbid) {
		this.fbid = fbid;
	}

	public Double getProfit() {
		return profit;
	}

	public void setProfit(Double profit) {
		this.profit = profit;
	}

}
