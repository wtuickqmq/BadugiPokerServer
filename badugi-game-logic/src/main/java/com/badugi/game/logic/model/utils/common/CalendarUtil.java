package com.badugi.game.logic.model.utils.common;

import java.sql.Timestamp;
import java.util.Calendar;

public class CalendarUtil{
	
	/**
	 * 本月第一周 
	 */
	private static final int FIRST_WEEK_OF_THE_MONTH = 1;
	
	private static final int FIRST_DAY_OF_THE_MONTH = 1;
	
	/**
	 * 每周天数
	 */ 
	public static final int MAX_DAY_OF_WEEK = 7;
	
	/**
	 * 一天最大小时 
	 */
	public static final int MAX_HOUR_OF_DAY = 24;
	
	/**
	 * 一小时最大分钟数 
	 */
	public static final int MAX_MINUTE_OF_HOUR = 59;
	
	/**
	 * 一分钟最大秒数
	 */
	public static final int MAX_SECOND_OF_MINUTE = 59;
	
	/**
	 * 一小秒最大毫秒数 
	 */
	public static final int MAX_MILLISECOND_OF_SECOND = 999;
	
	/**
	 * 日历对象 
	 */
	public static Calendar getCalendar(){
		
		return getCalendar(null);
	}
	
	/**
	 * 日历对象 
	 */
	public static Calendar getCalendar(Integer year){
		
		return getCalendar(year, null, null);
	}
	
	/**
	 * 日历对象 
	 */
	public static Calendar getCalendar(Integer year, Integer month){
		
		return getCalendar(year, month, null);
	}

	/**
	 * 日历对象 
	 */
	public static Calendar getCalendar(Integer year, Integer month,Integer date){
		
		Calendar calendar = Calendar.getInstance();
		
		if(year != null) calendar.set(Calendar.YEAR, year);
		
		if(month != null) calendar.set(Calendar.MONTH, month - 1);
		
		if(date != null) calendar.set(Calendar.DAY_OF_MONTH, date);
		
		return calendar;
	}
	
	/**
	 * 得到当前日期 
	 */
	public static int getCurDay(){
		
		return getCalendar().get(Calendar.DATE);
	}
	
	/**
	 * 得到当月月份 
	 */
	public static int getCurMonth(){
		
		return getCalendar().get(Calendar.MONTH);
	}
	
	/**
	 * 得到当前年年份 
	 */
	public static int getCurYear(){
		
		return getCalendar().get(Calendar.YEAR);
	}

	/**
	 * 根据偏移小时得到时间对象  起始时间为当天0点0分0秒0毫秒    
	 * @param hour 偏移小时 
	 */
	public static Timestamp getTimeBy(int hour){
		
		return getTimeBy(hour, 0, 0, 0);
	}
	
	/**
	 * 根据偏移时间得到时间对象  起始时间为当天0点0分0秒0毫秒  
	 * @param hour 偏移小时
	 * @param minute 偏移分 (0 - 59)
	 * @param second 偏移秒 (0 - 59)
	 * @param millisecond 偏移毫秒 (0 - 999)
	 */
	public static Timestamp getTimeBy(int hour, int minute, int second, int millisecond){
		
		Calendar calendar = getCalendar();
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);
		calendar.set(Calendar.MILLISECOND, millisecond);
		
		return new Timestamp(calendar.getTimeInMillis());
	}
	
	/**
	 * 得到当月最大天数 
	 */
	public static int getCurMonthMaxDate(){
		
		return getCalendar().getActualMaximum(Calendar.DATE);
	}
	
	/**
	 * 得到 日期    
	 */
	public static int getDayOfMonthBy(Timestamp ts){
		
		Calendar calendar = getCalendar();
		if(ts != null) calendar.setTimeInMillis(ts.getTime());
		
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 得到 日期    
	 */
	public static int getDayOfMonthBy(java.sql.Date date){
		
		Calendar calendar = getCalendar();
		if(date != null) calendar.setTimeInMillis(date.getTime());
		
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 得到日期 
	 */
	public static int getDayOfMonthBy(long time){
		
		Calendar calendar = getCalendar();
		calendar.setTimeInMillis(time);
		
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 当月第一天  Timestamp对象
	 */
	public static Timestamp getFirstDayOfMonth(){
		
		return getFirstDayOfMonth(null);
	}
	
	/**
	 * 当月第一天  Timestamp对象
	 */
	public static Timestamp getFirstDayOfMonth(Calendar calendar){
		
		if(calendar == null) calendar = getCalendar();
		
		calendar.set(Calendar.DATE, FIRST_DAY_OF_THE_MONTH);
		
		return new Timestamp(calendar.getTimeInMillis());
	}
	
	/**
	 * 当月最后一天  Timestamp对象
	 */
	public static Timestamp getLastDayOfMonth(){
		
		return getLastDayOfMonth(null);
	}
	
	/**
	 * 当月最后一天  Timestamp对象
	 */
	public static Timestamp getLastDayOfMonth(Calendar calendar){
		
		if(calendar == null) calendar = getCalendar();
		
		int maxDays = calendar.getActualMaximum(Calendar.DATE);
		
		calendar.set(Calendar.DATE, maxDays);
		
		return new Timestamp(calendar.getTimeInMillis());
	}
	
	/**
	 * 得到该周第一天  
	 * @param weeknum 第几周 
	 */
	public static Timestamp getFirstDayOfWeek(int weeknum){
		
		return getFirstDayOfWeek(weeknum, null);
	}
	
	/**
	 * 得到该周第一天  
	 * @param weeknum 第几周 
	 */
	public static Timestamp getFirstDayOfWeek(int weeknum, Calendar calendar){
		
		if(calendar == null) calendar = getCalendar();
		
		// 如果是本月第一周 直接返回 1号
		if(weeknum == FIRST_WEEK_OF_THE_MONTH) return getFirstDayOfMonth();
		
		
		calendar.set(Calendar.WEEK_OF_MONTH, weeknum);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		
		return new Timestamp(calendar.getTimeInMillis());
	}
	
	/**
	 * 得到该周最后一天 
	 * @param weeknum 第几周 
	 */
	public static Timestamp getLastDayOfWeek(int weeknum){
		
		return getLastDayOfWeek(weeknum, null);
	}
	
	/**
	 * 得到该周最后一天   如果月份有偏移 则得到该月最后一天
	 * @param weeknum 第几周 
	 */
	public static Timestamp getLastDayOfWeek(int weeknum, Calendar calendar){
		
		if(calendar == null)calendar = getCalendar();

		calendar.set(Calendar.WEEK_OF_MONTH, weeknum);
		// 记录月份
		int month = calendar.get(Calendar.MONTH);
		
		// 设置为周六
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		
		int newmonth = calendar.get(Calendar.MONTH);
		
		int lastWeek = calendar.getActualMaximum(Calendar.DAY_OF_WEEK);
		//本月最后一周有跳月
		if(lastWeek == weeknum && month != newmonth)
		{
			calendar.set(Calendar.MONTH, month);
			
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getMaximum(Calendar.DAY_OF_MONTH));
		}
		
		return new Timestamp(calendar.getTimeInMillis());
	}
	/**
	 * 该月有几个星期几
	 * @param dayOfWeek 星期几  0星期日  1星期1 。。。
	 */
	public static int dayOfWeekInMonth(int dayOfWeek){
		
		Calendar calendar = getCalendar();
		
		// 该月天数
		int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);  
		int num = days / MAX_DAY_OF_WEEK;  
		int yu = days % MAX_DAY_OF_WEEK;  
		
		for(int i = 1; i <= yu; i++)
		{   
			calendar.set(Calendar.DAY_OF_MONTH,i); 
			
			if(1==calendar.get(Calendar.DAY_OF_WEEK) - dayOfWeek)
			{   
				num++;    
				break;   
			}  
		}
		return num;
	}
	
	public static void main(String[] args) {
		
		System.out.println(getLastDayOfWeek(1));
	}
}
