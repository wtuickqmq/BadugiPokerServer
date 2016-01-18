package com.badugi.game.logic.model.domain.vo.api.match;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * api正在参与比赛人数
 * 
 * @author amin
 */
public class MatchOnlineVo extends ResultVo {

	private Long code;
	private String desc;
	private Integer count;

	public MatchOnlineVo() {
		super();
	}

	public MatchOnlineVo(Long code, String desc, Integer count) {
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
