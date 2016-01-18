package com.badugi.game.logic.model.vo.api.user;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 牌桌中标记返回值
 * 
 * @author amin
 */
public class MyFlagsResultVo extends ResultVo {

	private Long code;
	private String desc;
	private List<MyFlagsDetail> list;

	public MyFlagsResultVo() {
		super();
	}

	public MyFlagsResultVo(Long code, String desc, List<MyFlagsDetail> list) {
		super();
		this.code = code;
		this.desc = desc;
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

	public List<MyFlagsDetail> getList() {
		return list;
	}

	public void setList(List<MyFlagsDetail> list) {
		this.list = list;
	}

}
