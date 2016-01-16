package com.inkstd.badugi.game.common.constant;

public final class RedisKeys {
	/**
	 * 用户登陆服务器的映射<br/>
	 * 类型: HASH <br/>
	 * 使用: HSET user:login:mapping $playerId $sid@$channelId
	 */
	public static final String KEY_LOGIN_MAPPING = "user:login:mapping";
	/**
	 * 用户登陆服务器的映射<br/>
	 * 类型: HASH <br/>
	 * 使用: HSET user:login:proxy:%s $playerId $channelId
	 */
	public static final String KEY_LOGIN_PROXY = "user:login:proxy:%s";
	
	
	public static final String KEY_ROOMS = "rooms";
	public static final String KEY_ROOM_LEVEL = "roomlevel";
}
