package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PresentChips entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "present_chips")
public class PresentChips extends BaseEntity implements java.io.Serializable {

	/**
	 * 首次进入:0
	 */
	public static final Short GETTYPE_FIRSTGET = 0;
	/**
	 * 用完即送:1
	 */
	public static final Short GETTYPE_UPGET = 1;
	
	
	// Fields

	private Integer id;
	private Long fbId;
	private Double chips;
	private Short getType;
	private Timestamp presentTime;

	// Constructors

	/** default constructor */
	public PresentChips() {
	}

	/** full constructor */
	public PresentChips(Long fbId, Double chips, Short getType,
			Timestamp presentTime) {
		this.fbId = fbId;
		this.chips = chips;
		this.getType = getType;
		this.presentTime = presentTime;
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

	@Column(name = "FbId", nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "Chips", nullable = false, scale = 4)
	public Double getChips() {
		return this.chips;
	}

	public void setChips(Double chips) {
		this.chips = chips;
	}

	@Column(name = "GetType", nullable = false)
	public Short getGetType() {
		return this.getType;
	}

	public void setGetType(Short getType) {
		this.getType = getType;
	}

	@Column(name = "PresentTime", nullable = false, length = 19)
	public Timestamp getPresentTime() {
		return this.presentTime;
	}

	public void setPresentTime(Timestamp presentTime) {
		this.presentTime = presentTime;
	}

}