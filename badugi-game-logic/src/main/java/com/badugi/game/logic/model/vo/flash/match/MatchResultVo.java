package com.badugi.game.logic.model.vo.flash.match;

import java.util.List;

/**
 * 返回给flash
 */
@SuppressWarnings("rawtypes")
public class MatchResultVo {

	private String cmd;
	private int mi;
	private String rid;
	private long code;
	private List list;
	private String avgchips;
	
	public MatchResultVo(){
		super();
	}
	
	public MatchResultVo(String cmd) {
		super();
		this.cmd = cmd;
	}
	
	public MatchResultVo(String cmd, long code) {
		super();
		this.cmd = cmd;
		this.code = code;
	}
	
	public MatchResultVo(String cmd, List list) {
		super();
		this.cmd = cmd;
		this.list = list;
	}
	
	public MatchResultVo(String cmd, int mi, List list) {
		super();
		this.cmd = cmd;
		this.mi = mi;
		this.list = list;
	}
	public MatchResultVo(String cmd, int mi, List list,String avgchips) {
		super();
		this.cmd = cmd;
		this.mi = mi;
		this.list = list;
		this.avgchips=avgchips;
	}
	
	public MatchResultVo(String cmd, int mi, String rid, List list) {
		super();
		this.cmd = cmd;
		this.mi = mi;
		this.rid = rid;
		this.list = list;
	}

	public MatchResultVo(String cmd, long code, List list) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.list = list;
	}
	public MatchResultVo(String cmd, long code, int mi) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.mi = mi;
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
	
	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String getAvgchips() {
		return avgchips;
	}

	public void setAvgchips(String avgchips) {
		this.avgchips = avgchips;
	}
	
	

}
