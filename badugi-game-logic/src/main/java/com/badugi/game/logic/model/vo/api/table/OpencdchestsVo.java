package com.badugi.game.logic.model.vo.api.table;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class OpencdchestsVo extends ResultVo{

	private Long code;
	private String desc;
	private String prize;
	
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
	public String getPrize() {
		return prize;
	}
	public void setPrize(String prize) {
		this.prize = prize;
	}
	public OpencdchestsVo(Long code, String desc, String prize) {
		super();
		this.code = code;
		this.desc = desc;
		this.prize = prize;
	}
	
	
}
