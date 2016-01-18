package com.badugi.game.logic.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="deposit")
public class Deposit extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private long uid;
	private int beforeAmt;
	private int afterAmt;
	private int amt;
	private byte status;
	private  String billNo;
	private String pf;
	private Timestamp creTime;
	private Timestamp updTime;
	
	public Deposit(){}
	public Deposit(int id,int uid,int beforeamt,int afteramt,int amt ,String bollNo,byte status,String pf){
		this.id = id;
		this.uid = uid;
		this.beforeAmt = beforeamt;
		this.afterAmt = amt;
		this.afterAmt = afteramt;
		this.status = status;
		this.billNo = bollNo;
		this.pf = pf;
		}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "u_id", nullable = false,length=20)
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	@Column(name = "before_amt", nullable = false,length=11)
	public int getBeforeAmt() {
		return beforeAmt;
	}
	public void setBeforeAmt(int beforeAmt) {
		this.beforeAmt = beforeAmt;
	}
	@Column(name = "after_amt", nullable = false,length=11)
	public int getAfterAmt() {
		return afterAmt;
	}
	public void setAfterAmt(int afterAmt) {
		this.afterAmt = afterAmt;
	}
	@Column(name = "amt", nullable = false,length=11)
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	@Column(name = "status", nullable = false,length=2)
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	@Column(name = "billno", nullable = false,length=100)
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	@Column(name = "pf", nullable = false,length=20)
	public String getPf() {
		return pf;
	}
	public void setPf(String pf) {
		this.pf = pf;
	}
	public Timestamp getCreTime() {
		return creTime;
	}
	public void setCreTime(Timestamp creTime) {
		this.creTime = creTime;
	}
	public Timestamp getUpdTime() {
		return updTime;
	}
	public void setUpdTime(Timestamp updTime) {
		this.updTime = updTime;
	}
	
	
}
