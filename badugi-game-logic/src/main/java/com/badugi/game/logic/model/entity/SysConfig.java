package com.badugi.game.logic.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_config")
public class SysConfig extends BaseEntity implements java.io.Serializable {

	// Fields

	private String configKey;
	private String configValue;
	private String remark;

	// Constructors

	/** default constructor */
	public SysConfig() {
	}

	/** minimal constructor */
	public SysConfig(String configKey) {
		this.configKey = configKey;
	}

	/** full constructor */
	public SysConfig(String configKey, String configValue, String remark) {
		this.configKey = configKey;
		this.configValue = configValue;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@Column(name = "ConfigKey", unique = true, nullable = false, length = 200)
	public String getConfigKey() {
		return this.configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	@Column(name = "ConfigValue", length = 16777215)
	public String getConfigValue() {
		return this.configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	@Column(name = "Remark", length = 50)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}