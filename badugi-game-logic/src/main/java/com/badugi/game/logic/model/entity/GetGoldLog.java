package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GetGoldLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "get_gold_log")
public class GetGoldLog extends BaseEntity implements java.io.Serializable {

	/**
	 * 比赛
	 */
	public static final Short GETTYPE_MATCH = 0;
	/**
	 * 彩蛋
	 */
	public static final Short GETTYPE_PEGG = 1;
	/**
	 * 新手任务
	 */
	public static final Short GETTYPE_NEWTASK = 2;
	/**
	 * 每日任务
	 */
	public static final Short GETTYPE_TODAYASK = 3;
	
	/**
	 * 新版邀请
	 */
	public static final Short GETTYPE_NEWINVITE = 4;
	
	/**
	 * 免费筹码任务 
	 */
	public static final Short GETTYPE_FREECHTASK = 6;
	
	/**
	 * 场任务
	 */
	public static final Short GETTYPE_ROOMTASK = 7;

	/**
	 * 新等级
	 */
	public static final Short GETTYPE_LEVEL_ADD = 8;
	
	
	// Fields

	private Integer id;
	private Long fbId;
	private Integer goldValue;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public GetGoldLog() {
	}

	/** full constructor */
	public GetGoldLog(Long fbId, Integer goldValue, Timestamp createTime) {
		this.fbId = fbId;
		this.goldValue = goldValue;
		this.createTime = createTime;
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

	@Column(name = "FbId", nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "GoldValue", nullable = false)
	public Integer getGoldValue() {
		return this.goldValue;
	}

	public void setGoldValue(Integer goldValue) {
		this.goldValue = goldValue;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}