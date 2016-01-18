package com.badugi.game.logic.model.domain.vo.flash.user;

import java.util.List;

import com.badugi.game.logic.model.domain.vo.flash.match.TodayMatchs;



public class LoginVo {

	private String cmd;
	private long code;
	private int isn;
	private int isg;
	private double gchips;
	private long sessionid;
	private String name;
	private int lds;
	private double ldcs;
	private double ldms;
	private int isgmc;//是否已经领取连续登陆奖励
	private int isgbc;//是否可以领取补偿
	private String key;
	private List<TodayMatchs> matchs;

	public LoginVo(String cmd, long code) {
		super();
		this.cmd = cmd;
		this.code = code;
	}

	public LoginVo(String cmd, long code, int isn,String name, List<TodayMatchs> matchs) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.isn = isn;
		
		this.name = name;
		
		this.matchs = matchs;
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

	public int getIsn() {
		return isn;
	}

	public void setIsn(int isn) {
		this.isn = isn;
	}

	public int getIsg() {
		return isg;
	}

	public void setIsg(int isg) {
		this.isg = isg;
	}

	public double getGchips() {
		return gchips;
	}

	public void setGchips(double gchips) {
		this.gchips = gchips;
	}

	public long getSessionid() {
		return sessionid;
	}

	public void setSessionid(long sessionid) {
		this.sessionid = sessionid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLds() {
		return lds;
	}

	public void setLds(int lds) {
		this.lds = lds;
	}

	public double getLdcs() {
		return ldcs;
	}

	public void setLdcs(double ldcs) {
		this.ldcs = ldcs;
	}

	public double getLdms() {
		return ldms;
	}

	public void setLdms(double ldms) {
		this.ldms = ldms;
	}
	
	public int getIsgmc() {
		return isgmc;
	}
	
	public void setIsgmc(int isgmc) {
		this.isgmc = isgmc;
	}
	
	public int getIsgbc() {
		return isgbc;
	}
	
	public void setIsgbc(int isgbc) {
		this.isgbc = isgbc;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}

	public List<TodayMatchs> getMatchs() {
		return matchs;
	}

	public void setMatchs(List<TodayMatchs> matchs) {
		this.matchs = matchs;
	}
	
}
