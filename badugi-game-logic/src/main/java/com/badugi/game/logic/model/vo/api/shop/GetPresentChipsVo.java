package com.badugi.game.logic.model.vo.api.shop;

import java.io.Serializable;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class GetPresentChipsVo extends ResultVo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long code;
	private String desc;
	private Long fbid;// facebook编号
	private Long tofbid;// 赠送给对方的facebook编号
	private String tofbname;// 赠送对方的用户名称
	private Double chips;// 当前用户筹码
	private Double ochips;// 单笔最多赠送筹码
	private Double wchips;// 本周已赠送筹码
	private Double swchips;// 本周最多还可赠送筹码
	private Double permin;// 单笔赠送至少值

	public GetPresentChipsVo() {
		super();
	}

	public GetPresentChipsVo(Long code, String desc, Long fbid, Long tofbid,
			String tofbname, Double chips, Double ochips, Double wchips,
			Double swchips, Double permin) {
		super();
		this.code = code;
		this.desc = desc;
		this.fbid = fbid;
		this.tofbid = tofbid;
		this.tofbname = tofbname;
		this.chips = chips;
		this.ochips = ochips;
		this.wchips = wchips;
		this.swchips = swchips;
		this.permin = permin;
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

	public Long getFbid() {
		return fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}

	public Long getTofbid() {
		return tofbid;
	}

	public void setTofbid(Long tofbid) {
		this.tofbid = tofbid;
	}

	public String getTofbname() {
		return tofbname;
	}

	public void setTofbname(String tofbname) {
		this.tofbname = tofbname;
	}

	public Double getChips() {
		return chips;
	}

	public void setChips(Double chips) {
		this.chips = chips;
	}

	public Double getOchips() {
		return ochips;
	}

	public void setOchips(Double ochips) {
		this.ochips = ochips;
	}

	public Double getWchips() {
		return wchips;
	}

	public void setWchips(Double wchips) {
		this.wchips = wchips;
	}

	public Double getSwchips() {
		return swchips;
	}

	public void setSwchips(Double swchips) {
		this.swchips = swchips;
	}


	public Double getPermin() {
		return permin;
	}

	public void setPermin(Double permin) {
		this.permin = permin;
	}

}
