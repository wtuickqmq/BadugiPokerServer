package com.badugi.game.logic.model.domain.vo.flash.user;

public class Invitations {

	private Long uid;// facebook编号
	private String name;// 名称
	private String imgUrl;
	private int viplevel;// vip等级
	private double chips;//筹码
	private int flag;// 标记类型 0 无 1 鱼 2 敌人
	private int mtype = 0;// 1游戏中可追踪、0离线中、2大厅闲逛

	public Invitations() {
		super();
	}


	public Invitations(Long uid, String name, String imgUrl, int viplevel,
			double chips, int flag, int mtype) {
		super();
		this.uid = uid;
		this.name = name;
		this.imgUrl = imgUrl;
		this.viplevel = viplevel;
		this.chips = chips;
		this.flag = flag;
		this.mtype = mtype;
	}


	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getMtype() {
		return mtype;
	}

	public void setMtype(int mtype) {
		this.mtype = mtype;
	}

	
}
