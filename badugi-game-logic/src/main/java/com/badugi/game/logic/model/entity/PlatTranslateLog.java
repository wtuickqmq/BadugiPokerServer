package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PlatTranslateLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "plat_translate_log")
public class PlatTranslateLog extends BaseEntity implements java.io.Serializable {

	/**
	 * 筹码
	 */
	public static final Short TYPE_CHIPS = 1;
	/**
	 * 门票
	 */
	public static final Short TYPE_TICLET = 2;
	/**
	 * 金块
	 */
	public static final Short TYPE_GOLD = 3;
	/**
	 * 大师分
	 */
	public static final Short TYPE_MASTER = 4;
	/**
	 * 实物
	 */
	public static final Short TYPE_GOODS = 5;
	/**
	 * 充值卡
	 */
	public static final Short TYPE_PHONECARD = 6;
	
	/**
	 * 成功 
	 */
	public static final Short STATUS_TRUE = 1;
	
	/**
	 * 失败
	 */
	public static final Short STATUS_FALSE = 0;
	// Fields

	private Integer id;
	private Long fbId;
	private Short giftType;
	private Double object;
	private String msg;
	private Short status;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public PlatTranslateLog() {
	}

	/** full constructor */
	public PlatTranslateLog(Long fbId, Short giftType, Double object,
			String msg, Short status, Timestamp createTime) {
		this.fbId = fbId;
		this.giftType = giftType;
		this.object = object;
		this.msg = msg;
		this.status = status;
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

	@Column(name = "FbId")
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "GiftType")
	public Short getGiftType() {
		return this.giftType;
	}

	public void setGiftType(Short giftType) {
		this.giftType = giftType;
	}

	@Column(name = "Object", precision = 22, scale = 0)
	public Double getObject() {
		return this.object;
	}

	public void setObject(Double object) {
		this.object = object;
	}

	@Column(name = "Msg", length = 2000)
	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Column(name = "Status")
	public Short getStatus() {
		return status;
	}
	
	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "CreateTime", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}