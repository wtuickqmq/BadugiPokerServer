package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserOnline entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_info")
public class UserInfo extends BaseEntity implements java.io.Serializable {

	// Fields

	private Long fbId;
	private Integer popRelaWinCount;
	private Integer popWinCount;
	private Timestamp popWinDayTime;

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	

	public UserInfo(Long fbId, Integer popRelaWinCount) {
		super();
		this.fbId = fbId;
		this.popRelaWinCount = popRelaWinCount;
	}



	// Property accessors
	@Id
	@Column(name = "FbId", unique = true, nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}


	@Column(name = "PopRelaWinCount")
	public Integer getPopRelaWinCount() {
		return popRelaWinCount;
	}



	public void setPopRelaWinCount(Integer popRelaWinCount) {
		this.popRelaWinCount = popRelaWinCount;
	}


	@Column(name = "PopWinCount")
	public Integer getPopWinCount() {
		return popWinCount;
	}



	public void setPopWinCount(Integer popWinCount) {
		this.popWinCount = popWinCount;
	}


	@Column(name = "PopWinDayTime")
	public Timestamp getPopWinDayTime() {
		return popWinDayTime;
	}



	public void setPopWinDayTime(Timestamp popWinDayTime) {
		this.popWinDayTime = popWinDayTime;
	}



}