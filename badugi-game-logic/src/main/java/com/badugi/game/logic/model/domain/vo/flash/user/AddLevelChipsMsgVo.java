package com.badugi.game.logic.model.domain.vo.flash.user;

import com.badugi.game.logic.model.vo.config.TaskRewardVo;

/**
 * 等级升级获得筹码的返回值
 * 
 * @author amin
 */
public class AddLevelChipsMsgVo {

	/**
	 * 返回码
	 */
	private Long code;
	/**
	 * 操作类型
	 */
	private String cmd;

	/**
	 * 新等级
	 */
	private int el;
	/**
	 * 能获得奖励
	 */
	private TaskRewardVo prize;
	/**
	 * 解锁的小盲
	 */
	private double ulsb;
	/**
	 * 解锁的大盲
	 */
	private double ulbb;
	/**
	 * 下一次的等级
	 */
	private int nel;
	/**
	 * 下一次等级能获得奖励
	 */
	private TaskRewardVo nprize;

	public AddLevelChipsMsgVo() {
		super();
	}

	public AddLevelChipsMsgVo(int el, TaskRewardVo prize, double ulsb, double ulbb,
			int nel, TaskRewardVo nprize) {
		super();
		this.el = el;
		this.prize = prize;
		this.ulsb = ulsb;
		this.ulbb = ulbb;
		this.nel = nel;
		this.nprize = nprize;
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

	public int getEl() {
		return el;
	}

	public void setEl(int el) {
		this.el = el;
	}

	public TaskRewardVo getPrize() {
		return prize;
	}

	public void setPrize(TaskRewardVo prize) {
		this.prize = prize;
	}

	public double getUlsb() {
		return ulsb;
	}

	public void setUlsb(double ulsb) {
		this.ulsb = ulsb;
	}

	public double getUlbb() {
		return ulbb;
	}

	public void setUlbb(double ulbb) {
		this.ulbb = ulbb;
	}

	public int getNel() {
		return nel;
	}

	public void setNel(int nel) {
		this.nel = nel;
	}

	public TaskRewardVo getNprize() {
		return nprize;
	}

	public void setNprize(TaskRewardVo nprize) {
		this.nprize = nprize;
	}

}
