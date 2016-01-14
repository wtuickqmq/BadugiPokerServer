package io.nadron.handlers.netty;

import static io.nadron.event.Events.LOG_IN;
import static io.nadron.event.Events.PROTCOL_VERSION;
import static io.nadron.event.Events.RECONNECT;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.nadron.event.Events;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

/**
 * This is the default protocol of nadron. If incoming event is of type LOG_IN
 * and also has appropriate protocol version as defined in the {@link Events}
 * class, then this protocol will be applied. The 3rd and 4th bytes of the
 * incoming transmission are searched to get this information.
 * 
 * @author Abraham Menacherry
 * 
 */
public class DefaultNadProtocol implements LoginProtocol {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultNadProtocol.class);

	private int frameSize = 1024;
	private EventDecoder eventDecoder;
	private EventEncoder eventEncoder;
	private LoginHandler loginHandler;
	private LengthFieldPrepender lengthFieldPrepender;

	@Override
	public boolean applyProtocol(ByteBuf buffer, ChannelPipeline pipeline) {
		boolean isThisProtocol = false;
		int size = buffer.readableBytes();
		byte[] newb = new byte[size];
		buffer.copy().readBytes(newb);
		LOGGER.trace("{}", newb);
		
		final int opcode = buffer.getUnsignedByte(buffer.readerIndex() + 2);
		final int protocolVersion = buffer.getUnsignedByte(buffer.readerIndex() + 3);
		if (isNadProtocol(opcode, protocolVersion)) {
			pipeline.addLast("framer", createLengthBasedFrameDecoder());
			pipeline.addLast("eventDecoder", eventDecoder);
			pipeline.addLast(LOGIN_HANDLER_NAME, loginHandler);
			pipeline.addLast("lengthFieldPrepender", lengthFieldPrepender);
			pipeline.addLast("eventEncoder", eventEncoder);
			isThisProtocol = true;
		}
		return isThisProtocol;
	}

	protected boolean isNadProtocol(int magic1, int magic2) {
		return ((magic1 == LOG_IN ||magic1==Events.LOG_IN_WITH_JSON|| magic1 == RECONNECT) && magic2 == PROTCOL_VERSION);
	}

	public ChannelHandler createLengthBasedFrameDecoder() {
		return new LengthFieldBasedFrameDecoder(frameSize, 0, 2, 0, 2);
	}

	public int getFrameSize() {
		return frameSize;
	}

	public void setFrameSize(int frameSize) {
		this.frameSize = frameSize;
	}

	public EventDecoder getEventDecoder() {
		return eventDecoder;
	}
	

	public void setEventDecoder(EventDecoder eventDecoder) {
		this.eventDecoder = eventDecoder;
	}
	

	public EventEncoder getEventEncoder() {
		return eventEncoder;
	}

	public void setEventEncoder(EventEncoder eventEncoder) {
		this.eventEncoder = eventEncoder;
	}

	public LoginHandler getLoginHandler() {
		return loginHandler;
	}

	public void setLoginHandler(LoginHandler loginHandler) {
		this.loginHandler = loginHandler;
	}

	public LengthFieldPrepender getLengthFieldPrepender() {
		return lengthFieldPrepender;
	}

	public void setLengthFieldPrepender(LengthFieldPrepender lengthFieldPrepender) {
		this.lengthFieldPrepender = lengthFieldPrepender;
	}
}