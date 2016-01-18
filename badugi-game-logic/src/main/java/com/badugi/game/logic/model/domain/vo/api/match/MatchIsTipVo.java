package com.badugi.game.logic.model.domain.vo.api.match;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * api比赛登记是否已登记
 * 
 * @author amin
 */
public class MatchIsTipVo extends ResultVo {

	private Long code;
	private String desc;
	private List<MatchIsTipDetail> list;

	public MatchIsTipVo() {
		super();
	}

	public MatchIsTipVo(Long code, String desc, List<MatchIsTipDetail> list) {
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

	public List<MatchIsTipDetail> getList() {
		return list;
	}

	public void setList(List<MatchIsTipDetail> list) {
		this.list = list;
	}

}
