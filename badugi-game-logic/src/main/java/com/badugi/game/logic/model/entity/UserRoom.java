package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * UserRoom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_room", uniqueConstraints = @UniqueConstraint(columnNames = {
		"FbId", "RoomID" }))
public class UserRoom extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Long fbId;
	private Integer roomId;
	private Integer roundId;
	private Timestamp enterTime;

	// Constructors

	/** default constructor */
	public UserRoom() {
	}

	/** full constructor */
	public UserRoom(Long fbId, Integer roomId, Integer roundId,
			Timestamp enterTime) {
		this.fbId = fbId;
		this.roomId = roomId;
		this.roundId = roundId;
		this.enterTime = enterTime;
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

	@Column(name = "FbId", nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "RoomID", nullable = false)
	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	@Column(name = "RoundID", nullable = false)
	public Integer getRoundId() {
		return this.roundId;
	}

	public void setRoundId(Integer roundId) {
		this.roundId = roundId;
	}

	@Column(name = "EnterTime", nullable = false, length = 19)
	public Timestamp getEnterTime() {
		return this.enterTime;
	}

	public void setEnterTime(Timestamp enterTime) {
		this.enterTime = enterTime;
	}

}