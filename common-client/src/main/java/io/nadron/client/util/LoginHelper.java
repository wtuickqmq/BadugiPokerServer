package io.nadron.client.util;

import flex.messaging.io.ArrayList;
import io.nadron.client.app.impl.SessionFactory;
import io.nadron.client.communication.MessageBuffer;
import io.nadron.client.communication.NettyMessageBuffer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The creation of a connection to a remote nadron server requires multiple
 * parameters, for e.g. username, password etc. These parameters are stored in
 * this class which uses a builder pattern to create an instance. This instance
 * is then passed on to {@link SessionFactory} to actually create the sessions,
 * connections etc.
 * 
 * @author Abraham Menacherry
 * 
 */
public class LoginHelper {
	private final Integer type;
	private final String extension;
	private final String username;
	private final String password;
	private final String connectionKey;
	private final InetSocketAddress tcpServerAddress;
	private final InetSocketAddress udpServerAddress;

	protected LoginHelper(LoginBuilder loginBuilder) {
		loginBuilder.validateAndSetValues();
		this.type = loginBuilder.type;
		this.extension = loginBuilder.extension;
		this.username = loginBuilder.username;
		this.password = loginBuilder.password;
		this.connectionKey = loginBuilder.connectionKey;
		this.tcpServerAddress = loginBuilder.tcpServerAddress;
		this.udpServerAddress = loginBuilder.udpServerAddress;
	}

	public static class LoginBuilder {

		private Integer type;
		private String extension;
		private String username;
		private String password;
		private String connectionKey;
		private String nadronTcpHostName;
		private Integer tcpPort;
		private String nadronUdpHostName;
		private Integer udpPort;
		private InetSocketAddress tcpServerAddress;
		private InetSocketAddress udpServerAddress;

		public String getUsername() {
			return username;
		}

		public LoginBuilder username(String username) {
			this.username = username;
			return this;
		}

		public String getPassword() {
			return password;
		}

		public LoginBuilder password(String password) {
			this.password = password;
			return this;
		}

		public String getConnectionKey() {
			return connectionKey;
		}

		public LoginBuilder connectionKey(String connectionKey) {
			this.connectionKey = connectionKey;
			return this;
		}

		public String getNadronTcpHostName() {
			return nadronTcpHostName;
		}

		public LoginBuilder nadronTcpHostName(String nadronTcpHostName) {
			this.nadronTcpHostName = nadronTcpHostName;
			return this;
		}

		public int getTcpPort() {
			return tcpPort;
		}

		public LoginBuilder tcpPort(int tcpPort) {
			this.tcpPort = tcpPort;
			return this;
		}

		public Integer getType() {
			return type;
		}

		public void setType(Integer type) {
			this.type = type;
		}

		public String getExtension() {
			return extension;
		}

		public void setExtension(String extension) {
			this.extension = extension;
		}

		public String getNadronUdpHostName() {
			return nadronUdpHostName;
		}

		public LoginBuilder nadronUdpHostName(String nadronUdpHostName) {
			this.nadronUdpHostName = nadronUdpHostName;
			return this;
		}

		public int getUdpPort() {
			return udpPort;
		}

		public LoginBuilder udpPort(int udpPort) {
			this.udpPort = udpPort;
			return this;
		}

		public InetSocketAddress getTcpServerAddress() {
			return tcpServerAddress;
		}

		public LoginBuilder tcpServerAddress(InetSocketAddress tcpServerAddress) {
			this.tcpServerAddress = tcpServerAddress;
			return this;
		}

		public InetSocketAddress udpServerAddress() {
			return udpServerAddress;
		}

		public LoginBuilder udpServerAddress(InetSocketAddress updServerAddress) {
			this.udpServerAddress = updServerAddress;
			return this;
		}

		public LoginHelper build() {
			return new LoginHelper(this);
		}

		/**
		 * This method is used to validate and set the variables to default
		 * values if they are not already set before calling build. This method
		 * is invoked by the constructor of LoginHelper. <b>Important!</b>
		 * Builder child classes which override this method need to call
		 * super.validateAndSetValues(), otherwise you could get runtime NPE's.
		 */
		protected void validateAndSetValues() {
			if (null == username) {
				throw new IllegalArgumentException("Username cannot be null");
			}
			if (null == password) {
				throw new IllegalArgumentException("Password cannot be null");
			}
			if (null == connectionKey) {
				throw new IllegalArgumentException("ConnectionKey cannot be null");
			}
			if (null == tcpServerAddress && (null == nadronTcpHostName || null == tcpPort)) {
				throw new IllegalArgumentException("tcpServerAddress cannot be null");
			}

			if (null == tcpServerAddress) {
				tcpServerAddress = new InetSocketAddress(nadronTcpHostName, tcpPort);
			}

			if (null == udpServerAddress) {
				if (null != nadronUdpHostName && null != udpPort) {
					udpServerAddress = new InetSocketAddress(nadronUdpHostName, udpPort);
				}
			}
		}
	}

	public Map<String, Object> getLoginMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", username);
		map.put("password", password);
		map.put("connectionKey", connectionKey);
		return map;
	}

	public List<Object> getLoginList() {
		@SuppressWarnings("unchecked")
		List<Object> list = new ArrayList();
		list.add(username);
		list.add(password);
		list.add(connectionKey);
		return list;
	}

	/**
	 * Creates the appropriate login buffer using username, password,
	 * connectionkey and the local address to which the UDP channel is bound.
	 * 
	 * @param localUDPAddress
	 *            <b>optional</b> If passed in, then this address is passed on
	 *            to nadron server, so that it can associate this address with
	 *            its session.
	 * @return Returns the ByteBuf representation of username, password,
	 *         connection key, udp local bind address etc.
	 * @throws Exception
	 */
	public MessageBuffer<ByteBuf> getLoginBuffer(InetSocketAddress localUDPAddress) throws Exception {
		ByteBuf loginBuffer;

		ByteBuf credentials = null;

		if (null==type||type == 0) {
			credentials = NettyUtils.writeStrings(username, password, connectionKey);
		} else {
			credentials = NettyUtils.writeStrings(extension);
		}

		if (null != localUDPAddress) {
			ByteBuf udpAddressBuffer = NettyUtils.writeSocketAddress(localUDPAddress);
			loginBuffer = Unpooled.wrappedBuffer(credentials, udpAddressBuffer);
		} else {
			loginBuffer = credentials;
		}
		return new NettyMessageBuffer(loginBuffer);
	}

	/**
	 * Creates a wrapped netty buffer with reconnect key and udp address as its
	 * payload.
	 * 
	 * @param reconnectKey
	 *            The key that was initially sent by server on game room join
	 *            success event will be sent back to server for reconnecting
	 * @param udpAddress
	 *            If udp connection is required, then the new udpAddress need to
	 *            be sent.
	 * @return Returns the channel buffer containing reconnect key and udp
	 *         address in binary format.
	 */
	public MessageBuffer<ByteBuf> getReconnectBuffer(String reconnectKey, InetSocketAddress udpAddress) {
		ByteBuf reconnectBuffer = null;
		ByteBuf buffer = NettyUtils.writeString(reconnectKey);
		if (null != udpAddress) {
			reconnectBuffer = Unpooled.wrappedBuffer(buffer, NettyUtils.writeSocketAddress(udpAddress));
		} else {
			reconnectBuffer = buffer;
		}
		return new NettyMessageBuffer(reconnectBuffer);
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getConnectionKey() {
		return connectionKey;
	}

	public InetSocketAddress getTcpServerAddress() {
		return tcpServerAddress;
	}

	public InetSocketAddress getUdpServerAddress() {
		return udpServerAddress;
	}

	public Integer getType() {
		return type;
	}

	public String getExtension() {
		return extension;
	}
	
	
}
