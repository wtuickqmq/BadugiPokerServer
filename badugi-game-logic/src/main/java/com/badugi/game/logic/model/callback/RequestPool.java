package com.badugi.game.logic.model.callback;

import io.nadron.client.event.Event;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RequestPool {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestPool.class);

	private static final Map<String, RPCCall> CALLBACK = new HashMap<String, RPCCall>();

	public static void setCallback(String name, RPCCall call) {
		try {
			if (CALLBACK.containsKey(name)) {
				LOGGER.warn("exists call name:{} will override:{}", name,CALLBACK.get(name).getObject().getClass());
			}
			CALLBACK.put(name, call);
		} catch (Exception e) {

		}
	}

	public static Event execute(Forward2Logic proxy, ClientRequest client) {
		Object reponse = null;
		String event = client.getEvent();
		RPCCall call = CALLBACK.get(event);

		Event responseEvent = null;
		if (null != call) {
			String targetMethod = call.getMethod();
			try {
				Object obj = call.getObject();

				Method target = obj.getClass().getMethod(targetMethod, LogicRequest.class);

				LogicRequest parames = new LogicRequest(proxy.getSession(), client.getParames());

				parames.setClientEvent(event);

				parames.setData(client.getData());

				String proxyChannelId = proxy.getChannelId();
				String proxySessionId = proxy.getSession();

				parames.setChannelId(proxy.getChannelId());

				reponse = target.invoke(obj, parames);

				if (null != reponse && null != proxyChannelId && null != proxySessionId) {
					// String value = null;
					// value =
					// ObjectBeanUtil.JACKSON.writeValueAsString(reponse);
					// value = Base64Util.encode(value);
					ProxyResponse response = new ProxyResponse();
					response.setChannelId(proxy.getChannelId());
					response.setSession(proxy.getSession());
					response.setReponse(reponse);
					response = ProxyResponseBuilder.build(response);
					responseEvent = io.nadron.client.event.Events.dataInEvent(response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error("", e);
			}
		} else {
			LOGGER.warn("nou found callback:{}", event);
		}
		return responseEvent;
	}
}
