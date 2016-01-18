package com.badugi.game.logic.model.vo.flash.match;

import java.util.ArrayList;
import java.util.List;

/**
 * 赛事详情返回值
 * @author amin
 */
@SuppressWarnings("rawtypes")
public class MatchPlayDetailVo {

	private String cmd;// 操作类型
	private int mi;// 赛事编号
	private String mn;// 赛事名称
	private int c;// 参数人数
	private int ns;// 状态(0开放登记 1进行中 2人数已满 3已结束)
	private int ms;// 我的参赛状态(1已参加 0 未参加)
	private double jfc;// 参赛费用
	private double fwc;// 服务费
	private int mjc;// 参赛最多人数
	private String bt;// 开始时间
	private String et;// 结束时间
	private int tl;// 已开始时间
	private int bl;// 当前盲注等级
	private double bb;// 当前大盲
	private double sb;// 当前小盲
	private double an;//底注
	private int nbt;// 下一级涨盲时间
	private double nan;//下级底注
	private double nbb;// 下一级比赛大盲
	private double nsb;// 下一级比赛小盲
	private int nrc;// 当前剩余比赛人数
	private int ntc;// 当前比赛还剩牌桌数
	private double nmm;// 当前赛事最大筹码
	private double nsm;// 当前赛事最小筹码
	private double nvm;// 当前赛事平均筹码
	private double aam;// 奖池总筹码
	private int mc;// 钱圈人数
	private int gt;// 坐满就玩/锦标赛
	private String tp;// 比赛类型
	private List mlist;// 钱圈
	private int mcfg;//新钱圈奖品id
	
	private double rc;//赏金
	private double arm;//总赏金
	private int sjc;//最少人数
	private String at;//报名截止时间
	private int sat;//离报名结束时长
	private int sbt;//离比赛开始时长
	private boolean isr;//是否处于休息时间
	private int rt;//休息时间
	private String ijr;//参加比赛的房间编号
	private int ihe;//奖品是否包含实物
	private int surc;//离比赛还剩多少人开赛
	private List<String> changedvars = new ArrayList<String>();//变动字段
	
	private int uct;//用户自定义类型
	private int cuid;//比赛配置id
	private double ichips;//比赛初始金额

	public MatchPlayDetailVo() {
		super();
		this.cmd = "MatchPlayDetail";
	}
	
	/**
	 * 开放登记
	 */
	public MatchPlayDetailVo(String cmd, int mi, String mn, int c, int ns,
			int ms, double jfc, double fwc, int mjc, double aam, int mc,
			String tp, int gt,int surc, List mlist,double ichips,int mcfg) {
		super();
		this.cmd = cmd;
		this.mi = mi;
		this.mn = mn;
		this.c = c;
		this.ns = ns;
		this.ms = ms;
		this.jfc = jfc;
		this.fwc = fwc;
		this.mjc = mjc;
		this.aam = aam;
		this.mc = mc;
		this.tp = tp;
		this.gt = gt;
		this.surc = surc;
		this.mlist = mlist;
		this.ichips=ichips;
		this.mcfg=mcfg;
	}
	
	/**
	 * 登记结束
	 */
	public MatchPlayDetailVo(String cmd, int mi, String mn, int c, int ns,
			int ms, double jfc, double fwc, int mjc, String bt, double aam, int mc,
			String tp, int gt, List mlist,double ichips,int mcfg) {
		super();
		this.cmd = cmd;
		this.mi = mi;
		this.mn = mn;
		this.c = c;
		this.ns = ns;
		this.ms = ms;
		this.jfc = jfc;
		this.fwc = fwc;
		this.mjc = mjc;
		this.bt = bt;
		this.aam = aam;
		this.mc = mc;
		this.tp = tp;
		this.gt = gt;
		this.mlist = mlist;
		this.ichips=ichips;
		this.mcfg=mcfg;
	}
	
	/**
	 * 进行中
	 */
	public MatchPlayDetailVo(String cmd, int mi, String mn, int c, int ns,
			int ms, double jfc, double fwc, int mjc, String bt, int ntc,
			int tl, int bl, double bb, double sb, double an, int nbt, double nan,
			double nbb, double nsb, int nrc, double nmm, double nsm, double aam, 
			double nvm, int mc, String tp, int gt, List mlist,double ichips,int mcfg) {
		super();
		this.cmd = cmd;
		this.mi = mi;
		this.mn = mn;
		this.c = c;
		this.ns = ns;
		this.ms = ms;
		this.jfc = jfc;
		this.fwc = fwc;
		this.mjc = mjc;
		this.bt = bt;
		this.ntc = ntc;
		this.tl = tl;
		this.bl = bl;
		this.bb = bb;
		this.sb = sb;
		this.an = an;
		this.nbt = nbt;
		this.nan = nan;
		this.nbb = nbb;
		this.nsb = nsb;
		this.nrc = nrc;
		this.nmm = nmm;
		this.nsm = nsm;
		this.nvm = nvm;
		this.aam = aam;
		this.mc = mc;
		this.tp = tp;
		this.gt = gt;
		this.mlist = mlist;
		this.ichips=ichips;
		this.mcfg=mcfg;
	}
	
	/**
	 * 已结束
	 */
	public MatchPlayDetailVo(String cmd, int mi, String mn, int c, int ns,
			double jfc, double fwc, int mjc, String bt, String et, int mc,
			String tp, int gt, List mlist,double ichips,int mcfg) {
		super();
		this.cmd = cmd;
		this.mi = mi;
		this.mn = mn;
		this.c = c;
		this.ns = ns;
		this.jfc = jfc;
		this.fwc = fwc;
		this.mjc = mjc;
		this.bt = bt;
		this.et = et;
		this.mc = mc;
		this.tp = tp;
		this.gt = gt;
		this.mlist = mlist;
		this.ichips=ichips;
		this.mcfg=mcfg;
	}
	
	/**
	 * must
	 */
	public MatchPlayDetailVo(String cmd, int mi, String mn, int ns,double ichips,int mcfg) {
		super();
		this.cmd = cmd;
		this.mi = mi;
		this.mn = mn;
		this.ns = ns;
		this.ichips=ichips;
		this.mcfg=mcfg;
	}

	/**
	 * full 
	 */
	public MatchPlayDetailVo(String cmd, int mi, String mn, int c, int ns,
			int ms, double jfc, double fwc, int mjc, String bt, String et,
			int tl, int bl, double bb, double sb, int nbt, double nbb,
			double nsb, int nrc, double nmm, double nsm, double aam, double nvm,
			int mc, String tp, int gt, List mlist,double ichips,int mcfg) {
		super();
		this.cmd = cmd;
		this.mi = mi;
		this.mn = mn;
		this.c = c;
		this.ns = ns;
		this.ms = ms;
		this.jfc = jfc;
		this.fwc = fwc;
		this.mjc = mjc;
		this.bt = bt;
		this.et = et;
		this.tl = tl;
		this.bl = bl;
		this.bb = bb;
		this.sb = sb;
		this.nbt = nbt;
		this.nbb = nbb;
		this.nsb = nsb;
		this.nrc = nrc;
		this.nmm = nmm;
		this.nsm = nsm;
		this.nvm = nvm;
		this.aam = aam;
		this.mc = mc;
		this.tp = tp;
		this.gt = gt;
		this.mlist = mlist;
		this.ichips=ichips;
		this.mcfg=mcfg;
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

	public int getMjc() {
		return mjc;
	}

	public void setMjc(int mjc) {
		this.mjc = mjc;
	}

	public String getBt() {
		return bt;
	}

	public void setBt(String bt) {
		this.bt = bt;
	}

	public String getEt() {
		return et;
	}

	public void setEt(String et) {
		this.et = et;
	}

	public int getTl() {
		return tl;
	}

	public void setTl(int tl) {
		this.tl = tl;
	}

	public int getBl() {
		return bl;
	}

	public void setBl(int bl) {
		this.bl = bl;
	}

	public double getBb() {
		return bb;
	}

	public void setBb(double bb) {
		this.bb = bb;
	}

	public double getSb() {
		return sb;
	}

	public void setSb(double sb) {
		this.sb = sb;
	}
	
	public double getAn() {
		return an;
	}

	public void setAn(double an) {
		this.an = an;
	}

	public double getNan() {
		return nan;
	}

	public void setNan(double nan) {
		this.nan = nan;
	}

	public int getNbt() {
		return nbt;
	}

	public void setNbt(int nbt) {
		this.nbt = nbt;
	}

	public double getNbb() {
		return nbb;
	}

	public void setNbb(double nbb) {
		this.nbb = nbb;
	}

	public double getNsb() {
		return nsb;
	}

	public void setNsb(double nsb) {
		this.nsb = nsb;
	}

	public int getNrc() {
		return nrc;
	}

	public void setNrc(int nrc) {
		this.nrc = nrc;
	}
	
	public int getNtc() {
		return ntc;
	}

	public void setNtc(int ntc) {
		this.ntc = ntc;
	}

	public double getNmm() {
		return nmm;
	}

	public void setNmm(double nmm) {
		this.nmm = nmm;
	}

	public double getNsm() {
		return nsm;
	}

	public void setNsm(double nsm) {
		this.nsm = nsm;
	}
	
	public double getNvm() {
		return nvm;
	}

	public void setNvm(double nvm) {
		this.nvm = nvm;
	}

	public double getAam() {
		return aam;
	}

	public void setAam(double aam) {
		this.aam = aam;
	}

	public int getMc() {
		return mc;
	}

	public void setMc(int mc) {
		this.mc = mc;
	}

	public String getTp() {
		return tp;
	}

	public void setTp(String tp) {
		this.tp = tp;
	}
	
	public int getGt() {
		return gt;
	}

	public void setGt(int gt) {
		this.gt = gt;
	}

	public List getMlist() {
		return mlist;
	}

	public void setMlist(List mlist) {
		this.mlist = mlist;
	}

	public double getRc() {
		return rc;
	}

	public void setRc(double rc) {
		this.rc = rc;
	}

	public double getArm() {
		return arm;
	}

	public void setArm(double arm) {
		this.arm = arm;
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
	
	public int getSbt() {
		return sbt;
	}

	public void setSbt(int sbt) {
		this.sbt = sbt;
	}

	public boolean getIsr() {
		return isr;
	}

	public void setIsr(boolean isr) {
		this.isr = isr;
	}

	public int getRt() {
		return rt;
	}

	public void setRt(int rt) {
		this.rt = rt;
	}

	public String getIjr() {
		return ijr;
	}

	public void setIjr(String ijr) {
		this.ijr = ijr;
	}
	
	public int getIhe() {
		return ihe;
	}

	public void setIhe(int ihe) {
		this.ihe = ihe;
	}
	
	public int getSurc() {
		return surc;
	}

	public void setSurc(int surc) {
		this.surc = surc;
	}
	
	public int getUct() {
		return uct;
	}

	public void setUct(int uct) {
		this.uct = uct;
	}

	public int getCuid() {
		return cuid;
	}

	public void setCuid(int cuid) {
		this.cuid = cuid;
	}

	public List<String> getChangedvars() {
		return changedvars;
	}

	public void setChangedvars(List<String> changedvars) {
		this.changedvars = changedvars;
	}

	public double getIchips() {
		return ichips;
	}

	public void setIchips(double ichips) {
		this.ichips = ichips;
	}

	public int getMcfg() {
		return mcfg;
	}

	public void setMcfg(int mcfg) {
		this.mcfg = mcfg;
	}
	
	
}
