package com.badugi.game.logic.model.vo.flash.task;

/**
 * 场任务完成局数统计flash信息vo
 * 
 * @author amin
 */
public class RoomTaskCompleteVo {

	/**
	 * 返回码
	 */
	private Long code;
	/**
	 * 操作类型
	 */
	private String cmd;
	/**
	 * 小盲
	 */
	private Double sb;
	/**
	 * 大盲
	 */
	private Double bb;
	/**
	 * 已完成
	 */
	private int fc;
	/**
	 * 总数
	 */
	private int ac;

	public RoomTaskCompleteVo() {
		super();
	}

	public RoomTaskCompleteVo(Long code, String cmd, Double sb, Double bb,
			int fc, int ac) {
		super();
		this.code = code;
		this.cmd = cmd;
		this.sb = sb;
		this.bb = bb;
		this.fc = fc;
		this.ac = ac;
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
	
	public Double getSb() {
		return sb;
	}

	public void setSb(Double sb) {
		this.sb = sb;
	}

	public Double getBb() {
		return bb;
	}

	public void setBb(Double bb) {
		this.bb = bb;
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

}
