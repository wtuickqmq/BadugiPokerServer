package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Feedbacks entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "feedbacks")
public class Feedbacks extends BaseEntity implements java.io.Serializable {

	/**
	 * 程序出错
	 */
	public static final Short TYPE_SYS = 1;
	
	/**
	 * 账号异常
	 */
	public static final Short TYPE_ACCOUNT = 2;
	
	/**
	 * 界面风格
	 */
	public static final Short TYPE_BOUND = 3;
	
	/**
	 * 活动问题
	 */
	public static final Short TYPE_EXE = 4;
	
	/**
	 * 其他
	 */
	public static final Short TYPE_OTHER = 9;
	
	/**
	 * 已提交
	 */
	public static final Short STATUS_SUBMIT = 0;
	
	/**
	 * 已忽略
	 */
	public static final Short STATUS_IGNORE = 1;
	
	/**
	 * 已回复
	 */
	public static final Short STATUS_REPLY = 2;
	
	/**
	 * 回复已查看
	 */
	public static final Short STATUS_READ = 3;
	
	
	// Fields

	private Integer id;
	private Long fbId;
	private Short type;
	private String content;
	private String picName;
	private Timestamp createTime;
	private Short status;
	private String managerName;
	private Timestamp operatedTime;
	private String reply;

	// Constructors

	/** default constructor */
	public Feedbacks() {
	}

	/** minimal constructor */
	public Feedbacks(Long fbId, Short type, Timestamp createTime, Short status) {
		this.fbId = fbId;
		this.type = type;
		this.createTime = createTime;
		this.status = status;
	}

	/** full constructor */
	public Feedbacks(Long fbId, Short type, String content, String picName,
			Timestamp createTime, Short status, String managerName,
			Timestamp operatedTime, String reply) {
		this.fbId = fbId;
		this.type = type;
		this.content = content;
		this.picName = picName;
		this.createTime = createTime;
		this.status = status;
		this.managerName = managerName;
		this.operatedTime = operatedTime;
		this.reply = reply;
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

	@Column(name = "Type", nullable = false)
	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	@Column(name = "Content", length = 500)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "PicName", length = 50)
	public String getPicName() {
		return this.picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "Status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "ManagerName", length = 50)
	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Column(name = "OperatedTime", length = 19)
	public Timestamp getOperatedTime() {
		return this.operatedTime;
	}

	public void setOperatedTime(Timestamp operatedTime) {
		this.operatedTime = operatedTime;
	}

	@Column(name = "Reply", length = 500)
	public String getReply() {
		return this.reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

}