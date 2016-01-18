package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SigleTaskLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sigle_task_log")
public class SigleTaskLog extends BaseEntity implements java.io.Serializable {

	/**
	 * 是否完成1:是0：否
	 */
	public static final Short FINAL_TRUE = 1;
	
	/**
	 * 是否完成1:是0：否
	 */
	public static final Short FINAL_FALSE = 0;
	
	
	// Fields

	private Integer id;
	private Long fbid;
	private Integer taskId;
	private Integer requireNum1;
	private Integer gameCount;
	private Integer requireNum2;
	private Integer winGameCount;
	private Short isFinal;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public SigleTaskLog() {
	}

	/** minimal constructor */
	public SigleTaskLog(Long fbid, Integer taskId) {
		this.fbid = fbid;
		this.taskId = taskId;
	}

	public SigleTaskLog(Integer taskId, Integer requireNum1,
			Integer gameCount, Integer requireNum2, Integer winGameCount) {
		super();
		this.taskId = taskId;
		this.requireNum1 = requireNum1;
		this.gameCount = gameCount;
		this.requireNum2 = requireNum2;
		this.winGameCount = winGameCount;
	}

	/** full constructor */
	public SigleTaskLog(Long fbid, Integer taskId, Integer requireNum1,
			Integer gameCount, Integer requireNum2, Integer winGameCount,
			Timestamp createTime) {
		super();
		this.fbid = fbid;
		this.taskId = taskId;
		this.requireNum1 = requireNum1;
		this.gameCount = gameCount;
		this.requireNum2 = requireNum2;
		this.winGameCount = winGameCount;
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

	@Column(name = "Fbid", nullable = false)
	public Long getFbid() {
		return this.fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}

	@Column(name = "TaskId", nullable = false)
	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	
	@Column(name = "RequireNum1", nullable = false)
	public Integer getRequireNum1() {
		return requireNum1;
	}
	
	public void setRequireNum1(Integer requireNum1) {
		this.requireNum1 = requireNum1;
	}

	@Column(name = "GameCount", nullable = false)
	public Integer getGameCount() {
		return this.gameCount;
	}

	public void setGameCount(Integer gameCount) {
		this.gameCount = gameCount;
	}

	@Column(name = "RequireNum2", nullable = false)
	public Integer getRequireNum2() {
		return requireNum2;
	}
	
	public void setRequireNum2(Integer requireNum2) {
		this.requireNum2 = requireNum2;
	}
	
	@Column(name = "WinGameCount", nullable = false)
	public Integer getWinGameCount() {
		return winGameCount;
	}
	
	public void setWinGameCount(Integer winGameCount) {
		this.winGameCount = winGameCount;
	}
	
	@Column(name = "IsFinal")
	public Short getIsFinal() {
		return this.isFinal;
	}

	public void setIsFinal(Short isFinal) {
		this.isFinal = isFinal;
	}

	@Column(name = "CreateTime", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}