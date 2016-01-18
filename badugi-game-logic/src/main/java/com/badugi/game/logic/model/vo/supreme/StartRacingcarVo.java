package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class StartRacingcarVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cmd;
	private Long code;
	private Long fbId;
	private Double minChips;// 最低上庄筹码
	private Double playerChips;// 当前玩家大厅筹码
	private List<String> prizeRecords;// 开奖记录
	private String remark;
	private DealerStatus currDealer;
	private ConcurrentLinkedQueue<DealerQueueVo> queue;
	private List<WealthVo> wealthlist;
	private long status;
	private int isPush; //是否为主动推送, 1=推送,0=登陆
	/**
	 * wtu.edit 2015-11-25 为小游戏增加人数接口
	 */
	private int count;//人员数量

	public StartRacingcarVo(String cmd, Long code, String remark) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.remark = remark;
	}

	public StartRacingcarVo(String cmd, Long code, String remark, Long fbId, Double minChips, Double playerChips, List<String> prizeRecords, DealerStatus currDealer,
			ConcurrentLinkedQueue<DealerQueueVo> queue, List<WealthVo> wealthlist, long status) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.fbId = fbId;
		this.remark = remark;
		this.minChips = minChips;
		this.playerChips = playerChips;
		this.prizeRecords = prizeRecords;
		this.queue = queue;
		this.currDealer = currDealer;
		this.wealthlist = wealthlist;
		this.status = status;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public ConcurrentLinkedQueue<DealerQueueVo> getQueue() {
		return queue;
	}

	public void setQueue(ConcurrentLinkedQueue<DealerQueueVo> queue) {
		this.queue = queue;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public List<WealthVo> getWealthlist() {
		return wealthlist;
	}

	public void setWealthlist(List<WealthVo> wealthlist) {
		this.wealthlist = wealthlist;
	}

	public Double getMinChips() {
		return minChips;
	}

	public void setMinChips(Double minChips) {
		this.minChips = minChips;
	}

	public Double getPlayerChips() {
		return playerChips;
	}

	public void setPlayerChips(Double playerChips) {
		this.playerChips = playerChips;
	}

	public List<String> getPrizeRecords() {
		return prizeRecords;
	}

	public void setPrizeRecords(List<String> prizeRecords) {
		this.prizeRecords = prizeRecords;
	}

	public DealerStatus getCurrDealer() {
		return currDealer;
	}

	public void setCurrDealer(DealerStatus currDealer) {
		this.currDealer = currDealer;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public Long getFbId() {
		return fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	public int getIsPush() {
		return isPush;
	}

	public void setIsPush(int isPush) {
		this.isPush = isPush;
	}

	/**
	 * @return count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count 要设置的 count
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
	

}
