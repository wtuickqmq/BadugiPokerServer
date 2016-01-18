package com.badugi.game.logic.model.vo.flash.match;

/**
 * 比赛牌桌信息返回值
 * 
 * @author amin
 */
public class MatchRoomVo {

	private String rid;// 房间编号
	private String rn;// 房间名称
	private int c;// 房间人数
	private double mcp;// 最大筹码
	private double scp;// 最小筹码
	private int ie;// 是否删除

	public MatchRoomVo() {
		super();
	}

	public MatchRoomVo(String rid, String rn, int c, double mcp,
			double scp, int ie) {
		super();
		this.rid = rid;
		this.rn = rn;
		this.c = c;
		this.mcp = mcp;
		this.scp = scp;
		this.ie = ie;
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

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public double getMcp() {
		return mcp;
	}

	public void setMcp(double mcp) {
		this.mcp = mcp;
	}

	public double getScp() {
		return scp;
	}

	public void setScp(double scp) {
		this.scp = scp;
	}

	public int getIe() {
		return ie;
	}

	public void setIe(int ie) {
		this.ie = ie;
	}

}
