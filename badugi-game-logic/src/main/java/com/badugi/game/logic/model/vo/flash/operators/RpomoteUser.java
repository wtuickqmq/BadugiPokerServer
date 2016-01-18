package com.badugi.game.logic.model.vo.flash.operators;

public class RpomoteUser {

	public Long fbid;
	public String fbname;
	public String opendid;
	public String figureurl;
	public String imgurl;
	public RpomoteUser(Long fbid, String fbname) {
		super();
		this.fbid = fbid;
		this.fbname = fbname;
	}
	
	public RpomoteUser() {
		super();
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

	public String getOpendid() {
		return opendid;
	}

	public void setOpendid(String opendid) {
		this.opendid = opendid;
	}

	public String getFigureurl() {
		return figureurl;
	}

	public void setFigureurl(String figureurl) {
		this.figureurl = figureurl;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	
}
