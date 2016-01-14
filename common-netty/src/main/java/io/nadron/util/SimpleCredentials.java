package io.nadron.util;

import io.netty.buffer.ByteBuf;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class SimpleCredentials implements Credentials {

	private Object id;
	private String username;
	private String password;

	public SimpleCredentials(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public SimpleCredentials(Object id, String username, String password) {
		this(username, password);
		this.id = id;
	}

	public SimpleCredentials(final ByteBuf buffer) {
		this.username = NettyUtils.readString(buffer);
		this.id = NettyUtils.readString(buffer);
	}

	public static Object ByteToObject(byte[] bytes) {
		Object obj = null;
		try {
			// bytearray to object
			ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
			ObjectInputStream oi = new ObjectInputStream(bi);

			obj = oi.readObject();
			bi.close();
			oi.close();
		} catch (Exception e) {
			System.out.println("translation" + e.getMessage());
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return username;
	}

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

}
