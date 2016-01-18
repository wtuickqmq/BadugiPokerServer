package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GameUserlog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "game_userlog")
public class GameUserlog extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer ulogId;
	private Integer roundId;
	private Integer applyId;
	private Short roomLevel;
	private Double smallBlind;
	private Double bigBlind;
	private Integer roomUserCount;
	private String roomName;
	private Integer roomGroupId;
	private Integer roomId;
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
	private Short winMainPool;
	private Double expValue;
	private Short userFlag;
	private String holeCards;
	private String roundMaxCards;
	private Short handCardType;
	private String ip;
	private String remark;

	// Constructors

	/** default constructor */
	public GameUserlog() {
	}


	/** minimal constructor */
	public GameUserlog(Integer roundId, Integer applyId, Short roomLevel,
			Double smallBlind, Double bigBlind, Integer roomUserCount,
			String roomName, Integer roomGroupId, Integer roomId, Long fbId,
			Short position, Timestamp beginTime, Timestamp endTime,
			Integer playTime, Double oldChips, Double betChips,
			Double winChips, Double changeChips, Double points,
			Double vipPoints, Double expValue, Short userFlag,
			String holeCards, String ip) {
		this.roundId = roundId;
		this.applyId = applyId;
		this.roomLevel = roomLevel;
		this.smallBlind = smallBlind;
		this.bigBlind = bigBlind;
		this.roomUserCount = roomUserCount;
		this.roomName = roomName;
		this.roomGroupId = roomGroupId;
		this.roomId = roomId;
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
	public GameUserlog(Integer roundId, Integer applyId, Short roomLevel,
			Double smallBlind, Double bigBlind, Integer roomUserCount,
			String roomName, Integer roomGroupId, Integer roomId, Long fbId,
			String nickName, Short position, Timestamp beginTime,
			Timestamp endTime, Integer playTime, Double oldChips,
			Double betChips, Double winChips, Double changeChips,
			Double points, Double vipPoints, Double expValue, Short userFlag,
			String holeCards, String ip, String remark) {
		this.roundId = roundId;
		this.applyId = applyId;
		this.roomLevel = roomLevel;
		this.smallBlind = smallBlind;
		this.bigBlind = bigBlind;
		this.roomUserCount = roomUserCount;
		this.roomName = roomName;
		this.roomGroupId = roomGroupId;
		this.roomId = roomId;
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
	
	public GameUserlog(Long fbId, String nickName, Date beginTime, Date endTime, Long playTime, Double changeChips, Double points, Double smallBlind, Integer roomUserCount,
			String roomName) {
		super();
		this.fbId = fbId;
		this.nickName = nickName;
		this.beginTime = new Timestamp( beginTime.getTime());
		this.endTime =  new Timestamp(  endTime.getTime());
		this.playTime = playTime.intValue();
		this.changeChips = changeChips;
		this.points = points;
		this.smallBlind = smallBlind;
		this.roomUserCount = roomUserCount;
		this.roomName = roomName;
	}

	public GameUserlog(Long fbId, String nickName, Timestamp beginTime, Timestamp endTime, Integer playTime, Double changeChips, Double points) {
		super();
		this.fbId = fbId;
		this.nickName = nickName;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.playTime = playTime;
		this.changeChips = changeChips;
		this.points = points;
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

	@Column(name = "ApplyID", nullable = false)
	public Integer getApplyId() {
		return this.applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	@Column(name = "RoomLevel", nullable = false)
	public Short getRoomLevel() {
		return this.roomLevel;
	}

	public void setRoomLevel(Short roomLevel) {
		this.roomLevel = roomLevel;
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

	@Column(name = "RoomName", nullable = false, length = 20)
	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@Column(name = "RoomGroupID", nullable = false)
	public Integer getRoomGroupId() {
		return this.roomGroupId;
	}

	public void setRoomGroupId(Integer roomGroupId) {
		this.roomGroupId = roomGroupId;
	}

	@Column(name = "RoomID", nullable = false)
	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
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

	@Column(name = "ExpValue", nullable = false, scale = 4)
	public Double getExpValue() {
		return this.expValue;
	}

	public void setExpValue(Double expValue) {
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
	
	@Column(name = "RoundMaxCards", nullable = false, length = 20)
	public String getRoundMaxCards() {
		return roundMaxCards;
	}

	public void setRoundMaxCards(String roundMaxCards) {
		this.roundMaxCards = roundMaxCards;
	}

	@Column(name = "HandCardType", nullable = false)
	public Short getHandCardType() {
		return handCardType;
	}

	public void setHandCardType(Short handCardType) {
		this.handCardType = handCardType;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "WinMainPool", nullable = false)
	public Short getWinMainPool() {
		return winMainPool;
	}


	public void setWinMainPool(Short winMainPool) {
		this.winMainPool = winMainPool;
	}
	
	

}