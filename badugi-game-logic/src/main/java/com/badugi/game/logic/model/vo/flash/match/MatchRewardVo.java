package com.badugi.game.logic.model.vo.flash.match;

import java.util.List;

/**
 * 淘汰用户获得赏金
 * 
 * @author amin
 */
public class MatchRewardVo {

	private String cmd;
	private int mi;
	private String rid;
	private int ac;
	private double am;
	private int g;
	private int m;
	private List<TicketDetail> ts;
	private List<GoodsDetail> gs;

	public MatchRewardVo() {
		super();
	}

	public MatchRewardVo(String cmd, int mi, String rid, int ac, double am,
			int g, int m, List<TicketDetail> ts, List<GoodsDetail> gs) {
		super();
		this.cmd = cmd;
		this.mi = mi;
		this.rid = rid;
		this.ac = ac;
		this.am = am;
		this.g = g;
		this.m = m;
		this.ts = ts;
		this.gs = gs;
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

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public void setMi(int mi) {
		this.mi = mi;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
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

}
