package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author qazwsxedc
 *
 */
public class SettleAccountVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cmd;

	private String winPrizeItem;
	private List<PlayerWinVo> winlist;
	private List<WealthVo>	wealthlist;
	private List<String> drawRecords;	//
	
	public SettleAccountVo(){}
	
	public SettleAccountVo(String cmd,String winPrizeItem,List<PlayerWinVo> winlist,List<WealthVo>	wealthlist,List<String> drawRecords){
		this.cmd = cmd;
	
		this.winPrizeItem = winPrizeItem;
		this.winlist = winlist;
		this.wealthlist = wealthlist;
		this.drawRecords = drawRecords;
	}
	
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	

	

	public String getWinPrizeItem() {
		return winPrizeItem;
	}
	public void setWinPrizeItem(String winPrizeItem) {
		this.winPrizeItem = winPrizeItem;
	}
	public List<PlayerWinVo> getWinlist() {
		return winlist;
	}
	public void setWinlist(List<PlayerWinVo> winlist) {
		this.winlist = winlist;
	}
	public List<WealthVo> getWealthlist() {
		return wealthlist;
	}
	public void setWealthlist(List<WealthVo> wealthlist) {
		this.wealthlist = wealthlist;
	}

	public List<String> getDrawRecords() {
		return drawRecords;
	}

	public void setDrawRecords(List<String> drawRecords) {
		this.drawRecords = drawRecords;
	}
	
}
