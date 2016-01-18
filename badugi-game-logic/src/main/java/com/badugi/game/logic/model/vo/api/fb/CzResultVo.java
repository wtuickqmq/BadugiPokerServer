package com.badugi.game.logic.model.vo.api.fb;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 
* 项目名称：qq1.0   
* 类名称：CzResultVo   
* 创建人：huangcaiyuan 
* emial: caiyuan.huang@gmail.com   
* 创建时间：Sep 10, 2013 3:27:57 PM    
* @version 1.0
 */
public class CzResultVo extends ResultVo {
	
	private Long code;
	private String description;
	private Integer chips;
	private String amount;
	private String currency;
	
	public CzResultVo(Long code, String description) {
		super();
		this.code = code;
		this.description = description;
	}
	
	public CzResultVo(Long code, String description,String detailError) {
		super();
		this.code = code;
		this.description = description  + " " + detailError ;
	}

	public CzResultVo(Long code, String description, Integer chips,
			String amount, String currency) {
		super();
		this.code = code;
		this.description = description;
		this.chips = chips;
		this.amount = amount;
		this.currency = currency;
	}

	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getChips() {
		return chips;
	}

	public void setChips(Integer chips) {
		this.chips = chips;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
