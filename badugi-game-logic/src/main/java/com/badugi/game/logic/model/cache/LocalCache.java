package com.badugi.game.logic.model.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.badugi.game.logic.model.domain.vo.flash.operators.GameBeginVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.GameLogVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.RoomLevels;
import com.badugi.game.logic.model.domain.vo.flash.user.PlayerInfoInRoom;
import com.badugi.game.logic.model.domain.vo.flash.user.UserFundInfoVo;
import com.badugi.game.logic.model.domain.vo.flash.user.UserInRoom;
import com.badugi.game.logic.model.domain.vo.game.RoomGroupVo;
import com.badugi.game.logic.model.domain.vo.game.Rooms;
import com.badugi.game.logic.model.redis.RedisMapList;
import com.badugi.game.logic.model.redis.RedisMapMap;
import com.badugi.game.logic.model.redis.RedisMapSimple;
import com.joker.game.db.redis.RedisLogin;
import com.joker.game.db.util.SpringUtils;

/**
 * @author wtu.edit
 * @date 2015年9月18日
 * @version qq1.0
 * @email wtuickqmq@163.com
 */
public final class LocalCache {
	/**
	 * 用户基本信息缓存前缀 
	 */
	public static final String USER_INFO_CECHED_PRDFIX = "user.info.";
	
	/**
	 * 用户金额信息缓存前缀 
	 */
	public static final String USER_FUND_CECHED_PRDFIX = "user.fund.";
	
	/**
	 * 用户统计信息缓存前缀 
	 */
	public static final String USER_VIP_CECHED_PRDFIX = "user.vip.";
	
	/**
	 * 用户统计信息缓存前缀 
	 */
	public static final String USER_COUNT_CECHED_PRDFIX = "user.count.";


	public static final List<RoomGroupVo> ROOM_GROUPS=new ArrayList<RoomGroupVo>();
	/***
	 * 房间信息缓存
	 */
	public static final Map<String, Rooms> ROOMS = new ConcurrentHashMap<String, Rooms>();
	/***
	 * 等级信息缓存
	 */
	public static final Map<Integer, RoomLevels> ROOM_LEVELS = new HashMap<Integer, RoomLevels>();

	/**
	 * 用户账户信息 Long fbid
	 */
	// public static final Map<Long,UserFundInfoVo> USER_FUNDS = new
	// ConcurrentHashMap<Long,UserFundInfoVo>();
	//public static final Map<Long, UserFundInfoVo> USER_FUNDS = new RedisMapSimple<Long, UserFundInfoVo>("user_funds", Long.class, UserFundInfoVo.class);

	/**
	 * 新用户 Long fbid
	 */
	public static final Map<Long, Long> NEW_USERS = new RedisMapSimple<Long, Long>("new_users", Long.class, Long.class);

	/****
	 * 用户游戏信息 String fbid
	 */
	public static final RedisMapList<PlayerInfoInRoom> PLAYER_INFO_IN_ROOM = new RedisMapList<PlayerInfoInRoom>("player_info_in_room", PlayerInfoInRoom.class);

	/**
	 * 牌桌上用户玩家信息 String roomid Long fbid
	 */
	public static final RedisMapMap<Long, PlayerInfoInRoom> PLAYER_ON_ROOM = new RedisMapMap<Long, PlayerInfoInRoom>("player_on_room", Long.class, PlayerInfoInRoom.class);
	/****
	 * 用户所在房间信息 String fbid
	 */
	public static final RedisMapList<UserInRoom> USER_IN_ROOM = new RedisMapList<UserInRoom>("user_in_room", UserInRoom.class);
	/****
	 * 游戏开始信息vo String roomid
	 */
	public static final Map<String, GameBeginVo> GAME_ROOMS_BEGIN = new RedisMapSimple<String, GameBeginVo>("game_rooms_begin", String.class, GameBeginVo.class);

	/****
	 * 游戏开始信息vo String gid
	 */
	public static final Map<String, GameBeginVo> GAME_ROOMS_BEGIN_ROUND = new RedisMapSimple<String, GameBeginVo>("game_rooms_begin_round", String.class, GameBeginVo.class);

	/****
	 * 游戏结束信息vo(最近几十局) String roomid
	 */
	public static final RedisMapList<GameLogVo> GAME_ROOMS_END = new RedisMapList<GameLogVo>("game_rooms_end", GameLogVo.class);

	/**
	 * 返回房间map集合
	 */
	public static Rooms getRoom(String rid) {
		if (LocalCache.ROOMS.containsKey(rid)) {
			return LocalCache.ROOMS.get(rid);
		}
		return null;
	}
	/**
	 * 返回用户缓存筹码
	 * 
	 */
	public static Double getChips(Long fbid)
	{
		Double chips=0.0;
		RedisLogin redis = SpringUtils.getBean(RedisLogin.class);
		String rstr=redis.hget(LocalCache.USER_FUND_CECHED_PRDFIX +fbid, "chips");
		if(rstr!=null)
		chips=Double.valueOf(rstr);
		return chips;
	}
	/**
	 * 返回用户呢称
	 * @param fbid
	 * @return
	 */
	public static String getNickName(Long fbid)
	{
		String nickname="joker";
		
		RedisLogin redis = SpringUtils.getBean(RedisLogin.class);
		String rstr=redis.hget(LocalCache.USER_FUND_CECHED_PRDFIX +fbid, "name");
		if(rstr!=null)
			nickname=rstr;
		return nickname;
	}
	
	
}
