package com.joker.common.util;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 *  
 * @version : 1.00 
 * Create Time : 2011-2-22-下午04:31:36 
 * Description :  
 *             内容校验类 
 */  
public class ValidateUtil implements Serializable{  
	private static final long serialVersionUID = 1L;  

	/** 
	 * 默认编码格式 
	 */  
	private static final String DEFAULT_ENCODING = "UTF-8";  

	/** 
	 * Function  : 检查字符串的格式 
	 * @param str           ：  被检查的字符串 
	 * @param hasCN         ：  允许有中文 
	 * @param hasNum        ： 允许有数字 
	 * @param hasLetter     ： 允许有字母 
	 * @param specialChars  :  允许有特殊字符,输入方式:假设允许下划线则参数为,"_"  假如允许下划线和问号则参数为,"_","?" 
	 * example : 字母、数字、问号、句号和感叹号组成的字符串：isRealChar("xxxx",false,true,true,"?","。","!") 
	 * @return   匹配则返回true,不匹配返回false 
	 */  
	public static boolean isRealChar(String str,boolean hasCN,boolean hasNum,boolean hasLetter,String... specialChars){  
		String regex_start = "^[";  
		String regex_end = "]+$";  

		if(hasCN == true){  
			regex_start = regex_start + "|\u4e00-\u9fa5";  
		}else if(hasNum == true){  
			regex_start = regex_start + "|0-9";  
		}else if(hasLetter == true){  
			regex_start = regex_start + "|a-zA-Z";  
		}  
		if(specialChars != null){  
			for(int i = 0;i<specialChars.length;i++){  
				regex_start = regex_start +"|"+specialChars[i];  
			}  
		}  

		return match(regex_start+regex_end,str);  
	}  

	/** 
	 * @param str 
	 * @return 
	 * about version ：1.00 
	 * create time   : 2011-2-22-下午04:37:22 
	 * Description ： 验证邮箱的有效性 
	 *         成功匹配则返回true 
	 *         不匹配则返回false            
	 */  
	public static boolean isEmail(String str)   
	{  
		//return str.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+") ;  
		String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";   
		return match(regex, str);   
	}   

	/** 
	 * @param str 
	 * @return 
	 * about version ：1.00 
	 * create time   : 2011-2-22-下午04:38:38 
	 * Description ：验证IP地址 
	 *         匹配返回true 
	 *         不匹配返回false 
	 */  
	public static boolean isIP(String str)   
	{   
		String num = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";   
		String regex = "^" + num + "\\." + num + "\\." + num + "\\." + num + "$";   
		return match(regex, str);   
	}   

	/** 
	 *   
	 * @param str 
	 * @return 
	 * about version ：1.00 
	 * create time   : 2011-2-22-下午04:47:59 
	 * Description ： 校验网址(规则：以http://或https://开头) 
	 *         匹配则返回true 
	 *         不匹配则返回false 
	 */  
	public static boolean isUrl(String str)  
	{   
		String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";   
		return match(regex, str);   
	}   

	/** 
	 * @param str 
	 * @return 
	 * about version ：1.00 
	 * create time   : 2011-2-22-下午04:49:46 
	 * Description ：验证是否是固定电话(规则：xxxx(区号，3或4位)-(连接线，必备)xxxxxx(电话，6到8位),如028-83035137) 
	 *         匹配则返回true 
	 *         不匹配则返回false               
	 */  
	public static boolean isTelephone(String str)   
	{   
		String regex = "^(\\d{3,4}-)?\\d{6,8}$";   
		return match(regex, str);   
	}   

	/** 
	 * @param value 
	 * @return 
	 * about version ：1.00 
	 * create time   : 2011-2-22-下午04:51:00 
	 * Description ： 验证是否是手机号(规则：以1开头，接任意数字，11位) 
	 *         匹配则返回true 
	 *         不匹配则返回false 
	 */  
	public static boolean isMobilePhone(String value)  
	{  
		//String regex = "^[1]+[3,5]+\\d{9}$";   
		String regex = "^[1]+\\d{10}";   
		return value.matches(regex);  
	}   

	/** 
	 * @param str 
	 * @return 
	 * about version ：1.00 
	 * create time   : 2011-2-22-下午05:01:02 
	 * Description ：邮编地址 
	 *         匹配则返回true 
	 *         不匹配则返回false 
	 */  
	public static boolean isPostalcode(String str)   
	{   
		String regex = "^\\d{6}$";   
		return match(regex, str);   
	}   

	/** 
	 * @param str 
	 * @return 
	 * about version ：1.00 
	 * create time   : 2011-2-22-下午05:03:46 
	 * Description ：验证15位或18位身份证号 
	 *         匹配则返回true 
	 *         不匹配则返回false 
	 */  
	public static boolean isIDcard(String str)   
	{   
		String regex = "(^\\d{18}$)|(^\\d{15}$)";   
		return match(regex, str);   
	}   

	/** 
	 * @param str     被验证数据 
	 * @param digit   验证长度：小数点后几位 
	 * @return 
	 * about version ：1.00 
	 * create time   : 2011-2-22-下午05:12:03 
	 * Description ： 验证是否符合指定位数的小数 
	 *         匹配则返回true 
	 *         不匹配则返回false 
	 */  
	public static boolean isDecimal(String str,int digit)   
	{   
		String regex = "^[0-9]+(.[0-9]{"+digit+"})?$";   
		return match(regex, str);   
	}   


	/**  
	 * @param str 
	 * @return 
	 * about version ：1.00 
	 * create time   : 2011-2-22-下午05:18:49 
	 * Description ：验证是否是1~12月 
	 *         匹配则返回true 
	 *         不匹配则返回false 
	 */  
	public static boolean isMonth(String str)   
	{   
		String regex = "^(0?[1-9]|1[0-2])$";   
		return match(regex, str);   
	}   

	/** 
	 * @param str 
	 * @return 
	 * about version ：1.00 
	 * create time   : 2011-2-22-下午05:22:57 
	 * Description ： 校验日期格式(格式：xxxx-xx-xx，并且考虑闰月、大小月的情况) 
	 *        匹配则返回true 
	 *        不匹配则返回false 
	 */  
	public static boolean isDate(String str)   
	{   
		//严格验证时间格式的(匹配[2002-01-31], [1997-04-30], [2004-01-01])不匹配([2002-01-32], [2003-02-29], [04-01-01])   
		String regex = "^((((19|20)(([02468][048])|([13579][26]))-02-29))|((20[0-9][0-9])|(19[0-9][0-9]))-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((01,3-9])|(1[0-2]))-(29|30)))))$";   
		//没加时间验证的YYYY-MM-DD   
		//      String regex = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$";   
		//加了时间验证的YYYY-MM-DD 00:00:00   
		//      String regex = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";   
		return match(regex, str);   
	}   

	/** 
	 * @param str     ： 实际日期 
	 * @param format  ：日期格式，如yyyy-MM-dd 
	 * @return 
	 * @throws ParseException 
	 * about version ：1.00 
	 * create time   : 2011-2-22-下午05:46:37 
	 * Description ： 判断是否是指定日期格式 
	 *         匹配则返回true 
	 *         不匹配则返回false 
	 */  
	public static boolean isDateFormat(String str, String format) throws ParseException {
		if (hasText(str) || hasText(format)) {
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setLenient(true);

		Date date = sdf.parse(str);
		String str2 = sdf.format(date);

		if (!str.equals(str2)) {
			return false;
		}else{
			return true;
		}
	}

	/** 
	 * @param str 
	 * @param sign  : 三种"+","-","all",分别表示正数、负数、正负都行 
	 * @return 
	 * about version ：1.00 
	 * create time   : 2011-2-22-下午05:31:02 
	 * Description ：校验指定类型的数字 
	 *         匹配则返回true 
	 *         不匹配则返回false 
	 */  
	public static boolean isNumber(String str,String sign)   
	{  
		String regex = "";  
		if("+".equals(sign)){  
			regex = "^[+]?[0-9]*$";  
		}else if("-".equals(sign)){  
			regex = "^[-][0-9]*$";  
		}else{  
			regex = "^[+-]?[0-9]*$";  
		}  
		return match(regex, str);  
	}   

	/** 
	 * @param str 
	 * @return 
	 * about version ：1.00 
	 * create time   : 2011-2-22-下午05:36:04 
	 * Description ：验证非0正整数 
	 *         匹配则返回true 
	 *         不匹配则返回false 
	 */  
	public static boolean isIntNumber(String str)  
	{   
		String regex = "^\\+?[1-9][0-9]*$";   
		return match(regex, str);   
	}   

	/** 
	 * @param str 
	 * @return 
	 * about version ：1.00 
	 * create time   : 2011-2-22-下午05:38:38 
	 * Description ：验证大写字母 
	 *         匹配则返回true 
	 *         不匹配则返回false 
	 */  
	public static boolean isUpChar(String str)   
	{   
		String regex = "^[A-Z]+$";   
		return match(regex, str);   
	}   

	/** 
	 * @param str 
	 * @return 
	 * about version ：1.00 
	 * create time   : 2011-2-22-下午05:39:14 
	 * Description ： 验证小写字母 
	 *         匹配则返回true 
	 *         不匹配则返回false 
	 */  
	public static boolean isLowChar(String str)   
	{   
		String regex = "^[a-z]+$";   
		return match(regex, str);   
	}   

	/** 
	 * @param str 
	 * @return 
	 * about version ：1.00 
	 * create time   : 2011-2-22-下午05:39:57 
	 * Description ：验证输入的是字母 
	 *         匹配则返回true 
	 *         不匹配则返回false 
	 */  
	public static boolean isLetter(String str)   
	{   
		String regex = "^[A-Za-z]+$";   
		return match(regex, str);   
	}   

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNull(Object obj) {
		if(obj == null)
			return true;
		return false;
	}
	
	/**
	 * Check that the given CharSequence is neither <code>null</code> nor of length 0.
	 * Note: Will return <code>true</code> for a CharSequence that purely consists of whitespace.
	 * <p><pre>
	 * StringUtils.hasLength(null) = false
	 * StringUtils.hasLength("") = false
	 * StringUtils.hasLength(" ") = true
	 * StringUtils.hasLength("Hello") = true
	 * </pre>
	 * @param str the CharSequence to check (may be <code>null</code>)
	 * @return <code>true</code> if the CharSequence is not null and has length
	 * @see #hasText(String)
	 */
	public static boolean hasLength(CharSequence str) {
		return (str != null && str.length() > 0);
	}

	/**
	 * Check that the given String is neither <code>null</code> nor of length 0.
	 * Note: Will return <code>true</code> for a String that purely consists of whitespace.
	 * @param str the String to check (may be <code>null</code>)
	 * @return <code>true</code> if the String is not null and has length
	 * @see #hasLength(CharSequence)
	 */
	public static boolean hasLength(String str) {
		return hasLength((CharSequence) str);
	}

	/**
	 * Check whether the given CharSequence has actual text.
	 * More specifically, returns <code>true</code> if the string not <code>null</code>,
	 * its length is greater than 0, and it contains at least one non-whitespace character.
	 * <p><pre>
	 * StringUtils.hasText(null) = false
	 * StringUtils.hasText("") = false
	 * StringUtils.hasText(" ") = false
	 * StringUtils.hasText("12345") = true
	 * StringUtils.hasText(" 12345 ") = true
	 * </pre>
	 * @param str the CharSequence to check (may be <code>null</code>)
	 * @return <code>true</code> if the CharSequence is not <code>null</code>,
	 * its length is greater than 0, and it does not contain whitespace only
	 * @see java.lang.Character#isWhitespace
	 */
	public static boolean hasText(CharSequence str) {
		if (!hasLength(str)) {
			return false;
		}
		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	/** 
	 * @param str 
	 * @param encoding : 编码格式,如GBK,   不输入默认为UTF-8 
	 * @return ：返回指定编码格式下字符串的长度 
	 * about version ：1.00 
	 * create time   : 2011-2-22-下午05:54:16 
	 * Description ：选择不同编码，返回字符串长度 
	 */  
	public static int checkLength(String str,String encoding) {  
		int length;  
		try {  
			if(encoding == null||"".equals(encoding)){  
				length = str.getBytes(DEFAULT_ENCODING).length;  
			}else{  
				length = str.getBytes(encoding).length;  
			}  
		} catch (UnsupportedEncodingException e) {  
			length = str.getBytes().length;  
		}  
		return length;  
	}  




	/** 
	 * @param regex 
	 * @param str 
	 * @return 
	 * about version ：1.00 
	 * create time   : 2011-2-22-下午04:41:57 
	 * Description ： 正则表达式验证方法 
	 *         匹配表达式则返回true 
	 *         不匹配则返回false 
	 */  
	private static boolean match(String regex, String str)  
	{   
		Pattern pattern = Pattern.compile(regex);   
		Matcher matcher = pattern.matcher(str);   
		return matcher.matches();   
	}  
}  