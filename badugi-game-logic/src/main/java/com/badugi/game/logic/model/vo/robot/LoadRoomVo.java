package com.badugi.game.logic.model.vo.robot;

/**
 * 新增房间通知APP机器人VO
 * 
 * @author amin
 */
public class LoadRoomVo extends RobotVo {

	private String cmd;
	private String rid;// 房间ID
	private int uc;// 房间容纳人数
	private double mic;// 最小携带筹码
	private double mac;// 最大携带筹码

	public LoadRoomVo() {
		super();
	}

	public LoadRoomVo(String cmd, String rid, int uc, double mic, double mac) {
		super();
		this.cmd = cmd;
		this.rid = rid;
		this.uc = uc;
		this.mic = mic;
		this.mac = mac;
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

	public int getUc() {
		return uc;
	}

	public void setUc(int uc) {
		this.uc = uc;
	}

	public double getMic() {
		return mic;
	}

	public void setMic(double mic) {
		this.mic = mic;
	}

	public double getMac() {
		return mac;
	}

	public void setMac(double mac) {
		this.mac = mac;
	}

}
