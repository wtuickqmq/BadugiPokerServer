package com.badugi.game.logic.model.vo.qq;

/**
 * 腾讯回调发货信息
 * 参数详情请看：http://wiki.open.qq.com/wiki/%E5%9B%9E%E8%B0%83%E5%8F%91%E8%B4%A7URL%E7%9A%84%E5%8D%8F%E8%AE%AE%E8%AF%B4%E6%98%8E_V3
* 项目名称：qqt1.0   
* 类名称：TcPayBackVo   
* 创建人：huangcaiyuan 
* emial: caiyuan.huang@gmail.com   
* 创建时间：Sep 24, 2013 10:12:12 AM    
* @version 1.0
 */
public class TcPayBackVo{

	private String openid;
	private String appid;
	private String ts;
	private String payitem;
	private String token;
	private String billno;
	private String version;
	private String zoneid;
	private String providetype;
	private String provide_errno;
	private String provide_errmsg;
	private String amt;
	private String payamt_coins;
	private String pubacct_payamt_coins;
	private String sig;
	private String openkey;
	private String pf;
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getTs() {
		return ts;
	}
	public void setTs(String ts) {
		this.ts = ts;
	}
	public String getPayitem() {
		return payitem;
	}
	public void setPayitem(String payitem) {
		this.payitem = payitem;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getZoneid() {
		return zoneid;
	}
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}
	public String getProvidetype() {
		return providetype;
	}
	public void setProvidetype(String providetype) {
		this.providetype = providetype;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getPayamt_coins() {
		return payamt_coins;
	}
	public void setPayamt_coins(String payamtCoins) {
		payamt_coins = payamtCoins;
	}
	public String getPubacct_payamt_coins() {
		return pubacct_payamt_coins;
	}
	public void setPubacct_payamt_coins(String pubacctPayamtCoins) {
		pubacct_payamt_coins = pubacctPayamtCoins;
	}
	public String getSig() {
		return sig;
	}
	public void setSig(String sig) {
		this.sig = sig;
	}
	public String getProvide_errno() {
		return provide_errno;
	}
	public void setProvide_errno(String provideErrno) {
		provide_errno = provideErrno;
	}
	public String getProvide_errmsg() {
		return provide_errmsg;
	}
	public void setProvide_errmsg(String provideErrmsg) {
		provide_errmsg = provideErrmsg;
	}
	public String getOpenkey() {
		return openkey;
	}
	public void setOpenkey(String openkey) {
		this.openkey = openkey;
	}
	public String getPf() {
		return pf;
	}
	public void setPf(String pf) {
		this.pf = pf;
	}

	
}
