package com.badugi.game.logic.model.domain.vo.flash.match;

import java.util.HashMap;
import java.util.Map;


/***
 * 比赛用户信息
 * @author weijie
 *
 */
public class MatchUser {
	
	/**
	 * 是否被淘汰
	 * 是
	 */
	public static final int ISOVER_TRUE = 1;
	/**
	 * 是否被淘汰
	 * 否
	 */
	public static final int ISOVER_NO = 0;
	
	//更新比赛用户游戏座位标志 0：旁观,1 :游戏中,2：留座,3:托管
	public static final int SEAT_ONLOOKING=0;
	public static final int SEAT_GAMING=1;
	public static final int SEAT_LEAVING=2;
	public static final int SEAT_MANDATORYING=3;
	
	
	private Long fbId;
	
	private String fbName;
	
	private Double chip;
	
	private Long jionTime;
	/****
	 * 所在桌号
	 */
	private String rid;
	
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
	
	
	public MatchUser(){
		super();
	}
	
	public MatchUser(Long fbId, String fbName, Double chip, Long jionTime,
			int isOver, int ranking, String uid) {
		super();
		this.fbId = fbId;
		this.fbName = fbName;
		this.chip = chip;
		this.jionTime = jionTime;
		this.isOver = isOver;
		this.ranking = ranking;
		this.uid = uid;
	}
	
	public MatchUser(Long fbId, String fbName, Double chip, Long jionTime,
			int isOver, int ranking, String uid, String rid) {
		super();
		this.fbId = fbId;
		this.fbName = fbName;
		this.chip = chip;
		this.jionTime = jionTime;
		this.isOver = isOver;
		this.ranking = ranking;
		this.uid = uid;
		this.rid = rid;
	}



	public Long getFbId() {
		return fbId;
	}
	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}
	public String getFbName() {
		return fbName;
	}
	public void setFbName(String fbName) {
		this.fbName = fbName;
	}
	public Double getChip() {
		return chip;
	}
	public void setChip(Double chip) {
		this.chip = chip;
	}
	public Long getJionTime() {
		return jionTime;
	}
	public void setJionTime(Long jionTime) {
		this.jionTime = jionTime;
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

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}
	
	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public int getIsSit() {
		return isSit;
	}

	public void setIsSit(int isSit) {
		this.isSit = isSit;
	}
	
	public Map<Integer, Integer> killUser() {
		return this.killUser;
	}
	
	public boolean getIst() {
		return ist;
	}

	public void setIst(boolean ist) {
		this.ist = ist;
	}
	
	public boolean getIsut() {
		return isut;
	}
	
	public void setIsut(boolean isut) {
		this.isut = isut;
	}
	
	public int getIsStar() {
		return isStar;
	}
	
	public void setIsStar(int isStar) {
		this.isStar = isStar;
	}

	
	
}
