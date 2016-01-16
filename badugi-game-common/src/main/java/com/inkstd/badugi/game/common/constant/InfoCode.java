package com.inkstd.badugi.game.common.constant;

/**
 * 状态码
 */
public final class InfoCode {
	/**
	 * 成功状态码.
	 */
	public static final int SUCCESS = 1;
	/**
	 * 失败状态码.
	 */
	public static final int NONE = 0;
	/**
	 * 数据库读取异常.
	 */
	public static final int EXCEPTION_DB_READ = 400;
	/**
	 * 数据库写入异常.
	 */
	public static final int EXCEPTION_DB_WRITE = 401;

	/**
	 * 客户端版本不一致
	 */
	public static final int VERSION_DOWNLOAD = 9999;
	/**
	 * 您操作太快,歇会儿再继续吧
	 */
	public static final int SERVER_BUSYNESS = 10000;
}
