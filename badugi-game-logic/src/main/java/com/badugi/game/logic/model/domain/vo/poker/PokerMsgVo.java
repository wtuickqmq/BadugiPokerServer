package com.badugi.game.logic.model.domain.vo.poker;

public class PokerMsgVo {

	/**
	 * 返回码
	 */
	private Long code;
	/**
	 * 操作类型
	 */
	private String cmd;
	private Long uid;
	private Short type;
	private Object msg;

	public PokerMsgVo() {
		super();
	}
	public PokerMsgVo(Long code, String cmd, Long uid, Short type, Object msg) {
		super();
		this.code = code;
		this.cmd = cmd;
		this.uid = uid;
		this.type = type;
		this.msg = msg;
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
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public Short getType() {
		return type;
	}
	public void setType(Short type) {
		this.type = type;
	}
	public Object getMsg() {
		return msg;
	}
	public void setMsg(Object msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "MsgpromptAchievementVo [code=" + code + ", cmd=" + cmd
				+ ", uid=" + uid + ", type=" + type + ", msg=" + msg + "]";
	}

}
