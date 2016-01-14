package io.nadron.client.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.JavaType;

public class ObjectBeanUtil {

	public static final ObjectMapper JACKSON = new ObjectMapper();

	static {
		JACKSON.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		JACKSON.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
	}
	
	
	public static <T> java.util.List<T> subList(final List<T> list, final int startIndex, final int endIndex) {
		if (null == list || list.isEmpty()) {
			return new ArrayList<T>();
		}
		int size = list.size();
		int min = startIndex;
		int max = endIndex == -1 ? size : size < endIndex ? size : endIndex;
		if (max < min) {
			min = min ^ max;
			max = min ^ max;
			min = min ^ max;
		}
		if (min >= size || min < 0) {
			return new ArrayList<T>();
		}
		return list.subList(min, max);
	}

	public static <T> List<T> readValueAsList(String json, Class<T> templ) throws JsonParseException, JsonMappingException, IOException {
		JavaType javaType = getDefaultType(ArrayList.class, templ);
		List<T> value1 = null;
		value1 = ObjectBeanUtil.JACKSON.readValue(json, javaType);
		return value1;
	}

	public static <K, V> Map<K, V> readValueAsMap(String json, Class<K> k, Class<V> v) throws JsonParseException, JsonMappingException, IOException {
		JavaType javaType = getDefaultType(Map.class, k, v);
		Map<K, V> value1 = null;
		value1 = ObjectBeanUtil.JACKSON.readValue(json, javaType);
		return value1;
	}

	public static JavaType getDefaultType(Class<?> collectionClass, Class<?>... elementClasses) {
		return JACKSON.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}
}
