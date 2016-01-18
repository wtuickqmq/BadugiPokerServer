package com.badugi.game.logic.model.utils.common;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Date Utility Class This is used to convert Strings to Dates and Timestamps
 */

public class DateUtils
{

	@SuppressWarnings("unused")
	private final static String defaultDatePattern = null;

	public final static String PATTERN_HM = "HH:mm";
	public final static String PATTERN_YMD_ = "MM月dd日";

	public final static String PATTERN_YMD = "yyyy-MM-dd";

	public final static String PATTERN_YMD_INCLINE = "yyyy/MM/dd";

	public final static String PATTERN_YMDHMS = "yyyy-MM-dd HH:mm:ss";

	public final static String PATTERN_YM = "yyyy-MM";

	public final static String PATTERN_YMD_NOTAG = "yyyyMMdd";

	public final static String PATTERN_YMDHM = "yyyy/MM/dd HH:mm";

	/**
	 * 使SimpleDateFormat线程安全.
	 */
	private final static ThreadLocal<SimpleDateFormat> threadLocal_ymd = new ThreadLocal<SimpleDateFormat>()
	{
		@Override
		protected synchronized SimpleDateFormat initialValue()
		{
			return new SimpleDateFormat(PATTERN_YMD);
		}
	};

	private final static ThreadLocal<SimpleDateFormat> threadLocal_ymdhms = new ThreadLocal<SimpleDateFormat>()
	{
		@Override
		protected synchronized SimpleDateFormat initialValue()
		{
			return new SimpleDateFormat(PATTERN_YMDHMS);
		}
	};

	@SuppressWarnings("unused")
	private final static ThreadLocal<SimpleDateFormat> threadLocal_hm = new ThreadLocal<SimpleDateFormat>()
	{
		@Override
		protected synchronized SimpleDateFormat initialValue()
		{
			return new SimpleDateFormat(PATTERN_HM);
		}
	};

	private final static ThreadLocal<SimpleDateFormat> threadLocal_ymd_notag = new ThreadLocal<SimpleDateFormat>()
	{
		@Override
		protected synchronized SimpleDateFormat initialValue()
		{
			return new SimpleDateFormat(PATTERN_YMD_NOTAG);
		}
	};

	/**
	 * yyyy-MM-dd
	 * 
	 * @return SimpleDateFormat
	 */
	public static SimpleDateFormat getSimpleDateFormat2ymd()
	{
		return threadLocal_ymd.get();
	}

	/**
	 * yyyy-MM-dd HH:mm:ss.
	 * 
	 * @return SimpleDateFormat
	 */
	public static SimpleDateFormat getSimpleDateFormat2ymdhms()
	{
		return threadLocal_ymdhms.get();
	}

	/**
	 * yyyyMMdd
	 * 
	 * @return SimpleDateFormat
	 */
	public static SimpleDateFormat getSimpleDateFormat2ymd_notag()
	{
		return threadLocal_ymd_notag.get();
	}

	public static final Log log = LogFactory.getLog(DateUtils.class);

	/**
	 * This method generates a string representation of a date/time in the
	 * format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param strDate
	 *            a string representation of a date
	 * @return a converted Date object
	 * @see java.text.SimpleDateFormat
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String aMask, String strDate) throws ParseException
	{
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);
		if (log.isDebugEnabled())
		{
			log.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
		}

		try
		{
			date = df.parse(strDate);
		}
		catch (ParseException pe)
		{
			// log.error("ParseException: " + pe);
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}

	/**
	 * This method returns the current date time in the format: MM/dd/yyyy HH:MM
	 * a
	 * 
	 * @param theTime
	 *            the current time
	 * @return the current date/time
	 */
	public static String getTimeNow(Date theTime)
	{
		return getDateTime(PATTERN_HM, theTime);
	}

	public static String getDateStr(Date theTime)
	{
		return getDateTime(PATTERN_YMD, theTime);
	}
	public static String getDateStr_(Date theTime)
	{
		return getDateTime(PATTERN_YMD_, theTime);
	}

	/**
	 * This method generates a string representation of a date's date/time in
	 * the format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param aDate
	 *            a date object
	 * @return a formatted string representation of the date
	 * @see java.text.SimpleDateFormat
	 */
	public static String getDateTime(String aMask, Date aDate)
	{
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null)
		{
			log.error("aDate is null!");
		}
		else
		{
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	public static boolean isToday(java.sql.Date aDate)
	{
		final Date now = new Date();
		if (aDate != null) {
			String nowtime = getSimpleDateFormat2ymd_notag().format(now).toString();
			String createtime = getSimpleDateFormat2ymd_notag().format(aDate).toString();
			return nowtime.equals(createtime);
		}
		else {
			return false;
		}
	}

	public static boolean isToday(java.util.Date aDate)
	{
		final Date now = new Date();
		if (aDate != null) {
			String nowtime = getSimpleDateFormat2ymd_notag().format(now).toString();
			String createtime = getSimpleDateFormat2ymd_notag().format(aDate).toString();
			return nowtime.equals(createtime);
		}
		else {
			return false;
		}
	}

	public static Date addDate(Date date, int type, int intervel)
	{
		if (date == null)
		{
			date = new Date();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(type, intervel);
		return calendar.getTime();
	}

	/**
	 * �õ�����ʱ�������ٷ���
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int getMinuteMargin(Date beginDate, Date endDate)
	{
		int minute = 0;
		final int mOfMinute = 1000 * 60;
		final long divtime = (endDate.getTime() - beginDate.getTime());
		final long lminute = divtime % mOfMinute > 0 ? divtime / mOfMinute + 1 : divtime / mOfMinute;
		minute = Long.valueOf(lminute).intValue();
		return minute;
	}

	public static float dateDiff(Timestamp t1, Timestamp t2, int type)
	{
		float i = t1.getTime() - t2.getTime();
		float f = 0.0f;// i / (1000 * 60);
		switch (type)
		{
		case 1:// hour
			f = i / (1000 * 60 * 60);
			break;
		case 2:// min
			f = i / (1000 * 60);
			break;
		case 3:// sec
			f = i / (1000);
			break;
		case 0: // defaut is day
			f = i / (1000 * 60 * 60 * 24);
		}
		String temp = "#,##0.0";
		try
		{
			return Float.valueOf(new java.text.DecimalFormat(temp).format(f));
		}
		catch (Exception e)
		{
			;// System.out.println(e);
		}
		return f;
	}

	public static Timestamp dateAdd(Timestamp t1, Integer i, int type)
	{
		long interval = i * 1000 * 60 * 60 * 24l;
		Timestamp t = null;
		switch (type)
		{
		case 1:// hour
			interval = 1000 * 60 * 60 * i;
			t = new Timestamp(t1.getTime() + interval);
			break;
		case 2:// min
			interval = 1000 * 60 * i;
			t = new Timestamp(t1.getTime() + interval);
			break;
		case 3:// sec
			interval = 1000 * i;
			t = new Timestamp(t1.getTime() + interval);
			break;
		case 0: // defaut is day
			t = new Timestamp(t1.getTime() + interval);
			break;
		default:
			t = t1;
		}
		return t;
	}

	/**
	 * 获取月份的开始日期与结束日期 （结束日期为下月的一号）
	 * 
	 * @param date
	 *            日期
	 * @return Date[]
	 */
	public static Date[] getMonthOfYear(Date dateTime)
	{
		Date[] date = new Date[2];
		try
		{
			int monthfield, yearReport;
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateTime);
			yearReport = calendar.get(Calendar.YEAR);
			monthfield = calendar.get(Calendar.MONTH) + 1;
			Calendar lastDate = Calendar.getInstance();
			lastDate.set(Calendar.YEAR, yearReport);
			lastDate.set(Calendar.MONTH, monthfield - 1);
			lastDate.set(Calendar.DATE, 1);
			int year = lastDate.get(Calendar.YEAR);
			int month = lastDate.get(Calendar.MONTH) + 1;
			int day = lastDate.get(Calendar.DATE);
			String startDate = year + "-" + month + "-" + day;
			date[0] = getSimpleDateFormat2ymd().parse(startDate);
			lastDate.add(Calendar.MONTH, 1);
			lastDate.add(Calendar.DATE, -1);
			year = lastDate.get(Calendar.YEAR);
			month = lastDate.get(Calendar.MONTH) + 1;
			day = lastDate.get(Calendar.DATE);
			startDate = year + "-" + month + "-" + day + " 24" + ":" + "00" + ":" + "00";
			date[1] = new SimpleDateFormat(PATTERN_YMDHMS).parse(startDate);
		}
		catch (ParseException e)
		{
			log.error(e.getMessage(), e);
		}
		return date;
	}

	/**
	 * 获取日期 年 月 日
	 * 
	 * @param date
	 * @return
	 */
	public static int[] getYearAndMonthAndDay(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return new int[] { year, month, day };
	}

	/**
	 * 获取两个日期的时间差
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return 相隔天数
	 */
	public static int getTimeDifference(Date beginDate, Date endDate)
	{
		long DAY = 24L * 60L * 60L * 1000L;
		long day = endDate.getTime() - beginDate.getTime();
		return Long.valueOf(day / DAY).intValue();
	}

	public static int getMonths(Date date1, Date date2)
	{
		int iMonth = 0;
		try
		{
			Calendar objCalendarDate1 = Calendar.getInstance();
			objCalendarDate1.setTime(date1);
			Calendar objCalendarDate2 = Calendar.getInstance();
			objCalendarDate2.setTime(date2);
			if (objCalendarDate2.equals(objCalendarDate1))
				return 0;
			if (objCalendarDate1.after(objCalendarDate2))
			{
				Calendar temp = objCalendarDate1;
				objCalendarDate1 = objCalendarDate2;
				objCalendarDate2 = temp;
			}
			if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1.get(Calendar.YEAR))
				iMonth = (objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1.get(Calendar.YEAR)) * 12 + objCalendarDate2.get(Calendar.MONTH)
						- objCalendarDate1.get(Calendar.MONTH);
			else
				iMonth = objCalendarDate2.get(Calendar.MONTH) - objCalendarDate1.get(Calendar.MONTH);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return iMonth;
	}

	/**
	 * ȡ��ָ����ʽ�ĵ�ǰ���� Symbol Meaning Presentation Example ------ -------
	 * ------------ ------- G era designator (Text) AD y year (Number) 1996 M
	 * month in year (Text & Number) July & 07 d day in month (Number) 10 h hour
	 * in am/pm (1~12) (Number) 12 H hour in day (0~23) (Number) 0 m minute in
	 * hour (Number) 30 s second in minute (Number) 55 S millisecond (Number)
	 * 978 E day in week (Text) Tuesday D day in year (Number) 189 F day of week
	 * in month (Number) 2 (2nd Wed in July) w week in year (Number) 27 W week
	 * in month (Number) 2 a am/pm marker (Text) PM k hour in day (1~24)
	 * (Number) 24 K hour in am/pm (0~11) (Number) 0 z time zone (Text) Pacific
	 * Standard Time ' escape for text (Delimiter) '' single quote (Literal) '
	 * ��:yyyy-MM-dd HH:mm:ss.SSS
	 * 
	 * @param format
	 *            String
	 * @return String
	 */
	public static String getCurDateTime(String format)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date dateCurrentTime = new Date();
		String sCurrentTime = formatter.format(dateCurrentTime);
		return sCurrentTime;
	}

	/**
	 * ����תΪָ���ĸ�ʽ�ַ�
	 * 
	 * @param inputDateTime
	 *            Date
	 * @param format
	 *            String
	 * @return String
	 */
	public static String dateToString(Date inputDateTime, String format)
	{
		String outDateTime = "0000-00-00 00:00:00";
		try
		{
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			outDateTime = formatter.format(inputDateTime);
		}
		catch (Exception ex)
		{}
		return outDateTime;
	}

	/**
	 * �ַ�ת����
	 * 
	 * @param s
	 *            String
	 * @return Date
	 */
	public static Date StringToDate(String s)
	{
		Date date = new Date();
		try
		{
			SimpleDateFormat simpledateformat = new SimpleDateFormat(PATTERN_YMDHMS);
			ParsePosition parseposition = new ParsePosition(0);
			date = simpledateformat.parse(s, parseposition);
		}
		catch (Exception ex)
		{}
		return date;
	}

	/**
	 * �ַ�ת����
	 * 
	 * @param s
	 *            String
	 * @return Date
	 */
	public static Date StringToDate(String s, String reg)
	{
		Date date = new Date();
		try
		{
			SimpleDateFormat simpledateformat = new SimpleDateFormat(reg);
			ParsePosition parseposition = new ParsePosition(0);
			date = simpledateformat.parse(s, parseposition);
		}
		catch (Exception ex)
		{}
		return date;
	}

	public static Date DateStringToDate(String s)
	{
		Date date = new Date();
		try
		{
			SimpleDateFormat simpledateformat = new SimpleDateFormat(PATTERN_YMDHMS);
			ParsePosition parseposition = new ParsePosition(0);
			date = simpledateformat.parse(s, parseposition);
		}
		catch (Exception ex)
		{}
		return date;
	}

	public static Date TimeStringToDate(String s)
	{
		Date date = new Date();
		try
		{
			SimpleDateFormat simpledateformat = new SimpleDateFormat("HH:mm:ss");
			ParsePosition parseposition = new ParsePosition(0);
			date = simpledateformat.parse(s, parseposition);
		}
		catch (Exception ex)
		{}
		return date;
	}

	public static Timestamp String2Timestamp(String s, String fmt)
	{
		Timestamp ts = new Timestamp(new Date().getTime());
		try
		{
			SimpleDateFormat df = new SimpleDateFormat(fmt);
			ts = new Timestamp(df.parse(s).getTime());
			return ts;
		}
		catch (Exception ex)
		{}
		return ts;
	}

	/**
	 * 取出当前周的开始时间，既是周一凌晨0.0.0开始,返回的时时间戳
	 * 
	 * @return
	 */
	public static long CurrentWeekBegin() {
		Calendar currentDate = new GregorianCalendar();
		currentDate.setFirstDayOfWeek(Calendar.MONDAY);

		currentDate.set(Calendar.HOUR_OF_DAY, 0);
		currentDate.set(Calendar.MINUTE, 0);
		currentDate.set(Calendar.SECOND, 0);
		currentDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return currentDate.getTime().getTime();
	}

	/**
	 * 取出当前周的结束时间，既是周日晚59:59:59结束,返回的时时间戳
	 * 
	 * @return
	 */
	public static long CurrentWeekEnd() {
		Calendar currentDate = new GregorianCalendar();
		currentDate.setFirstDayOfWeek(Calendar.MONDAY);
		currentDate.set(Calendar.HOUR_OF_DAY, 23);
		currentDate.set(Calendar.MINUTE, 59);
		currentDate.set(Calendar.SECOND, 59);
		currentDate.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return currentDate.getTime().getTime();
	}

	/**
	 * 时间戳转换为字符串
	 * 
	 * @param time
	 * @param format
	 * @return
	 */
	public static String timestamp2Str(Timestamp time, String format) {
		Date date = null;
		if (null != time) {
			if (format == null) {
				format = PATTERN_YMDHMS;
			}
			date = new Date(time.getTime());
		}
		return dateToString(date, format);
	}

	/**
	 * ��ȡ��ǰ���ڵļ���
	 * 
	 * @return int 0 ��ȡ�쳣 1 ���� 2 �ļ� 3 �＾ 4 ����
	 */
	public static int getSeason()
	{
		int ret = 0;
		try
		{
			int month = Integer.parseInt(getCurDateTime("MM"));
			int day = Integer.parseInt(getCurDateTime("dd"));
			if (month > 1 && month <= 3)
				ret = 4;
			if (month == 3 && day > 19)
				ret = 1;
			if (month > 3 && month <= 6)
				ret = 1;
			if (month == 6 && day > 20)
				ret = 2;
			if (month > 6 && month <= 9)
				ret = 2;
			if (month == 9 && day > 21)
				ret = 3;
			if (month > 9 && month <= 12)
				ret = 3;
			if (month == 12 && day > 20)
				ret = 4;
		}
		catch (Exception ex)
		{}
		return ret;
	}

	/**
	 * 取出某一天为第几周 如果day为null则默认当前时间
	 * 
	 * @param day
	 * @return
	 */
	public static int getCurWeek(String day) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		if (day != null) {
			try {
				date = format.parse(day);
			}
			catch (ParseException e) {
				e.printStackTrace();
			}
		}
		else {
			date = new Date();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(date);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}
	/**
	 * 取出当前周 星期一日期
	 * 
	 * @return
	 */
	public static String curMon() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return sdf.format(c.getTime());
	}
	/**
	 * 某一个日期的前一个日期
	 * 
	 * @param d
	 *            ,某一个日期
	 * @param field
	 *            日历字段
	 *            y 年 M 月 d 日 H 时 m 分 s 秒
	 * @param amount
	 *            数量
	 * @return 一个日期
	 * @throws ParseException
	 */
	public static String getPreDateByString(String d, String field, int amount) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getSimpleDateFormat2ymdhms().parse(d));
		if (field != null && !field.equals("")) {
			if (field.equals("y")) {
				calendar.add(calendar.YEAR, amount);
			}
			else if (field.equals("M")) {
				calendar.add(calendar.MONTH, amount);
			}
			else if (field.equals("d")) {
				calendar.add(calendar.DAY_OF_MONTH, amount);
			}
			else if (field.equals("H")) {
				calendar.add(calendar.HOUR, amount);
			}
		}
		else {
			return null;
		}
		return getFormatDate(calendar.getTime());
	}
	public static String getFormatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	public static String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YMDHMS);
		return sdf.format(date);
	}
	public void main(String[] args)
	{
		int[] time = DateUtils.getYearAndMonthAndDay(addDate(null, Calendar.DATE, -17));
		System.out.println(time[0]);
		System.out.println(time[1]);
		System.out.println(time[2]);
	}
}
