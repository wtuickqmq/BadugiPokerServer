package com.joker.common.util;

public class UnicodeUtil {
	/**
	 * 解码unicode
	 * 
	 * @param dataStr
	 *            需要解码的字符串
	 * @return 解码后的字符串
	 */
	public static String decodeUnicode(final String dataStr) {
		try {
			int start = 0;
			int end = 0;
			final StringBuffer buffer = new StringBuffer();
			while (start > -1) {
				end = dataStr.indexOf("\\u", start + 2);
				String charStr = "";
				if (end == -1) {
					charStr = dataStr.substring(start + 2, dataStr.length());
				} else {
					charStr = dataStr.substring(start + 2, end);
				}
				char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
				buffer.append(new Character(letter).toString());
				start = end;
			}
			return buffer.toString();
		} catch (Exception e) {
			return dataStr;
		}
	}

	/**
	 * 将中文转换成unicode编码
	 * 
	 * @param gbString
	 *            需要转换的字符
	 * @return 转换后的字符串
	 */
	public static String gbEncoding(final String gbString) {
		char[] utfBytes = gbString.toCharArray();
		String unicodeBytes = "";
		for (int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++) {
			String hexB = Integer.toHexString(utfBytes[byteIndex]);
			if (hexB.length() <= 2) {
				hexB = "00" + hexB;
			}
			unicodeBytes = unicodeBytes + "\\u" + hexB;
		}
		return unicodeBytes;
	}

}
