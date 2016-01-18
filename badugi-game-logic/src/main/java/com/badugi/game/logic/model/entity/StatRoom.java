package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * StatRoom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "stat_room")
public class StatRoom extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer roomUserCount;
	private Double smallBlind;
	private Double bigBlind;
	private Integer roomCount;
	private Integer userCount;
	private Integer cuidcount;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public StatRoom() {
	}

	/** full constructor */
	public StatRoom(Integer roomUserCount, Double smallBlind, Double bigBlind,
			Integer roomCount, Integer userCount, Integer cuidcount,
			Timestamp createTime) {
		this.roomUserCount = roomUserCount;
		this.smallBlind = smallBlind;
		this.bigBlind = bigBlind;
		this.roomCount = roomCount;
		this.userCount = userCount;
		this.cuidcount = cuidcount;
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

	@Column(name = "RoomUserCount", nullable = false)
	public Integer getRoomUserCount() {
		return this.roomUserCount;
	}

	public void setRoomUserCount(Integer roomUserCount) {
		this.roomUserCount = roomUserCount;
	}

	@Column(name = "SmallBlind", nullable = false, scale = 4)
	public Double getSmallBlind() {
		return this.smallBlind;
	}

	public void setSmallBlind(Double smallBlind) {
		this.smallBlind = smallBlind;
	}

	@Column(name = "BigBlind", nullable = false, scale = 4)
	public Double getBigBlind() {
		return this.bigBlind;
	}

	public void setBigBlind(Double bigBlind) {
		this.bigBlind = bigBlind;
	}

	@Column(name = "RoomCount", nullable = false)
	public Integer getRoomCount() {
		return this.roomCount;
	}

	public void setRoomCount(Integer roomCount) {
		this.roomCount = roomCount;
	}

	@Column(name = "UserCount", nullable = false)
	public Integer getUserCount() {
		return this.userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	@Column(name = "CUIDCount", nullable = false)
	public Integer getCuidcount() {
		return this.cuidcount;
	}

	public void setCuidcount(Integer cuidcount) {
		this.cuidcount = cuidcount;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}