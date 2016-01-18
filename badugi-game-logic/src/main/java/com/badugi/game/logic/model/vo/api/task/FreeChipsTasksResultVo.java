package com.badugi.game.logic.model.vo.api.task;

import java.util.ArrayList;
import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;
import com.badugi.game.logic.model.vo.config.TaskRewardVo;

/**
 * 免费筹码任务返回数据
 * 
 * @author amin
 */
public class FreeChipsTasksResultVo extends ResultVo {

	private int flag;
	private int ishg;
	private int isag;
	private TaskRewardVo prize = null;
	private List<FreeChipsTasksDetail> tlist = null;

	public FreeChipsTasksResultVo() {
		super();
	}
	
	public FreeChipsTasksResultVo(int flag, int ishg, int isag) {
		super();
		this.flag = flag;
		this.ishg = ishg;
		this.isag = isag;
		//默认初始化
		this.prize = new TaskRewardVo();
		this.tlist = new ArrayList<FreeChipsTasksDetail>();
	}

	public FreeChipsTasksResultVo(int flag, int ishg, int isag, TaskRewardVo prize,
			List<FreeChipsTasksDetail> tlist) {
		super();
		this.flag = flag;
		this.ishg = ishg;
		this.isag = isag;
		this.prize = prize;
		this.tlist = tlist;
	}
	
	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	public int getIshg() {
		return ishg;
	}
	
	public void setIshg(int ishg) {
		this.ishg = ishg;
	}

	public int getIsag() {
		return isag;
	}

	public void setIsag(int isag) {
		this.isag = isag;
	}

	public TaskRewardVo getPrize() {
		return prize;
	}

	public void setPrize(TaskRewardVo prize) {
		this.prize = prize;
	}

	public List<FreeChipsTasksDetail> getTlist() {
		return tlist;
	}

	public void setTlist(List<FreeChipsTasksDetail> tlist) {
		this.tlist = tlist;
	}

}
