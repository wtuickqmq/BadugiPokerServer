package com.joker.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @category 正则工具类
 */
public class RegexUtil {

	/**
	 * 
	 * <pre>
	 *  合法E-mail地址：    
	 *  必须包含一个并且只有一个符号“@”    
	 *  第一个字符不得是“@”或者“.”    
	 *  不允许出现“@.”或者.@    
	 *  结尾不得是字符“@”或者“.”    
	 *  允许“@”前的字符中出现“＋”    
	 *  不允许“＋”在最前面，或者“＋@”    
	 *  
	 * 正则表达式如下：    
	 * -----------------------------------------------------------------------    
	 * ^(\w+((-\w+)|(\.\w+))*)\+\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$  
	 * 
	 * ^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$
	 * 
	 * ^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$
	 * -----------------------------------------------------------------------    
	 * 
	 * 字符描述：    
	 * ^ ：匹配输入的开始位置。    
	 * \：将下一个字符标记为特殊字符或字面值。    
	 * ：匹配前一个字符零次或几次。    
	 * + ：匹配前一个字符一次或多次。    
	 * (pattern) 与模式匹配并记住匹配。    
	 * x|y：匹配 x 或 y。    
	 * [a-z] ：表示某个范围内的字符。与指定区间内的任何字符匹配。    
	 * \w ：与任何单词字符匹配，包括下划线。    
	 * $ ：匹配输入的结尾。
	 * </pre>
	 */
	public static final String CHECK_MAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

	/**
	 * 验证IP地址
	 */
	public static final String CHECK_IP = "\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b";

	/**
	 * 验证日期时间，解决润月
	 */
	public static final String CHECK_DFATETIME = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";

	/**
	 * 验证手机号码
	 * 
	 * 验证手机号码
	 * 
	 * 要更加准确的匹配手机号码只匹配11位数字是不够的，比如说就没有以144开始的号码段，
	 * 
	 * 故先要整清楚现在已经开放了多少个号码段，国家号码段分配如下：
	 * 
	 * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
	 * 
	 * 联通：130、131、132、152、155、156、185、186
	 * 
	 * 电信：133、153、180、189、（1349卫通）
	 * 
	 * @see http://blog.myspace.cn/e/405268924.htm
	 */
	public static final String CHECK_PHONE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

	/**
	 * 验证字符串是否是数值类型
	 */
	public static final String CHECK_STRING = "^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$";

	private static boolean check(String _regex, CharSequence _input) {
		Pattern regex = Pattern.compile(_regex);
		Matcher matcher = regex.matcher(_input);
		boolean isMatched = matcher.matches();
		return isMatched;
	}

	/**
	 * 邮箱是否正确
	 * 
	 * @param email
	 */
	public static boolean isMail(String email) {
		return check(CHECK_MAIL, email);
	}

	/**
	 * 手机号码是否正确
	 * 
	 * @param phone
	 */
	public static boolean isPhone(String phone) {
		return check("^0{0,1}(13[0-9]|15[0-9]|15[0-2]|18[0]|18[5-9])[0-9]{8}$", phone);
	}

	/**
	 * 验证日期时间是否正确
	 * 
	 * @param dateTime
	 */
	public static boolean isDateTime(String dateTime) {
		return check(CHECK_DFATETIME, dateTime);
	}

	/**
	 * 验证字符串是否为数值
	 * 
	 * @param num
	 */
	public static boolean isNum(String num) {
		return check(CHECK_STRING, num);
	}

}
