package com.badugi.game.logic.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TaskCategory1 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "task_category1")
public class TaskCategory1 extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer cateId1;
	private String cateName;
	private String reward;

	// Constructors

	/** default constructor */
	public TaskCategory1() {
	}

	/** full constructor */
	public TaskCategory1(String cateName, String reward) {
		this.cateName = cateName;
		this.reward = reward;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CateId1", unique = true, nullable = false)
	public Integer getCateId1() {
		return this.cateId1;
	}

	public void setCateId1(Integer cateId1) {
		this.cateId1 = cateId1;
	}

	@Column(name = "CateName", length = 50)
	public String getCateName() {
		return this.cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	@Column(name = "Reward")
	public String getReward() {
		return reward;
	}
	
	public void setReward(String reward) {
		this.reward = reward;
	}

}