package com.badugi.game.logic.util;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.model.callback.RPCCall;
import com.badugi.game.logic.model.callback.RPCReponse;
import com.badugi.game.logic.model.callback.RPCService;
import com.badugi.game.logic.model.callback.RequestPool;
import com.badugi.game.logic.service.GameCarService;
import com.badugi.game.logic.service.GameMessageService;
import com.badugi.game.logic.service.MatchService;
import com.badugi.game.logic.service.PlayerService;

public class CallBackUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(CallBackUtil.class);

	public static final void initCallBack() {
		try {
			if (isExtension()) {
				initCall(GameCarService.class);
			} else if (isMatch()) {
				initCall(MatchService.class);
			} else {
				initCall(PlayerService.class);
				initCall(GameMessageService.class);
			}
			// add other
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	private static final void initCall(Class<? extends RPCService> beanClass) {
		try {
			initCallPool(AppContext.getBean(beanClass)); // spring 注入
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	private static final void initCallPool(Object object) throws InstantiationException, IllegalAccessException {
		Method[] methods = object.getClass().getDeclaredMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(RPCReponse.class)) {
				// 请求的参数
				String requestName = method.getAnnotation(RPCReponse.class).value();
				// 执行的函数
				String methodName = method.getName();
				// 注册回调
				RequestPool.setCallback(requestName, new RPCCall(methodName, object));
			}
		}
	}

	private static boolean isExtension() {
		String room = LogicPropertyUtil.getString("logic.room", "rpc");
		if ("extension".equalsIgnoreCase(room)) {
			return true;
		}
		return false;
	}

	private static boolean isMatch() {
		String room = LogicPropertyUtil.getString("logic.room", "rpc");
		if ("match".equalsIgnoreCase(room)) {
			return true;
		}
		return false;
	}

}
