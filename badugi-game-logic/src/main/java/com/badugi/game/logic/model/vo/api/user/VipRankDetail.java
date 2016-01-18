package com.badugi.game.logic.model.vo.api.user;

/**
 * vip 排行详细
 * 
 * @author amin
 */
public class VipRankDetail {

	private Long fbid;// facebook编号
	private String fbname;// facebook名称
	private Integer viplevel;// vip等级
	private double nextvipper;// 下一个vip等级百分比
	private Integer ranklevel;// 排行名次
	private int type;//是否为机器人1：是0：否

	public VipRankDetail() {
		super();
	}

	public VipRankDetail(Long fbid, String fbname, Integer viplevel,
			double nextvipper, Integer ranklevel) {
		super();
		this.fbid = fbid;
		this.fbname = fbname;
		this.viplevel = viplevel;
		this.nextvipper = nextvipper;
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

	public Double getNextvipper() {
		return nextvipper;
	}

	public void setNextvipper(double nextvipper) {
		this.nextvipper = nextvipper;
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

}
