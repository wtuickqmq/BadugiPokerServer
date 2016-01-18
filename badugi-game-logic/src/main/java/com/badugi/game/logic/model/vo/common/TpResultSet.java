package com.badugi.game.logic.model.vo.common;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * tp自定义ResultSet(一个对象对应一行数据)
 * 
 * @author amin
 */
public class TpResultSet {

	/**
	 * 索引集合
	 */
	public Map<Integer, Object> idmap = new HashMap<Integer, Object>();
	/**
	 * 列名集合
	 */
	public Map<String, Object> cnmap = new HashMap<String, Object>();

	private static final int TYPE_INT = 1;
	private static final int TYPE_SHORT = 2;
	private static final int TYPE_DOUBLE = 3;
	private static final int TYPE_LONG = 4;
	private static final int TYPE_BIGDECIMAL = 5;
	private static final int TYPE_BIGINTEGER = 6;
	private static final int TYPE_STRING = 7;
	private static final int TYPE_DATE = 8;
	private static final int TYPE_TIMESTAMP = 9;

	public int getInt(Integer index) {
		return (Integer) getValueByIndex(index, TYPE_INT);
	}

	public int getInt(String name) {
		return (Integer) getValueByName(name, TYPE_INT);
	}

	public short getShort(Integer index) {
		return (Short) getValueByIndex(index, TYPE_SHORT);
	}

	public short getShort(String name) {
		return (Short) getValueByName(name, TYPE_SHORT);
	}

	public double getDouble(Integer index) {
		return (Double) getValueByIndex(index, TYPE_DOUBLE);
	}

	public double getDouble(String name) {
		return (Double) getValueByName(name, TYPE_DOUBLE);
	}

	public long getLong(Integer index) {
		return (Long) getValueByIndex(index, TYPE_LONG);
	}

	public long getLong(String name) {
		return (Long) getValueByName(name, TYPE_LONG);
	}

	public BigDecimal getBigDecimal(String name) {
		return (BigDecimal) getValueByName(name, TYPE_BIGDECIMAL);
	}

	public BigDecimal getBigDecimal(Integer index) {
		return (BigDecimal) getValueByIndex(index, TYPE_BIGDECIMAL);
	}

	public BigInteger getBigInteger(String name) {
		return (BigInteger) getValueByName(name, TYPE_BIGINTEGER);
	}

	public BigInteger getBigInteger(Integer index) {
		return (BigInteger) getValueByIndex(index, TYPE_BIGINTEGER);
	}

	public String getString(Integer index) {
		return (String) getValueByIndex(index, TYPE_STRING);
	}

	public String getString(String name) {
		return (String) getValueByName(name, TYPE_STRING);
	}

	public Date getDate(Integer index) {
		return (Date) getValueByIndex(index, TYPE_DATE);
	}

	public Date getDate(String name) {
		return (Date) getValueByName(name, TYPE_DATE);
	}

	public Timestamp getTimestamp(Integer index) {
		return (Timestamp) getValueByIndex(index, TYPE_TIMESTAMP);
	}

	public Timestamp getTimestamp(String name) {
		return (Timestamp) getValueByName(name, TYPE_TIMESTAMP);
	}

	private Object getObjectByIndex(Integer index) {
		return idmap.get(index);
	}

	private Object getObjectByName(String name) {
		return cnmap.get(name);
	}

	private Object getValueByIndex(Integer index, Integer type) {
		return getObjectValue(getObjectByIndex(index), type);
	}

	private Object getValueByName(String name, Integer type) {
		return getObjectValue(getObjectByName(name), type);
	}

	private Object getObjectValue(Object obj, Integer type) {
		if (obj == null) {
			switch (type) {
			case TYPE_INT:
				return 0;
			case TYPE_SHORT:
				return (short)0;
			case TYPE_DOUBLE:
				return Double.valueOf(0d);
			case TYPE_LONG:
				return Long.valueOf(0l);
			case TYPE_BIGDECIMAL:
				return BigDecimal.valueOf(0d);
			case TYPE_BIGINTEGER:
				return BigInteger.valueOf(0l);
			default:
				return null;
			}
		} else {
			switch (type) {
			case TYPE_INT:
				return Double.valueOf(String.valueOf(obj)).intValue();
			case TYPE_SHORT:
				return Double.valueOf(String.valueOf(obj)).shortValue();
			case TYPE_DOUBLE:
				return Double.valueOf(String.valueOf(obj));
			case TYPE_LONG:
				return Long.valueOf(String.valueOf(obj));
			case TYPE_BIGDECIMAL:
				return (BigDecimal) obj;
			case TYPE_BIGINTEGER:
				return (BigInteger) obj;
			case TYPE_STRING:
				return String.valueOf(obj);
			case TYPE_TIMESTAMP:
				return (Timestamp) obj;
			case TYPE_DATE:
				return (Date) obj;
			default:
				return null;
			}
		}
	}

}
