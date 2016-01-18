package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "activityuser_attstat")
public class ActivityuserAttstat extends BaseEntity implements java.io.Serializable {
	// `userId` bigint(20) NOT NULL,
	// `lastLoginDays` int(11) DEFAULT NULL COMMENT '跟连续登录天数有别，用于活动 如连续领取(天数)',
	// `createTime` datetime DEFAULT NULL,

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userId;
	private Integer lastLoginDays;
	private Timestamp createTime;

	public ActivityuserAttstat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ActivityuserAttstat(Long userId, Integer lastLoginDays, Timestamp createTime) {
		super();
		this.userId = userId;
		this.lastLoginDays = lastLoginDays;
		this.createTime = createTime;
	}
	@Id
	@Column(name = "userId", unique = true, nullable = false)
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Column(name = "lastLoginDays")
	public Integer getLastLoginDays() {
		return lastLoginDays;
	}
	public void setLastLoginDays(Integer lastLoginDays) {
		this.lastLoginDays = lastLoginDays;
	}

	@Column(name = "createTime")
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}