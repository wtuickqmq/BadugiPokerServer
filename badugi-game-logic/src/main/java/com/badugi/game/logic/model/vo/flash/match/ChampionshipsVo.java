package com.badugi.game.logic.model.vo.flash.match;

import com.badugi.game.logic.model.domain.vo.flash.ResultVo;


public class ChampionshipsVo extends ResultVo {

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
	 * 状态 -1 开放登记 1 比赛中 0结束 -2 人数已满 4报名截止
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
	/***
	 * 奖池
	 */
	private double aa;
	/****
	 * 比赛报名结束时间
	 */
	private String spt;
	/**
	 * 比赛开始时间
	 */
	private String stt;
	/**
	 * 比赛主要奖品图片名称
	 */
	private String pin;
	/**
	 * 排序参照值
	 */
	private int sv;
	/**
	 * 坐满就玩
	 */
	private int gs;
	//wtu.edit
	/**
	 * 距离比赛开始时间
	 */
	private int lst;
	
	/**
	 * 是否为密码房 true 有密码、false 没有密码
	 */
	private boolean ispwd;
	
	/**
	 * 参赛费用
	 */
	private double jfc;
	/**
	 * 服务费
	 */
	private double fwc;
	/**
	 * 赏金(当且仅当只有一种赏金的时候)
	 */
	private double rc;
	/**
	 * 
	 * 服务器id
	 */
	private String matchServerId;
	
    //wtu.edit
	public ChampionshipsVo() {
		super("Championships");
	}

	public ChampionshipsVo(Integer mi, String mn, String sp, double ma, int st,
			int mc, int mnc, int mt, int ml, String tp, String spt, String stt, double aa,int lst,boolean ispwd,
			double jfc,double fwc,double rc) {
		super("Championships");
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
		this.spt = spt;
		this.stt = stt;
		this.aa = aa;
		this.lst=lst;
		this.ispwd=ispwd;
		this.jfc=jfc;
		this.fwc=fwc;
		this.rc=rc;
	}

	public String getMatchServerId() {
		return matchServerId;
	}

	public void setMatchServerId(String matchServerId) {
		this.matchServerId = matchServerId;
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

	public int getTc() {
		return tc;
	}

	public void setTc(int tc) {
		this.tc = tc;
	}

	public int getIt() {
		return it;
	}

	public void setIt(int it) {
		this.it = it;
	}

	public double getAa() {
		return aa;
	}

	public void setAa(double aa) {
		this.aa = aa;
	}

	public String getSpt() {
		return spt;
	}

	public void setSpt(String spt) {
		this.spt = spt;
	}

	public String getStt() {
		return stt;
	}

	public void setStt(String stt) {
		this.stt = stt;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public int getSv() {
		return sv;
	}

	public void setSv(int sv) {
		this.sv = sv;
	}

	public int getGs() {
		return gs;
	}

	public void setGs(int gs) {
		this.gs = gs;
	}

	public int getLst() {
		return lst;
	}

	public void setLst(int lst) {
		this.lst = lst;
	}

	public boolean isIspwd() {
		return ispwd;
	}

	public void setIspwd(boolean ispwd) {
		this.ispwd = ispwd;
	}
	

	public double getJfc() {
		return jfc;
	}

	public void setJfc(double jfc) {
		this.jfc = jfc;
	}

	public double getFwc() {
		return fwc;
	}

	public void setFwc(double fwc) {
		this.fwc = fwc;
	}

	public double getRc() {
		return rc;
	}

	public void setRc(double rc) {
		this.rc = rc;
	}

	@Override
	public String toString() {
		return "ChampionshipsVo [mi=" + mi + ", mn=" + mn + ", sp=" + sp
				+ ", ma=" + ma + ", st=" + st + ", mc=" + mc + ", mnc=" + mnc
				+ ", mt=" + mt + ", ml=" + ml + ", tp=" + tp + ", tc=" + tc
				+ ", it=" + it + ", aa=" + aa + ", spt=" + spt + ", stt=" + stt
				+ ", pin=" + pin + ", sv=" + sv + ", gs=" + gs + ", lst=" + lst
				+ ", ispwd=" + ispwd + "]";
	}
	
	
	
	
	
}
