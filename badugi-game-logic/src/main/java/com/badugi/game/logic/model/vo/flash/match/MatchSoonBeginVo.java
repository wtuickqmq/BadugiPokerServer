package com.badugi.game.logic.model.vo.flash.match;

/**
 * 比赛即将开始
 */
public class MatchSoonBeginVo {

	private String cmd;
	private long code;
	private int type;
	private int mid;
	private String mn;
	private String mst;

	public MatchSoonBeginVo() {
		super();
	}

	public MatchSoonBeginVo(String cmd, long code, int type, int mid,
			String mn, String mst) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.type = type;
		this.mid = mid;
		this.mn = mn;
		this.mst = mst;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMn() {
		return mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}

	public String getMst() {
		return mst;
	}

	public void setMst(String mst) {
		this.mst = mst;
	}

}
