package com.badugi.game.logic.util;

import io.nadron.client.util.ObjectBeanUtil;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.dao.UsersDao;
import com.badugi.game.logic.model.cache.LocalCache;
import com.badugi.game.logic.model.domain.vo.flash.operators.RoomLevels;
import com.badugi.game.logic.model.domain.vo.game.RoomGroupVo;
import com.badugi.game.logic.model.domain.vo.game.Rooms;
import com.joker.game.common.constant.RedisKeys;
import com.joker.game.db.redis.RedisLogin;

public final class CacheUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(CacheUtil.class);
	
	public static void init() throws JsonParseException, JsonMappingException, IOException {

		RedisLogin redis = AppContext.getBean(RedisLogin.class);

		String roomsValue = redis.get(RedisKeys.KEY_ROOMS);
		
		LOGGER.info("roomsValue isNull:{},size:{} ",(null==roomsValue),(null!=roomsValue)?roomsValue.length():0);
		
		if(null==roomsValue){
			LOGGER.warn("redis room data not ready!");
			return;
			
		}
		List<Rooms> rooms = ObjectBeanUtil.readValueAsList(roomsValue, Rooms.class);

		synchronized (LocalCache.class) {
			
			LocalCache.ROOMS.clear();
			for (Rooms room : rooms) {
				LocalCache.ROOMS.put(room.getRid(), room);
			}

			String roomsLevelValue = redis.get(RedisKeys.KEY_ROOM_LEVEL);

			List<RoomLevels> roomLevel = ObjectBeanUtil.readValueAsList(roomsLevelValue, RoomLevels.class);

			LocalCache.ROOM_LEVELS.clear();
			for (RoomLevels room : roomLevel) {
				LocalCache.ROOM_LEVELS.put(room.getGl(), room);
			}
			
			//初始化房间组信息
			StringBuffer sql = new StringBuffer("select rg.SFSGroupID,rg.RoomLevel,rg.UserCount,rg.MinChips,rg.MaxChips,rg.defChips,rg.EarlyBets,cbc.SmallBlind,cbc.BigBlind,");
			sql.append("rg.RakeValue,rg.ChipLimit,rg.SpecialCard from roomgroups rg,comm_blindlevel_config cbc where rg.BlindLevelConfigId=cbc.BlindLevel and ");
			sql.append("rg.roomgroupid in (select distinct roomgroupid from rooms);");
		
			List<Map<String, Object>> rs = AppContext.getBean(UsersDao.class).querySQLListWithMap(sql.toString());

			Iterator<Map<String, Object>> itr = rs.iterator();
			System.out.println(rs);
			while (itr.hasNext()) {
				
				RoomGroupVo  rgv = ObjectBeanUtil.JACKSON.convertValue(itr.next(), RoomGroupVo.class);
				LocalCache.ROOM_GROUPS.add(rgv);
			}
		}
	}

}
