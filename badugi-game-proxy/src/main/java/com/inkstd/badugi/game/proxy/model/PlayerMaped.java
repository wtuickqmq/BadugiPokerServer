package com.inkstd.badugi.game.proxy.model;

import java.util.Map;

import com.google.common.collect.Maps;

public class PlayerMaped {

	private Map<String, String> ch2pid;

	private Map<String, String> pid2ch;

	public PlayerMaped() {
		super();
		this.ch2pid = Maps.newConcurrentMap();
		this.pid2ch = Maps.newConcurrentMap();
		
		
	}

	public PlayerMaped(Map<String, String> ch2pid, Map<String, String> pid2ch) {
		super();
		this.ch2pid = ch2pid;
		this.pid2ch = pid2ch;
	}

	public Map<String, String> getCh2pid() {
		return ch2pid;
	}

	public void setCh2pid(Map<String, String> ch2pid) {
		this.ch2pid = ch2pid;
	}

	public Map<String, String> getPid2ch() {
		return pid2ch;
	}

	public void setPid2ch(Map<String, String> pid2ch) {
		this.pid2ch = pid2ch;
	}

}
