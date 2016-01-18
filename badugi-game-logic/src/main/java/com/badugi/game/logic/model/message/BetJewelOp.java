package com.badugi.game.logic.model.message;

/**
 * @author wtu.edit
 * @date 2015年10月6日
 * @version qq1.0
 * @email wtuickqmq@163.com
 */
public class BetJewelOp {

	/***
	 * 事件类型
	 */
	private String event;
	/**
	 * 用户id
	 */
	private Long uid;
	/**
	 * round id
	 */
	private Long rid;
	
	
	
	public BetJewelOp() {
		super();
	}
	
	public BetJewelOp(String event, Long uid, Long rid) {
		super();
		this.event = event;
		this.uid = uid;
		this.rid = rid;
		
	}


	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	
	
	
	
}
