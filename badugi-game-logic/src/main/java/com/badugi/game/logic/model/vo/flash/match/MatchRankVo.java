package com.badugi.game.logic.model.vo.flash.match;

/**
 * 比赛用户排行返回值
 * 
 * @author amin
 */
public class MatchRankVo {

	private String un;// 用户名
	private Long uid;// 用户编号
	private double cp;// 筹码
	private Integer rk;// 排名
	private int ic;//是否取消1 是 0 否
	private String rid;//所在房间

	public MatchRankVo() {
		super();
	}

	public MatchRankVo(String un, Long uid, double cp, Integer rk, int ic,String rid) {
		super();
		this.un = un;
		this.uid = uid;
		this.cp = cp;
		this.rk = rk;
		this.ic = ic;
		this.rid=rid;
	}

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public double getCp() {
		return cp;
	}

	public void setCp(double cp) {
		this.cp = cp;
	}

	public Integer getRk() {
		return rk;
	}

	public void setRk(Integer rk) {
		this.rk = rk;
	}

	public int getIc() {
		return ic;
	}

	public void setIc(int ic) {
		this.ic = ic;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}
	
	
	
}
