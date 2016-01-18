package com.badugi.game.logic.model.vo.flash.match;

public class MatchVo {

	/***
	 * 比赛编号
	 */
	private Integer mi;
	/****
	 * 比赛名字
	 */
	private String mn;
	/****
	 * 速度
	 */
	private String sp;
	/****
	 * 参赛金额
	 */
	private double ma;
	/****
	 * 状态 -1 开放登记 1 比赛中 0结束 -2 人数已满
	 */
	private int st;
	/****
	 * 比赛人数
	 */
	private int mc;
	/****
	 * 当前比赛人数
	 */
	private int mnc;

	/***
	 * 比赛类型
	 */
	private int mt;

	/****
	 * 比赛等级
	 */
	private int ml;
	/***
	 * 普通/fifty 50
	 */
	private String tp;
	/**
	 * 几人桌
	 */
	private int tc;
	/**
	 * 是否参加该比赛
	 */
	private int it;

	public MatchVo() {
		super();
	}
	
	public MatchVo(Integer mi, String mn, String sp, double ma, int st, int mc,
			int mnc, int mt, int ml, String tp) {
		super();
		this.mi = mi;
		this.mn = mn;
		this.sp = sp;
		this.ma = ma;
		this.st = st;
		this.mc = mc;
		this.mnc = mnc;
		this.mt = mt;
		this.ml = ml;
		this.tp = tp;
	}

	public MatchVo(Integer mi, String mn, String sp, double ma, int st, int mc,
			int mnc, int mt, int ml, String tp, int tc) {
		super();
		this.mi = mi;
		this.mn = mn;
		this.sp = sp;
		this.ma = ma;
		this.st = st;
		this.mc = mc;
		this.mnc = mnc;
		this.mt = mt;
		this.ml = ml;
		this.tp = tp;
		this.tc = tc;
	}

	public Integer getMi() {
		return mi;
	}

	public void setMi(Integer mi) {
		this.mi = mi;
	}

	public String getMn() {
		return mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}

	public String getSp() {
		return sp;
	}

	public void setSp(String sp) {
		this.sp = sp;
	}

	public double getMa() {
		return ma;
	}

	public void setMa(double ma) {
		this.ma = ma;
	}

	public int getSt() {
		return st;
	}

	public void setSt(int st) {
		this.st = st;
	}

	public int getMc() {
		return mc;
	}

	public void setMc(int mc) {
		this.mc = mc;
	}

	public int getMnc() {
		return mnc;
	}

	public void setMnc(int mnc) {
		this.mnc = mnc;
	}

	public int getMt() {
		return mt;
	}

	public void setMt(int mt) {
		this.mt = mt;
	}

	public int getMl() {
		return ml;
	}

	public void setMl(int ml) {
		this.ml = ml;
	}

	public String getTp() {
		return tp;
	}

	public void setTp(String tp) {
		this.tp = tp;
	}

	public int getIt() {
		return it;
	}

	public void setIt(int it) {
		this.it = it;
	}

	public int getTc() {
		return tc;
	}

	public void setTc(int tc) {
		this.tc = tc;
	}

}
