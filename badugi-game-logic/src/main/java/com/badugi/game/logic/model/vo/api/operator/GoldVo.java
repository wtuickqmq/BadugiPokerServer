package com.badugi.game.logic.model.vo.api.operator;

import com.badugi.game.logic.model.vo.api.ResultVo;


public class GoldVo extends ResultVo {

	private Long fbid;
	private String fbname;
	private Integer goldnum;

	public GoldVo() {
		super();
	}

	public GoldVo( Long fbid, String fbname,
			Integer goldnum) {
		super();
		this.fbid = fbid;
		this.fbname = fbname;
		this.goldnum = goldnum;
	}

	

	public Long getFbid() {
		return fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}

	public String getFbname() {
		return fbname;
	}

	public void setFbname(String fbname) {
		this.fbname = fbname;
	}

	public Integer getGoldnum() {
		return goldnum;
	}

	public void setGoldnum(Integer goldnum) {
		this.goldnum = goldnum;
	}

}
