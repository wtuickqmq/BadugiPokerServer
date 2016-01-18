package com.badugi.game.logic.model.vo.api.match.matchplayinfo.acgl;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class CuragentListVo extends ResultVo {

	private Long code;
	private String desc;
	private Long gfbid;
	private String gname;
	private List<AgentVo> list ;

	public List<AgentVo> getList() {
		return list;
	}

	public void setList(List<AgentVo> list) {
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

	public Long getGfbid() {
		return gfbid;
	}

	public void setGfbid(Long gfbid) {
		this.gfbid = gfbid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}
	
	

}
