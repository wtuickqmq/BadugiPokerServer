package com.badugi.game.logic.util;

import io.nadron.client.app.Session;
import io.nadron.client.communication.MessageSender.Reliable;
import io.nadron.client.event.Event;
import io.nadron.client.event.Events;
import io.nadron.client.util.ObjectBeanUtil;
import io.netty.channel.ChannelFuture;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.ChannelGroupFuture;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.model.callback.ProxyResponse;
import com.badugi.game.logic.model.callback.ProxyResponseBuilder;
import com.badugi.game.logic.model.proxy.LogicProxyClient;
import com.google.common.collect.Lists;
import com.joker.game.common.constant.Constant;

public class LogicChannelUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogicChannelUtil.class);

	/**
	 * 消息发送类，并处理所有消息发送异常
	 * 
	 * @param response
	 *            回应的消息
	 */
	public static final ChannelFuture writeObjectToChannel(final Session session, final Object response, boolean jsonFormat) {
		return writeObjectToChannel(session, response, -1, jsonFormat);
	}

	/**
	 * 消息发送类，并处理所有消息发送异常
	 * 
	 * @param response
	 *            回应的消息
	 */
	public static final ChannelGroupFuture writeObjectToChannelGroup(final ChannelGroup channelGroup, final Object response, boolean jsonFormat) {
		return writeObjectToChannelGroup(channelGroup, response, -1, jsonFormat);
	}

	public static Event buildEvent(Object response, int eventType, boolean jsonFormat) throws JsonGenerationException, JsonMappingException, IOException {
		Event event = null;
		if (response instanceof Event) {
			event = (Event) response;
			boolean isNotString = true;
			if (event.getSource() instanceof String) {
				isNotString = false;
			}
			event.setSource((jsonFormat && isNotString) ? ObjectBeanUtil.JACKSON.writeValueAsString(event.getSource()) : event.getSource());
		} else {
			Object source = jsonFormat ? ObjectBeanUtil.JACKSON.writeValueAsString(response) : response;
			if (eventType > 0) {
				event = Events.event(source, eventType);
			} else {
				event = Events.dataInEvent(source);
			}
		}
		return event;
	}

	/**
	 * 消息发送类，并处理所有消息发送异常
	 * 
	 * @param response
	 *            回应的消息
	 */
	public static final ChannelGroupFuture writeObjectToChannelGroup(ChannelGroup channelGroup, Object response, int eventType, boolean jsonFormat) {
		ChannelGroupFuture channelGroupFuture = null;
		if (null == response) {
			LOGGER.debug("response is null: [{}]", response);
			return channelGroupFuture;
		}
		Event event = null;
		try {
			event = buildEvent(response, eventType, jsonFormat);
			event.setType(Events.SESSION_MESSAGE);
			// String value = JACKSON.writeValueAsString(data);
			// WebSocketFrame frame = new TextWebSocketFrame(value);
			channelGroupFuture = channelGroup.write(event);
			LOGGER.trace("{}", event);
		} catch (Exception e) {
			LOGGER.warn("event={} ,e:{}", event, e);
		}
		return channelGroupFuture;
	}

	/**
	 * 消息发送类，并处理所有消息发送异常
	 * 
	 * @param response
	 *            回应的消息
	 */
	public static final ChannelFuture writeObjectToChannel(Session session, Object response, int eventType, boolean jsonFormat) {
		ChannelFuture channelFuture = null;
		if (null == session || null == response) {
			LOGGER.debug("session or response is null ! session[{}], response[{}]", session, response);
			return channelFuture;
		}
		Event event = null;
		try {
			event = buildEvent(response, eventType, jsonFormat);
			// String value = JACKSON.writeValueAsString(data);
			// WebSocketFrame frame = new TextWebSocketFrame(value);
			Reliable reliable = session.getTcpMessageSender();
			if (null != reliable) {
				// String value =
				// ProxyBeanUtil.JACKSON.writeValueAsString(event);
				channelFuture = (ChannelFuture) reliable.sendMessage(event);
			} else {
				LOGGER.warn("session tcp :{} null event:{} ", session, event);
			}
			LOGGER.trace("writeObjectToChannel {}", event);
		} catch (Exception e) {
			LOGGER.warn("event={} ,e:{}", event, e);
		}
		return channelFuture;
	}

	/**
	 * 消息发送类，并处理所有消息发送异常
	 * 
	 * @param response
	 *            回应的消息
	 */
	public static final ChannelFuture writeObjectToChannel(Session session, Event response) {
		return writeObjectToChannel(session, response, false);
	}

	/**
	 * 消息发送类，并处理所有消息发送异常
	 * 
	 * @param response
	 *            回应的消息
	 */
	public static final ChannelFuture writeObjectToChannel(Event response) {
		return writeObjectToChannel(LogicProxyClient.getSession(), response, false);
	}

	/**
	 * 服务器广播
	 * 
	 * @param event
	 * @param targets
	 */
	public static final ChannelFuture sendToTargets(Object event, List<String> targets) {
		ProxyResponse response = new ProxyResponse();
		response.setChannelId(null);
		response.setSession(null);
		response.setReponse(event);
		response.setTargets(targets);
		response.setProxy(null);
		Event responseEvent = io.nadron.client.event.Events.event(ProxyResponseBuilder.build(response), Constant.EVENT_TYPE_BROADCAST);
		return LogicChannelUtil.writeObjectToChannel(responseEvent);
	}
	/**
	 * 服务器广播
	 * 
	 * @param event
	 * @param targets
	 */
	public static final ChannelFuture sendToTarget(Object event, String target) {
		return sendToTargets(event, Lists.newArrayList(target));
	}

	/**
	 * 服务器广播
	 * 
	 * @param event
	 * @param targets
	 */
	public static final ChannelFuture sendToAll(Object event) {
		ProxyResponse response = new ProxyResponse();
		response.setChannelId(null);
		response.setSession(null);
		response.setReponse(event);
		response.setProxy(null);
		Event responseEvent = io.nadron.client.event.Events.event(ProxyResponseBuilder.build(response), Constant.EVENT_TYPE_BROADCAST);
		return LogicChannelUtil.writeObjectToChannel(responseEvent);
	}

	/**
	 * 服务器广播
	 * 
	 * @param event
	 * @param targets
	 */
	public static final ChannelFuture sendToAllWithOutTargets(Object event, List<String> without) {
		ProxyResponse response = new ProxyResponse();
		response.setChannelId(null);
		response.setSession(null);
		response.setReponse(event);
		response.setProxy(null);
		response.setExcludes(without);
		Event responseEvent = io.nadron.client.event.Events.event(ProxyResponseBuilder.build(response), Constant.EVENT_TYPE_BROADCAST);
		return LogicChannelUtil.writeObjectToChannel(responseEvent);
	}

	/**
	 * 服务器广播
	 * 
	 * @param event
	 * @param targets
	 */
	public static final ChannelFuture sendToRobot(Object event) {
		ProxyResponse response = new ProxyResponse();
		response.setChannelId(null);
		response.setSession(null);
		response.setReponse(event);
		response.setProxy(null);
		Event responseEvent = io.nadron.client.event.Events.event(ProxyResponseBuilder.build(response), Constant.EVENT_TYPE_ROBOT);
		LOGGER.debug("sendToRobot:{}", response);
		return LogicChannelUtil.writeObjectToChannel(responseEvent);
	}

}
