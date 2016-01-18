package com.badugi.game.logic.model.cache;

import java.util.Map;

import com.badugi.game.logic.model.domain.vo.flash.match.Match;
import com.badugi.game.logic.model.domain.vo.flash.match.Table;
import com.badugi.game.logic.model.domain.vo.flash.operators.ServerStopVo;
import com.badugi.game.logic.model.domain.vo.flash.user.UserInRoom;
import com.badugi.game.logic.model.redis.RedisMapList;
import com.badugi.game.logic.model.redis.RedisMapSimple;

/****
 * 比赛大厅相关缓存
 * 
 * @author weijie
 */
public class LocalMatchCache {

	/****
	 * 比赛用户所在房间信息 key:String fbid
	 */
	public static final RedisMapList<UserInRoom> MATCH_USER_IN_ROOM = new  RedisMapList<UserInRoom>("match_user_in_room",UserInRoom.class);

	/****
	 * 比赛信息 key:Integer matchId
	 */
	public static final Map<Integer, Match> MATCHS = new RedisMapSimple<Integer, Match>("matchs", Integer.class, Match.class);

	/****
	 * 牌桌 key:String rid
	 */
	public static final Map<String, Table> TABLES = new RedisMapSimple<String, Table>("tables", String.class, Table.class);
	/**
	 * 服务器启停
	 */
	public static final ServerStopVo SERVER_STOP = new ServerStopVo();
}
