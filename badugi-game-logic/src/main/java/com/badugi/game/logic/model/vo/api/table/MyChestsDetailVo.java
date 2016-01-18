package com.badugi.game.logic.model.vo.api.table;

public class MyChestsDetailVo {

	/**
	 * 猜大小
	 */
	public static final Integer TYPE_1 = 1;
	/**
	 * 倒计时宝箱
	 */
	public static final Integer TYPE_2 = 2;

	private int type;// 类型（1：猜大小2：宝箱）
	private int step;// 到了第几步
	private int value;// 值(type==2时为宝箱倒计时时间)

	public MyChestsDetailVo() {
		super();
	}

	public MyChestsDetailVo(int type, int step, int value) {
		super();
		this.type = type;
		this.step = step;
		this.value = value;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
