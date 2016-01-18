package com.badugi.game.logic.model.message;

public class GameUserMessage {
	// {"uid":22,"changechips":33,"holdcards":""}
	private Long uid;
	private Long changechips;
	private Long winchips;
	private String holdcards;

	public GameUserMessage(Long uid, Long changechips, String holdcards, Long winchips) {
		super();
		this.uid = uid;
		this.changechips = changechips;
		this.holdcards = holdcards;
		this.winchips = winchips;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public Long getChangechips() {
		return changechips;
	}
	public void setChangechips(Long changechips) {
		this.changechips = changechips;
	}
	public String getHoldcards() {
		return holdcards;
	}
	public void setHoldcards(String holdcards) {
		this.holdcards = holdcards;
	}
	public Long getWinchips() {
		return winchips;
	}
	public void setWinchips(Long winchips) {
		this.winchips = winchips;
	}

}
