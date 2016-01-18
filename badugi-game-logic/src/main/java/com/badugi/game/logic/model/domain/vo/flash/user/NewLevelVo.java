package com.badugi.game.logic.model.domain.vo.flash.user;

/**
 * 用户新等级的返回值
 * 
 * @author amin
 */
public class NewLevelVo {

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
	 * 新等级
	 */
	private Integer level;

	public NewLevelVo() {
		super();
	}

	public NewLevelVo(Long fbid, Integer level) {
		super();
		this.fbid = fbid;
		this.level = level;
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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}
