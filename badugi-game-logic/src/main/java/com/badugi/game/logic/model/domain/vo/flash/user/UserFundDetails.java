package com.badugi.game.logic.model.domain.vo.flash.user;

public class UserFundDetails {

	/**
	 * 用户id/头像id
	 */
	private Long uid;
	/**
	 * 用户昵称
	 */
	private String nn;
	/**
	 * 经验等级
	 */
	private int el;
	/**
	 * vip等级
	 */
	private int vl;
	/**
	 * 筹码
	 */
	private double cp;
	/**
	 * 是否为机器人(1:是0:否)
	 */
	private int tp;

	/**
	 * 腾讯头像url
	 */
	private String imgurl;
//    座位号
	private int seat;

	public UserFundDetails() {
		super();
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public UserFundDetails(Long uid, String nn, int el, int vl, double cp,
			int tp, String imgurl, int seat) {
		super();
		this.uid = uid;
		this.nn = nn;
		this.el = el;
		this.vl = vl;
		this.cp = cp;
		this.tp = tp;
		this.imgurl = imgurl;
		this.seat = seat;
	}


	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getNn() {
		return nn;
	}

	public void setNn(String nn) {
		this.nn = nn;
	}

	public int getEl() {
		return el;
	}

	public void setEl(int el) {
		this.el = el;
	}

	public int getVl() {
		return vl;
	}

	public void setVl(int vl) {
		this.vl = vl;
	}

	public double getCp() {
		return cp;
	}

	public void setCp(double cp) {
		this.cp = cp;
	}

	public int getTp() {
		return tp;
	}

	public void setTp(int tp) {
		this.tp = tp;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

}
