package com.badugi.game.logic.model.domain.vo.flash.operators;

/**
 * @author amin
 */
public class MatchMergeTableOkVo {

	/**
	 * 比赛编号
	 */
	private Integer id;
	/**
	 * 拼桌编号
	 */
	private String sign;
	/**
	 * 返回代码
	 */
	private Integer code;

	public MatchMergeTableOkVo() {
		super();
	}

	public MatchMergeTableOkVo(Integer id, String sign, Integer code) {
		super();
		this.id = id;
		this.sign = sign;
		this.code = code;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
