package com.badugi.game.logic.model.vo.flash.operators;

public class JewelBoxConfigVo {
	private int type;
	private int tid;
	
	
	public JewelBoxConfigVo() {
		super();
	}
	public JewelBoxConfigVo(int type, int tid) {
		super();
		this.type = type;
		this.tid = tid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	

}
