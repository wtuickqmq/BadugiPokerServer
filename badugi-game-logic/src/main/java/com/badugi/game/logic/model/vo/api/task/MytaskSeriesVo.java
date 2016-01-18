package com.badugi.game.logic.model.vo.api.task;

import java.util.ArrayList;
import java.util.List;

public class MytaskSeriesVo {

	private int type;// 阶段(1,2,3,4)
	private int isj;// 是否完成(1:是0:否)
	private String prize;// 奖品名称
	private List<MytaskDetailVo> tlist = new ArrayList<MytaskDetailVo>();// 详细任务

	public MytaskSeriesVo() {
		super();
	}
	
	public MytaskSeriesVo(int type, int isj, String prize) {
		super();
		this.type = type;
		this.isj = isj;
		this.prize = prize;
	}

	public MytaskSeriesVo(int type, int isj, String prize,
			List<MytaskDetailVo> tlist) {
		super();
		this.type = type;
		this.isj = isj;
		this.prize = prize;
		this.tlist = tlist;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getIsj() {
		return isj;
	}

	public void setIsj(int isj) {
		this.isj = isj;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public List<MytaskDetailVo> getTlist() {
		return tlist;
	}

	public void setTlist(List<MytaskDetailVo> tlist) {
		this.tlist = tlist;
	}

}
