package com.badugi.game.logic.model.domain.vo.flash.api;


import javax.persistence.Entity;

import javax.persistence.Table;

import com.badugi.game.logic.model.domain.vo.flash.ResultVo;


@Entity
@Table(name = "jewel_box")
public class JewelBoxVo extends ResultVo {
	
	private Integer Id;
	private Long RoundID;//游戏局次
	private Long Fbid;//玩家ID
	private String nickname;//玩家呢称
	private String holecards;//玩家手中的牌
	private Short isWiner;//是否赢得主池
	private Integer WinType;//中奖类型
	private String WinCards;//中奖牌型
	private String WinTime;//中奖时间
	private Long BetMoney;//下注筹码
	private Long WinMoney;//中奖筹码
	private Integer count;//同类型中奖次数
	private Short isGet;//是否领奖 0未领取，1已领取
	
	public JewelBoxVo() {
		super();
		
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Long getRoundID() {
		return RoundID;
	}

	public void setRoundID(Long roundID) {
		RoundID = roundID;
	}


	public Long getFbid() {
		return Fbid;
	}

	public void setFbid(Long fbid) {
		this.Fbid = fbid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHolecards() {
		return holecards;
	}

	public void setHolecards(String holecards) {
		this.holecards = holecards;
	}

	public Short getIsWiner() {
		return isWiner;
	}

	public void setIsWiner(Short isWiner) {
		this.isWiner = isWiner;
	}

	public Integer getWinType() {
		return WinType;
	}

	public void setWinType(Integer winType) {
		WinType = winType;
	}

	public String getWinCards() {
		return WinCards;
	}

	public void setWinCards(String winCards) {
		WinCards = winCards;
	}

	public String getWinTime() {
		return WinTime;
	}

	public void setWinTime(String winTime) {
		WinTime = winTime;
	}

	public Long getBetMoney() {
		return BetMoney;
	}

	public void setBetMoney(Long betMoney) {
		BetMoney = betMoney;
	}

	public Long getWinMoney() {
		return WinMoney;
	}

	public void setWinMoney(Long winMoney) {
		WinMoney = winMoney;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Short getIsGet() {
		return isGet;
	}

	public void setIsGet(Short isGet) {
		this.isGet = isGet;
	}
	
	
	
	
}
