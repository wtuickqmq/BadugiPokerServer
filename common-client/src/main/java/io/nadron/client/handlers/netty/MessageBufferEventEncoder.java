package io.nadron.client.handlers.netty;

import io.nadron.client.communication.MessageBuffer;
import io.nadron.client.communication.NettyMessageBuffer;
import io.nadron.client.event.Event;
import io.nadron.client.event.Events;
import io.nadron.client.util.ObjectBeanUtil;
import io.nadron.client.util.NettyUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.io.IOException;
import java.util.List;

/**
 * Converts an incoming {@link Event} which in turn has a
 * IMessageBuffer<ByteBuf> payload to a Netty {@link ByteBuf}. <b>Note that
 * {@link Event} instances containing other type of objects as its payload will
 * result in {@link ClassCastException}.
 * 
 * @author Abraham Menacherry.
 * 
 */
// TODO check if MessageToMessageEncoder can be replaced with
// MessageToByteEncoder
@Sharable
public class MessageBufferEventEncoder extends MessageToMessageEncoder<Event> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Event event, List<Object> out) throws Exception {
		out.add(encode(ctx, event));
	}

	/**
	 * Encode is separated out so that child classes can still reuse this
	 * functionality.
	 * 
	 * @param ctx
	 * @param event
	 *            The event to be encoded into {@link ByteBuf}. It will be
	 *            converted to 'opcode'-'payload' format.
	 * @return If only opcode is specified a single byte {@link ByteBuf} is
	 *         returned, otherwise a byte buf with 'opcode'-'payload' format is
	 *         returned.
	 */
	protected ByteBuf encode(ChannelHandlerContext ctx, Event event) {
		ByteBuf out = ctx.alloc().buffer();
		out.writeByte(event.getType());
		if (Events.LOG_IN == event.getType() ||Events.LOG_IN_WITH_JSON == event.getType()  || Events.RECONNECT == event.getType()) {
			// write protocol version also
			out.writeByte(Events.PROTOCOL_VERSION);
		}

		if (null != event.getSource()) {
			// @SuppressWarnings("unchecked")
			Object source = event.getSource();
			NettyMessageBuffer buffer = null;
			if (source instanceof NettyMessageBuffer) {
				buffer = (NettyMessageBuffer) source;
			} else if (source instanceof String) {
				buffer = new NettyMessageBuffer(NettyUtils.writeString((String) source));
			} else {
				String str = null;
				try {
					str = ObjectBeanUtil.JACKSON.writeValueAsString(source);
				} catch (IOException e) {
					e.printStackTrace();
				}
				buffer = new io.nadron.client.communication.NettyMessageBuffer(NettyUtils.writeString(str));
			}
			MessageBuffer<ByteBuf> msgBuffer = (MessageBuffer<ByteBuf>) buffer;
			ByteBuf data = msgBuffer.getNativeBuffer();
			out.writeBytes(data);
			data.release();
		}
		return out;
	}
}
