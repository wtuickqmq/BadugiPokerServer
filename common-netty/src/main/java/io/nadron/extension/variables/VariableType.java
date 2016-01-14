package io.nadron.extension.variables;

public enum VariableType {
	NULL(0), BOOL(1), INT(2), DOUBLE(3), STRING(4), OBJECT(5), ARRAY(6);

	private int id;

	private VariableType(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public static VariableType fromString(String id) {
		return valueOf(id.toUpperCase());
	}

	public static VariableType fromId(int id) {
		for (VariableType type : values()) {
			if (type.id == id) {
				return type;
			}
		}
		return null;
	}
}