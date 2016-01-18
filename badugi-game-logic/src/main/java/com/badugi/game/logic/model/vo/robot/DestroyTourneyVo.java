package com.badugi.game.logic.model.vo.robot;

/**
 * 比赛结束或者销毁时机器人通知VO
 * 
 * @author amin
 */
public class DestroyTourneyVo extends RobotVo {

	private String cmd;
	private String tid;// 比赛编号

	public DestroyTourneyVo() {
		super();
	}

	public DestroyTourneyVo(String cmd, String tid) {
		super();
		this.cmd = cmd;
		this.tid = tid;
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

}
