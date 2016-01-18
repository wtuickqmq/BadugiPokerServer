package com.badugi.game.logic.model.vo.api;

public class JewelBoxMoneyVo extends ResultVo {
	private Long code;
	private String desc;
	private Long allmoney;
	private Long siglemoney;
	
	
	public JewelBoxMoneyVo() {
		super();
	}
	public JewelBoxMoneyVo(Long code, String desc, Long allmoney,
			Long siglemoney) {
		super();
		this.code = code;
		this.desc = desc;
		this.allmoney = allmoney;
		this.siglemoney = siglemoney;
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
	public Long getAllmoney() {
		return allmoney;
	}
	public void setAllmoney(Long allmoney) {
		this.allmoney = allmoney;
	}
	public Long getSiglemoney() {
		return siglemoney;
	}
	public void setSiglemoney(Long siglemoney) {
		this.siglemoney = siglemoney;
	}
	
	

}
