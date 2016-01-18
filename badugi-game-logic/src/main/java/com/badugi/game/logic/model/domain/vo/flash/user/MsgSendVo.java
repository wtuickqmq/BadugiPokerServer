package com.badugi.game.logic.model.domain.vo.flash.user;

/**
 * 消息、公告、用户反馈返回给flash
 */
public class MsgSendVo {

	private String cmd;
	private long code;
	private String title;
	private Integer msgType;//1 小游戏提示广播  2 小游戏中奖广播
	private String content;
	private String time;

	public MsgSendVo() {
		super();
	}
	
	

	public MsgSendVo(String cmd, Integer msgType,
			String content, String time) {
		super();
		this.cmd = cmd;
		this.msgType = msgType;
		this.content = content;
		this.time = time;
	}



	public MsgSendVo(String cmd, String content,String time) {
		super();
		this.cmd = cmd;
		this.content = content;
		this.time = time;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}



	/**
	 * @return msgType
	 */
	public Integer getMsgType() {
		return msgType;
	}



	/**
	 * @param msgType 要设置的 msgType
	 */
	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	
	
	

}
