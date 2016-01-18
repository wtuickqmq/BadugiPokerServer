package com.badugi.game.logic.model.domain.vo.flash.user;

public class TrackRooms {

	private String rid;// 房间id
	private String rn;// 房间名称
	private double bb;// 大盲
	private double sb;// 小盲
	private String sp;// 速度
	private int cc;// 房间人数
	private int st;// 状态(1:坐下,0:旁观,2留座)

	public TrackRooms() {
		super();
	}
	
	public TrackRooms(String rid, String rn, double bb, double sb) {
		super();
		this.rid = rid;
		this.rn = rn;
		this.bb = bb;
		this.sb = sb;
	}

	public TrackRooms(String rid, String rn, double bb, double sb, String sp,
			int cc, int st) {
		super();
		this.rid = rid;
		this.rn = rn;
		this.bb = bb;
		this.sb = sb;
		this.sp = sp;
		this.cc = cc;
		this.st = st;
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

	public String getSp() {
		return sp;
	}

	public void setSp(String sp) {
		this.sp = sp;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public int getSt() {
		return st;
	}

	public void setSt(int st) {
		this.st = st;
	}

}
