package com.badugi.game.logic.model.vo.api.shop;

import java.io.Serializable;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class PresentTicketGiftVo extends ResultVo implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long code;
	private String desc;
	private Integer count;
	private String tofbn;
	
	
	public PresentTicketGiftVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PresentTicketGiftVo(Long code, String desc, Integer count, String tofbn) {
		super();
		this.code = code;
		this.desc = desc;
		this.count = count;
		this.tofbn = tofbn;
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


	public String getTofbn() {
		return tofbn;
	}


	public void setTofbn(String tofbn) {
		this.tofbn = tofbn;
	}


	
}
