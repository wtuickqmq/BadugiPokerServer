package com.badugi.game.logic.model.utils.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/*****
 * 
 * @copyright：Copyright 2011 highesthelp.com All Rights Reserved
 * @author: wei jie
 * @email: <a href="mailto:jackstudiomaster@gmail.com">wei jie</a>
 * @createTime: 2011-3-20
 * @description: 
 */
@SuppressWarnings("rawtypes")
public class ApiUtils {
	public final static Log log = LogFactory.getLog("ApiUtils");

	/****
	 * MD5加密
	 * @param orgin
	 * @return
	 */
	public static String Signature(String orgin) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			String result = byte2hex(md.digest(orgin.toString().getBytes("utf-8")));
			return result;
		} catch (Exception e) {
			throw new java.lang.RuntimeException("sign error !");
		}
	}

	private static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase();

	}
	
	/****
	 * 将列表的内容生产字符串，每项间用逗号","分割
	 */
	public static String list2SplitStr(List list){
		if(list == null)
			return null;
		String items = "";
		for(int i = 0;i < list.size();i++){
			if("".equals(items)){
				items = list.get(i).toString();
			}else{
				items += "," + list.get(i).toString();
			}
		}
		return items;
		
	}
	
	/****
	 * 局号 = appId + yyyyMMddHHmmss + 四位随机数字
	 * @param appId
	 * @return
	 */
	public static BigInteger renderRoundId(Integer appId){
		StringBuffer sb = new StringBuffer();
		sb.append(appId);
		SimpleDateFormat formatter = new  SimpleDateFormat("yyMMddHHmmss");
		String ctime =  formatter.format(new Date());
		sb.append(ctime);
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			sb.append(String.valueOf(random.nextInt(10)));
		}
		return new BigInteger(sb.toString());
	}
	

	public static void main(String args[]) throws Exception {
		
		List<String> sipSessions = new ArrayList<String>();
		sipSessions.add("100x");
		sipSessions.add("200x");
		sipSessions.add("300x");
		
		System.out.println(renderRoundId(104));
		
	}
	
	
}
