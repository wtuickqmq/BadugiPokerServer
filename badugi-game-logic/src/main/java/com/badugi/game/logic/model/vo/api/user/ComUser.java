package com.badugi.game.logic.model.vo.api.user;

public class ComUser {

	private Long fbid;
	private String fbname;
	private Short t;//用户类型 0为真人 1为机器人
	private String imgurl;//腾讯头像url
	
	public ComUser(Long fbid, String fbname, Short t) {
		super();
		this.fbid = fbid;
		this.fbname = fbname;
		this.t = t;
	}

	public ComUser() {
		super();
	}
	
	public Short getT() {
		return t;
	}

	public void setT(Short t) {
		this.t = t;
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

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	
}
