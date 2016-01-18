package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MatchUsergamelog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "match_usergamelog")
public class MatchUsergamelog extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer ulogId;
	private Integer roundId;
	private Integer matchId;
	private Double smallBlind;
	private Double bigBlind;
	private Integer roomUserCount;
	private String roomId;
	private String roomName;
	private Long fbId;
	private String nickName;
	private Short position;
	private Timestamp beginTime;
	private Timestamp endTime;
	private Integer playTime;
	private Double oldChips;
	private Double betChips;
	private Double winChips;
	private Double changeChips;
	private Double points;
	private Double vipPoints;
	private Integer expValue;
	private Short userFlag;
	private String holeCards;
	private String ip;
	private String remark;

	// Constructors

	/** default constructor */
	public MatchUsergamelog() {
	}

	/** minimal constructor */
	public MatchUsergamelog(Integer roundId, Integer matchId,
			Double smallBlind, Double bigBlind, Integer roomUserCount,
			String roomId, String roomName, Long fbId, Short position,
			Timestamp beginTime, Timestamp endTime, Integer playTime,
			Double oldChips, Double betChips, Double winChips,
			Double changeChips, Double points, Double vipPoints,
			Integer expValue, Short userFlag, String holeCards, String ip) {
		this.roundId = roundId;
		this.matchId = matchId;
		this.smallBlind = smallBlind;
		this.bigBlind = bigBlind;
		this.roomUserCount = roomUserCount;
		this.roomId = roomId;
		this.roomName = roomName;
		this.fbId = fbId;
		this.position = position;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.playTime = playTime;
		this.oldChips = oldChips;
		this.betChips = betChips;
		this.winChips = winChips;
		this.changeChips = changeChips;
		this.points = points;
		this.vipPoints = vipPoints;
		this.expValue = expValue;
		this.userFlag = userFlag;
		this.holeCards = holeCards;
		this.ip = ip;
	}

	/** full constructor */
	public MatchUsergamelog(Integer roundId, Integer matchId,
			Double smallBlind, Double bigBlind, Integer roomUserCount,
			String roomId, String roomName, Long fbId, String nickName,
			Short position, Timestamp beginTime, Timestamp endTime,
			Integer playTime, Double oldChips, Double betChips,
			Double winChips, Double changeChips, Double points,
			Double vipPoints, Integer expValue, Short userFlag,
			String holeCards, String ip, String remark) {
		this.roundId = roundId;
		this.matchId = matchId;
		this.smallBlind = smallBlind;
		this.bigBlind = bigBlind;
		this.roomUserCount = roomUserCount;
		this.roomId = roomId;
		this.roomName = roomName;
		this.fbId = fbId;
		this.nickName = nickName;
		this.position = position;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.playTime = playTime;
		this.oldChips = oldChips;
		this.betChips = betChips;
		this.winChips = winChips;
		this.changeChips = changeChips;
		this.points = points;
		this.vipPoints = vipPoints;
		this.expValue = expValue;
		this.userFlag = userFlag;
		this.holeCards = holeCards;
		this.ip = ip;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ULogID", unique = true, nullable = false)
	public Integer getUlogId() {
		return this.ulogId;
	}

	public void setUlogId(Integer ulogId) {
		this.ulogId = ulogId;
	}

	@Column(name = "RoundID", nullable = false)
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

	@Column(name = "FbId", nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "NickName", length = 50)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "Position", nullable = false)
	public Short getPosition() {
		return this.position;
	}

	public void setPosition(Short position) {
		this.position = position;
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

	@Column(name = "OldChips", nullable = false, scale = 4)
	public Double getOldChips() {
		return this.oldChips;
	}

	public void setOldChips(Double oldChips) {
		this.oldChips = oldChips;
	}

	@Column(name = "BetChips", nullable = false, scale = 4)
	public Double getBetChips() {
		return this.betChips;
	}

	public void setBetChips(Double betChips) {
		this.betChips = betChips;
	}

	@Column(name = "WinChips", nullable = false, scale = 4)
	public Double getWinChips() {
		return this.winChips;
	}

	public void setWinChips(Double winChips) {
		this.winChips = winChips;
	}

	@Column(name = "ChangeChips", nullable = false, scale = 4)
	public Double getChangeChips() {
		return this.changeChips;
	}

	public void setChangeChips(Double changeChips) {
		this.changeChips = changeChips;
	}

	@Column(name = "Points", nullable = false, scale = 4)
	public Double getPoints() {
		return this.points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	@Column(name = "VipPoints", nullable = false, scale = 4)
	public Double getVipPoints() {
		return this.vipPoints;
	}

	public void setVipPoints(Double vipPoints) {
		this.vipPoints = vipPoints;
	}

	@Column(name = "ExpValue", nullable = false)
	public Integer getExpValue() {
		return this.expValue;
	}

	public void setExpValue(Integer expValue) {
		this.expValue = expValue;
	}

	@Column(name = "UserFlag", nullable = false)
	public Short getUserFlag() {
		return this.userFlag;
	}

	public void setUserFlag(Short userFlag) {
		this.userFlag = userFlag;
	}

	@Column(name = "HoleCards", nullable = false, length = 20)
	public String getHoleCards() {
		return this.holeCards;
	}

	public void setHoleCards(String holeCards) {
		this.holeCards = holeCards;
	}

	@Column(name = "IP", nullable = false, length = 40)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "Remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}