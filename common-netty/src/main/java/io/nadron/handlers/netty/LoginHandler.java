package io.nadron.handlers.netty;

import io.nadron.app.Game;
import io.nadron.app.GameRoom;
import io.nadron.app.Player;
import io.nadron.app.PlayerSession;
import io.nadron.app.Session;
import io.nadron.communication.NettyTCPMessageSender;
import io.nadron.event.Event;
import io.nadron.event.Events;
import io.nadron.event.impl.ReconnetEvent;
import io.nadron.server.netty.AbstractNettyServer;
import io.nadron.service.LookupService;
import io.nadron.service.SessionRegistryService;
import io.nadron.service.UniqueIDGeneratorService;
import io.nadron.service.impl.ReconnectSessionRegistry;
import io.nadron.util.Credentials;
import io.nadron.util.NadronConfig;
import io.nadron.util.NettyUtils;
import io.nadron.util.ObjectBeanUtil;
import io.nadron.util.SimpleCredentials;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Sharable
public class LoginHandler extends SimpleChannelInboundHandler<Event> {
	private static final Logger LOG = LoggerFactory.getLogger(LoginHandler.class);

	// private static final Integer LOGIN_TYPE_DEFAULT = 0;
	// private static final Integer LOGIN_TYPE_JSON = 1;

	protected LookupService lookupService;
	protected SessionRegistryService<SocketAddress> udpSessionRegistry;
	protected ReconnectSessionRegistry reconnectRegistry;
	protected UniqueIDGeneratorService idGeneratorService;
	protected int loginType;

	/**
	 * Used for book keeping purpose. It will count all open channels. Currently
	 * closed channels will not lead to a decrement.
	 */
	private static final AtomicInteger CHANNEL_COUNTER = new AtomicInteger(0);

	@Override
	public void channelRead0(ChannelHandlerContext ctx, Event event) throws Exception {
		ByteBuf buffer = null;
		Object source = event.getSource();
		if (source instanceof io.nadron.communication.NettyMessageBuffer) {
			buffer = ((io.nadron.communication.NettyMessageBuffer) source).getNativeBuffer();
		} else {
			buffer = (ByteBuf) event.getSource();
		}
		final Channel channel = ctx.channel();
		int type = event.getType();
		if (Events.LOG_IN == type) {
			Player player = lookupPlayer(buffer, channel);
			if (handleLogin(player, ctx)) {
				String refKey = null;//
				String gameRoomName = null;// NettyUtils.readString(buffer);
				String group = null;// NettyUtils.readString(buffer);

				refKey = NettyUtils.readString(buffer);
				gameRoomName = NettyUtils.readString(buffer);
				group = NettyUtils.readString(buffer);
				if (null == gameRoomName) {
					gameRoomName = refKey;
				}
				handleGameRoomJoin(player, ctx, buffer, refKey, gameRoomName, group);
			}
			LOG.debug("Login attempt from {}", channel.remoteAddress());
		} else if (Events.LOG_IN_WITH_JSON == type) {
			String json = NettyUtils.readString(buffer);
			try {
				LOG.debug("login json parames: {}", json);
				Map<String, Object> map = ObjectBeanUtil.readValueAsMap(json, String.class, Object.class);
				 String userid = map.get("userid").toString();
				String username = map.get("username").toString();
				String password = map.get("password").toString();
				Player player = lookupPlayer(userid,username, password);
				if (handleLogin(player, ctx)) {
					// 添加所有的属性
					player.addPropertyMap(map);

					String refKey = null;//
					// String gameRoomName = null;//
					// NettyUtils.readString(buffer);
					String group = null;// NettyUtils.readString(buffer);

					@SuppressWarnings("unchecked")
					Map<String, Object> data = (Map<String, Object>) map.get("data");
					refKey = data.get("game").toString();
					Object gameRoomKey = data.get("rid").toString();
					if (data.containsKey("group")) {
						group = data.get("group").toString();
					}
					if (null == gameRoomKey) {
						gameRoomKey = refKey;
					} else {
						if (gameRoomKey instanceof String) {
							gameRoomKey = Integer.parseInt((String) gameRoomKey);
						}
					}
					handleGameRoomJoin(player, ctx, buffer, refKey, gameRoomKey, group);
				}
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error("", e);
			}
		}

		else if (Events.RECONNECT == type) {
			LOG.debug("Reconnect attempt from {}", channel.remoteAddress());
			String reconnectKey = NettyUtils.readString(buffer);
			PlayerSession playerSession = lookupSession(reconnectKey);
			handleReconnect(playerSession, ctx, buffer);
		} else {
			LOG.error("Invalid event {} sent from remote address {}. " + "Going to close channel {}", new Object[] { event.getType(), channel.remoteAddress(), channel });
			closeChannelWithLoginFailure(channel);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		Channel channel = ctx.channel();
		LOG.error("Exception {} occurred during log in process, going to close channel {}", cause, channel);
		channel.close();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		AbstractNettyServer.ALL_CHANNELS.add(ctx.channel());
		LOG.debug("Added Channel {} as the {}th open channel", ctx.channel(), CHANNEL_COUNTER.incrementAndGet());
	}

	public Player lookupPlayer(final ByteBuf buffer, final Channel channel) {
		Credentials credentials = new SimpleCredentials(buffer);
		Player player = lookupService.playerLookup(credentials);
		if (null == player || null == credentials) {
			LOG.error("Invalid credentials provided by user: {}", credentials);
		}
		return player;
	}

	public Player lookupPlayer(Object id, String userName, String passWord) {
		Credentials credentials = new SimpleCredentials(id, userName, passWord);
		Player player = lookupService.playerLookup(credentials);
		if (null == player || null == credentials) {
			LOG.error("Invalid credentials provided by user: {}", credentials);
		}
		return player;
	}

	public PlayerSession lookupSession(final String reconnectKey) {
		PlayerSession playerSession = (PlayerSession) reconnectRegistry.getSession(reconnectKey);
		if (null != playerSession) {
			synchronized (playerSession) {
				// if its an already active session then do not allow a
				// reconnect. So the only state in which a client is allowed to
				// reconnect is if it is "NOT_CONNECTED"
				if (playerSession.getStatus() == Session.Status.NOT_CONNECTED) {
					playerSession.setStatus(Session.Status.CONNECTING);
				} else {
					playerSession = null;
				}
			}
		}
		return playerSession;
	}

	public boolean handleLogin(Player player, ChannelHandlerContext ctx) {
		if (null != player) {
			ctx.channel().writeAndFlush(NettyUtils.createBufferForOpcode(Events.LOG_IN_SUCCESS));
			return true;
		} else {
			// Write future and close channel
			closeChannelWithLoginFailure(ctx.channel());
			return false;
		}
	}

	protected void handleReconnect(PlayerSession playerSession, ChannelHandlerContext ctx, ByteBuf buffer) {
		if (null != playerSession) {
			ctx.write(NettyUtils.createBufferForOpcode(Events.LOG_IN_SUCCESS));
			GameRoom gameRoom = playerSession.getGameRoom();
			gameRoom.disconnectSession(playerSession);
			if (null != playerSession.getTcpSender())
				playerSession.getTcpSender().close();

			if (null != playerSession.getUdpSender())
				playerSession.getUdpSender().close();

			handleReJoin(playerSession, gameRoom, ctx.channel(), buffer);
		} else {
			// Write future and close channel
			closeChannelWithLoginFailure(ctx.channel());
		}
	}

	/**
	 * Helper method which will close the channel after writing
	 * {@link Events#LOG_IN_FAILURE} to remote connection.
	 * 
	 * @param channel
	 *            The tcp connection to remote machine that will be closed.
	 */
	private void closeChannelWithLoginFailure(Channel channel) {
		ChannelFuture future = channel.writeAndFlush(NettyUtils.createBufferForOpcode(Events.LOG_IN_FAILURE));
		future.addListener(ChannelFutureListener.CLOSE);
	}

	public void handleGameRoomJoin(Player player, ChannelHandlerContext ctx, ByteBuf buffer, String refKey, Object gameRoomKey, String group) {
		// String refKey = NettyUtils.readString(buffer);
		if (null == refKey) {
			return;
		}
		Channel channel = ctx.channel();

		Game game = lookupService.gameLookup(refKey);

		// String gameRoomName = NettyUtils.readString(buffer);
		//
		// if (null == gameRoomName) {
		// gameRoomName = refKey;
		// }
		GameRoom gameRoom = lookupService.gameRoomLookup(game, gameRoomKey);
		if (null != gameRoom) {
			PlayerSession playerSession = gameRoom.createPlayerSession(player);
			boolean isReconnect = false;
			if (isReconnect) {
				String reconnectKey = (String) idGeneratorService.generateFor(playerSession.getClass());
				playerSession.setAttribute(NadronConfig.RECONNECT_KEY, reconnectKey);
				playerSession.setAttribute(NadronConfig.RECONNECT_REGISTRY, reconnectRegistry);
			}
			// String group = NettyUtils.readString(buffer);
			if (null != group) {
				playerSession.setAttribute(NadronConfig.GROUP_REF_NAME, group);
			}
			// ByteBuf reconnectKeyBuffer =
			// Unpooled.wrappedBuffer(NettyUtils.createBufferForOpcode(Events.GAME_ROOM_JOIN_SUCCESS),
			// NettyUtils.writeString(reconnectKey));
			try {
				Thread.sleep(50L);
			} catch (Exception e) {
				LOG.warn("", e);
			}
			ChannelFuture future = channel.writeAndFlush(NettyUtils.createBufferForOpcode(Events.GAME_ROOM_JOIN_SUCCESS));
			LOG.debug("Sending GAME_ROOM_JOIN_SUCCESS to channel {}, result {}", channel, future);
			connectToGameRoom(gameRoom, playerSession, future);
			loginUdp(playerSession, buffer);
		} else {
			// Write failure and close channel.
			ChannelFuture future = channel.writeAndFlush(NettyUtils.createBufferForOpcode(Events.GAME_ROOM_JOIN_FAILURE));
			future.addListener(ChannelFutureListener.CLOSE);
			LOG.error("Invalid ref key provided by client: {}. room:{} ,Channel {} will be closed", new Object[] { refKey, gameRoom, channel });
		}
	}

	protected void handleReJoin(PlayerSession playerSession, GameRoom gameRoom, Channel channel, ByteBuf buffer) {
		LOG.trace("Going to clear pipeline");
		// Clear the existing pipeline
		NettyUtils.clearPipeline(channel.pipeline());
		// Set the tcp channel on the session.
		NettyTCPMessageSender sender = new NettyTCPMessageSender(channel);
		playerSession.setTcpSender(sender);
		// Connect the pipeline to the game room.
		gameRoom.connectSession(playerSession);
		playerSession.setWriteable(true);// TODO remove if unnecessary. It
											// should be done in start event
		// Send the re-connect event so that it will in turn send the START
		// event.
		playerSession.onEvent(new ReconnetEvent(sender));
		loginUdp(playerSession, buffer);
	}

	public void connectToGameRoom(final GameRoom gameRoom, final PlayerSession playerSession, ChannelFuture future) {
		future.addListener(new ChannelFutureListener() {
			@Override
			public void operationComplete(ChannelFuture future) throws Exception {
				Channel channel = future.channel();
				LOG.debug("Sending GAME_ROOM_JOIN_SUCCESS to channel {} completed", channel);
				if (future.isSuccess()) {
					LOG.debug("Going to clear pipeline");
					// Clear the existing pipeline
					NettyUtils.clearPipeline(channel.pipeline());
					// Set the tcp channel on the session.
					NettyTCPMessageSender tcpSender = new NettyTCPMessageSender(channel);
					playerSession.setTcpSender(tcpSender);
					// Connect the pipeline to the game room.
					gameRoom.connectSession(playerSession);
					// send the start event to remote client.
					// Object result = tcpSender.sendMessage(Events.event(null,
					// Events.START));
					try {
						Thread.sleep(50L);
					} catch (Exception e) {
						LOG.warn("", e);
					}
					Object result = future.channel().writeAndFlush(NettyUtils.createBufferForOpcode(Events.START));
					LOG.info("send start result: {}", result);
					gameRoom.onLogin(playerSession);
				} else {
					LOG.error("GAME_ROOM_JOIN_SUCCESS message sending to client was failure, channel will be closed");
					channel.close();
				}
			}
		});
	}

	/**
	 * This method adds the player session to the {@link SessionRegistryService}
	 * . The key being the remote udp address of the client and the session
	 * being the value.
	 * 
	 * @param playerSession
	 * @param buffer
	 *            Used to read the remote address of the client which is
	 *            attempting to connect via udp.
	 */
	protected void loginUdp(PlayerSession playerSession, ByteBuf buffer) {
		InetSocketAddress remoteAddress = NettyUtils.readSocketAddress(buffer);
		if (null != remoteAddress) {
			udpSessionRegistry.putSession(remoteAddress, playerSession);
		}
	}

	public LookupService getLookupService() {
		return lookupService;
	}

	public void setLookupService(LookupService lookupService) {
		this.lookupService = lookupService;
	}

	public UniqueIDGeneratorService getIdGeneratorService() {
		return idGeneratorService;
	}

	public void setIdGeneratorService(UniqueIDGeneratorService idGeneratorService) {
		this.idGeneratorService = idGeneratorService;
	}

	public SessionRegistryService<SocketAddress> getUdpSessionRegistry() {
		return udpSessionRegistry;
	}

	public void setUdpSessionRegistry(SessionRegistryService<SocketAddress> udpSessionRegistry) {
		this.udpSessionRegistry = udpSessionRegistry;
	}

	public ReconnectSessionRegistry getReconnectRegistry() {
		return reconnectRegistry;
	}

	public void setReconnectRegistry(ReconnectSessionRegistry reconnectRegistry) {
		this.reconnectRegistry = reconnectRegistry;
	}

	public int getLoginType() {
		return loginType;
	}

	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}

}
