package com.badugi.game.logic.model.domain.vo.flash.operators;

import java.util.List;

/**
 * 
* 项目名称：qq1.0   
* 类名称：MatchGameBeginVo   
* 创建人：huangcaiyuan 
* emial: caiyuan.huang@gmail.com   
* 创建时间：Dec 3, 2012 8:35:34 PM    
* @version 1.0
* 每局游戏开始
 */
public class MatchGameBeginVo {

	/**
	 * 比赛ID
	 */
	private Integer tid;
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

	public MatchGameBeginVo() {
		super();
	}

	public MatchGameBeginVo(Integer tid,String gid, String rid, long bt, List<UserCpVo> list) {
		super();
		this.tid=tid;
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

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

}
