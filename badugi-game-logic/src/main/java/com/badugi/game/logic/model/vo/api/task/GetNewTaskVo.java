package com.badugi.game.logic.model.vo.api.task;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 用户新任务
 * 
 * @author amin
 */
public class GetNewTaskVo extends ResultVo {

	private Long code;
	private String desc;
	private int taskid;
	private List<TaskCompleteInfoVo> list;

	public GetNewTaskVo() {
		super();
	}

	public GetNewTaskVo(Long code, String desc, int taskid,
			List<TaskCompleteInfoVo> list) {
		super();
		this.code = code;
		this.desc = desc;
		this.taskid = taskid;
		this.list = list;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getTaskid() {
		return taskid;
	}

	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}

	public List<TaskCompleteInfoVo> getList() {
		return list;
	}

	public void setList(List<TaskCompleteInfoVo> list) {
		this.list = list;
	}

}
