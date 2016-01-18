package com.badugi.game.logic.model.vo.flash.operators;

/**
 * 赠送筹码通知flash信息vo
 * @author amin
 */
public class PresentChipsNoticeVo {

	/**
	 * 返回码
	 */
	private Long code;
	/**
	 * 操作类型
	 */
	private String cmd;
	/**
	 * 赠送的次数
	 */
	private int ac;
	/**
	 * 剩余赠送次数
	 */
	private int sc;
	/**
	 * 美金价值
	 */
	private int dl;
	/**
	 * 低于多少筹码
	 */
	private double lam;
	/**
	 * 赠送的筹码量
	 */
	private double am;

	public PresentChipsNoticeVo() {
		super();
	}

	public PresentChipsNoticeVo(Long code, String cmd, int dl, int ac, int sc, double am, double lam) {
		super();
		this.code = code;
		this.cmd = cmd;
		this.dl = dl;
		this.ac = ac;
		this.am = am;
		this.lam = lam;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getCmd() {
		return cmd;
	}
	
	public int getDl() {
		return dl;
	}

	public void setDl(int dl) {
		this.dl = dl;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}
	
	public int getSc() {
		return sc;
	}

	public void setSc(int sc) {
		this.sc = sc;
	}

	public double getLam() {
		return lam;
	}

	public void setLam(double lam) {
		this.lam = lam;
	}

	public double getAm() {
		return am;
	}

	public void setAm(double am) {
		this.am = am;
	}

}
