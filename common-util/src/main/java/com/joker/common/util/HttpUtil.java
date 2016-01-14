package com.joker.common.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtil {

	/**
	 * HTTP GET 访问
	 * 
	 * @param url
	 *            访问地址
	 * @return
	 */
	public static String sendGet(String url) {
		return Get(url, "");
	}

	/**
	 * HTTP GET 访问
	 * 
	 * @param url
	 *            访问地址
	 * @param param
	 *            访问参数
	 * @return
	 */
	public static String Get(String url, String param) {
		StringBuffer result = new StringBuffer();
		if (StringUtil.hasText(param)) {
			url = url + "?" + param;
		}
		try {
			URL U = new URL(url);
			URLConnection connection = U.openConnection();
			connection.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
			in.close();
		} catch (FileNotFoundException e) {

		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println("没有结果！" + e);
		}
		return result.toString();
	}

	/**
	 * HTTP POST 访问
	 * 
	 * @param url
	 *            访问地址
	 * @return
	 */
	public static String sendPost(String url) {
		return Post(url, "");
	}

	/**
	 * HTTP POST 访问
	 * 
	 * @param url
	 *            访问地址
	 * @param param
	 *            访问参数
	 * @return
	 */
	public static String Post(String url, String param) {
		String result = "";
		try {
			URL httpurl = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) httpurl.openConnection();
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			PrintWriter out = new PrintWriter(httpConn.getOutputStream());
			out.print(param);
			out.flush();
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			in.close();
		} catch (FileNotFoundException e) {

		} catch (Exception e) {
			// System.out.println("没有结果！" + e);
		}
		return result;
	}

	/**
	 * to split out the SessionID from a Cookie String
	 * 
	 * @param cookie
	 * @return
	 */
	public static String getSessionIdFromCookie(String cookie) {
		int index_1 = cookie.indexOf("JSESSIONID=");
		int index_2 = cookie.indexOf(";");
		return cookie.substring(index_1, index_2);
	}

	/**
	 * just for the sake of debuging
	 * 
	 * @param stream
	 * @throws Exception
	 */
	public void printIoStream(InputStream stream) throws Exception {
		BufferedInputStream buff = new BufferedInputStream(stream);
		Reader r = new InputStreamReader(buff, "gbk");
		BufferedReader br = new BufferedReader(r);
		StringBuffer strHtml = new StringBuffer("");
		String strLine = null;
		while ((strLine = br.readLine()) != null) {
			strHtml.append(strLine + "\r\n");
		}
		System.out.print(strHtml.toString());
	}

	public static void addProperty(URLConnection connection) {
		connection
				.addRequestProperty("Accept",
						"image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, application/x-shockwave-flash, application/msword, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/x-silverlight, */*");
		connection.setRequestProperty("Referer", "https://9.186.10.56:8443/index.jsp");
		connection.setRequestProperty("Accept-Language", "zh-cn");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
		connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; Foxy/1; .NET CLR 2.0.50727;MEGAUPLOAD 1.0)");
		connection.setRequestProperty("Connection", "Keep-Alive");
		connection.setRequestProperty("Cache-Control", "no-cache");
	}
}
