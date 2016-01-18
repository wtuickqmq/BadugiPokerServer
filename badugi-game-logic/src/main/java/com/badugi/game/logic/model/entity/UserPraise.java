package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_praise")
public class UserPraise extends BaseEntity implements java.io.Serializable {
	
	/**
	 * 赞
	 */
	public final static Integer LIKE = 1;
	/**
	 * 取消赞
	 */
	public final static Integer UNLIKE = 0;
	
	
	private Integer id;
	private Long fbId;
	private Long tofbId;
	private Timestamp createTime;
	private Integer status;
	
	public UserPraise(){
		super();
	}
	
	public UserPraise(Long fbId, Long tofbId, Integer status) {
		super();
		this.fbId = fbId;
		this.tofbId = tofbId;
		this.status = status;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "FbId")
	public Long getFbId() {
		return fbId;
	}
	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}
	
	@Column(name = "tofbId")
	public Long getTofbId() {
		return tofbId;
	}
	public void setTofbId(Long tofbId) {
		this.tofbId = tofbId;
	}
	
	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Column(name = "CreateTime")
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	@PrePersist
	public void prePersist(){
		this.createTime = (this.createTime == null ? new Timestamp(System.currentTimeMillis()) : this.createTime);
	}
}