package com.badugi.game.logic.model.vo.flash;

import java.util.List;

/**
 * 返回给flash
 */
@SuppressWarnings("rawtypes")
public class ResultVo {

	private String cmd;
	private long code;
	private int flag;
	private List list;
	private int roomGroup;
	
	public ResultVo(){
		super();
	}
	
	public ResultVo(String cmd) {
		super();
		this.cmd = cmd;
	}
	
	public ResultVo(String cmd, long code) {
		super();
		this.cmd = cmd;
		this.code = code;
	}
	
	public ResultVo(String cmd, List list) {
		super();
		this.cmd = cmd;
		this.list = list;
	}
	
	
	public ResultVo(String cmd, long code, List list, int roomGroup) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.list = list;
		this.roomGroup = roomGroup;
	}

	public ResultVo(String cmd, long code, int flag, List list) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.flag = flag;
		this.list = list;
	}

	public ResultVo(String cmd, long code, List list) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.list = list;
	}

	
	public int getRoomGroup() {
		return roomGroup;
	}

	public void setRoomGroup(int roomGroup) {
		this.roomGroup = roomGroup;
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
	
	public int getFlag() {
		return flag;
	}
	
	public void setFlag(int flag) {
		this.flag = flag;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}
