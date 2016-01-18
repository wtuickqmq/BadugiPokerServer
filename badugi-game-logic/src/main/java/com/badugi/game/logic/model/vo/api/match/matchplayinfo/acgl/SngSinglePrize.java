package com.badugi.game.logic.model.vo.api.match.matchplayinfo.acgl;

/**
 * 单场比赛奖励
 * @author Administrator
 *
 */
public class SngSinglePrize {

	private Integer rk;//	单场名次
	private Integer mj;//	对应名次奖金(泰珠)
	private Integer mf;//	对应名次比赛积分
	public Integer getRk() {
		return rk;
	}
	public void setRk(Integer rk) {
		this.rk = rk;
	}
	public Integer getMj() {
		return mj;
	}
	public void setMj(Integer mj) {
		this.mj = mj;
	}
	public Integer getMf() {
		return mf;
	}
	public void setMf(Integer mf) {
		this.mf = mf;
	}
	

}
