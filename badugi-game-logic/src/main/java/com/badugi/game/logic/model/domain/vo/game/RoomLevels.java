package com.badugi.game.logic.model.domain.vo.game;
/**
 * @copyright：Copyright 2011  highesthelp.com All Rights Reserved
 * @author: weijie
 * @email: <a href="mailto:jackstudiomaster@gmail.com">jackie</a>
 * @createTime: 2012-11-9
 * @description：
 */
public class RoomLevels {
	/**
	 * 等级类型(1虚拟,0现金)
	 */
	private int gt;
	/***
	 * 房间等级
	 */
	private int gl;
	/****
	 * 等级名称
	 */
	private String  ln;

	public RoomLevels(){
		super();
	}
	
	public RoomLevels(int gt, int gl, String ln) {
		super();
		this.gt = gt;
		this.gl = gl;
		this.ln = ln;
	}

	public int getGt() {
		return gt;
	}

	public void setGt(int gt) {
		this.gt = gt;
	}

	public int getGl() {
		return gl;
	}

	public void setGl(int gl) {
		this.gl = gl;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

}
