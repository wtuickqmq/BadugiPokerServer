package com.badugi.game.logic.model.vo.api.shop;

import java.io.Serializable;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class PresentChipsVo extends ResultVo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long code;
	private String desc;
	private String tofbn;
	private Double chips;

	public PresentChipsVo() {
		super();
	}

	public PresentChipsVo(Long code, String desc, String tofbn, Double chips) {
		super();
		this.code = code;
		this.desc = desc;
		this.tofbn = tofbn;
		this.chips = chips;
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

	public String getTofbn() {
		return tofbn;
	}

	public void setTofbn(String tofbn) {
		this.tofbn = tofbn;
	}

	public Double getChips() {
		return chips;
	}

	public void setChips(Double chips) {
		this.chips = chips;
	}

}
