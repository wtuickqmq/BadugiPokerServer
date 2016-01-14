package io.nadron;

import io.nadron.client.app.Session;
import io.nadron.client.app.impl.SessionFactory;
import io.nadron.client.event.Event;
import io.nadron.client.event.Events;
import io.nadron.client.event.impl.AbstractSessionEventHandler;
import io.nadron.client.util.LoginHelper;
import io.nadron.client.util.ObjectBeanUtil;
import io.nadron.client.util.LoginHelper.LoginBuilder;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class TestClient {

	/**
	 * @param args
	 * @throws Exception
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException, Exception {
		String clientSize = System.getProperty("client.zie", "1");
		int size = Integer.valueOf(clientSize);
		System.out.println("init client size: " + size);
		for (int i = 1; i <= size; i++)
			testGame(i);

	}

	static void testDefault() throws InterruptedException, Exception {
		LoginBuilder builder = new LoginBuilder().username("user").password("pass").connectionKey("Zombie_ROOM_1_REF_KEY_1").nadronTcpHostName("localhost").tcpPort(18090)
				.nadronUdpHostName("255.255.255.255").udpPort(18090);
		LoginHelper loginHelper = builder.build();
		SessionFactory sessionFactory = new SessionFactory(loginHelper);
		Session session = sessionFactory.createAndConnectSession();
		AbstractSessionEventHandler handler = new AbstractSessionEventHandler(session) {
			@Override
			public void onDataIn(Event event) {
				System.out.println("Received event: " + event);
			}

		};
		session.addHandler(handler);
	}

	static void testGame(final int id) throws InterruptedException, Exception {
		String host = System.getProperty("proxy.host", "127.0.0.1");
		String port = System.getProperty("proxy.port", "8801");

		Map<String,Object> args = new HashMap<String, Object>();
		int userid=1000110;
		args.put("userid", String.valueOf(userid));
		args.put("username", "lion");
		args.put("password", "lion");
		Map<String,Object> data = new HashMap<String, Object>();
		
		data.put("game", "play");
		data.put("rid", "1301");
		data.put("puid", userid);
		data.put("sign", "");
		
		args.put("data", data);
		String parames= ObjectBeanUtil
				.JACKSON.writeValueAsString(args);
		LoginBuilder builder = new LoginBuilder().username("user").password(String.valueOf(id)).connectionKey("play").nadronTcpHostName(host).tcpPort(Integer.valueOf(port));
		builder.setType(1);
		builder.setExtension(parames);
//		builder.type(1).parames(parames);
		
		LoginHelper loginHelper = builder.build();
		final SessionFactory sessionFactory = new SessionFactory(loginHelper);
		Session session = sessionFactory.createAndConnectSession();
		AbstractSessionEventHandler handler = new AbstractSessionEventHandler(session) {
			@Override
			public void onDataIn(Event event) {
				System.out.println("Received event: " + event);
			}

			@Override
			public void onLoginSuccess(Event event) {
//				this.session.getTcpMessageSender().sendMessage(Events.event(null, Events.GAME_ROOM_JOIN));
				sendSit();
			}

			void sendUserLogin() {

				String loginInfo = String.format("{\"event\":\"e_login\",\"fbid\":\"%d\",\"flag\":0}", id);

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("event", "escape_exit");
				map.put("fbid", 100000L);

				Object status1 = this.session.getTcpMessageSender().sendMessage(Events.dataInEvent(loginInfo));
				Object status2 = this.session.getTcpMessageSender().sendMessage(Events.dataInEvent(map));

				System.out.println(status1);
				System.out.println(status2);
			}
			
			void sendSit() {
				
				String loginInfo = String.format("{\"cmd\":\"getseatno\",\"rid\":\"1301\",\"chips\":100000.00}", id);
				String loginInfo2 = String.format("{\"minlimit\":100000,\"takechips\":1000000,\"seatno\":0,\"autoapp\":true,\"rid\":\"1301\",\"maxlimit\":2000000,\"cmd\":\"setsitdown\",\"starttb\":false,\"autoappingame\":false,\"deflimit\":1000000}", id);
				
				Object status1 = this.session.getTcpMessageSender().sendMessage(Events.dataInEvent(loginInfo));
				Object status2 = this.session.getTcpMessageSender().sendMessage(Events.dataInEvent(loginInfo2));
				
				System.out.println(status1);
				System.out.println(status2);
			}

			void shutdown() {
				session.close();
				System.err.println("close...");
				sessionFactory.getTcpClient().getBootstrap().group().shutdownGracefully();
			}

		};
		session.addHandler(handler);
	}
}
