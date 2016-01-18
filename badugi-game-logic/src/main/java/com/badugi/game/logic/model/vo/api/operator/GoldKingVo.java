package com.badugi.game.logic.model.vo.api.operator;

import com.badugi.game.logic.model.vo.api.ResultVo;


public class GoldKingVo extends ResultVo {

	private Long code;
	private String desc;
	private Long fbid;
	private String fbname;
	private Integer goldnum;

	public GoldKingVo() {
		super();
	}

	public GoldKingVo(Long code, String desc, Long fbid, String fbname,
			Integer goldnum) {
		super();
		this.code = code;
		this.desc = desc;
		this.fbid = fbid;
		this.fbname = fbname;
		this.goldnum = goldnum;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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
