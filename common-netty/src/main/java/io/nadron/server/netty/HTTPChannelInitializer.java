package io.nadron.server.netty;

import io.nadron.handlers.netty.HTTPUpstreamHandler;
import io.nadron.service.LookupService;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpServerCodec;

public class HTTPChannelInitializer extends ChannelInitializer<SocketChannel> {

	private ChannelHandler channelHandler;
	private LookupService lookupService;

	@Override
	public void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline p = ch.pipeline();

		// Uncomment the following line if you want HTTPS
		// SSLEngine engine =
		// SecureChatSslContextFactory.getServerContext().createSSLEngine();
		// engine.setUseClientMode(false);
		// p.addLast("ssl", new SslHandler(engine));

		p.addLast("codec", new HttpServerCodec());

		/*
		 * 压缩 Compresses an HttpMessage and an HttpContent in gzip or deflate
		 * encoding while respecting the "Accept-Encoding" header. If there is
		 * no matching encoding, no compression is done.
		 */
		p.addLast("deflater", new HttpContentCompressor());

		p.addLast("handler", getChannelHandler());
	}

	public ChannelHandler getChannelHandler() {
		if (this.channelHandler == null)
			return new HTTPUpstreamHandler(lookupService);
		return this.channelHandler;
	}

	public void setChannelHandler(ChannelHandler channelHandler) {
		this.channelHandler = channelHandler;
	}

	/**
	 * @return the lookupService
	 */
	public LookupService getLookupService() {
		return lookupService;
	}

	/**
	 * @param lookupService
	 *            the lookupService to set
	 */
	public void setLookupService(LookupService lookupService) {
		this.lookupService = lookupService;
	}
}
