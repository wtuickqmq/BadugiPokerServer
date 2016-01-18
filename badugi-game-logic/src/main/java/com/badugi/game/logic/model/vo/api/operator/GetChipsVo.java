package com.badugi.game.logic.model.vo.api.operator;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 获得筹码返回值
 * 
 * @author amin
 */
public class GetChipsVo extends ResultVo {

	private Long code;
	private String desc;
	private int lds;
	private double ldcs;
	private double mdcs;

	public GetChipsVo() {
		super();
	}

	public GetChipsVo(Long code, String desc, int lds, double ldcs, double mdcs) {
		super();
		this.code = code;
		this.desc = desc;
		this.lds = lds;
		this.ldcs = ldcs;
		this.mdcs = mdcs;
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

	public int getLds() {
		return lds;
	}

	public void setLds(int lds) {
		this.lds = lds;
	}

	public double getLdcs() {
		return ldcs;
	}

	public void setLdcs(double ldcs) {
		this.ldcs = ldcs;
	}

	public double getMdcs() {
		return mdcs;
	}

	public void setMdcs(double mdcs) {
		this.mdcs = mdcs;
	}

}
