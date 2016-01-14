package io.nadron.extension.util;

import io.nadron.extension.data.ISFSObject;
import io.nadron.extension.variables.RoomVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONSerializer;

public final class SamrtFoxServerUtil {

	public static Object convertISFSObject(ISFSObject params) {
		if (null != params) {
			return JSONSerializer.toJSON(params.toJson());
		}
		return null;
	}

	public static Map<String, Object> getVariable(RoomVariable var) {
		if (null != var) {
			Map<String, Object> map = new HashMap<String, Object>();
			Object value = var.getValue();
			if (value instanceof ISFSObject) {
				value = SamrtFoxServerUtil.convertISFSObject((ISFSObject) value);
			}
			map.put(var.getName(), value);
			return map;
		}
		return null;
	}

	public static Map<String, Object> getVariable(List<RoomVariable> vars) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != vars && !vars.isEmpty()) {
			for (RoomVariable var : vars) {
				Map<String, Object> value = getVariable(var);
				if (null != value) {
					map.putAll(value);
				}
			}
		}
		return map;
	}

}
