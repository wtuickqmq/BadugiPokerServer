package com.badugi.game.logic.model.domain.vo.flash.operators;

import java.util.List;

/**
 * 游戏开始vo
 * @author amin
 */
public class GameBeginVo {

	/**
	 * 游戏编号gameid
	 */
	private String gid;
	/**
	 * roomId
	 */
	private String rid;
	/**
	 * 开始时间
	 */
	private long bt;
	/**
	 * 游戏开始用户筹码
	 */
	private List<UserCpVo> list;

	public GameBeginVo() {
		super();
	}

	public GameBeginVo(String gid, String rid, long bt, List<UserCpVo> list) {
		super();
		this.gid = gid;
		this.rid = rid;
		this.bt = bt;
		this.list = list;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public long getBt() {
		return bt;
	}

	public void setBt(long bt) {
		this.bt = bt;
	}

	public List<UserCpVo> getList() {
		return list;
	}

	public void setList(List<UserCpVo> list) {
		this.list = list;
	}

}
