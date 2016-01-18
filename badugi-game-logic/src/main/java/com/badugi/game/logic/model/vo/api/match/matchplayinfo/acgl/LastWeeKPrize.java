package com.badugi.game.logic.model.vo.api.match.matchplayinfo.acgl;

/**
 * 上周奖金排名
 * @author Administrator
 *
 */
public class LastWeeKPrize {

	private Long fbid;//	本周获奖排名fbid
	private String un;//	本周获奖排名用户名
	private Integer rk;//	本周获奖用户名次 rank
	private Integer zj;//	本周获奖用户奖金
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
	public Integer getZj() {
		return zj;
	}
	public void setZj(Integer zj) {
		this.zj = zj;
	}
	
	public LastWeeKPrize() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LastWeeKPrize(Long fbid, String un, Integer rk, Integer zj) {
		super();
		this.fbid = fbid;
		this.un = un;
		this.rk = rk;
		this.zj = zj;
	}
	
	

}
