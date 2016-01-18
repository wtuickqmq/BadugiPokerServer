package com.badugi.game.logic.model.vo.api;

/**
 * api获取系统服务器时间
 * @author amin
 */
public class DateTimeVo extends ResultVo{

	private Long code;
	private String description;
	private String datetime;
	
	public DateTimeVo(Long code, String description) {
		super();
		this.code = code;
		this.description = description;
	}
	
	public DateTimeVo(Long code, String description,String datetime) {
		super();
		this.code = code;
		this.description = description;
		this.datetime = datetime;
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
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	
}
