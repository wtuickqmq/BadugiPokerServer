package com.badugi.game.logic.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * NewsWall entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "news_wall")
public class NewsWall extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer newsId;
	private String content;

	// Constructors

	/** default constructor */
	public NewsWall() {
	}

	/** full constructor */
	public NewsWall(String content) {
		this.content = content;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "NewsId", unique = true, nullable = false)
	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	@Column(name = "Content", length = 500)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}