package com.badugi.game.logic.model.vo.config;

public class ThbPromptVo {

	private Integer msgId;
	private Long toFbid;
	private String toFbName;
	public Integer getMsgId() {
		return msgId;
	}
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	public Long getToFbid() {
		return toFbid;
	}
	public void setToFbid(Long toFbid) {
		this.toFbid = toFbid;
	}
	public String getToFbName() {
		return toFbName;
	}
	public void setToFbName(String toFbName) {
		this.toFbName = toFbName;
	}
	public ThbPromptVo(Integer msgId, Long toFbid, String toFbName) {
		super();
		this.msgId = msgId;
		this.toFbid = toFbid;
		this.toFbName = toFbName;
	}
	
	
}
