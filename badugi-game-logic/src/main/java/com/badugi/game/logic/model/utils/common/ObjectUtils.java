package com.badugi.game.logic.model.utils.common;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
/**
 * 对象工具类
 * @author user02
 */
public final class ObjectUtils {
	
	
	public static final ObjectMapper MAPPER = new ObjectMapper();
	
	static {
		MAPPER.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
	}
	
}
