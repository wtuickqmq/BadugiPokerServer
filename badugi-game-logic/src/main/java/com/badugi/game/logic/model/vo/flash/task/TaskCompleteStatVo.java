package com.badugi.game.logic.model.vo.flash.task;

/**
 * 任务完成局数统计flash信息vo
 * 
 * @author amin
 */
public class TaskCompleteStatVo {

	/**
	 * 返回码
	 */
	private Long code;
	/**
	 * 操作类型
	 */
	private String cmd;
	/**
	 * 已完成
	 */
	private int fc;
	/**
	 * 总数
	 */
	private int ac;
	/**
	 * 是否第一次
	 */
	private int isf;

	public TaskCompleteStatVo() {
		super();
	}

	public TaskCompleteStatVo(Long code, String cmd, int fc, int ac) {
		super();
		this.code = code;
		this.cmd = cmd;
		this.fc = fc;
		this.ac = ac;
	}

	public TaskCompleteStatVo(Long code, String cmd, int fc, int ac, int isf) {
		super();
		this.code = code;
		this.cmd = cmd;
		this.fc = fc;
		this.ac = ac;
		this.isf = isf;
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

	public int getFc() {
		return fc;
	}

	public void setFc(int fc) {
		this.fc = fc;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

	public int getIsf() {
		return isf;
	}

	public void setIsf(int isf) {
		this.isf = isf;
	}

}
