package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MyTicketUsedlog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "my_ticket_usedlog")
public class MyTicketUsedlog extends BaseEntity implements java.io.Serializable {

	/**
	 * 门票报名
	 */
	public static final Short USETYPE_MATCH = 1;
	
	/**
	 * 兑奖使用
	 */
	public static final Short USETYPE_EXPRIZE = 2;
	
	/**
	 * 兑换筹码使用
	 */
	public static final Short USETYPE_EXCHANGE = 3;
	
	/**
	 * 赠送
	 */
	public static final Short USETYPE_PRESENT = 4;
	
	/**
	 * 装饰 
	 */
	public static final Short USERTYPE_DECORTE = 6;
	
	
	/**
	 * 已使用
	 */
	public static final Integer OBJECT_USED = 1;
	
	/**
	 * 未使用
	 */
	public static final Integer OBJECT_FED = 0;
	
	
	// Fields

	private Integer id;
	private Integer myTicketId;
	private Long fbId;
	private Short useType;
	private Integer object;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public MyTicketUsedlog() {
	}

	/** minimal constructor */
	public MyTicketUsedlog(Integer myTicketId, Long fbId, Short useType) {
		this.myTicketId = myTicketId;
		this.fbId = fbId;
		this.useType = useType;
	}

	/** full constructor */
	public MyTicketUsedlog(Integer myTicketId, Long fbId, Short useType,
			Integer object, Timestamp createTime) {
		this.myTicketId = myTicketId;
		this.fbId = fbId;
		this.useType = useType;
		this.object = object;
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

	@Column(name = "MyTicketId", nullable = false)
	public Integer getMyTicketId() {
		return this.myTicketId;
	}

	public void setMyTicketId(Integer myTicketId) {
		this.myTicketId = myTicketId;
	}

	@Column(name = "FbId", nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "UseType", nullable = false)
	public Short getUseType() {
		return this.useType;
	}

	public void setUseType(Short useType) {
		this.useType = useType;
	}
	
	@Column(name = "Object")
	public Integer getObject() {
		return this.object;
	}

	public void setObject(Integer object) {
		this.object = object;
	}

	@Column(name = "CreateTime", nullable = false)
	public Timestamp getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	

}