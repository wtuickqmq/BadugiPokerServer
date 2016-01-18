package com.badugi.game.logic.model.vo.api.shop;

import java.io.Serializable;
import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class TicketGoodListVo extends ResultVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long code;
	private String desc;
	private Double rebate;
	private List<TicketGoodVo> list;
	
	public TicketGoodListVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TicketGoodListVo(Long code, String desc, List<TicketGoodVo> list,Double rebate) {
		super();
		this.code = code;
		this.desc = desc;
		this.list = list;
		this.rebate=rebate;
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
	public List<TicketGoodVo> getList() {
		return list;
	}
	public void setList(List<TicketGoodVo> list) {
		this.list = list;
	}
	public Double getRebate() {
		return rebate;
	}
	public void setRebate(Double rebate) {
		this.rebate = rebate;
	}
	
}
