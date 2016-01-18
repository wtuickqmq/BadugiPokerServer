package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * 
* 项目名称：qq1.0   
* 类名称：OdreHistory   
* 创建人：huangcaiyuan 
* emial: caiyuan.huang@gmail.com   
* 创建时间：Oct 12, 2013 11:47:32 AM    
* @version 1.0
 */
@Entity
@Table(name = "orderdispute")
public class OrderDispute extends BaseEntity implements Serializable{

	private Long orderId;
	private String user_comment;
	private Timestamp time_created;
	private String user_email;
	public Integer status;
	
	@Id
	@Column(name = "orderId", unique = true, nullable = false)
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	@Column(name = "user_comment")
	public String getUser_comment() {
		return user_comment;
	}
	public void setUser_comment(String userComment) {
		user_comment = userComment;
	}
	@Column(name = "time_created")
	public Timestamp getTime_created() {
		return time_created;
	}
	public void setTime_created(Timestamp timeCreated) {
		time_created = timeCreated;
	}
	@Column(name = "user_email")
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String userEmail) {
		user_email = userEmail;
	}
	
	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
