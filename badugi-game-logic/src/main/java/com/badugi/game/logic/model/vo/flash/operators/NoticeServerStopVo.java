package com.badugi.game.logic.model.vo.flash.operators;

/**
 * 服务器启停通知APP返回值VO
 * @author amin
 *
 */
public class NoticeServerStopVo {

	private long bt;
	private long et;
	private long egt;
	private long emt;

	public NoticeServerStopVo() {
		super();
	}

	public NoticeServerStopVo(long bt, long et, long egt, long emt) {
		super();
		this.bt = bt;
		this.et = et;
		this.egt = egt;
		this.emt = emt;
	}

	public long getBt() {
		return bt;
	}

	public void setBt(long bt) {
		this.bt = bt;
	}

	public long getEt() {
		return et;
	}

	public void setEt(long et) {
		this.et = et;
	}

	public long getEgt() {
		return egt;
	}

	public void setEgt(long egt) {
		this.egt = egt;
	}

	public long getEmt() {
		return emt;
	}

	public void setEmt(long emt) {
		this.emt = emt;
	}

}
