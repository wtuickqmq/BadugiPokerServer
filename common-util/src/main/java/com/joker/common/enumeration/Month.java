package com.joker.common.enumeration;

public enum Month {
	
	January(1),
	February(2),
	March(3),
	April(4),
	May(5),
	June(6),
	July(7),
	August(8),
	September(9),
	October(10),
	November(11),
	December(12);
	
	private String numberValue;
	private String placeholderValue;
	private String usEnValue;
	private String zhCnValue;
	private Month(int month){
		switch(month){
		case 1:
			numberValue = "1";
			placeholderValue = "01";
			usEnValue = "January";
			zhCnValue = "一月";
			break;
		case 2:
			numberValue = "2";
			placeholderValue = "02";
			usEnValue = "February";
			zhCnValue = "二月";
			break;
		case 3:
			numberValue = "3";
			placeholderValue = "03";
			usEnValue = "March";
			zhCnValue = "三月";
			break;
		case 4:
			numberValue = "4";
			placeholderValue = "04";
			usEnValue = "April";
			zhCnValue = "四月";
			break;
		case 5:
			numberValue = "5";
			placeholderValue = "05";
			usEnValue = "May";
			zhCnValue = "五月";
			break;
		case 6:
			numberValue = "6";
			placeholderValue = "06";
			usEnValue = "June";
			zhCnValue = "六月";
			break;
		case 7:
			numberValue = "7";
			placeholderValue = "07";
			usEnValue = "July";
			zhCnValue = "七月";
			break;
		case 8:
			numberValue = "8";
			placeholderValue = "08";
			usEnValue = "August";
			zhCnValue = "八月";
			break;
		case 9:
			numberValue = "9";
			placeholderValue = "09";
			usEnValue = "September";
			zhCnValue = "九月";
			break;
		case 10:
			numberValue = "10";
			placeholderValue = numberValue;
			usEnValue = "October";
			zhCnValue = "十月";
			break;
		case 11:
			numberValue = "11";
			placeholderValue = numberValue;
			usEnValue = "November";
			zhCnValue = "十一月";
			break;
		case 12:
			numberValue = String.valueOf(month);
			placeholderValue = numberValue;
			usEnValue = "December";
			zhCnValue = "十二月";
			break;
		default:
			throw new java.lang.NumberFormatException(month + " not month value !!");
		}
	}
	
	/**
	 * Get Number Value, e.g : 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12;
	 * @return
	 */
	public String getNumberValue(){
		return numberValue;
	}
	
	/**
	 * Get Placeholder Value, e.g : 1 = 01, 10 = 10;
	 * @return
	 */
	public String getPlaceholderValue(){
		return placeholderValue;
	}
	
	/**
	 * Us EN Month Express Value, e.g : January, February, March... October, November, December
	 * @return
	 */
	public String getUsEnValue(){
		return usEnValue;
	}
	
	/**
	 * Zh CN Month Express Value, e.g : 一月, 二月, 三月...十月, 十一月, 十二月
	 * @return
	 */
	public String getZhCnValue(){
		return zhCnValue;
	}
	
	/**
	 * Returns the month representation of the int argument.
	 * @param month an int.
	 * @return Month
	 */
	public static Month valueOf(int month){
		switch(month){
		case 1:
			return Month.January;
		case 2:
			return Month.February;
		case 3:
			return Month.March;
		case 4:
			return Month.April;
		case 5:
			return Month.May;
		case 6:
			return Month.June;
		case 7:
			return Month.July;
		case 8:
			return Month.August;
		case 9:
			return Month.September;
		case 10:
			return Month.October;
		case 11:
			return Month.November;
		case 12:
			return Month.December;
		default:
			return valueOf((month % 12) + 1);
		}
	}
}
