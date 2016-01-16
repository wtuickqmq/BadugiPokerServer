package com.inkstd.badugi.game.proxy.model;

import io.nadron.app.Session;

import org.codehaus.jackson.annotate.JsonIgnore;

public class RpcSessionBuilder implements Cloneable{

	private Object id;

	@JsonIgnore
	private Session session;

	private int weight;
	
	private int balance;

	private String macAddress;

	private String processId;
	
	private String extension;

	public RpcSessionBuilder() {
	}

	public RpcSessionBuilder(Session session) {
		if (null != session) {
			this.session = session;
			this.id = session.getId();
		}
	}

	public RpcSessionBuilder(Session session, int weight) {
		this(session);
		this.weight = weight;
	}

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	@Override
	public RpcSessionBuilder clone() throws CloneNotSupportedException  {
		RpcSessionBuilder rpc = (RpcSessionBuilder) super.clone();
		return rpc;
	}

	@Override
	public String toString() {
		return "RpcSessionBuilder [id=" + id + ", weight=" + weight+ ", balance=" + balance + "]"+" @" + Integer.toHexString(hashCode());
	}
	
}
