package com.badugi.game.logic.model.vo.msg;

/**
 * 消息
 * @author amin
 */
public class RequestVo {

	private String event;// 事件名
	private Long fbid;// facebook编号

	public RequestVo() {
		super();
	}

	public RequestVo(String event, Long fbid) {
		super();
		this.event = event;
		this.fbid = fbid;
	}

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

}
