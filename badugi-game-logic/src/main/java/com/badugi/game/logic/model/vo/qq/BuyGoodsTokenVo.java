package com.badugi.game.logic.model.vo.qq;

/**
 * 交易token 
* 项目名称：qqt1.0   
* 类名称：BuyGoodsTokenVo   
* 创建人：huangcaiyuan 
* emial: caiyuan.huang@gmail.com   
* 创建时间：Sep 23, 2013 10:22:22 AM    
* @version 1.0
 */
public class BuyGoodsTokenVo extends TReturnVo{

	private String url_params;
	private String token;
	private String pf;
	private String appid;
	public String getUrl_params() {
		return url_params;
	}
	public void setUrl_params(String urlParams) {
		url_params = urlParams;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPf() {
		return pf;
	}
	public void setPf(String pf) {
		this.pf = pf;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}

	
}
