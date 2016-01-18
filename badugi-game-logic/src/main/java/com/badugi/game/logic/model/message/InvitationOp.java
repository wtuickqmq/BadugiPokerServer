package com.badugi.game.logic.model.message;

import java.util.List;



/**
 * @author wtu.edit
 * @date 2015年10月16日
 * @version qq1.0
 * @email wtuickqmq@163.com
 */
public class InvitationOp {

	/***
	 * 事件类型
	 */
	private String event;
	/**
	 * 编号uid 
	 */
	private Long uid;
		
	/**
	 * roomId
	 */
	private Long rid;
	
	/**
	 * 回话id
	 */
	private List<String> list;

	
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	
	
	

}
