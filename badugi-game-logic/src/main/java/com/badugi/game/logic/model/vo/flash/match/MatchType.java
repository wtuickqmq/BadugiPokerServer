package com.badugi.game.logic.model.vo.flash.match;

public class MatchType {
	/**
	 * 游戏类型
	 */
	private int mt;
	/**
	 * 类型名称
	 */
	private String tn;
	
	public MatchType(){
		super();
	}
	
	public MatchType(int mt, String tn) {
		super();
		this.mt = mt;
		this.tn = tn;
	}
	
	public int getMt() {
		return mt;
	}

	public void setMt(int mt) {
		this.mt = mt;
	}

	public String getTn() {
		return tn;
	}

	public void setTn(String tn) {
		this.tn = tn;
	}

 


}
