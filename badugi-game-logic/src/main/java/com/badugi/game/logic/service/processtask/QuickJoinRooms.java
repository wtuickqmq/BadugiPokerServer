package com.badugi.game.logic.service.processtask;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.badugi.game.logic.helper.LobbyUserHelper;
import com.badugi.game.logic.model.cache.LocalCache;
import com.badugi.game.logic.model.cache.LocalMatchCache;
import com.badugi.game.logic.model.domain.vo.api.match.matchplayinfo.QuickVo;
import com.badugi.game.logic.model.domain.vo.flash.Definition;
import com.badugi.game.logic.model.domain.vo.flash.user.QuickResultVo;
import com.badugi.game.logic.model.domain.vo.flash.user.UserInRoom;
import com.badugi.game.logic.model.domain.vo.game.Rooms;
import com.badugi.game.logic.util.LogicPropertyUtil;



/**
 * @author wtu.edit
 * @date 2015年9月18日
 * @version qq1.0
 * @email wtuickqmq@163.com
 */
public class QuickJoinRooms  {
	
	

	public QuickJoinRooms() {

	}

	public QuickResultVo task(QuickVo op) {
		QuickResultVo vo = null;
		try {
			if(op==null)return vo;

			// 获取需要登录的房间
			Double chips = LocalCache.getChips(op.getFbid());
			String rid = null;
			if (op.getSb() > 0 && op.getBb() > 0) {
				rid = LobbyUserHelper.quickJoinInRoom(op.getFbid(), chips, op.getSb(), op.getBb());
			}
			else {
				
				rid = LobbyUserHelper.quickJoinInRoom(op.getFbid(), chips, op.getType());

			}

			if (rid == null) {// 没获取到房间ID
				vo = new QuickResultVo(Definition.QUICKJOINROOM, Definition.NO_ENO_CHIPS);
				
				return vo;
			}
			Rooms room = LocalCache.getRoom(rid);
			UserInRoom inRoom = null;
			// 房间不存在
			if (room == null) {
				vo = new QuickResultVo(Definition.JOINROOM, Definition.NOROOM_CODE);
				return vo;
			}

			// 游戏服务器配置
			String ip =LogicPropertyUtil.getString("option.texas.ip");
			int pt = LogicPropertyUtil.getInteger("option.texas.port",9933);

			List<UserInRoom> matchUserInRoomList = LocalMatchCache.MATCH_USER_IN_ROOM.get(op.getFbid().toString());
			List<UserInRoom> userInRoomList = LocalCache.USER_IN_ROOM.get(op.getFbid().toString());

			// 已经进去该房间
			/*
			 * if(LobbyUserHelper.isInRoom(userInRoomList, rid)){
			 * vo = new QuickResultVo(Definition.QUICKJOINROOM, Definition.REPEAT_CODE);
			 * String rooms = JsonUtils.beanToJson(vo);
			 * channel.write(rooms);
			 * return;
			 * }
			 */
			if (userInRoomList != null && userInRoomList.size() > 0) {
				UserInRoom uinRoom = null;
				for (int i = 0; i < userInRoomList.size(); i++) {
					uinRoom = userInRoomList.get(i);
					if (uinRoom.getRid().equals(rid)) {
						// 成功
						vo = new QuickResultVo(Definition.QUICKJOINROOM, Definition.SUCCESS_CODE, ip, pt, uinRoom.getUid(), room.getRid(), room.getRn(), room.getBb(), room.getSb(), room.getGl(), getSign(uinRoom.getUid(), ip, pt, room.getRid()), op.getAm());
						
						return vo;
					}
				}
			}

			// 是否已经打开最大房间数
			int max = LogicPropertyUtil.getInteger("option.open.room.max",4);
			Integer mcount = matchUserInRoomList != null ? matchUserInRoomList.size() : 0;
			Integer ucount = userInRoomList != null ? userInRoomList.size() : 0;
			if ((mcount + ucount) >= max) {
				vo = new QuickResultVo(Definition.QUICKJOINROOM, Definition.OUTSET_CODE);
				
				return vo;
			}
			// 构建数据
			String uid = UUID.randomUUID().toString();
			inRoom = new UserInRoom(ip, pt, uid, room.getRid(), room.getRn(), room.getBb(), room.getSb(), getSign(uid, ip, pt, room.getRid()));
			inRoom.setCt(System.currentTimeMillis());
			if (LocalCache.USER_IN_ROOM.containsKey(op.getFbid().toString())) {
				LocalCache.USER_IN_ROOM.get(op.getFbid().toString()).add(inRoom);
			}
			else {
				ArrayList<UserInRoom> userList = new ArrayList<UserInRoom>();
				userList.add(inRoom);
				LocalCache.USER_IN_ROOM.put(op.getFbid().toString(), userList);
			}
			// 返回数据给flash
			ArrayList<UserInRoom> resultList = new ArrayList<UserInRoom>();
			resultList.add(inRoom);
			// 成功
			vo = new QuickResultVo(Definition.QUICKJOINROOM, Definition.SUCCESS_CODE, ip, pt, uid, room.getRid(), room.getRn(), room.getBb(), room.getSb() ,room.getGl(), getSign(uid, ip, pt, room.getRid()), op.getAm());
			
		}
		catch (Exception e) {
			vo = new QuickResultVo(Definition.QUICKJOINROOM, Definition.UNKNOW_CODE);
			
		}
		return vo;
	}


	private String getSign(String uid, String ip, int pt, String rid) {
		// TODO 自动生成的方法存根
		return "";
	}
	
	

}
