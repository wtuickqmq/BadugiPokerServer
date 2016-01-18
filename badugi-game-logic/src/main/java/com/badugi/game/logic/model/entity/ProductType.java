package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ProductType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product_type")
public class ProductType extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String description;
	private Timestamp inputTime;
	private Short status;

	// Constructors

	/** default constructor */
	public ProductType() {
	}

	/** minimal constructor */
	public ProductType(String name, Short status) {
		this.name = name;
		this.status = status;
	}

	/** full constructor */
	public ProductType(String name, String description, Timestamp inputTime,
			Short status) {
		this.name = name;
		this.description = description;
		this.inputTime = inputTime;
		this.status = status;
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

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "inputTime", length = 19)
	public Timestamp getInputTime() {
		return this.inputTime;
	}

	public void setInputTime(Timestamp inputTime) {
		this.inputTime = inputTime;
	}

	@Column(name = "status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

}