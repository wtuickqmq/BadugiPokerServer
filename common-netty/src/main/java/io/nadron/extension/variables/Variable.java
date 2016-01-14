package io.nadron.extension.variables;

import io.nadron.extension.data.ISFSArray;
import io.nadron.extension.data.ISFSObject;

public abstract interface Variable extends Cloneable {
	
	public abstract String getName();

	public abstract VariableType getType();

	public abstract Object getValue();

	public abstract Boolean getBoolValue();

	public abstract Integer getIntValue();

	public abstract Double getDoubleValue();

	public abstract String getStringValue();

	public abstract ISFSObject getSFSObjectValue();

	public abstract ISFSArray getSFSArrayValue();

	public abstract boolean isNull();

	public abstract ISFSArray toSFSArray();
}