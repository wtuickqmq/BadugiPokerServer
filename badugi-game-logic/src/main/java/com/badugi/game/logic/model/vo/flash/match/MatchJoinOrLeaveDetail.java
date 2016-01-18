package com.badugi.game.logic.model.vo.flash.match;


public class MatchJoinOrLeaveDetail {

	/****
	 * 父账号
	 */
	private String puid;
	/**
	 * 房间编号
	 */
	private String rid;
	/***
	 * 最后筹码
	 */
	private Double cp;
	/****
	 * 位置
	 */
	private Integer pos;
	/**
	 * 赢家父账号
	 */
	private String koid;

	public MatchJoinOrLeaveDetail() {
		super();
	}
	
	public MatchJoinOrLeaveDetail(String puid, String rid, Double cp,
			Integer pos, String koid) {
		super();
		this.puid = puid;
		this.rid = rid;
		this.cp = cp;
		this.pos = pos;
		this.koid = koid;
	}

	public String getPuid() {
		return puid;
	}

	public void setPuid(String puid) {
		this.puid = puid;
	}
	
	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public Double getCp() {
		return cp;
	}

	public void setCp(Double cp) {
		this.cp = cp;
	}
	
	public Integer getPos() {
		return pos;
	}

	public void setPos(Integer pos) {
		this.pos = pos;
	}

	public String getKoid() {
		return koid;
	}

	public void setKoid(String koid) {
		this.koid = koid;
	}
	
}
