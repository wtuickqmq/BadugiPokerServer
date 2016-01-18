package com.badugi.game.logic.model.vo.api.poker.param;

public class GameendVo extends ParamSuper {

	private static final long serialVersionUID = 156564647979931L;

	private Long uid;
	
	private Integer ulogId;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Integer getUlogId() {
		return ulogId;
	}

	public void setUlogId(Integer ulogId) {
		this.ulogId = ulogId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
