package com.badugi.poker.oddscalcu.helper;

public class Percontion {

	/**
	 * 从N个元素中取出M个数的排列数
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public static int getPercontionCount(int m, int n) {
		int c = 1;
		for (int i = n - m; i < n; c *= ++i)
			;
		return c;
	}

	public static void main(String args[]) {
		System.out.println(getPercontionCount(3,10));
	}

}
