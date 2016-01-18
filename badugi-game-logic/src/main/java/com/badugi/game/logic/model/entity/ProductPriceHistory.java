package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ProductPriceHistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product_price_history")
public class ProductPriceHistory extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer itemId;
	private Long chips;
	private Integer price;
	private Short status;
	private Timestamp inputTime;

	// Constructors

	/** default constructor */
	public ProductPriceHistory() {
	}

	/** minimal constructor */
	public ProductPriceHistory(Integer itemId) {
		this.itemId = itemId;
	}

	/** full constructor */
	public ProductPriceHistory(Integer itemId, Long chips, Integer price,
			Short status, Timestamp inputTime) {
		this.itemId = itemId;
		this.chips = chips;
		this.price = price;
		this.status = status;
		this.inputTime = inputTime;
	}

	// Property accessors
	@Id
	@Column(name = "item_id", unique = true, nullable = false)
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Column(name = "chips")
	public Long getChips() {
		return this.chips;
	}

	public void setChips(Long chips) {
		this.chips = chips;
	}

	@Column(name = "price")
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "inputTime", length = 19)
	public Timestamp getInputTime() {
		return this.inputTime;
	}

	public void setInputTime(Timestamp inputTime) {
		this.inputTime = inputTime;
	}

}