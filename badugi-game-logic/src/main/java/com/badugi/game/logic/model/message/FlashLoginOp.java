package com.badugi.game.logic.model.message;


/**
 * @copyright：Copyright 2011  highesthelp.com All Rights Reserved
 * @author: weijie
 * @email: <a href="mailto:jackstudiomaster@gmail.com">jackie</a>
 * @createTime: 2012-11-5
 * @description：flash请求参数
 */
public class FlashLoginOp {

	/***
	 * 事件类型
	 */
	private String event;
	/**
	 * facebook编号fbid 
	 */
	private Long fbid;
	/**
	 * 标识(0：正常登陆1：重连)
	 */
	private int flag;
	/**
	 * 时间戳
	 */
	private long timestamp;
	/**
	 * 签名
	 */
	private String sign;
	/**
	 * 游戏类型gametype
	 * 1 按简洁信息输出
	 * 2 按老版本房间信息输出
	 * 3 比赛信息输出
	 */
	private int gt;
	/**
	 * 房间等级
	 */
	private int gl;
	/**
	 * roomId
	 */
	private String rid;
	/***
	 * 比赛类型
	 */
	private int mt;
	/****
	 * 比赛等级
	 */
	private int ml;
	/**
	 * 回话id
	 */
	private Long sessionid;
	/**
	 * 状态类型 
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
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
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
	public Long getSessionid() {
		return sessionid;
	}
	public void setSessionid(Long sessionid) {
		this.sessionid = sessionid;
	}
	public int getSt() {
		return st;
	}
	public void setSt(int st) {
		this.st = st;
	}
	
	

}
