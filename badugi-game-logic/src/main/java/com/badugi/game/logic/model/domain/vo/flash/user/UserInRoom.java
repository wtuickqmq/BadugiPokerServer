package com.badugi.game.logic.model.domain.vo.flash.user;

/**
 * @copyright：Copyright 2011  highesthelp.com All Rights Reserved
 * @author: weijie
 * @email: <a href="mailto:jackstudiomaster@gmail.com">jackie</a>
 * @createTime: 2012-11-10
 * @description：
 */
public class UserInRoom {
	
	/**
	 * 比赛ID
	 */
	private int mi;
	/**
	 * 游戏类型
	 */
	private int gt;
	/**
	 * 游戏服务器ip
	 */
	private String ip;
	/**
	 * 端口port
	 */
	private int pt;
	/**
	 * 子账号
	 */
	private String uid;
	/**
	 * 房间id(roomId)
	 */
	private String rid;
	/**
	 * 房间名称(roomName)
	 */
	private String rn;
	/**
	 * 大盲
	 */
	private double bb;
	/**
	 * 小盲
	 */
	private double sb;
	/**
	 * 签名
	 */
	private String sign;
	/**
	 * 创建时间
	 */
	private long ct;
	/**
	 * 是否坐下(标示)
	 * （-1:flash申请,0：旁观,1 :游戏中,2：留座）
	 */
	private int isSit = -1;
	
	private int gl;
	

	public UserInRoom(){
		super();
	}

	public UserInRoom(String ip,int pt,String uid, String rid, String rn, double bb, double sb,
			String sign) {
		super();
		this.ip = ip;
		this.pt = pt;
		this.uid = uid;
		this.rid = rid;
		this.rn = rn;
		this.bb = bb;
		this.sb = sb;
		this.sign = sign;
	}
	
	public UserInRoom( String ip, int pt, String uid,String rid, String rn, double bb, double sb,int gl , String sign ) {
		super();

		this.ip = ip;
		this.pt = pt;
		this.uid = uid;
		this.rid = rid;
		this.rn = rn;
		this.bb = bb;
		this.sb = sb;
		this.sign = sign;
		this.gl = gl;
	}

	public int getMi() {
		return mi;
	}

	public void setMi(int mi) {
		this.mi = mi;
	}

	public int getGt() {
		return gt;
	}

	public void setGt(int gt) {
		this.gt = gt;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPt() {
		return pt;
	}

	public void setPt(int pt) {
		this.pt = pt;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getRn() {
		return rn;
	}

	public void setRn(String rn) {
		this.rn = rn;
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

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public int getIsSit() {
		return isSit;
	}

	public void setIsSit(int isSit) {
		this.isSit = isSit;
	}

	public long getCt() {
		return ct;
	}

	public void setCt(long ct) {
		this.ct = ct;
	}

	public int getGl() {
		return gl;
	}

	public void setGl(int gl) {
		this.gl = gl;
	}

	
	

	
	
}
