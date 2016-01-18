package com.badugi.game.logic.model.vo.api.operator;

public class SigninDayDetailVo {

	private int day;// 某日
	private int iss;// 是否签到(1:是0:否)

	public SigninDayDetailVo() {
		super();
	}

	public SigninDayDetailVo(int day, int iss) {
		super();
		this.day = day;
		this.iss = iss;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getIss() {
		return iss;
	}

	public void setIss(int iss) {
		this.iss = iss;
	}

}
