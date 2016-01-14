package io.nadron.common.http.serialization;

import io.netty.buffer.ByteBuf;

public interface Deserializer {
	
	public <T> T deserialize(String string, Class<T> type);
	
	public <T> T deserialize(ByteBuf buffer, Class<T> type);
	
}
