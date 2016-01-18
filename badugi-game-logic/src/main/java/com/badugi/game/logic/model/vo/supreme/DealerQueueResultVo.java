package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DealerQueueResultVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cmd;
	/**
	 * 游戏服务器ip
	 */
	private String ip;
	/**
	 * 端口port
	 */
	private int pt;
	/**
	 * 上庄最小筹码量
	 */
	private Double minChips;
	/**
	 * 上庄玩家总筹码量
	 */
	private Double playerChips;
	/**
	 * 子账号
	 */
	private String uid;
	/**
	 * 房间id(roomId)
	 */
	private String rid;
	/**
	 * 房间名称(roomName)
	 */
	private String rn;
	/**
	 * 返回结果代码
	 */
	private Long code;
	/**
	 * 返回结果描述
	 */
	private String description;
	/**
	 * 创建时间
	 */
	private long ct;
	
	private DealerQueueVo queuevo;  //待上庄
	
	private ConcurrentLinkedQueue<DealerQueueVo> queue;  //上庄队列
	private List<WealthVo> wealthlist;  //玩家大厅筹码土豪榜
	public DealerQueueResultVo(){}
	public DealerQueueResultVo(Long code,String description){
		this.code = code;
		this.description = description;
	}
	public DealerQueueResultVo(String cmd,Double minChips,DealerQueueVo queuevo,Double playerChips,List<WealthVo> wealthlist,ConcurrentLinkedQueue<DealerQueueVo> queue,Long code,String description){
		this.cmd = cmd;
		this.queuevo = queuevo;
		this.queue = queue;
		this.minChips = minChips;
		this.playerChips = playerChips;
		this.code = code;
		this.description = description;
		this.wealthlist = wealthlist;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPt() {
		return pt;
	}
	public void setPt(int pt) {
		this.pt = pt;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getRn() {
		return rn;
	}
	public void setRn(String rn) {
		this.rn = rn;
	}
	public long getCt() {
		return ct;
	}
	public void setCt(long ct) {
		this.ct = ct;
	}

	public DealerQueueVo getQueuevo() {
		return queuevo;
	}

	public void setQueuevo(DealerQueueVo queuevo) {
		this.queuevo = queuevo;
	}

	public ConcurrentLinkedQueue<DealerQueueVo> getQueue() {
		return queue;
	}

	public void setQueue(ConcurrentLinkedQueue<DealerQueueVo> queue) {
		this.queue = queue;
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
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<WealthVo> getWealthlist() {
		return wealthlist;
	}
	public void setWealthlist(List<WealthVo> wealthlist) {
		this.wealthlist = wealthlist;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	
}
