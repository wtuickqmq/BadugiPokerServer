package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * StatOnline entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "stat_online")
public class StatOnline extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer onlineUserCount;
	private Integer lobbyUserCount;
	private Integer roomUserCount;
	private Integer roomCount;
	private Integer waitUserCount;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public StatOnline() {
	}

	/** full constructor */
	public StatOnline(Integer onlineUserCount, Integer lobbyUserCount,
			Integer roomUserCount, Integer roomCount, Integer waitUserCount,
			Timestamp createTime) {
		this.onlineUserCount = onlineUserCount;
		this.lobbyUserCount = lobbyUserCount;
		this.roomUserCount = roomUserCount;
		this.roomCount = roomCount;
		this.waitUserCount = waitUserCount;
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

	@Column(name = "OnlineUserCount", nullable = false)
	public Integer getOnlineUserCount() {
		return this.onlineUserCount;
	}

	public void setOnlineUserCount(Integer onlineUserCount) {
		this.onlineUserCount = onlineUserCount;
	}

	@Column(name = "LobbyUserCount", nullable = false)
	public Integer getLobbyUserCount() {
		return this.lobbyUserCount;
	}

	public void setLobbyUserCount(Integer lobbyUserCount) {
		this.lobbyUserCount = lobbyUserCount;
	}

	@Column(name = "RoomUserCount", nullable = false)
	public Integer getRoomUserCount() {
		return this.roomUserCount;
	}

	public void setRoomUserCount(Integer roomUserCount) {
		this.roomUserCount = roomUserCount;
	}

	@Column(name = "RoomCount", nullable = false)
	public Integer getRoomCount() {
		return this.roomCount;
	}

	public void setRoomCount(Integer roomCount) {
		this.roomCount = roomCount;
	}

	@Column(name = "WaitUserCount", nullable = false)
	public Integer getWaitUserCount() {
		return this.waitUserCount;
	}

	public void setWaitUserCount(Integer waitUserCount) {
		this.waitUserCount = waitUserCount;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}