package com.badugi.game.logic.model.vo.flash.match;

/**
 * 今日大赛
 * 
 * @author amin
 */
public class TodayMatchs {

	private int mid;
	private String mn;
	private String mst;
	private int st;

	public TodayMatchs() {
		super();
	}

	public TodayMatchs(int mid, String mn, String mst) {
		super();
		this.mid = mid;
		this.mn = mn;
		this.mst = mst;
	}

	public TodayMatchs(int mid, String mn, String mst, int st) {
		super();
		this.mid = mid;
		this.mn = mn;
		this.mst = mst;
		this.st = st;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMn() {
		return mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}

	public String getMst() {
		return mst;
	}

	public void setMst(String mst) {
		this.mst = mst;
	}

	public int getSt() {
		return st;
	}

	public void setSt(int st) {
		this.st = st;
	}

}
