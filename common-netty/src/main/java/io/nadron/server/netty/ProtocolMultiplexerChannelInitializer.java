package io.nadron.server.netty;

import io.nadron.handlers.netty.LoginProtocol;
import io.nadron.handlers.netty.ProtocolMultiplexerDecoder;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;


public class ProtocolMultiplexerChannelInitializer extends
	ChannelInitializer<SocketChannel>
{
	// TODO make this configurable from spring.
	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProtocolMultiplexerChannelInitializer.class);

	private int idleStateCheck = 60;
	private int bytesForProtocolCheck;
	private LoginProtocol loginProtocol;
	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception 
	{
		// Create a default pipeline implementation.
		LOGGER.info("网络事件添加");
		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast("idleStateCheck", new IdleStateHandler(
				idleStateCheck, idleStateCheck, idleStateCheck));
		pipeline.addLast("multiplexer", createProtcolMultiplexerDecoder());
	}

	protected ChannelHandler createProtcolMultiplexerDecoder()
	{
		return new ProtocolMultiplexerDecoder(bytesForProtocolCheck, loginProtocol);
	}

	public int getBytesForProtocolCheck()
	{
		return bytesForProtocolCheck;
	}

	public void setBytesForProtocolCheck(int bytesForProtocolCheck)
	{
		this.bytesForProtocolCheck = bytesForProtocolCheck;
	}

	public LoginProtocol getLoginProtocol()
	{
		return loginProtocol;
	}

	public void setLoginProtocol(LoginProtocol loginProtocol)
	{
		this.loginProtocol = loginProtocol;
	}

	public int getIdleStateCheck() {
		return idleStateCheck;
	}

	public void setIdleStateCheck(int idleStateCheck) {
		this.idleStateCheck = idleStateCheck;
	}
	
	

}
