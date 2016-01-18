package com.badugi.game.logic.model.vo.api.task;

import java.util.ArrayList;
import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;
import com.badugi.game.logic.model.vo.config.TaskRewardVo;

/**
 * 场任务返回数据
 * 
 * @author amin
 */
public class RoomTasksResultVo extends ResultVo {

	private double sb;
	private double bb;
	private int isag;
	private TaskRewardVo prize = null;
	private List<RoomTasksDetail> tlist = null;

	public RoomTasksResultVo() {
		super();
	}

	public RoomTasksResultVo(double sb, double bb, int isag) {
		super();
		this.sb = sb;
		this.bb = bb;
		this.isag = isag;
		// 默认初始化
		this.prize = new TaskRewardVo();
		this.tlist = new ArrayList<RoomTasksDetail>();
	}

	public RoomTasksResultVo(double sb, double bb, int isag,
			TaskRewardVo prize, List<RoomTasksDetail> tlist) {
		super();
		this.sb = sb;
		this.bb = bb;
		this.isag = isag;
		this.prize = prize;
		this.tlist = tlist;
	}
	
	public double getSb() {
		return sb;
	}

	public void setSb(double sb) {
		this.sb = sb;
	}

	public double getBb() {
		return bb;
	}

	public void setBb(double bb) {
		this.bb = bb;
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

	public List<RoomTasksDetail> getTlist() {
		return tlist;
	}

	public void setTlist(List<RoomTasksDetail> tlist) {
		this.tlist = tlist;
	}

}
