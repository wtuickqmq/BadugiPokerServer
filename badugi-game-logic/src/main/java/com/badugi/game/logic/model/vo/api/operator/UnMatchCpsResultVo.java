package com.badugi.game.logic.model.vo.api.operator;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 获得大学生赛冠军返回值
 * 
 * @author amin
 */
public class UnMatchCpsResultVo extends ResultVo {

	private Long code;
	private String desc;
	private Long fbid;
	private String fbname;
	private Integer type;
	private String date;
	private String mn;

	public UnMatchCpsResultVo() {
		super();
	}

	public UnMatchCpsResultVo(Long code, String desc, Long fbid, String fbname,
			Integer type, String date) {
		super();
		this.code = code;
		this.desc = desc;
		this.fbid = fbid;
		this.fbname = fbname;
		this.type = type;
		this.date = date;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getFbid() {
		return fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}

	public String getFbname() {
		return fbname;
	}

	public void setFbname(String fbname) {
		this.fbname = fbname;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getMn() {
		return mn;
	}
	
	public void setMn(String mn) {
		this.mn = mn;
	}

}
