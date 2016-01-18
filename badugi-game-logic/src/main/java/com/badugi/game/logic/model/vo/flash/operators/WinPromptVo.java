package com.badugi.game.logic.model.vo.flash.operators;

public class WinPromptVo {

	/**
	 * 返回码
	 */
	private String cmd;
	private Long code;

	private Integer rid;
	private Long chips;

	public WinPromptVo(String cmd, Long code) {
		super();
		this.cmd = cmd;
		this.code = code;
	}

	public WinPromptVo(String cmd, Long code, Integer rid, Long chips) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.rid = rid;
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

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Long getChips() {
		return chips;
	}

	public void setChips(Long chips) {
		this.chips = chips;
	}

}
