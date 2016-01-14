package io.nadron.handlers.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtobufLoginProtocol implements LoginProtocol {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProtobufLoginProtocol.class);
	
	private ProtobufDecoder protobufDecoder;
	private ProtobufEncoder protobufEncoder;
	private ChannelInboundHandler channelInboundHandler;
	private ProtobufVarint32LengthFieldPrepender protobufVarint32LengthFieldPrepender;

	@Override
	public boolean applyProtocol(ByteBuf object, ChannelPipeline pipeline) {
		boolean isThisProtocol = false;
		if(object instanceof ByteBuf) {
			try {
				ByteBuf buffer = (ByteBuf) object;
				StringBuffer sBuffer = new StringBuffer();
				for (int i = 0; i < 20; i++) {
					sBuffer.append(Character.toChars(buffer
							.getUnsignedByte(buffer.readerIndex() + i)));
				}
				//if(isProtobuf(_P, _r, _o, _t)) {
				if (isProtobuf(sBuffer.toString())) {
					pipeline.addLast("frameDecoder",
							new ProtobufVarint32FrameDecoder());
					pipeline.addLast("protobufDecoder", protobufDecoder);
					pipeline.addLast("handler", channelInboundHandler);
					pipeline.addLast("frameEncoder",
							protobufVarint32LengthFieldPrepender);
					pipeline.addLast("protobufEncoder", protobufEncoder);
					isThisProtocol = true;
				}
			} catch (Exception e) {
				LOGGER.error("",e);
			}
		}
		return isThisProtocol;
	}
	
	private boolean isProtobuf(String potocolsTag) {
		return potocolsTag.contains("Proto"); // CONNECT
	}
	
	/**
	 * @return the protobufVarint32LengthFieldPrepender
	 */
	public ProtobufVarint32LengthFieldPrepender getProtobufVarint32LengthFieldPrepender() {
		return protobufVarint32LengthFieldPrepender;
	}

	/**
	 * @param protobufVarint32LengthFieldPrepender the protobufVarint32LengthFieldPrepender to set
	 */
	public void setProtobufVarint32LengthFieldPrepender(
			ProtobufVarint32LengthFieldPrepender protobufVarint32LengthFieldPrepender) {
		this.protobufVarint32LengthFieldPrepender = protobufVarint32LengthFieldPrepender;
	}
	
	/**
	 * @return the protobufEncoder
	 */
	public ProtobufEncoder getProtobufEncoder() {
		return protobufEncoder;
	}

	/**
	 * @param protobufEncoder the protobufEncoder to set
	 */
	public void setProtobufEncoder(ProtobufEncoder protobufEncoder) {
		this.protobufEncoder = protobufEncoder;
	}

	/**
	 * @return the channelInboundHandler
	 */
	public ChannelInboundHandler getChannelInboundHandler() {
		return channelInboundHandler;
	}

	/**
	 * @param channelInboundHandler the channelInboundHandler to set
	 */
	public void setChannelInboundHandler(ChannelInboundHandler channelInboundHandler) {
		this.channelInboundHandler = channelInboundHandler;
	}

	/**
	 * @return the protobufDecoder
	 */
	public ProtobufDecoder getProtobufDecoder() {
		return protobufDecoder;
	}

	/**
	 * @param protobufDecoder the protobufDecoder to set
	 */
	public void setProtobufDecoder(ProtobufDecoder protobufDecoder) {
		this.protobufDecoder = protobufDecoder;
	}
}
