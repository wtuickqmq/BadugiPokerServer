package com.badugi.game.logic.model.domain.vo.flash.operators;

/**
 * 服务启停vo
 * 
 * @author amin
 */
public class ServerStopVo {

	private boolean stopserver;// 是否停止服务器
	private long begintime;// 启停时间
	private long endtime;// 启停结束时间
	private long gametime;// 游戏开始停止时间
	private long matchtime;// 比赛开始停止时间
	private boolean stopgame;// 停止进入游戏场
	private boolean stopmatch;// 停止进入比赛
	private boolean isnoticeapp;// 是否通知app

	public ServerStopVo() {
		super();
	}

	public ServerStopVo(boolean stopserver, long begintime, long endtime,
			long gametime, long matchtime, boolean stopgame, boolean stopmatch) {
		super();
		this.stopserver = stopserver;
		this.begintime = begintime;
		this.endtime = endtime;
		this.gametime = gametime;
		this.matchtime = matchtime;
		this.stopgame = stopgame;
		this.stopmatch = stopmatch;
	}

	public boolean getStopserver() {
		return stopserver;
	}

	public void setStopserver(boolean stopserver) {
		this.stopserver = stopserver;
	}

	public long getBegintime() {
		return begintime;
	}

	public void setBegintime(long begintime) {
		this.begintime = begintime;
	}

	public long getEndtime() {
		return endtime;
	}

	public void setEndtime(long endtime) {
		this.endtime = endtime;
	}

	public long getGametime() {
		return gametime;
	}

	public void setGametime(long gametime) {
		this.gametime = gametime;
	}

	public long getMatchtime() {
		return matchtime;
	}

	public void setMatchtime(long matchtime) {
		this.matchtime = matchtime;
	}

	public boolean getStopgame() {
		return stopgame;
	}

	public void setStopgame(boolean stopgame) {
		this.stopgame = stopgame;
	}

	public boolean getStopmatch() {
		return stopmatch;
	}

	public void setStopmatch(boolean stopmatch) {
		this.stopmatch = stopmatch;
	}

	public boolean getIsnoticeapp() {
		return isnoticeapp;
	}

	public void setIsnoticeapp(boolean isnoticeapp) {
		this.isnoticeapp = isnoticeapp;
	}

}
