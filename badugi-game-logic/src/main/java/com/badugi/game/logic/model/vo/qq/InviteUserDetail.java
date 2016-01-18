package com.badugi.game.logic.model.vo.qq;

/**
 * 受邀请的好友信息
 * 
 * @author amin
 * 
 */
public class InviteUserDetail {

	private long userid;// 用户ID
	private String username;// 用户名
	private Double c;// 用户筹码
	private String imgurl;// 头像
	private int utype;// 用户类型(1机器人0真人)
	
	public InviteUserDetail(){
		super();
	}
	
	public InviteUserDetail(long userid){
		this.userid = userid;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getC() {
		return c;
	}

	public void setC(Double c) {
		this.c = c;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public int getUtype() {
		return utype;
	}

	public void setUtype(int utype) {
		this.utype = utype;
	}

}
