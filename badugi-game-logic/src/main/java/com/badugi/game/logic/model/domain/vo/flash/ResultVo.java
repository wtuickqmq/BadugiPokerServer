package com.badugi.game.logic.model.domain.vo.flash;

import java.util.List;

/**
 * 返回给flash
 */
@SuppressWarnings("rawtypes")
public class ResultVo {

	private String cmd;
	private Long code;
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
	/**
	 * sock 返回参数 
	 * @param cmd   命令
	 * @param code  返回代码
	 * @param list  返回列表
	 */

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

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
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
