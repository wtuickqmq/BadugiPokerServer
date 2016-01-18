package com.badugi.game.logic.model.vo.common;

import java.util.Date;

import org.springframework.util.ReflectionUtils;



public class MatchSettingVo {
	
	public static final int CIRCLE_DAY_1= 1;
	public static final int CIRCLE_WEEK_2= 2;
	public static final int CIRCLE_MONTH_3= 3;
	
	//{'c':3,'d':3,'ot':'10:30','ct':'11:30','bt':'11:35'} 
	private Integer matchConfigId;
	
	/***
	 * 延后几天开始比赛
	 */
	private Integer after;
	
	/***
	 * 周期 1天 2周 3月
	 */
	private Integer circle;
	/*****
	 * 每周星期几 1~7
	 */
	private Integer week;
	/****
	 * 每月几号
	 */
	private Integer day;
	/***
	 * 报名开始时间
	 */
	private String openTime;
	/***
	 * 报名结束时间
	 */
	private String closeTime;
	/***
	 * 比赛开始时间
	 */
	private String beginTime;

	/***
	 * 上次生成时间
	 */
	private Date lastRenderTime;
	
	
	
	
	public MatchSettingVo() {
		super();
	}


	public MatchSettingVo(Integer matchConfigId, Integer circle, Integer week,
			Integer day, String openTime, String closeTime, String beginTime) {
		super();
		this.matchConfigId = matchConfigId;
		this.circle = circle;
		this.week = week;
		this.day = day;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.beginTime = beginTime;
	}
	
	
	public Integer getAfter() {
		return after;
	}


	public void setAfter(Integer after) {
		this.after = after;
	}


	public Integer getMatchConfigId() {
		return matchConfigId;
	}
	public void setMatchConfigId(Integer matchConfigId) {
		this.matchConfigId = matchConfigId;
	}
	public Integer getCircle() {
		return circle;
	}
	public void setCircle(Integer circle) {
		this.circle = circle;
	}
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public Date getLastRenderTime() {
		return lastRenderTime;
	}


	public void setLastRenderTime(Date lastRenderTime) {
		this.lastRenderTime = lastRenderTime;
	}





}
