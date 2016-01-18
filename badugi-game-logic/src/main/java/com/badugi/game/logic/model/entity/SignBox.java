package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SignBox entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sign_box")
public class SignBox extends BaseEntity implements java.io.Serializable {

	// Fields
	public static final Short BOXTYPE_5 = 1;
	public static final Short BOXTYPE_10 = 2;
	public static final Short BOXTYPE_20 = 3;
	/**
	 * 全勤
	 */
	public static final Short BOXTYPE_30 = 4;
	
	
	// Fields

	private Integer id;
	private Long fbId;
	private Short boxType;
	private Integer ticketId;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public SignBox() {
	}

	/** minimal constructor */
	public SignBox(Long fbId, Short boxType, Timestamp createTime) {
		this.fbId = fbId;
		this.boxType = boxType;
		this.createTime = createTime;
	}

	/** full constructor */
	public SignBox(Long fbId, Short boxType, Integer ticketId,
			Timestamp createTime) {
		this.fbId = fbId;
		this.boxType = boxType;
		this.ticketId = ticketId;
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

	@Column(name = "FbId", nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "BoxType", nullable = false)
	public Short getBoxType() {
		return this.boxType;
	}

	public void setBoxType(Short boxType) {
		this.boxType = boxType;
	}

	@Column(name = "TicketId")
	public Integer getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	public static Short getBoxType(int count){
		switch(count){
			case 5:
				return BOXTYPE_5;
			case 10:
				return BOXTYPE_10;
			case 20:
				return BOXTYPE_20;
			case 30:
				return BOXTYPE_30;
		}
		return null;
	}

}