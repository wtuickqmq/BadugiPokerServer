package com.badugi.game.logic.model.vo.flash.match;

public class FlashBeginVo {
	
	//{cmd, ip,pt,uid,rid,fbid}
	
	private String cmd;
	private String ip;
	private int pt;
	private String uid;
	private String rid;
	private Long fbid;
	private int mi;
	private Long code;
	private String orid;//原房间ID
	
	
	
	
	public FlashBeginVo(String cmd, String ip, int pt, String uid, String rid,
			Long fbid, int mi) {
		super();
		this.cmd = cmd;
		this.ip = ip;
		this.pt = pt;
		this.uid = uid;
		this.rid = rid;
		this.fbid = fbid;
		this.mi = mi;
	}
	
	public FlashBeginVo(String ip, int pt, String uid, String rid,
			Long fbid, int mi) {
		super();
		this.ip = ip;
		this.pt = pt;
		this.uid = uid;
		this.rid = rid;
		this.fbid = fbid;
		this.mi = mi;
	}
	
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
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
	public String getOrid() {
		return orid;
	}
	public void setOrid(String orid) {
		this.orid = orid;
	}
	public Long getFbid() {
		return fbid;
	}
	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}
	public int getMi() {
		return mi;
	}
	public void setMi(int mi) {
		this.mi = mi;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	
	
	
	
}
