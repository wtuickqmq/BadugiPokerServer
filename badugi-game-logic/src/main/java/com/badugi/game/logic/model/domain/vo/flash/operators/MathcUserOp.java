package com.badugi.game.logic.model.domain.vo.flash.operators;

import java.util.List;

/**
 * 
* 项目名称：qq1.0   
* 类名称：UserOp   
* 创建人：huangcaiyuan 
* emial: caiyuan.huang@gmail.com   
* 创建时间：Dec 3, 2012 8:46:21 PM    
* @version 1.0
* 游戏应用端比赛用户信息更新请求参数
 */
public class MathcUserOp {
	
	private String cmd;
	/**
	 * isAll
	 */
	private boolean ia;
	/**
	 * MatchPlayerInfoInRoom
	 */
	private List<MatchPlayerInfoInRoom> list;
	
	
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
	public List<MatchPlayerInfoInRoom> getList() {
		return list;
	}
	public void setList(List<MatchPlayerInfoInRoom> list) {
		this.list = list;
	}


}
