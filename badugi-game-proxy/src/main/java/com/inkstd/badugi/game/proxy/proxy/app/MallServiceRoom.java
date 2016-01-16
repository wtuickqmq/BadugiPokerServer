package com.inkstd.badugi.game.proxy.proxy.app;

import io.nadron.app.PlayerSession;
import io.nadron.app.impl.GameRoomSession;
import io.nadron.common.http.Request;
import io.nadron.util.ObjectBeanUtil;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;
import com.inkstd.badugi.game.common.constant.MallNotifyEvents;
import com.inkstd.badugi.game.proxy.proxy.handler.MallRoomSessionHandler;
import com.inkstd.badugi.game.proxy.proxy.handler.MallServiceHandler;
import com.inkstd.badugi.game.proxy.service.MallSessionManager;
import com.inkstd.badugi.game.proxy.service.NotifyService;
import com.inkstd.badugi.game.proxy.service.PlayerMapedService;
import com.inkstd.badugi.game.proxy.utils.ProxyBeanUtil;



public class MallServiceRoom extends GameRoomSession {

	private static final Logger LOGGER = LoggerFactory.getLogger(MallServiceRoom.class);

	protected MallSessionManager mallSessionManager;

	public MallServiceRoom(GameRoomSessionBuilder sessionBuilder, MallSessionManager mallSessionManager) {
		super(sessionBuilder);
		this.mallSessionManager = mallSessionManager;
		addHandler(new MallRoomSessionHandler(this));
	}

	@Override
	public void onLogin(PlayerSession session) {
		MallServiceHandler listener = new MallServiceHandler(session);
		session.addHandler(listener);
		LOGGER.info("session login={}", session);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object onHTTPRequest(Request request) {
		Map<String, Object> response = Maps.newHashMap();
		try {
			Map<String, String> httpQuery = request.getQueryStringMap();

			LOGGER.info("request: {}", httpQuery);

			// Map<String, Object> test = Maps.newHashMap();
			// test.put("event", "say");
			// test.put("msg", "hello");

			if (httpQuery.containsKey("event")) {

				String event = httpQuery.get("event");

				if (MallNotifyEvents.CHANGE_AMOUNT.equals(event)) //
				{
					Object data = ProxyBeanUtil.get(NotifyService.class).call_change_amt(httpQuery);

					response.put("data", data);

				} else if (MallNotifyEvents.CHANGE_EXP.equals(event)) //
				{
					Object data = ProxyBeanUtil.get(NotifyService.class).call_change_exp(httpQuery);
					response.put("data", data);

				} else if (MallNotifyEvents.LOUDSPEAKER_MSG.equals(event))//
				{
					Object data = ProxyBeanUtil.get(NotifyService.class).call_horn(httpQuery);
					response.put("data", data);

				} else if (MallNotifyEvents.NEW_ACHIEVE.equals(event)) //
				{
					Object data = ProxyBeanUtil.get(NotifyService.class).call_new_achieve(httpQuery);
					response.put("data", data);

				} else if (MallNotifyEvents.NEW_LEVEL.equals(event))//
				{
					Object data = ProxyBeanUtil.get(NotifyService.class).call_new_level(httpQuery);
					response.put("data", data);

				} else if (MallNotifyEvents.NEW_MESSAGE.equals(event)) //
				{
					Object data = ProxyBeanUtil.get(NotifyService.class).call_new_msg(httpQuery);
					response.put("data", data);

				} else if (MallNotifyEvents.NEW_VIP_LEVEL.equals(event)) //
				{
					Object data = ProxyBeanUtil.get(NotifyService.class).call_new_viplv(httpQuery);
					response.put("data", data);

				} else if (MallNotifyEvents.PRESENT_CHIPS_MSG.equals(event)) //
				{
					Object data = ProxyBeanUtil.get(NotifyService.class).call_present_chips(httpQuery);
					response.put("data", data);

				} 
				else if (MallNotifyEvents.DRAGON_BUY.equals(event)) //
				{
					Object data = ProxyBeanUtil.get(NotifyService.class).call_dragon_buy(httpQuery);
					response.put("data", data);

				} 
				else if (MallNotifyEvents.PLOTLINE.equals(event))
				{
					Object data = ProxyBeanUtil.get(NotifyService.class).call_plotline(httpQuery);
					response.put("data", data);
				}
				else if ("friend_req".equals(event)) //
				{
					Object data = ProxyBeanUtil.get(NotifyService.class).call_friend_req(httpQuery);
					response.put("data", data);
				}
				if ("notify".equals(event) && httpQuery.containsKey("data")) {
					
				} else if ("online".equals(event)) {
					int online = ProxyBeanUtil.get(PlayerMapedService.class).getOnlineSize();
					response.put("size", online);
				} else if ("isOnline".equals(event)) {
					if (httpQuery.containsKey("target")) {
						int isOnline = ProxyBeanUtil.get(PlayerMapedService.class).isOnline(httpQuery.get("target"));
						response.put("isOnline", isOnline);
					}

				} else if ("playerId2proxyId".equals(event)) {
					Map<String, String> online = ProxyBeanUtil.get(PlayerMapedService.class).getPlayerId2proxyId();
					response.put("playerId2proxyId", online);

				}
			}

			LOGGER.info("{}", ObjectBeanUtil.JACKSON.writeValueAsString(response));
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return response;
	}

}
