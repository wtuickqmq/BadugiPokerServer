package com.badugi.game.logic.model.vo.api.poker.param;

public class ReachieveVo extends ParamSuper {

	private static final long serialVersionUID = 15648456431L;

	private Long uid;
	
	private String subtype;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
