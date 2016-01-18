package com.badugi.game.logic.model.message;

import java.util.List;

/**
 * @copyright：Copyright 2011 highesthelp.com All Rights Reserved
 * @author: weijie
 * @email: <a href="mailto:jackstudiomaster@gmail.com">jackie</a>
 * @createTime: 2012-11-9
 * @description：游戏应用端财务信息更新请求参数
 */
public class FundOp {

	/**
	 * fbid
	 */
	private Long id;
	/**
	 * changeChips
	 */
	private double ccp;

	private List<PlayFunds> pf;
	
	public FundOp(){
		super();
	}
	
	public FundOp(Long id, double ccp, List<PlayFunds> pf) {
		super();
		this.id = id;
		this.ccp = ccp;
		this.pf = pf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCcp() {
		return ccp;
	}

	public void setCcp(double ccp) {
		this.ccp = ccp;
	}

	public List<PlayFunds> getPf() {
		return pf;
	}

	public void setPf(List<PlayFunds> pf) {
		this.pf = pf;
	}

}
