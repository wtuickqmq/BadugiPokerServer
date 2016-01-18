package com.badugi.game.logic.model.vo.api.operator;

import java.io.Serializable;
import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class TodayGoldListVo extends ResultVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long code;
	private String desc;
	private Long myid;
	private String myname;
	private Integer mygoldnum;
	private Integer oindex;
	private List<GoldVo> list;
	
	
	public TodayGoldListVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TodayGoldListVo(Long code, String desc, Long myid, String myname,
			Integer mygoldnum, Integer oindex, List<GoldVo> list) {
		super();
		this.code = code;
		this.desc = desc;
		this.myid = myid;
		this.myname = myname;
		this.mygoldnum = mygoldnum;
		this.oindex = oindex;
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
	public Long getMyid() {
		return myid;
	}
	public void setMyid(Long myid) {
		this.myid = myid;
	}
	public String getMyname() {
		return myname;
	}
	public void setMyname(String myname) {
		this.myname = myname;
	}
	public Integer getMygoldnum() {
		return mygoldnum;
	}
	public void setMygoldnum(Integer mygoldnum) {
		this.mygoldnum = mygoldnum;
	}
	public Integer getOindex() {
		return oindex;
	}
	public void setOindex(Integer oindex) {
		this.oindex = oindex;
	}
	public List<GoldVo> getList() {
		return list;
	}
	public void setList(List<GoldVo> list) {
		this.list = list;
	}
	
	
}
