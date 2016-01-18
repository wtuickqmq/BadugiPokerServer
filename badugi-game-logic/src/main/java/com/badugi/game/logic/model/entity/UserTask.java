package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserTask entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_task")
public class UserTask extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Long fbId;
	private Integer cateId1;
	private Integer cateId2;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public UserTask() {
	}

	/** full constructor */
	public UserTask(Long fbId, Integer cateId1, Integer cateId2,
			Timestamp createTime) {
		this.fbId = fbId;
		this.cateId1 = cateId1;
		this.cateId2 = cateId2;
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

	@Column(name = "CateId1", nullable = false)
	public Integer getCateId1() {
		return this.cateId1;
	}

	public void setCateId1(Integer cateId1) {
		this.cateId1 = cateId1;
	}

	@Column(name = "CateId2", nullable = false)
	public Integer getCateId2() {
		return this.cateId2;
	}

	public void setCateId2(Integer cateId2) {
		this.cateId2 = cateId2;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}