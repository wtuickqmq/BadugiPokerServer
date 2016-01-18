package com.badugi.game.logic.model.domain.vo.flash.operators;

import com.badugi.game.logic.model.domain.vo.flash.user.UserInRoom;

public class RobotRoomVo {
	private String cmd;
	/**
	 * 返回码
	 */
	private Long code;
	
	
	private UserInRoom room;
	
	/**
	 * wtu.add 2015-10-12
	 * 机器人，需要房间最大人数
	 * 在线人数
	 */
	private int mc;
	
	private int cc;
	//房间新老用户类型
	private int rt;
	
	private String gid;
	

	public RobotRoomVo() {
		super();
	}
	
	

	public RobotRoomVo(String cmd, Long code, UserInRoom room, int mc, int cc) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.room = room;
		this.mc = mc;
		this.cc = cc;
	}
	

	public RobotRoomVo(String cmd, Long code, UserInRoom room, int mc, int cc,
			int rt, String gid) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.room = room;
		this.mc = mc;
		this.cc = cc;
		this.rt = rt;
		this.gid = gid;
	}



	public RobotRoomVo(String cmd, Long code, UserInRoom room, int mc, int cc,
			int rt) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.room = room;
		this.mc = mc;
		this.cc = cc;
		this.rt = rt;
	}

	public RobotRoomVo(String cmd, Long code, UserInRoom room) {
		super();
		this.cmd = cmd;
		this.code = code;
		
		this.room = room;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	
	public UserInRoom getRoom() {
		return room;
	}

	public void setRoom(UserInRoom room) {
		this.room = room;
	}

	public int getMc() {
		return mc;
	}

	public void setMc(int mc) {
		this.mc = mc;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public int getRt() {
		return rt;
	}

	public void setRt(int rt) {
		this.rt = rt;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	
	

	





}
