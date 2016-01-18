package com.badugi.game.logic.model.vo.robot;

import java.util.List;

/**
 * 房间人数发现变化
 * 
 * @author amin
 */
public class RoomInfoVo extends RobotVo{

	private String cmd;
	private String rid;
	private int sc;
	private List<Long> uids;

	public RoomInfoVo() {
		super();
	}

	public RoomInfoVo(String cmd, String rid, int sc, List<Long> uids) {
		super();
		this.cmd = cmd;
		this.rid = rid;
		this.sc = sc;
		this.uids = uids;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public int getSc() {
		return sc;
	}

	public void setSc(int sc) {
		this.sc = sc;
	}

	public List<Long> getUids() {
		return uids;
	}

	public void setUids(List<Long> uids) {
		this.uids = uids;
	}

}
