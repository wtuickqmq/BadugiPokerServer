package com.inkstd.badugi.game.proxy.utils;

import io.nadron.util.ObjectBeanUtil;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.inkstd.badugi.game.proxy.model.event.EventHashMap;
import com.joker.common.util.StringUtil;


public class EventSourceUtil {

	public static final String buffer2String(io.nadron.event.Event event) {
		String value = null;
		Object source = event.getSource();
		if (source instanceof io.nadron.communication.NettyMessageBuffer) {
			io.nadron.communication.NettyMessageBuffer buffer = (io.nadron.communication.NettyMessageBuffer) source;
			String readString = null;
			readString = buffer.readString();
			if (StringUtil.isEmpty(readString))
				return value;
			value = readString;
		}
		return value;
	}

	public static final <T> T buffer2Object(io.nadron.event.Event event, Class<T> c) throws JsonParseException, JsonMappingException, IOException {
		String value = buffer2String(event);
		if (null != value) {
			return ObjectBeanUtil.JACKSON.readValue(value, c);
		}
		return null;
	}

	public static final EventHashMap buffer2Map(io.nadron.event.Event event) throws JsonParseException, JsonMappingException, IOException {
		return buffer2Object(event, EventHashMap.class);
	}
}
