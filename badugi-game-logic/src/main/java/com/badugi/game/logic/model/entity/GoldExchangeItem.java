package com.badugi.game.logic.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GoldExchangeItem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gold_exchange_item")
public class GoldExchangeItem extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer goldValue;
	private Short goodsType;
	private Integer object;
	private Short status;

	// Constructors

	/** default constructor */
	public GoldExchangeItem() {
	}

	/** full constructor */
	public GoldExchangeItem(Integer goldValue, Short goodsType, Integer object) {
		this.goldValue = goldValue;
		this.goodsType = goodsType;
		this.object = object;
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

	@Column(name = "GoldValue", nullable = false)
	public Integer getGoldValue() {
		return this.goldValue;
	}

	public void setGoldValue(Integer goldValue) {
		this.goldValue = goldValue;
	}

	@Column(name = "GoodsType", nullable = false)
	public Short getGoodsType() {
		return this.goodsType;
	}

	public void setGoodsType(Short goodsType) {
		this.goodsType = goodsType;
	}

	@Column(name = "Object", nullable = false)
	public Integer getObject() {
		return this.object;
	}

	public void setObject(Integer object) {
		this.object = object;
	}
	
	@Column(name = "status", nullable = false)
	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

}