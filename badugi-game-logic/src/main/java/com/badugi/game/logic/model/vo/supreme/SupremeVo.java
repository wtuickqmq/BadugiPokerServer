package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;

/**
 * 极品飞车
 * @author qazwsxedc
 *
 */
public class SupremeVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cmd;
	private Long fbId;//facebookId
	private Long sessionid;
	private int type;//
	private Long rmId;//房间号
	private double sb;//小筹
	private double cb;//中筹
	private double bb;//大筹
	private double upChips; //上庄筹码
	
	public SupremeVo(){}
	public SupremeVo(Long fbId){
		this.fbId = fbId;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public Long getFbId() {
		return fbId;
	}
	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}
	public Long getSessionid() {
		return sessionid;
	}
	public void setSessionid(Long sessionid) {
		this.sessionid = sessionid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getSb() {
		return sb;
	}
	public void setSb(double sb) {
		this.sb = sb;
	}
	public double getBb() {
		return bb;
	}
	public void setBb(double bb) {
		this.bb = bb;
	}
	public double getCb() {
		return cb;
	}
	public void setCb(double cb) {
		this.cb = cb;
	}
	public double getUpChips() {
		return upChips;
	}
	public void setUpChips(double upChips) {
		this.upChips = upChips;
	}
	public Long getRmId() {
		return rmId;
	}
	public void setRmId(Long rmId) {
		this.rmId = rmId;
	}
}
