package com.badugi.game.logic.model.vo.api.table;

import java.io.Serializable;
import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class FlagtipVo extends ResultVo implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long code;
	private String desc;
	private Integer istip;
	private List<UserBasicVo> list;
	
	
	public FlagtipVo() {
		super();
	}


	public FlagtipVo(Long code, String desc, Integer istip,
			List<UserBasicVo> list) {
		super();
		this.code = code;
		this.desc = desc;
		this.istip = istip;
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


	public Integer getIstip() {
		return istip;
	}


	public void setIstip(Integer istip) {
		this.istip = istip;
	}


	public List<UserBasicVo> getList() {
		return list;
	}


	public void setList(List<UserBasicVo> list) {
		this.list = list;
	}


	
}
