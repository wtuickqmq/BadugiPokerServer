package com.badugi.game.logic.model.domain.vo.poker;

public class NewMessageVo {
	private Long uid;
	private String subtype;
	private String summary;
	
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getSubtype() {
		return subtype;
	}
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Override
	public String toString() {
		return "NewMessageVo [uid=" + uid + ", subtype=" + subtype
				+ ", summary=" + summary + "]";
	}

}
