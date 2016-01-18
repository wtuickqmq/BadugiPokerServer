package com.badugi.game.logic.model.vo.api.task;

public class UserTaskFinalVo {

	private int tasktype;// 阶段
	private int iscomplete;// 是否完成(1:是0:否)

	public UserTaskFinalVo() {
		super();
	}

	public UserTaskFinalVo(int tasktype, int iscomplete) {
		super();
		this.tasktype = tasktype;
		this.iscomplete = iscomplete;
	}

	public int getTasktype() {
		return tasktype;
	}

	public void setTasktype(int tasktype) {
		this.tasktype = tasktype;
	}

	public int getIscomplete() {
		return iscomplete;
	}

	public void setIscomplete(int iscomplete) {
		this.iscomplete = iscomplete;
	}

}
