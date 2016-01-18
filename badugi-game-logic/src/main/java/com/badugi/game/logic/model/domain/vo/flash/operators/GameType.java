package com.badugi.game.logic.model.domain.vo.flash.operators;

public class GameType {

	/**
	 * 游戏类型
	 */
	private int gt;
	/**
	 * 类型名称
	 */
	private String tn;
	
	public GameType(){
		super();
	}
	
	public GameType(int gt, String tn) {
		super();
		this.gt = gt;
		this.tn = tn;
	}

	public int getGt() {
		return gt;
	}

	public void setGt(int gt) {
		this.gt = gt;
	}

	public String getTn() {
		return tn;
	}

	public void setTn(String tn) {
		this.tn = tn;
	}

}
