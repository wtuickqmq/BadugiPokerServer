package com.badugi.game.logic.model.domain.vo.flash.user;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * 大厅用户账户信息vo
 * 
 * @author amin
 */
public class UserBackChipsVo {

	/**
	 * 返回码
	 */
	private Long code;
	/**
	 * 操作类型
	 */
	private String cmd;
	/**
	 * facebook编号fbid
	 */
	private Long id;
	
	//局数
	private int rd;
	//总时间（秒 单位）
	private int pt;
	//赢利筹码
	private double cc;
	//VIP点数
	private double p;
	//返回提示语
	private String lab;
	//时间
	private String t;
	
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getRd() {
		return rd;
	}
	public void setRd(int rd) {
		this.rd = rd;
	}
	public int getPt() {
		return pt;
	}
	public void setPt(int pt) {
		this.pt = pt;
	}
	public double getCc() {
		return cc;
	}
	public void setCc(double cc) {
		this.cc = cc;
	}
	public double getP() {
		return p;
	}
	public void setP(double p) {
		this.p = p;
	}
	public String getLab() {
		return lab;
	}
	public void setLab(String lab) {
		this.lab = lab;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	
	
	
}
