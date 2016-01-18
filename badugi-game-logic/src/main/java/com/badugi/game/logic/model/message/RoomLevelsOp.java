package com.badugi.game.logic.model.message;

import java.util.List;

import com.badugi.game.logic.model.domain.vo.flash.operators.RoomLevels;


/**
 * @copyright：Copyright 2011  highesthelp.com All Rights Reserved
 * @author: weijie
 * @email: <a href="mailto:jackstudiomaster@gmail.com">jackie</a>
 * @createTime: 2012-11-9
 * @description：游戏应用端房间等级信息更新请求参数
 */
public class RoomLevelsOp {
	
	private String cmd;
	private boolean ia;
	private List<RoomLevels> list;
	
	
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
	public List<RoomLevels> getList() {
		return list;
	}
	public void setList(List<RoomLevels> list) {
		this.list = list;
	}
	
	
}
