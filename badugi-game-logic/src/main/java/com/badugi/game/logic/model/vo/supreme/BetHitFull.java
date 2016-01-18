package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;
import java.util.Map;

public class BetHitFull implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cmd;
	private Long fbId;
	private Long hitFullChips;//达到上限时押注的筹码量
	private Map<String,Boolean> poolIsFull;//<门类,是否满>
	public BetHitFull(){}
	public BetHitFull(String cmd,Long fbId,Long hitFullChips,Map<String,Boolean> poolIsFull){
		this.cmd = cmd;
		this.fbId = fbId;
		this.hitFullChips = hitFullChips;
		this.poolIsFull = poolIsFull;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public Long getFbId() {
		return fbId;
	}
	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}
	public Long getHitFullChips() {
		return hitFullChips;
	}
	public void setHitFullChips(Long hitFullChips) {
		this.hitFullChips = hitFullChips;
	}
	public Map<String, Boolean> getPoolIsFull() {
		return poolIsFull;
	}
	public void setPoolIsFull(Map<String, Boolean> poolIsFull) {
		this.poolIsFull = poolIsFull;
	}
}
