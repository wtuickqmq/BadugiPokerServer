package com.badugi.game.logic.model.domain.vo.flash.operators;

import java.util.List;

import com.badugi.game.logic.model.vo.flash.match.MatchJoinOrLeaveDetail;

/**
 * 
* 项目名称：qq1.0   
* 类名称：MatchGameLogVo   
* 创建人：huangcaiyuan 
* emial: caiyuan.huang@gmail.com   
* 创建时间：Dec 3, 2012 8:35:55 PM    
* @version 1.0
* 每局游戏结束
 */
public class MatchGameLogVo {

	/**
	 * 比赛编号
	 */
	private Integer tid;
	/**
	 * roomId
	 */
	private String rid;
	/**
	 * 结束时间
	 */
	private long et;
	/**
	 * 当前局底池
	 */
	private double pot;
	/**
	 * 当局是否翻牌
	 */
	private boolean flop;
	/**
	 * 游戏局号
	 */
	private String gid;
	/**
	 * 开始时间
	 */
	private long bt;
	/**
	 * 比赛是否结束
	 */
	private boolean ite;
	/**
	 * 游戏结束用户筹码
	 */
	private List<UserCpVo> list;
	
	/**
	 * 淘汰用户集合
	 */
	private List<MatchJoinOrLeaveDetail> loses;

	
	public MatchGameLogVo() {
		super();
	}
	


	public MatchGameLogVo(Integer tid, String rid, long et, double pot,
			boolean flop, List<UserCpVo> list) {
		super();
		this.tid = tid;
		this.rid = rid;
		this.et = et;
		this.pot = pot;
		this.flop = flop;
		this.list = list;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public long getEt() {
		return et;
	}

	public void setEt(long et) {
		this.et = et;
	}

	public double getPot() {
		return pot;
	}

	public void setPot(double pot) {
		this.pot = pot;
	}

	public boolean getFlop() {
		return flop;
	}

	public void setFlop(boolean flop) {
		this.flop = flop;
	}
	
	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public long getBt() {
		return bt;
	}

	public void setBt(long bt) {
		this.bt = bt;
	}
	
	public boolean getIte() {
		return ite;
	}

	public void setIte(boolean ite) {
		this.ite = ite;
	}

	public List<UserCpVo> getList() {
		return list;
	}

	public void setList(List<UserCpVo> list) {
		this.list = list;
	}

	public List<MatchJoinOrLeaveDetail> getLoses() {
		return loses;
	}

	public void setLoses(List<MatchJoinOrLeaveDetail> loses) {
		this.loses = loses;
	}

	
}
