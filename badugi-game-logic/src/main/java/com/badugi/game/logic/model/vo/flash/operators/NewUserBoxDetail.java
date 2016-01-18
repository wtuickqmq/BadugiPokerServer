package com.badugi.game.logic.model.vo.flash.operators;

/**
 * 新手礼包详情
 * 
 * @author amin
 */
public class NewUserBoxDetail {

	private int sp;
	private int isf;

	public NewUserBoxDetail() {
		super();
	}

	public NewUserBoxDetail(int sp, int isf) {
		super();
		this.sp = sp;
		this.isf = isf;
	}

	public int getSp() {
		return sp;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

	public int getIsf() {
		return isf;
	}

	public void setIsf(int isf) {
		this.isf = isf;
	}

}
