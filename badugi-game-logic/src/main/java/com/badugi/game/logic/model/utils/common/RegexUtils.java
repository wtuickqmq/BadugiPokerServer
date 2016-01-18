package com.badugi.game.logic.model.utils.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * 
 * @author liuy
 * 
 */
public class RegexUtils{

	/**
	 * 一个或多个数字
	 */
	private static final String NUMBER_REGEX = "[0-9]+";

	/**
	 * 合并多个连续的字符 如：1-----2---3 替换为 1-2-3
	 * 
	 * @param model
	 *            要合并的字符 如 -
	 * @param str
	 * @return 合并后的字符串
	 */
	
	public String mergingStr(String model, String str) {
		if (str == null || "".equals(str)) {
			return str;
		}
		Pattern pattern = Pattern.compile(model + "{1,}");
		Matcher matcher = pattern.matcher(str);
		return matcher.replaceAll("-");
	}


	public String filterStr(String model, String str, String replace) {
		if (model == null) {
			// model="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？  {1,}]";
			// model = "(^\\D|([^a-zA-Z]))+";
			model = "([^0-9a-zA-Z])+";
		}
		if (null != str) {
			Pattern p = Pattern.compile(model);
			Matcher m = p.matcher(str);
			return m.replaceAll(replace).trim();
		} else {
			return null;
		}
	}


	public String filterHeadOrEndStr(String model, String str, String replace) {
		if (model == null) {
			model = "(^([^0-9a-zA-Z]*))|(([^0-9a-zA-Z]*)$)";
		}
		if (null != str) {
			Pattern p = Pattern.compile(model);
			Matcher m = p.matcher(str);
			return m.replaceAll(replace).trim();
		} else {
			return null;
		}
	}


	public Boolean isNumber(String str) {
		return this.validateString(RegexUtils.NUMBER_REGEX, str);
	}


	public Boolean validateString(String regex, String str) {
		return validateString(regex, str, Pattern.CASE_INSENSITIVE);
	}


	public Boolean validateString(String regex, String str, Integer flags) {
		Pattern p = null;
		if (flags == null) {
			p = Pattern.compile(regex);
		} else {
			p = Pattern.compile(regex, flags);
		}
		Matcher m = p.matcher(str);
		return m.matches();
	}

	public static void main(String[] args) {
		// UtilBeanLoader.getRegexUtil().filterStr("(<a\\s(\\w+(=('|\")(www.folica.com)+))(.*?)(/>|/a>))",
		// str, "");
		// String s = "www.folica.com";
		// RegexUtilImpl regexUtilImpl = new RegexUtilImpl();
		// System.out.println(regexUtilImpl.filterStr("(<a\\s(\\w+(=('|\")(.*)(www.folica.com)+))(.*?)(/>|/a>))",
		// "<a href=\"http://www.folica.com\" />//'<a href='www.folica.com' > aaa</a>~1-d 234~<a />00<a > aaa</a>99<a > aaa</a>77<a > aaa</a>",
		// ""));;
		String s = " table1__col1 = '1' and table2__col2='2' and taddfdddle2__col2='2' ";
		// RegexUtilImpl regexUtilImpl = new RegexUtilImpl();
		// s = regexUtilImpl.filterHeadOrEndStr(null, s, "");
		// s = regexUtilImpl.filterStr(null, s, " ");
		// System.out.println(s);
		Pattern p = Pattern.compile("( ?[a-zA-z]*[0-9]__)");
		Matcher m = p.matcher(s);
		System.out.println(m.matches());
		System.out.println(m.regionStart());
		System.out.println(m.regionEnd());
		System.out.println(m.groupCount());
		if (m.find()) {
			System.out.println(m.replaceAll(" "));
		}
	}


	public String substringBy(String str, int length) {
		String[] s = str.split("-");
		if (s.length > length) {
			str = "";
			for (int i = 0; i < length; i++) {
				str += s[i];
				if (i < length - 1) {
					str += "-";
				}
			}
		}
		return str;
	}

}
