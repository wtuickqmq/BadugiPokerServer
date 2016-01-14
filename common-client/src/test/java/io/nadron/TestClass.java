package io.nadron;

import io.nadron.client.app.Session;
import io.nadron.client.app.impl.SessionFactory;
import io.nadron.client.event.Event;
import io.nadron.client.event.Events;
import io.nadron.client.event.impl.AbstractSessionEventHandler;
import io.nadron.client.util.LoginHelper;
import io.nadron.client.util.LoginHelper.LoginBuilder;

import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * A simple test class for connecting Nad client to a remote nadron server. This
 * does not have any game logic and will just print out events coming from the
 * server.
 * 
 * @author Abraham Menacherry
 * 
 */
public class TestClass {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestClass.class);

	/**
	 * @param args
	 * @throws Exception
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException, Exception {
//		for(int i = 1;i<=1;i++)
//			testGame(i);
			
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
		LoginBuilder builder = new LoginBuilder().username("user").password(String.valueOf(id)).connectionKey("player").nadronTcpHostName("127.0.0.1").tcpPort(20001);
		LoginHelper loginHelper = builder.build();
		SessionFactory sessionFactory = new SessionFactory(loginHelper);
		Session session = sessionFactory.createAndConnectSession();
		AbstractSessionEventHandler handler = new AbstractSessionEventHandler(session) {
			@Override
			public void onDataIn(Event event) {
				System.out.println("Received event: " + event);
			}

			@Override
			public void onLoginSuccess(Event event) {
				
				String loginInfo = String.format("{\"event\":\"e_login\",\"fbid\":\"%d\",\"flag\":0}", id);
				
				Object status = this.session.getTcpMessageSender().sendMessage(Events.dataInEvent(loginInfo));
				LOGGER.info("send login request :{}",status);
			}

		};
		session.addHandler(handler);
	}
}
