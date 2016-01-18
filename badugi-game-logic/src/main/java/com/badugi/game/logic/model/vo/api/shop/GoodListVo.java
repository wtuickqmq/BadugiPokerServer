package com.badugi.game.logic.model.vo.api.shop;

import java.io.Serializable;
import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class GoodListVo extends ResultVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long code;
	private String desc;
	private List<GoodVo> list;
	private Integer ac;
	private List<GoodNum> glists;
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
	public List<GoodVo> getList() {
		return list;
	}
	public void setList(List<GoodVo> list) {
		this.list = list;
	}
	public Integer getAc() {
		return ac;
	}
	public void setAc(Integer ac) {
		this.ac = ac;
	}
	public List<GoodNum> getGlists() {
		return glists;
	}
	public void setGlists(List<GoodNum> glists) {
		this.glists = glists;
	}
	public GoodListVo(Long code, String desc, List<GoodVo> list, Integer ac,
			List<GoodNum> glists) {
		super();
		this.code = code;
		this.desc = desc;
		this.list = list;
		this.ac = ac;
		this.glists = glists;
	}
	public GoodListVo() {
		super();
	}
	
}
