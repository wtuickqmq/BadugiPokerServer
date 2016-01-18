package com.badugi.game.logic.model.message;

import java.util.List;

import com.badugi.game.logic.model.domain.vo.game.Rooms;



/**
 * @copyright：Copyright 2011  highesthelp.com All Rights Reserved
 * @author: weijie
 * @email: <a href="mailto:jackstudiomaster@gmail.com">jackie</a>
 * @createTime: 2012-11-9
 * @description：游戏应用端房间信息更新请求参数
 */
public class RoomsOp {
	
	private String cmd;
	/**
	 * QQ3.0
	 * wtu.edit
	 * 请求用户id
	 */
	private Long fbid;
	/**
	 * isAll
	 */
	private boolean ia;
	/**
	 * roomId
	 */
	private String rid;
	/**
	 * gameType
	 */
	private int gt;
	/**
	 * groupId
	 */
	private String gid;
	/**
	 * room
	 */
	private List<Rooms> list;
	
	/*加入/离开房间相关*/
	/**
	 *  父账号
	 */
	private String puid;

	/**
	 * 是否加入房间
	 * (加入为true,离开为false)
	 */
	private boolean ij;
	
	private boolean isRobot;
	
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	
	public Long getFbid() {
		return fbid;
	}
	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}
	public boolean isIa() {
		return ia;
	}
	public void setIa(boolean ia) {
		this.ia = ia;
	}
	public int getGt() {
		return gt;
	}
	public void setGt(int gt) {
		this.gt = gt;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public List<Rooms> getList() {
		return list;
	}
	public void setList(List<Rooms> list) {
		this.list = list;
	}
	public String getPuid() {
		return puid;
	}
	public void setPuid(String puid) {
		this.puid = puid;
	}
	public boolean getIj() {
		return ij;
	}
	public void setIj(boolean ij) {
		this.ij = ij;
	}
	
	public boolean isRobot() {
		return isRobot;
	}
	public void setRobot(boolean isRobot) {
		this.isRobot = isRobot;
	}
	@Override
	public String toString() {
		return "RoomsOp [cmd=" + cmd + ", ia=" + ia + ", rid=" + rid + ", gt="
				+ gt + ", gid=" + gid + ", list=" + list + ", puid=" + puid
				+ ", ij=" + ij + "]";
	}
	
	

}
