package com.badugi.game.logic.model.utils.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

@SuppressWarnings({"unchecked","rawtypes"})
public class MapUtils {

	/**
	 * map 转成 list
	 */
	public static List map2List(Map map) {
		List list = new ArrayList();
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Entry entry = (Entry) iter.next();
			list.add(entry.getValue());
		}
		return list;
	}

	/**
	 * 按map的key排序升序<br/>
	 * <font color="red">注：</font>只支持比较String类型的KEY,其他类型可使用sortKey2
	 */
	public static Map sortKey(Map map) {
		Map<Object, Object> mapVK = new TreeMap<Object, Object>(
				new Comparator<Object>() {
					public int compare(Object obj1, Object obj2) {
						Double v1 = Double.valueOf(obj1.toString());
						Double v2 = Double.valueOf(obj2.toString());
						return v1.compareTo(v2);
					}
				});
		Set col = map.keySet();
		Iterator iter = col.iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			Object value = (Object) map.get(key);
			mapVK.put(key, value);
		}
		return mapVK;
	}
	
	/**
	 * 按map的key排序降序<br/>
	 * <font color="red">注：</font>只支持比较String类型的KEY,其他类型可使用descKey2
	 */
	public static Map descKey(Map map) {
		Map<Object, Object> mapVK = new TreeMap<Object, Object>(
				new Comparator<Object>() {
					public int compare(Object obj1, Object obj2) {
						Double v1 = Double.valueOf(obj1.toString());
						Double v2 = Double.valueOf(obj2.toString());
						return v2.compareTo(v1);
					}
				});
		Set col = map.keySet();
		Iterator iter = col.iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			Object value = (Object) map.get(key);
			mapVK.put(key, value);
		}
		return mapVK;
	}
	
	/**
	 * 按map的value排序升序<br/>
	 * <font color="red">注：</font>只能比较数值类型的Value
	 */
	public static List<Map.Entry<Object, Object>> sortValue(Map map) {
		List<Map.Entry<Object, Object>> result = new ArrayList<Map.Entry<Object, Object>>(map.entrySet());
		Collections.sort(result, new Comparator<Map.Entry<Object, Object>>() {
			public int compare(Map.Entry<Object, Object> o1,
					Map.Entry<Object, Object> o2) {
					return Double.valueOf(o1.getValue().toString()).compareTo(Double.valueOf(o2.getValue().toString()));
				}
		});
		return result;
	}
	
	/**
	 * 按map的value排序降序<br/>
	 * <font color="red">注：</font>只能比较数值类型的Value
	 */
	public static List<Map.Entry<Object, Object>> descValue(Map map) {
		List<Map.Entry<Object, Object>> result = new ArrayList<Map.Entry<Object, Object>>(map.entrySet());
		Collections.sort(result, new Comparator<Map.Entry<Object, Object>>() {
			public int compare(Map.Entry<Object, Object> o1,
					Map.Entry<Object, Object> o2) {
					return Double.valueOf(o2.getValue().toString()).compareTo(Double.valueOf(o1.getValue().toString()));
				}
		});
		return result;
	}
	
	/**
	 * 按map的key排序升序<br/>
	 * <font color="red">注：</font>只能比较数值类型的KEY
	 */
	public static List<Map.Entry<Object, Object>> sortKey2(Map map) {
		List<Map.Entry<Object, Object>> result = new ArrayList<Map.Entry<Object, Object>>(map.entrySet());
		Collections.sort(result, new Comparator<Map.Entry<Object, Object>>() {
			public int compare(Map.Entry<Object, Object> o1,
					Map.Entry<Object, Object> o2) {
					return Double.valueOf(o1.getKey().toString()).compareTo(Double.valueOf(o2.getKey().toString()));
				}
		});
		return result;
	}
	
	/**
	 * 按map的key排序降序<br/>
	 * <font color="red">注：</font>只能比较数值类型的KEY
	 */
	public static List<Map.Entry<Object, Object>> descKey2(Map map) {
		List<Map.Entry<Object, Object>> result = new ArrayList<Map.Entry<Object, Object>>(map.entrySet());
		Collections.sort(result, new Comparator<Map.Entry<Object, Object>>() {
			public int compare(Map.Entry<Object, Object> o1,
					Map.Entry<Object, Object> o2) {
					return Double.valueOf(o2.getKey().toString()).compareTo(Double.valueOf(o1.getKey().toString()));
				}
		});
		return result;
	}

}
