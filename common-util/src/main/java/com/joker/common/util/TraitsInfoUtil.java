package com.joker.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class TraitsInfoUtil {

	private final String className;

	private final boolean dynamic;

	private final boolean externalizable;

	private List<String> properties;

	public TraitsInfoUtil(String className) {
		this(className, false, false, 10);
	}

	public TraitsInfoUtil(String className, int initialCount) {
		this(className, false, false, initialCount);
	}

	public TraitsInfoUtil(String className, boolean dynamic, boolean externalizable, int initialCount) {
		this(className, dynamic, externalizable, new ArrayList<String>(initialCount));
	}

	public TraitsInfoUtil(String className, boolean dynamic, boolean externalizable, List<String> properties) {
		if (className == null)
			className = "";

		this.className = className;

		if (properties == null)
			properties = new ArrayList<String>();

		this.properties = properties;
		this.dynamic = dynamic;
		this.externalizable = externalizable;
	}

	public boolean isDynamic() {
		return dynamic;
	}

	public boolean isExternalizable() {
		return externalizable;
	}

	public int length() {
		return properties.size();
	}

	public String getClassName() {
		return className;
	}

	public void addProperty(String name) {
		properties.add(name);
	}

	public void addAllProperties(Collection<String> props) {
		properties.addAll(props);
	}

	public String getProperty(int i) {
		return (String) properties.get(i);
	}

	public List<String> getProperties() {
		return properties;
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof TraitsInfoUtil) {
			TraitsInfoUtil other = (TraitsInfoUtil) obj;
			if (!this.className.equals(other.className)) {
				return false;
			}
			if (!(this.dynamic == other.dynamic)) {
				return false;
			}
			List<String> thisProperties = this.properties;
			List<String> otherProperties = other.properties;
			if (thisProperties != otherProperties) {
				int thisCount = thisProperties.size();

				if (thisCount != otherProperties.size()) {
					return false;
				}

				for (int i = 0; i < thisCount; i++) {
					Object thisProp = thisProperties.get(i);
					Object otherProp = otherProperties.get(i);
					if (thisProp != null && otherProp != null) {
						if (!thisProp.equals(otherProp)) {
							return false;
						}
					}
				}
			}
			return true;
		}
		return false;
	}

	public int hashCode() {
		int c = className.hashCode();
		c = dynamic ? c << 2 : c << 1;
		c = c | (properties.size() << 24);
		return c;
	}
}