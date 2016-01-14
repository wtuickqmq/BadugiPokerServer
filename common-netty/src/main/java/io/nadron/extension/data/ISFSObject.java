package io.nadron.extension.data;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public abstract interface ISFSObject
{
  public abstract boolean isNull(String paramString);

  public abstract boolean containsKey(String paramString);

  public abstract boolean removeElement(String paramString);

  public abstract Set<String> getKeys();

  public abstract int size();

  public abstract Iterator<Map.Entry<String, SFSDataWrapper>> iterator();

  public abstract byte[] toBinary();

  public abstract String toJson();

  public abstract String getDump();

  public abstract String getDump(boolean paramBoolean);

  public abstract String getHexDump();

  public abstract SFSDataWrapper get(String paramString);

  public abstract Boolean getBool(String paramString);

  public abstract Byte getByte(String paramString);

  public abstract Integer getUnsignedByte(String paramString);

  public abstract Short getShort(String paramString);

  public abstract Integer getInt(String paramString);

  public abstract Long getLong(String paramString);

  public abstract Float getFloat(String paramString);

  public abstract Double getDouble(String paramString);

  public abstract String getUtfString(String paramString);

  public abstract Collection<Boolean> getBoolArray(String paramString);

  public abstract byte[] getByteArray(String paramString);

  public abstract Collection<Integer> getUnsignedByteArray(String paramString);

  public abstract Collection<Short> getShortArray(String paramString);

  public abstract Collection<Integer> getIntArray(String paramString);

  public abstract Collection<Long> getLongArray(String paramString);

  public abstract Collection<Float> getFloatArray(String paramString);

  public abstract Collection<Double> getDoubleArray(String paramString);

  public abstract Collection<String> getUtfStringArray(String paramString);

  public abstract ISFSArray getSFSArray(String paramString);

  public abstract ISFSObject getSFSObject(String paramString);

  public abstract Object getClass(String paramString);

  public abstract void putNull(String paramString);

  public abstract void putBool(String paramString, boolean paramBoolean);

  public abstract void putByte(String paramString, byte paramByte);

  public abstract void putShort(String paramString, short paramShort);

  public abstract void putInt(String paramString, int paramInt);

  public abstract void putLong(String paramString, long paramLong);

  public abstract void putFloat(String paramString, float paramFloat);

  public abstract void putDouble(String paramString, double paramDouble);

  public abstract void putUtfString(String paramString1, String paramString2);

  public abstract void putBoolArray(String paramString, Collection<Boolean> paramCollection);

  public abstract void putByteArray(String paramString, byte[] paramArrayOfByte);

  public abstract void putShortArray(String paramString, Collection<Short> paramCollection);

  public abstract void putIntArray(String paramString, Collection<Integer> paramCollection);

  public abstract void putLongArray(String paramString, Collection<Long> paramCollection);

  public abstract void putFloatArray(String paramString, Collection<Float> paramCollection);

  public abstract void putDoubleArray(String paramString, Collection<Double> paramCollection);

  public abstract void putUtfStringArray(String paramString, Collection<String> paramCollection);

  public abstract void putSFSArray(String paramString, ISFSArray paramISFSArray);

  public abstract void putSFSObject(String paramString, ISFSObject paramISFSObject);

  public abstract void putClass(String paramString, Object paramObject);

  public abstract void put(String paramString, SFSDataWrapper paramSFSDataWrapper);
}