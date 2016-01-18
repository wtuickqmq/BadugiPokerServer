package com.badugi.game.logic.model.vo.api.user;

public class Fbfriends {

	private Long fbid;// facebook编号
	private String name;// 名称
	private int explevel;// 普通等级
	private int viplevel;// vip等级
	private double chips;// 筹码数量
	private int flag;// 标记类型 0 无 1 鱼 2 敌人
	private int isonline;//是否在线 1在线0不在线
	private int type;//是否为机器人1:是0否
	private String imgurl;//腾讯头像url
	
	public Fbfriends(){
		super();
	}
	
	public Fbfriends(Long fbid, String name, int explevel,
			int viplevel, int chips, int flag) {
		super();
		this.fbid = fbid;
		this.name = name;
		this.explevel = explevel;
		this.viplevel = viplevel;
		this.chips = chips;
		this.flag = flag;
	}

	public Long getFbid() {
		return fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExplevel() {
		return explevel;
	}

	public void setExplevel(int explevel) {
		this.explevel = explevel;
	}

	public int getViplevel() {
		return viplevel;
	}

	public void setViplevel(int viplevel) {
		this.viplevel = viplevel;
	}

	public double getChips() {
		return chips;
	}

	public void setChips(double chips) {
		this.chips = chips;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getIsonline() {
		return isonline;
	}

	public void setIsonline(int isonline) {
		this.isonline = isonline;
	}

	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	
}
