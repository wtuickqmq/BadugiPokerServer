package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BlindIncreaseConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "blind_increase_config")
public class BlindIncreaseConfig extends BaseEntity implements java.io.Serializable {

	// Fields

	private Short blindIncCfgId;
	private String cfgName;
	private Integer cfgSpeed;
	private String managerName;
	private Timestamp operatedTime;
	private Short language;

	// Constructors

	/** default constructor */
	public BlindIncreaseConfig() {
	}

	/** full constructor */
	public BlindIncreaseConfig(String cfgName, Integer cfgSpeed,
			String managerName, Timestamp operatedTime, Short language) {
		this.cfgName = cfgName;
		this.cfgSpeed = cfgSpeed;
		this.managerName = managerName;
		this.operatedTime = operatedTime;
		this.language = language;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BlindIncCfgId", unique = true, nullable = false)
	public Short getBlindIncCfgId() {
		return this.blindIncCfgId;
	}

	public void setBlindIncCfgId(Short blindIncCfgId) {
		this.blindIncCfgId = blindIncCfgId;
	}

	@Column(name = "CfgName", length = 50)
	public String getCfgName() {
		return this.cfgName;
	}

	public void setCfgName(String cfgName) {
		this.cfgName = cfgName;
	}

	@Column(name = "CfgSpeed")
	public Integer getCfgSpeed() {
		return this.cfgSpeed;
	}

	public void setCfgSpeed(Integer cfgSpeed) {
		this.cfgSpeed = cfgSpeed;
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

	@Column(name = "Language")
	public Short getLanguage() {
		return this.language;
	}

	public void setLanguage(Short language) {
		this.language = language;
	}

}