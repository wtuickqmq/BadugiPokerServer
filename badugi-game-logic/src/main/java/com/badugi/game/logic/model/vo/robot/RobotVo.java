package com.badugi.game.logic.model.vo.robot;

import java.util.HashMap;
import java.util.Map;

public class RobotVo {
	
	private Long robotFbId;
	
	private String robotFbName;
	
	private String nickName;
	
	private Double expValue;
	
	private Double totalVipValue;
	
	private Integer vipLevel;
	
	private Double vipPoints;
	
	private Double maxChips;
	
	private Double roundMaxChips;
	/**
	 * 携带筹码
	 */
	private Double chips;
	/**
	 * 机器人头像
	 */
	private String imageUrl;
	
	
	/**
	 * 机器人已连续坐庄数
	 */
	private Integer inning;
	/**
	 * 构造时间
	 */
	private Long constructTime;
	
	 //机器人初始筹码
	private Double initChips;
	/***
	 * 是否淘汰(0 否 ,1 是)
	 */
	private int isOver;
	/****
	 * 排名
	 */
	private int ranking;
	/****
	 * 子账号信息
	 */
	private String uid;
	
	/***
	 * 离开时间
	 */
	private Long leaveTime;
	/***
	 * 最后一局的初始筹码
	 */
	private Double lastChips;
	/***
	 * 位置
	 */
	private Integer pos;
	/**
	 * 获得的奖品
	 */
	private String prize;
	/**
	 * 获得的筹码
	 */
	private Double amount;
	/**
	 * 获得的金块
	 */
	private Integer goldValue;
	/**
	 * 获得大师分
	 */
	private Integer masterValue;
	/**
	 * 是否得奖
	 */
	private boolean win;
	
	/** 坐位标志
	 * 0：旁观,1 :游戏中,2：留座,3:托管
	 */
	private int isSit = 1;
	/**
	 * 特殊选项
	 */
	private int isStar;
	/**
	 * 淘汰用户
	 * key:int 0 knockout 1 明星赏金 2 特殊赏金
	 * value:淘汰的人数
	 */
	private Map<Integer,Integer> killUser = new HashMap<Integer, Integer>();
	/**
	 * 是否被人淘汰
	 */
	private boolean ist = true;
	
	/**
	 * 是否使用门票报名
	 */
	private boolean isut = false;
	
	public RobotVo(){}
	
	public RobotVo(Long robotId,String nickname,Double chips,Double initChips,String imageUrl,Integer inning,Long constructTime){
		this.robotFbId = robotId;
		this.chips = chips;
		this.inning = inning;
		this.initChips = initChips;
		this.constructTime = constructTime;
		this.imageUrl = imageUrl;
	}
	public RobotVo(Long robotFbId,Double chips,Double lastChips){
		this.robotFbId = robotFbId;
		this.chips = chips;
		this.lastChips = lastChips;
	}

	

	public Double getChips() {
		return chips;
	}

	public void setChip(Double chips) {
		this.chips = chips;
	}

 

	public Long getConstructTime() {
		return constructTime;
	}

	public void setConstructTime(Long constructTime) {
		this.constructTime = constructTime;
	}
	
	public int getIsOver() {
		return isOver;
	}

	public void setIsOver(int isOver) {
		this.isOver = isOver;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Long getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(Long leaveTime) {
		this.leaveTime = leaveTime;
	}

	public Double getLastChips() {
		return lastChips;
	}
	
	public void setLastChips(Double lastChips) {
		this.lastChips = lastChips;
	}

	public Integer getPos() {
		return pos;
	}

	public void setPos(Integer pos) {
		this.pos = pos;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getGoldValue() {
		return goldValue;
	}

	public void setGoldValue(Integer goldValue) {
		this.goldValue = goldValue;
	}

	public Integer getMasterValue() {
		return masterValue;
	}

	public void setMasterValue(Integer masterValue) {
		this.masterValue = masterValue;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public int getIsSit() {
		return isSit;
	}

	public void setIsSit(int isSit) {
		this.isSit = isSit;
	}

	public int getIsStar() {
		return isStar;
	}

	public void setIsStar(int isStar) {
		this.isStar = isStar;
	}

	public Map<Integer, Integer> getKillUser() {
		return killUser;
	}

	public void setKillUser(Map<Integer, Integer> killUser) {
		this.killUser = killUser;
	}

	public boolean isIst() {
		return ist;
	}

	public void setIst(boolean ist) {
		this.ist = ist;
	}

	public boolean isIsut() {
		return isut;
	}

	public void setIsut(boolean isut) {
		this.isut = isut;
	}

	public Long getRobotFbId() {
		return robotFbId;
	}

	public void setRobotFbId(Long robotFbId) {
		this.robotFbId = robotFbId;
	}

	public String getRobotFbName() {
		return robotFbName;
	}

	public void setRobotFbName(String robotFbName) {
		this.robotFbName = robotFbName;
	}

	

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Double getExpValue() {
		return expValue;
	}

	public void setExpValue(Double expValue) {
		this.expValue = expValue;
	}

	public Double getTotalVipValue() {
		return totalVipValue;
	}

	public void setTotalVipValue(Double totalVipValue) {
		this.totalVipValue = totalVipValue;
	}

	public Integer getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(Integer vipLevel) {
		this.vipLevel = vipLevel;
	}

	public Double getVipPoints() {
		return vipPoints;
	}

	public void setVipPoints(Double vipPoints) {
		this.vipPoints = vipPoints;
	}

	public Double getMaxChips() {
		return maxChips;
	}

	public void setMaxChips(Double maxChips) {
		this.maxChips = maxChips;
	}

	public Double getRoundMaxChips() {
		return roundMaxChips;
	}

	public void setRoundMaxChips(Double roundMaxChips) {
		this.roundMaxChips = roundMaxChips;
	}

	public void setChips(Double chips) {
		this.chips = chips;
	}

	public Integer getInning() {
		return inning;
	}

	public void setInning(Integer inning) {
		this.inning = inning;
	}

	public Double getInitChips() {
		return initChips;
	}

	public void setInitChips(Double initChips) {
		this.initChips = initChips;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
