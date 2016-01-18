package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ServerStop entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "server_stop")
public class ServerStop extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Timestamp stopTime;
	private Timestamp startTime;
	private Integer gameBefore;
	private Integer matchBefore;
	private String remark;
	private Short status;
	private String manager;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public ServerStop() {
	}

	/** minimal constructor */
	public ServerStop(Timestamp stopTime, Timestamp startTime, String manager,
			Timestamp createTime) {
		this.stopTime = stopTime;
		this.startTime = startTime;
		this.manager = manager;
		this.createTime = createTime;
	}

	/** full constructor */
	public ServerStop(Timestamp stopTime, Timestamp startTime,
			Integer gameBefore, Integer matchBefore, String remark,
			Short status, String manager, Timestamp createTime) {
		super();
		this.stopTime = stopTime;
		this.startTime = startTime;
		this.gameBefore = gameBefore;
		this.matchBefore = matchBefore;
		this.remark = remark;
		this.status = status;
		this.manager = manager;
		this.createTime = createTime;
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

	@Column(name = "StopTime", nullable = false, length = 19)
	public Timestamp getStopTime() {
		return this.stopTime;
	}

	public void setStopTime(Timestamp stopTime) {
		this.stopTime = stopTime;
	}

	@Column(name = "StartTime", nullable = false, length = 19)
	public Timestamp getStartTime() {
		return this.startTime;
	}
	
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	
	@Column(name = "GameBefore")
	public Integer getGameBefore() {
		return gameBefore;
	}
	
	public void setGameBefore(Integer gameBefore) {
		this.gameBefore = gameBefore;
	}
	
	@Column(name = "MatchBefore")
	public Integer getMatchBefore() {
		return matchBefore;
	}
	
	public void setMatchBefore(Integer matchBefore) {
		this.matchBefore = matchBefore;
	}

	@Column(name = "Remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "Status")
	public Short getStatus() {
		return status;
	}
	
	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "Manager", nullable = false, length = 50)
	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
	
	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}