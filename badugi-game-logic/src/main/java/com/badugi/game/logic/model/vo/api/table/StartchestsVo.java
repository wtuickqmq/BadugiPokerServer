package com.badugi.game.logic.model.vo.api.table;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class StartchestsVo extends ResultVo{

	private Long code;
	private String desc;
	private Integer time;
	private Integer roundid;
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
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public Integer getRoundid() {
		return roundid;
	}
	public void setRoundid(Integer roundid) {
		this.roundid = roundid;
	}
	public String getPrize() {
		return prize;
	}
	public void setPrize(String prize) {
		this.prize = prize;
	}
	
	
	public StartchestsVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StartchestsVo(Long code, String desc, Integer time, Integer roundid,
			String prize) {
		super();
		this.code = code;
		this.desc = desc;
		this.time = time;
		this.roundid = roundid;
		this.prize = prize;
	}
	
	
}
