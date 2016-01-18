package com.badugi.game.logic.model.callback;

public class LogicRequest {

	private String clientEvent;

	private String channelId;

	private String session;

	private String data;

	private LogicMap parames;

	public LogicRequest() {
	}

	public LogicRequest(String session, LogicMap parames) {
		super();
		this.session = session;
		this.parames = parames;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public LogicMap getParames() {
		return parames;
	}

	public void setParames(LogicMap parames) {
		this.parames = parames;
	}

	public String getClientEvent() {
		return clientEvent;
	}

	public void setClientEvent(String clientEvent) {
		this.clientEvent = clientEvent;
	}

}
