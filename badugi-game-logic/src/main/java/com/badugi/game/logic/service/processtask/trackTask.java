package com.badugi.game.logic.service.processtask;

import io.nadron.client.util.ObjectBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.model.cache.LocalCache;
import com.badugi.game.logic.model.callback.LogicRequest;
import com.badugi.game.logic.model.domain.vo.flash.Definition;
import com.badugi.game.logic.model.domain.vo.flash.ResultVo;
import com.badugi.game.logic.model.domain.vo.flash.user.PlayerInfoInRoom;
import com.badugi.game.logic.model.domain.vo.flash.user.TrackRooms;
import com.badugi.game.logic.model.domain.vo.flash.user.UserInRoom;
import com.badugi.game.logic.model.domain.vo.game.Rooms;
import com.badugi.game.logic.model.message.TrackOp;

/**
 * @author wtu.edit
 * @date 2015年10月17日
 * @version qq1.0
 * @email wtuickqmq@163.com
 */
public class trackTask {

	private static final Logger LOGGER = LoggerFactory.getLogger(trackTask.class);

	public trackTask() {
		super();

	}

	public ResultVo Task(LogicRequest args) {
		ResultVo vo = null;
		Long uid = null;
		Long tid = null;


		try {
			TrackOp op = ObjectBeanUtil.JACKSON.readValue(args.getData(), TrackOp.class);
			uid=op.getUid();
			tid=op.getTagetuid();

			if (uid == null || uid <= 0 || tid == null || tid <= 0) {
				vo = new ResultVo(Definition.TRACK, Definition.ARG_CODE);
				return vo;
			}
			// 返回追踪数据
			List<TrackRooms> tlist=new ArrayList<TrackRooms>();
			List<UserInRoom> ulist = LocalCache.USER_IN_ROOM.get(String.valueOf(tid));

			UserInRoom inRoom = null;
			Rooms r = null;
			
			if (ulist != null && ulist.size() > 0) {
				Map<Long, PlayerInfoInRoom> omIds = null;

				for (int i = 0; i < ulist.size(); i++) {
					inRoom = ulist.get(i);
					omIds = LocalCache.PLAYER_ON_ROOM.get(inRoom.getRid());
					TrackRooms trackRoom = null;
					trackRoom = new TrackRooms(inRoom.getRid(), inRoom.getRn(), inRoom.getBb(), inRoom.getSb());
					r = LocalCache.ROOMS.get(inRoom.getRid());
					trackRoom.setSp(String.valueOf(r != null ? r.getSp() : 0));// 速度
					trackRoom.setCc(omIds == null ? 0 : omIds.size());// 房间
					trackRoom.setSt(inRoom.getIsSit() != -1 ? inRoom.getIsSit() : 0);
					tlist.add(trackRoom);

				}
			}


			vo = new ResultVo(Definition.TRACK, Definition.SUCCESS_CODE, tlist);
			return vo;



		} catch (Exception e) {
			vo = new ResultVo(Definition.JOINROOM, Definition.UNKNOW_CODE, null);
			LOGGER.error("", e);
			e.printStackTrace();
			// Logger.error("deal with join room error  !!!",e);
		}
		return vo;

	}


}
