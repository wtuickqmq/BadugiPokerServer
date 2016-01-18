package com.badugi.game.logic.model.message;

public class BetShakeOp {

	/***
	 * 事件类型
	 */
	private String event;
	/**
	 * facebook编号fbid 
	 */
	private Long uid;
	/**
	 * roomId
	 */
	private Long rid;
	/***
	 * 比赛类型
	 */
	private Long chip;
	
	
	public BetShakeOp() {
		super();
	}
	
	public BetShakeOp(String event, Long uid, Long rid, Long chip) {
		super();
		this.event = event;
		this.uid = uid;
		this.rid = rid;
		this.chip = chip;
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
	public Long getChip() {
		return chip;
	}
	public void setChip(Long chip) {
		this.chip = chip;
	}
	
	
	
}
