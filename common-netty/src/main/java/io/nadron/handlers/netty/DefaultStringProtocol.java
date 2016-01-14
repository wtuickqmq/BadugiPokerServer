package io.nadron.handlers.netty;

import io.nadron.event.Event;
import io.nadron.event.Events;
import io.nadron.util.NettyUtils;
import io.nadron.util.ObjectBeanUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.string.StringDecoder;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.List;

/**
 * This is the default protocol of nadron. If incoming event is of type LOG_IN
 * and also has appropriate protocol version as defined in the {@link Events}
 * class, then this protocol will be applied. The 3rd and 4th bytes of the
 * incoming transmission are searched to get this information.
 * 
 * @author Abraham Menacherry
 * 
 */
public class DefaultStringProtocol implements LoginProtocol {

	private StringLoginHandler stringLoginHandler;

	private LengthFieldPrepender lengthFieldPrepender;

	@Override
	public boolean applyProtocol(ByteBuf buffer, ChannelPipeline pipeline) {
		boolean isThisProtocol = false;

		byte[] values = NettyUtils.toByteArray(buffer, false);

		String val = new String(values);
		if (!"".equals(val)) {
			pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
			pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));

			pipeline.addLast("decode", new StringDecoder());
			pipeline.addLast(LOGIN_HANDLER_NAME, stringLoginHandler);
			// pipeline.addLast("encode", new StringEncoder());
			pipeline.addLast("StringEventEncoder", new EventStringEncoder());
			pipeline.addLast("lengthFieldPrepender", lengthFieldPrepender);
			isThisProtocol = true;
		}
		return isThisProtocol;
	}

	public StringLoginHandler getStringLoginHandler() {
		return stringLoginHandler;
	}

	public void setStringLoginHandler(StringLoginHandler stringLoginHandler) {
		this.stringLoginHandler = stringLoginHandler;
	}

	public LengthFieldPrepender getLengthFieldPrepender() {
		return lengthFieldPrepender;
	}

	public void setLengthFieldPrepender(LengthFieldPrepender lengthFieldPrepender) {
		this.lengthFieldPrepender = lengthFieldPrepender;
	}

	@Sharable
	public static class EventStringEncoder extends MessageToMessageEncoder<Object> {

		@Override
		protected void encode(ChannelHandlerContext ctx, Object msg, List<Object> out) throws Exception {
			if (msg instanceof String) {
				String text = (String) msg;
				if (text.length() == 0) {
					return;
				}

				out.add(ByteBufUtil.encodeString(ctx.alloc(), CharBuffer.wrap(text), Charset.defaultCharset()));
			} else if (msg instanceof Event) {
				Event eventObject = (Event) msg;
				String text = ObjectBeanUtil.JACKSON.writeValueAsString(eventObject);
				if (text.length() == 0) {
					return;
				}

				out.add(ByteBufUtil.encodeString(ctx.alloc(), CharBuffer.wrap(text), Charset.defaultCharset()));
			}

		}

	}

}