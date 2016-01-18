package com.badugi.game.logic.model.vo.api.user;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class MyfbfriendsVo extends ResultVo{

	private Long code;
	private String desc;
	private String trfbid;
	private String trfbname;
	
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
	
	
	public String getTrfbid() {
		return trfbid;
	}
	public void setTrfbid(String trfbid) {
		this.trfbid = trfbid;
	}
	public String getTrfbname() {
		return trfbname;
	}
	public void setTrfbname(String trfbname) {
		this.trfbname = trfbname;
	}
	public MyfbfriendsVo(Long code, String desc, String trfbid, String trfbname) {
		super();
		this.code = code;
		this.desc = desc;
		this.trfbid = trfbid;
		this.trfbname = trfbname;
	}
	
}
