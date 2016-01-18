package com.badugi.game.logic.model.vo.record;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 
* 项目名称：qq1.0   
* 类名称：MathcLobbyGrVo   
* 创建人：huangcaiyuan 
* emial: caiyuan.huang@gmail.com   
* 创建时间：Feb 25, 2013 3:19:22 PM    
* @version 1.0
 */

public class MathcLobbyGrVo {
	public Integer matchId;
	public Short payType;
	public String name;
	public Double payAcount;
	public String inits;
	public Timestamp startTime;
	public Timestamp registerTime;
	public Integer rank;
	public Double wins;
	public Integer ticketId;
	public String matchResult;
//	select new vo.record.MathcLobbyGrVo(mu.matchId,mcf.matchName,mu.payType,mu.payAmount,mu.registTime,mu.rank,mu.bonus)
	public MathcLobbyGrVo(Integer matchId, String name,Short payType,Double payAcount,
			Date startTime, Date registerTime, Integer rank, Double wins,Integer ticketId) {
		super();
		this.matchId = matchId;
		this.name = name;
		this.payType=payType;
		this.payAcount=payAcount;
		this.startTime = new Timestamp(startTime.getTime());
		this.registerTime = new Timestamp(registerTime.getTime());
//		this.startTime = startTime;
		this.rank = rank;
		this.wins = wins;
		this.ticketId=ticketId;
		
	}



	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public Short getPayType() {
		return payType;
	}

	public void setPayType(Short payType) {
		this.payType = payType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPayAcount() {
		return payAcount;
	}

	public void setPayAcount(Double payAcount) {
		this.payAcount = payAcount;
	}

	public String getInits() {
		return inits;
	}

	public void setInits(String inits) {
		this.inits = inits;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Double getWins() {
		return wins;
	}

	public void setWins(Double wins) {
		this.wins = wins;
	}


	public Timestamp getRegisterTime() {
		return registerTime;
	}


	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}


	public Integer getTicketId() {
		return ticketId;
	}


	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}


	public String getMatchResult() {
		return matchResult;
	}



	public void setMatchResult(String matchResult) {
		this.matchResult = matchResult;
	}
	
	
	
}
