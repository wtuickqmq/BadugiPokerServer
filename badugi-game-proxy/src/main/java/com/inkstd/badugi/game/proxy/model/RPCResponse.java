package com.inkstd.badugi.game.proxy.model;

import java.util.List;

import com.google.common.collect.Lists;

public class RPCResponse {

	private int isRoute;
	/**
	 * 用户在proxy服务器的渠道id
	 */
	private String channelId;

	/**
	 * 用户的id
	 */
	private String session;

	/**
	 * 返回的数据
	 */
	private String reponse;

	/**
	 * 指定代理服务器
	 */
	private String proxy;

	/**
	 * 是否广播
	 */
	private int broadcast;

	/**
	 * 指定广播的对象
	 */
	private List<String> targets;
	/**
	 * 排除广播的对象
	 */
	private List<String> excludes;

	public RPCResponse() {
		targets = Lists.newArrayList();
		excludes = Lists.newArrayList();
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

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public String getProxy() {
		return proxy;
	}

	public void setProxy(String proxy) {
		this.proxy = proxy;
	}

	public int getBroadcast() {
		return broadcast;
	}

	public void setBroadcast(int broadcast) {
		this.broadcast = broadcast;
	}

	public List<String> getTargets() {
		return targets;
	}

	public void setTargets(List<String> targets) {
		this.targets = targets;
	}

	public List<String> getExcludes() {
		return excludes;
	}

	public void setExcludes(List<String> excludes) {
		this.excludes = excludes;
	}

	public int getIsRoute() {
		return isRoute;
	}

	public void setIsRoute(int isRoute) {
		this.isRoute = isRoute;
	}

}
