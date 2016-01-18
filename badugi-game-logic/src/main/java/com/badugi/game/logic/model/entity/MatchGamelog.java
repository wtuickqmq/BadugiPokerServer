package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MatchGamelog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "match_gamelog")
public class MatchGamelog extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer roundId;
	private Integer matchId;
	private Double smallBlind;
	private Double bigBlind;
	private Integer roomUserCount;
	private String roomId;
	private String roomName;
	private Timestamp beginTime;
	private Timestamp endTime;
	private Integer playTime;
	private Short userCount;
	private Double points;
	private Double pot;
	private Short betRound;
	private String publicCards;
	private String nickNames;
	private String winUsers;
	private String remark;

	// Constructors

	/** default constructor */
	public MatchGamelog() {
	}

	/** minimal constructor */
	public MatchGamelog(Integer roundId, Integer matchId, Double smallBlind,
			Double bigBlind, Integer roomUserCount, String roomId,
			String roomName, Timestamp beginTime, Timestamp endTime,
			Integer playTime, Short userCount, Double points, Double pot,
			Short betRound, String publicCards, String winUsers) {
		this.roundId = roundId;
		this.matchId = matchId;
		this.smallBlind = smallBlind;
		this.bigBlind = bigBlind;
		this.roomUserCount = roomUserCount;
		this.roomId = roomId;
		this.roomName = roomName;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.playTime = playTime;
		this.userCount = userCount;
		this.points = points;
		this.pot = pot;
		this.betRound = betRound;
		this.publicCards = publicCards;
		this.winUsers = winUsers;
	}

	/** full constructor */
	public MatchGamelog(Integer roundId, Integer matchId, Double smallBlind,
			Double bigBlind, Integer roomUserCount, String roomId,
			String roomName, Timestamp beginTime, Timestamp endTime,
			Integer playTime, Short userCount, Double points, Double pot,
			Short betRound, String publicCards, String nickNames,
			String winUsers, String remark) {
		this.roundId = roundId;
		this.matchId = matchId;
		this.smallBlind = smallBlind;
		this.bigBlind = bigBlind;
		this.roomUserCount = roomUserCount;
		this.roomId = roomId;
		this.roomName = roomName;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.playTime = playTime;
		this.userCount = userCount;
		this.points = points;
		this.pot = pot;
		this.betRound = betRound;
		this.publicCards = publicCards;
		this.nickNames = nickNames;
		this.winUsers = winUsers;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@Column(name = "RoundID", unique = true, nullable = false)
	public Integer getRoundId() {
		return this.roundId;
	}

	public void setRoundId(Integer roundId) {
		this.roundId = roundId;
	}

	@Column(name = "MatchId", nullable = false)
	public Integer getMatchId() {
		return this.matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	@Column(name = "SmallBlind", nullable = false, scale = 4)
	public Double getSmallBlind() {
		return this.smallBlind;
	}

	public void setSmallBlind(Double smallBlind) {
		this.smallBlind = smallBlind;
	}

	@Column(name = "BigBlind", nullable = false, scale = 4)
	public Double getBigBlind() {
		return this.bigBlind;
	}

	public void setBigBlind(Double bigBlind) {
		this.bigBlind = bigBlind;
	}

	@Column(name = "RoomUserCount", nullable = false)
	public Integer getRoomUserCount() {
		return this.roomUserCount;
	}

	public void setRoomUserCount(Integer roomUserCount) {
		this.roomUserCount = roomUserCount;
	}

	@Column(name = "RoomID", nullable = false, length = 50)
	public String getRoomId() {
		return this.roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	@Column(name = "RoomName", nullable = false, length = 20)
	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@Column(name = "BeginTime", nullable = false, length = 19)
	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	@Column(name = "EndTime", nullable = false, length = 19)
	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	@Column(name = "PlayTime", nullable = false)
	public Integer getPlayTime() {
		return this.playTime;
	}

	public void setPlayTime(Integer playTime) {
		this.playTime = playTime;
	}

	@Column(name = "UserCount", nullable = false)
	public Short getUserCount() {
		return this.userCount;
	}

	public void setUserCount(Short userCount) {
		this.userCount = userCount;
	}

	@Column(name = "Points", nullable = false, scale = 4)
	public Double getPoints() {
		return this.points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	@Column(name = "Pot", nullable = false, scale = 4)
	public Double getPot() {
		return this.pot;
	}

	public void setPot(Double pot) {
		this.pot = pot;
	}

	@Column(name = "BetRound", nullable = false)
	public Short getBetRound() {
		return this.betRound;
	}

	public void setBetRound(Short betRound) {
		this.betRound = betRound;
	}

	@Column(name = "PublicCards", nullable = false, length = 50)
	public String getPublicCards() {
		return this.publicCards;
	}

	public void setPublicCards(String publicCards) {
		this.publicCards = publicCards;
	}

	@Column(name = "NickNames", length = 300)
	public String getNickNames() {
		return this.nickNames;
	}

	public void setNickNames(String nickNames) {
		this.nickNames = nickNames;
	}

	@Column(name = "WinUsers", nullable = false, length = 100)
	public String getWinUsers() {
		return this.winUsers;
	}

	public void setWinUsers(String winUsers) {
		this.winUsers = winUsers;
	}

	@Column(name = "Remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}