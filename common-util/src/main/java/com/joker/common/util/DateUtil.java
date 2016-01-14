package com.joker.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * 日期相关工具
 * 
 * @author linxiaokai
 * @version 2012-9-27 下午5:14:04
 */
public final class DateUtil {

	private DateUtil() {
	}

	/**
	 * 获取连续的天数
	 * 
	 * @param days
	 *            <pre>
	 * example:
	 * 	java.util.List<String> days = Lists.newArrayList();
	 * 		days.add("2013-01-06");
	 * 		days.add("2013-01-05");
	 * 		days.add("2013-01-04");
	 * 		days.add("2013-01-03");
	 * 		days.add("2013-01-01");
	 * </pre>
	 * 
	 */
	public static int getContinuous(List<String> days, boolean isFormatInt) {
		int times = 0;
		 days.remove(DateUtil.getDateToDay());
		int length = days.size();
		
		for (int i = 0; i < length; i++) {
			Calendar c = DateUtil.nextDate(-i - 1);
			String day = isFormatInt ? DateUtil.getDateInt(c) : DateUtil.getDateToDay(c);
			if (day.equals(days.get(i))) {
				times++;
			} else {
				break;
			}
		}
		return times;
	}

	/**
	 * 取得时间到天数 <br/>
	 * 格式:2013-03-03
	 */
	public static String getDateToDay() {
		Calendar c = Calendar.getInstance();
		return getDateToDay(c);
	}

	/**
	 * 取得时间整数 <br/>
	 * 格式:20130303
	 */
	public static String getDateInt() {
		Calendar c = Calendar.getInstance();
		return getDateInt(c);
	}

	/**
	 * 取得日期整点时间 <br/>
	 * 格式:2013-03-03 10:00:00
	 */
	public static String getDateHour() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return toInfo(c.getTime());
	}

	/**
	 * 取得日期整点时间 <br/>
	 * 格式:2013-03-03 10:10:00
	 */
	public static String getDateMinute() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.SECOND, 0);
		return toInfo(c.getTime());
	}

	/**
	 * 取得标准日期时间 <br/>
	 * 格式:2013-03-03 10:01:36
	 */
	public static String getDateTime() {
		Calendar c = Calendar.getInstance();
		return toInfo(c.getTime());
	}

	/**
	 * 将Java时间戳转换成UNIX时间戳
	 * 
	 * <pre>
	 * JAVA:1364363570283
	 * UNIX:1364363570
	 * </pre>
	 */
	public static int toUnixTime(long timeInMillis) {
		return (int) (timeInMillis / 1000);
	}

	/**
	 * 当前时间+24h
	 * 
	 * @return
	 */
	public static Calendar nextDate() {
		return nextDate(1);
	}

	public static Calendar nextDateByZore() {
		return nextDateByZore(1);
	}

	public static Calendar nextDateByZore(int add) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, add);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c;
	}

	public static Calendar getHourByZore(int hour) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.HOUR_OF_DAY, hour);
		return c;
	}

	/**
	 * 获取到第二天凌晨剩余的秒数
	 */
	public static int getLeftCost() {
		int temp = (int) (nextDateByZore().getTimeInMillis() - System.currentTimeMillis()) / 1000;
		return temp;
	}

	/**
	 * 往前(后)推移几天
	 * 
	 * @param val
	 *            要推移的天数
	 */
	public static Calendar nextDate(int val) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, val);
		return c;
	}

	/**
	 * 获取当前年份
	 */
	public static int getYear() {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		return year;
	}

	/**
	 * 获取现在是今年的第几月
	 */
	public static int getMonth() {
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH) + 1;
		return month;
	}

	/**
	 * 获取现在是当月的第几周
	 */
	public static int getWeekInMonth() {
		Calendar c = Calendar.getInstance();
		int week = c.get(Calendar.WEEK_OF_MONTH);
		return week;
	}

	/**
	 * 获取现在是今年的第几周
	 */
	public static int getWeekInYear() {
		Calendar c = Calendar.getInstance();
		int week = c.get(Calendar.WEEK_OF_YEAR);
		return week;
	}

	/**
	 * 获取今天是这个月底第几天
	 */
	public static int getDay() {
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_MONTH);
		return day;
	}

	/**
	 * 获取今天是这周的第几天 星期天算这个礼拜的第一天
	 */
	public static int getDayInWeek() {
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_WEEK);
		return day;
	}

	/**
	 * 获取系统当前整点
	 */
	public static int getHour() {
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		return hour;
	}

	/**
	 * 获取系统当前分钟
	 */
	public static int getMinute() {
		Calendar c = Calendar.getInstance();
		int minute = c.get(Calendar.MINUTE);
		return minute;
	}

	/**
	 * 获取系统当前秒数
	 */
	public static int getSecond() {
		Calendar c = Calendar.getInstance();
		int second = c.get(Calendar.SECOND);
		return second;
	}

	/**
	 * 时间差计算
	 */
	public static String costTime(long time1, long time2) {
		long sub = time1 - time2;
		// yyyy-MM-dd HH:mm:ss
		String time = "";
		// 多少小时
		long remainder = sub % (3600 * 1000);
		long result = sub / (3600 * 1000);
		if (result < 10) {
			time += "00" + result;
		} else if (result < 100) {
			time += "0" + result;
		} else {
			time += "" + result;
		}
		// 多少分钟
		sub = remainder;
		remainder = sub % (60 * 1000);
		result = sub / (60 * 1000);
		if (result < 10) {
			time += ":0" + result;
		} else {
			time += ":" + result;
		}
		// 多少秒
		sub = remainder;
		result = sub / (1000);
		if (result < 10) {
			time += ":0" + result;
		} else {
			time += ":" + result;
		}

		return time;
	}

	public static String getDate(long time) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(time);
		return getDateInt(c);
	}

	public static String getDateInt(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int mont = c.get(Calendar.MONTH) + 1;
		int days = c.get(Calendar.DAY_OF_MONTH);
		return year + "" + (mont < 10 ? "0" + mont : mont) + "" + (days < 10 ? "0" + days : days);
	}

	public static String getDateToDay(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int mont = c.get(Calendar.MONTH) + 1;
		int days = c.get(Calendar.DAY_OF_MONTH);
		return year + "-" + (mont < 10 ? "0" + mont : mont) + "-" + (days < 10 ? "0" + days : days);
	}

	public static Calendar getCalendar() {
		return Calendar.getInstance();
	}

	public static long getTime() {
		return getTime(getCalendar());
	}

	public static long getTime(Calendar c) {
		return c.getTimeInMillis();
	}

	public static String format() {
		return toInfo(getCalendar());
	}

	/**
	 * @param date
	 */
	public static String toInfo(Date date) {
		return toInfo(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * @return
	 */
	public static String toInfo() {
		return toInfo(getCalendar().getTime(), "yyyy-MM-dd");
	}

	/**
	 * 把date格式化成YYYY-MM-DD的格式
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateMedium(Date date) {
		return DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);
	}

	/**
	 * @param date
	 * @param dateFromat
	 */
	public static String toInfo(Date date, String dateFromat) {
		SimpleDateFormat format = new SimpleDateFormat(dateFromat);
		return format.format(date);
	}

	/**
	 * @param calendar
	 */
	public static String toInfo(Calendar calendar) {
		return toInfo(calendar.getTime());
	}

	/**
	 * @param hour
	 * @param mins
	 */
	public static Calendar setCalendar(int hour, int mins) {
		return setCalendar(hour, mins, 0);
	}

	/**
	 * @param hour
	 * @param mins
	 * @param seco
	 */
	public static Calendar setCalendar(int hour, int mins, int seco) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, mins);
		c.set(Calendar.SECOND, seco);
		return c;
	}

	/**
	 * @param day
	 * @param hour
	 * @param mins
	 * @param seco
	 */
	public static Calendar setCalendar(int day, int hour, int mins, int seco) {
		Calendar c = setCalendar(hour, mins, seco);
		c.set(Calendar.DAY_OF_MONTH, day);
		return c;
	}

	/**
	 * @param mont
	 * @param day
	 * @param hour
	 * @param mins
	 * @param seco
	 */
	public static Calendar setCalendar(int mont, int day, int hour, int mins, int seco) {
		Calendar c = setCalendar(day, hour, mins, seco);
		c.set(Calendar.DAY_OF_MONTH, day);
		return c;
	}

	/**
	 * 计算从当前时间currentDate开始，满足条件 hourOfDay, minuteOfHour, secondOfMinite的最近时间
	 * 
	 * @return
	 */
	public static Calendar getEarliestDate(Calendar currentDate, int hourOfDay, int minuteOfHour, int secondOfMinite) {
		int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);
		int currentHour = currentDate.get(Calendar.HOUR_OF_DAY);
		int currentMinute = currentDate.get(Calendar.MINUTE);
		int currentSecond = currentDate.get(Calendar.SECOND);
		boolean next = false;
		if (hourOfDay < currentHour) {
			next = true;
		} else if (hourOfDay == currentHour) {
			if (minuteOfHour < currentMinute) {
				next = true;
			} else if (minuteOfHour == currentSecond) {
				if (secondOfMinite < currentSecond) {
					next = true;
				}
			}
		}
		if (next) {
			currentDate.set(Calendar.DAY_OF_MONTH, currentDay + 1);
		}
		currentDate.set(Calendar.HOUR_OF_DAY, hourOfDay);
		currentDate.set(Calendar.MINUTE, minuteOfHour);
		currentDate.set(Calendar.SECOND, secondOfMinite);
		return currentDate;
	}

	/**
	 * 计算从当前时间currentDate开始，满足条件dayOfWeek, hourOfDay, minuteOfHour,
	 * secondOfMinite的最近时间
	 * 
	 * @return
	 */
	public static Calendar getEarliestDate(Calendar currentDate, int dayOfWeek, int hourOfDay, int minuteOfHour, int secondOfMinite) {
		// 计算当前时间的WEEK_OF_YEAR,DAY_OF_WEEK, HOUR_OF_DAY, MINUTE,SECOND等各个字段值
		int currentWeekOfYear = currentDate.get(Calendar.WEEK_OF_YEAR);
		int currentDayOfWeek = currentDate.get(Calendar.DAY_OF_WEEK);
		int currentHour = currentDate.get(Calendar.HOUR_OF_DAY);
		int currentMinute = currentDate.get(Calendar.MINUTE);
		int currentSecond = currentDate.get(Calendar.SECOND);

		// 如果输入条件中的dayOfWeek小于当前日期的dayOfWeek,则WEEK_OF_YEAR需要推迟一周
		boolean weekLater = false;
		if (dayOfWeek < currentDayOfWeek) {
			weekLater = true;
		} else if (dayOfWeek == currentDayOfWeek) {
			// 当输入条件与当前日期的dayOfWeek相等时，如果输入条件中的
			// hourOfDay小于当前日期的
			// currentHour，则WEEK_OF_YEAR需要推迟一周
			if (hourOfDay < currentHour) {
				weekLater = true;
			} else if (hourOfDay == currentHour) {
				// 当输入条件与当前日期的dayOfWeek, hourOfDay相等时，
				// 如果输入条件中的minuteOfHour小于当前日期的
				// currentMinute，则WEEK_OF_YEAR需要推迟一周
				if (minuteOfHour < currentMinute) {
					weekLater = true;
				} else if (minuteOfHour == currentSecond) {
					// 当输入条件与当前日期的dayOfWeek, hourOfDay，
					// minuteOfHour相等时，如果输入条件中的
					// secondOfMinite小于当前日期的currentSecond，
					// 则WEEK_OF_YEAR需要推迟一周
					if (secondOfMinite < currentSecond) {
						weekLater = true;
					}
				}
			}
		}
		if (weekLater) {
			// 设置当前日期中的WEEK_OF_YEAR为当前周推迟一周
			currentDate.set(Calendar.WEEK_OF_YEAR, currentWeekOfYear + 1);
		}
		// 设置当前日期中的DAY_OF_WEEK,HOUR_OF_DAY,MINUTE,SECOND为输入条件中的值。
		currentDate.set(Calendar.DAY_OF_WEEK, dayOfWeek);
		currentDate.set(Calendar.HOUR_OF_DAY, hourOfDay);
		currentDate.set(Calendar.MINUTE, minuteOfHour);
		currentDate.set(Calendar.SECOND, secondOfMinite);
		return currentDate;
	}

	/**
	 * 获取当前周的星期一的当前时间
	 * 
	 * @param format
	 * @return
	 */
	public static String getWeekFirst(String format) {
		Calendar c = Calendar.getInstance();
		int days = getDayInWeek();
		c.add(GregorianCalendar.DATE, 2 - ((days == 1) ? 8 : days));
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(c.getTime());
	}
}
