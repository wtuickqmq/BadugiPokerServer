package com.badugi.game.logic.model.vo.api.user;

import java.io.Serializable;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class IsfriendVo extends ResultVo implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long code;
	private String desc;
	private Boolean isf;
	
	
	public IsfriendVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public IsfriendVo(Long code, String desc, Boolean isf) {
		super();
		this.code = code;
		this.desc = desc;
		this.isf = isf;
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


	public Boolean getIsf() {
		return isf;
	}


	public void setIsf(Boolean isf) {
		this.isf = isf;
	}


	
	
}
