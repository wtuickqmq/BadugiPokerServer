package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;

public class DealerQueueVo  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long fbId;
	private String fbName;
	private String imageUrl;
	private boolean robot;
	private Double upChips;//庄家上庄筹码
	private Double lobbyChips;//庄家大厅筹码
	private Long dateTime; //申请加入庄家队列时间
	public DealerQueueVo(){}
	public DealerQueueVo(Long fbId,String fbName,String imageUrl,Boolean robot,Double upChips,Double lobbyChips,Long dateTime){
		this.fbId = fbId;
		this.upChips = upChips;
		this.robot = robot;
		this.fbName = fbName;
		this.imageUrl = imageUrl;
		this.lobbyChips = lobbyChips;
		this.dateTime = dateTime;
	}
	
	public Double getUpChips() {
		return upChips;
	}
	public void setUpChips(Double upChips) {
		this.upChips = upChips;
	}
	public Long getFbId() {
		return fbId;
	}
	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}
	public boolean isRobot() {
		return robot;
	}
	public void setRobot(boolean robot) {
		this.robot = robot;
	}
	public String getFbName() {
		return fbName;
	}
	public void setFbName(String fbName) {
		this.fbName = fbName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Double getLobbyChips() {
		return lobbyChips;
	}
	public void setLobbyChips(Double lobbyChips) {
		this.lobbyChips = lobbyChips;
	}
	public Long getDateTime() {
		return dateTime;
	}
	public void setDateTime(Long dateTime) {
		this.dateTime = dateTime;
	}
}
