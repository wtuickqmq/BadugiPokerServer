package com.badugi.game.logic.model.vo.api.task;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 我的任务结果返回值
 * 
 * @author amin
 */
public class MytasksResultVo extends ResultVo {

	private Long code;
	private String desc;
	private int ecount;// 完成的任务格式
	private int count;// 总任务个数
	private List<MytaskSeriesVo> list;// 阶级任务列表

	public MytasksResultVo() {
		super();
	}

	public MytasksResultVo(Long code, String desc, int ecount, int count,
			List<MytaskSeriesVo> list) {
		super();
		this.code = code;
		this.desc = desc;
		this.ecount = ecount;
		this.count = count;
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

	public int getEcount() {
		return ecount;
	}

	public void setEcount(int ecount) {
		this.ecount = ecount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<MytaskSeriesVo> getList() {
		return list;
	}

	public void setList(List<MytaskSeriesVo> list) {
		this.list = list;
	}

}
