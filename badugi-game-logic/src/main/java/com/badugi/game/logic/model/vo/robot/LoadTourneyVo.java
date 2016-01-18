package com.badugi.game.logic.model.vo.robot;

/**
 * 新增比赛机器人通知VO
 * @author amin
 */
public class LoadTourneyVo extends RobotVo {

	private String cmd;
	private String tid;// 比赛编号
	private String tn;// 比赛名称
	private int uc;// 比赛容纳人数
	private int tc1;// 比赛一级分类
	private int tc2;// 比赛二级分类
	private int tc3;// 比赛三级分类
	private int tp;// 比赛类型
	private double mc;// 报名费
	private long ot;// 比赛开放时间
	private long st;// 比赛开始时间

	public LoadTourneyVo() {
		super();
	}

	public LoadTourneyVo(String cmd, String tid, String tn, int uc, int tc1,
			int tc2, int tc3, int tp, double mc, long ot, long st) {
		super();
		this.cmd = cmd;
		this.tid = tid;
		this.tn = tn;
		this.uc = uc;
		this.tc1 = tc1;
		this.tc2 = tc2;
		this.tc3 = tc3;
		this.tp = tp;
		this.mc = mc;
		this.ot = ot;
		this.st = st;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTn() {
		return tn;
	}

	public void setTn(String tn) {
		this.tn = tn;
	}

	public int getUc() {
		return uc;
	}

	public void setUc(int uc) {
		this.uc = uc;
	}

	public int getTc1() {
		return tc1;
	}

	public void setTc1(int tc1) {
		this.tc1 = tc1;
	}

	public int getTc2() {
		return tc2;
	}

	public void setTc2(int tc2) {
		this.tc2 = tc2;
	}

	public int getTc3() {
		return tc3;
	}

	public void setTc3(int tc3) {
		this.tc3 = tc3;
	}
	
	public int getTp() {
		return tp;
	}
	
	public void setTp(int tp) {
		this.tp = tp;
	}
	
	public double getMc() {
		return mc;
	}
	
	public void setMc(double mc) {
		this.mc = mc;
	}

	public long getOt() {
		return ot;
	}

	public void setOt(long ot) {
		this.ot = ot;
	}

	public long getSt() {
		return st;
	}

	public void setSt(long st) {
		this.st = st;
	}
	
}
