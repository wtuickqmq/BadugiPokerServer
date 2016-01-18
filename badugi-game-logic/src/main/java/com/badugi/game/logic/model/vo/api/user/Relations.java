package com.badugi.game.logic.model.vo.api.user;

public class Relations {

	private Long fbid;// facebook编号
	private String name;// 名称
	private int explevel;// 普通等级
	private int viplevel;// vip等级
	private double chips;// 筹码数量
	private int flag;// 标记类型 0 无 1 鱼 2 敌人
	private int isfriend;// 是否是牌友 0 不是 1 是
	private int isfbfriend;// 是否为facebook牌友0 不是 1是
	private int isonline;// 是否在线 1在线 0不在线
	private int type;// 是否为机器人1:是0否
	private int mtype = 2;// 1游戏中可追踪、2离线中、3大厅闲逛4可召回 默认为2
	private String imgurl;
	private Integer pftype;// 平台代号1为QQ空间，2朋友网，3微博

	public Relations() {
		super();
	}

	public Relations(Long fbid, String name, int explevel,
			int viplevel, int chips, int flag, int isfriend) {
		super();
		this.fbid = fbid;
		this.name = name;
		this.explevel = explevel;
		this.viplevel = viplevel;
		this.chips = chips;
		this.flag = flag;
		this.isfriend = isfriend;
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

	public int getIsfriend() {
		return isfriend;
	}

	public void setIsfriend(int isfriend) {
		this.isfriend = isfriend;
	}

	public int getIsfbfriend() {
		return isfbfriend;
	}

	public void setIsfbfriend(int isfbfriend) {
		this.isfbfriend = isfbfriend;
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

	public int getMtype() {
		return mtype;
	}

	public void setMtype(int mtype) {
		this.mtype = mtype;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public Integer getPftype() {
		return pftype;
	}

	public void setPftype(Integer pftype) {
		this.pftype = pftype;
	}

}
