package com.badugi.game.logic.model.vo.api.operator;

public class SigninBoxDetailVo {

	private double cid;// 宝箱编号
	private double count;// 打开宝箱需要的签到次数
	private int iso;// 是否打开(1:是0:否)

	public SigninBoxDetailVo() {
		super();
	}

	public SigninBoxDetailVo(double cid, double count, int iso) {
		super();
		this.cid = cid;
		this.count = count;
		this.iso = iso;
	}

	public double getCid() {
		return cid;
	}

	public void setCid(double cid) {
		this.cid = cid;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	public int getIso() {
		return iso;
	}

	public void setIso(int iso) {
		this.iso = iso;
	}

}
