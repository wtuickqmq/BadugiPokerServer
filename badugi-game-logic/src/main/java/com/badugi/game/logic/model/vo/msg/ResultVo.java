package com.badugi.game.logic.model.vo.msg;

/**
 * @createTime: 2012-10-22
 * @description：
 */
public class ResultVo {
	
	private Long code;
	private String description;
	
	public ResultVo(Long code, String description) {
		super();
		this.code = code;
		this.description = description;
	}
	
	public ResultVo(Long code, String description,String detailError) {
		super();
		this.code = code;
		this.description = description  + " " + detailError ;
	}

	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
