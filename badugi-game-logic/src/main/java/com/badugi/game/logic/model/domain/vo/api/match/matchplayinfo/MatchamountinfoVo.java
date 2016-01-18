package com.badugi.game.logic.model.domain.vo.api.match.matchplayinfo;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class MatchamountinfoVo extends ResultVo{

	private Long code;
	private String desc;
	private List<BonusSaiQian> mlist;//奖金集合
	
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
	public List<BonusSaiQian> getMlist() {
		return mlist;
	}
	public void setMlist(List<BonusSaiQian> mlist) {
		this.mlist = mlist;
	}
	
	
}
