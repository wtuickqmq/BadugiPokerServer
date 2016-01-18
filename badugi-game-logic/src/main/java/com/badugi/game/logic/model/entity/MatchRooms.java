package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MatchRooms entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "match_rooms")
public class MatchRooms extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer roomId;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public MatchRooms() {
	}

	/** full constructor */
	public MatchRooms(Timestamp createTime) {
		this.createTime = createTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "RoomID", unique = true, nullable = false)
	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	@Column(name = "CreateTime", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}