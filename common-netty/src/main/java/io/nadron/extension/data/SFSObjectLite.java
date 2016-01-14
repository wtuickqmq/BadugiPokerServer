package io.nadron.extension.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class SFSObjectLite extends SFSObject {
	public static SFSObject newInstance() {
		return new SFSObjectLite();
	}

	public Byte getByte(String key) {
		Integer i = super.getInt(key);

		return i != null ? Byte.valueOf(i.byteValue()) : null;
	}

	public Short getShort(String key) {
		Integer i = super.getInt(key);

		return i != null ? Short.valueOf(i.shortValue()) : null;
	}

	public Float getFloat(String key) {
		Double d = super.getDouble(key);

		return d != null ? Float.valueOf(d.floatValue()) : null;
	}

	public Collection<Boolean> getBoolArray(String key) {
		ISFSArray arr = getSFSArray(key);
		if (arr == null) {
			return null;
		}
		List data = new ArrayList();

		for (int i = 0; i < arr.size(); i++) {
			data.add(arr.getBool(i));
		}
		return data;
	}

	public Collection<Short> getShortArray(String key) {
		ISFSArray arr = getSFSArray(key);
		if (arr == null) {
			return null;
		}
		List data = new ArrayList();

		for (int i = 0; i < arr.size(); i++) {
			data.add(Short.valueOf(arr.getInt(i).shortValue()));
		}
		return data;
	}

	public Collection<Integer> getIntArray(String key) {
		ISFSArray arr = getSFSArray(key);
		if (arr == null) {
			return null;
		}
		List data = new ArrayList();

		for (int i = 0; i < arr.size(); i++) {
			data.add(arr.getInt(i));
		}
		return data;
	}

	public Collection<Float> getFloatArray(String key) {
		ISFSArray arr = getSFSArray(key);
		if (arr == null) {
			return null;
		}
		List data = new ArrayList();

		for (int i = 0; i < arr.size(); i++) {
			data.add(Float.valueOf(arr.getDouble(i).floatValue()));
		}
		return data;
	}

	public Collection<Double> getDoubleArray(String key) {
		ISFSArray arr = getSFSArray(key);
		if (arr == null) {
			return null;
		}
		List data = new ArrayList();

		for (int i = 0; i < arr.size(); i++) {
			data.add(arr.getDouble(i));
		}
		return data;
	}

	public Collection<String> getUtfStringArray(String key) {
		ISFSArray arr = getSFSArray(key);
		if (arr == null) {
			return null;
		}
		List data = new ArrayList();

		for (int i = 0; i < arr.size(); i++) {
			data.add(arr.getUtfString(i));
		}
		return data;
	}
}