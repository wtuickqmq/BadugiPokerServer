package com.badugi.game.logic.model.vo.flash.match;

import java.util.ArrayList;
import java.util.List;

/**
 * 赛事等待详情返回值
 * 
 * @author amin
 */
@SuppressWarnings("rawtypes")
public class MatchWaitDetailVo {

	private String cmd;// 操作类型
	private int mi;// 赛事编号
	private String mn;// 赛事名称
	private int c;// 参数人数
	private int sjc;// 参赛最少人数
	private int ns;// 状态(0开放登记 1进行中 2人数已满 3已结束)
	private int ms;// 我的参赛状态(1已参加 0 未参加)
	private int ims;// 是否为明星赛(100:明星ko1:普通ko 0: 否)
	private double msrv;// 淘汰获得奖励
	private double ac;// 我的可用额
	private double anm;// 我的门票/积分数量
	private double jfc;// 参赛费用
	private double fwc;// 服务费
	private double rc;// 赏金
	private int surc;// 离比赛还剩多少人开赛
	private String at;// 报名截止时间
	private int sat;// 离报名结束时长
	private int gt;// 坐满就玩/锦标赛
	private String pin;// 第一名奖品图片
	private List mlist = new ArrayList();// 钱圈
	private List plist = new ArrayList();// 支付集合
	private int mauc;// 最大人数
	private int mcfg;//奖品Id
	

	private List<String> changedvars = new ArrayList<String>();// 变动字段

	public MatchWaitDetailVo() {
		super();
	}

	/**
	 * 开放登记
	 */
	public MatchWaitDetailVo(String cmd, int mi, String mn, int c, int ns,
			int ms, double jfc, double fwc, double rc, int sjc, int gt,
			int surc, String pin, List mlist,int mcfg) {
		super();
		this.cmd = cmd;
		this.mi = mi;
		this.mn = mn;
		this.c = c;
		this.ns = ns;
		this.ms = ms;
		this.jfc = jfc;
		this.fwc = fwc;
		this.rc = rc;
		this.sjc = sjc;
		this.gt = gt;
		this.surc = surc;
		this.pin = pin;
		this.mlist = mlist;
		this.mcfg=mcfg;
	}

	/**
	 * 变化时
	 */
	public MatchWaitDetailVo(String cmd, int mi, String mn, int c, int ns) {
		super();
		this.cmd = cmd;
		this.mi = mi;
		this.mn = mn;
		this.c = c;
		this.ns = ns;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public int getMi() {
		return mi;
	}

	public void setMi(int mi) {
		this.mi = mi;
	}

	public String getMn() {
		return mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getSjc() {
		return sjc;
	}

	public void setSjc(int sjc) {
		this.sjc = sjc;
	}

	public String getAt() {
		return at;
	}

	public void setAt(String at) {
		this.at = at;
	}

	public int getSat() {
		return sat;
	}

	public void setSat(int sat) {
		this.sat = sat;
	}

	public int getNs() {
		return ns;
	}

	public void setNs(int ns) {
		this.ns = ns;
	}

	public int getMs() {
		return ms;
	}

	public void setMs(int ms) {
		this.ms = ms;
	}

	public int getIms() {
		return ims;
	}

	public void setIms(int ims) {
		this.ims = ims;
	}

	public double getMsrv() {
		return msrv;
	}

	public void setMsrv(double msrv) {
		this.msrv = msrv;
	}

	public double getAc() {
		return ac;
	}

	public void setAc(double ac) {
		this.ac = ac;
	}

	public double getAnm() {
		return anm;
	}

	public void setAnm(double anm) {
		this.anm = anm;
	}

	public double getJfc() {
		return jfc;
	}

	public void setJfc(double jfc) {
		this.jfc = jfc;
	}

	public double getFwc() {
		return fwc;
	}

	public void setFwc(double fwc) {
		this.fwc = fwc;
	}

	public double getRc() {
		return rc;
	}

	public void setRc(double rc) {
		this.rc = rc;
	}

	public int getSurc() {
		return surc;
	}

	public void setSurc(int surc) {
		this.surc = surc;
	}

	public int getGt() {
		return gt;
	}

	public void setGt(int gt) {
		this.gt = gt;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public List getMlist() {
		return mlist;
	}

	public void setMlist(List mlist) {
		this.mlist = mlist;
	}

	public List getPlist() {
		return plist;
	}

	public void setPlist(List plist) {
		this.plist = plist;
	}

	public List<String> getChangedvars() {
		return changedvars;
	}

	public void setChangedvars(List<String> changedvars) {
		this.changedvars = changedvars;
	}

	public int getMauc() {
		return mauc;
	}

	public void setMauc(int mauc) {
		this.mauc = mauc;
	}

	public int getMcfg() {
		return mcfg;
	}

	public void setMcfg(int mcfg) {
		this.mcfg = mcfg;
	}
	
	

}
