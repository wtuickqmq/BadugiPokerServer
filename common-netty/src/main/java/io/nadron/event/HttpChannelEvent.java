package io.nadron.event;

import io.nadron.common.http.Request;
import io.netty.channel.Channel;

public interface HttpChannelEvent {
	
	void doRequest(Channel channel,Request request);
}