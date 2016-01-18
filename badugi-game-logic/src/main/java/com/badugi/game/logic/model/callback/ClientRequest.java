package com.badugi.game.logic.model.callback;


public class ClientRequest {

	private String data;

	private String event;

	private LogicMap parames;

	public ClientRequest() {

	}

	public ClientRequest(String event, LogicMap parames) {
		this.event = event;
		this.parames = parames;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public LogicMap getParames() {
		return parames;
	}

	public void setParames(LogicMap parames) {
		this.parames = parames;
	}

}
