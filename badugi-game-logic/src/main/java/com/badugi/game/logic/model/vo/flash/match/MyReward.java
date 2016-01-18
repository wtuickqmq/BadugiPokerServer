package com.badugi.game.logic.model.vo.flash.match;

import java.util.HashMap;
import java.util.Map;

/**
 * 我的比赛奖励
 * 
 * @author amin
 */
public class MyReward {

	private long fbid;
	private int m;// 大师分
	private int g;// 金块
	private double am;// 奖金
	private int mf;// 比赛积分
	private int c;// 淘汰人的个数
	private Map<Integer, Integer> ts = new HashMap<Integer, Integer>();// 门票
	private Map<Integer, Integer> gs = new HashMap<Integer, Integer>();// 实物
	private String prize;// 奖品的名称

	public MyReward() {
		super();
	}

	public MyReward(long fbid, int m, int g, double am, int c,
			Map<Integer, Integer> ts, Map<Integer, Integer> gs) {
		super();
		this.fbid = fbid;
		this.m = m;
		this.g = g;
		this.am = am;
		this.c = c;
		this.ts = ts;
		this.gs = gs;
	}

	public long getFbid() {
		return fbid;
	}

	public void setFbid(long fbid) {
		this.fbid = fbid;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public double getAm() {
		return am;
	}

	public void setAm(double am) {
		this.am = am;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
	
	public int getMf() {
		return mf;
	}

	public void setMf(int mf) {
		this.mf = mf;
	}

	public Map<Integer, Integer> getTs() {
		return ts;
	}

	public void setTs(Map<Integer, Integer> ts) {
		this.ts = ts;
	}

	public Map<Integer, Integer> getGs() {
		return gs;
	}

	public void setGs(Map<Integer, Integer> gs) {
		this.gs = gs;
	}
	
	public String getPrize() {
		return prize;
	}
	
	public void setPrize(String prize) {
		this.prize = prize;
	}

}
