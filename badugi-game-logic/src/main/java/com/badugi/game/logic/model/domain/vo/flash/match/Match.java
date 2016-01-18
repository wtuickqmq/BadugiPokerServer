package com.badugi.game.logic.model.domain.vo.flash.match;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badugi.game.logic.model.cache.LocalMatchCache;

import java.io.Serializable;
import java.text.SimpleDateFormat;


/*****
 * 比赛信息
 * @author weijie
 *
 */
@SuppressWarnings("rawtypes")
public class Match implements java.io.Serializable {
	
	/**
	 * 开放登记
	 */
	public static final int MATCH_STATUS_OPEN = 0;
	/****
	 * 正在进行
	 */
	public static final int MATCH_STATUS_DOING = 1;
	/****
	 * 人数已满
	 */
	public static final int MATCH_STATUS_FULL = 2;
	/*****
	 * 比赛结束
	 */
	public static final int MATCH_STATUS_OVER = 3;
	
	/*****
	 * 报名截止
	 */
	public static final int MATCH_STATUS_ENDREGISTER = 4;
	
	
	/***
	 * 比赛编号
	 */
	private Integer mi;
	/****
	 * 比赛名字
	 */
	private String mn;
	/*****
	 *比赛配置ID  
	 */
	private Integer confId;
	/****
	 * 速度
	 */
	private String sp;
	/****
	 * 参赛金额
	 */
	private double ma;
	/****
	 * 状态  0开放登记 1进行中 2人数已满 3已结束
	 */
	private int st;
	/****
	 * 牌桌人数
	 */
	private int mc;
	/****
	 * 当前比赛人数
	 */
	private int mnc;
	
	/**
	 * 一级分类
	 */
	private int gt;
	
	/**
	 * 处理后的一级类型
	 */
	private int egt;

	/***
	 * 比赛类型
	 */
	private int mt;
	
	/****
	 * 比赛等级
	 */
	private int ml;
	/**
	 * 开放登记时间
	 */
	private Date bt;
	/**
	 * 登记结束时间
	 */
	private Date spt;
	/****
	 * 比赛开始时间
	 */
	private Date stt;
	/**
	 * 结束时间
	 */
	private Date ett;
	/***
	 * 盲注等级时间配置
	 */
	private Long bti;
	/****
	 * 多少分钟升级一次
	 */
	private int cs;
	/****
	 * 当前盲注等级
	 */
	private Long nil;
	
	/****
	 * 当前大盲注
	 */
	private Double nbb;
	/***
	 * 当前小盲注
	 */
	private Double nsb;
	/****
	 * 当前底注
	 */
	private Double nat;
	/**
	 * 比赛桌(单桌多桌)
	 */
	private int tt;
	/**
	 * 是否参加 (1是 0 否)
	 */
	private int it;
	/**
	 * 参赛费用
	 */
	private double jfc;
	/**
	 * 服务费
	 */
	private double fwc;
	/**
	 * 赏金(当且仅当只有一种赏金的时候)
	 */
	private double rc;
	/**
	 * 第一名奖品图片名称
	 */
	private String toprcfg;
	/**
	 * 比赛类型名称
	 */
	private String tn;
	/****
	 * 比赛类型编号
	 */
	private int ti;
	
	/**
	 * 预留空比赛
	 */
	private int et;
	/**
	 * 显示已结束牌桌
	 */
	private int ct;
	/**
	 * 钱圈人数
	 */
	private int qc;
	/**
	 * 结束方式
	 */
	private int luc;
	/**
	 * 钱圈
	 */
	//private List mlist;
	/**
	 * 多桌时钱圈
	 */
	private List mslist;
	/****
	 * 初始筹码
	 */
	private double ic;
	
	/****
	 * 最少人数
	 */
	private int miuc;
	
	/*****
	 * 最大人数
	 */
	private int mauc;

	/****
	 * 每小时第几分钟休息
	 */
	private int mph;
	
	/****
	 * 休息时长(分钟)
	 */
	private int mor;
	
	/**
	 * 比赛门票ID
	 */
	private int tid;
	
	/**
	 * 主要比赛奖品图片名称
	 */
	private String pin;
	/**
	 * 钱圈配置类型
	 */
	private int mty;
	/**
	 * VIP积分分配方案
	 */
	private MatchFixPointsVo fixPoints;
	
	/**
	 * 用户自定义分类
	 */
	private int uct;
	
	/**
	 * 是否通知应用服务器初始化牌桌(大厅维护)
	 */
	private boolean isNoticeAppBegin;
	/**
	 * 比赛是否已经到结束(大厅维护)
	 */
	private boolean isEnough;
	/**
	 * 是否开启
	 */
	private boolean isOn = true;
	
	/**
	 * 第一名能获得的奖品
	 */
	private String prize;
	/**
	 * 用户是否还可登记取消比赛
	 */
	private boolean isexec = true;
	/**
	 * wtu.edit
	 * 密码房密码
	 */
	private String pwd;
	/**
	 * 
	 * 修改原钱圈奖励配置，设为奖励ID
	 */
	private Integer mcf;
	/**
	 * 
	 * 服务器id
	 */
	private String matchserverid;

	/**
	 * 
	 * 服务器addon盲注级别
	 */
	private Integer addonLv;

	/**
	 * 
	 * 服务器addon时间
	 */
	private Integer addonIntervalTime;

	/***
	 * 比赛被展示出的开始时间
	 */
	private String showBeginTime;
	
	/***
	 * 比赛被展示出的结束时间
	 */
	private String showEndTime;

	//wtu.edit
	
	public Match(){}
	
	
	public Match(Integer mi, String mn, String sp, double ma, int st, int mc,
			int mnc, int mt, int ml) {
		
		super();
		this.mi = mi;
		this.mn = mn;
		this.sp = sp;
		this.ma = ma;
		this.st = st;
		this.mc = mc;
		this.mnc = mnc;
		this.mt = mt;
		this.ml = ml;
	}

	public String getMatchServerId() {
		return matchserverid;
	}

	public void setMatchServerId(String serverid) {
		this.matchserverid = serverid;
	}
	
	public Integer getAddonLv() {
		return this.addonLv;
	}

	public void setAddonLv(Integer addonLv) {
		this.addonLv = addonLv;
	}
	
	public Integer getaddonIntervalTime() {
		return this.addonIntervalTime;
	}

	public void setaddonIntervalTime(Integer addonIntervalTime) {
		this.addonIntervalTime = addonIntervalTime;
	}

	public Integer getMi() {
		return mi;
	}

	public void setMi(Integer mi) {
		this.mi = mi;
	}

	public String getMn() {
		return mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}

	public String getSp() {
		return sp;
	}

	public void setSp(String sp) {
		this.sp = sp;
	}

	public double getMa() {
		return ma;
	}

	public void setMa(double ma) {
		this.ma = ma;
	}

	public int getSt() {
		return st;
	}

	public void setSt(int st) {
		this.st = st;
	}

	public int getMc() {
		return mc;
	}

	public void setMc(int mc) {
		this.mc = mc;
	}

	public int getMnc() {
		return mnc;
	}

	public void setMnc(int mnc) {
		this.mnc = mnc;
	}
	
	public int getGt() {
		return gt;
	}

	public void setGt(int gt) {
		this.gt = gt;
	}
	
	public int getEgt() {
		return egt;
	}

	public void setEgt(int egt) {
		this.egt = egt;
	}

	public int getMt() {
		return mt;
	}

	public void setMt(int mt) {
		this.mt = mt;
	}

	public int getMl() {
		return ml;
	}

	public void setMl(int ml) {
		this.ml = ml;
	}
	
	public Long getNil() {
		return nil;
	}

	public void setNil(Long nil) {
		this.nil = nil;
	}
	
	public Date getBt() {
		return bt;
	}

	public void setBt(Date bt) {
		this.bt = bt;
	}

	public Date getSpt() {
		return spt;
	}

	public void setSpt(Date spt) {
		this.spt = spt;
	}

	public Date getStt() {
		return stt;
	}

	public void setStt(Date stt) {
		this.stt = stt;
	}
	
	public Date getEtt() {
		return ett;
	}

	public void setEtt(Date ett) {
		this.ett = ett;
	}

	public Long getBti() {
		return bti;
	}

	public void setBti(Long bti) {
		this.bti = bti;
	}

	public int getCs() {
		return cs;
	}

	public void setCs(int cs) {
		this.cs = cs;
	}

	public Double getNbb() {
		return nbb;
	}

	public void setNbb(Double nbb) {
		this.nbb = nbb;
	}

	public Double getNsb() {
		return nsb;
	}

	public void setNsb(Double nsb) {
		this.nsb = nsb;
	}

	public Double getNat() {
		return nat;
	}

	public void setNat(Double nat) {
		this.nat = nat;
	}
	
	public int getIt() {
		return it;
	}

	public void setIt(int it) {
		this.it = it;
	}
	
	public String getTn() {
		return tn;
	}

	public void setTn(String tn) {
		this.tn = tn;
	}

	public int getTi() {
		return ti;
	}

	public void setTi(int ti) {
		this.ti = ti;
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
	
	public int getTt() {
		return tt;
	}

	public void setTt(int tt) {
		this.tt = tt;
	}

	public double getRc() {
		return rc;
	}

	public void setRc(double rc) {
		this.rc = rc;
	}

	public int getQc() {
		return qc;
	}

	public void setQc(int qc) {
		this.qc = qc;
	}

	public Integer getConfId() {
		return confId;
	}

	public void setConfId(Integer confId) {
		this.confId = confId;
	}
	
	public int getLuc() {
		return luc;
	}

	public void setLuc(int luc) {
		this.luc = luc;
	}
	

	public int getEt() {
		return et;
	}

	public void setEt(int et) {
		this.et = et;
	}

	public int getCt() {
		return ct;
	}

	public void setCt(int ct) {
		this.ct = ct;
	}

	
	
	public List getMslist() {
		return mslist;
	}

	public void setMslist(List mslist) {
		this.mslist = mslist;
	}

	public double getIc() {
		return ic;
	}

	public void setIc(double ic) {
		this.ic = ic;
	}
	
	public int getMty() {
		return mty;
	}

	public void setMty(int mty) {
		this.mty = mty;
	}
	
	public MatchFixPointsVo getFixPoints() {
		return fixPoints;
	}

	public void setFixPoints(MatchFixPointsVo fixPoints) {
		this.fixPoints = fixPoints;
	}
	
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public int getUct() {
		return uct;
	}

	public void setUct(int uct) {
		this.uct = uct;
	}

	public int getMiuc() {
		return miuc;
	}

	public void setMiuc(int miuc) {
		this.miuc = miuc;
	}

	public int getMauc() {
		return mauc;
	}

	public void setMauc(int mauc) {
		this.mauc = mauc;
	}

	public int getMph() {
		return mph;
	}

	public void setMph(int mph) {
		this.mph = mph;
	}

	public int getMor() {
		return mor;
	}

	public void setMor(int mor) {
		this.mor = mor;
	}
	
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public boolean getIsNoticeAppBegin() {
		return isNoticeAppBegin;
	}

	public void setIsNoticeAppBegin(boolean isNoticeAppBegin) {
		this.isNoticeAppBegin = isNoticeAppBegin;
	}
	
	public boolean getIsEnough() {
		return isEnough;
	}

	public void setIsEnough(boolean isEnough) {
		this.isEnough = isEnough;
	}
	
	public boolean getIsOn() {
		return isOn;
	}
	public void setIsOn(boolean isOn) {
		this.isOn = isOn;
	}
	
	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}
	
	public String getToprcfg() {
		return toprcfg;
	}
	
	public void setToprcfg(String toprcfg) {
		this.toprcfg = toprcfg;
	}
	
	public boolean isIsexec() {
		return isexec;
	}

	public void setIsexec(boolean isexec) {
		this.isexec = isexec;
	}
	


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	public Integer getMcf() {
		return mcf;
	}

	
	public void setMcf(Integer mcf) {
		this.mcf = mcf;
	}
	
	public String getShowBeginTime() {
		return this.showBeginTime;
	}
	
	public Date getShowBeginTimeToDate() {
		SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			return slf.parse(this.showBeginTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void setShowBeginTime(String showBeginTime) {
		this.showBeginTime = showBeginTime;
	}

	public String getShowEndTime() {
		return this.showEndTime;
	}
	
	public Date getShowEndTimeToDate() {
		SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			return slf.parse(this.showEndTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void setShowEndTime(String showEndTime) {
		this.showEndTime = showEndTime;
	}	
	
}
