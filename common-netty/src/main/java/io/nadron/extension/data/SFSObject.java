package io.nadron.extension.data;

import io.nadron.extension.serialization.DefaultObjectDumpFormatter;
import io.nadron.extension.serialization.DefaultSFSDataSerializer;
import io.nadron.extension.serialization.ISFSDataSerializer;
import io.nadron.util.BinaryUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SFSObject implements ISFSObject {
	private Map<String, SFSDataWrapper> dataHolder;
	private ISFSDataSerializer serializer;

	public static SFSObject newFromObject(Object o) {
		return (SFSObject) DefaultSFSDataSerializer.getInstance().pojo2sfs(o);
	}

	public static SFSObject newFromBinaryData(byte[] bytes) {
		return (SFSObject) DefaultSFSDataSerializer.getInstance().binary2object(bytes);
	}

	public static ISFSObject newFromJsonData(String jsonStr) {
		return DefaultSFSDataSerializer.getInstance().json2object(jsonStr);
	}

	public static SFSObject newFromResultSet(ResultSet rset) throws SQLException {
		return DefaultSFSDataSerializer.getInstance().resultSet2object(rset);
	}

	public static SFSObject newInstance() {
		return new SFSObject();
	}

	public SFSObject() {
		this.dataHolder = new ConcurrentHashMap();
		this.serializer = DefaultSFSDataSerializer.getInstance();
	}

	public Iterator<Map.Entry<String, SFSDataWrapper>> iterator() {
		return this.dataHolder.entrySet().iterator();
	}

	public boolean containsKey(String key) {
		return this.dataHolder.containsKey(key);
	}

	public boolean removeElement(String key) {
		return this.dataHolder.remove(key) != null;
	}

	public int size() {
		return this.dataHolder.size();
	}

	public byte[] toBinary() {
		return this.serializer.object2binary(this);
	}

	public String toJson() {
		return this.serializer.object2json(flatten());
	}

	public String getDump() {
		if (size() == 0) {
			return "[ Empty SFSObject ]";
		}
		return DefaultObjectDumpFormatter.prettyPrintDump(dump());
	}

	public String getDump(boolean noFormat) {
		if (!noFormat) {
			return dump();
		}
		return getDump();
	}

	private String dump() {
		StringBuilder buffer = new StringBuilder();
		buffer.append('{');

		for (String key : getKeys()) {
			SFSDataWrapper wrapper = get(key);
			buffer.append("(").append(wrapper.getTypeId().name().toLowerCase()).append(") ").append(key).append(": ");

			if (wrapper.getTypeId() == SFSDataType.SFS_OBJECT) {
				buffer.append(((SFSObject) wrapper.getObject()).getDump(false));
			} else if (wrapper.getTypeId() == SFSDataType.SFS_ARRAY) {
				buffer.append(((SFSArray) wrapper.getObject()).getDump(false));
			} else if (wrapper.getTypeId() == SFSDataType.BYTE_ARRAY) {
				buffer.append(DefaultObjectDumpFormatter.prettyPrintByteArray((byte[]) wrapper.getObject()));
			} else if (wrapper.getTypeId() == SFSDataType.CLASS) {
				buffer.append(wrapper.getObject().getClass().getName());
			} else {
				buffer.append(wrapper.getObject());
			}
			buffer.append(';');
		}

		buffer.append('}');

		return buffer.toString();
	}

	public String getHexDump() {
		// return ByteUtils.fullHexDump(toBinary());
		return BinaryUtils.getHexString(toBinary());
	}

	public boolean isNull(String key) {
		SFSDataWrapper wrapper = (SFSDataWrapper) this.dataHolder.get(key);

		if (wrapper == null) {
			return false;
		}
		return wrapper.getTypeId() == SFSDataType.NULL;
	}

	public SFSDataWrapper get(String key) {
		return (SFSDataWrapper) this.dataHolder.get(key);
	}

	public Boolean getBool(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return (Boolean) o.getObject();
	}

	public Collection<Boolean> getBoolArray(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return (Collection) o.getObject();
	}

	public Byte getByte(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return (Byte) o.getObject();
	}

	public byte[] getByteArray(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return (byte[]) o.getObject();
	}

	public Double getDouble(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return (Double) o.getObject();
	}

	public Collection<Double> getDoubleArray(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return (Collection) o.getObject();
	}

	public Float getFloat(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return (Float) o.getObject();
	}

	public Collection<Float> getFloatArray(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return (Collection) o.getObject();
	}

	public Integer getInt(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return (Integer) o.getObject();
	}

	public Collection<Integer> getIntArray(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return (Collection) o.getObject();
	}

	public Set<String> getKeys() {
		return this.dataHolder.keySet();
	}

	public Long getLong(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return (Long) o.getObject();
	}

	public Collection<Long> getLongArray(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return (Collection) o.getObject();
	}

	public ISFSArray getSFSArray(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return (ISFSArray) o.getObject();
	}

	public ISFSObject getSFSObject(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return (ISFSObject) o.getObject();
	}

	public Short getShort(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return (Short) o.getObject();
	}

	public Collection<Short> getShortArray(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return (Collection) o.getObject();
	}

	public Integer getUnsignedByte(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return Integer.valueOf(DefaultSFSDataSerializer.getInstance().getUnsignedByte(((Byte) o.getObject()).byteValue()));
	}

	public Collection<Integer> getUnsignedByteArray(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}

		DefaultSFSDataSerializer serializer = DefaultSFSDataSerializer.getInstance();
		Collection intCollection = new ArrayList();

		for (byte b : (byte[]) o.getObject()) {
			intCollection.add(Integer.valueOf(serializer.getUnsignedByte(b)));
		}

		return intCollection;
	}

	public String getUtfString(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return (String) o.getObject();
	}

	public Collection<String> getUtfStringArray(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return (Collection) o.getObject();
	}

	public Object getClass(String key) {
		SFSDataWrapper o = (SFSDataWrapper) this.dataHolder.get(key);

		if (o == null) {
			return null;
		}
		return o.getObject();
	}

	public void putBool(String key, boolean value) {
		putObj(key, Boolean.valueOf(value), SFSDataType.BOOL);
	}

	public void putBoolArray(String key, Collection<Boolean> value) {
		putObj(key, value, SFSDataType.BOOL_ARRAY);
	}

	public void putByte(String key, byte value) {
		putObj(key, Byte.valueOf(value), SFSDataType.BYTE);
	}

	public void putByteArray(String key, byte[] value) {
		putObj(key, value, SFSDataType.BYTE_ARRAY);
	}

	public void putDouble(String key, double value) {
		putObj(key, Double.valueOf(value), SFSDataType.DOUBLE);
	}

	public void putDoubleArray(String key, Collection<Double> value) {
		putObj(key, value, SFSDataType.DOUBLE_ARRAY);
	}

	public void putFloat(String key, float value) {
		putObj(key, Float.valueOf(value), SFSDataType.FLOAT);
	}

	public void putFloatArray(String key, Collection<Float> value) {
		putObj(key, value, SFSDataType.FLOAT_ARRAY);
	}

	public void putInt(String key, int value) {
		putObj(key, Integer.valueOf(value), SFSDataType.INT);
	}

	public void putIntArray(String key, Collection<Integer> value) {
		putObj(key, value, SFSDataType.INT_ARRAY);
	}

	public void putLong(String key, long value) {
		putObj(key, Long.valueOf(value), SFSDataType.LONG);
	}

	public void putLongArray(String key, Collection<Long> value) {
		putObj(key, value, SFSDataType.LONG_ARRAY);
	}

	public void putNull(String key) {
		this.dataHolder.put(key, new SFSDataWrapper(SFSDataType.NULL, null));
	}

	public void putSFSArray(String key, ISFSArray value) {
		putObj(key, value, SFSDataType.SFS_ARRAY);
	}

	public void putSFSObject(String key, ISFSObject value) {
		putObj(key, value, SFSDataType.SFS_OBJECT);
	}

	public void putShort(String key, short value) {
		putObj(key, Short.valueOf(value), SFSDataType.SHORT);
	}

	public void putShortArray(String key, Collection<Short> value) {
		putObj(key, value, SFSDataType.SHORT_ARRAY);
	}

	public void putUtfString(String key, String value) {
		putObj(key, value, SFSDataType.UTF_STRING);
	}

	public void putUtfStringArray(String key, Collection<String> value) {
		putObj(key, value, SFSDataType.UTF_STRING_ARRAY);
	}

	public void put(String key, SFSDataWrapper wrappedObject) {
		putObj(key, wrappedObject, null);
	}

	public void putClass(String key, Object o) {
		putObj(key, o, SFSDataType.CLASS);
	}

	public String toString() {
		return "[SFSObject, size: " + size() + "]";
	}

	private void putObj(String key, Object value, SFSDataType typeId) {
		if (key == null) {
			throw new IllegalArgumentException("SFSObject requires a non-null key for a 'put' operation!");
		}
		if (key.length() > 255) {
			throw new IllegalArgumentException("SFSObject keys must be less than 255 characters!");
		}
		if (value == null) {
			throw new IllegalArgumentException("SFSObject requires a non-null value! If you need to add a null use the putNull() method.");
		}
		if ((value instanceof SFSDataWrapper))
			this.dataHolder.put(key, (SFSDataWrapper) value);
		else
			this.dataHolder.put(key, new SFSDataWrapper(typeId, value));
	}

	private Map<String, Object> flatten() {
		Map map = new HashMap();
		DefaultSFSDataSerializer.getInstance().flattenObject(map, this);

		return map;
	}
}