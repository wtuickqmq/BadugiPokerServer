package com.badugi.game.logic.model.vo.robot;

/**
 * 房间销毁通知APP机器人VO
 * 
 * @author amin
 */
public class DestroyRoomVo extends RobotVo {

	private String cmd;
	private String rid;// 房间ID

	public DestroyRoomVo() {
		super();
	}

	public DestroyRoomVo(String cmd, String rid) {
		super();
		this.cmd = cmd;
		this.rid = rid;
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

}
