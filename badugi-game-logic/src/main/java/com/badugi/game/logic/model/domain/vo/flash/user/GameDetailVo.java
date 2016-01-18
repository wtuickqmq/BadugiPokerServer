package com.badugi.game.logic.model.domain.vo.flash.user;

import java.util.List;

public class GameDetailVo {

	private String cmd;
	/**
	 * 返回码 
	 */
	private Long code;
	/**
	 * 房间编号roomId
	 */
	private String rid;
	/**
	 * 房间名
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
	 * 房间用户详情
	 */
	private List<UserFundDetails> list;

	public GameDetailVo() {
		super();
	}
	
	public GameDetailVo(String rid, String rn, double bb, double sb) {
		super();
		this.rid = rid;
		this.rn = rn;
		this.bb = bb;
		this.sb = sb;
	}

	public GameDetailVo(String rid, String rn, double bb, double sb,
			List<UserFundDetails> list) {
		super();
		this.rid = rid;
		this.rn = rn;
		this.bb = bb;
		this.sb = sb;
		this.list = list;
	}
	
	public GameDetailVo(String cmd, Long code){
		super();
		this.cmd = cmd;
		this.code = code;
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

	public List<UserFundDetails> getList() {
		return list;
	}

	public void setList(List<UserFundDetails> list) {
		this.list = list;
	}

}
