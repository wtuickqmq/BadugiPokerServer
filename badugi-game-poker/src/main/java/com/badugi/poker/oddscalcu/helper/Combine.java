package com.badugi.poker.oddscalcu.helper;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Combine {

	/**
	 * 从数组的n个元素中取m个元素的组合取法
	 * 
	 * @param array
	 * @param m
	 * @param list
	 * @return
	 */
	public static List<String> getCombineList(final String[] array, int m) {
		int n = array.length;
		if (n < m)
			throw new IllegalArgumentException("Error   n   <   m");
		BitSet bs = new BitSet(n);
		for (int i = 0; i < m; i++) {
			bs.set(i, true);
		}
		int size = (int) getCombineCount(m, n);
		List<String> list = new ArrayList<String>(size);
		do {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < n; i++)
				if (bs.get(i)) {
					sb.append(array[i]).append(',');
				}
			sb.setLength(sb.length() - 1);
			list.add(sb.toString());
		} while (moveNext(bs, n));
		return list;
	}

	/**
	 * 从数组的n个元素中取m个元素的组合取法
	 * 
	 * @param array
	 * @param m
	 * @param list
	 * @return
	 */
	public static List<int[]> getCombineList(final int[] array, int m) {
		int n = array.length;
		if (n < m)
			throw new IllegalArgumentException("Error   n   <   m");
		BitSet bs = new BitSet(n);
		for (int i = 0; i < m; i++) {
			bs.set(i, true);
		}
		int size = (int) getCombineCount(m, n);
		List<int[]> list = new ArrayList<int[]>(size);
		int[] arr;
		int j = 0;
		do {
			arr = new int[m];
			for (int i = 0; i < n; i++)
				if (bs.get(i)) {
					// sb.append(array[i]).append(',');
					arr[j++] = array[i];
				}
			// sb.setLength(sb.length() - 1);
			list.add(arr);
			j = 0;
		} while (moveNext(bs, n));
		return list;
	}

	/**
	 * 1、start 第一个true片段的起始位，end截止位 2、把第一个true片段都置false
	 * 3、数组从0下标起始到以第一个true片段元素数量减一为下标的位置都置true 4、把第一个true片段end截止位置true
	 * 
	 * @param bs
	 *            数组是否显示的标志位
	 * @param n
	 *            数组长度
	 * @return boolean 是否还有其他组合
	 */
	private static boolean moveNext(final BitSet bs, int n) {
		int start = -1;
		while (start < n)
			if (bs.get(++start))
				break;
		if (start >= n)
			return false;

		int end = start;
		while (end < n)
			if (!bs.get(++end))
				break;
		if (end >= n)
			return false;
		for (int i = start; i < end; i++)
			bs.set(i, false);
		for (int i = 0; i < end - start - 1; i++)
			bs.set(i);
		bs.set(end);
		return true;
	}

	/**
	 * 从n个数字中选择m个数字
	 * 
	 * @param a
	 * @param m
	 * @return
	 */
	public static List<int[]> getCombineListQuick(int[] a, int m) {
		int n = a.length;
		if (m > n) {
			throw new IllegalArgumentException("Error   n   <   m");
		}
		List<int[]> result = new ArrayList<int[]>();
		int[] bs = new int[n];
		for (int i = 0; i < n; i++) {
			bs[i] = 0;
		}
		// 初始化
		for (int i = 0; i < m; i++) {
			bs[i] = 1;
		}
		boolean flag = true;
		boolean tempFlag = false;
		int pos = 0;
		int sum = 0;
		// 首先找到第一个10组合，然后变成01，同时将左边所有的1移动到数组的最左边
		do {
			sum = 0;
			pos = 0;
			tempFlag = true;
			result.add(print(bs, a, m));
			for (int i = 0; i < n - 1; i++) {
				if (bs[i] == 1 && bs[i + 1] == 0) {
					bs[i] = 0;
					bs[i + 1] = 1;
					pos = i;
					break;
				}
			}
			// 将左边的1全部移动到数组的最左边
			for (int i = 0; i < pos; i++) {
				if (bs[i] == 1) {
					sum++;
				}
			}
			for (int i = 0; i < pos; i++) {
				if (i < sum) {
					bs[i] = 1;
				} else {
					bs[i] = 0;
				}
			}
			// 检查是否所有的1都移动到了最右边
			for (int i = n - m; i < n; i++) {
				if (bs[i] == 0) {
					tempFlag = false;
					break;
				}
			}
			if (tempFlag == false) {
				flag = true;
			} else {
				flag = false;
			}

		} while (flag);
		result.add(print(bs, a, m));
		return result;
	}

	private static int[] print(int[] bs, int[] a, int m) {
		int[] result = new int[m];
		int pos = 0;
		for (int i = 0; i < bs.length; i++) {
			if (bs[i] == 1) {
				result[pos] = a[i];
				pos++;
			}
		}
		return result;
	}

	/**
	 * 从n个元素中取出m个元素的组和数
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static long getCombineCount(int m, int n) {
		if (m < 0 || n < 0 || n < m) {
			return 0;
		} // 当m小于0时返回0
		long n1 = 1, n2 = 1;
		for (long i = n, j = 1; j <= m; n1 *= i--, n2 *= j++)
			;
		return n1 / n2;
	}

	/**
	 * 获取组合注数
	 * */

	public static void main(String[] args) throws Exception {
		long i = getCombineCount(5, 48);
		System.out.println( i );
	}

	private static void compare(int i, int j) {
		if (i == j) {
			i = j;
		} else {
			i = 45 + j;
		}
	}

}
