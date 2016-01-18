package com.badugi.game.logic.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserSetting entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_setting")
public class UserSetting extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Long fbId;
	private Integer settingType;
	private Integer settingValue;

	// Constructors

	/** default constructor */
	public UserSetting() {
	}

	/** full constructor */
	public UserSetting(Long fbId, Integer settingType, Integer settingValue) {
		this.fbId = fbId;
		this.settingType = settingType;
		this.settingValue = settingValue;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "FbId", nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "SettingType", nullable = false)
	public Integer getSettingType() {
		return this.settingType;
	}

	public void setSettingType(Integer settingType) {
		this.settingType = settingType;
	}

	@Column(name = "SettingValue", nullable = false)
	public Integer getSettingValue() {
		return this.settingValue;
	}

	public void setSettingValue(Integer settingValue) {
		this.settingValue = settingValue;
	}

}