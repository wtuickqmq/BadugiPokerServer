package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.AUTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "racingcar_win_log")
public class RacingCarWinLog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;// 日志ID
	private String gameId;// 游戏id
	private Date time;// 操作时间
	private int isWin;// 是否是赢
	private int isRobot;// 是否是机器人
	private Long fbId; // 用户id
	private Long num; // 输赢的金额
	private Long commission; //佣金

	public RacingCarWinLog() {
	}

	@Id
	@GeneratedValue(strategy = AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "gameId", nullable = false)
	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "isWin", nullable = false)
	public int getIsWin() {
		return isWin;
	}

	public void setIsWin(int isWin) {
		this.isWin = isWin;
	}

	@Column(name = "fbId", nullable = false)
	public Long getFbId() {
		return fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "num", nullable = true)
	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	@Column(name = "isRobot", nullable = true)
	public int getIsRobot() {
		return isRobot;
	}

	public void setIsRobot(int isRobot) {
		this.isRobot = isRobot;
	}

	@Column(name = "commission", nullable = true)
	public Long getCommission() {
		return commission;
	}

	public void setCommission(Long commission) {
		this.commission = commission;
	}
	
	

}
