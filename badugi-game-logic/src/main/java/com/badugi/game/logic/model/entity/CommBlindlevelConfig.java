package com.badugi.game.logic.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CommBlindlevelConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comm_blindlevel_config")
public class CommBlindlevelConfig extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer blindLevel;
	private Double smallBlind;
	private Double bigBlind;

	// Constructors

	/** default constructor */
	public CommBlindlevelConfig() {
	}

	/** full constructor */
	public CommBlindlevelConfig(Integer blindLevel, Double smallBlind,
			Double bigBlind) {
		this.blindLevel = blindLevel;
		this.smallBlind = smallBlind;
		this.bigBlind = bigBlind;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "BlindLevel")
	public Integer getBlindLevel() {
		return this.blindLevel;
	}

	public void setBlindLevel(Integer blindLevel) {
		this.blindLevel = blindLevel;
	}

	@Column(name = "SmallBlind", precision = 10, scale = 4)
	public Double getSmallBlind() {
		return this.smallBlind;
	}

	public void setSmallBlind(Double smallBlind) {
		this.smallBlind = smallBlind;
	}

	@Column(name = "BigBlind", precision = 10, scale = 4)
	public Double getBigBlind() {
		return this.bigBlind;
	}

	public void setBigBlind(Double bigBlind) {
		this.bigBlind = bigBlind;
	}

}