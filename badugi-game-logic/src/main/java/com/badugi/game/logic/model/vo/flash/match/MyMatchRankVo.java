package com.badugi.game.logic.model.vo.flash.match;

import java.util.List;

/**
 * 我的比赛排名
 * 
 * @author amin
 */
public class MyMatchRankVo {

	private String cmd;
	private int mi;
	private String mn;// 比赛名称
	private int rk;// 名次
	private double am;// 奖金
	private int g;// 金块
	private int m;// 大师分
	private List<TicketDetail> ts;
	private List<GoodsDetail> gs;
	private String rid;//奖品例表
	private int it;// 比赛是否结束提示
	private int configid;// 用户快速登记同类型的比赛
	private int ctid;// 用户自定义类型
	private int iswp=0;//默认未获奖
	

	public MyMatchRankVo() {
		super();
	}
	

	public MyMatchRankVo(String cmd, int mi, String mn, int rk, String rid) {
		super();
		this.cmd = cmd;
		this.mi = mi;
		this.mn = mn;
		this.rk = rk;
		this.rid = rid;
	
	}


	public MyMatchRankVo(String cmd, int mi, String mn, int rk, double am,
			int g, int m, List<TicketDetail> ts, List<GoodsDetail> gs,
			String rid, int it, int configid, int ctid, int iswp) {
		super();
		this.cmd = cmd;
		this.mi = mi;
		this.mn = mn;
		this.rk = rk;
		this.am = am;
		this.g = g;
		this.m = m;
		this.ts = ts;
		this.gs = gs;
		this.rid = rid;
		this.it = it;
		this.configid = configid;
		this.ctid = ctid;
		this.iswp = iswp;
	}
	
	public MyMatchRankVo(String cmd, int mi, String mn, int rk,
			String rid, int it, int configid, int ctid) {
		super();
		this.cmd = cmd;
		this.mi = mi;
		this.mn = mn;
		this.rk = rk;
		this.rid = rid;
		this.it = it;
		this.configid = configid;
		this.ctid = ctid;
	}
	
	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
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

	public int getRk() {
		return rk;
	}

	public void setRk(int rk) {
		this.rk = rk;
	}

	public double getAm() {
		return am;
	}

	public void setAm(double am) {
		this.am = am;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public List<TicketDetail> getTs() {
		return ts;
	}

	public void setTs(List<TicketDetail> ts) {
		this.ts = ts;
	}

	public List<GoodsDetail> getGs() {
		return gs;
	}

	public void setGs(List<GoodsDetail> gs) {
		this.gs = gs;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public int getIt() {
		return it;
	}

	public void setIt(int it) {
		this.it = it;
	}

	public int getConfigid() {
		return configid;
	}

	public void setConfigid(int configid) {
		this.configid = configid;
	}

	public int getCtid() {
		return ctid;
	}

	public void setCtid(int ctid) {
		this.ctid = ctid;
	}
	
	public int getIswp() {
		return iswp;
	}
	
	public void setIswp(int iswp) {
		this.iswp = iswp;
	}

}
