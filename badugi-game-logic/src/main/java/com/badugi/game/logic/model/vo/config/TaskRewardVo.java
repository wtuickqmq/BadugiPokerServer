package com.badugi.game.logic.model.vo.config;

/**
 * 单任务完成获得奖品配置
 * 
 * @author amin
 * 
 */
public class TaskRewardVo {

	private int f;// 分配类型编号
	private int c;// 筹码
	private int t;// 门票ID
	private int c2;// 筹码2
	private int p;// 特权ID
	private int pc;// 特权次数
	private int m;// 大师分
	private int g;// 金块
	private int pro;// 概率

	public TaskRewardVo() {
		super();
	}

	public TaskRewardVo(int f, int c, int t, int c2) {
		super();
		this.f = f;
		this.c = c;
		this.t = t;
		this.c2 = c2;
	}

	public TaskRewardVo(int f, int c, int c2, int m, int g) {
		super();
		this.f = f;
		this.c = c;
		this.c2 = c2;
		this.m = m;
		this.g = g;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}

	public int getC2() {
		return c2;
	}

	public void setC2(int c2) {
		this.c2 = c2;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getPro() {
		return pro;
	}

	public void setPro(int pro) {
		this.pro = pro;
	}

}
