package com.badugi.game.logic.model.vo.api.task;

public class MytaskDetailVo {

	private int tid;// 任务编号
	private int isr;// 是否完成(1:是0:否)

	public MytaskDetailVo() {
		super();
	}

	public MytaskDetailVo(int tid, int isr) {
		super();
		this.tid = tid;
		this.isr = isr;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getIsr() {
		return isr;
	}

	public void setIsr(int isr) {
		this.isr = isr;
	}

}
