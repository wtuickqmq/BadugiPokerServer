package com.badugi.game.logic.model.vo.flash.match;

import java.util.List;

/**
 * 拼桌返回给APP数据
 * @author amin
 */
public class MatchMergeTableVo {

	private int tid;// 比赛编号
	private String rid;// 房间编号
	private String sign;// 处理编号
	private List<MergeTableDetail> merge;// 移动用户集合

	private boolean sync;// 是否同步
	private int state;// 1结束
	private long et;// 结束时间

	public MatchMergeTableVo() {
		super();
	}

	public MatchMergeTableVo(int tid, String rid, String sign) {
		super();
		this.tid = tid;
		this.rid = rid;
		this.sign = sign;
	}

	public MatchMergeTableVo(int tid, String rid, List<MergeTableDetail> merge) {
		super();
		this.tid = tid;
		this.rid = rid;
		this.merge = merge;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public List<MergeTableDetail> getMerge() {
		return merge;
	}

	public void setMerge(List<MergeTableDetail> merge) {
		this.merge = merge;
	}

	public boolean isSync() {
		return sync;
	}

	public void setSync(boolean sync) {
		this.sync = sync;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public long getEt() {
		return et;
	}

	public void setEt(long et) {
		this.et = et;
	}

}
