package com.badugi.game.logic.model.vo.api.operator;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class MyPrizeListVo extends ResultVo{

	private Long code;
	private String desc;
	private Integer count;
	private List<MyPrize> list;
	
	
	
	public MyPrizeListVo(Long code, String desc, Integer count,
			List<MyPrize> list) {
		super();
		this.code = code;
		this.desc = desc;
		this.count = count;
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<MyPrize> getList() {
		return list;
	}
	public void setList(List<MyPrize> list) {
		this.list = list;
	}
	
}
