package com.badugi.game.logic.model.vo.record;

import java.io.Serializable;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class RecordBackVO extends ResultVo implements Serializable {

	/**
	 * 
	 */
	public static final long serialVersionUID = -2253702507707906552L;
	public final static Integer CODE_1=1;//成功
	public final static Integer CODE_2=1;//用户未登录
	public final static Integer CODE_3=3;//用户不存在
	public final static Integer CODE_4=4;//未知错误
	public final static String DESC_1="成功";
	public final static String DESC_2="用户未登录";
	public final static String DESC_3="用户不存在";
	public final static String DESC_4="未知错误";
	
	
	public Integer code;
	public String desc;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
