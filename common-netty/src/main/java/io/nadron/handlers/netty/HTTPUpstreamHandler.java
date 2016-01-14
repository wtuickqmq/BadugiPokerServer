package io.nadron.handlers.netty;

import static io.netty.handler.codec.http.HttpHeaders.is100ContinueExpected;
import static io.netty.handler.codec.http.HttpHeaders.isKeepAlive;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import io.nadron.app.GameRoom;
import io.nadron.common.http.Request;
import io.nadron.common.http.route.RouteMapping;
import io.nadron.common.http.route.RouteResolver;
import io.nadron.event.HttpChannelEvent;
import io.nadron.service.LookupService;
import io.nadron.util.NadronConfig;
import io.nadron.util.NettyUtils;
import io.nadron.util.ObjectBeanUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders.Values;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.util.CharsetUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.joker.common.util.StringUtil;

public class HTTPUpstreamHandler extends ChannelInboundHandlerAdapter {
	private static final Logger LOG = LoggerFactory.getLogger(HTTPUpstreamHandler.class);

	private static final ByteBuf CONTENT = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("404", CharsetUtil.UTF_8));

	private LookupService lookupService;

	public HTTPUpstreamHandler(LookupService lookupService) {
		this.lookupService = lookupService;
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (msg instanceof HttpRequest) {
			HttpRequest req = (HttpRequest) msg;

			if (is100ContinueExpected(req)) {
				ctx.write(new DefaultFullHttpResponse(HTTP_1_1, HttpResponseStatus.CONTINUE));
			}
			boolean keepAlive = isKeepAlive(req);

			Request request = new Request(req, new RouteResolver(new RouteMapping()));
			
			if("/favicon.ico".equals(request.getUrl()) ) return;
			Object result = StringUtil.EMPTY_STRING;
			String contentType = "text/html;charset=utf-8";
			if (request.getQueryStringMap() != null && request.getQueryStringMap().containsKey(NadronConfig.ROOM_REF_NAME)) {
				GameRoom gameRoom = lookupService.gameRoomLookup(request.getQueryStringMap().get(NadronConfig.ROOM_REF_NAME));
				if (gameRoom != null) {
					LOG.debug("send message to room {} onHTTPRequest", request.getQueryStringMap().get(NadronConfig.ROOM_REF_NAME));
					if (gameRoom instanceof HttpChannelEvent) {
						((HttpChannelEvent) gameRoom).doRequest(ctx.channel(), request);
						return;
					} else {
						// result = gameRoom.onHTTPRequest(ctx.channel(),
						// request.getQueryStringMap(),
						// request.getHeader(COOKIE));
						Object value = gameRoom.onHTTPRequest(request);
						if (null != value) {
							result = ObjectBeanUtil.JACKSON.writeValueAsString(value);
							contentType = "text/plain;charset=utf-8";
						}
					}
				} else {
					LOG.warn("not found area id from {}", request.getQueryStringMap().get(NadronConfig.ROOM_REF_NAME));
				}
			} else {
				// 获取html所存放的路径
				String htdocs = System.getProperty("wwwroot.path", "html");
				String path = request.getPath();
				File file = new File(htdocs + "/" + path);
				String url = request.getUrl();
				if (file.exists() && file.length() > 0 && !file.isDirectory()) {
					byte[] b = null;
					FileInputStream fis = null;
					ByteArrayOutputStream ops = null;
					int fileLength = (int) file.length();
					try {
						fis = new FileInputStream(file);
						ops = new ByteArrayOutputStream(fileLength);
						byte[] temp = new byte[fileLength];
						int n;
						while ((n = fis.read(temp)) != -1) {
							ops.write(temp, 0, n);
						}
						b = ops.toByteArray();
						String fileName = file.getName();
						result = b;
						if (fileName.endsWith(".html") || fileName.indexOf(".") == -1) {
							result = new String(b);
							contentType = "text/html";
						} else if (fileName.endsWith("jpg") || fileName.endsWith("jpeg"))
							contentType = "image/jpeg";
						else if (fileName.endsWith("gif"))
							contentType = "image/gif";
						else if (fileName.endsWith("png"))
							contentType = "image/png";
						else if (fileName.endsWith("zip"))
							contentType = "application/zip";
						else if (fileName.endsWith("pdf"))
							contentType = "application/pdf";
						else if (fileName.endsWith("doc"))
							contentType = "application/msword";
						else if (fileName.endsWith("xls"))
							contentType = "application/vnd.ms-excel";
						else if (fileName.endsWith("ppt"))
							contentType = "application/vnd.ms-powerpoint";
						else if (fileName.endsWith("json")) {
							contentType = "text/json";
							result = new String(b);
						} else if (fileName.endsWith("txt")) {
							contentType = "text/plain";
							result = new String(b);
						} else if (fileName.endsWith("css")) {
							contentType = "text/css";
							result = new String(b);
						} else if (fileName.endsWith("js")) {
							contentType = "text/javascript";
							result = new String(b);
						} else
							contentType = "application/octet-stream";

					} catch (Exception e) {
						LOG.error("", e);
					} finally {
						if (null != ops) {
							ops.close();
						}
						if (null != fis) {
							fis.close();
						}
					}
				} else {
					LOG.info("http request path {} is miss", url);
				}
			}
			FullHttpResponse response = null;
			if (result instanceof String) {
				String value = (String) result;
				if (StringUtil.hasText(value)) {
					response = NettyUtils.writeHttpResponse(contentType, Unpooled.unreleasableBuffer(Unpooled.copiedBuffer((String) result, CharsetUtil.UTF_8)), HttpResponseStatus.OK);
				} else {
					response = NettyUtils.writeHttpResponse(contentType, CONTENT.duplicate(), HttpResponseStatus.NOT_FOUND);
				}
			} else if (result instanceof byte[]) {
				byte[] value = (byte[]) result;
				response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(value));
			}
			// response = NettyUtil.writeHttpResponse(contentType,
			// Unpooled.unreleasableBuffer(Unpooled.copiedBuffer(result,
			// CharsetUtil.UTF_8)), HttpResponseStatus.OK);
			else {
				response = NettyUtils.writeHttpResponse(contentType, CONTENT.duplicate(), HttpResponseStatus.BAD_REQUEST);
			}

			if (!keepAlive) {
				ctx.write(response).addListener(ChannelFutureListener.CLOSE);
			} else {
				response.headers().set(CONNECTION, Values.KEEP_ALIVE);
				ctx.write(response);
			}
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		LOG.error("remote ip={}", ctx.channel().remoteAddress());
		LOG.error("", cause);
		ctx.write(new DefaultFullHttpResponse(HTTP_1_1, HttpResponseStatus.FORBIDDEN)).addListener(ChannelFutureListener.CLOSE);
	}
}
