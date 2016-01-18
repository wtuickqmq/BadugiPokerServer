package com.badugi.game.logic.model.vo.api.match.matchplayinfo.acgl;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class IsCuragentVo extends ResultVo{

	private Long code;
	private String desc;
	private Integer isa;//是否代理
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
	public Integer getIsa() {
		return isa;
	}
	public void setIsa(Integer isa) {
		this.isa = isa;
	}

	

}
