package com.badugi.game.logic.model.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.joker.common.util.Base64Util;

import io.nadron.client.util.ObjectBeanUtil;

public final class ProxyResponseBuilder {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProxyResponseBuilder.class);

	/**
	 * 将要发送的数据进行打包
	 * 
	 * @param response
	 * @return
	 */
	public static final ProxyResponse build(ProxyResponse response) {

		ProxyResponse build = new ProxyResponse();
		Object clientResponse = response.getReponse();
		try {
			String value = ObjectBeanUtil.JACKSON.writeValueAsString(clientResponse);

			build.setChannelId(response.getChannelId());
			build.setProxy(response.getProxy());
			build.setBroadcast(response.getBroadcast());
			build.setSession(response.getSession());
			build.setTargets(response.getTargets());
			build.setReponse(Base64Util.encode(value));
			build.setExcludes(response.getExcludes());
			build.setIsRoute(response.getIsRoute());
		} catch (Exception e) {
			LOGGER.warn("", e);
		}
		return build;
	}
}
