package com.badugi.game.logic.handler;

import io.nadron.client.app.Session;
import io.nadron.client.event.Event;
import io.nadron.client.event.impl.AbstractSessionEventHandler;
import io.nadron.client.util.ObjectBeanUtil;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.model.callback.ClientRequest;
import com.badugi.game.logic.model.callback.Forward2Logic;
import com.badugi.game.logic.model.callback.LogicMap;
import com.badugi.game.logic.model.callback.RequestPool;
import com.badugi.game.logic.model.proxy.LogicProxyClient;
import com.badugi.game.logic.task.ConnectProxyTask;
import com.badugi.game.logic.util.EventSourceUtil;
import com.badugi.game.logic.util.LogicChannelUtil;
import com.joker.common.util.Base64Util;
import com.joker.common.util.StringUtil;

public class DefaultHandler extends AbstractSessionEventHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHandler.class);

	public DefaultHandler() {
	}

	public DefaultHandler(Session session) {
		super(session);
	}

	@Override
	public void onDataIn(Event event) {
		try {
			String readString = EventSourceUtil.buffer2String2(event);
			if (null != readString) {
				Forward2Logic proxyRequest = ObjectBeanUtil.JACKSON.readValue(readString, Forward2Logic.class);
				LOGGER.info("Received Proxy Request:{}", ObjectBeanUtil.JACKSON.writeValueAsString(proxyRequest));
				String requestData = proxyRequest.getRequest().toString();
				String data = Base64Util.decode2string(requestData);
				LogicMap rpcMap = ObjectBeanUtil.JACKSON.readValue(data, LogicMap.class);
				ClientRequest clientRequest = null;

				boolean hasEvent = rpcMap.containsKey("event") && !StringUtil.isEmpty(rpcMap.get("event"));
				boolean hasCMD = rpcMap.containsKey("cmd") && !StringUtil.isEmpty(rpcMap.get("cmd"));
				if (hasEvent) {
					String clientEvent = rpcMap.get("event").toString();
					clientRequest = new ClientRequest(clientEvent, rpcMap);
				} else if (hasCMD) {
					LOGGER.info("rpcMap :{}", rpcMap);
					String clientEvent = rpcMap.get("cmd").toString();
					clientRequest = new ClientRequest(clientEvent, rpcMap);
				}
				if (null != clientRequest) {
					clientRequest.setData(data);
					Event response = RequestPool.execute(proxyRequest, clientRequest);
					if (null != response) {
						LogicChannelUtil.writeObjectToChannel(session, response);
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	@Override
	public void onCustomEvent(Event event) {
//		LOGGER.info("Received event: {}", event);
	}

	@Override
	public void onLoginSuccess(Event event) {
		LogicProxyClient.setStatus(LogicProxyClient.STATUS_ALREADY_CONNECT);
		LOGGER.info("connect succes");
		try {
			ConnectProxyTask.stopCrontab();
			LOGGER.info("stop connect task...");
		} catch (SchedulerException e) {
			LOGGER.error("stop connect task exception:{}", e);
		}
	}

	@Override
	public void onConnectFailed(Event event) {
		super.onConnectFailed(event);
		LogicProxyClient.setStatus(LogicProxyClient.STATUS_NOT_CONNECT);
		LOGGER.warn("connect failed");
	}

	@Override
	public void onDisconnect(Event event) {
		super.onClose(event);
		LogicProxyClient.setStatus(LogicProxyClient.STATUS_CLOSE_CONNECT);
		LOGGER.info("remote server close, event={}", event);
		// 断线重连
		try {
			ConnectProxyTask.startCrontab();
			LOGGER.info("start connect task...");
		} catch (SchedulerException e) {
			LOGGER.error("start connect task exception:{}", e);
		}

	}

	public void onException(Event event) {
		LOGGER.warn("exception:{}", event.getSource());
	}

}
