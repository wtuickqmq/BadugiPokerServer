package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FreechipsTaskLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "freechips_task_log")
public class FreechipsTaskLog extends BaseEntity implements java.io.Serializable {

	/**
	 * 是否已领取奖品1:是0：否
	 */
	public static final Short ISGET_TRUE = 1;
	
	/**
	 * 是否已领取奖品1:是0：否
	 */
	public static final Short ISGET_FALSE = 0;
	
	
	// Fields

	private Integer id;
	private Long fbId;
	private Integer taskId;
	private Short isGetChips;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public FreechipsTaskLog() {
	}

	/** full constructor */
	public FreechipsTaskLog(Long fbId, Integer taskId, Short isGetChips,
			Timestamp createTime) {
		this.fbId = fbId;
		this.taskId = taskId;
		this.isGetChips = isGetChips;
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

	@Column(name = "TaskId", nullable = false)
	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	@Column(name = "IsGetChips", nullable = false)
	public Short getIsGetChips() {
		return this.isGetChips;
	}

	public void setIsGetChips(Short isGetChips) {
		this.isGetChips = isGetChips;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}