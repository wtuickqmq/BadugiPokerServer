package com.badugi.game.logic.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class HttpClientUtil {
//	private static final Log log = LogFactory.getLog(HttpClientUtil.class);
	private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);

	private static HttpClient customerHttpClient;
	private static final String CHARSET = "utf-8";
	private static final int TIME_OUT = 30000;
	
	private static final String USER_AGENT_MOZILLA = "Mozilla/5.0(Linux;U;Android 2.2.1;en-us;" + "Nexus One Build.FRG83) AppleWebKit/553.1(KHTML,like Gecko) Version/4.0 Mobile Safari/533.1";

	/**
	 * Http Gat url
	 * 
	 * @param url
	 *            请求 Url 地址
	 * @return
	 * @throws Exception
	 */
	public static String Get(String url) throws Exception {
		return Get(url, false);
	}

	/**
	 * Http Gat url
	 * 
	 * @param url
	 *            请求 Url 地址
	 * @param secret
	 *            是否使用SSL
	 * @return
	 * @throws Exception
	 */
	public static String Get(String url, boolean secret) throws Exception {
		
		HttpClient httpClient = new DefaultHttpClient();
		httpClient.getParams().setParameter(HttpProtocolParams.HTTP_CONTENT_CHARSET, CHARSET);
		httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,TIME_OUT);
		httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,TIME_OUT);
		try {
			HttpGet request = new HttpGet(url);
			if (secret && request.getURI().toURL().getProtocol().equals("https")) {
				TrustManager easyTrustManager = new X509TrustManager() {
					public void checkClientTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws java.security.cert.CertificateException {
					}

					public void checkServerTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws java.security.cert.CertificateException {
					}

					public java.security.cert.X509Certificate[] getAcceptedIssuers() {
						return new java.security.cert.X509Certificate[0];
					}
				};
				SSLContext sslcontext = SSLContext.getInstance("TLS");
				sslcontext.init(null, new TrustManager[] { easyTrustManager }, null);
				SSLSocketFactory sf = new SSLSocketFactory(sslcontext);

				Scheme sch = new Scheme("https", 443, sf);

				httpClient.getConnectionManager().getSchemeRegistry().register(sch);
			}
			// httpClient = getHttpClient();
			HttpResponse response = httpClient.execute(request);
//			response.getParams().setParameter(HttpProtocolParams.HTTP_CONTENT_CHARSET, CHARSET);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				LOGGER.warn("Server Error, response : " + response.getStatusLine());
			}
			HttpEntity entity = response.getEntity();
			if (entity != null) {
//				return EntityUtils.toString(entity);
				String rtn = EntityUtils.toString(entity);
						
				//判断当前字符串的编码格式
				if(rtn.equals(new String(rtn.getBytes("iso8859-1"), "iso8859-1")))
				{
					rtn = new String(rtn.getBytes("iso8859-1"),CHARSET);
				}
				return rtn; 
			}
			return new BasicResponseHandler().handleResponse(response);
		} catch (UnsupportedEncodingException e) {
			LOGGER.warn(e.getMessage());
			return null;
		} catch (ClientProtocolException e) {
			LOGGER.warn(e.getMessage());
			return null;
		} catch (IOException e) {
			throw e;
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}

	/**
	 * 
	 * @param url
	 * @param formparams
	 * @return
	 * @throws Exception
	 */
	public static String Post(String url, List<NameValuePair> formparams) throws Exception {
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, CHARSET);// 编码参数
			return Post(url, entity);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * @param url
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String Post(String url, String data) throws Exception {
		try {
			StringEntity entity = new StringEntity(data, CHARSET);
			return Post(url, entity);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * @param url
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public static String Post(String url, HttpEntity entity) throws Exception {
		try {
			HttpPost request = new HttpPost(url);// 创建POST请求
			request.setEntity(entity);// 发送请求
			HttpResponse response = getHttpClient().execute(request);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				throw new RuntimeException("Server Error, response : " + response.getStatusLine());
			}
			HttpEntity resEntity = response.getEntity();
			return (resEntity == null) ? null : EntityUtils.toString(resEntity, CHARSET);
		} catch (UnsupportedEncodingException e) {
			LOGGER.warn(e.getMessage());
			return null;
		} catch (ClientProtocolException e) {
			LOGGER.warn(e.getMessage());
			return null;
		} catch (IOException e) {
			throw new RuntimeException("连接失败", e);
		}
	}

	/**
	 * 
	 * @param url
	 * @param formparams
	 * @return
	 * @throws Exception
	 */
	public static String Put(String url, List<NameValuePair> formparams) throws Exception {
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, CHARSET);// 编码参数

			HttpPut request = new HttpPut(url);// 创建POST请求
			request.setEntity(entity);// 发送请求

			HttpClient client = getHttpClient();
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				throw new RuntimeException("Server Error, response : " + response.getStatusLine());
			}
			HttpEntity resEntity = response.getEntity();
			return (resEntity == null) ? null : EntityUtils.toString(resEntity, CHARSET);
		} catch (UnsupportedEncodingException e) {
			LOGGER.warn(e.getMessage());
			return null;
		} catch (ClientProtocolException e) {
			LOGGER.warn(e.getMessage());
			return null;
		} catch (IOException e) {
			throw new RuntimeException("连接失败", e);
		}
	}

	/**
	 * 
	 * @param url
	 * @throws Exception
	 */
	public static String Delete(String url) throws Exception {
		try {
			HttpDelete request = new HttpDelete(url);
			HttpResponse response = getHttpClient().execute(request);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				throw new RuntimeException("Server Error, response : " + response.getStatusLine());
			}
			return new BasicResponseHandler().handleResponse(response);
		} catch (UnsupportedEncodingException e) {
			LOGGER.warn(e.getMessage());
			return null;
		} catch (ClientProtocolException e) {
			LOGGER.warn(e.getMessage());
			return null;
		} catch (IOException e) {
			throw new RuntimeException("连接失败", e);
		}
	}

	/**
	 * init http client
	 * 
	 * @return
	 */
	public static synchronized HttpClient getHttpClient() {
		if (null == customerHttpClient) {
			HttpParams params = new BasicHttpParams();
			HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
			HttpProtocolParams.setContentCharset(params, CHARSET);
			HttpProtocolParams.setUseExpectContinue(params, true);
			HttpProtocolParams.setUserAgent(params, USER_AGENT_MOZILLA);
			HttpConnectionParams.setConnectionTimeout(params, 5000); // 连接超时
			HttpConnectionParams.setSoTimeout(params, 150000); // 请求超时
			SchemeRegistry schReg = new SchemeRegistry(); // 设置我HttpClient支持HTTP和HTTPS两种模式
			schReg.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
			schReg.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));
			// 使用线程安全的连接管理来创建HttpClient, 可设置连接池超时
			ClientConnectionManager connectionManager = new PoolingClientConnectionManager(schReg);
			customerHttpClient = new DefaultHttpClient(connectionManager, params);
			customerHttpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,TIME_OUT);
			customerHttpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,TIME_OUT);
			customerHttpClient.getParams().setParameter(HttpProtocolParams.HTTP_CONTENT_CHARSET, CHARSET);
			
//			customerHttpClient.getParams().setParameter(
//					HttpProtocolParams.USER_AGENT,
//				    "JUC (Linux; U; 2.3.7; zh-cn; MB200; 320*480) UCWEB7.9.3.103/139/999");
		}
		return customerHttpClient;
	}
}
