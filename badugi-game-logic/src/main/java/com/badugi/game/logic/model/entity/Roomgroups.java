package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

/**
 * Roomgroups entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "roomgroups", uniqueConstraints = @UniqueConstraint(columnNames = "SFSGroupID"))
public class Roomgroups extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer roomGroupId;
	private Short groupType;
	private Short roomLevel;
	private String sfsgroupId;
	private Integer userCount;
	private Integer blindLevelConfigId;
	private Double minChips;
	private Double maxChips;
	private Integer timeBank;
	private Integer flushTime;
	private Integer flushValue;
	private Integer reconnectTime;
	private Double rakeValue;
	private Double rakeRate;
	private String maxRake;
	private Short status;
	private Integer intervalTime;
	private Integer thinkTime;
	private Timestamp createTime;
	private String remark;
	private String managerName;
	private Timestamp operatedTime;
	
	private String levelName;
	private Integer iminChips;
	private Integer imaxChips;
	private Double smallBlind;
	private Double bigBlind;
	private Roomlevel roomLevels;

	// Constructors

	/** default constructor */
	public Roomgroups() {
	}

	/** minimal constructor */
	public Roomgroups(Short groupType, Short roomLevel, String sfsgroupId,
			Integer userCount, Integer blindLevelConfigId, Double minChips,
			Double maxChips, Integer timeBank, Integer flushTime,
			Integer flushValue, Integer reconnectTime, Double rakeValue,
			Double rakeRate, String maxRake, Short status,
			Integer intervalTime, Integer thinkTime, Timestamp createTime) {
		this.groupType = groupType;
		this.roomLevel = roomLevel;
		this.sfsgroupId = sfsgroupId;
		this.userCount = userCount;
		this.blindLevelConfigId = blindLevelConfigId;
		this.minChips = minChips;
		this.maxChips = maxChips;
		this.timeBank = timeBank;
		this.flushTime = flushTime;
		this.flushValue = flushValue;
		this.reconnectTime = reconnectTime;
		this.rakeValue = rakeValue;
		this.rakeRate = rakeRate;
		this.maxRake = maxRake;
		this.status = status;
		this.intervalTime = intervalTime;
		this.thinkTime = thinkTime;
		this.createTime = createTime;
	}

	/** full constructor */
	public Roomgroups(Short groupType, Short roomLevel, String sfsgroupId,
			Integer userCount, Integer blindLevelConfigId, Double minChips,
			Double maxChips, Integer timeBank, Integer flushTime,
			Integer flushValue, Integer reconnectTime, Double rakeValue,
			Double rakeRate, String maxRake, Short status,
			Integer intervalTime, Integer thinkTime, Timestamp createTime,
			String remark, String managerName, Timestamp operatedTime) {
		this.groupType = groupType;
		this.roomLevel = roomLevel;
		this.sfsgroupId = sfsgroupId;
		this.userCount = userCount;
		this.blindLevelConfigId = blindLevelConfigId;
		this.minChips = minChips;
		this.maxChips = maxChips;
		this.timeBank = timeBank;
		this.flushTime = flushTime;
		this.flushValue = flushValue;
		this.reconnectTime = reconnectTime;
		this.rakeValue = rakeValue;
		this.rakeRate = rakeRate;
		this.maxRake = maxRake;
		this.status = status;
		this.intervalTime = intervalTime;
		this.thinkTime = thinkTime;
		this.createTime = createTime;
		this.remark = remark;
		this.managerName = managerName;
		this.operatedTime = operatedTime;
	}
	
	public Roomgroups(Roomgroups roomgroups, Double smallBlind, Double bigBlind, Roomlevel roomleves) {
		this.roomGroupId = roomgroups.getRoomGroupId();
		this.groupType = roomgroups.getGroupType();
		this.roomLevel = roomgroups.getRoomLevel();
		this.sfsgroupId = roomgroups.getSfsgroupId();
		this.userCount = roomgroups.getUserCount();
		this.blindLevelConfigId = roomgroups.getBlindLevelConfigId();
		this.minChips = roomgroups.getMinChips();
		this.maxChips = roomgroups.getMaxChips();
		this.timeBank = roomgroups.getTimeBank();
		this.flushTime = roomgroups.getFlushTime();
		this.flushValue = roomgroups.getFlushValue();
		this.reconnectTime = roomgroups.getReconnectTime();
		this.rakeValue = roomgroups.getRakeValue();
		this.rakeRate = roomgroups.getRakeRate();
		this.maxRake = roomgroups.getMaxRake();
		this.status = roomgroups.getStatus();
		this.intervalTime = roomgroups.getIntervalTime();
		this.thinkTime = roomgroups.getThinkTime();
		this.createTime = roomgroups.getCreateTime();
		this.remark = roomgroups.getRemark();
		this.managerName = roomgroups.getManagerName();
		this.operatedTime = roomgroups.getOperatedTime();
		this.smallBlind = smallBlind;
		this.bigBlind = bigBlind;
		this.roomLevels = roomleves;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "RoomGroupID", unique = true, nullable = false)
	public Integer getRoomGroupId() {
		return this.roomGroupId;
	}

	public void setRoomGroupId(Integer roomGroupId) {
		this.roomGroupId = roomGroupId;
	}

	@Column(name = "GroupType", nullable = false)
	public Short getGroupType() {
		return this.groupType;
	}

	public void setGroupType(Short groupType) {
		this.groupType = groupType;
	}

	@Column(name = "RoomLevel", nullable = false)
	public Short getRoomLevel() {
		return this.roomLevel;
	}

	public void setRoomLevel(Short roomLevel) {
		this.roomLevel = roomLevel;
	}

	@Column(name = "SFSGroupID", unique = true, nullable = false, length = 20)
	public String getSfsgroupId() {
		return this.sfsgroupId;
	}

	public void setSfsgroupId(String sfsgroupId) {
		this.sfsgroupId = sfsgroupId;
	}

	@Column(name = "UserCount", nullable = false)
	public Integer getUserCount() {
		return this.userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	@Column(name = "BlindLevelConfigId", nullable = false)
	public Integer getBlindLevelConfigId() {
		return this.blindLevelConfigId;
	}

	public void setBlindLevelConfigId(Integer blindLevelConfigId) {
		this.blindLevelConfigId = blindLevelConfigId;
	}

	@Column(name = "MinChips", nullable = false, scale = 4)
	public Double getMinChips() {
		return this.minChips;
	}

	public void setMinChips(Double minChips) {
		this.minChips = minChips;
	}

	@Column(name = "MaxChips", nullable = false, scale = 4)
	public Double getMaxChips() {
		return this.maxChips;
	}

	public void setMaxChips(Double maxChips) {
		this.maxChips = maxChips;
	}

	@Column(name = "TimeBank", nullable = false)
	public Integer getTimeBank() {
		return this.timeBank;
	}

	public void setTimeBank(Integer timeBank) {
		this.timeBank = timeBank;
	}

	@Column(name = "FlushTime", nullable = false)
	public Integer getFlushTime() {
		return this.flushTime;
	}

	public void setFlushTime(Integer flushTime) {
		this.flushTime = flushTime;
	}

	@Column(name = "FlushValue", nullable = false)
	public Integer getFlushValue() {
		return this.flushValue;
	}

	public void setFlushValue(Integer flushValue) {
		this.flushValue = flushValue;
	}

	@Column(name = "ReconnectTime", nullable = false)
	public Integer getReconnectTime() {
		return this.reconnectTime;
	}

	public void setReconnectTime(Integer reconnectTime) {
		this.reconnectTime = reconnectTime;
	}

	@Column(name = "RakeValue", nullable = false, scale = 4)
	public Double getRakeValue() {
		return this.rakeValue;
	}

	public void setRakeValue(Double rakeValue) {
		this.rakeValue = rakeValue;
	}

	@Column(name = "RakeRate", nullable = false, scale = 4)
	public Double getRakeRate() {
		return this.rakeRate;
	}

	public void setRakeRate(Double rakeRate) {
		this.rakeRate = rakeRate;
	}

	@Column(name = "MaxRake", nullable = false, length = 100)
	public String getMaxRake() {
		return this.maxRake;
	}

	public void setMaxRake(String maxRake) {
		this.maxRake = maxRake;
	}

	@Column(name = "Status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "IntervalTime", nullable = false)
	public Integer getIntervalTime() {
		return this.intervalTime;
	}

	public void setIntervalTime(Integer intervalTime) {
		this.intervalTime = intervalTime;
	}

	@Column(name = "ThinkTime", nullable = false)
	public Integer getThinkTime() {
		return this.thinkTime;
	}

	public void setThinkTime(Integer thinkTime) {
		this.thinkTime = thinkTime;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "Remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "ManagerName", length = 50)
	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Column(name = "OperatedTime", length = 19)
	public Timestamp getOperatedTime() {
		return this.operatedTime;
	}

	public void setOperatedTime(Timestamp operatedTime) {
		this.operatedTime = operatedTime;
	}
	
	@Transient
	public String getLevelName() {
	    return this.smallBlind + "/" + this.bigBlind + "(" + this.userCount + "人)";
	}

	public void setLevelName(String levelName) {
	    this.levelName = this.smallBlind + "/" + this.bigBlind;
	}

	@Transient
	public Integer getIminChips() {
		return iminChips;
	}

	public void setIminChips(Integer iminChips) {
		this.iminChips = iminChips;
	}

	@Transient
	public Integer getImaxChips() {
		return imaxChips;
	}

	public void setImaxChips(Integer imaxChips) {
		this.imaxChips = imaxChips;
	}

	@Transient
	public Double getSmallBlind() {
		return smallBlind;
	}

	public void setSmallBlind(Double smallBlind) {
		this.smallBlind = smallBlind;
	}

	@Transient
	public Double getBigBlind() {
		return bigBlind;
	}

	public void setBigBlind(Double bigBlind) {
		this.bigBlind = bigBlind;
	}
	
	@Transient
	public Roomlevel getRoomLevels() {
		return roomLevels;
	}
	
	public void setRoomLevels(Roomlevel roomLevels) {
		this.roomLevels = roomLevels;
	}
	
}