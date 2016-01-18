package com.badugi.game.logic.model.vo.config;

/**
 * 连续登录获得筹码配置
 * @author amin
 */
public class ConnLoginChipsVo {

	private int bt;//开始天数
	private int et;//结束天数
	private double c;//获得筹码量

	public int getBt() {
		return bt;
	}

	public void setBt(int bt) {
		this.bt = bt;
	}

	public int getEt() {
		return et;
	}

	public void setEt(int et) {
		this.et = et;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

}
