package com.badugi.game.logic.model.vo.api.fb;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class IsLikeVo extends ResultVo{

	private Long code;
	private String desc;
	private boolean islike;
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
	public boolean isIslike() {
		return islike;
	}
	public void setIslike(boolean islike) {
		this.islike = islike;
	}
	
	
	public IsLikeVo(Long code, String desc, boolean islike) {
		super();
		this.code = code;
		this.desc = desc;
		this.islike = islike;
	}
	public IsLikeVo() {
		super();
	}
	
	
	
}
