package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="racingcar_dealer")
public class RacingcarDealer extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -27880349652234596L;
	private String racingDealerId;//主键
	private Long dealerId;//庄家ID
	private Long updealerChips;//该局上庄筹码
	private String racingcarId;//游戏Id
	private Date dealerTime;//坐庄时间
	
	public RacingcarDealer(){}
	public RacingcarDealer(String racingDealerId,Long dealerId,Long updealerChips,String racingcarId){
		this.dealerId = dealerId;
		this.racingDealerId = racingDealerId;
		this.updealerChips = updealerChips;
		this.racingcarId = racingcarId;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "racing_dealer_id", unique = true, nullable = false)
	public String getRacingDealerId() {
		return racingDealerId;
	}
	public void setRacingDealerId(String racingDealerId) {
		this.racingDealerId = racingDealerId;
	}
	@Column(name="dealer_id")
	public Long getDealerId() {
		return dealerId;
	}
	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}
	@Column(name="updealer_chips")
	public Long getUpdealerChips() {
		return updealerChips;
	}
	public void setUpdealerChips(Long updealerChips) {
		this.updealerChips = updealerChips;
	}
	@Column(name="racingcar_id")
	public String getRacingcarId() {
		return racingcarId;
	}
	public void setRacingcarId(String racingcarId) {
		this.racingcarId = racingcarId;
	}
	@Column(name="dealer_time")
	public Date getDealerTime() {
		return dealerTime;
	}
	public void setDealerTime(Date dealerTime) {
		this.dealerTime = dealerTime;
	}
	
}
