package com.badugi.game.logic.model.message;



/**
 * @author wtu.edit
 * @date 2015年10月20日
 * @version qq1.0
 * @email wtuickqmq@163.com
 */
public class TrackOp {

	/***
	 * 事件类型
	 */
	private String event;
	/**
	 * 发起追踪的玩家
	 */
	private Long uid;
	/**
	 * 被追踪的玩家
	 */
	private Long tagetuid;
	
	
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
	public Long getTagetuid() {
		return tagetuid;
	}
	public void setTagetuid(Long tagetuid) {
		this.tagetuid = tagetuid;
	}
	
	
	

}
