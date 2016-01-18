package com.badugi.game.logic.model.domain.vo.flash.operators;

import java.util.Map;

/**
 * 比赛用户奖金分配
 * @author amin
 */
public class MatchUserBonus {

	private Integer matchId;
	private Long fbid;
	private String fbName;
	private String rid;
	private Integer rank;
	private Double bonus;
	private Map<Integer,Integer> allkillUsers;

	public MatchUserBonus() {
		super();
	}

	public MatchUserBonus(Integer matchId, Long fbid, String fbName, String rid, Integer rank, 
			Double bonus, Map<Integer,Integer> allkillUsers) {
		super();
		this.matchId = matchId;
		this.fbid = fbid;
		this.fbName = fbName;
		this.rid = rid;
		this.rank = rank;
		this.bonus = bonus;
		this.allkillUsers = allkillUsers;
	}

	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}
	
	public String getFbName() {
		return fbName;
	}
	
	public void setFbName(String fbName) {
		this.fbName = fbName;
	}

	public Long getFbid() {
		return fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}
	
	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
	
	public Map<Integer, Integer> getAllkillUsers() {
		return allkillUsers;
	}
	
	public void setAllkillUsers(Map<Integer, Integer> allkillUsers) {
		this.allkillUsers = allkillUsers;
	}

}
