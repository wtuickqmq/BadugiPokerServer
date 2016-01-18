package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 极品飞车游戏
 * 
 * @author qazwsxedc
 *
 */
@Entity
@Table(name = "racing_car")
public class RacingCar extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5504489960775082293L;
	private String racingcarId;
	private String launchTime;// 游戏启动时间
	private Long dealerId;// 庄家ID
	private Integer playerCounts;// 玩家人数
	private Long dealerWinChips;// 庄家赢取(或输掉)筹码量
	private String drawId;// 开奖项(draw_item表外键)
	private Long systemPoolChips;// 当前系统奖池
	private Long sumChips;// 玩家押注总筹码量
	private Long robotChips;// 机器人押注总筹码量
	private Long playerWin; // 玩家赢钱
	private Long robotWin;// 机器人赢钱
	private Long dealerCommission; //庄家抽水

	public RacingCar() {
	}

	public RacingCar(String racingcarId, String launchTime, Long dealerId, Integer playerCounts, Long dealerWinChips, String drawId, Long systemPoolChips, Long sumChips, Long robotChips) {
		this.racingcarId = racingcarId;
		this.launchTime = launchTime;
		this.dealerId = dealerId;
		this.playerCounts = playerCounts;
		this.dealerWinChips = dealerWinChips;
		this.drawId = drawId;
		this.systemPoolChips = systemPoolChips;
		this.sumChips = sumChips;
		this.robotChips = robotChips;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "racingcar_id", unique = true, nullable = false)
	public String getRacingcarId() {
		return racingcarId;
	}

	public void setRacingcarId(String racingcarId) {
		this.racingcarId = racingcarId;
	}

	@Column(name = "launch_time")
	public String getLaunchTime() {
		return launchTime;
	}

	public void setLaunchTime(String launchTime) {
		this.launchTime = launchTime;
	}

	@Column(name = "dealer_id")
	public Long getDealerId() {
		return dealerId;
	}

	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}

	@Column(name = "player_counts")
	public Integer getPlayerCounts() {
		return playerCounts;
	}

	public void setPlayerCounts(Integer playerCounts) {
		this.playerCounts = playerCounts;
	}

	@Column(name = "dealer_win_chips")
	public Long getDealerWinChips() {
		return dealerWinChips;
	}

	public void setDealerWinChips(Long dealerWinChips) {
		this.dealerWinChips = dealerWinChips;
	}

	@Column(name = "draw_id")
	public String getDrawId() {
		return drawId;
	}

	public void setDrawId(String drawId) {
		this.drawId = drawId;
	}

	@Column(name = "systempool_chips")
	public Long getSystemPoolChips() {
		return systemPoolChips;
	}

	public void setSystemPoolChips(Long systemPoolChips) {
		this.systemPoolChips = systemPoolChips;
	}

	@Column(name = "sum_chips")
	public Long getSumChips() {
		return sumChips;
	}

	public void setSumChips(Long sumChips) {
		this.sumChips = sumChips;
	}

	@Column(name = "robot_chips")
	public Long getRobotChips() {
		return robotChips;
	}

	public void setRobotChips(Long robotChips) {
		this.robotChips = robotChips;
	}

	@Column(name = "playerWin")
	public Long getPlayerWin() {
		return playerWin;
	}

	public void setPlayerWin(Long playerWin) {
		this.playerWin = playerWin;
	}

	@Column(name = "robotWin")
	public Long getRobotWin() {
		return robotWin;
	}

	public void setRobotWin(Long robotWin) {
		this.robotWin = robotWin;
	}

	@Column(name = "dealerCommission")
	public Long getDealerCommission() {
		return dealerCommission;
	}

	public void setDealerCommission(Long dealerCommission) {
		this.dealerCommission = dealerCommission;
	}

	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RacingCar [racingcarId=" + racingcarId + ", launchTime="
				+ launchTime + ", dealerId=" + dealerId + ", playerCounts="
				+ playerCounts + ", dealerWinChips=" + dealerWinChips
				+ ", drawId=" + drawId + ", systemPoolChips=" + systemPoolChips
				+ ", sumChips=" + sumChips + ", robotChips=" + robotChips
				+ ", playerWin=" + playerWin + ", robotWin=" + robotWin
				+ ", dealerCommission=" + dealerCommission + "]";
	}
	
	

}
