package com.badugi.game.logic.model.vo.record;
/**
 * 
* 项目名称：qq1.0   
* 类名称：StatusCode   
* 创建人：huangcaiyuan 
* emial: caiyuan.huang@gmail.com   
* 创建时间：Nov 16, 2012 7:18:26 PM    
* @version 1.0
 */
public class StatusCode
{
	/**
	 * StatusCode.
	 * 30000,调用成功.
	 */
	public static final String SUCCESS="30000";
	/**
	 * 
	 * 30001,参数错误.
	 */
	public static final String PARAMS_ERROR="30001";
	/**
	 * 
	 * 30002,授权不通过.
	 */
	public static final String AUTHORIZE_ERROR="30002";
	/**
	 * 
	 * 30003,系统出错.
	 */
	public static final String REMOTESERVICE_ERROR="30003";
	/**
	 * 
	 * 30004,没有数据.
	 */
	public static final String HAVENODATA_ERROR="30004";
	/**
	 * 
	 * 30005,消息类型不是系统消息.
	 */
	public static final String NOTSYSMSG_ERROR="30005";
	
	/**	 
	 * * 30101.已经没有上一局了.
	 */
	public static final String NO_PRE="30101";
	/**
	 * 30102,已经没有下一局了.
	 */
	public static final String NO_NEXT="30102";
	/**
	 * 30103.用户已经不在房间内.
	 */
	public static final String LEAVE_ROOM="30103";
	/**
	 * 30104.记录有异常.
	 */
	public static final String RECORD_ERROR="30104";
	/**
	 * 30201.下注失败.
	 */
	public static final String BET_ERROR="30201";
	
	/**
	 * 39999,未知错误.
	 */
	public static final String UNKNOW_ERROR="39999";

}
