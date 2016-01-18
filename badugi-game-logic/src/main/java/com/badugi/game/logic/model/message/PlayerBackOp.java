package com.badugi.game.logic.model.message;

import java.util.List;

/**
 * @copyright：QQ2.0
 * @author: wtu
 * @email: wtuickqmq@163.com
 * @createTime: 2015-7-24
 * @description：游戏返回筹码更新
 */
public class PlayerBackOp {

	/**
	 * fbid
	 */
	private Long id;
	/**
	 * changeChips
	 */
	private double ccp;
	
	/**
	 * 返回编号
	 */
	private String aid;

	private List<PlayFunds> pf;
	
	public PlayerBackOp(){
		super();
	}
	
	public PlayerBackOp(Long id, double ccp, List<PlayFunds> pf) {
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
	
	
	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public List<PlayFunds> getPf() {
		return pf;
	}

	public void setPf(List<PlayFunds> pf) {
		this.pf = pf;
	}

}
