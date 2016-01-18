package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="racingcar_init")
public class RacingcarInit extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8386265359564107938L;
	
	private Long racingcarInitId;
	private Long robotInitChips;//机器人初始化筹码
	private Long systemPoolInitChips;//系统奖池初始化筹码
	private Long racingcarId; //racingcar外键
	
	public RacingcarInit(){}
	public RacingcarInit(Long systemPoolInitChips,Long robotInitChips){
		this.systemPoolInitChips = systemPoolInitChips;
		this.robotInitChips = robotInitChips;
	}
	public RacingcarInit(Long systemPoolInitChips){
		this.systemPoolInitChips = systemPoolInitChips;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "racingcar_init_id", unique = true, nullable = false)
	public Long getRacingcarInitId() {
		return racingcarInitId;
	}
	public void setRacingcarInitId(Long racingcarInitId) {
		this.racingcarInitId = racingcarInitId;
	}
	@Column(name="robot_init_chips",nullable=false)
	public Long getRobotInitChips() {
		return robotInitChips;
	}
	public void setRobotInitChips(Long robotInitChips) {
		this.robotInitChips = robotInitChips;
	}
	@Column(name="systempool_init_chips",nullable=false)
	public Long getSystemPoolInitChips() {
		return systemPoolInitChips;
	}
	public void setSystemPoolInitChips(Long systemPoolInitChips) {
		this.systemPoolInitChips = systemPoolInitChips;
	}
	@Column(name="racingcar_id")
	public Long getRacingcarId() {
		return racingcarId;
	}
	public void setRacingcarId(Long racingcarId) {
		this.racingcarId = racingcarId;
	}
}
