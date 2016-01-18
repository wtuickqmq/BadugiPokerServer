package com.badugi.game.logic.model.vo.api.task;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * api免费获得筹码返回值
 * 
 * @author amin
 */
public class GetFreeChipsVo extends ResultVo {

	private Long code;
	private String desc;
	private double lam;// 低于多少筹码
	private int dl;// 美金
	private double am;// 赠送的筹码
	private int ac;// 赠送的次数
	private int sc;// 剩余赠送的次数

	public GetFreeChipsVo() {
		super();
	}

	public GetFreeChipsVo(Long code, String desc, double lam, int dl, double am,
			int ac, int sc) {
		super();
		this.code = code;
		this.desc = desc;
		this.lam = lam;
		this.dl = dl;
		this.am = am;
		this.ac = ac;
		this.sc = sc;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getLam() {
		return lam;
	}

	public void setLam(double lam) {
		this.lam = lam;
	}

	public int getDl() {
		return dl;
	}

	public void setDl(int dl) {
		this.dl = dl;
	}

	public double getAm() {
		return am;
	}

	public void setAm(double am) {
		this.am = am;
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

}
