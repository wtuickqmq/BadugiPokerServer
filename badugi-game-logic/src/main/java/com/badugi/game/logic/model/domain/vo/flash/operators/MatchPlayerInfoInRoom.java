package com.badugi.game.logic.model.domain.vo.flash.operators;

/**
 * 
* 项目名称：qq1.0   
* 类名称：MatchPlayerInfoInRoom   
* 创建人：huangcaiyuan 
* emial: caiyuan.huang@gmail.com   
* 创建时间：Dec 3, 2012 8:41:46 PM    
* @version 1.0
* 比赛中玩家房间信息
 */
public class MatchPlayerInfoInRoom {

	/**
	 * 比赛编号
	 */
	private Integer tid;
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
	 * 比赛中筹码
	 */
	private double cp;
	
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

	public MatchPlayerInfoInRoom() {
		super();
	}

	
	public MatchPlayerInfoInRoom(Integer tid, String rid, String puid, String uid,
			String nn, double cp, long dt, long wt, boolean is, boolean at,
			boolean ia, boolean so) {
		super();
		this.tid = tid;
		this.rid = rid;
		this.puid = puid;
		this.uid = uid;
		this.nn = nn;
		this.cp = cp;
		this.dt = dt;
		this.wt = wt;
		this.is = is;
		this.at = at;
		this.ia = ia;
		this.so = so;
	}


	public Integer getTid() {
		return tid;
	}


	public void setTid(Integer tid) {
		this.tid = tid;
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
	
}
