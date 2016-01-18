package com.badugi.game.logic.util;

/**
 * @copyright：Copyright 2011  highesthelp.com All Rights Reserved
 * @author: weijie
 * @email: <a href="mailto:jackstudiomaster@gmail.com">jackie</a>
 * @createTime: 2011-12-28
 * @description：
 */
import java.math.BigDecimal;

public class MathExtendUtils {
	// 默认除法运算精度
	private static final int DEFAULT_DIV_SCALE = 10;

	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}
	
	public static double add(double...ds) {
		BigDecimal b = BigDecimal.ZERO;
		for(double d:ds){
			b=b.add(BigDecimal.valueOf(d));
		}
		return b.doubleValue();
	}

	public static String add(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2).toString();
	}

	public static double subtract(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}
	
	public static double subtract(double...ds) {
		BigDecimal b = BigDecimal.ZERO;
		for(double d:ds){
			b=b.subtract(BigDecimal.valueOf(d));
		}
		return b.doubleValue();
	}

	public static String subtract(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.subtract(b2).toString();
	}

	public static double multiply(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	public static String multiply(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.multiply(b2).toString();
	}

	public static double divide(double v1, double v2) {
		return divide(v1, v2, DEFAULT_DIV_SCALE);
	}

	public static double divide(double v1, double v2, int scale) {
		return divide(v1, v2, scale, BigDecimal.ROUND_HALF_EVEN);
	}

	public static double divide(double v1, double v2, int scale, int round_mode) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, round_mode).doubleValue();
	}

	public static String divide(String v1, String v2) {
		return divide(v1, v2, DEFAULT_DIV_SCALE);
	}

	public static String divide(String v1, String v2, int scale) {
		return divide(v1, v2, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_EVEN);
	}

	public static String divide(String v1, String v2, int scale, int round_mode) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2, scale, round_mode).toString();
	}

	public static double round(double v, int scale) {
		return round(v, scale, BigDecimal.ROUND_HALF_EVEN);
	}

	public static double round(double v, int scale, int round_mode) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		return b.setScale(scale, round_mode).doubleValue();
	}

	public static String round(String v, int scale) {
		return round(v, scale, BigDecimal.ROUND_HALF_EVEN);
	}

	public static String round(String v, int scale, int round_mode) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(v);
		return b.setScale(scale, round_mode).toString();
	}
	
	/**
	 * 某个范围的随机数
	 */
	public static double betround(int min, int max) {
		double chips=(double)Math.round(Math.random()*(max-min)+min);
		return chips;
	}
	
	public static int betroundInt(int min, int max) {
		int chips=(int)Math.round(Math.random()*(max-min)+min);
		return chips;
	}
	
	public static void main(String[] args) {

		System.out.println(add(1,2));
		
			/*List<Double> retList = new ArrayList<Double>();
				String[] ids = "-2000.0,-10891.0,17554.22,-2208.0,-2495.22,40.0".split(",");
				for(int i=0;i<ids.length;i++){
					retList.add(Double.valueOf(ids[i]));
				}
				double all = 0;
				for(int i=0;i<retList.size();i++){
					all = add(all,retList.get(i));
					System.out.println(all);
				}*/
				
	}
	
	
}