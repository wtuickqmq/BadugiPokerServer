package com.badugi.game.logic.model.domain.vo.flash.user;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * 大厅用户账户信息vo
 * 
 * @author amin
 */
public class UserFundInfoVo {

	/**
	 * 返回码
	 */
	private Long code;
	/**
	 * 操作类型
	 */
	private String cmd;
	/**
	 * facebook编号fbid
	 */
	private Long id;
	/**
	 * 用户名称name
	 */
	private String n;
	/**
	 * 筹码chips
	 */
	private double c;
	/**
	 * 总VIP点数totalpoints
	 */
	private double tp;
	/**
	 * vip点数points
	 */
	private double p;
	/**
	 * 保级需要积分periodvippoint
	 */
	private double pvp;
	/**
	 * vip积分vippoints
	 */
	private double vp;
	/**
	 * 总VIP积分totalvippoints
	 */
	private double tvp;
	/**
	 * vip等级viplevel
	 */
	private int vl;
	/**
	 * 下一级vip积分nextVipPoints
	 */
	private double nvp;
	/**
	 * 经验值ExpValue(减去上一级的经验)
	 */
	private Double e;
	/**
	 * 总经验值totalExpValue
	 */
	private Double te;
	/**
	 * 普通等级
	 */
	private int el;
	/**
	 * 下一级经验数
	 */
	private int ne;

	/**
	 * 大师分MasterValue(减去上一级的大师分)
	 */
	private int m;
	/**
	 * 总大师分
	 */
	private int tm;
	/**
	 * 大师分等级
	 */
	private int ml;
	/**
	 * 下一级大师分数值
	 */
	private int nm;
	/**
	 * 金块
	 */
	private int g;
	/**
	 * 玩局数playcounts
	 */
	private int pc;
	/**
	 * 赢局数wincounts
	 */
	private int wc;
	/**
	 * 任务完成个数
	 */
	private int tec;
	/**
	 * 任务总个数
	 */
	private int tc;

	/**
	 * 腾讯头像url
	 */
	private String imgurl;

	/**
	 * 是否为机器人
	 */
	private int isRobot;
	/**
	 * 是否新用户
	 */
	private boolean isnew;
	/**
	 * 登录时间
	 */
	private long loginTime;
	/**
	 * 注册时间
	 */
	private Timestamp regTime;
	/**
	 * 用户名
	 */
	private String un;
	/**
	 * 赞的总数
	 */
	private int lkc;
	/**
	 * 签名
	 */
	private String sg;
	
	/**
	 * 单次赢取最大金额数
	 */
	private double roundmaxchips;

	/**
	 * 是否已经发送大型赛事提示
	 * matchconfigid,true or false
	 */
	private Map<Integer, Boolean> matchPrompt = new HashMap<Integer, Boolean>();;

	/**
	 * 是否已经发送已经登记比赛的赛事提示
	 * matchconfigid,true or false
	 */
	private Map<Integer, Boolean> matchAttendPrompt = new HashMap<Integer, Boolean>();

	public UserFundInfoVo() {
		super();
	}

	public UserFundInfoVo(Long id, String n, double c, double tp, double tvp, Double te, int vl, String un, int lkc,
			int tm, int g,Double rmc) {
		super();
		this.id = id;
		this.n = n;
		this.c = c;
		this.tp = tp;
		this.tvp = tvp;
		this.te = te;
		this.vl = vl;
		this.un = un;
		this.lkc = lkc;
		this.tm = tm;
		this.g = g;
		this.roundmaxchips = rmc;
	}

	public UserFundInfoVo(String cmd, Long code) {
		super();
		this.cmd = cmd;
		this.code = code;
	}

	public UserFundInfoVo(Long id, String n, double c, double tp, double pvp,
			double tvp, int vl, double nvp, Double te, int el, int ne, int pc, int wc,Double rmc) {
		super();
		this.id = id;
		this.n = n;
		this.c = c;
		this.tp = tp;
		this.pvp = pvp;
		this.tvp = tvp;
		this.vl = vl;
		this.nvp = nvp;
		this.te = te;
		this.el = el;
		this.ne = ne;
		this.pc = pc;
		this.wc = wc;
		this.roundmaxchips = rmc;
	}
	

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public double getP() {
		return p;
	}

	public void setP(double p) {
		this.p = p;
	}

	public double getPvp() {
		return pvp;
	}

	public void setPvp(double pvp) {
		this.pvp = pvp;
	}

	public double getVp() {
		return vp;
	}

	public void setVp(double vp) {
		this.vp = vp;
	}

	public int getVl() {
		return vl;
	}

	public void setVl(int vl) {
		this.vl = vl;
	}

	public double getNvp() {
		return nvp;
	}

	public void setNvp(double nvp) {
		this.nvp = nvp;
	}

	public Double getE() {
		return e;
	}

	public void setE(Double e) {
		this.e = e;
	}

	public int getEl() {
		return el;
	}

	public void setEl(int el) {
		this.el = el;
	}

	public int getNe() {
		return ne;
	}

	public void setNe(int ne) {
		this.ne = ne;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getTm() {
		return tm;
	}

	public void setTm(int tm) {
		this.tm = tm;
	}

	public int getMl() {
		return ml;
	}

	public void setMl(int ml) {
		this.ml = ml;
	}

	public int getNm() {
		return nm;
	}

	public void setNm(int nm) {
		this.nm = nm;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public int getWc() {
		return wc;
	}

	public void setWc(int wc) {
		this.wc = wc;
	}

	public Double getTe() {
		return te;
	}

	public void setTe(Double te) {
		this.te = te;
	}

	public double getTp() {
		return tp;
	}

	public void setTp(double tp) {
		this.tp = tp;
	}

	public double getTvp() {
		return tvp;
	}

	public void setTvp(double tvp) {
		this.tvp = tvp;
	}

	public int getTec() {
		return tec;
	}

	public void setTec(int tec) {
		this.tec = tec;
	}

	public int getTc() {
		return tc;
	}

	public void setTc(int tc) {
		this.tc = tc;
	}

	public int getIsRobot() {
		return isRobot;
	}

	public void setIsRobot(int isRobot) {
		this.isRobot = isRobot;
	}

	public long MyLoginTime() {
		return loginTime;
	}

	public void setLoginTime(long loginTime) {
		this.loginTime = loginTime;
	}

	public Timestamp getRegTime() {
		return regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	public boolean getIsnew() {
		return isnew;
	}

	public void setIsnew(boolean isnew) {
		this.isnew = isnew;
	}

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public int getLkc() {
		return lkc;
	}

	public void setLkc(int lkc) {
		this.lkc = lkc;
	}

	public Map<Integer, Boolean> MyMatchPrompt() {
		return matchPrompt;
	}

	public void setMatchPrompt(Map<Integer, Boolean> matchPrompt) {
		this.matchPrompt = matchPrompt;
	}

	public Map<Integer, Boolean> MyMatchAttendPrompt() {
		return matchAttendPrompt;
	}

	public void setMatchAttendPrompt(Map<Integer, Boolean> matchAttendPrompt) {
		this.matchAttendPrompt = matchAttendPrompt;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getSg() {
		return sg;
	}

	public void setSg(String sg) {
		this.sg = sg;
	}

	public double getRoundmaxchips() {
		return roundmaxchips;
	}

	public void setRoundmaxchips(double roundmaxchips) {
		this.roundmaxchips = roundmaxchips;
	}

	public Map<Integer, Boolean> getMatchPrompt() {
		return matchPrompt;
	}

	public Map<Integer, Boolean> getMatchAttendPrompt() {
		return matchAttendPrompt;
	}

	@Override
	public String toString() {
		return "UserFundInfoVo [code=" + code + ", cmd=" + cmd + ", id=" + id
				+ ", n=" + n + ", c=" + c + ", tp=" + tp + ", p=" + p
				+ ", pvp=" + pvp + ", vp=" + vp + ", tvp=" + tvp + ", vl=" + vl
				+ ", nvp=" + nvp + ", e=" + e + ", te=" + te + ", el=" + el
				+ ", ne=" + ne + ", m=" + m + ", tm=" + tm + ", ml=" + ml
				+ ", nm=" + nm + ", g=" + g + ", pc=" + pc + ", wc=" + wc
				+ ", tec=" + tec + ", tc=" + tc + ", imgurl=" + imgurl
				+ ", isRobot=" + isRobot + ", isnew=" + isnew + ", loginTime="
				+ loginTime + ", regTime=" + regTime + ", un=" + un + ", lkc="
				+ lkc + ", sg=" + sg + ", roundmaxchips=" + roundmaxchips
				+ ", matchPrompt=" + matchPrompt + ", matchAttendPrompt="
				+ matchAttendPrompt + "]";
	}
	
}
