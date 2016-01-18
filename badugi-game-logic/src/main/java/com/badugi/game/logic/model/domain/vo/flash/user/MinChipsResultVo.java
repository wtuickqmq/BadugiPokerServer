package com.badugi.game.logic.model.domain.vo.flash.user;


/**
 * 返回给flash
 */
public class MinChipsResultVo {

	private String cmd;
	private long code;
	private double chips;
	private double min;

	public MinChipsResultVo(String cmd, long code) {
		super();
		this.cmd = cmd;
		this.code = code;
	}
	
	public MinChipsResultVo(String cmd, long code, double chips, double min) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.chips = chips;
		this.min = min;
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
	public double getChips() {
		return chips;
	}
	public void setChips(double chips) {
		this.chips = chips;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	
	
	
	
	
}
