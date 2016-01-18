package com.badugi.game.logic.model.domain.vo.flash.operators;

import java.util.Date;

import com.badugi.game.logic.model.domain.vo.flash.ResultVo;
import com.badugi.game.logic.util.DateUtils;


/**
 * 加入房间时如果为服务器启停禁止进入中返回值
 * 
 * @author amin
 */
public class ServerstopResultVo extends ResultVo {

	private String cmd;
	private Long code;
	private String bt;
	private String et;
	private String egt;
	private String emt;

	public ServerstopResultVo() {
		super();
	}

	public ServerstopResultVo(String cmd, Long code, String bt, String et,
			String egt, String emt) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.bt = bt;
		this.et = et;
		this.egt = egt;
		this.emt = emt;
	}
	
	public ServerstopResultVo(String cmd, Long code, long bt, long et,
			long egt, long emt) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.bt = DateUtils.dateToString(new Date(bt), DateUtils.PATTERN_YMDHMS);
		this.et = DateUtils.dateToString(new Date(et), DateUtils.PATTERN_YMDHMS);
		this.egt = DateUtils.dateToString(new Date(egt), DateUtils.PATTERN_YMDHMS);
		this.emt = DateUtils.dateToString(new Date(emt), DateUtils.PATTERN_YMDHMS);
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getBt() {
		return bt;
	}

	public void setBt(String bt) {
		this.bt = bt;
	}

	public String getEt() {
		return et;
	}

	public void setEt(String et) {
		this.et = et;
	}

	public String getEgt() {
		return egt;
	}

	public void setEgt(String egt) {
		this.egt = egt;
	}

	public String getEmt() {
		return emt;
	}

	public void setEmt(String emt) {
		this.emt = emt;
	}

}
