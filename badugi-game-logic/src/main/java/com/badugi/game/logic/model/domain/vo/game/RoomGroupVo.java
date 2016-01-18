package com.badugi.game.logic.model.domain.vo.game;

/**
 * @author wtu.edit
 * @date 2015年10月17日
 * @version qq1.0
 * @email wtuickqmq@163.com
 */
public class RoomGroupVo {
//	{UserCount=6, defChips=400.0000, ChipLimit=1, EarlyBets=0.0000, RoomLevel=1, 
//			SpecialCard=1,
//			 SmallBlind=5.0000, BigBlind=10.0000, 
//			 MinChips=100.0000, RakeValue=0.0000, MaxChips=800.0000, SFSGroupID=g1}
	private String SFSGroupID;
	private int RoomLevel;
	private int UserCount;
	private double SmallBlind;
	private double BigBlind;
	private double RakeValue;
	private double EarlyBets;
	private double MinChips;
	private double MaxChips;
	private double defChips;
	private int ChipLimit;
	private int SpecialCard;
	
	public String getSFSGroupID() {
		return SFSGroupID;
	}
	public void setSFSGroupID(String sFSGroupID) {
		SFSGroupID = sFSGroupID;
	}
	public int getRoomLevel() {
		return RoomLevel;
	}
	public void setRoomLevel(int roomLevel) {
		RoomLevel = roomLevel;
	}
	public int getUserCount() {
		return UserCount;
	}
	public void setUserCount(int userCount) {
		UserCount = userCount;
	}
	public double getSmallBlind() {
		return SmallBlind;
	}
	public void setSmallBlind(double smallBlind) {
		SmallBlind = smallBlind;
	}
	public double getBigBlind() {
		return BigBlind;
	}
	public void setBigBlind(double bigBlind) {
		BigBlind = bigBlind;
	}
	public double getRakeValue() {
		return RakeValue;
	}
	public void setRakeValue(double rakeValue) {
		RakeValue = rakeValue;
	}
	public double getEarlyBets() {
		return EarlyBets;
	}
	public void setEarlyBets(double earlyBets) {
		EarlyBets = earlyBets;
	}
	public double getMinChips() {
		return MinChips;
	}
	public void setMinChips(double minChips) {
		MinChips = minChips;
	}
	public double getMaxChips() {
		return MaxChips;
	}
	public void setMaxChips(double maxChips) {
		MaxChips = maxChips;
	}
	public double getDefChips() {
		return defChips;
	}
	public void setDefChips(double defChips) {
		this.defChips = defChips;
	}
	public int getChipLimit() {
		return ChipLimit;
	}
	public void setChipLimit(int chipLimit) {
		ChipLimit = chipLimit;
	}
	public int getSpecialCard() {
		return SpecialCard;
	}
	public void setSpecialCard(int specialCard) {
		SpecialCard = specialCard;
	}
	
	
	

}
