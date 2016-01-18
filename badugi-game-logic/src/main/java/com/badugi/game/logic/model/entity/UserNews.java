package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserNews entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_news")
public class UserNews extends BaseEntity implements java.io.Serializable {

	/**
	 * 比赛
	 */
	public static final Short TYPE_MATCH = 1;
	
	
	// Fields

	private Integer id;
	private Long fbId;
	private Short newsType;
	private Timestamp createTime;
	private String content;

	// Constructors

	/** default constructor */
	public UserNews() {
	}

	/** minimal constructor */
	public UserNews(Long fbId, Short newsType, Timestamp createTime) {
		this.fbId = fbId;
		this.newsType = newsType;
		this.createTime = createTime;
	}

	/** full constructor */
	public UserNews(Long fbId, Short newsType, Timestamp createTime,
			String content) {
		this.fbId = fbId;
		this.newsType = newsType;
		this.createTime = createTime;
		this.content = content;
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

	@Column(name = "NewsType", nullable = false)
	public Short getNewsType() {
		return this.newsType;
	}

	public void setNewsType(Short newsType) {
		this.newsType = newsType;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "Content", length = 500)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}