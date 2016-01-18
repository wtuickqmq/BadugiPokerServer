package com.badugi.game.logic.model.domain.vo.api.match;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * api登记比赛返回值
 * 
 * @author amin
 */
public class JoinMatchVo extends ResultVo {

	private Long code;
	private String desc;
	private Integer gt;
	private Integer mt;

	public JoinMatchVo() {
		super();
	}

	public JoinMatchVo(Long code, String desc, String detailError, Integer gt, Integer mt) {
		super();
		this.code = code;
		this.desc = desc + ", " + detailError;
		this.gt = gt;
		this.mt = mt;
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

	public Integer getGt() {
		return gt;
	}

	public void setGt(Integer gt) {
		this.gt = gt;
	}

	public Integer getMt() {
		return mt;
	}

	public void setMt(Integer mt) {
		this.mt = mt;
	}

}
