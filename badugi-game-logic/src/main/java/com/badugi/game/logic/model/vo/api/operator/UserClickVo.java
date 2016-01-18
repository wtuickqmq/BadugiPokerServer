package com.badugi.game.logic.model.vo.api.operator;

public class UserClickVo {
	
	/**
	 * 点击引导弹窗中新手指引
	 */
	public static final int TYPE_1 = 1;
	
	/**
	 * 点击获取筹码中充值
	 */
	public static final int TYPE_2 = 2;
	
	private String event;
	private Long fbid;
	private Long sessionid;
	private int clicktype;
	private int value;
	
	
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
	public int getClicktype() {
		return clicktype;
	}
	public void setClicktype(int clicktype) {
		this.clicktype = clicktype;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * 根据点击类型获得数据库操作阶段id
	 * @param clickType
	 * @return
	 */
	public static Integer getNode(int clickType){
		switch(clickType){
			case 1:
				return 3;
			case 2:
				return 6;
			default:
				return clickType;
		}
	}
	
	
}
