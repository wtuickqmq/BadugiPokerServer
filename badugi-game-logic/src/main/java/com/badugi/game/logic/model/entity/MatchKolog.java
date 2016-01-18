package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MatchKolog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "match_kolog")
public class MatchKolog extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer matchId;
	private Long fbId;
	private Long koFbId;
	private Double reward;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public MatchKolog() {
	}

	/** minimal constructor */
	public MatchKolog(Integer matchId, Long fbId, Long koFbId, Double reward) {
		this.matchId = matchId;
		this.fbId = fbId;
		this.koFbId = koFbId;
		this.reward = reward;
	}

	/** full constructor */
	public MatchKolog(Integer matchId, Long fbId, Long koFbId, Double reward,
			Timestamp createTime) {
		this.matchId = matchId;
		this.fbId = fbId;
		this.koFbId = koFbId;
		this.reward = reward;
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

	@Column(name = "MatchId", nullable = false)
	public Integer getMatchId() {
		return this.matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	@Column(name = "FbId", nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "KoFbId", nullable = false)
	public Long getKoFbId() {
		return this.koFbId;
	}

	public void setKoFbId(Long koFbId) {
		this.koFbId = koFbId;
	}

	@Column(name = "Reward", nullable = false, scale = 4)
	public Double getReward() {
		return this.reward;
	}

	public void setReward(Double reward) {
		this.reward = reward;
	}

	@Column(name = "CreateTime", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}