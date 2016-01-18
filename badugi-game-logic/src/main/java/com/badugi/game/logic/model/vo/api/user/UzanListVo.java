package com.badugi.game.logic.model.vo.api.user;

import java.io.Serializable;
import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class UzanListVo extends ResultVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long code;
	private String desc;
	private List<ComUser> list;
	
	
	public UzanListVo(Long code, String desc, List<ComUser> list) {
		super();
		this.code = code;
		this.desc = desc;
		this.list = list;
	}

	public UzanListVo() {
		super();
	}
	
	public List<ComUser> getList() {
		return list;
	}
	public void setList(List<ComUser> list) {
		this.list = list;
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
	
	
	
}
