package com.badugi.game.logic.model.vo.flash.task;

/**
 * 每日任务完成通知flash信息vo
 * 
 * @author amin
 */
public class TodayTaskCompleteVo {

	/**
	 * 返回码
	 */
	private Long code;
	/**
	 * 操作类型
	 */
	private String cmd;
	/**
	 * 任务编号
	 */
	private int taskid;

	public TodayTaskCompleteVo() {
		super();
	}

	public TodayTaskCompleteVo(Long code, String cmd, int taskid) {
		super();
		this.code = code;
		this.cmd = cmd;
		this.taskid = taskid;
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

	public int getTaskid() {
		return taskid;
	}

	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}

}
