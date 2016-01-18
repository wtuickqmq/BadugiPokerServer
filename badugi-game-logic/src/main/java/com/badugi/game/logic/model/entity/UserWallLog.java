package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserWallLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_wall_log")
public class UserWallLog extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Long fbid;
	private Integer newsId;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public UserWallLog() {
	}

	/** full constructor */
	public UserWallLog(Long fbid, Integer newsId, Timestamp createTime) {
		this.fbid = fbid;
		this.newsId = newsId;
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

	@Column(name = "Fbid", nullable = false)
	public Long getFbid() {
		return this.fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}

	@Column(name = "NewsId", nullable = false)
	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}