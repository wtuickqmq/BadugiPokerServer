package com.badugi.game.logic.model.vo.api.user;

/**
 * 等级排行详细
 * 
 * @author amin
 */
public class LevelRankDetail {

	private Long fbid;// facebook编号
	private String fbname;// facebook名称
	private Integer viplevel;// vip等级
	private Integer level;// 普通等级
	private Integer ranklevel;// 排行名次
	private int type;//是否为机器人1：是0：否
	private String imgurl;//腾讯头像url

	public LevelRankDetail() {
		super();
	}

	public LevelRankDetail(Long fbid, String fbname, Integer viplevel,
			Integer level, Integer ranklevel) {
		super();
		this.fbid = fbid;
		this.fbname = fbname;
		this.viplevel = viplevel;
		this.level = level;
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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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
