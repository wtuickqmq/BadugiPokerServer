package com.badugi.game.logic.model.vo.api.shop;

import java.io.Serializable;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class ExchangeGoodsVo extends ResultVo implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long code;
	private String desc;
	private Integer count;
	private Integer chips;
	
	
	public ExchangeGoodsVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ExchangeGoodsVo(Long code, String desc, Integer count, Integer chips) {
		super();
		this.code = code;
		this.desc = desc;
		this.count = count;
		this.chips = chips;
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


	public Integer getChips() {
		return chips;
	}


	public void setChips(Integer chips) {
		this.chips = chips;
	}


}
