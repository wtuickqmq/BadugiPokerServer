package com.badugi.game.logic.model.vo.api.match;

import java.io.Serializable;
import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class TicketListVo extends ResultVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long code;
	private String desc;
	private List<TicketVo> list;
	private Integer ac;
	private List<TicketNum> tlists;
	
	public TicketListVo() {
		super();
	}
	public TicketListVo(Long code, String desc, List<TicketVo> list, Integer ac,List<TicketNum> tlists) {
		super();
		this.code = code;
		this.desc = desc;
		this.list = list;
		this.ac = ac;
		this.tlists=tlists;
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
	public List<TicketVo> getList() {
		return list;
	}
	public void setList(List<TicketVo> list) {
		this.list = list;
	}
	public Integer getAc() {
		return ac;
	}
	public void setAc(Integer ac) {
		this.ac = ac;
	}
	public List<TicketNum> getTlists() {
		return tlists;
	}
	public void setTlists(List<TicketNum> tlists) {
		this.tlists = tlists;
	}
	

}
