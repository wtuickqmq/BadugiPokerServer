package com.badugi.game.logic.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FreechipsTask entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "freechips_task")
public class FreechipsTask extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private String taskName;
	private Short type;
	private String reward;
	private Integer index;
	private String remark;

	// Constructors

	/** default constructor */
	public FreechipsTask() {
	}

	/** minimal constructor */
	public FreechipsTask(Short type, Integer index) {
		this.type = type;
		this.index = index;
	}

	/** full constructor */
	public FreechipsTask(String taskName, Short type, String reward,
			Integer index, String remark) {
		this.taskName = taskName;
		this.type = type;
		this.reward = reward;
		this.index = index;
		this.remark = remark;
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

	@Column(name = "TaskName", length = 50)
	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Column(name = "Type", nullable = false)
	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	@Column(name = "Reward")
	public String getReward() {
		return this.reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	@Column(name = "Index", nullable = false)
	public Integer getIndex() {
		return this.index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	@Column(name = "Remark", length = 50)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}