package com.badugi.game.logic.model.proxy;

import io.nadron.client.app.Session;
import io.nadron.client.app.impl.SessionFactory;
import io.nadron.client.event.impl.AbstractSessionEventHandler;
import io.nadron.client.util.LoginHelper;
import io.nadron.client.util.LoginHelper.LoginBuilder;
import io.nadron.client.util.ObjectBeanUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badugi.game.logic.handler.DefaultHandler;
import com.badugi.game.logic.util.LogicPropertyUtil;
import com.google.common.collect.Lists;
import com.joker.common.util.MacUtil;
import com.joker.common.util.RootUtil;
import com.joker.common.util.SocketUtil;

import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicInteger;

public class LogicProxyClient {

	public static final int STATUS_NOT_CONNECT = 0;

	public static final int STATUS_ALREADY_CONNECT = 1;

	public static final int STATUS_CLOSE_CONNECT = 2;

	private static AtomicInteger status = new AtomicInteger(0);
	
	private static Session session = null;
	
	
	private static SessionFactory sessionFactory;

	private LogicProxyClient() {
	}

	public static void connect(String tcpHost, int tcpPort) throws InterruptedException, Exception {
		synchronized (LogicProxyClient.class) {
			int status = getStatus();
			if (status == STATUS_NOT_CONNECT || status == STATUS_CLOSE_CONNECT) {
				if (SocketUtil.isStart(tcpHost, tcpPort)) {
					Map<String, Object> rpcInfo = new HashMap<String, Object>();
					rpcInfo.put("macAddress", MacUtil.getMacAddress());
					rpcInfo.put("processId", RootUtil.getProcessID());
					rpcInfo.put("weight", Integer.valueOf(System.getProperty("rpc.weight", "1").trim()));
					rpcInfo.put("balance", Integer.valueOf(System.getProperty("balance", "0").trim()));
					List<Integer> list = Lists.newArrayList();
					for(int i =0;i<10;i++){
						list.add(i);
					}
					rpcInfo.put("test", list);
					String rpcPwd = "rpc@service";
					try {
						rpcPwd = ObjectBeanUtil.JACKSON.writeValueAsString(rpcInfo);
					} catch (Exception e) {
					}
					String userName = LogicPropertyUtil.getString("logic.userName", "rpc@service");
					String room = LogicPropertyUtil.getString("logic.room", "rpc");
					LoginBuilder builder = new LoginBuilder().username(userName).password(rpcPwd).connectionKey(room).nadronTcpHostName(tcpHost).tcpPort(Integer.valueOf(tcpPort));
					LoginHelper loginHelper = builder.build();
					sessionFactory = new SessionFactory(loginHelper);
					session = sessionFactory.createSession();
					AbstractSessionEventHandler handler = new DefaultHandler(session);
					sessionFactory.connectSession(session);
					session.addHandler(handler);
				}
			} else if (getStatus() == STATUS_ALREADY_CONNECT) {
				// session.removeHandler(handler);
			}
		}
	}

	public static int getStatus() {
		synchronized (LogicProxyClient.class) {
			return status.get();
		}
	}

	public static void setStatus(int st) {
		synchronized (LogicProxyClient.class) {
			status.set(st);
		}
	}

	public static Session getSession() {
		return session;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		LogicProxyClient.sessionFactory = sessionFactory;
	}

}
