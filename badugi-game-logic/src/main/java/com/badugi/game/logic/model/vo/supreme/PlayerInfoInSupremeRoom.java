package com.badugi.game.logic.model.vo.supreme;

import java.util.List;

/**
 * @copyright： 
 * @author:  
 * @email:  
 * @createTime:  
 * @description：
 */
public class PlayerInfoInSupremeRoom {
	
	/**
	 * 账号
	 */
	private Long fbId;
	
	/**
	 * 用户昵称
	 */
	private String fbName;
	/**
	 * 用户头像
	 */
	private String imageUrl;
	/**
	 * 玩家游戏中座位号
	 */
	private short seat;
	
	/**
	 * 玩家游戏中筹码
	 */
	private double cp;
	/**
	 * 玩家在牌桌上的筹码
	 */
	private double cpir;
	/**
	 * 断线时间
	 */
	private long dt;
	/**
	 * 等待游戏时间
	 */
	private long wt;
	/**
	 * 是否坐下
	 */
	private boolean is;
	/**
	 * 是否托管
	 */
	private boolean at;
	/**
	 * 是否全部玩家更新
	 */
	private boolean ia;
	/**
	 * 是否留坐
	 */
	private boolean so;
	/****
	 * 是否是机器人
	 */
	private boolean isRobot;
	/**
	 * 玩家大厅筹码
	 */
	private Double lobbyChips;
	
	private List<Double> chipLayers;
	/**
	 * 是否坐下(标示)
	 * （-1:flash申请,1 :游戏中)
	 */
	private int isSit = -1;
	
	public PlayerInfoInSupremeRoom() {
	}
	public PlayerInfoInSupremeRoom(Long fbId,String fbName,boolean isRobot,String imageUrl,Double lobbyChips) {
		this.fbId = fbId;
		this.isRobot = isRobot;
		this.fbName = fbName;
		this.imageUrl = imageUrl;
		this.lobbyChips = lobbyChips;
	}

	public short getSeat() {
		return seat;
	}

	public void setSeat(short seat) {
		this.seat = seat;
	}

	public Long getFbId() {
		return fbId;
	}
	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getFbName() {
		return fbName;
	}
	public void setFbName(String fbName) {
		this.fbName = fbName;
	}
	public double getCp() {
		return cp;
	}

	public void setCp(double cp) {
		this.cp = cp;
	}
	
	public double getCpir() {
		return cpir;
	}

	public void setCpir(double cpir) {
		this.cpir = cpir;
	}

	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public long getWt() {
		return wt;
	}

	public void setWt(long wt) {
		this.wt = wt;
	}

	public boolean getIs() {
		return is;
	}

	public void setIs(boolean is) {
		this.is = is;
	}

	public boolean getAt() {
		return at;
	}

	public void setAt(boolean at) {
		this.at = at;
	}

	public boolean getIa() {
		return ia;
	}

	public void setIa(boolean ia) {
		this.ia = ia;
	}

	public boolean getSo() {
		return so;
	}

	public void setSo(boolean so) {
		this.so = so;
	}

	public boolean isRobot() {
		return isRobot;
	}

	public void setRobot(boolean isRobot) {
		this.isRobot = isRobot;
	}

	public List<Double> getChipLayers() {
		return chipLayers;
	}

	public void setChipLayers(List<Double> chipLayers) {
		this.chipLayers = chipLayers;
	}
	public int getIsSit() {
		return isSit;
	}
	public void setIsSit(int isSit) {
		this.isSit = isSit;
	}
	public Double getLobbyChips() {
		return lobbyChips;
	}
	public void setLobbyChips(Double lobbyChips) {
		this.lobbyChips = lobbyChips;
	}
}
