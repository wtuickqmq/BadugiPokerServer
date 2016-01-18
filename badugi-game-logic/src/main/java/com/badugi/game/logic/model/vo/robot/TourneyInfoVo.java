package com.badugi.game.logic.model.vo.robot;

/**
 * 比赛人数变化时机器人通知VO
 * 
 * @author amin
 */
public class TourneyInfoVo extends RobotVo {

	private String cmd;
	private String tid;// 比赛编号
	private int rc;// 比赛登记人数

	public TourneyInfoVo() {
		super();
	}

	public TourneyInfoVo(String cmd, String tid, int rc) {
		super();
		this.cmd = cmd;
		this.tid = tid;
		this.rc = rc;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public int getRc() {
		return rc;
	}

	public void setRc(int rc) {
		this.rc = rc;
	}

}
