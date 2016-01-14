package io.nadron.extension.variables;

import io.nadron.extension.data.ISFSArray;

public class SFSRoomVariable extends SFSUserVariable implements RoomVariable {
	private volatile boolean _private;
	private volatile boolean _persistent;
	private volatile boolean _global;

	private SFSRoomVariable(String name) {
		super(name);
	}

	private SFSRoomVariable(String name, String type, String literal) {
		super(name, VariableType.fromString(type), literal);
	}

	public SFSRoomVariable(String name, Object value) {
		this(name, value, false, false, false);
	}

	public SFSRoomVariable(String name, Object value, boolean isPrivate, boolean isPersistent, boolean isGlobal) {
		super(name, value);
		this._private = isPrivate;
		this._persistent = isPersistent;
		this._global = isGlobal;
	}

	public static SFSRoomVariable newFromStringLiteral(String name, String type, String literal) {
		return new SFSRoomVariable(name, type, literal);
	}

	public static SFSRoomVariable newFromSFSArray(ISFSArray array) {
		return new SFSRoomVariable(array.getUtfString(0), array.getElementAt(2), array.getBool(3).booleanValue(), array.getBool(4).booleanValue(), false);
	}

	public boolean isGlobal() {
		return this._global;
	}

	public boolean isPersistent() {
		return this._persistent;
	}

	public boolean isPrivate() {
		return this._private;
	}

	public void setGlobal(boolean flag) {
		this._global = flag;
	}

	public void setPersistent(boolean flag) {
		this._persistent = flag;
	}

	public void setPrivate(boolean flag) {
		this._private = flag;
	}

	public ISFSArray toSFSArray() {
		ISFSArray sfsa = super.toSFSArray();

		sfsa.addBool(isPrivate());

		sfsa.addBool(isPersistent());

		return sfsa;
	}

	public String toString() {
		return String.format("{ N: %s, T: %s, V: %s, Pr: %s, Ps: %s, G: %s, H: %s, Owner: %s }",
				new Object[] { this.name, this.type, this.value, Boolean.valueOf(this._private), Boolean.valueOf(this._persistent), Boolean.valueOf(this._global), Boolean.valueOf(isHidden()), });
	}
}