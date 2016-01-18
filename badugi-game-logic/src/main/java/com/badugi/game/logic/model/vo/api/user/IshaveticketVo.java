package com.badugi.game.logic.model.vo.api.user;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class IshaveticketVo extends ResultVo{

	private Long code;
	private String desc;
	private boolean ih;
	
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
	public boolean isIh() {
		return ih;
	}
	public void setIh(boolean ih) {
		this.ih = ih;
	}
	public IshaveticketVo(Long code, String desc, boolean ih) {
		super();
		this.code = code;
		this.desc = desc;
		this.ih = ih;
	}
	
}
