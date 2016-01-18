package com.badugi.game.logic.model.vo.api.task;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 每日任务返回值
 * 
 * @author amin
 */
public class DayTasksVo extends ResultVo {

	private Long code;
	private String desc;
	private int ac;
	private int afc;
	private List<DayTasksDetail> list;

	public DayTasksVo() {
		super();
	}

	public DayTasksVo(Long code, String desc, int ac, int afc,
			List<DayTasksDetail> list) {
		super();
		this.code = code;
		this.desc = desc;
		this.ac = ac;
		this.afc = afc;
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

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

	public int getAfc() {
		return afc;
	}

	public void setAfc(int afc) {
		this.afc = afc;
	}

	public List<DayTasksDetail> getList() {
		return list;
	}

	public void setList(List<DayTasksDetail> list) {
		this.list = list;
	}

}
