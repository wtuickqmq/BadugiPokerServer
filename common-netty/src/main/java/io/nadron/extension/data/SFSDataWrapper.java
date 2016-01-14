package io.nadron.extension.data;

public class SFSDataWrapper {
	private SFSDataType typeId;
	private Object object;

	public SFSDataWrapper(SFSDataType typeId, Object object) {
		this.typeId = typeId;
		this.object = object;
	}

	public SFSDataType getTypeId() {
		return this.typeId;
	}

	public Object getObject() {
		return this.object;
	}
}