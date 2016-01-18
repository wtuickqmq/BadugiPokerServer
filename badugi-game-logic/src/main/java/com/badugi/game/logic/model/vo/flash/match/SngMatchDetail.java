package com.badugi.game.logic.model.vo.flash.match;

import java.util.ArrayList;
import java.util.List;

/**
 * SNG赛
 * 
 * @author amin
 */
public class SngMatchDetail {
	private String cmd;
	private long code;

	private int mi;//赛事编号
	private String mn;//比赛名称
	private int c;//总参赛人数
	private int n;//当前参赛人数
	private int cp;//报名筹码
	private int ct;//每场第一名充值卡数
	private int wt;//每周排行第一名充值卡
	private int ns;//赛状态
	private int ms;//我的参赛状态 
	private List<SngMatchWeekFen> wlist = new ArrayList<SngMatchWeekFen>();// 本周积分排行

	public SngMatchDetail() {
		super();
	}

	public SngMatchDetail(int mi, String mn, int c, int n, int cp, int ns, int ms) {
		super();
		this.mi = mi;
		this.mn = mn;
		this.c = c;
		this.n = n;
		this.cp = cp;
		this.ns = ns;
		this.ms = ms;
	}
	
	public SngMatchDetail(int mi, String mn, int c, int n, int cp, int ct,
			int wt, int ns, int ms, List<SngMatchWeekFen> wlist) {
		super();
		this.mi = mi;
		this.mn = mn;
		this.c = c;
		this.n = n;
		this.cp = cp;
		this.ct = ct;
		this.wt = wt;
		this.ns = ns;
		this.ms = ms;
		this.wlist = wlist;
	}



	public int getMi() {
		return mi;
	}

	public void setMi(int mi) {
		this.mi = mi;
	}

	public String getMn() {
		return mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public int getCt() {
		return ct;
	}

	public void setCt(int ct) {
		this.ct = ct;
	}

	public int getWt() {
		return wt;
	}

	public void setWt(int wt) {
		this.wt = wt;
	}

	public int getNs() {
		return ns;
	}

	public void setNs(int ns) {
		this.ns = ns;
	}

	public int getMs() {
		return ms;
	}

	public void setMs(int ms) {
		this.ms = ms;
	}

	public List<SngMatchWeekFen> getWlist() {
		return wlist;
	}

	public void setWlist(List<SngMatchWeekFen> wlist) {
		this.wlist = wlist;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	
}
