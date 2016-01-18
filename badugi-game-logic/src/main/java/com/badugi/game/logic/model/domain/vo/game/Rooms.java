package com.badugi.game.logic.model.domain.vo.game;
/**
 * @copyright：Copyright 2011  highesthelp.com All Rights Reserved
 * @author: weijie
 * @email: <a href="mailto:jackstudiomaster@gmail.com">jackie</a>
 * @createTime: 2012-11-9
 * @description：
 */
public class Rooms {
	
	/***
	 * 房间ID
	 */
	private String rid;
	/***
	 * 游戏类型
	 */
	private int gt;
	/***
	 * 游戏等级
	 */
	private int gl;
	/***
	 * 房间名称
	 */
	private String rn;
	/****
	 * 分组ID
	 */
	private String gid;
	/****
	 * 大盲
	 */
	private double bb;
	/***
	 * 小盲
	 */
	private double sb;
	/***
	 * 最大用户数
	 */
	private int mc;
	/**
	 * 当前用户
	 */
	private int cc;
	/***
	 * 最高挈带
	 */
	private double mxp;
	/****
	 * 最小挈带
	 */
	private double mip;
	/***
	 * 速度
	 */
	private int sp;
	/**
	 * 平均底池
	 */
	//private double ap;
	/**
	 * 翻牌率
	 */
	//private double fr;
	/**
	 * 局数/每小时
	 */
	//private int rh;
	/**
	 * 是否坐下
	 */
	//private boolean st;
	/**
	 * 是否筹码超出锁住
	 */
	//private int clk;
	/**
	 * 是否筹码不足并等级不够锁住
	 */
	private int lk;
	
	private int cl;
	private int sc;
	/**
	 * wtu.add 2015-10-12
	 * 房间新老用户分组类型
	 */
	private int rt;
	
	private int truePlayers;
	
	// add by fengpeijie 20150420 begin
	// 必下房提前下注金额
	private double eb;
	// 默认带入房间的筹码
	private double defc;
	// add by fengpeijie 20150420 end
	
	// 默认带入房间的筹码

	public Rooms(){
		super();
	}

	public Rooms(String rid, int gt, int gl, String rn, String gid, double bb,
			double sb, int mc, int cc, double mxp, double mip, int sp,int cl,int sc) {
		super();
		this.rid = rid;
		this.gt = gt;
		this.gl = gl;
		this.rn = rn;
		this.gid = gid;
		this.bb = bb;
		this.sb = sb;
		this.mc = mc;
		this.cc = cc;

		this.sp = sp;
		this.cl = cl;
		this.sc = sc;
	}
	


	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public int getGt() {
		return gt;
	}
	public void setGt(int gt) {
		this.gt = gt;
	}
	public int getGl() {
		return gl;
	}
	public void setGl(int gl) {
		this.gl = gl;
	}
	public String getRn() {
		return rn;
	}
	public void setRn(String rn) {
		this.rn = rn;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public double getBb() {
		return bb;
	}
	public void setBb(double bb) {
		this.bb = bb;
	}
	public double getSb() {
		return sb;
	}
	public void setSb(double sb) {
		this.sb = sb;
	}
	public int getMc() {
		return mc;
	}
	public void setMc(int mc) {
		this.mc = mc;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	
	public int getSp() {
		return sp;
	}
	public void setSp(int sp) {
		this.sp = sp;
	}
	
	public double getMxp() {
		return mxp;
	}

	public void setMxp(double mxp) {
		this.mxp = mxp;
	}

	public double getMip() {
		return mip;
	}

	public void setMip(double mip) {
		this.mip = mip;
	}

	public int getLk() {
		return lk;
	}
	public void setLk(int lk) {
		this.lk = lk;
	}

	public int getCl() {
		return cl;
	}

	public void setCl(int cl) {
		this.cl = cl;
	}

	public int getSc() {
		return sc;
	}

	public void setSc(int sc) {
		this.sc = sc;
	}

	public double getEb() {
		return eb;
	}

	public void setEb(double eb) {
		this.eb = eb;
	}

	public double getDefc() {
		return defc;
	}

	public void setDefc(double defc) {
		this.defc = defc;
	}
	
	public int getRt() {
		return rt;
	}

	public void setRt(int rt) {
		this.rt = rt;
	}

	public int getTruePlayers() {
		return truePlayers;
	}

	public void setTruePlayers(int truePlayers) {
		this.truePlayers = truePlayers;
	}
	
}
