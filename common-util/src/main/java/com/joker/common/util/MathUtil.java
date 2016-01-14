package com.joker.common.util;

import java.util.Random;

public class MathUtil {

	public static int random(int min, int max) {
		return Math.round((float) Math.random() * (max - min)) + min;
	}

	public static float randomFloat(float min, float max) {
		return (float) (Math.random() * (max - min) + min);
	}

	public static int randInt(int range) {
		if (range < 1) {
			return 0;
		}
		return (int) (Math.random() * range);
	}

	public static int toUAngle(int angle) {
		if (angle > -1 && angle < 360)
			return angle;
		angle %= 360;
		if (angle < 0)
			angle += 360;
		return angle;
	}

	public static int getCrossAngle(int source, int target) {
		if (source == target)
			return 0;
		if (source >= 360)
			source -= 360;
		else if (source < 0)
			source += 360;
		if (target >= 360)
			target -= 360;
		else if (target < 0)
			target += 360;
		int angle;
		if (source < target) {
			angle = target - source;
			if (angle > 180) {
				angle = 360 - angle;
				return -angle;
			} else
				return angle;
		} else {
			angle = source - target;
			if (angle > 180) {
				angle = 360 - angle;
				return angle;
			} else
				return -angle;
		}
	}

	public static void swap(int[] data, int i, int j) {
		if (i == j) {
			return;
		}
		data[i] = data[i] + data[j];
		data[j] = data[i] - data[j];
		data[i] = data[i] - data[j];
	}

	public static void shuffleSort(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			int j = (int) (data.length * Math.random());
			swap(data, i, j);
		}
	}

    /**
     * 随机指定范围内N个不重复的数
     * 在初始化的无重复待选数组中随机产生一个数放入结果中，
     * 将待选数组被随机到的数，用待选数组(len-1)下标对应的数替换
     * 然后从len-2里随机产生下一个随机数，如此类推
     * @param max  指定范围最大值
     * @param min  指定范围最小值
     * @param n  随机数个数
     * @return int[] 随机数结果集
     */
    public static int[] randomArray(int min, int max, int n){
        int len = max - min + 1;

        if(max < min || n > len){
            return null;
        }

        //初始化给定范围的待选数组
        int[] source = new int[len];
        for (int i = min; i < min+len; i++){
            source[i-min] = i;
        }

        int[] result = new int[n];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            //待选数组0到(len-2)随机一个下标
            index = Math.abs(rd.nextInt() % len--);
            //将随机到的数放入结果集
            result[i] = source[index];
            //将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换
            source[index] = source[len];
        }
        return result;
    }
}
