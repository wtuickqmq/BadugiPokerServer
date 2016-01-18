package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;
import java.util.List;

public class DealerResultVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cmd;
	private Long fbId;
	private Long totalWinChips;
	private List<DealerWinVo> dealerWinList;
	public DealerResultVo(){}
	public DealerResultVo(String cmd,Long fbId,Long totalWinChips,List<DealerWinVo> dealerWinList){
		this.cmd = cmd;
		this.fbId = fbId;
		this.totalWinChips = totalWinChips;
		this.dealerWinList = dealerWinList;
	}
	public Long getFbId() {
		return fbId;
	}
	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}
	public Long getTotalWinChips() {
		return totalWinChips;
	}
	public void setTotalWinChips(Long totalWinChips) {
		this.totalWinChips = totalWinChips;
	}
	public List<DealerWinVo> getDealerWinList() {
		return dealerWinList;
	}
	public void setDealerWinList(List<DealerWinVo> dealerWinList) {
		this.dealerWinList = dealerWinList;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	
}
