package io.nadron.extension.variables;

import io.nadron.extension.data.ISFSArray;
import io.nadron.extension.data.ISFSObject;
import io.nadron.extension.data.SFSArray;
import io.nadron.extension.data.SFSObject;
import io.nadron.extension.exception.SFSRuntimeException;

public class SFSUserVariable implements UserVariable {
	protected String name;
	protected volatile Object value;
	protected VariableType type;
	protected volatile boolean hidden;

	public static SFSUserVariable newInstance(String name, Object value) {
		return new SFSUserVariable(name, value);
	}

	public static SFSUserVariable newFromStringLiteral(String name, String type, String literal) {
		return new SFSUserVariable(name, type, literal);
	}

	public static SFSUserVariable newFromSFSArray(ISFSArray array) {
		return new SFSUserVariable(array.getUtfString(0), array.getElementAt(2));
	}

	public SFSUserVariable(String name, Object value) {
		this(name, value, false);
	}

	public SFSUserVariable(String name, Object value, boolean isHidden) {
		this(name);
		setValue(value);
		this.hidden = isHidden;
	}

	protected SFSUserVariable(String name) {
		this.name = name;
		this.hidden = false;
	}

	protected SFSUserVariable(String name, VariableType type, String literal) {
		this(name);
		setValueFromStringLiteral(type, literal);
	}

	protected SFSUserVariable(String name, String type, String literal) {
		this(name, VariableType.fromString(type), literal);
	}

	public boolean isHidden() {
		return this.hidden;
	}

	public void setHidden(boolean flag) {
		this.hidden = flag;
	}

	protected void setValueFromStringLiteral(VariableType type, String literal) {
		if (type == VariableType.NULL) {
			setNull();
		} else if (type == VariableType.BOOL) {
			setValue(Boolean.valueOf(Boolean.parseBoolean(literal)));
		} else if (type == VariableType.INT) {
			setValue(Integer.valueOf(Integer.parseInt(literal)));
		} else if (type == VariableType.DOUBLE) {
			setValue(Double.valueOf(Double.parseDouble(literal)));
		} else if (type == VariableType.STRING) {
			setValue(literal);
		} else if (type == VariableType.ARRAY) {
			setValue(SFSArray.newFromJsonData(literal));
		} else if (type == VariableType.OBJECT) {
			setValue(SFSObject.newFromJsonData(literal));
		}
	}

	public VariableType getType() {
		return this.type;
	}

	public Boolean getBoolValue() {
		return (Boolean) this.value;
	}

	public Double getDoubleValue() {
		return (Double) this.value;
	}

	public Integer getIntValue() {
		return (Integer) this.value;
	}

	public String getName() {
		return this.name;
	}

	public ISFSArray getSFSArrayValue() {
		return (ISFSArray) this.value;
	}

	public ISFSObject getSFSObjectValue() {
		return (ISFSObject) this.value;
	}

	public String getStringValue() {
		return (String) this.value;
	}

	public Object getValue() {
		return this.value;
	}

	public boolean isNull() {
		return this.type == VariableType.NULL;
	}

	public void setNull() {
		this.value = null;
		this.type = VariableType.NULL;
	}

	protected void setValue(Boolean val) {
		this.type = VariableType.BOOL;
		this.value = val;
	}

	protected void setValue(Double val) {
		this.type = VariableType.DOUBLE;
		this.value = val;
	}

	protected void setValue(Integer val) {
		this.type = VariableType.INT;
		this.value = val;
	}

	protected void setValue(ISFSArray val) {
		this.type = VariableType.ARRAY;
		this.value = val;
	}

	protected void setValue(ISFSObject val) {
		this.type = VariableType.OBJECT;
		this.value = val;
	}

	protected void setValue(Object val) {
		if (val == null) {
			this.type = VariableType.NULL;
		} else if ((val instanceof Boolean)) {
			setValue((Boolean) val);
		} else if ((val instanceof Byte)) {
			setValue(Integer.valueOf(((Byte) val).intValue()));
		} else if ((val instanceof Short)) {
			setValue(Integer.valueOf(((Short) val).intValue()));
		} else if ((val instanceof Integer)) {
			setValue((Integer) val);
		} else if ((val instanceof Long)) {
			setValue(Double.valueOf(((Long) val).doubleValue()));
		} else if ((val instanceof Float)) {
			setValue(Double.valueOf(((Float) val).doubleValue()));
		} else if ((val instanceof Double)) {
			setValue((Double) val);
		} else if ((val instanceof String)) {
			setValue((String) val);
		} else if ((val instanceof ISFSArray)) {
			setValue((ISFSArray) val);
		} else if ((val instanceof ISFSObject))
			setValue((ISFSObject) val);
		else
			throw new IllegalArgumentException("Cannot set variable type for value: " + (val != null ? val : "<Null>"));
	}

	public ISFSArray toSFSArray() {
		ISFSArray sfsa = SFSArray.newInstance();

		sfsa.addUtfString(this.name);

		sfsa.addByte((byte) this.type.getId());

		populateArrayWithValue(sfsa);

		return sfsa;
	}

	protected void populateArrayWithValue(ISFSArray sfsa) {
//		switch ($SWITCH_TABLE$com$smartfoxserver$v2$entities$variables$VariableType()[this.type.ordinal()]) {
//		switch (this.type.ordinal()) {
		switch (this.type.ordinal()) {
		case 1:
			sfsa.addNull();
			break;
		case 2:
			sfsa.addBool(getBoolValue().booleanValue());
			break;
		case 3:
			sfsa.addInt(getIntValue().intValue());
			break;
		case 4:
			sfsa.addDouble(getDoubleValue().doubleValue());
			break;
		case 5:
			sfsa.addUtfString(getStringValue());
			break;
		case 6:
			sfsa.addSFSObject(getSFSObjectValue());
			break;
		case 7:
			sfsa.addSFSArray(getSFSArrayValue());
		}
	}

	protected void setValue(String val) {
		this.type = VariableType.STRING;
		this.value = val;
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new SFSRuntimeException("Clone Error! " + e.getMessage() + ", " + toString());
		}
	}

	public String toString() {
		return String.format("{ N: %s, T: %s, V: %s, H: %s }", new Object[] { this.name, this.type, this.value, Boolean.valueOf(this.hidden) });
	}
}