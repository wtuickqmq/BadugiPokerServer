package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GetMasterLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "get_master_log")
public class GetMasterLog extends BaseEntity implements java.io.Serializable {

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
	 * 免费筹码任务 
	 */
	public static final Short GETTYPE_FREECHTASK = 10;
	
	/**
	 * 场任务
	 */
	public static final Short GETTYPE_ROOMTASK = 11;
	
	
	// Fields

	private Integer id;
	private Long fbId;
	private Short getType;
	private Integer masterValue;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public GetMasterLog() {
	}

	/** minimal constructor */
	public GetMasterLog(Long fbId, Integer masterValue, Timestamp createTime) {
		this.fbId = fbId;
		this.masterValue = masterValue;
		this.createTime = createTime;
	}

	/** full constructor */
	public GetMasterLog(Long fbId, Short getType, Integer masterValue,
			Timestamp createTime) {
		this.fbId = fbId;
		this.getType = getType;
		this.masterValue = masterValue;
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

	@Column(name = "GetType")
	public Short getGetType() {
		return this.getType;
	}

	public void setGetType(Short getType) {
		this.getType = getType;
	}

	@Column(name = "MasterValue", nullable = false)
	public Integer getMasterValue() {
		return this.masterValue;
	}

	public void setMasterValue(Integer masterValue) {
		this.masterValue = masterValue;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}