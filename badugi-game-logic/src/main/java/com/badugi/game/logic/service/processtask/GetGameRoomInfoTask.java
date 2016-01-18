package com.badugi.game.logic.service.processtask;

import io.nadron.client.util.ObjectBeanUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.badugi.game.logic.helper.LobbyUserHelper;
import com.badugi.game.logic.model.cache.LocalCache;
import com.badugi.game.logic.model.cache.LocalMatchCache;
import com.badugi.game.logic.model.callback.LogicRequest;
import com.badugi.game.logic.model.domain.vo.flash.Definition;
import com.badugi.game.logic.model.domain.vo.flash.ResultVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.RobotRoomVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.ServerStopVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.ServerstopResultVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.ShakeOpenVo;
import com.badugi.game.logic.model.domain.vo.flash.user.GameDetailVo;
import com.badugi.game.logic.model.domain.vo.flash.user.PlayerInfoInRoom;
import com.badugi.game.logic.model.domain.vo.flash.user.UserFundDetails;
import com.badugi.game.logic.model.domain.vo.flash.user.UserInRoom;
import com.badugi.game.logic.model.domain.vo.game.Rooms;
import com.badugi.game.logic.model.message.FlashLoginOp;
import com.badugi.game.logic.model.message.RoomsOp;
import com.badugi.game.logic.util.LogicChannelUtil;
import com.badugi.game.logic.util.LogicPropertyUtil;
import com.badugi.game.logic.util.MapUtils;

import java.util.UUID;

import ch.qos.logback.classic.Logger;

public class GetGameRoomInfoTask {

	public GetGameRoomInfoTask() {
		super();

	}

	

	public GameDetailVo Task(LogicRequest args)
	{
		GameDetailVo vo=null;
		Long fbid = null;

		try {
			FlashLoginOp op = ObjectBeanUtil.JACKSON.readValue(args.getData(), FlashLoginOp.class);
			

			if (op != null) {
				fbid=op.getFbid();
				Map<Long, PlayerInfoInRoom> playOnRoom = LocalCache.PLAYER_ON_ROOM.get(op.getRid());
				Rooms room = LocalCache.getRoom(op.getRid());
				if (room != null) {
					List<UserFundDetails> pi = new ArrayList<UserFundDetails>();
					vo = new GameDetailVo(room.getRid(), room.getRn(), room.getBb(), room.getSb());
					if (playOnRoom != null) {
						if (playOnRoom.size() > 0) {

							// 牌桌上筹码
							Map<String, Double> userNowChips = new HashMap<String, Double>();
							Map<String, Short> seats=new HashMap<String,Short>();

							String ids = "";
							Iterator<Entry<Long, PlayerInfoInRoom>> ite = playOnRoom.entrySet().iterator();
							PlayerInfoInRoom pivalue = null;
							while (ite.hasNext()) {
								Entry<Long, PlayerInfoInRoom> entry =  ite.next();
								Long key = entry.getKey();// map中的key
								if ("".equals(ids)) {
									ids = key.toString();
								}
								else {
									ids += "," + key.toString();
								}
								pivalue = (PlayerInfoInRoom) entry.getValue();
								
								
								UserFundDetails details = LobbyUserHelper.getUserInfo(key);
								details.setCp(pivalue.getCpir());
								details.setSeat(pivalue.getSeat());
								if(!isInList(pi,details))
								{
									pi.add(details);
								}
								
							}

						
						}
					}
					vo.setCode(Definition.SUCCESS_CODE);
					vo.setCmd(Definition.GAMEDETAILS);
					vo.setList(pi);
					
				}
				else {
					vo = new GameDetailVo(Definition.GAMEDETAILS, Definition.NOROOM_CODE);
				}
			}
			else
			{
				vo =  new GameDetailVo(Definition.GAMEDETAILS, Definition.NOLOGIN_CODE);
			}

		
			
			
		} catch (Exception e) {
			vo =  new GameDetailVo(Definition.GAMEDETAILS, Definition.UNKNOW_CODE);
			// Logger.error("deal with join room error  !!!",e);
		}
		return vo;

	}
	/**
	 * 检测是否在列表中
	 * @param plist
	 * @param ds
	 * @return
	 */
	private boolean isInList(List<UserFundDetails> plist,UserFundDetails ds)
	{
		Iterator<UserFundDetails> itr=plist.iterator();
		while(itr.hasNext())
		{
			if(itr.next().getUid()==ds.getUid())
			{
				return true;
			}
		}
		return false;
	}

}
