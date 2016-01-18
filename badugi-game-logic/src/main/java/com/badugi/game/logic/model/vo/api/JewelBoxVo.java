package com.badugi.game.logic.model.vo.api;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "jewel_box")
public class JewelBoxVo extends ResultVo {
	private Integer id;
	private Long roundid;//游戏局次
	private Long fbid;//玩家ID
	private String fbname;//玩家呢称
	private String holecards;//玩家手中的牌
	private Short isWiner;//是否赢得主池
	private Short wintype;//中奖类型
	private String wincards;//中奖牌型
	private String wintime;//中奖时间
	private Long betmoney;//下注筹码
	private Long winmoney;//中奖筹码
	private Integer count;//同类型中奖次数
	private Short isget;//是否领奖 0未领取，1已领取
	
	public JewelBoxVo() {
		super();
		
	}
	public JewelBoxVo(Long roundid, Long fbid) {
		super();
		this.roundid = roundid;
		this.fbid = fbid;
	}
	
	public JewelBoxVo(Long roundid, Long fbid, Long betmoney) {
		super();
		this.roundid = roundid;
		this.fbid = fbid;
		this.betmoney = betmoney;
	}
	public JewelBoxVo(Long fbid, String fbname, Short wintype, String wincards,
			String wintime, Long winmoney, Integer count, Short isget) {
		super();
		this.fbid = fbid;
		this.fbname = fbname;
		this.wintype = wintype;
		this.wincards = wincards;
		this.wintime = wintime;
		this.winmoney = winmoney;
		this.count = count;
		this.isget = isget;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	@Column(name = "HoleCards", length = 20)
	public String getHoleCards() {
		return holecards;
	}
	public void setHoleCards(String holeCards) {
		this.holecards = holeCards;
	}
	
	@Column(name = "WinType", nullable = false)
	public Short getWintype() {
		return wintype;
	}
	public void setWintype(Short wintype) {
		this.wintype = wintype;
	}
	
	
	@Column(name = "RoundID", nullable = false)
	public Long getRoundid() {
		return roundid;
	}
	public void setRoundid(Long roundid) {
		this.roundid = roundid;
	}
	
	@Column(name = "Fbid", nullable = false)
	public Long getFbid() {
		return fbid;
	}
	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}
	
	@Column(name = "WinCards", length = 20)
	public String getWincards() {
		return wincards;
	}
	public void setWincards(String wincards) {
		this.wincards = wincards;
	}
	
	@Column(name = "WinTime", nullable = false, length = 19)
	public String getWintime() {
		return wintime;
	}
	public void setWintime(String wintime) {
		this.wintime = wintime;
	}

	@Column(name = "BetMoney", nullable = false)
	public Long getBetmoney() {
		return betmoney;
	}
	public void setBetmoney(Long betmoney) {
		this.betmoney = betmoney;
	}
	
	@Column(name = "WinMoney", nullable = false)
	public Long getWinmoney() {
		return winmoney;
	}
	public void setWinmoney(Long winmoney) {
		this.winmoney = winmoney;
	}
	
	@Column(name = "isGet", nullable = false)
	public Short getIsget() {
		return isget;
	}
	public void setIsget(Short isget) {
		this.isget = isget;
	}
		
	public String getFbname() {
		return fbname;
	}
	public void setFbname(String fbname) {
		this.fbname = fbname;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Short getIsWiner() {
		return isWiner;
	}
	public void setIsWiner(Short isWiner) {
		this.isWiner = isWiner;
	}
	
	
	
}
