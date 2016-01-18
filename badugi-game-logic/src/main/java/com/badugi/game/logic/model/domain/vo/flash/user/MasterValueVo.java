package com.badugi.game.logic.model.domain.vo.flash.user;

/**
 * 大师分涨幅的返回值
 * @author amin
 */
public class MasterValueVo {

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
	 * 涨幅的大师分
	 */
	private Integer value;
	
	public MasterValueVo(){
		super();
	}
	
	public MasterValueVo(Long fbid, Integer value) {
		super();
		this.fbid = fbid;
		this.value = value;
	}
	
	public MasterValueVo(Long code, String cmd, Long fbid, Integer value) {
		super();
		this.code = code;
		this.cmd = cmd;
		this.fbid = fbid;
		this.value = value;
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

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
