package com.badugi.game.logic.model.vo.api.user;

import java.io.Serializable;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class LikeVo extends ResultVo implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long code;
	private String desc;
	private Integer count;
	
	public LikeVo() {
		super();
	}

	public LikeVo(Long code, String desc, Integer count) {
		super();
		this.code = code;
		this.desc = desc;
		this.count = count;
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}


	
}
