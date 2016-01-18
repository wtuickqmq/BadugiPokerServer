package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ViplevelLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "viplevel_log")
public class ViplevelLog extends BaseEntity implements java.io.Serializable {

	// Fields

	private Long id;
	private Long fbId;
	private Short vipLevel;
	private Short newVipLevel;
	private Short changeType;
	private Double currVipValue;
	private Timestamp lastVipTime;
	private Timestamp vipStartTime;

	// Constructors

	/** default constructor */
	public ViplevelLog() {
	}

	/** full constructor */
	public ViplevelLog(Long fbId, Short vipLevel, Short newVipLevel,
			Short changeType, Double currVipValue, Timestamp lastVipTime,
			Timestamp vipStartTime) {
		this.fbId = fbId;
		this.vipLevel = vipLevel;
		this.newVipLevel = newVipLevel;
		this.changeType = changeType;
		this.currVipValue = currVipValue;
		this.lastVipTime = lastVipTime;
		this.vipStartTime = vipStartTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "FbId", nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "VipLevel", nullable = false)
	public Short getVipLevel() {
		return this.vipLevel;
	}

	public void setVipLevel(Short vipLevel) {
		this.vipLevel = vipLevel;
	}

	@Column(name = "NewVipLevel", nullable = false)
	public Short getNewVipLevel() {
		return this.newVipLevel;
	}

	public void setNewVipLevel(Short newVipLevel) {
		this.newVipLevel = newVipLevel;
	}

	@Column(name = "ChangeType", nullable = false)
	public Short getChangeType() {
		return this.changeType;
	}

	public void setChangeType(Short changeType) {
		this.changeType = changeType;
	}

	@Column(name = "CurrVipValue", nullable = false, scale = 4)
	public Double getCurrVipValue() {
		return this.currVipValue;
	}

	public void setCurrVipValue(Double currVipValue) {
		this.currVipValue = currVipValue;
	}

	@Column(name = "LastVipTime", nullable = false, length = 19)
	public Timestamp getLastVipTime() {
		return this.lastVipTime;
	}

	public void setLastVipTime(Timestamp lastVipTime) {
		this.lastVipTime = lastVipTime;
	}

	@Column(name = "VipStartTime", nullable = false, length = 19)
	public Timestamp getVipStartTime() {
		return this.vipStartTime;
	}

	public void setVipStartTime(Timestamp vipStartTime) {
		this.vipStartTime = vipStartTime;
	}

}