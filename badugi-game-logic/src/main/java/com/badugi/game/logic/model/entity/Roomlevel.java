package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Roomlevel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "roomlevel")
public class Roomlevel extends BaseEntity implements java.io.Serializable {

	// Fields

	private Short roomLevel;
	private String levelName;
	private Short status;
	private String managerName;
	private Timestamp operatedTime;

	// Constructors

	/** default constructor */
	public Roomlevel() {
	}

	/** minimal constructor */
	public Roomlevel(Short roomLevel, Short status) {
		this.roomLevel = roomLevel;
		this.status = status;
	}

	/** full constructor */
	public Roomlevel(Short roomLevel, String levelName, Short status,
			String managerName, Timestamp operatedTime) {
		this.roomLevel = roomLevel;
		this.levelName = levelName;
		this.status = status;
		this.managerName = managerName;
		this.operatedTime = operatedTime;
	}

	// Property accessors
	@Id
	@Column(name = "RoomLevel", unique = true, nullable = false)
	public Short getRoomLevel() {
		return this.roomLevel;
	}

	public void setRoomLevel(Short roomLevel) {
		this.roomLevel = roomLevel;
	}

	@Column(name = "LevelName", length = 20)
	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	@Column(name = "Status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "ManagerName", length = 50)
	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Column(name = "OperatedTime", length = 19)
	public Timestamp getOperatedTime() {
		return this.operatedTime;
	}

	public void setOperatedTime(Timestamp operatedTime) {
		this.operatedTime = operatedTime;
	}

}