package com.badugi.game.logic.model.domain.vo.flash.operators;

/**
 * 用户游戏筹码信息
 * 
 * @author amin
 * 
 */
public class UserCpVo {

	/**
	 * fbid
	 */
	private String puid;
	/**
	 * 房间玩家筹码
	 */
	private double cp;
	/**
	 * 是否参与本局
	 */
	private long wt;
	
	public UserCpVo(){
		super();
	}
	
	public UserCpVo(String puid, double cp, long wt) {
		super();
		this.puid = puid;
		this.cp = cp;
		this.wt = wt;
	}

	public String getPuid() {
		return puid;
	}

	public void setPuid(String puid) {
		this.puid = puid;
	}

	public double getCp() {
		return cp;
	}

	public void setCp(double cp) {
		this.cp = cp;
	}
	
	public long getWt() {
		return wt;
	}
	
	public void setWt(long wt) {
		this.wt = wt;
	}

}
