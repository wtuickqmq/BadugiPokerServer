package com.badugi.game.logic.util;

import io.nadron.client.util.ObjectBeanUtil;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.joker.common.util.StringUtil;

public class EventSourceUtil {


	public static final String buffer2String2(io.nadron.client.event.Event event) {
		String value = null;
		Object source = event.getSource();
		if (source instanceof io.nadron.client.communication.NettyMessageBuffer) {
			io.nadron.client.communication.NettyMessageBuffer buffer = (io.nadron.client.communication.NettyMessageBuffer) source;
			String readString = null;
			readString = buffer.readString();
			if (StringUtil.isEmpty(readString))
				return value;
			value = readString;
		}
		return value;
	}

	public static final <T> T buffer2Object2(io.nadron.client.event.Event event, Class<T> c) throws JsonParseException, JsonMappingException, IOException {
		String value = buffer2String2(event);
		if (null != value) {
			return ObjectBeanUtil.JACKSON.readValue(value, c);
		}
		return null;
	}
}
