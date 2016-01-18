package com.badugi.game.logic.model.callback;


/**
 * 转发给逻辑处理
 * 
 * @author lion
 */
public final class Forward2Logic {

	/**
	 * 客户端请求数据
	 */
	private Object request;

	/**
	 * 客户端的用户id
	 */
	private String session;

	/**
	 * 客户端在的socket链接id (自动生成)
	 */
	private String channelId;

	/**
	 * 客户端的IP
	 */
	private String clinetIp;

	
	public Object getRequest() {
		return request;
	}

	public void setRequest(Object request) {
		this.request = request;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getClinetIp() {
		return clinetIp;
	}

	public void setClinetIp(String clinetIp) {
		this.clinetIp = clinetIp;
	}

}

