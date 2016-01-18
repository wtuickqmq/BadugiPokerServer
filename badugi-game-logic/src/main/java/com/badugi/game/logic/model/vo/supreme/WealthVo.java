package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;

/**
 * 土豪财富榜
 * @author qazwsxedc
 *
 */
public class WealthVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long fbId;
	private String fbName;
	private String imageUrl;//
	private Double lobbyChips;//大厅筹码
	private boolean robot; //是否为机器人
	private Long dateTime;//加入土豪财富榜时间
	public WealthVo(){}
	public WealthVo(Long fbId,String fbName,String imageUrl,Double lobbyChips,Long dateTime,boolean robot){
		this.fbId = fbId;
		this.fbName = fbName;
		this.imageUrl = imageUrl;
		this.lobbyChips = lobbyChips;
		this.dateTime = dateTime;
		this.robot = robot;
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
	public boolean isRobot() {
		return robot;
	}
	public void setRobot(boolean robot) {
		this.robot = robot;
	}
}
