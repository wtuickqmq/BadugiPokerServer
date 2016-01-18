package com.badugi.game.logic.model.vo.api.user;

/**
 * 筹码排行详细
 * 
 * @author amin
 */
public class ChipsRankDetail {

	private Long fbid;// facebook编号
	private String fbname;// facebook名称
	private Integer viplevel;// vip等级
	private Double chips;// 普通等级
	private Integer ranklevel;// 排行名次
	private int type;//是否为机器人1：是0：否
	private String imgurl;//腾讯头像url

	public ChipsRankDetail() {
		super();
	}

	public ChipsRankDetail(Long fbid, String fbname, Integer viplevel,
			Double chips, Integer ranklevel) {
		super();
		this.fbid = fbid;
		this.fbname = fbname;
		this.viplevel = viplevel;
		this.chips = chips;
		this.ranklevel = ranklevel;
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

	public Integer getViplevel() {
		return viplevel;
	}

	public void setViplevel(Integer viplevel) {
		this.viplevel = viplevel;
	}

	public Double getChips() {
		return chips;
	}

	public void setChips(Double chips) {
		this.chips = chips;
	}

	public Integer getRanklevel() {
		return ranklevel;
	}

	public void setRanklevel(Integer ranklevel) {
		this.ranklevel = ranklevel;
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
