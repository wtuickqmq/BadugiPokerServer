package io.nadron.handlers.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelPipeline;


/**
 * Applies a protocol to the incoming pipeline which will handle login.
 * Subsequent protocol may also be manipulated by these login handlers.
 * 
 * @author Abraham Menacherry
 * 
 */
public interface LoginProtocol
{
	String LOGIN_HANDLER_NAME = "loginHandler";
	/**
	 * Apply a protocol on the pipeline to handle login. Implementations will
	 * first "search" if the incoming bytes correspond to the implementations
	 * protocol, only if they match, the correspoinding protocol will be
	 * applied.
	 * 
	 * @param buffer
	 *            The incoming buffer, by default around 5 bytes will be read
	 *            and passed on to detect the protocol
	 * @param pipeline
	 *            The channelpipeline on which the login protocol handlers need
	 *            to be set.
	 * @return Returs true if the protocol was applied, else false.
	 */
	public boolean applyProtocol(ByteBuf buffer, ChannelPipeline pipeline);

}
