package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "racingcar_log")
public class RacingCarLog extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -195635806313912126L;
	private String scId;//日志ID
	private Long fbId;//操作人ID
	private String operType;//操作类型
	private String operContent;//操作内容
	private String operRemark;//操作备注
	private Date operTime;//操作时间
	
	public RacingCarLog(){}
	
	public RacingCarLog(String scId,Long fbId,String operType,String operContent,String operRemark,Date operTime){
		this.scId = scId;
		this.fbId = fbId;
		this.operContent= operContent;
		this.operRemark = operRemark;
		this.operType = operType;
		this.operTime = operTime;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sc_id", unique = true, nullable = false)
	public String getScId() {
		return scId;
	}
	public void setScId(String scId) {
		this.scId = scId;
	}
	@Column(name = "fbId", nullable = true)
	public Long getFbId() {
		return fbId;
	}
	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}
	@Column(name = "operType", nullable = true)
	public String getOperType() {
		return operType;
	}
	public void setOperType(String operType) {
		this.operType = operType;
	}
	@Column(name = "operContent", nullable = true)
	public String getOperContent() {
		return operContent;
	}
	public void setOperContent(String operContent) {
		this.operContent = operContent;
	}
	@Column(name = "operRemark", nullable = true)
	public String getOperRemark() {
		return operRemark;
	}
	public void setOperRemark(String operRemark) {
		this.operRemark = operRemark;
	}
	@Column(name = "operTime", nullable = true)
	public Date getOperTime() {
		return operTime;
	}
	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}
	
	
	
}
