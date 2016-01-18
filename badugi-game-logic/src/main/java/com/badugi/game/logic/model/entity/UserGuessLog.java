package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserGuessLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_guess_log")
public class UserGuessLog extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Long fbId;
	private Integer guessId;
	private String winHand;
	private String guessHand;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public UserGuessLog() {
	}

	/** minimal constructor */
	public UserGuessLog(Long fbId, Integer guessId, Timestamp createTime) {
		this.fbId = fbId;
		this.guessId = guessId;
		this.createTime = createTime;
	}
	
	public UserGuessLog(Long fbId, Integer guessId, String winHand,
			Timestamp createTime) {
		this.fbId = fbId;
		this.guessId = guessId;
		this.winHand = winHand;
		this.createTime = createTime;
	}

	/** full constructor */
	public UserGuessLog(Long fbId, Integer guessId, String winHand,
			String guessHand, Timestamp createTime) {
		this.fbId = fbId;
		this.guessId = guessId;
		this.winHand = winHand;
		this.guessHand = guessHand;
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

	@Column(name = "GuessId", nullable = false)
	public Integer getGuessId() {
		return this.guessId;
	}

	public void setGuessId(Integer guessId) {
		this.guessId = guessId;
	}

	@Column(name = "WinHand", length = 20)
	public String getWinHand() {
		return this.winHand;
	}

	public void setWinHand(String winHand) {
		this.winHand = winHand;
	}

	@Column(name = "GuessHand", length = 20)
	public String getGuessHand() {
		return this.guessHand;
	}

	public void setGuessHand(String guessHand) {
		this.guessHand = guessHand;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}