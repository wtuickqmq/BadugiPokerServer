package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ExpvalueLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "expvalue_log")
public class ExpvalueLog extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Long fbId;
	private String logType;
	private Double expValue;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public ExpvalueLog() {
	}

	/** full constructor */
	public ExpvalueLog(Long fbId, String logType, Double expValue,
			Timestamp createTime) {
		this.fbId = fbId;
		this.logType = logType;
		this.expValue = expValue;
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

	@Column(name = "LogType", nullable = false, length = 100)
	public String getLogType() {
		return this.logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	@Column(name = "ExpValue", nullable = false, scale = 4)
	public Double getExpValue() {
		return this.expValue;
	}

	public void setExpValue(Double expValue) {
		this.expValue = expValue;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}