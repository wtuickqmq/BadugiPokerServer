package com.badugi.game.logic.model.vo.config;

/**
 * 场解/锁场配置
 * 
 * @author amin
 */
public class RoomLockConfigVo {

	private double sb;// 小盲
	private double bb;// 大盲
	private int lkc;// 锁场筹码
	private int ulkc;// 解场筹码
	private int ulkl;// 解场等级

	public double getSb() {
		return sb;
	}

	public void setSb(double sb) {
		this.sb = sb;
	}

	public double getBb() {
		return bb;
	}

	public void setBb(double bb) {
		this.bb = bb;
	}

	public int getLkc() {
		return lkc;
	}

	public void setLkc(int lkc) {
		this.lkc = lkc;
	}

	public int getUlkc() {
		return ulkc;
	}

	public void setUlkc(int ulkc) {
		this.ulkc = ulkc;
	}

	public int getUlkl() {
		return ulkl;
	}

	public void setUlkl(int ulkl) {
		this.ulkl = ulkl;
	}

}
