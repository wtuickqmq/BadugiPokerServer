package com.badugi.game.logic.model.domain.vo.flash.user;

import com.badugi.game.logic.model.domain.vo.flash.ResultVo;


/**
 * 返回给flash
 */
public class QuickResultVo extends ResultVo {

	private String cmd;
	private long code;

	/**
	 * 比赛ID
	 */
	private int mi;
	/**
	 * 游戏类型
	 */
	private int gt;
	/**
	 * 游戏服务器ip
	 */
	private String ip;
	/**
	 * 端口port
	 */
	private int pt;
	/**
	 * 子账号
	 */
	private String uid;
	/**
	 * 房间id(roomId)
	 */
	private String rid;
	/**
	 * 房间名称(roomName)
	 */
	private String rn;
	/**
	 * 大盲
	 */
	private double bb;
	/**
	 * 小盲
	 */
	private double sb;
	/**
	 * 签名
	 */
	private String sign;
	/**
	 * 创建时间
	 */
	private long ct;
	/**
	 * 是否坐下(标示)
	 * （-1:flash申请,0：旁观,1 :游戏中,2：留座）
	 */
	private int isSit = -1;
	/**
	 * 筹码
	 */
	private double am;
	/**
	 * 房间分组
	 */
	private int gl;
	
	private boolean islooker;

	public QuickResultVo(){
		super();
	}
	public QuickResultVo(String cmd,Long code) {
		super();
		this.cmd = cmd;
		this.code = code;
	}
	public QuickResultVo(String ip,int pt,String uid, String rid, String rn, double bb, double sb,int gl,String sign) {
		super();
		this.ip = ip;
		this.pt = pt;
		this.uid = uid;
		this.rid = rid;
		this.rn = rn;
		this.bb = bb;
		this.sb = sb;
		this.gl=gl;
		this.sign = sign;
	}
	public QuickResultVo(String cmd,Long code,String ip,int pt,String uid, String rid, String rn, double bb, double sb,int gl,String sign,double am) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.ip = ip;
		this.pt = pt;
		this.uid = uid;
		this.rid = rid;
		this.rn = rn;
		this.bb = bb;
		this.sb = sb;
		this.gl=gl;
		this.sign = sign;
		this.am = am;
	}
	public QuickResultVo(String cmd,Long code,String ip,int pt,String uid, String rid, String rn, double bb, double sb,int gl,String sign,double am,boolean islooker) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.ip = ip;
		this.pt = pt;
		this.uid = uid;
		this.rid = rid;
		this.rn = rn;
		this.bb = bb;
		this.sb = sb;
		this.gl=gl;
		this.sign = sign;
		this.am = am;
		this.islooker = islooker;
	}
	public int getMi() {
		return mi;
	}

	public void setMi(int mi) {
		this.mi = mi;
	}

	public int getGt() {
		return gt;
	}

	public void setGt(int gt) {
		this.gt = gt;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPt() {
		return pt;
	}

	public void setPt(int pt) {
		this.pt = pt;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getRn() {
		return rn;
	}

	public void setRn(String rn) {
		this.rn = rn;
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

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public int getIsSit() {
		return isSit;
	}

	public void setIsSit(int isSit) {
		this.isSit = isSit;
	}

	public long getCt() {
		return ct;
	}

	public void setCt(long ct) {
		this.ct = ct;
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

	public void setCode(long code) {
		this.code = code;
	}
	public double getAm() {
		return am;
	}
	public void setAm(double am) {
		this.am = am;
	}
	public int getGl() {
		return gl;
	}
	public void setGl(int gl) {
		this.gl = gl;
	}
	public boolean isIslooker() {
		return islooker;
	}
	public void setIslooker(boolean islooker) {
		this.islooker = islooker;
	}
	
}
