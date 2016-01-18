package com.badugi.game.logic.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.badugi.game.logic.model.cache.LocalCache;
import com.badugi.game.logic.model.domain.vo.flash.user.PlayerInfoInRoom;
import com.badugi.game.logic.model.domain.vo.game.RoomGroupVo;
import com.badugi.game.logic.model.domain.vo.game.Rooms;
import com.badugi.game.logic.util.MapUtils;

/**
 * 
 * 房间管理
 * @author wtu.edit
 * @date 2015年10月17日
 * @version qq1.0
 * @email wtuickqmq@163.com
 */
public class TableManagerHelper {
	
//	private static final Logger LOGGER = LoggerFactory.getLogger(TableManagerHelper.class);
	/**
	 * 取得满足条件的房间列表
	 * 
	 * @param gid 分组
	 * @param rid 排除的房间id
	 * @param prlevel 低等级房间 1 为A组 2 为B组 0不分组
	 * @return
	 */
	public static final List<Rooms> getRoomsByGroup(String gid,String rid,Integer prlevel)
	{
		List<Rooms> mlist=new ArrayList<Rooms>();//有人
		List<Rooms> nlist=new ArrayList<Rooms>();//没人
		@SuppressWarnings("unchecked")
		Map<String, Rooms> sortRooms = MapUtils.sortKey(LocalCache.ROOMS);
		Iterator<Entry<String, Rooms>> iter = sortRooms.entrySet().iterator(); // 获得map的Iterator

//		Map<Integer, Integer> mc = null;

//		Rooms room = null;
		Map<Long, PlayerInfoInRoom> omIds = null;
//		int playcount = 0;
		while (iter.hasNext()) {

			Map.Entry<String, Rooms> entry = iter.next();
			Rooms rm = entry.getValue();

			if (rm.getGid().equals(gid) && !rm.getRid().equals(rid)) {
				omIds = LocalCache.PLAYER_ON_ROOM.get(rm.getRid());
				rm.setCc(omIds == null ? 0 : omIds.size());
				// if(room==null)room=rm;
				if (rm.getCc() < rm.getMc()) {// 小于最大用户数
												// 大于前一房间人数，则选择该房间
					if (rm.getRt() == prlevel || rm.getRt() == 0) {
						if(rm.getCc()>0)
						{
							mlist.add(rm);
						}
						else
						{
							nlist.add(rm);
						}
						
					}

				}
			}
		}
		mlist.addAll(nlist);
		
		
		return mlist;
		
	}
	
	/**
	 * 根据用户筹码返回分组
	 * 筹码> 默认携带*3
	 * @param uid 用户id 
	 * @return 返回分组
	 */
	public static final String getGroupbyChips(Long uid)
	{
		Double chips=LocalCache.getChips(uid);
		String gid=null;
		Iterator<RoomGroupVo> itr=LocalCache.ROOM_GROUPS.iterator();
		 while(itr.hasNext())
		 {
			 RoomGroupVo item=itr.next();
			 if(chips<(item.getDefChips()*3))
			 {
				 gid=item.getSFSGroupID();
			 }
		 }
		return gid;
		
	}


}
