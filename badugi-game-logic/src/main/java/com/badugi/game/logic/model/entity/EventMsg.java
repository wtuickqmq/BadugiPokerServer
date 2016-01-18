package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EventMsg entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "event_msg")
public class EventMsg extends BaseEntity implements java.io.Serializable {

	/**
	 * 系统群发消息
	 */
	public static final Short TYPE_SYS = 1;
	
	/**
	 * 活动
	 */
	public static final Short TYPE_EVE = 0;
	// Fields

	private Integer msgId;
	private String title;
	private Short type = TYPE_EVE;
	private String content;
	private Timestamp createTime;
	private String picName;
	private String managerName;
	private Timestamp operatedTime;

	// Constructors

	/** default constructor */
	public EventMsg() {
	}

	/** full constructor */
	public EventMsg(String title, Short type, String content, Timestamp createTime,
			String picName, String managerName, Timestamp operatedTime) {
		this.title = title;
		this.type = type;
		this.content = content;
		this.createTime = createTime;
		this.picName = picName;
		this.managerName = managerName;
		this.operatedTime = operatedTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MsgId", unique = true, nullable = false)
	public Integer getMsgId() {
		return this.msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	@Column(name = "Title", length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "Type")
	public Short getType() {
		return type;
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

	@Column(name = "CreateTime", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "PicName", length = 50)
	public String getPicName() {
		return this.picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
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

}