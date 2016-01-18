package com.badugi.game.logic.model.vo.flash.match;

import java.util.List;

public class MatchJoinOrLeaveVo {
	/****
	 * 比赛编号
	 */
	private Integer tid;

	/***
	 * 房间编号
	 */
	private String rid;
	/***
	 * 加入或离开
	 */
	private boolean ij;
	/**
	 * 淘汰用户
	 * (只会是单用户)
	 */
	private String puid;
	/**
	 * 子账号id
	 */
	private String cuid;
	/**
	 * 多个集合
	 */
	private List<MatchJoinOrLeaveDetail> list;

	public MatchJoinOrLeaveVo() {
		super();
	}

	public MatchJoinOrLeaveVo(Integer tid, String rid, boolean ij) {
		super();
		this.tid = tid;
		this.rid = rid;
		this.ij = ij;
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

	public boolean isIj() {
		return ij;
	}

	public void setIj(boolean ij) {
		this.ij = ij;
	}
	
	public String getPuid() {
		return puid;
	}

	public void setPuid(String puid) {
		this.puid = puid;
	}
	
	public String getCuid() {
		return cuid;
	}
	
	public void setCuid(String cuid) {
		this.cuid = cuid;
	}

	public List<MatchJoinOrLeaveDetail> getList() {
		return list;
	}

	public void setList(List<MatchJoinOrLeaveDetail> list) {
		this.list = list;
	}
	
}
