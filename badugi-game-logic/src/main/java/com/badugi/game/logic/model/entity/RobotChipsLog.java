package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RobotChipsLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "robot_chips_log")
public class RobotChipsLog extends BaseEntity implements java.io.Serializable {

	/**
	 * 后台
	 */
	public static final Short TYPE_MANAGER = 1;
	// Fields

	private Integer id;
	private Long fbId;
	private Double chips;
	private Short type;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public RobotChipsLog() {
	}

	/** full constructor */
	public RobotChipsLog(Long fbId, Double chips, Short type,
			Timestamp createTime) {
		this.fbId = fbId;
		this.chips = chips;
		this.type = type;
		this.createTime = createTime;
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

	@Column(name = "Type", nullable = false)
	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}