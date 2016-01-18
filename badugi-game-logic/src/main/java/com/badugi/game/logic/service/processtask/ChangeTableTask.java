package com.badugi.game.logic.service.processtask;

import io.nadron.client.util.ObjectBeanUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.helper.LobbyUserHelper;
import com.badugi.game.logic.helper.RobotHelper;
import com.badugi.game.logic.helper.TableManagerHelper;
import com.badugi.game.logic.model.cache.LocalCache;
import com.badugi.game.logic.model.cache.LocalMatchCache;
import com.badugi.game.logic.model.callback.LogicRequest;
import com.badugi.game.logic.model.domain.vo.flash.Definition;
import com.badugi.game.logic.model.domain.vo.flash.ResultVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.RobotRoomVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.ServerStopVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.ServerstopResultVo;
import com.badugi.game.logic.model.domain.vo.flash.user.PlayerInfoInRoom;
import com.badugi.game.logic.model.domain.vo.flash.user.UserInRoom;
import com.badugi.game.logic.model.domain.vo.game.Rooms;
import com.badugi.game.logic.model.message.RoomsOp;
import com.badugi.game.logic.util.LogicChannelUtil;
import com.badugi.game.logic.util.LogicPropertyUtil;
import com.badugi.game.logic.util.MapUtils;

/**
 * @author wtu.edit
 * @date 2015年10月17日
 * @version qq1.0
 * @email wtuickqmq@163.com
 */
public class ChangeTableTask {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChangeTableTask.class);

	public ChangeTableTask() {
		super();

	}

	public ResultVo Task(LogicRequest args) {
		ResultVo vo = null;
		Long fbid = null;
		String rid = null;
		Rooms onRoom = null;
		Integer pRoomLevel = 0;

		try {
			RoomsOp op = ObjectBeanUtil.JACKSON.readValue(args.getData(), RoomsOp.class);

			if (op != null) {
				fbid = op.getFbid();
				rid = op.getRid();
				onRoom = LocalCache.ROOMS.get(rid);
				Integer lv = LobbyUserHelper.getUserLv(fbid);

				Integer rplevel = LogicPropertyUtil.getInteger("option.texas.room.plevel");
				if (lv <= rplevel) {// 新用户
					pRoomLevel = 1;
				} else {// 老用户
					pRoomLevel = 2;
				}
			} else {
				vo = new ResultVo(Definition.JOINROOM, Definition.ARG_CODE, null);
				return vo;
			}

			if (onRoom != null && !"".equals(onRoom)) {// 按分组进入房间分配

				Rooms room = getRoom(onRoom.getGid(), rid, pRoomLevel);

				// 填充选中房间
				if (room != null) {
					// 本组内找到房间
					op.setRid(room.getRid());
				} else {
					// 找不到房间
					String gid = TableManagerHelper.getGroupbyChips(fbid);
					room = getRoom(gid, rid, pRoomLevel);

					if (room == null) {
						vo = new ResultVo(Definition.JOINROOM, Definition.FULL_ROOM_CODE, null);
						return vo;
					}
					op.setRid(room.getRid());
				}
			}

			// 获取需要登录的房间
			Rooms room = LocalCache.getRoom(op.getRid());
			UserInRoom inRoom = null;
			// 房间不存在
			if (room == null) {
				vo = new ResultVo(Definition.JOINROOM, Definition.NOROOM_CODE, null);

				return vo;
			}

			// 保存节点
			// LobbyUserHelper.saveUserNodeLog(fbid,
			// UserNodeLog.USER_NODE_GOTALBE, 0);

			// 游戏服务器配置
			String ip = LogicPropertyUtil.getString("option.texas.ip");
			int pt = LogicPropertyUtil.getInteger("option.texas.port", 9933);

			List<UserInRoom> matchUserInRoomList = LocalMatchCache.MATCH_USER_IN_ROOM.get(op.getFbid());
			List<UserInRoom> userInRoomList = LocalCache.USER_IN_ROOM.get(op.getFbid());

			LobbyUserHelper.checkStopGame();
			// 是否禁止进入游戏场
			ServerStopVo serverStopVo = LocalMatchCache.SERVER_STOP;
			if (serverStopVo.getStopserver() && serverStopVo.getStopgame()) {
				ServerstopResultVo svo = new ServerstopResultVo(Definition.JOINROOM, Definition.SERVER_STOP_CODE, serverStopVo.getBegintime(), serverStopVo.getEndtime(), serverStopVo.getGametime(),
						serverStopVo.getMatchtime());

				return svo;
			}

			// 是否已经打开最大房间数
			int max = LogicPropertyUtil.getInteger("option.open.room.max", 4);
			Integer mcount = matchUserInRoomList != null ? matchUserInRoomList.size() : 0;
			Integer ucount = userInRoomList != null ? userInRoomList.size() : 0;
			if ((mcount + ucount) >= max) {
				vo = new ResultVo(Definition.JOINROOM, Definition.OUTSET_CODE, null);

				return vo;
			}

			// 构建数据
			String uid = UUID.randomUUID().toString();
			inRoom = new UserInRoom(ip, pt, uid, room.getRid(), room.getRn(), room.getBb(), room.getSb(), room.getGl(), "");
			inRoom.setCt(System.currentTimeMillis());
			// if (LocalCache.USER_IN_ROOM.containsKey(op.getPuid())) {
			// LocalCache.USER_IN_ROOM.get(op.getPuid()).add(inRoom);
			// } else {
			// ArrayList<UserInRoom> userList = new ArrayList<UserInRoom>();
			// userList.add(inRoom);
			// LocalCache.USER_IN_ROOM.put(op.getPuid(), userList);
			// }
			LocalCache.USER_IN_ROOM.add(fbid.toString(), inRoom);
			// 返回数据给flash
			ArrayList<UserInRoom> resultList = new ArrayList<UserInRoom>();
			resultList.add(inRoom);
			// 成功

			vo = new ResultVo(Definition.JOINROOM, Definition.SUCCESS_CODE, resultList);
			RobotHelper.CheckRoomToRobot(inRoom, room.getCc(), room.getMc(), op.isRobot(),room.getRt(),room.getGid(),true);
		} catch (Exception e) {
			vo = new ResultVo(Definition.JOINROOM, Definition.UNKNOW_CODE, null);
			LOGGER.error("", e);
			e.printStackTrace();
			// Logger.error("deal with join room error  !!!",e);
		}
		return vo;

	}

	private Rooms getRoom(String gid, String rid, Integer pRoomLevel) {
		List<Rooms> rlist = TableManagerHelper.getRoomsByGroup(gid, rid, pRoomLevel);
		Iterator<Rooms> iter = rlist.iterator();
		Rooms room = null;
		while (iter.hasNext()) {
			Rooms rm = iter.next();
			if (rm.getCc() < rm.getMc()) {// 小于最大用户数
				if (rm.getRt() == pRoomLevel || rm.getRt() == 0) {
					room = rm;
					break;
				}
			}
		}
		return room;
	}

	
}
