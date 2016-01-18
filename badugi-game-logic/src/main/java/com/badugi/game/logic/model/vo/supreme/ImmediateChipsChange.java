package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;

public class ImmediateChipsChange implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cmd;//押注成功返回命令
	private Long fbId; //玩家ID
	private Long betFbId;//本次下注者fbId
	private String prizeItem;//玩家押注项
	private Integer upChips; //本次下注筹码
	private Map<String,String> chipsMap;//<chiptype,chiptypecount>,玩家该门押注筹码构成
	private Long lobbyChips; //押注后用户的大厅筹码
	private Long selfChips;//玩家单门押注筹码量
	private Long sumChips; //所有玩家该门押注筹码量
	private Map<String,Boolean> poolIsFull;//<门类,是否满>,押注后8个门类是否满的状态
	public ImmediateChipsChange(){}
	public ImmediateChipsChange(String cmd,Long fbId,Long betFbId,Integer upChips,String prizeItem,Map<String,String> chipsMap,Long lobbyChips,Long selfChips,Long sumChips,Map<String,Boolean> poolIsFull){
		this.cmd = cmd;
		this.fbId = fbId;
		this.betFbId = betFbId;
		this.upChips = upChips;
		this.prizeItem = prizeItem;
		this.chipsMap = chipsMap;
		this.sumChips = sumChips;
		this.selfChips = selfChips;
		this.lobbyChips = lobbyChips;
		this.poolIsFull = poolIsFull;
	}
	
	public Long getSelfChips() {
		return selfChips;
	}
	public void setSelfChips(Long selfChips) {
		this.selfChips = selfChips;
	}
	public Long getFbId() {
		return fbId;
	}
	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}
	public String getPrizeItem() {
		return prizeItem;
	}
	public void setPrizeItem(String prizeItem) {
		this.prizeItem = prizeItem;
	}
	 
	public Map<String, String> getChipsMap() {
		return chipsMap;
	}
	public void setChipsMap(Map<String,String> chipsMap) {
		this.chipsMap = chipsMap;
	}
	public Long getSumChips() {
		return sumChips;
	}
	public void setSumChips(Long sumChips) {
		this.sumChips = sumChips;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public Long getLobbyChips() {
		return lobbyChips;
	}
	public void setLobbyChips(Long lobbyChips) {
		this.lobbyChips = lobbyChips;
	}
	public Map<String, Boolean> getPoolIsFull() {
		return poolIsFull;
	}
	public void setPoolIsFull(Map<String, Boolean> poolIsFull) {
		this.poolIsFull = poolIsFull;
	}
	public Integer getUpChips() {
		return upChips;
	}
	public void setUpChips(Integer upChips) {
		this.upChips = upChips;
	}
	public Long getBetFbId() {
		return betFbId;
	}
	public void setBetFbId(Long betFbId) {
		this.betFbId = betFbId;
	}
	
}
