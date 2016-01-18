package com.badugi.game.logic.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MatchPaytype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "match_paytype")
public class MatchPaytype extends BaseEntity implements java.io.Serializable {

	/**
	 * 支付方式0：筹码
	 */
	public static final Short PAYTIME_CHIPS = 0;
	/**
	 * 支付方式1：积分
	 */
	public static final Short PAYTIME_VIPPOINT = 1;
	/**
	 * 支付方式2：门票
	 */
	public static final Short PAYTIME_TICKET = 2;
	/**
	 * 支付方式3：推广代理
	 */
	public static final Short PAYTIME_AGENT = 3;
	/**
	 * 支付方式4：密码
	 */
	public static final Short PAYTIME_PWD = 4;
	
	
	// Fields

	private Integer id;
	private Integer matchConfigId;
	private Short payType;
	private String detail;

	// Constructors

	/** default constructor */
	public MatchPaytype() {
	}

	/** minimal constructor */
	public MatchPaytype(Integer matchConfigId, Short payType) {
		this.matchConfigId = matchConfigId;
		this.payType = payType;
	}

	/** full constructor */
	public MatchPaytype(Integer matchConfigId, Short payType, String detail) {
		this.matchConfigId = matchConfigId;
		this.payType = payType;
		this.detail = detail;
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

	@Column(name = "MatchConfigId", nullable = false)
	public Integer getMatchConfigId() {
		return this.matchConfigId;
	}

	public void setMatchConfigId(Integer matchConfigId) {
		this.matchConfigId = matchConfigId;
	}

	@Column(name = "PayType", nullable = false)
	public Short getPayType() {
		return this.payType;
	}

	public void setPayType(Short payType) {
		this.payType = payType;
	}

	@Column(name = "Detail", length = 100)
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}