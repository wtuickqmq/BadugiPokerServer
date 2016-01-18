package com.badugi.game.logic.model.domain.vo.flash.user;

/**
 * 经验值涨幅的返回值
 * @author amin
 */
public class ExpValueVo {

	/**
	 * 返回码
	 */
	private Long code;
	/**
	 * 操作类型
	 */
	private String cmd;
	/**
	* fb编号
	*/
	private Long fbid;
	/**
	 * 涨幅的经验值
	 */
	private Integer expvalue;
	
	public ExpValueVo(){
		super();
	}
	
	public ExpValueVo(Long fbid, Integer expvalue) {
		super();
		this.fbid = fbid;
		this.expvalue = expvalue;
	}
	
	public ExpValueVo(Long code, String cmd, Long fbid, Integer expvalue) {
		super();
		this.code = code;
		this.cmd = cmd;
		this.fbid = fbid;
		this.expvalue = expvalue;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public Long getFbid() {
		return fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}

	public Integer getExpvalue() {
		return expvalue;
	}

	public void setExpvalue(Integer expvalue) {
		this.expvalue = expvalue;
	}

}
