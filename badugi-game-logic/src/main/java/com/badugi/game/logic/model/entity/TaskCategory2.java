package com.badugi.game.logic.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TaskCategory2 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "task_category2")
public class TaskCategory2 extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer cateId2;
	private String cateName;
	private Integer cateId1;
	private String remark;

	// Constructors

	/** default constructor */
	public TaskCategory2() {
	}

	/** minimal constructor */
	public TaskCategory2(Integer cateId1) {
		this.cateId1 = cateId1;
	}

	/** full constructor */
	public TaskCategory2(String cateName, Integer cateId1, String remark) {
		this.cateName = cateName;
		this.cateId1 = cateId1;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CateId2", unique = true, nullable = false)
	public Integer getCateId2() {
		return this.cateId2;
	}

	public void setCateId2(Integer cateId2) {
		this.cateId2 = cateId2;
	}

	@Column(name = "CateName", length = 50)
	public String getCateName() {
		return this.cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	@Column(name = "CateId1", nullable = false)
	public Integer getCateId1() {
		return this.cateId1;
	}

	public void setCateId1(Integer cateId1) {
		this.cateId1 = cateId1;
	}

	@Column(name = "Remark", length = 50)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}