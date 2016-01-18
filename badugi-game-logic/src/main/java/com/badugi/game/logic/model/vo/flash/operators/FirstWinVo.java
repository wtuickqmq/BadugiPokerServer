package com.badugi.game.logic.model.vo.flash.operators;

/**
 * 第一次赢钱返回值
 * 
 * @version 1.0
 */
public class FirstWinVo {

	private String cmd;
	/**
	 * 返回码
	 */
	private Long code;

	private Integer chips;

	public FirstWinVo() {
		super();
	}

	public FirstWinVo(String cmd, Long code, Integer chips) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.chips = chips;
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

	public Integer getChips() {
		return chips;
	}

	public void setChips(Integer chips) {
		this.chips = chips;
	}

}
