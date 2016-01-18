package com.badugi.game.logic.model.vo.fb;
/**
 * 
* 项目名称：qq1.0   
* 类名称：TokenVo   
* 创建人：huangcaiyuan 
* emial: caiyuan.huang@gmail.com   
* 创建时间：Aug 16, 2013 12:53:53 PM    
* @version 1.0
 */
public class UploadVo {
	
	private String fbid;
	private String timestamp;
//	File picture;
	private String sign;
	public String getFbid() {
		return fbid;
	}
	public void setFbid(String fbid) {
		this.fbid = fbid;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}

	
}
