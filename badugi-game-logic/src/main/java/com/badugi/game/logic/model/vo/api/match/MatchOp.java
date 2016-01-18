package com.badugi.game.logic.model.vo.api.match;

/**
 * @copyright：Copyright 2011  highesthelp.com All Rights Reserved
 * @author: weijie
 * @email: <a href="mailto:jackstudiomaster@gmail.com">jackie</a>
 * @createTime: 2012-11-5
 * @description：比赛flash请求参数
 */
public class MatchOp {

	/***
	 * 事件类型
	 */
	private String event;
	/**
	 * facebook编号fbid 
	 */
	private Long fbid;
	/**
	 * 比赛一级分类
	 */
	private int gt;
	/**
	 * 比赛类型matchtype
	 */
	private int mt;
	/**
	 * 比赛等级matchlevel
	 */
	private int ml;
	/**
	 * 房间编号 roomId
	 */
	private String rid;
	/**
	 * 比赛编号 matchId
	 */
	private Integer mi;
	/**
	 * 状态(-1全部，其他状态跟match状态对应)
	 */
	private int st;
	

	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public Long getFbid() {
		return fbid;
	}
	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}
	public int getGt() {
		return gt;
	}
	public void setGt(int gt) {
		this.gt = gt;
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
	public Integer getMi() {
		return mi;
	}
	public void setMi(Integer mi) {
		this.mi = mi;
	}
	public int getSt() {
		return st;
	}
	public void setSt(int st) {
		this.st = st;
	}
}
