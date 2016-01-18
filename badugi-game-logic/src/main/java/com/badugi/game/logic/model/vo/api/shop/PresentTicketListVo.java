package com.badugi.game.logic.model.vo.api.shop;

import java.io.Serializable;
import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class PresentTicketListVo extends ResultVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long code;
	private String desc;
	private Long fbid;
	private Long tofbid;
	private String tofbname;
	private List<PresentTicketVo> list;
	
	public PresentTicketListVo() {
		super();
	}

	public PresentTicketListVo(Long code, String desc, Long fbid, Long tofbid,
			String tofbname, List<PresentTicketVo> list) {
		super();
		this.code = code;
		this.desc = desc;
		this.fbid = fbid;
		this.tofbid = tofbid;
		this.tofbname = tofbname;
		this.list = list;
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

	public List<PresentTicketVo> getList() {
		return list;
	}

	public void setList(List<PresentTicketVo> list) {
		this.list = list;
	}

	
	
}
