package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GoldExchipsLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gold_exchips_log")
public class GoldExchipsLog extends BaseEntity implements java.io.Serializable {

	/**
	 * 摇奖
	 */
	public static final Short TYPE_ERNIE = 1;
	
	
	// Fields

	private Integer id;
	private Long fbId;
	private Short type;
	private Integer goldValue;
	private Double chips;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public GoldExchipsLog() {
	}

	/** full constructor */
	public GoldExchipsLog(Long fbId, Short type, Integer goldValue,
			Double chips, Timestamp createTime) {
		this.fbId = fbId;
		this.type = type;
		this.goldValue = goldValue;
		this.chips = chips;
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

	@Column(name = "Type", nullable = false)
	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	@Column(name = "GoldValue", nullable = false)
	public Integer getGoldValue() {
		return this.goldValue;
	}

	public void setGoldValue(Integer goldValue) {
		this.goldValue = goldValue;
	}

	@Column(name = "Chips", nullable = false, scale = 4)
	public Double getChips() {
		return this.chips;
	}

	public void setChips(Double chips) {
		this.chips = chips;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}