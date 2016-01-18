package com.badugi.game.logic.model.message;

import java.util.List;

import com.badugi.game.logic.model.domain.vo.flash.user.PlayerInfoInRoom;

/**
 * @copyright：Copyright 2011  highesthelp.com All Rights Reserved
 * @author: weijie
 * @email: <a href="mailto:jackstudiomaster@gmail.com">jackie</a>
 * @createTime: 2012-11-9
 * @description：游戏应用端用户信息更新请求参数
 */
public class UserOp {
	
	private String cmd;
	/**
	 * isAll
	 */
	private boolean ia;
	/**
	 * PlayerInfoInRoom
	 */
	private List<PlayerInfoInRoom> list;
	
	
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public boolean isIa() {
		return ia;
	}
	public void setIa(boolean ia) {
		this.ia = ia;
	}
	public List<PlayerInfoInRoom> getList() {
		return list;
	}
	public void setList(List<PlayerInfoInRoom> list) {
		this.list = list;
	}


}
