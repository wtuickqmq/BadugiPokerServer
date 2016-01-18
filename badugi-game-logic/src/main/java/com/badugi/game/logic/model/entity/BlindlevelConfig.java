package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BlindlevelConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "blindlevel_config")
public class BlindlevelConfig extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Short blindTypeId;
	private Short blindLevel;
	private Double smallBlind;
	private Double bigBlind;
	private Double ante;
	private String managerName;
	private Timestamp operatedTime;

	// Constructors

	/** default constructor */
	public BlindlevelConfig() {
	}

	/** minimal constructor */
	public BlindlevelConfig(Short blindTypeId, Short blindLevel) {
		this.blindTypeId = blindTypeId;
		this.blindLevel = blindLevel;
	}

	/** full constructor */
	public BlindlevelConfig(Short blindTypeId, Short blindLevel,
			Double smallBlind, Double bigBlind, Double ante,
			String managerName, Timestamp operatedTime) {
		this.blindTypeId = blindTypeId;
		this.blindLevel = blindLevel;
		this.smallBlind = smallBlind;
		this.bigBlind = bigBlind;
		this.ante = ante;
		this.managerName = managerName;
		this.operatedTime = operatedTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "BlindTypeId", nullable = false)
	public Short getBlindTypeId() {
		return this.blindTypeId;
	}

	public void setBlindTypeId(Short blindTypeId) {
		this.blindTypeId = blindTypeId;
	}

	@Column(name = "BlindLevel", nullable = false)
	public Short getBlindLevel() {
		return this.blindLevel;
	}

	public void setBlindLevel(Short blindLevel) {
		this.blindLevel = blindLevel;
	}

	@Column(name = "SmallBlind", scale = 4)
	public Double getSmallBlind() {
		return this.smallBlind;
	}

	public void setSmallBlind(Double smallBlind) {
		this.smallBlind = smallBlind;
	}

	@Column(name = "BigBlind", scale = 4)
	public Double getBigBlind() {
		return this.bigBlind;
	}

	public void setBigBlind(Double bigBlind) {
		this.bigBlind = bigBlind;
	}

	@Column(name = "Ante", scale = 4)
	public Double getAnte() {
		return this.ante;
	}

	public void setAnte(Double ante) {
		this.ante = ante;
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

}