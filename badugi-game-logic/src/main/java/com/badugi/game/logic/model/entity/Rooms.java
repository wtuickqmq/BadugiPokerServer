package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

/**
 * Rooms entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "rooms", uniqueConstraints = @UniqueConstraint(columnNames = "SFSRoomName"))
public class Rooms extends BaseEntity implements java.io.Serializable {

	private static Rooms _SELF = new Rooms();
	
	// Fields

	public Integer roomId;
	public Integer roomGroupId;
	public String sfsroomName;
	public String roomName;
	public Short status;
	public Timestamp createTime;
	public String remark;
	public String managerName;
	public Timestamp operatedTime;
	
	public String fullName;
	public String level;
	public Integer userCount;
	public Integer orderType;
	public Integer orderValue;

	// Constructors

	/** default constructor */
	public Rooms() {
	}

	public Rooms(Integer roomId, String roomName) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
	}

	public Rooms(Integer roomId, String roomName,String fullName) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.fullName = fullName;
	}

	public Rooms(Integer roomId, String sfsroomName, String roomName,
			Short status, String managerName, Object  operatedTime,
			Integer userCount,Integer roomGroupId) {
		this.roomId = roomId;
		this.sfsroomName = sfsroomName;
		this.roomName = roomName;
		this.status = status;
		this.managerName = managerName;
		this.operatedTime = string2Timestamp(operatedTime.toString());
		this.userCount = userCount;
		this.roomGroupId=roomGroupId;
	}
	/** minimal constructor */
	public Rooms(Integer roomGroupId, String sfsroomName, Short status,
			Timestamp createTime) {
		this.roomGroupId = roomGroupId;
		this.sfsroomName = sfsroomName;
		this.status = status;
		this.createTime = createTime;
	}

	/** full constructor */
	public Rooms(Integer roomGroupId, String sfsroomName, String roomName,
			Short status, Timestamp createTime, String remark,
			String managerName, Timestamp operatedTime) {
		this.roomGroupId = roomGroupId;
		this.sfsroomName = sfsroomName;
		this.roomName = roomName;
		this.status = status;
		this.createTime = createTime;
		this.remark = remark;
		this.managerName = managerName;
		this.operatedTime = operatedTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "RoomID", unique = true, nullable = false)
	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	@Column(name = "RoomGroupID", nullable = false)
	public Integer getRoomGroupId() {
		return this.roomGroupId;
	}

	public void setRoomGroupId(Integer roomGroupId) {
		this.roomGroupId = roomGroupId;
	}

	@Column(name = "SFSRoomName", unique = true, nullable = false, length = 20)
	public String getSfsroomName() {
		return this.sfsroomName;
	}

	public void setSfsroomName(String sfsroomName) {
		this.sfsroomName = sfsroomName;
	}

	@Column(name = "RoomName", length = 20)
	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@Column(name = "Status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "Remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	@Transient
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Transient
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Transient
	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	@Transient
	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	@Transient
	public Integer getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(Integer orderValue) {
		this.orderValue = orderValue;
	}
	
	public static Rooms newIntance(){
	    Rooms a = null;
	    try {
	      a = (Rooms)_SELF.clone();
	      if (a == null)
	        a = new Rooms();
	    } catch (CloneNotSupportedException e) {
	      a = new Rooms();
	    }
	    return a;
	}
	

}