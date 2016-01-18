package com.badugi.game.logic.model.vo.flash.match;

/**
 * SNG周积分排名
 * @author Administrator
 *
 */
public class SngMatchWeekFen {

	private Long fbid;//fbid
	private String un;//本周排名用户名
	private Integer rk;//本周用户名次
	private Integer zf;//本周用户积分
	public Long getFbid() {
		return fbid;
	}
	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}
	public String getUn() {
		return un;
	}
	public void setUn(String un) {
		this.un = un;
	}
	public Integer getRk() {
		return rk;
	}
	public void setRk(Integer rk) {
		this.rk = rk;
	}
	public Integer getZf() {
		return zf;
	}
	public void setZf(Integer zf) {
		this.zf = zf;
	}
	
	
}
