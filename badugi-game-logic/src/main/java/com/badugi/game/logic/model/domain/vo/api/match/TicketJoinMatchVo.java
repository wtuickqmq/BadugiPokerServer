package com.badugi.game.logic.model.domain.vo.api.match;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * api门票登记比赛
 * 
 * @author amin
 */
public class TicketJoinMatchVo extends ResultVo {

	private Long code;
	private String desc;
	private Integer mid;

	public TicketJoinMatchVo() {
		super();
	}

	public TicketJoinMatchVo(Long code, String desc, Integer mid) {
		super();
		this.code = code;
		this.desc = desc;
		this.mid = mid;
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

}
