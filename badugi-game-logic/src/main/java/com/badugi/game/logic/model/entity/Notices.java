package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Notices entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "notices")
public class Notices extends BaseEntity implements java.io.Serializable {

	public static final Short TYPE_SERVERSTOP = 1;
	
	
	// Fields

	private Integer id;
	private String content;
	private Timestamp beginTime;
	private Timestamp endTime;
	private String managerName;
	private Timestamp operatedTime;
	private Short type;

	// Constructors

	/** default constructor */
	public Notices() {
	}

	/** minimal constructor */
	public Notices(String content, Timestamp beginTime, Timestamp endTime) {
		this.content = content;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}

	/** full constructor */
	public Notices(String content, Timestamp beginTime, Timestamp endTime,
			String managerName, Timestamp operatedTime) {
		this.content = content;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.managerName = managerName;
		this.operatedTime = operatedTime;
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

	@Column(name = "Content", nullable = false, length = 100)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "BeginTime", nullable = false, length = 19)
	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	@Column(name = "EndTime", nullable = false, length = 19)
	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
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
	
	@Column(name = "Type", nullable = false)
	public Short getType() {
		return type;
	}
	
	public void setType(Short type) {
		this.type = type;
	}

}