package com.badugi.game.logic.model.vo.flash.match;

/**
 * 比赛牌桌上用户详情返回值
 * 
 * @author amin
 */
public class MatchRoomDetailVo {

	private String rid;// 房间编号
	private String un;// 用户名
	private long uid;// 用户编号
	private double cp;// 筹码
	private int ie;// 是否淘汰 1 是 0 否

	public MatchRoomDetailVo() {
		super();
	}

	public MatchRoomDetailVo(String rid, String un, long uid,
			double cp, int ie) {
		super();
		this.rid = rid;
		this.un = un;
		this.uid = uid;
		this.cp = cp;
		this.ie = ie;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public double getCp() {
		return cp;
	}

	public void setCp(double cp) {
		this.cp = cp;
	}

	public int getIe() {
		return ie;
	}

	public void setIe(int ie) {
		this.ie = ie;
	}

}
