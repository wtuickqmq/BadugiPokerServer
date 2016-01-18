package com.badugi.game.logic.model.domain.vo.flash.operators;

import java.util.List;

/**
 * 游戏结束vo
 * @author amin
 */
public class GameLogVo {

	/**
	 * 游戏编号gameId
	 */
	private String gid;
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
	 * 游戏结束用户筹码
	 */
	private List<UserCpVo> list;

	// ******************游戏开始信息复制*************************
	/**
	 * 开始时间
	 */
	private long bt;
	/**
	 * 游戏开始用户筹码
	 */
	private List<UserCpVo> blist;

	public GameLogVo() {
		super();
	}
	
	public GameLogVo(String gid, String rid, long et, double pot, boolean flop,
			List<UserCpVo> list, long bt, List<UserCpVo> blist) {
		super();
		this.rid = rid;
		this.et = et;
		this.pot = pot;
		this.flop = flop;
		this.list = list;
		this.gid = gid;
		this.bt = bt;
		this.blist = blist;
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

	public List<UserCpVo> getList() {
		return list;
	}

	public void setList(List<UserCpVo> list) {
		this.list = list;
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

	public List<UserCpVo> getBlist() {
		return blist;
	}

	public void setBlist(List<UserCpVo> blist) {
		this.blist = blist;
	}

}
