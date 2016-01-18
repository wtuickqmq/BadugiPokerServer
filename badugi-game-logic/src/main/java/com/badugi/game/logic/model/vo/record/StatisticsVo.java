package com.badugi.game.logic.model.vo.record;

public class StatisticsVo {
	public String dayTime;
	public Integer vists;
	public Integer logins;
	public Integer newLogins;
	public Integer ips;
	
	public StatisticsVo(String dayTime, Integer vists, Integer logins,
			Integer newLogins, Integer ips) {
		super();
		this.dayTime = dayTime;
		this.vists = vists;
		this.logins = logins;
		this.newLogins = newLogins;
		this.ips = ips;
	}
	
	
	
	public StatisticsVo() {
		super();
	}

	public String getDayTime() {
		return dayTime;
	}
	public void setDayTime(String dayTime) {
		this.dayTime = dayTime;
	}
	public Integer getVists() {
		return vists;
	}
	public void setVists(Integer vists) {
		this.vists = vists;
	}
	public Integer getLogins() {
		return logins;
	}
	public void setLogins(Integer logins) {
		this.logins = logins;
	}
	public Integer getNewLogins() {
		return newLogins;
	}
	public void setNewLogins(Integer newLogins) {
		this.newLogins = newLogins;
	}
	public Integer getIps() {
		return ips;
	}
	public void setIps(Integer ips) {
		this.ips = ips;
	}
	
	

}
