package com.badugi.game.logic.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CfgVipLevel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cfg_vip_level")
public class CfgVipLevel extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Short vipLevel;
	private String vipLevelName;
	private Double vipValue;
	private Double expValueTimes;
	private Integer period;
	private Double keepVipValue;

	// Constructors

	/** default constructor */
	public CfgVipLevel() {
	}

	/** minimal constructor */
	public CfgVipLevel(Short vipLevel, Double vipValue, Double expValueTimes,
			Integer period, Double keepVipValue) {
		this.vipLevel = vipLevel;
		this.vipValue = vipValue;
		this.expValueTimes = expValueTimes;
		this.period = period;
		this.keepVipValue = keepVipValue;
	}

	/** full constructor */
	public CfgVipLevel(Short vipLevel, String vipLevelName, Double vipValue,
			Double expValueTimes, Integer period, Double keepVipValue) {
		this.vipLevel = vipLevel;
		this.vipLevelName = vipLevelName;
		this.vipValue = vipValue;
		this.expValueTimes = expValueTimes;
		this.period = period;
		this.keepVipValue = keepVipValue;
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

	@Column(name = "VipLevel", nullable = false)
	public Short getVipLevel() {
		return this.vipLevel;
	}

	public void setVipLevel(Short vipLevel) {
		this.vipLevel = vipLevel;
	}

	@Column(name = "VipLevelName", length = 50)
	public String getVipLevelName() {
		return this.vipLevelName;
	}

	public void setVipLevelName(String vipLevelName) {
		this.vipLevelName = vipLevelName;
	}

	@Column(name = "VipValue", nullable = false, scale = 4)
	public Double getVipValue() {
		return this.vipValue;
	}

	public void setVipValue(Double vipValue) {
		this.vipValue = vipValue;
	}

	@Column(name = "ExpValueTimes", nullable = false, scale = 4)
	public Double getExpValueTimes() {
		return this.expValueTimes;
	}

	public void setExpValueTimes(Double expValueTimes) {
		this.expValueTimes = expValueTimes;
	}

	@Column(name = "Period", nullable = false)
	public Integer getPeriod() {
		return this.period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	@Column(name = "KeepVipValue", nullable = false, scale = 4)
	public Double getKeepVipValue() {
		return this.keepVipValue;
	}

	public void setKeepVipValue(Double keepVipValue) {
		this.keepVipValue = keepVipValue;
	}

}