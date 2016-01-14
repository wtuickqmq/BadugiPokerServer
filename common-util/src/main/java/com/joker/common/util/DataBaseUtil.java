package com.joker.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataBaseUtil {

	/**
	 * 获得与数据库的连接
	 * 
	 * @param path
	 * @return Connection
	 */
	public static Connection getConn(String classDriver, String url, String user, String pwd) {
		try {
			Class.forName(classDriver);
			return DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static Connection getConn(DataSource dataSource) {
		try {
			return dataSource.getConnection();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static Connection getConn(String jndiName) {
		try {
			Context ctx;
			ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/" + jndiName);
			return dataSource.getConnection();
		} catch (NamingException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static Connection getConn(Properties properties) {
		try {
			String driver = properties.getProperty("jdbc.driverClassName");
			String url = properties.getProperty("jdbc.url");
			String user = properties.getProperty("jdbc.username");
			String password = properties.getProperty("jdbc.password");
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * oracle连接
	 * 
	 * @param path
	 * @return Connection
	 */
	public static Connection getOracleConn(String url, String user, String pwd) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * mysql连接
	 * 
	 * @param path
	 * @return Connection
	 */
	public static Connection getMysqlConn(String url, String user, String pwd) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * Access连接
	 * 
	 * @param path
	 * @return Connection
	 */
	public static Connection getAccessConn(String path) {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:Driver={MicroSoft Access Driver (*.mdb)};DBQ=" + path;
			return DriverManager.getConnection(url, "", "");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static void close(Object... objects) {
		try {
			for (Object object : objects) {
				if (object != null) {
					if (object instanceof ResultSet) {
						ResultSet rs = (ResultSet) object;
						rs.close();
					} else if (object instanceof Statement) {
						Statement stmt = (Statement) object;
						stmt.close();
					} else if (object instanceof Connection) {
						Connection conn = (Connection) object;
						conn.close();
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}