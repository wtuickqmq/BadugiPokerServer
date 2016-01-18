package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GenRoundid entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gen_roundid")
public class GenRoundid extends BaseEntity implements java.io.Serializable {

	// Fields

	private Long roundId;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public GenRoundid() {
	}

	/** full constructor */
	public GenRoundid(Timestamp createTime) {
		this.createTime = createTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "RoundID", unique = true, nullable = false)
	public Long getRoundId() {
		return this.roundId;
	}

	public void setRoundId(Long roundId) {
		this.roundId = roundId;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}