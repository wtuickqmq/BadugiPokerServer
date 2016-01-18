package com.badugi.game.logic.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserPlayInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_play_info")
public class UserPlayInfo implements java.io.Serializable {

	// Fields

	private Long fbId;
	private Integer playCount = 0;
	private Integer winCount = 0;

	// Constructors

	/** default constructor */
	public UserPlayInfo() {
	}

	/** full constructor */
	public UserPlayInfo(Long fbId, Integer playCount, Integer winCount) {
		this.fbId = fbId;
		this.playCount = playCount;
		this.winCount = winCount;
	}

	// Property accessors
	@Id
	@Column(name = "FbId", unique = true, nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "PlayCount", nullable = false)
	public Integer getPlayCount() {
		return this.playCount;
	}

	public void setPlayCount(Integer playCount) {
		this.playCount = playCount;
	}

	@Column(name = "WinCount", nullable = false)
	public Integer getWinCount() {
		return this.winCount;
	}

	public void setWinCount(Integer winCount) {
		this.winCount = winCount;
	}

}