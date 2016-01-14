package io.nadron.extension.serialization;

import io.nadron.extension.data.ISFSArray;
import io.nadron.extension.data.ISFSObject;
import io.nadron.extension.data.SFSArray;
import io.nadron.extension.data.SFSArrayLite;
import io.nadron.extension.data.SFSDataType;
import io.nadron.extension.data.SFSDataWrapper;
import io.nadron.extension.data.SFSObject;
import io.nadron.extension.data.SFSObjectLite;
import io.nadron.extension.exception.SFSCodecException;
import io.nadron.extension.exception.SFSRuntimeException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSFSDataSerializer implements ISFSDataSerializer {
	private static final String CLASS_MARKER_KEY = "$C";
	private static final String CLASS_FIELDS_KEY = "$F";
	private static final String FIELD_NAME_KEY = "N";
	private static final String FIELD_VALUE_KEY = "V";
	private static DefaultSFSDataSerializer instance = new DefaultSFSDataSerializer();
	private static int BUFFER_CHUNK_SIZE = 512;
	private final Logger logger;

	public static DefaultSFSDataSerializer getInstance() {
		return instance;
	}

	private DefaultSFSDataSerializer() {
		this.logger = LoggerFactory.getLogger(getClass());
	}

	public int getUnsignedByte(byte b) {
		return 0xFF & b;
	}

	public String array2json(List<Object> array) {
		return JSONArray.fromObject(array).toString();
	}

	public ISFSArray binary2array(byte[] data) {
		if (data.length < 3) {
			throw new IllegalStateException("Can't decode an SFSArray. Byte data is insufficient. Size: " + data.length + " bytes");
		}
		ByteBuffer buffer = ByteBuffer.allocate(data.length);
		buffer.put(data);
		buffer.flip();

		return decodeSFSArray(buffer);
	}

	private ISFSArray decodeSFSArray(ByteBuffer buffer) {
		ISFSArray sfsArray = SFSArray.newInstance();

		byte headerBuffer = buffer.get();

		if (headerBuffer != SFSDataType.SFS_ARRAY.getTypeID()) {
			throw new IllegalStateException("Invalid SFSDataType. Expected: " + SFSDataType.SFS_ARRAY.getTypeID() + ", found: " + headerBuffer);
		}

		short size = buffer.getShort();

		if (size < 0) {
			throw new IllegalStateException("Can't decode SFSArray. Size is negative = " + size);
		}

		try {
			for (int i = 0; i < size; i++) {
				SFSDataWrapper decodedObject = decodeObject(buffer);

				if (decodedObject != null)
					sfsArray.add(decodedObject);
				else {
					throw new IllegalStateException("Could not decode SFSArray item at index: " + i);
				}
			}

		} catch (SFSCodecException codecError) {
			throw new IllegalArgumentException(codecError.getMessage());
		}

		return sfsArray;
	}

	public ISFSObject binary2object(byte[] data) {
		if (data.length < 3) {
			throw new IllegalStateException("Can't decode an SFSObject. Byte data is insufficient. Size: " + data.length + " bytes");
		}
		ByteBuffer buffer = ByteBuffer.allocate(data.length);
		buffer.put(data);
		buffer.flip();

		return decodeSFSObject(buffer);
	}

	private ISFSObject decodeSFSObject(ByteBuffer buffer) {
		ISFSObject sfsObject = SFSObject.newInstance();

		byte headerBuffer = buffer.get();

		if (headerBuffer != SFSDataType.SFS_OBJECT.getTypeID()) {
			throw new IllegalStateException("Invalid SFSDataType. Expected: " + SFSDataType.SFS_OBJECT.getTypeID() + ", found: " + headerBuffer);
		}

		short size = buffer.getShort();

		if (size < 0) {
			throw new IllegalStateException("Can't decode SFSObject. Size is negative = " + size);
		}

		try {
			for (int i = 0; i < size; i++) {
				short keySize = buffer.getShort();

				if ((keySize < 0) || (keySize > 255)) {
					throw new IllegalStateException("Invalid SFSObject key length. Found = " + keySize);
				}
				byte[] keyData = new byte[keySize];
				buffer.get(keyData, 0, keyData.length);
				String key = new String(keyData);

				SFSDataWrapper decodedObject = decodeObject(buffer);

				if (decodedObject != null)
					sfsObject.put(key, decodedObject);
				else {
					throw new IllegalStateException("Could not decode value for key: " + keyData);
				}
			}

		} catch (SFSCodecException codecError) {
			throw new IllegalArgumentException(codecError.getMessage());
		}

		return sfsObject;
	}

	public ISFSArray json2array(String jsonStr) {
		if (jsonStr.length() < 2) {
			throw new IllegalStateException("Can't decode SFSObject. JSON String is too short. Len: " + jsonStr.length());
		}
		JSONArray jsa = JSONArray.fromObject(jsonStr);

		return decodeSFSArray(jsa);
	}

	private ISFSArray decodeSFSArray(JSONArray jsa) {
		ISFSArray sfsArray = SFSArrayLite.newInstance();

		for (Iterator iter = jsa.iterator(); iter.hasNext();) {
			Object value = iter.next();
			SFSDataWrapper decodedObject = decodeJsonObject(value);

			if (decodedObject != null)
				sfsArray.add(decodedObject);
			else {
				throw new IllegalStateException("(json2sfarray) Could not decode value for object: " + value);
			}
		}
		return sfsArray;
	}

	public ISFSObject json2object(String jsonStr) {
		if (jsonStr.length() < 2) {
			throw new IllegalStateException("Can't decode SFSObject. JSON String is too short. Len: " + jsonStr.length());
		}

		JSONObject jso = JSONObject.fromObject(jsonStr);

		return decodeSFSObject(jso);
	}

	private ISFSObject decodeSFSObject(JSONObject jso) {
		ISFSObject sfsObject = SFSObjectLite.newInstance();

		for (Iterator localIterator = jso.keySet().iterator(); localIterator.hasNext();) {
			Object key = localIterator.next();

			Object value = jso.get(key);

			SFSDataWrapper decodedObject = decodeJsonObject(value);

			if (decodedObject != null)
				sfsObject.put((String) key, decodedObject);
			else {
				throw new IllegalStateException("(json2sfsobj) Could not decode value for key: " + key);
			}
		}
		return sfsObject;
	}

	private SFSDataWrapper decodeJsonObject(Object o) {
		if ((o instanceof Integer)) {
			return new SFSDataWrapper(SFSDataType.INT, o);
		}

		if ((o instanceof Long)) {
			return new SFSDataWrapper(SFSDataType.LONG, o);
		}

		if ((o instanceof Double)) {
			return new SFSDataWrapper(SFSDataType.DOUBLE, o);
		}

		if ((o instanceof Boolean)) {
			return new SFSDataWrapper(SFSDataType.BOOL, o);
		}

		if ((o instanceof String)) {
			return new SFSDataWrapper(SFSDataType.UTF_STRING, o);
		}

		if ((o instanceof JSONObject)) {
			JSONObject jso = (JSONObject) o;

			if (jso.isNullObject()) {
				return new SFSDataWrapper(SFSDataType.NULL, null);
			}

			return new SFSDataWrapper(SFSDataType.SFS_OBJECT, decodeSFSObject(jso));
		}

		if ((o instanceof JSONArray)) {
			return new SFSDataWrapper(SFSDataType.SFS_ARRAY, decodeSFSArray((JSONArray) o));
		}

		throw new IllegalArgumentException(String.format("Unrecognized DataType while converting JSONObject 2 SFSObject. Object: %s, Type: %s", new Object[] { o, o == null ? "null" : o.getClass() }));
	}

	public SFSObject resultSet2object(ResultSet rset) throws SQLException {
		ResultSetMetaData metaData = rset.getMetaData();
		SFSObject sfso = new SFSObject();

		if (rset.isBeforeFirst()) {
			rset.next();
		}
		for (int col = 1; col <= metaData.getColumnCount(); col++) {
			String colName = metaData.getColumnName(col);
			int type = metaData.getColumnType(col);

			Object rawDataObj = rset.getObject(col);
			if (rawDataObj != null) {
				if (type == 0) {
					sfso.putNull(colName);
				} else if (type == 16) {
					sfso.putBool(colName, rset.getBoolean(col));
				} else if (type == 91) {
					sfso.putLong(colName, rset.getDate(col).getTime());
				} else if ((type == 6) || (type == 3) || (type == 8) || (type == 7)) {
					sfso.putDouble(colName, rset.getDouble(col));
				} else if ((type == 4) || (type == -6) || (type == 5)) {
					sfso.putInt(colName, rset.getInt(col));
				} else if ((type == -1) || (type == 12) || (type == 1)) {
					sfso.putUtfString(colName, rset.getString(col));
				} else if ((type == -9) || (type == -16) || (type == -15)) {
					sfso.putUtfString(colName, rset.getNString(col));
				} else if (type == 93) {
					sfso.putLong(colName, rset.getTimestamp(col).getTime());
				} else if (type == -5) {
					sfso.putLong(colName, rset.getLong(col));
				} else if (type == -4) {
					byte[] binData = getBlobData(colName, rset.getBinaryStream(col));

					if (binData != null) {
						sfso.putByteArray(colName, binData);
					}
				} else if (type == 2004) {
					Blob blob = rset.getBlob(col);
					sfso.putByteArray(colName, blob.getBytes(0L, (int) blob.length()));
				} else {
					this.logger.info("Skipping Unsupported SQL TYPE: " + type + ", Column:" + colName);
				}
			}
		}
		return sfso;
	}

	private byte[] getBlobData(String colName, InputStream stream) {
		BufferedInputStream bis = new BufferedInputStream(stream);
		byte[] bytes = (byte[]) null;
		try {
			bytes = new byte[bis.available()];
			bis.read(bytes);
		} catch (IOException ex) {
			this.logger.warn("SFSObject serialize error. Failed reading BLOB data for column: " + colName);
		} finally {
			IOUtils.closeQuietly(bis);
		}

		return bytes;
	}

	public SFSArray resultSet2array(ResultSet rset) throws SQLException {
		SFSArray sfsa = new SFSArray();

		while (rset.next()) {
			sfsa.addSFSObject(resultSet2object(rset));
		}

		return sfsa;
	}

	public byte[] object2binary(ISFSObject object) {
		ByteBuffer buffer = ByteBuffer.allocate(BUFFER_CHUNK_SIZE);
		buffer.put((byte) SFSDataType.SFS_OBJECT.getTypeID());
		buffer.putShort((short) object.size());

		return obj2bin(object, buffer);
	}

	private byte[] obj2bin(ISFSObject object, ByteBuffer buffer) {
		Set<String> keys = object.getKeys();

		for (String key : keys) {
			SFSDataWrapper wrapper = object.get(key);
			Object dataObj = wrapper.getObject();

			buffer = encodeSFSObjectKey(buffer, key);

			buffer = encodeObject(buffer, wrapper.getTypeId(), dataObj);
		}

		int pos = buffer.position();

		byte[] result = new byte[pos];
		buffer.flip();

		buffer.get(result, 0, pos);

		return result;
	}

	public byte[] array2binary(ISFSArray array) {
		ByteBuffer buffer = ByteBuffer.allocate(BUFFER_CHUNK_SIZE);
		buffer.put((byte) SFSDataType.SFS_ARRAY.getTypeID());
		buffer.putShort((short) array.size());

		return arr2bin(array, buffer);
	}

	private byte[] arr2bin(ISFSArray array, ByteBuffer buffer) {
		Iterator iter = array.iterator();

		while (iter.hasNext()) {
			SFSDataWrapper wrapper = (SFSDataWrapper) iter.next();
			Object dataObj = wrapper.getObject();

			buffer = encodeObject(buffer, wrapper.getTypeId(), dataObj);
		}

		int pos = buffer.position();

		byte[] result = new byte[pos];
		buffer.flip();

		buffer.get(result, 0, pos);

		return result;
	}

	public String object2json(Map<String, Object> map) {
		return JSONObject.fromObject(map).toString();
	}

	public void flattenObject(Map<String, Object> map, SFSObject sfsObj) {
		for (Iterator it = sfsObj.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();

			String key = (String) entry.getKey();
			SFSDataWrapper value = (SFSDataWrapper) entry.getValue();

			if (value.getTypeId() == SFSDataType.SFS_OBJECT) {
				Map newMap = new HashMap();

				map.put(key, newMap);

				flattenObject(newMap, (SFSObject) value.getObject());
			} else if (value.getTypeId() == SFSDataType.SFS_ARRAY) {
				List newList = new ArrayList();
				map.put(key, newList);
				flattenArray(newList, (SFSArray) value.getObject());
			} else {
				map.put(key, value.getObject());
			}
		}
	}

	public void flattenArray(List<Object> array, SFSArray sfsArray) {
		for (Iterator it = sfsArray.iterator(); it.hasNext();) {
			SFSDataWrapper value = (SFSDataWrapper) it.next();

			if (value.getTypeId() == SFSDataType.SFS_OBJECT) {
				Map newMap = new HashMap();

				array.add(newMap);

				flattenObject(newMap, (SFSObject) value.getObject());
			} else if (value.getTypeId() == SFSDataType.SFS_ARRAY) {
				List newList = new ArrayList();
				array.add(newList);
				flattenArray(newList, (SFSArray) value.getObject());
			} else {
				array.add(value.getObject());
			}
		}
	}

	private SFSDataWrapper decodeObject(ByteBuffer buffer) throws SFSCodecException {
		SFSDataWrapper decodedObject = null;

		byte headerByte = buffer.get();

		if (headerByte == SFSDataType.NULL.getTypeID()) {
			decodedObject = binDecode_NULL(buffer);
		} else if (headerByte == SFSDataType.BOOL.getTypeID()) {
			decodedObject = binDecode_BOOL(buffer);
		} else if (headerByte == SFSDataType.BOOL_ARRAY.getTypeID()) {
			decodedObject = binDecode_BOOL_ARRAY(buffer);
		} else if (headerByte == SFSDataType.BYTE.getTypeID()) {
			decodedObject = binDecode_BYTE(buffer);
		} else if (headerByte == SFSDataType.BYTE_ARRAY.getTypeID()) {
			decodedObject = binDecode_BYTE_ARRAY(buffer);
		} else if (headerByte == SFSDataType.SHORT.getTypeID()) {
			decodedObject = binDecode_SHORT(buffer);
		} else if (headerByte == SFSDataType.SHORT_ARRAY.getTypeID()) {
			decodedObject = binDecode_SHORT_ARRAY(buffer);
		} else if (headerByte == SFSDataType.INT.getTypeID()) {
			decodedObject = binDecode_INT(buffer);
		} else if (headerByte == SFSDataType.INT_ARRAY.getTypeID()) {
			decodedObject = binDecode_INT_ARRAY(buffer);
		} else if (headerByte == SFSDataType.LONG.getTypeID()) {
			decodedObject = binDecode_LONG(buffer);
		} else if (headerByte == SFSDataType.LONG_ARRAY.getTypeID()) {
			decodedObject = binDecode_LONG_ARRAY(buffer);
		} else if (headerByte == SFSDataType.FLOAT.getTypeID()) {
			decodedObject = binDecode_FLOAT(buffer);
		} else if (headerByte == SFSDataType.FLOAT_ARRAY.getTypeID()) {
			decodedObject = binDecode_FLOAT_ARRAY(buffer);
		} else if (headerByte == SFSDataType.DOUBLE.getTypeID()) {
			decodedObject = binDecode_DOUBLE(buffer);
		} else if (headerByte == SFSDataType.DOUBLE_ARRAY.getTypeID()) {
			decodedObject = binDecode_DOUBLE_ARRAY(buffer);
		} else if (headerByte == SFSDataType.UTF_STRING.getTypeID()) {
			decodedObject = binDecode_UTF_STRING(buffer);
		} else if (headerByte == SFSDataType.UTF_STRING_ARRAY.getTypeID()) {
			decodedObject = binDecode_UTF_STRING_ARRAY(buffer);
		} else if (headerByte == SFSDataType.SFS_ARRAY.getTypeID()) {
			buffer.position(buffer.position() - 1);

			decodedObject = new SFSDataWrapper(SFSDataType.SFS_ARRAY, decodeSFSArray(buffer));
		} else if (headerByte == SFSDataType.SFS_OBJECT.getTypeID()) {
			buffer.position(buffer.position() - 1);

			ISFSObject sfsObj = decodeSFSObject(buffer);
			SFSDataType type = SFSDataType.SFS_OBJECT;
			Object finalSfsObj = sfsObj;

			if ((sfsObj.containsKey("$C")) && (sfsObj.containsKey("$F"))) {
				type = SFSDataType.CLASS;
				finalSfsObj = sfs2pojo(sfsObj);
			}

			decodedObject = new SFSDataWrapper(type, finalSfsObj);
		} else {
			throw new SFSCodecException("Unknow SFSDataType ID: " + headerByte);
		}
		return decodedObject;
	}

	private ByteBuffer encodeObject(ByteBuffer buffer, SFSDataType typeId, Object object) {
		switch (typeId) {
		case BOOL:
			buffer = binEncode_NULL(buffer);
			break;
		case BOOL_ARRAY:
			buffer = binEncode_BOOL(buffer, (Boolean) object);
			break;
		case BYTE:
			buffer = binEncode_BYTE(buffer, (Byte) object);
			break;
		case BYTE_ARRAY:
			buffer = binEncode_SHORT(buffer, (Short) object);
			break;
		case CLASS:
			buffer = binEncode_INT(buffer, (Integer) object);
			break;
		case DOUBLE:
			buffer = binEncode_LONG(buffer, (Long) object);
			break;
		case DOUBLE_ARRAY:
			buffer = binEncode_FLOAT(buffer, (Float) object);
			break;
		case FLOAT:
			buffer = binEncode_DOUBLE(buffer, (Double) object);
			break;
		case FLOAT_ARRAY:
			buffer = binEncode_UTF_STRING(buffer, (String) object);
			break;
		case INT:
			buffer = binEncode_BOOL_ARRAY(buffer, (Collection) object);
			break;
		case INT_ARRAY:
			buffer = binEncode_BYTE_ARRAY(buffer, (byte[]) object);
			break;
		case LONG:
			buffer = binEncode_SHORT_ARRAY(buffer, (Collection) object);
			break;
		case LONG_ARRAY:
			buffer = binEncode_INT_ARRAY(buffer, (Collection) object);
			break;
		case NULL:
			buffer = binEncode_LONG_ARRAY(buffer, (Collection) object);
			break;
		case SFS_ARRAY:
			buffer = binEncode_FLOAT_ARRAY(buffer, (Collection) object);
			break;
		case SFS_OBJECT:
			buffer = binEncode_DOUBLE_ARRAY(buffer, (Collection) object);
			break;
		case SHORT:
			buffer = binEncode_UTF_STRING_ARRAY(buffer, (Collection) object);
			break;
		case SHORT_ARRAY:
			buffer = addData(buffer, array2binary((SFSArray) object));
			break;
		case UTF_STRING:
			buffer = addData(buffer, object2binary((SFSObject) object));
			break;
		case UTF_STRING_ARRAY:
			buffer = addData(buffer, object2binary(pojo2sfs(object)));
			break;
		default:
			throw new IllegalArgumentException("Unrecognized type in SFSObject serialization: " + typeId);
		}

		return buffer;
	}

	private SFSDataWrapper binDecode_NULL(ByteBuffer buffer) {
		return new SFSDataWrapper(SFSDataType.NULL, null);
	}

	private SFSDataWrapper binDecode_BOOL(ByteBuffer buffer) throws SFSCodecException {
		byte boolByte = buffer.get();
		Boolean bool = null;

		if (boolByte == 0)
			bool = new Boolean(false);
		else if (boolByte == 1)
			bool = new Boolean(true);
		else {
			throw new SFSCodecException("Error decoding Bool type. Illegal value: " + bool);
		}
		return new SFSDataWrapper(SFSDataType.BOOL, bool);
	}

	private SFSDataWrapper binDecode_BYTE(ByteBuffer buffer) {
		byte boolByte = buffer.get();

		return new SFSDataWrapper(SFSDataType.BYTE, Byte.valueOf(boolByte));
	}

	private SFSDataWrapper binDecode_SHORT(ByteBuffer buffer) {
		short shortValue = buffer.getShort();

		return new SFSDataWrapper(SFSDataType.SHORT, Short.valueOf(shortValue));
	}

	private SFSDataWrapper binDecode_INT(ByteBuffer buffer) {
		int intValue = buffer.getInt();

		return new SFSDataWrapper(SFSDataType.INT, Integer.valueOf(intValue));
	}

	private SFSDataWrapper binDecode_LONG(ByteBuffer buffer) {
		long longValue = buffer.getLong();

		return new SFSDataWrapper(SFSDataType.LONG, Long.valueOf(longValue));
	}

	private SFSDataWrapper binDecode_FLOAT(ByteBuffer buffer) {
		float floatValue = buffer.getFloat();

		return new SFSDataWrapper(SFSDataType.FLOAT, Float.valueOf(floatValue));
	}

	private SFSDataWrapper binDecode_DOUBLE(ByteBuffer buffer) {
		double doubleValue = buffer.getDouble();

		return new SFSDataWrapper(SFSDataType.DOUBLE, Double.valueOf(doubleValue));
	}

	private SFSDataWrapper binDecode_UTF_STRING(ByteBuffer buffer) throws SFSCodecException {
		short strLen = buffer.getShort();

		if (strLen < 0) {
			throw new SFSCodecException("Error decoding UtfString. Negative size: " + strLen);
		}

		byte[] strData = new byte[strLen];
		buffer.get(strData, 0, strLen);

		String decodedString = new String(strData);
		return new SFSDataWrapper(SFSDataType.UTF_STRING, decodedString);
	}

	private SFSDataWrapper binDecode_BOOL_ARRAY(ByteBuffer buffer) throws SFSCodecException {
		short arraySize = getTypeArraySize(buffer);
		List array = new ArrayList();

		for (int j = 0; j < arraySize; j++) {
			byte boolData = buffer.get();

			if (boolData == 0)
				array.add(Boolean.valueOf(false));
			else if (boolData == 1) {
				array.add(Boolean.valueOf(true));
			} else {
				throw new SFSCodecException("Error decoding BoolArray. Invalid bool value: " + boolData);
			}
		}

		return new SFSDataWrapper(SFSDataType.BOOL_ARRAY, array);
	}

	private SFSDataWrapper binDecode_BYTE_ARRAY(ByteBuffer buffer) throws SFSCodecException {
		int arraySize = buffer.getInt();

		if (arraySize < 0) {
			throw new SFSCodecException("Error decoding typed array size. Negative size: " + arraySize);
		}
		byte[] byteData = new byte[arraySize];

		buffer.get(byteData, 0, arraySize);

		return new SFSDataWrapper(SFSDataType.BYTE_ARRAY, byteData);
	}

	private SFSDataWrapper binDecode_SHORT_ARRAY(ByteBuffer buffer) throws SFSCodecException {
		short arraySize = getTypeArraySize(buffer);
		List array = new ArrayList();

		for (int j = 0; j < arraySize; j++) {
			short shortValue = buffer.getShort();
			array.add(Short.valueOf(shortValue));
		}

		return new SFSDataWrapper(SFSDataType.SHORT_ARRAY, array);
	}

	private SFSDataWrapper binDecode_INT_ARRAY(ByteBuffer buffer) throws SFSCodecException {
		short arraySize = getTypeArraySize(buffer);
		List array = new ArrayList();

		for (int j = 0; j < arraySize; j++) {
			int intValue = buffer.getInt();
			array.add(Integer.valueOf(intValue));
		}

		return new SFSDataWrapper(SFSDataType.INT_ARRAY, array);
	}

	private SFSDataWrapper binDecode_LONG_ARRAY(ByteBuffer buffer) throws SFSCodecException {
		short arraySize = getTypeArraySize(buffer);
		List array = new ArrayList();

		for (int j = 0; j < arraySize; j++) {
			long longValue = buffer.getLong();
			array.add(Long.valueOf(longValue));
		}

		return new SFSDataWrapper(SFSDataType.LONG_ARRAY, array);
	}

	private SFSDataWrapper binDecode_FLOAT_ARRAY(ByteBuffer buffer) throws SFSCodecException {
		short arraySize = getTypeArraySize(buffer);
		List array = new ArrayList();

		for (int j = 0; j < arraySize; j++) {
			float floatValue = buffer.getFloat();
			array.add(Float.valueOf(floatValue));
		}

		return new SFSDataWrapper(SFSDataType.FLOAT_ARRAY, array);
	}

	private SFSDataWrapper binDecode_DOUBLE_ARRAY(ByteBuffer buffer) throws SFSCodecException {
		short arraySize = getTypeArraySize(buffer);
		List array = new ArrayList();

		for (int j = 0; j < arraySize; j++) {
			double doubleValue = buffer.getDouble();
			array.add(Double.valueOf(doubleValue));
		}

		return new SFSDataWrapper(SFSDataType.DOUBLE_ARRAY, array);
	}

	private SFSDataWrapper binDecode_UTF_STRING_ARRAY(ByteBuffer buffer) throws SFSCodecException {
		short arraySize = getTypeArraySize(buffer);
		List array = new ArrayList();

		for (int j = 0; j < arraySize; j++) {
			short strLen = buffer.getShort();

			if (strLen < 0) {
				throw new SFSCodecException("Error decoding UtfStringArray element. Element has negative size: " + strLen);
			}

			byte[] strData = new byte[strLen];
			buffer.get(strData, 0, strLen);

			array.add(new String(strData));
		}

		return new SFSDataWrapper(SFSDataType.UTF_STRING_ARRAY, array);
	}

	private short getTypeArraySize(ByteBuffer buffer) throws SFSCodecException {
		short arraySize = buffer.getShort();

		if (arraySize < 0) {
			throw new SFSCodecException("Error decoding typed array size. Negative size: " + arraySize);
		}
		return arraySize;
	}

	private ByteBuffer binEncode_NULL(ByteBuffer buffer) {
		return addData(buffer, new byte[1]);
	}

	private ByteBuffer binEncode_BOOL(ByteBuffer buffer, Boolean value) {
		byte[] data = new byte[2];
		data[0] = ((byte) SFSDataType.BOOL.getTypeID());
		data[1] = (byte) (value.booleanValue() ? 1 : 0);

		return addData(buffer, data);
	}

	private ByteBuffer binEncode_BYTE(ByteBuffer buffer, Byte value) {
		byte[] data = new byte[2];
		data[0] = ((byte) SFSDataType.BYTE.getTypeID());
		data[1] = value.byteValue();

		return addData(buffer, data);
	}

	private ByteBuffer binEncode_SHORT(ByteBuffer buffer, Short value) {
		ByteBuffer buf = ByteBuffer.allocate(3);
		buf.put((byte) SFSDataType.SHORT.getTypeID());
		buf.putShort(value.shortValue());

		return addData(buffer, buf.array());
	}

	private ByteBuffer binEncode_INT(ByteBuffer buffer, Integer value) {
		ByteBuffer buf = ByteBuffer.allocate(5);
		buf.put((byte) SFSDataType.INT.getTypeID());
		buf.putInt(value.intValue());

		return addData(buffer, buf.array());
	}

	private ByteBuffer binEncode_LONG(ByteBuffer buffer, Long value) {
		ByteBuffer buf = ByteBuffer.allocate(9);
		buf.put((byte) SFSDataType.LONG.getTypeID());
		buf.putLong(value.longValue());

		return addData(buffer, buf.array());
	}

	private ByteBuffer binEncode_FLOAT(ByteBuffer buffer, Float value) {
		ByteBuffer buf = ByteBuffer.allocate(5);
		buf.put((byte) SFSDataType.FLOAT.getTypeID());
		buf.putFloat(value.floatValue());

		return addData(buffer, buf.array());
	}

	private ByteBuffer binEncode_DOUBLE(ByteBuffer buffer, Double value) {
		ByteBuffer buf = ByteBuffer.allocate(9);
		buf.put((byte) SFSDataType.DOUBLE.getTypeID());
		buf.putDouble(value.doubleValue());

		return addData(buffer, buf.array());
	}

	private ByteBuffer binEncode_UTF_STRING(ByteBuffer buffer, String value) {
		byte[] stringBytes = value.getBytes();
		ByteBuffer buf = ByteBuffer.allocate(3 + stringBytes.length);
		buf.put((byte) SFSDataType.UTF_STRING.getTypeID());
		buf.putShort((short) stringBytes.length);
		buf.put(stringBytes);

		return addData(buffer, buf.array());
	}

	private ByteBuffer binEncode_BOOL_ARRAY(ByteBuffer buffer, Collection<Boolean> value) {
		ByteBuffer buf = ByteBuffer.allocate(3 + value.size());
		buf.put((byte) SFSDataType.BOOL_ARRAY.getTypeID());
		buf.putShort((short) value.size());

		for (Iterator localIterator = value.iterator(); localIterator.hasNext();) {
			boolean b = ((Boolean) localIterator.next()).booleanValue();

			buf.put((byte) (b ? 1 : 0));
		}

		return addData(buffer, buf.array());
	}

	private ByteBuffer binEncode_BYTE_ARRAY(ByteBuffer buffer, byte[] value) {
		ByteBuffer buf = ByteBuffer.allocate(5 + value.length);
		buf.put((byte) SFSDataType.BYTE_ARRAY.getTypeID());
		buf.putInt(value.length);

		buf.put(value);

		return addData(buffer, buf.array());
	}

	private ByteBuffer binEncode_SHORT_ARRAY(ByteBuffer buffer, Collection<Short> value) {
		ByteBuffer buf = ByteBuffer.allocate(3 + 2 * value.size());
		buf.put((byte) SFSDataType.SHORT_ARRAY.getTypeID());
		buf.putShort((short) value.size());

		for (Iterator localIterator = value.iterator(); localIterator.hasNext();) {
			short item = ((Short) localIterator.next()).shortValue();

			buf.putShort(item);
		}

		return addData(buffer, buf.array());
	}

	private ByteBuffer binEncode_INT_ARRAY(ByteBuffer buffer, Collection<Integer> value) {
		ByteBuffer buf = ByteBuffer.allocate(3 + 4 * value.size());
		buf.put((byte) SFSDataType.INT_ARRAY.getTypeID());
		buf.putShort((short) value.size());

		for (Iterator localIterator = value.iterator(); localIterator.hasNext();) {
			int item = ((Integer) localIterator.next()).intValue();

			buf.putInt(item);
		}

		return addData(buffer, buf.array());
	}

	private ByteBuffer binEncode_LONG_ARRAY(ByteBuffer buffer, Collection<Long> value) {
		ByteBuffer buf = ByteBuffer.allocate(3 + 8 * value.size());
		buf.put((byte) SFSDataType.LONG_ARRAY.getTypeID());
		buf.putShort((short) value.size());

		for (Iterator localIterator = value.iterator(); localIterator.hasNext();) {
			long item = ((Long) localIterator.next()).longValue();

			buf.putLong(item);
		}

		return addData(buffer, buf.array());
	}

	private ByteBuffer binEncode_FLOAT_ARRAY(ByteBuffer buffer, Collection<Float> value) {
		ByteBuffer buf = ByteBuffer.allocate(3 + 4 * value.size());
		buf.put((byte) SFSDataType.FLOAT_ARRAY.getTypeID());
		buf.putShort((short) value.size());

		for (Iterator localIterator = value.iterator(); localIterator.hasNext();) {
			float item = ((Float) localIterator.next()).floatValue();

			buf.putFloat(item);
		}

		return addData(buffer, buf.array());
	}

	private ByteBuffer binEncode_DOUBLE_ARRAY(ByteBuffer buffer, Collection<Double> value) {
		ByteBuffer buf = ByteBuffer.allocate(3 + 8 * value.size());
		buf.put((byte) SFSDataType.DOUBLE_ARRAY.getTypeID());
		buf.putShort((short) value.size());

		for (Iterator localIterator = value.iterator(); localIterator.hasNext();) {
			double item = ((Double) localIterator.next()).doubleValue();

			buf.putDouble(item);
		}

		return addData(buffer, buf.array());
	}

	private ByteBuffer binEncode_UTF_STRING_ARRAY(ByteBuffer buffer, Collection<String> value) {
		int stringDataLen = 0;

		byte[][] binStrings = new byte[value.size()][];
		int count = 0;
		byte[] binStr = null;
		for (String item : value) {
			binStr = item.getBytes();
			binStrings[(count++)] = binStr;
			stringDataLen += 2 + binStr.length;
		}

		ByteBuffer buf = ByteBuffer.allocate(3 + stringDataLen);
		buf.put((byte) SFSDataType.UTF_STRING_ARRAY.getTypeID());
		buf.putShort((short) value.size());
		byte[][] arrayOfByte2;
		int arrayOfByte1 = (arrayOfByte2 = binStrings).length;
		for (int i = 0; i < arrayOfByte1; i++) {
			byte[] binItem = arrayOfByte2[i];
			buf.putShort((short) binItem.length);
			buf.put(binItem);
		}

		return addData(buffer, buf.array());
	}

	private ByteBuffer encodeSFSObjectKey(ByteBuffer buffer, String value) {
		ByteBuffer buf = ByteBuffer.allocate(2 + value.length());
		buf.putShort((short) value.length());
		buf.put(value.getBytes());

		return addData(buffer, buf.array());
	}

	private ByteBuffer addData(ByteBuffer buffer, byte[] newData) {
		if (buffer.remaining() < newData.length) {
			int newSize = BUFFER_CHUNK_SIZE;

			if (newSize < newData.length) {
				newSize = newData.length;
			}
			ByteBuffer newBuffer = ByteBuffer.allocate(buffer.capacity() + newSize);
			buffer.flip();
			newBuffer.put(buffer);

			buffer = newBuffer;
		}

		buffer.put(newData);

		return buffer;
	}

	public ISFSObject pojo2sfs(Object pojo) {
		ISFSObject sfsObj = SFSObject.newInstance();
		try {
			convertPojo(pojo, sfsObj);
		} catch (Exception e) {
			throw new SFSRuntimeException(e);
		}

		return sfsObj;
	}

	private void convertPojo(Object pojo, ISFSObject sfsObj) throws Exception {
		Class pojoClazz = pojo.getClass();
		String classFullName = pojoClazz.getCanonicalName();

		if (classFullName == null) {
			throw new IllegalArgumentException("Anonymous classes cannot be serialized!");
		}
		if (!(pojo instanceof SerializableSFSType)) {
			throw new IllegalStateException("Cannot serialize object: " + pojo + ", type: " + classFullName + " -- It doesn't implement the SerializableSFSType interface");
		}
		ISFSArray fieldList = SFSArray.newInstance();

		sfsObj.putUtfString("$C", classFullName);
		sfsObj.putSFSArray("$F", fieldList);

		for (Field field : pojoClazz.getDeclaredFields()) {
			try {
				int modifiers = field.getModifiers();

				if ((!Modifier.isTransient(modifiers)) && (!Modifier.isStatic(modifiers))) {
					String fieldName = field.getName();
					Object fieldValue = null;

					if (Modifier.isPublic(modifiers)) {
						fieldValue = field.get(pojo);
					} else {
						fieldValue = readValueFromGetter(fieldName, field.getType().getSimpleName(), pojo);
					}

					ISFSObject fieldDescriptor = SFSObject.newInstance();

					fieldDescriptor.putUtfString("N", fieldName);

					fieldDescriptor.put("V", wrapPojoField(fieldValue));

					fieldList.addSFSObject(fieldDescriptor);
				}
			} catch (NoSuchMethodException err) {
				this.logger.info("-- No public getter -- Serializer skipping private field: " + field.getName() + ", from class: " + pojoClazz);
				err.printStackTrace();
			}
		}
	}

	private Object readValueFromGetter(String fieldName, String type, Object pojo) throws Exception {
		Object value = null;
		boolean isBool = type.equalsIgnoreCase("boolean");

		String getterName = "get" + StringUtils.capitalize(fieldName);

		Method getterMethod = pojo.getClass().getMethod(getterName, new Class[0]);
		value = getterMethod.invoke(pojo, new Object[0]);

		return value;
	}

	private SFSDataWrapper wrapPojoField(Object value) {
		if (value == null) {
			return new SFSDataWrapper(SFSDataType.NULL, null);
		}

		SFSDataWrapper wrapper = null;

		if ((value instanceof Boolean)) {
			wrapper = new SFSDataWrapper(SFSDataType.BOOL, value);
		} else if ((value instanceof Byte)) {
			wrapper = new SFSDataWrapper(SFSDataType.BYTE, value);
		} else if ((value instanceof Short)) {
			wrapper = new SFSDataWrapper(SFSDataType.SHORT, value);
		} else if ((value instanceof Integer)) {
			wrapper = new SFSDataWrapper(SFSDataType.INT, value);
		} else if ((value instanceof Long)) {
			wrapper = new SFSDataWrapper(SFSDataType.LONG, value);
		} else if ((value instanceof Float)) {
			wrapper = new SFSDataWrapper(SFSDataType.FLOAT, value);
		} else if ((value instanceof Double)) {
			wrapper = new SFSDataWrapper(SFSDataType.DOUBLE, value);
		} else if ((value instanceof String)) {
			wrapper = new SFSDataWrapper(SFSDataType.UTF_STRING, value);
		} else if (value.getClass().isArray()) {
			wrapper = new SFSDataWrapper(SFSDataType.SFS_ARRAY, unrollArray((Object[]) value));
		} else if ((value instanceof Collection)) {
			wrapper = new SFSDataWrapper(SFSDataType.SFS_ARRAY, unrollCollection((Collection) value));
		} else if ((value instanceof Map)) {
			wrapper = new SFSDataWrapper(SFSDataType.SFS_OBJECT, unrollMap((Map) value));
		} else if ((value instanceof SerializableSFSType)) {
			wrapper = new SFSDataWrapper(SFSDataType.SFS_OBJECT, pojo2sfs(value));
		}

		return wrapper;
	}

	private ISFSArray unrollArray(Object[] arr) {
		ISFSArray array = SFSArray.newInstance();

		for (Object item : arr) {
			array.add(wrapPojoField(item));
		}

		return array;
	}

	private ISFSArray unrollCollection(Collection collection) {
		ISFSArray array = SFSArray.newInstance();

		for (Iterator localIterator = collection.iterator(); localIterator.hasNext();) {
			Object item = localIterator.next();

			array.add(wrapPojoField(item));
		}

		return array;
	}

	private ISFSObject unrollMap(Map map) {
		ISFSObject sfsObj = SFSObject.newInstance();
		Set entries = map.entrySet();

		for (Iterator iter = entries.iterator(); iter.hasNext();) {
			Map.Entry item = (Map.Entry) iter.next();
			Object key = item.getKey();

			if ((key instanceof String)) {
				sfsObj.put((String) key, wrapPojoField(item.getValue()));
			}
		}

		return sfsObj;
	}

	public Object sfs2pojo(ISFSObject sfsObj) {
		Object pojo = null;

		if ((!sfsObj.containsKey("$C")) && (!sfsObj.containsKey("$F"))) {
			throw new SFSRuntimeException("The SFSObject passed does not represent any serialized class.");
		}
		try {
			String className = sfsObj.getUtfString("$C");
			Class theClass = Class.forName(className);
			pojo = theClass.newInstance();

			if (!(pojo instanceof SerializableSFSType)) {
				throw new IllegalStateException("Cannot deserialize object: " + pojo + ", type: " + className + " -- It doesn't implement the SerializableSFSType interface");
			}
			convertSFSObject(sfsObj.getSFSArray("$F"), pojo);
		} catch (Exception e) {
			throw new SFSRuntimeException(e);
		}

		return pojo;
	}

	private void convertSFSObject(ISFSArray fieldList, Object pojo) throws Exception {
		for (int j = 0; j < fieldList.size(); j++) {
			ISFSObject fieldDescriptor = fieldList.getSFSObject(j);
			String fieldName = fieldDescriptor.getUtfString("N");
			Object fieldValue = unwrapPojoField(fieldDescriptor.get("V"));

			setObjectField(pojo, fieldName, fieldValue);
		}
	}

	private void setObjectField(Object pojo, String fieldName, Object fieldValue) throws Exception {
		Class pojoClass = pojo.getClass();
		Field field = pojoClass.getDeclaredField(fieldName);
		int fieldModifier = field.getModifiers();

		if (Modifier.isTransient(fieldModifier)) {
			return;
		}

		boolean isArray = field.getType().isArray();
		if (isArray) {
			if (!(fieldValue instanceof Collection)) {
				throw new SFSRuntimeException("Problem during SFSObject => POJO conversion. Found array field in POJO: " + fieldName + ", but data is not a Collection!");
			}

			Collection collection = (Collection) fieldValue;
			fieldValue = collection.toArray();
			int arraySize = collection.size();

			Object typedArray = Array.newInstance(field.getType().getComponentType(), arraySize);
			System.arraycopy(fieldValue, 0, typedArray, 0, arraySize);

			fieldValue = typedArray;
		} else if ((fieldValue instanceof Collection)) {
			Collection collection = (Collection) fieldValue;
			String fieldClass = field.getType().getSimpleName();

			if ((fieldClass.equals("ArrayList")) || (fieldClass.equals("List"))) {
				fieldValue = new ArrayList(collection);
			}
			if (fieldClass.equals("CopyOnWriteArrayList")) {
				fieldValue = new CopyOnWriteArrayList(collection);
			} else if (fieldClass.equals("LinkedList")) {
				fieldValue = new LinkedList(collection);
			} else if (fieldClass.equals("Vector")) {
				fieldValue = new Vector(collection);
			} else if ((fieldClass.equals("Set")) || (fieldClass.equals("HashSet"))) {
				fieldValue = new HashSet(collection);
			} else if (fieldClass.equals("LinkedHashSet")) {
				fieldValue = new LinkedHashSet(collection);
			} else if (fieldClass.equals("TreeSet")) {
				fieldValue = new TreeSet(collection);
			} else if (fieldClass.equals("CopyOnWriteArraySet")) {
				fieldValue = new CopyOnWriteArraySet(collection);
			} else if ((fieldClass.equals("Queue")) || (fieldClass.equals("PriorityQueue"))) {
				fieldValue = new PriorityQueue(collection);
			} else if ((fieldClass.equals("BlockingQueue")) || (fieldClass.equals("LinkedBlockingQueue"))) {
				fieldValue = new LinkedBlockingQueue(collection);
			} else if (fieldClass.equals("PriorityBlockingQueue")) {
				fieldValue = new PriorityBlockingQueue(collection);
			} else if (fieldClass.equals("ConcurrentLinkedQueue")) {
				fieldValue = new ConcurrentLinkedQueue(collection);
			} else if (fieldClass.equals("DelayQueue")) {
				fieldValue = new DelayQueue(collection);
			} else if ((fieldClass.equals("Deque")) || (fieldClass.equals("ArrayDeque"))) {
				fieldValue = new ArrayDeque(collection);
			} else if (fieldClass.equals("LinkedBlockingDeque")) {
				fieldValue = new LinkedBlockingDeque(collection);
			}

		}

		if (Modifier.isPublic(fieldModifier))
			field.set(pojo, fieldValue);
		else
			writeValueFromSetter(field, pojo, fieldValue);
	}

	private void writeValueFromSetter(Field field, Object pojo, Object fieldValue) throws Exception {
		String setterName = "set" + StringUtils.capitalize(field.getName());
		try {
			Method setterMethod = pojo.getClass().getMethod(setterName, new Class[] { field.getType() });
			setterMethod.invoke(pojo, new Object[] { fieldValue });
		} catch (NoSuchMethodException e) {
			this.logger.info("-- No public setter -- Serializer skipping private field: " + field.getName() + ", from class: " + pojo.getClass().getName());
		}
	}

	private Object unwrapPojoField(SFSDataWrapper wrapper) {
		Object obj = null;

		SFSDataType type = wrapper.getTypeId();

		if (type.getTypeID() <= SFSDataType.UTF_STRING.getTypeID()) {
			obj = wrapper.getObject();
		} else if (type == SFSDataType.SFS_ARRAY) {
			obj = rebuildArray((ISFSArray) wrapper.getObject());
		} else if (type == SFSDataType.SFS_OBJECT) {
			obj = rebuildMap((ISFSObject) wrapper.getObject());
		} else if (type == SFSDataType.CLASS) {
			obj = wrapper.getObject();
		}

		return obj;
	}

	private Object rebuildArray(ISFSArray sfsArray) {
		Collection collection = new ArrayList();

		for (Iterator iter = sfsArray.iterator(); iter.hasNext();) {
			Object item = unwrapPojoField((SFSDataWrapper) iter.next());
			collection.add(item);
		}

		return collection;
	}

	private Object rebuildMap(ISFSObject sfsObj) {
		Map map = new HashMap();

		for (String key : sfsObj.getKeys()) {
			SFSDataWrapper wrapper = sfsObj.get(key);
			map.put(key, unwrapPojoField(wrapper));
		}

		return map;
	}
}