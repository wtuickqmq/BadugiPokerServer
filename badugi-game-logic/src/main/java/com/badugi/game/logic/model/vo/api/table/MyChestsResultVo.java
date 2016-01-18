package com.badugi.game.logic.model.vo.api.table;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 牌桌中任务返回值
 * 
 * @author amin
 */
public class MyChestsResultVo extends ResultVo {

	private Long code;
	private String desc;
	private Long fbid;
	private List<MyChestsDetailVo> cslist;// 小任务

	public MyChestsResultVo() {
		super();
	}

	public MyChestsResultVo(Long code, String desc, Long fbid,
			List<MyChestsDetailVo> cslist) {
		super();
		this.code = code;
		this.desc = desc;
		this.fbid = fbid;
		this.cslist = cslist;
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

	public Long getFbid() {
		return fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}

	public List<MyChestsDetailVo> getCslist() {
		return cslist;
	}

	public void setCslist(List<MyChestsDetailVo> cslist) {
		this.cslist = cslist;
	}

}
