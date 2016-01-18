package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;
import java.util.List;

public class CollectionBetsVo  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private CollectionBets bets;
	private String cmd;
	private Long fbId;
	private String item;
	private Integer upChips;
	public CollectionBetsVo(){}
	public CollectionBetsVo(Long fbId,String cmd,String item,Integer upChips){
		this.cmd = cmd;
		this.fbId = fbId;
		this.item = item;
		this.upChips = upChips;
	}
/*	public CollectionBets getBets() {
		return bets;
	}
	public void setBets(CollectionBets bets) {
		this.bets = bets;
	}*/
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
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Integer getUpChips() {
		return upChips;
	}
	public void setUpChips(Integer upChips) {
		this.upChips = upChips;
	}
	
}
