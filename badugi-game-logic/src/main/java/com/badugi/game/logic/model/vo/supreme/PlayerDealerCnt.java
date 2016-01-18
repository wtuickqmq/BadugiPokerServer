package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;

/**
 * 玩家与庄家结算信息对比(仅发送给玩家自己)
 * @author qazwsxedc
 *
 */
public class PlayerDealerCnt implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cmd;
	private Long dealerFbId;//庄家id
	private Long playerFbId;//当前玩家id
	private Long playerWinChips;//当前玩家筹码
	private Long dealerWinChips;//庄家筹码
	private Long allWinChips;//所有闲家
	private Long mulWinChips;//加倍赠送的筹码
	
	public PlayerDealerCnt(){}
	
	public PlayerDealerCnt(String cmd,Long dealerFbId,Long playerFbId,Long playerWinChips,Long dealerWinChips,Long allWinChips,Long mulWinChips){
		this.cmd = cmd;
		this.dealerFbId = dealerFbId;
		this.playerFbId = playerFbId;
		this.playerWinChips = (playerWinChips==null?0:playerWinChips);
		this.dealerWinChips = dealerWinChips;
		this.allWinChips=  (allWinChips==null?0:allWinChips);
		this.mulWinChips=mulWinChips;
	}
	
	public Long getDealerFbId() {
		return dealerFbId;
	}
	public void setDealerFbId(Long dealerFbId) {
		this.dealerFbId = dealerFbId;
	}
	public Long getPlayerFbId() {
		return playerFbId;
	}
	public void setPlayerFbId(Long playerFbId) {
		this.playerFbId = playerFbId;
	}
	public Long getPlayerWinChips() {
		return playerWinChips;
	}
	public void setPlayerWinChips(Long playerWinChips) {
		this.playerWinChips = playerWinChips;
	}
	public Long getDealerWinChips() {
		return dealerWinChips;
	}
	public void setDealerWinChips(Long dealerWinChips) {
		this.dealerWinChips = dealerWinChips;
	}
	
	
	
	/**
	 * @return allWinChips
	 */
	public Long getAllWinChips() {
		return allWinChips;
	}

	/**
	 * @param allWinChips 要设置的 allWinChips
	 */
	public void setAllWinChips(Long allWinChips) {
		this.allWinChips = allWinChips;
	}
	
	

	/**
	 * @return mulWinChips
	 */
	public Long getMulWinChips() {
		return mulWinChips;
	}

	/**
	 * @param mulWinChips 要设置的 mulWinChips
	 */
	public void setMulWinChips(Long mulWinChips) {
		this.mulWinChips = mulWinChips;
	}

	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
}
