package com.badugi.game.logic.model.vo.api.match;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * api快速登记比赛
 * 
 * @author amin
 */
public class FastJoinMatchVo extends ResultVo {

	private Long code;
	private String desc;
	private Integer mid;
	private Integer st;

	public FastJoinMatchVo() {
		super();
	}

	public FastJoinMatchVo(Long code, String desc, Integer mid) {
		super();
		this.code = code;
		this.desc = desc;
		this.mid = mid;
	}
	
	public FastJoinMatchVo(Long code, String desc, Integer mid, Integer st) {
		super();
		this.code = code;
		this.desc = desc;
		this.mid = mid;
		this.st = st;
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

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}
	
	public Integer getSt() {
		return st;
	}
	
	public void setSt(Integer st) {
		this.st = st;
	}

}
