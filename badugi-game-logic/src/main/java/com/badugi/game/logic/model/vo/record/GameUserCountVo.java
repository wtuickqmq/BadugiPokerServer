package com.badugi.game.logic.model.vo.record;

public class GameUserCountVo {

	public String beginTime;// 开始时间
	public String endTime;// 结束时间
	public Integer howLong = 0;// 时间段
	public Long roundCount = 0L;// 总局数
	public Long allPlayTime = 0L;// 总游戏时长
	public Double allChangeChips = 0.0;// 总盈亏
	public Double allVipPoints;// 总vip点数
	public Double allPoint = 0.0;// 总vip积分
	public Double allExpValue = 0.0;// 总经验

	public GameUserCountVo() {
		super();
	}

	public GameUserCountVo(String beginTime, String endTime, Integer howLong,
			Long roundCount, Long allPlayTime, Double allChangeChips,
			Double allVipPoints, Double allPoint, Double allExpValue) {
		super();
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.howLong = howLong;
		this.roundCount = roundCount;
		this.allPlayTime = allPlayTime;
		this.allChangeChips = allChangeChips;
		this.allVipPoints = allVipPoints;
		this.allPoint = allPoint;
		this.allExpValue = allExpValue;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getHowLong() {
		return howLong;
	}

	public void setHowLong(Integer howLong) {
		this.howLong = howLong;
	}

	public Long getRoundCount() {
		return roundCount;
	}

	public void setRoundCount(Long roundCount) {
		this.roundCount = roundCount;
	}

	public Long getAllPlayTime() {
		return allPlayTime;
	}

	public void setAllPlayTime(Long allPlayTime) {
		this.allPlayTime = allPlayTime;
	}

	public Double getAllChangeChips() {
		return allChangeChips;
	}

	public void setAllChangeChips(Double allChangeChips) {
		this.allChangeChips = allChangeChips;
	}

	public Double getAllVipPoints() {
		return allVipPoints;
	}

	public void setAllVipPoints(Double allVipPoints) {
		this.allVipPoints = allVipPoints;
	}

	public Double getAllPoint() {
		return allPoint;
	}

	public void setAllPoint(Double allPoint) {
		this.allPoint = allPoint;
	}

	public Double getAllExpValue() {
		return allExpValue;
	}

	public void setAllExpValue(Double allExpValue) {
		this.allExpValue = allExpValue;
	}

}
