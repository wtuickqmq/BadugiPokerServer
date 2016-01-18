package com.badugi.game.logic.model.vo.api.operator;

public class DayPrizesDetail {

	private int d;
	private int c;
	private int g;

	public DayPrizesDetail() {
		super();
	}

	public DayPrizesDetail(int d, int c, int g) {
		super();
		this.d = d;
		this.c = c;
		this.g = g;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

}
