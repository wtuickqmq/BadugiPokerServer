package com.badugi.game.logic.model.vo.flash.operators;

import java.util.List;

import com.badugi.game.logic.model.vo.config.TaskRewardVo;

/**
 * 新手礼包返回值
 * 
 * @author amin
 */
public class NewUserBoxResultVo {

	private String cmd;
	private Long code;
	private int step;
	private TaskRewardVo prize;
	private List<NewUserBoxDetail> list;
	private int ishc;// 是否继续按钮
	private int cc;// 继续往下的顺序(2:玩一局3:发送邀请)

	public NewUserBoxResultVo() {
		super();
	}

	public NewUserBoxResultVo(String cmd, Long code, int step,
			TaskRewardVo prize, List<NewUserBoxDetail> list, int ishc, int cc) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.step = step;
		this.prize = prize;
		this.list = list;
		this.ishc = ishc;
		this.cc = cc;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public TaskRewardVo getPrize() {
		return prize;
	}

	public void setPrize(TaskRewardVo prize) {
		this.prize = prize;
	}

	public List<NewUserBoxDetail> getList() {
		return list;
	}

	public void setList(List<NewUserBoxDetail> list) {
		this.list = list;
	}

	public int getIshc() {
		return ishc;
	}

	public void setIshc(int ishc) {
		this.ishc = ishc;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

}
