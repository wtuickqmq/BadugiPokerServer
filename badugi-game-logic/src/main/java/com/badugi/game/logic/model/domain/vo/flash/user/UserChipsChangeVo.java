package com.badugi.game.logic.model.domain.vo.flash.user;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * 大厅用户账户信息vo
 * 
 * @author amin
 */
public class UserChipsChangeVo {

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
	/**
	 * 筹码chips
	 */
	private double value;
	/**
	 * 改变类型
	 */
	private int type;
	
	
	public UserChipsChangeVo() {
		super();
	}
	
	
	
	public UserChipsChangeVo(Long code, String cmd, Long id, double value,
			int type) {
		super();
		this.code = code;
		this.cmd = cmd;
		this.id = id;
		this.value = value;
		this.type = type;
	}



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
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	
	
}
