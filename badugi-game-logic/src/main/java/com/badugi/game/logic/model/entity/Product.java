package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product")
public class Product extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer itemId;
	private String title;
	private Integer type;
	private String description;
	private String imageUrl;
	private String productUrl;
	private Integer price;
	private Integer chips;
	private String data;
	private Timestamp inputTime;
	private Short status;
	private Double discountrate;
	private Integer ishot;
	private Integer specialChips;

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** full constructor */
	public Product(String title, Integer type, String description,
			String imageUrl, String productUrl, Integer price, Integer chips,
			String data, Timestamp inputTime, Short status) {
		this.title = title;
		this.type = type;
		this.description = description;
		this.imageUrl = imageUrl;
		this.productUrl = productUrl;
		this.price = price;
		this.chips = chips;
		this.data = data;
		this.inputTime = inputTime;
		this.status = status;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "item_id", unique = true, nullable = false)
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Column(name = "title", length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "description", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "image_url", length = 100)
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "product_url", length = 100)
	public String getProductUrl() {
		return this.productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	@Column(name = "price")
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "chips")
	public Integer getChips() {
		return this.chips;
	}

	public void setChips(Integer chips) {
		this.chips = chips;
	}

	@Column(name = "data", length = 100)
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Column(name = "inputTime", length = 19)
	public Timestamp getInputTime() {
		return this.inputTime;
	}

	public void setInputTime(Timestamp inputTime) {
		this.inputTime = inputTime;
	}

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "discountrate")
	public Double getDiscountrate() {
		return discountrate;
	}

	public void setDiscountrate(Double discountrate) {
		this.discountrate = discountrate;
	}
	
	@Column(name = "ishot")
	public Integer getIshot() {
		return ishot;
	}
	public void setIshot(Integer ishot) {
		this.ishot = ishot;
	}
	
	@Column(name = "specialChips")
	public Integer getSpecialChips() {
		return specialChips;
	}
	
	public void setSpecialChips(Integer specialChips) {
		this.specialChips = specialChips;
	}
	
	@PrePersist
	public void prePersist(){
		this.inputTime = (this.inputTime == null ? new Timestamp(System.currentTimeMillis()) : this.inputTime);
	}

}