package io.nadron.extension.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SFSArrayLite extends SFSArray {
	public static SFSArrayLite newInstance() {
		return new SFSArrayLite();
	}

	public Byte getByte(int index) {
		Integer i = super.getInt(index);

		return i != null ? Byte.valueOf(i.byteValue()) : null;
	}

	public Short getShort(int index) {
		Integer i = super.getInt(index);

		return i != null ? Short.valueOf(i.shortValue()) : null;
	}

	public Float getFloat(int index) {
		Double d = super.getDouble(index);

		return d != null ? Float.valueOf(d.floatValue()) : null;
	}

	public Collection<Boolean> getBoolArray(int key) {
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

	public Collection<Short> getShortArray(int key) {
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

	public Collection<Integer> getIntArray(int key) {
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

	public Collection<Float> getFloatArray(int key) {
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

	public Collection<Double> getDoubleArray(int key) {
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

	public Collection<String> getUtfStringArray(int key) {
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