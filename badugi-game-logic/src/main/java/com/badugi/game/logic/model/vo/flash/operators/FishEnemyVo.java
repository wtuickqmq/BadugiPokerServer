package com.badugi.game.logic.model.vo.flash.operators;

public class FishEnemyVo {

	/**
	 * 返回码
	 */
	private String cmd;
	private Long code;

	private Integer flag;
	private Integer rid;
	private Long tofbid;
	private String tofbname;
	private Integer isf;
	
	
	public FishEnemyVo(String cmd, Long code) {
		super();
		this.cmd = cmd;
		this.code = code;
	}
	
	/**
	 * flag:1:fish,2:敌人
	 */
	public FishEnemyVo(String cmd, Long code, Integer flag, Integer rid,
			Long tofbid, String tofbname, Integer isf) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.flag = flag;
		this.rid = rid;
		this.tofbid = tofbid;
		this.tofbname = tofbname;
		this.isf = isf;
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
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Long getTofbid() {
		return tofbid;
	}
	public void setTofbid(Long tofbid) {
		this.tofbid = tofbid;
	}
	public String getTofbname() {
		return tofbname;
	}
	public void setTofbname(String tofbname) {
		this.tofbname = tofbname;
	}
	public Integer getIsf() {
		return isf;
	}
	public void setIsf(Integer isf) {
		this.isf = isf;
	}

	

}
