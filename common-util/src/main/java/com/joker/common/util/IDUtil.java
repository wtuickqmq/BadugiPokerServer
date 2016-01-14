package com.joker.common.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class IDUtil {

	private static ArrayList<Integer> _free = new ArrayList<Integer>();

	private static AtomicInteger _index = new AtomicInteger(1);

	public static int get() {
		synchronized (_free) {
			if (_free.size() > 0) {
				return _free.remove(0);
			} else {
				return _index.getAndIncrement();
			}
		}
	}

	public static void free(int id) {
		synchronized (_free) {
			if (!_free.contains(id)) {
				_free.add(id);
			}
		}
	}
}
