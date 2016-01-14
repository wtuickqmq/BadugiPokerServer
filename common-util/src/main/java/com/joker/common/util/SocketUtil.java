package com.joker.common.util;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;

public final class SocketUtil {

	/**
	 * @return 是否可以连接主机端口
	 */
	public static boolean isStart(String host, int port) {
		return isStart1(host, port);
	}

	/**
	 * 普通堵塞连接
	 * 
	 * @author lion
	 * @param host
	 *            主机
	 * @param port
	 *            端口
	 * @return 是否可以连接主机端口
	 */
	public static boolean isStart0(String host, int port) {
		boolean status = false;
		Socket socket = null;
		try {
			socket = new Socket(host, port);
			status = true;
			socket.close();
		} catch (Exception e) {
		} finally {
		}
		return status;
	}

	/**
	 * 设置超时连接
	 * 
	 * @author lion
	 * @param host
	 *            主机
	 * @param port
	 *            端口
	 * @return 是否可以连接主机端口
	 */
	public static boolean isStart1(String host, int port) {
		boolean status = false;
		InetAddress addr = null;
		Socket socket = new Socket();
		try {
			addr = InetAddress.getByName(host);
			socket.connect(new InetSocketAddress(addr, port), 100);
			status = true;
			socket.close();
		} catch (Exception e) {
		} finally {
		}
		return status;
	}

	/**
	 * nio socket连接
	 * 
	 * @author lion
	 * @param host
	 *            主机
	 * @param port
	 *            端口
	 * @return 是否可以连接主机端口
	 */
	public static boolean isStart2(String host, int port) {
		boolean status = false;
		SocketChannel socketChannel = null;
		try {
			socketChannel = SocketChannel.open();
			SocketAddress socketAddress = new InetSocketAddress(host, port);
			socketChannel.connect(socketAddress);
			socketChannel.close();
		} catch (Exception e) {
		} finally {
		}
		return status;
	}
}
