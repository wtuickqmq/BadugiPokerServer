package com.badugi.game.logic.model.vo.api.match.matchplayinfo;

public class QuickVo {
	/**
	 * 1：点击引导弹窗中快速开始
	 */
	public static final int QUICK_1 = 1;
	/**
	 * 2：点击帮助弹窗中快速开始
	 */
	public static final int QUICK_2 = 2;
	/**
	 * 3：点击大厅快速开始
	 */
	public static final int QUICK_3 = 3;
	/**
	 * 4：点击add快速开始
	 */
	public static final int QUICK_4 = 4;
	/**
	 * 5：其他快速开始
	 */
	public static final int QUICK_5 = 5;
	/**
	 * 6：点击大厅快速开始2(顶部)
	 */
	public static final int QUICK_6 = 6;
	/**
	 * 7：点击新手教程中快速开始
	 */
	public static final int QUICK_7 = 7;
	
	private String event;
	private Long fbid;//facebookId
	private Long sessionid;
	private int type;//
	private double sb;//小盲
	private double bb;//大盲
	private double am;//筹码
	private boolean isquickstart ;//true为快速开始,false为开新桌
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public Long getFbid() {
		return fbid;
	}
	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}
	public Long getSessionid() {
		return sessionid;
	}
	public void setSessionid(Long sessionid) {
		this.sessionid = sessionid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getSb() {
		return sb;
	}
	public void setSb(double sb) {
		this.sb = sb;
	}
	public double getBb() {
		return bb;
	}
	public void setBb(double bb) {
		this.bb = bb;
	}
	public double getAm() {
		return am;
	}
	public void setAm(double am) {
		this.am = am;
	}
	public boolean isIsquickstart() {
		return isquickstart;
	}
	public void setIsquickstart(boolean isquickstart) {
		this.isquickstart = isquickstart;
	}
	
}
