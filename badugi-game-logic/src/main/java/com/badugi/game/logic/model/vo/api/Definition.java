package com.badugi.game.logic.model.vo.api;

import java.util.Random;

/****
 * @createTime: 2012-10-22
 * @description:统一接口定义
 */
public class Definition {
	
	
	/**方法默认版本*/
	public final static String DEFAUL_METHOD_VERSER = "1.0";
	
	/**数据返回格式--json*/
	public final static String FMT_TYPE_JSON = "json";
	
	/***
	 * 操作成功
	 */
	public final static long SUCCESS_CODE = 10000L;
	public final static String SUCCESS_DESCRIPTION = "success";
	
	/***
	 * 未知错误
	 */
	public final static long NUKNOW_CODE = 19999L;
	public final static String NUKNOW_DESCRIPTION = "nuknow error";
	
	/***
	 * 参数错误
	 */
	public final static long ERROR_ARGS_CODE = 10001L;
	public final static String ERROR_ARGS_DESCRIPTION = "the params error! please check it.";
	
	/***
	 * 签名失败
	 */
	public final static long SIGN_CODE = 10002L;
	public final static String SIGN_DESCRIPTION = "sign error";
	
	/***
	 * 禁用
	 */
	public final static long DISABLE_ERROR_CODE = 10003L;
	public final static String DISABLE_ERROR_DESCRIPTION = "disable error!";
	
	/****
	 * 授权错误
	 */
	public final static long SIPSESSION_ERROR_CODE = 10004L;
	public final static String SIPSESSION_ERROR_DESCRIPTION = "sip session error";
	
	/****
	 * 用户不存在
	 */
	public final static long NOTEXISTS_ERROR_CODE = 10005L;
	public final static String NOTEXISTS_ERROR_DESCRIPTION = "not exists error";
	
	/****
	 * 用户未登陆或者登陆授权错误
	 */
	public final static long NOTLOGIN_ERROR_CODE = 10006L;
	public final static String NOTLOGIN_ERROR_DESCRIPTION = "not login or login token error";
	
	/****
	 * 重复操作
	 */
	public final static long REPEAT_ERROR_CODE = 10007L;
	public final static String REPEAT_ERROR_DESCRIPTION = "repeat excetion error";
	
	/****
	 * 无法操作
	 */
	public final static long CONNOT_ERROR_CODE = 10008L;
	public final static String CONNOT_ERROR_DESCRIPTION = "connot request error";
	
	/***
	 * 申请失败
	 */
	public final static long ACCEPT_ERROR_CODE = 10009L;
	public final static String ACCEPT_ERROR_DESCRIPTION = "accept error, the accept credit too big!";
	
	/***
	 * 比赛已结束
	 */
	public final static long MATCHOVER_ERROR_CODE = 10010L;
	public final static String MATCHOVER_ERROR_DESCRIPTION = "match is over!";
	
	/***
	 * 超出
	 */
	public final static long OUT_ERROR_CODE = 10011L;
	public final static String OUT_ERROR_DESCRIPTION = "out!";
	
	/***
	 * 没有找到该类型的比赛
	 */
	public final static long NOMATCH_ERROR_CODE = 10012L;
	public final static String NOMATCH_ERROR_DESCRIPTION = "not match!";
	
	/****
	 * 房间密码不正确
	 */
	public final static long MATCH_PWD_ERROR_CODE = 10013L;
	public final static String MATCH_PWD_ERROR_DESCRIPTION = "password request error";
	
	/***
	 * 服务器即将启停
	 */
	public final static long SERVERSTOP_ERROR_CODE = 12222L;
	public final static String SERVERSTOP_ERROR_DESCRIPTION = "server stop start!";
	
	
	public static String genSipsession(){
		int len = 10;
		String iniStr = "1,T,2,3,w,4,5,8,0,a,b,U,c,d,e,f,D,g,E,j,k,7,l,W,m,n,p,Q,r,9,s,t,u,v,x,y,A,B,C,h,F,K,G,H,I,6,J,L,M,q,N,O,P,R,S,o,V,i,X,Y";
		String[] s = iniStr.split(",");
		StringBuffer retval = new StringBuffer();
		Random r = new Random();
		for(int i = 0;i < len;i++){
			retval.append(s[r.nextInt(s.length)]);
		}
		return retval.toString();
	}
	
}
