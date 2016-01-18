package com.badugi.game.logic.model.utils.common;

import java.security.MessageDigest;

/**
 * The interface of MD5.<br>
 * Translates password to a String Value of MD5.<br>
 * Usage: String md5OfStr=MD5.getInstance().getMD5(String str);
 */

public final class Md5Utils{
	
	/****
	 * MD5加密
	 * @param orgin
	 * @return
	 */
	public static String md5(String orgin) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			String result = byte2hex(md.digest(orgin.toString().getBytes("utf-8")));
			return result;
		} catch (Exception e) {
			throw new java.lang.RuntimeException("sign error !");
		}
	}
	
	/****
	 * MD5加密,返回小写的字符串
	 * @param orgin
	 * @return 小写
	 */
	public static String md5toLowerCase(String orgin) {
		try {
			String result = md5(orgin).toLowerCase();
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
	
	
	
	public static void main(String[] args) {
		;
	}
}