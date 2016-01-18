package com.badugi.game.logic.model.domain.vo.flash.user;
/**
 * @copyright：Copyright 2011  highesthelp.com All Rights Reserved
 * @author: weijie
 * @email: <a href="mailto:jackstudiomaster@gmail.com">jackie</a>
 * @createTime: 2012-10-23
 * @description：
 */
public class ExpLevelConfigVo {
	
	private int level;
	private int value;
	private int totalvalue;
	
	public ExpLevelConfigVo() {
		super();
	}


	public ExpLevelConfigVo(int level, int value) {
		super();
		this.level = level;
		this.value = value;
	}
	
	public ExpLevelConfigVo(int level, int value, int totalvalue) {
		super();
		this.level = level;
		this.value = value;
		this.totalvalue = totalvalue;
	}
	
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getTotalvalue() {
		return totalvalue;
	}
	public void setTotalvalue(int totalvalue) {
		this.totalvalue = totalvalue;
	}
	
	
	
}
