package com.badugi.game.logic.model.domain.vo.flash.user;

/**
 * @copyright：Copyright 2011 highesthelp.com All Rights Reserved
 * @author: weijie
 * @email: <a href="mailto:jackstudiomaster@gmail.com">jackie</a>
 * @createTime: 2012-11-10
 * @description：
 */
public class PlayerInfoInRoom {

	/**
	 * roomId
	 */
	private String rid;
	/**
	 * 父账号
	 */
	private String puid;
	/**
	 * 子账号
	 */
	private String uid;
	/**
	 * 用户昵称
	 */
	private String nn;
	/**
	 * 玩家游戏中座位号
	 */
	private short seat;
	
	/**
	 * 玩家游戏中筹码
	 */
	private double cp;
	/**
	 * 玩家在牌桌上的筹码
	 */
	private double cpir;
	/**
	 * 断线时间
	 */
	private long dt;
	/**
	 * 等待游戏时间
	 */
	private long wt;
	/**
	 * 是否坐下
	 */
	private boolean is;
	/**
	 * 是否托管
	 */
	private boolean at;
	/**
	 * 是否全部玩家更新
	 */
	private boolean ia;
	/**
	 * 是否留坐
	 */
	private boolean so;
	/****
	 * 是否是机器人
	 */
	private boolean isRobot;

	public PlayerInfoInRoom() {
		super();
	}

	public PlayerInfoInRoom(String rid, String puid, String uid, String nn,
			short seat, double cp, double cpir, long dt, long wt, boolean is,
			boolean at, boolean ia, boolean so, boolean isRobot) {
		super();
		this.rid = rid;
		this.puid = puid;
		this.uid = uid;
		this.nn = nn;
		this.seat = seat;
		this.cp = cp;
		this.cpir = cpir;
		this.dt = dt;
		this.wt = wt;
		this.is = is;
		this.at = at;
		this.ia = ia;
		this.so = so;
		this.isRobot = isRobot;
	}

	public short getSeat() {
		return seat;
	}

	public void setSeat(short seat) {
		this.seat = seat;
	}


	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getPuid() {
		return puid;
	}

	public void setPuid(String puid) {
		this.puid = puid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getNn() {
		return nn;
	}

	public void setNn(String nn) {
		this.nn = nn;
	}

	public double getCp() {
		return cp;
	}

	public void setCp(double cp) {
		this.cp = cp;
	}
	
	public double getCpir() {
		return cpir;
	}

	public void setCpir(double cpir) {
		this.cpir = cpir;
	}

	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public long getWt() {
		return wt;
	}

	public void setWt(long wt) {
		this.wt = wt;
	}

	public boolean getIs() {
		return is;
	}

	public void setIs(boolean is) {
		this.is = is;
	}

	public boolean getAt() {
		return at;
	}

	public void setAt(boolean at) {
		this.at = at;
	}

	public boolean getIa() {
		return ia;
	}

	public void setIa(boolean ia) {
		this.ia = ia;
	}

	public boolean getSo() {
		return so;
	}

	public void setSo(boolean so) {
		this.so = so;
	}

	public boolean isRobot() {
		return isRobot;
	}

	public void setRobot(boolean isRobot) {
		this.isRobot = isRobot;
	}
	
}
