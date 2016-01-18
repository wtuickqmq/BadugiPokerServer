package com.badugi.game.logic.model.vo.fb.newpay;

public class PayUpateEntry {

	private String id;
	private Long time;
	private String changed_fields[];
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public String[] getChanged_fields() {
		return changed_fields;
	}
	public void setChanged_fields(String[] changedFields) {
		changed_fields = changedFields;
	}
	
	
}
