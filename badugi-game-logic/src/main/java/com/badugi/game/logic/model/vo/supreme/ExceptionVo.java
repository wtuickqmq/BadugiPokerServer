package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;

/**
 * 
 * @author nexus
 *
 */
public class ExceptionVo  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long fbId;//请求异常者ID
	private Long code;//请求异常码
	private String cmd;//请求异常命令
	private String type;//异常类别
	private String content;//异常内容
	public ExceptionVo(){}
	public ExceptionVo(Long code,String cmd,String type,String content){
		this.type = type;
		this.cmd = cmd;
		this.code =code;
		this.content = content;
	}
	public ExceptionVo(Long fbId,Long code,String cmd,String type,String content){
		this.fbId = fbId;
		this.type = type;
		this.cmd = cmd;
		this.code =code;
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getFbId() {
		return fbId;
	}
	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
}
