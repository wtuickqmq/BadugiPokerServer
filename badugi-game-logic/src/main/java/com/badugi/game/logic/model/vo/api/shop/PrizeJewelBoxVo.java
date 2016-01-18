package com.badugi.game.logic.model.vo.api.shop;

public class PrizeJewelBoxVo {
	private Integer id;
	private Short wintype;//中奖类型
	private String wincards;//中奖牌型
	private String wintime;//中奖时间
	private Integer winmoney;//中奖筹码
	
	public PrizeJewelBoxVo() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Short getWintype() {
		return wintype;
	}
	public void setWintype(Short wintype) {
		this.wintype = wintype;
	}
	public String getWincards() {
		return wincards;
	}
	public void setWincards(String wincards) {
		this.wincards = wincards;
	}
	public String getWintime() {
		return wintime;
	}
	public void setWintime(String wintime) {
		this.wintime = wintime;
	}
	public Integer getWinmoney() {
		return winmoney;
	}
	public void setWinmoney(Integer winmoney) {
		this.winmoney = winmoney;
	}
	
}
