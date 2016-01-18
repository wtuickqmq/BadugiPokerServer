package com.badugi.game.logic.model.vo.api.table;

public class UserBasicVo {

	public Long fbid;
	public String fbname;
	
	
	public UserBasicVo(Long fbid, String fbname) {
		super();
		this.fbid = fbid;
		this.fbname = fbname;
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
	
	
}
