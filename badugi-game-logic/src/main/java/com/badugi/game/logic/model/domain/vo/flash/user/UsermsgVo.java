package com.badugi.game.logic.model.domain.vo.flash.user;

import java.util.List;

/**
 * 
 * 项目名称：qq1.0 类名称：Usermsg 创建人：huangcaiyuan emial: caiyuan.huang@gmail.com
 * 创建时间：Jul 9, 2013 5:28:58 PM
 * 
 * @version 1.0
 */
public class UsermsgVo {

	private String cmd;
	/**
	 * 返回码
	 */
	private Long code;

	private Integer msgid;
	private Integer msgtype;
	private Long fromfbid;
	private String imgurl;
	private String fromfbname;
	private String msg;
	private String price;
	private int value;
	private int isf;
	private List<MsgDetailVo> list;

	public UsermsgVo() {
		super();
	}

	public UsermsgVo(String cmd, Long code, Integer msgid, Integer msgtype,
			Long fromfbid, String fromfbname, String msg,String imgurl) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.msgid = msgid;
		this.msgtype = msgtype;
		this.fromfbid = fromfbid;
		this.fromfbname = fromfbname;
		this.msg = msg;
		this.imgurl=imgurl;
	}

	public UsermsgVo(Integer msgtype, Integer msgid, Long fromfbid,
			String fromfbname, String msg,String imgurl) {
		super();
		this.msgtype = msgtype;
		this.msgid = msgid;
		this.fromfbid = fromfbid;
		this.fromfbname = fromfbname;
		this.msg = msg;
		this.imgurl=imgurl;
	}
	public UsermsgVo(Integer msgtype, Integer msgid, Long fromfbid,
			String fromfbname, String msg, String price, int value,
			int isf, List<MsgDetailVo> list,String imgurl) {
		super();
		this.msgtype = msgtype;
		this.msgid = msgid;
		this.fromfbid = fromfbid;
		this.fromfbname = fromfbname;
		this.msg = msg;
		this.price=price;
		this.value = value;
		this.isf = isf;
		this.list = list;
		this.imgurl=imgurl;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getMsgid() {
		return msgid;
	}

	public void setMsgid(Integer msgid) {
		this.msgid = msgid;
	}

	public Integer getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(Integer msgtype) {
		this.msgtype = msgtype;
	}

	public String getFromfbname() {
		return fromfbname;
	}

	public void setFromfbname(String fromfbname) {
		this.fromfbname = fromfbname;
	}

	public Long getFromfbid() {
		return fromfbid;
	}

	public void setFromfbid(Long fromfbid) {
		this.fromfbid = fromfbid;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public int getIsf() {
		return isf;
	}
	
	public void setIsf(int isf) {
		this.isf = isf;
	}

	public List<MsgDetailVo> getList() {
		return list;
	}

	public void setList(List<MsgDetailVo> list) {
		this.list = list;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
}
