package com.badugi.game.logic.model.vo.flash.operators;

public class GetDecorateResultVo {

	/**
	 * 返回码
	 */
	private String cmd;
	private Long code;

	private int did;// 饰品编号
	private int st;// 状态(1装饰0暂无)

	public GetDecorateResultVo() {
		super();
	}

	public GetDecorateResultVo(String cmd, Long code, int did, int st) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.did = did;
		this.st = st;
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

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getSt() {
		return st;
	}

	public void setSt(int st) {
		this.st = st;
	}

}
