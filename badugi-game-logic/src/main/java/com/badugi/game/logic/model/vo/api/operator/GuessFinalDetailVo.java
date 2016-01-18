package com.badugi.game.logic.model.vo.api.operator;

public class GuessFinalDetailVo {

	private String hp;// 牌型
	private double wr;// 胜率

	public GuessFinalDetailVo() {
		super();
	}

	public GuessFinalDetailVo(String hp, double wr) {
		super();
		this.hp = hp;
		this.wr = wr;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public double getWr() {
		return wr;
	}

	public void setWr(double wr) {
		this.wr = wr;
	}

}
