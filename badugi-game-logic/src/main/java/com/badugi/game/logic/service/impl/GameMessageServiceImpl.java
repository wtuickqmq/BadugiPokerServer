package com.badugi.game.logic.service.impl;

import io.nadron.client.util.ObjectBeanUtil;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badugi.game.logic.dao.GameUserlogDao;
import com.badugi.game.logic.dao.UsersDao;
import com.badugi.game.logic.helper.LobbyMsgHelper;
import com.badugi.game.logic.helper.LobbyUserHelper;
import com.badugi.game.logic.helper.RobotHelper;
import com.badugi.game.logic.model.cache.LobbyParamCache;
import com.badugi.game.logic.model.cache.LocalCache;
import com.badugi.game.logic.model.cache.LocalMatchCache;
import com.badugi.game.logic.model.callback.LogicMap;
import com.badugi.game.logic.model.callback.LogicRequest;
import com.badugi.game.logic.model.callback.RPCReponse;
import com.badugi.game.logic.model.domain.vo.flash.Definition;
import com.badugi.game.logic.model.domain.vo.flash.operators.DealwithFishEnemyThread;
import com.badugi.game.logic.model.domain.vo.flash.operators.GameBeginVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.GameLogVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.RoomLevels;
import com.badugi.game.logic.model.domain.vo.flash.operators.ServerStopVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.UserCpVo;
import com.badugi.game.logic.model.domain.vo.flash.user.MsgSendVo;
import com.badugi.game.logic.model.domain.vo.flash.user.PlayerInfoInRoom;
import com.badugi.game.logic.model.domain.vo.flash.user.UserBackChipsVo;
import com.badugi.game.logic.model.domain.vo.flash.user.UserInRoom;
import com.badugi.game.logic.model.domain.vo.game.Rooms;
import com.badugi.game.logic.model.entity.Notices;
import com.badugi.game.logic.model.entity.PlayerBackChips;
import com.badugi.game.logic.model.message.FundOp;
import com.badugi.game.logic.model.message.PlayerBackOp;
import com.badugi.game.logic.model.message.RoomLevelsOp;
import com.badugi.game.logic.model.message.RoomsOp;
import com.badugi.game.logic.model.message.UserOp;
import com.badugi.game.logic.model.redis.RedisMapSimple;
import com.badugi.game.logic.service.GameMessageService;
import com.badugi.game.logic.util.AppContext;
import com.badugi.game.logic.util.CacheUtil;
import com.badugi.game.logic.util.DateUtils;
import com.badugi.game.logic.util.LangsUtil;
import com.badugi.game.logic.util.LogicChannelUtil;
import com.badugi.game.logic.util.LogicExecutorUtil;
import com.badugi.game.logic.util.LogicPropertyUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Service("gameMessageService")
public class GameMessageServiceImpl implements GameMessageService {

	@Autowired
	private GameUserlogDao gameUserlogDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(GameMessageServiceImpl.class);

	@RPCReponse("call_stop_server")
	public void call_stop_server(LogicRequest request) {
		try {
			boolean flag = true;
			LogicMap logicMap = request.getParames();
			flag &= logicMap.containsKey("begintime");
			flag &= logicMap.containsKey("endtime");
			flag &= logicMap.containsKey("gametime");
			flag &= logicMap.containsKey("matchtime");
			if (flag) {
				Long begintime = Long.valueOf(logicMap.get("begintime").toString());
				Long endtime = Long.valueOf(logicMap.get("endtime").toString());
				Long gametime = Long.valueOf(logicMap.get("gametime").toString());
				Long matchtime = Long.valueOf(logicMap.get("matchtime").toString());
				GameMessageServiceImpl.startServerStop(begintime, endtime, gametime, matchtime);
			}
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		
	}

	@RPCReponse("call_stop")
	public void call_stop(LogicRequest request) {
		LogicMap logicMap = request.getParames();
		if (logicMap.containsKey("begintime") && logicMap.containsKey("endtime") && logicMap.containsKey("gametime") && logicMap.containsKey("matchtime")) {

			String format = "yyyy-MM-dd HH时mm分ss秒";
			Timestamp now = new Timestamp(System.currentTimeMillis());

			Long begintime = Long.valueOf(logicMap.get("begintime").toString());
			Long endtime = Long.valueOf(logicMap.get("endtime").toString());
			Integer _gametime = Integer.valueOf(logicMap.get("gametime").toString());
			Integer _endtime = Integer.valueOf(logicMap.get("matchtime").toString());

			String bt = DateUtils.dateToString(new Date(begintime), DateUtils.PATTERN_YMDHMS);
			String bt2 = DateUtils.dateToString(new Date(begintime), format);
			String et = DateUtils.dateToString(new Date(endtime), DateUtils.PATTERN_YMDHMS);
			String et2 = DateUtils.dateToString(new Date(endtime), format);

			// 提前多长时间提示
			Date gametime = DateUtils.addDate(new Date(begintime), 12, -_gametime);
			Date matchtime = DateUtils.addDate(new Date(begintime), 12, -_endtime);
			String gameet = DateUtils.dateToString(gametime, DateUtils.PATTERN_YMDHMS);
			String gameet2 = DateUtils.dateToString(gametime, format);
			String matchet = DateUtils.dateToString(matchtime, DateUtils.PATTERN_YMDHMS);
			String matchet2 = DateUtils.dateToString(matchtime, format);
			// 消息提示
			String language = LogicPropertyUtil.getString("option.match.sysmsg.language.default", "");

			// String content = Messages.get(Lang.forCode(language),
			// "option.notice.serverstop.msg", bt, et, gameet, matchet, "'");
			String content = LangsUtil.getMessage("option.notice.serverstop.msg", new Object[] { bt2, et2, gameet2, matchet2 }, new Locale(language));
			// 保存公告
			String nt = DateUtils.dateToString(new Date(now.getTime()), DateUtils.PATTERN_YMDHMS);
			StringBuffer notices = new StringBuffer("INSERT INTO notices(Content,BeginTime,EndTime,OperatedTime,Type)VALUES(");
			notices.append("\"" + content + "\"");
			notices.append(",'" + nt + "'");
			notices.append(",'" + bt + "'");
			notices.append(",'" + nt + "'");
			notices.append("," + Notices.TYPE_SERVERSTOP);
			notices.append(");");
			AppContext.getBean(UsersDao.class).execSQL(notices.toString());
			// DbUtils.insertAndRelKey(notices.toString());

			// 发送公告通知用户
			Notices n = LobbyMsgHelper.getLastNotice();
			
			if(null!=n){
				MsgSendVo vo = new MsgSendVo(Definition.NOTICES, content,
						DateUtils.dateToString(new Date(n.getOperatedTime().getTime()), DateUtils.PATTERN_YMDHMS));
				
				LogicChannelUtil.sendToAll(vo);
				
			}
		}

	}

	@RPCReponse("call_start_server")
	public void call_start_server(LogicRequest request) {
		GameMessageServiceImpl.stopServerStop();
	}

	@RPCReponse("call_test")
	public void call_test(LogicRequest request) {
		Map<String, Object> map = Maps.newConcurrentMap();
		map.put("event", "say");
		map.put("msg", "hello world");
		LogicChannelUtil.sendToTargets(map, null);
		LogicChannelUtil.sendToRobot(map);
		LOGGER.info("{}", request);
	}

	@RPCReponse("call_room_info")
	public void call_updaterooms(LogicRequest request) {
		try {
			CacheUtil.init();

		} catch (IOException e) {
			LOGGER.error("", e);
		}
		LOGGER.info("{}", request.getData());
	}

	@RPCReponse("call_room_clear")
	public void call_room_clear(LogicRequest request) {
		LocalCache.PLAYER_INFO_IN_ROOM.clear();
		LocalCache.PLAYER_ON_ROOM.clear();
		LocalCache.USER_IN_ROOM.clear();
		LocalCache.GAME_ROOMS_BEGIN.clear();
		LocalCache.GAME_ROOMS_BEGIN_ROUND.clear();
		LocalCache.GAME_ROOMS_END.clear();
		LOGGER.info("{}", request.getData());
	}

	@RPCReponse("call_room_level")
	public void call_updatelevels(LogicRequest request) {
		LOGGER.info("{}", request.getData());
		try {
			Map<String, Class> map = new HashMap<String, Class>();
			map.put("list", RoomLevels.class);
			RoomLevelsOp op = ObjectBeanUtil.JACKSON.readValue(request.getData(), RoomLevelsOp.class);
			if (op.isIa()) {
				LocalCache.ROOM_LEVELS.clear();
			}
			if (op.getList() != null) {
				RoomLevels mqRoomLevels = null;
				for (int i = 0; i < op.getList().size(); i++) {
					mqRoomLevels = op.getList().get(i);
					// mqRoomLevels.setLn(mqRoomLevels.getLn());//实现多语言将名称覆盖为ID
					LocalCache.ROOM_LEVELS.put(mqRoomLevels.getGl(), mqRoomLevels);
				}
			}
		} catch (Exception e) {

			// Logger.error("deal with room levels error form MQ !!!",e);
		}
	}

	@RPCReponse("call_removerooms")
	public void call_removerooms(LogicRequest request) {
		LOGGER.info("{}", request.getData());
		try {
			Map<String, Class> map = new HashMap<String, Class>();
			map.put("list", Rooms.class);
			RoomsOp op;

			op = ObjectBeanUtil.JACKSON.readValue(request.getData(), RoomsOp.class);

			if (op != null && op.getList() != null && op.getList().size() > 0) {
				List<Rooms> list = op.getList();
				Map<String, String> removeRids = new HashMap<String, String>();
				for (int i = 0; i < list.size(); i++) {
					removeRids.put(list.get(i).getRid(), list.get(i).getRid());
				}
				// 执行删除
				Iterator iter = LocalCache.ROOMS.entrySet().iterator();
				while (iter.hasNext()) {
					Entry entry = (Entry) iter.next();
					String roomId = entry.getKey().toString();
					if (removeRids.containsKey(roomId)) {
						LocalCache.ROOMS.remove(roomId);
					}
				}
			}
		} catch (JsonParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@RPCReponse("call_room_players")
	public void call_updateroomplayers(LogicRequest request) {
		LOGGER.info("{}", request.getData());
		try {
			Map<String, Class> map = new HashMap<String, Class>();
			map.put("list", PlayerInfoInRoom.class);
			UserOp op = ObjectBeanUtil.JACKSON.readValue(request.getData(), UserOp.class);

			String rid = null;
			Long puid = null;
			RedisMapSimple<Long, PlayerInfoInRoom> userIds = null;

			if (op.isIa()) {
				LocalCache.PLAYER_INFO_IN_ROOM.clear();// 玩家在房间信息(用户ID为Key)
				LocalCache.PLAYER_ON_ROOM.clear();// 玩家在房间信息(房间ID为Key)
				LocalCache.USER_IN_ROOM.clear();// 用户在房间信息
				LocalCache.GAME_ROOMS_END.clear();// 清空最近游戏记录

				List<PlayerInfoInRoom> list = op.getList();
				if (list != null) {
					ArrayList<PlayerInfoInRoom> userList = null;
					PlayerInfoInRoom _idsVo = null;
					UserInRoom inRoom = null;

					Rooms room = null;
					for (int i = 0; i < list.size(); i++) {
						PlayerInfoInRoom piir = list.get(i);
						rid = piir.getRid();
						puid = Long.valueOf(piir.getPuid());
						room = LocalCache.getRoom(rid);
						if (room == null) {
							continue;
						}

						String ip = LogicPropertyUtil.getString("option.texas.ip");
						int pt = LogicPropertyUtil.getInteger("option.texas.port", 9933);
						inRoom = new UserInRoom(ip, pt, piir.getUid(), rid, room.getRn(), room.getBb(), room.getSb(), "");

						userIds = LocalCache.PLAYER_ON_ROOM.get(rid);
						if (userIds == null) {
							// userIds = new ConcurrentHashMap<Long,
							// PlayerInfoInRoom>();
						}

						// 保存用户在牌桌上的情况
						if (piir.getIs()) {// 是否坐下
							if (piir.getSo()) {
								inRoom.setIsSit(2);
							} else {
								inRoom.setIsSit(1);
							}

							_idsVo = piir;
							_idsVo.setCpir(_idsVo.getCp());
							_idsVo.setRobot(LobbyUserHelper.isRobot(puid));
							userIds.put(puid, _idsVo);
						} else {
							inRoom.setIsSit(0);
						}
						// 玩家在房间信息
						// if
						// (LocalCache.USER_IN_ROOM.containsKey(piir.getPuid()))
						// {
						// LocalCache.USER_IN_ROOM.get(piir.getPuid()).add(inRoom);
						// } else
						// {
						// ArrayList<UserInRoom> ulist = new
						// ArrayList<UserInRoom>();
						// ulist.add(inRoom);
						// LocalCache.USER_IN_ROOM.put(piir.getPuid(), ulist);
						// }

						LocalCache.USER_IN_ROOM.add(piir.getPuid(), inRoom);
						// 玩家在游戏信息
						// if
						// (LocalCache.PLAYER_INFO_IN_ROOM.containsKey(piir.getPuid()))
						// {
						// LocalCache.PLAYER_INFO_IN_ROOM.get(piir.getPuid()).add(piir);
						// } else
						// {
						// userList = new ArrayList<PlayerInfoInRoom>();
						// userList.add(piir);
						// LocalCache.PLAYER_INFO_IN_ROOM.put(piir.getPuid(),
						// userList);
						// }
						//

						LocalCache.PLAYER_INFO_IN_ROOM.add(piir.getPuid(), piir);
						LocalCache.PLAYER_ON_ROOM.put(rid, userIds);
						// 更新房间人数
						room.setCc(userIds.size());
					}
				}
			} else {
				List<PlayerInfoInRoom> list = op.getList();
				if (op.getList() != null) {
					List<PlayerInfoInRoom> userList = null;
					List<PlayerInfoInRoom> _uList = null;
					PlayerInfoInRoom _idsVo = null;
					for (int i = 0; i < list.size(); i++) {
						PlayerInfoInRoom piir = list.get(i);
						rid = piir.getRid();
						puid = Long.valueOf(piir.getPuid());

						// 原来牌桌上的用户
						userIds = LocalCache.PLAYER_ON_ROOM.get(rid);
						if (userIds == null) {
							// userIds = new ConcurrentHashMap<Long,
							// PlayerInfoInRoom>();
						}
						if (piir.getIs()) {
							_idsVo = piir;
							_idsVo.setCpir(piir.getCp());
							_idsVo.setRobot(LobbyUserHelper.isRobot(puid));
							userIds.put(puid, _idsVo);
							// 更改用户在房间状态
							if (piir.getSo()) {// 留座
								LobbyUserHelper.updateUserSitStatus(piir.getPuid(), rid, 2);
							} else {
								LobbyUserHelper.updateUserSitStatus(piir.getPuid(), rid, 1);
							}
						} else {
							userIds.remove(puid);
							// 更改用户在房间状态
							LobbyUserHelper.updateUserSitStatus(piir.getPuid(), rid, 0);
						}

						if (LocalCache.PLAYER_INFO_IN_ROOM.containsKey(piir.getPuid())) {
							_uList = LocalCache.PLAYER_INFO_IN_ROOM.get(piir.getPuid());
							if (_uList != null) {
								for (int j = 0; j < _uList.size(); j++) {
									if (piir.getRid().equals(_uList.get(j).getRid())) {
										_uList.remove(j);
										_uList.add(piir);
										break;
									}
								}
							}
						} else {
							// userList = new ArrayList<PlayerInfoInRoom>();
							// userList.add(piir);
							// LocalCache.PLAYER_INFO_IN_ROOM.put(piir.getPuid(),
							// userList);

							LocalCache.PLAYER_INFO_IN_ROOM.add(piir.getPuid(), piir);
						}
						LocalCache.PLAYER_ON_ROOM.put(rid, userIds);
						// 更新房间人数
						Rooms room = LocalCache.getRoom(rid);
						if (room != null) {
							room.setCc(userIds.size());
							LOGGER.debug("size:{}", LocalCache.getRoom(rid).getCc());
						}
					}
				}
			}
			if (op.getList() != null && op.getList().size() > 0) {
				// 通知机器人是否调整人数
				// RobotMessageSendUtils.sendRoomInfo(rid);
			}
		} catch (Exception e) {
			LOGGER.error("", e);
			// Logger.error("deal with update roomplayers  error form MQ !!!",
			// e);
		}

	}

	@RPCReponse("call_game_begin")
	public void call_gamebegin(LogicRequest request) {
		try {
			Map<String, Class> map = new HashMap<String, Class>();
			map.put("list", UserCpVo.class);
			GameBeginVo op = ObjectBeanUtil.JACKSON.readValue(request.getData(), GameBeginVo.class);
			if (op != null) {
				LocalCache.GAME_ROOMS_BEGIN.put(op.getRid(), op);
				LocalCache.GAME_ROOMS_BEGIN_ROUND.put(op.getGid(), op);
                boolean isRealPlayer=false;
                int playcount=0;
				// 用户开始游戏金额
				List<UserCpVo> list = op.getList();
				if (list != null && list.size() > 0) {
					UserCpVo cpVo = null;
					Map<Long, PlayerInfoInRoom> roomIdsVo = LocalCache.PLAYER_ON_ROOM.get(op.getRid());
					PlayerInfoInRoom idsVo = null;
					for (int i = 0; i < list.size(); i++) {
						cpVo = list.get(i);
						Long key = Long.valueOf(cpVo.getPuid());
						if (roomIdsVo != null && roomIdsVo.containsKey(key)) {
							idsVo = roomIdsVo.get(key);
							idsVo.setCpir(cpVo.getCp());
							roomIdsVo.put(key, idsVo);
							if(!idsVo.isRobot())
							{
								isRealPlayer=true;
							}
						}
						
					}
					playcount=roomIdsVo.size();
					
				}
				if(isRealPlayer)
				{
					Rooms room = LocalCache.getRoom(op.getRid());
					
					if((room.getMc()-playcount)>=2)
					{
				       UserInRoom inRoom = null;
					   String ip = LogicPropertyUtil.getString("option.texas.ip");
					   int pt = LogicPropertyUtil.getInteger("option.texas.port", 9933);
					   String uid = UUID.randomUUID().toString();
					   inRoom = new UserInRoom(ip, pt, uid, room.getRid(), room.getRn(), room.getBb(), room.getSb(), room.getGl(), "");
					   inRoom.setCt(System.currentTimeMillis());
					   RobotHelper.CheckRoomToRobot(inRoom, playcount, room.getMc(), false,room.getRt(),room.getGid(),false);
					}
				}
				
			} else {
				// Logger.warn("deal with game begin arg is error, system rollback!"
				// + msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// Logger.error("deal with game begin error form MQ !!!",e);
		}
	}

	@RPCReponse("call_game_end")
	public void call_gameend(LogicRequest request) {
		// TODO 自动生成的方法存根

		GameLogVo op = null;
		try {
			op = ObjectBeanUtil.JACKSON.readValue(request.getData(), GameLogVo.class);
		} catch (JsonParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		if (op == null) {
			// Logger.warn("deal with game end arg is error, system rollback!" +
			// msg);
			return;
		}

		// 是否敌人或者fish提示
		String gid = op.getGid();
		if (gid != null) {
			// 把结果发给商城处理
			LogicExecutorUtil.getLogicService().execute(new DealwithFishEnemyThread(new Integer(gid)));
			// Threadpool.executorOtherPool.execute();
		}

		String rid = op.getRid();
		Rooms rooms = LocalCache.ROOMS.get(rid);
		if (rooms == null)
			return;

		// 将游戏开始信息填充到游戏记录中
		GameBeginVo bvo = LocalCache.GAME_ROOMS_BEGIN_ROUND.get(gid);

		if (bvo == null)
			return;

		op.setBt(bvo.getBt());
		op.setBlist(bvo.getList());
		LocalCache.GAME_ROOMS_BEGIN_ROUND.remove(gid);

		List<GameLogVo> logList = LocalCache.GAME_ROOMS_END.get(rid);
		if (logList == null) {

			logList = new ArrayList<GameLogVo>();

		} else if (logList.size() >= LobbyParamCache.MAX_LAST_ROUND) {// 统计最近多少局的数据

			logList.remove(0);// 删除第一条
		}
		logList.add(op);
		LocalCache.GAME_ROOMS_END.put(rid, logList);

	}

	@RPCReponse("call_player_join_or_leave")
	public void call_player_join_or_leave(LogicRequest request) {
		// TODO 自动生成的方法存根

		try {
			RoomsOp op = ObjectBeanUtil.JACKSON.readValue(request.getData(), RoomsOp.class);
			List<UserInRoom> userList = null;
			if (op.getIj()) {// 进入房间
				// 构建数据
				userList = LocalCache.USER_IN_ROOM.get(op.getPuid());
				// 加入房间提醒
				LobbyUserHelper.userOnline(Long.valueOf(op.getPuid()));
				if (userList != null && userList.size() > 0) {
					UserInRoom inRoom = null;
					for (int i = 0; i < userList.size(); i++) {
						inRoom = userList.get(i);
						if (inRoom.getRid().equals(op.getRid())) {
							if (inRoom.getIsSit() == -1) {
								inRoom.setIsSit(0);// 已经加入房间

								// 强制更新
								userList.set(i, inRoom);

							}
						}
					}
				} else {
					// Logger.warn("the user is not login room,user_apply_in_room is null! puid:"
					// + op.getPuid() + ", rid:" + op.getRid());
				}
			} else {// 离开房间
				userList = LocalCache.USER_IN_ROOM.get(op.getPuid());
				// 离开房间提醒
				LobbyUserHelper.userLeaveRoom(Long.valueOf(op.getPuid()));
				if (userList != null && userList.size() > 0) {
					UserInRoom inRoom = null;
					Map<String, String> lRoom = new HashMap<String, String>();
					for (int i = 0; i < userList.size(); i++) {
						inRoom = userList.get(i);
						if (op.getRid().equals(inRoom.getRid())) {
							lRoom.put(inRoom.getRid(), inRoom.getRid());

						}
					}
					if (lRoom.size() > 0) {
						Iterator iter = lRoom.entrySet().iterator();
						while (iter.hasNext()) {
							Entry entry = (Entry) iter.next();
							String rid = (String) entry.getKey();
							LobbyUserHelper.deleteUserInRoom(userList, rid);
						}
					}
				}
			}
		} catch (Exception e) {
			// Logger.error("deal with join or leave room  error form MQ !!!",e);
		}

	}

	@RPCReponse("call_update_chips_info")
	public void call_update_chips_info(LogicRequest request) {
		// TODO 自动生成的方法存根
		try {
			FundOp op = ObjectBeanUtil.JACKSON.readValue(request.getData(), FundOp.class);
			if (op != null) {
				LobbyUserHelper.sendLobbyChipsChange(op.getId(), op.getCcp());
				if(op.getCcp()>0)
				{
					LobbyUserHelper.updateUserSaveCost(op.getId(),op.getCcp(),1,"普通场游戏返回");
				}
				else
				{
					LobbyUserHelper.updateUserSaveCost(op.getId(),op.getCcp(),1,"普通场游戏申请");
				}
				
			} else {
				LOGGER.error("call_update_chips_info data error");
			}
		} catch (Exception e) {
			LOGGER.error("call_update_chips_info " + e.getMessage());
		}

	}

	@RPCReponse("call_p_back_chips")
	public void call_p_back_chips(LogicRequest request) {
		// TODO 自动生成的方法存根
		try {
			PlayerBackOp op = ObjectBeanUtil.JACKSON.readValue(request.getData(), PlayerBackOp.class);
			if (op != null) {

				LobbyUserHelper.sendLobbyChipsChange(op.getId(), op.getCcp());

				if (op.getCcp() <= 0) {// 如果小于零则不返回赢利数据，直接退出
					//return;
				}

				StringBuffer sql = new StringBuffer(
						"select count(gu.fbid) as rcount,sum(gu.playtime) as sumtime,sum(gu.changechips) as changechips,sum(gu.points) as points,rg.defchips as defchips from game_userlog as gu,roomgroups as rg where rg.roomgroupid=gu.roomgroupid ");
				sql.append(" and gu.fbid=" + op.getId());
				sql.append(" and gu.applyid=" + op.getAid());
				PlayerBackChips item = null;
				List<Map<String, Object>> rs = AppContext.getBean(UsersDao.class).querySQLListWithMap(sql.toString());

				Iterator<Map<String, Object>> itr = rs.iterator();
				System.out.println(rs);
				if (itr.hasNext()) {

					item = ObjectBeanUtil.JACKSON.convertValue(itr.next(), PlayerBackChips.class);
				}

				if (item == null || item.getRcount() <= 0)
					return;
				LobbyUserHelper.updateUserPoints(op.getId(), item.getPoints());
				double defchips = item.getDefchips();
				UserBackChipsVo ubcv = new UserBackChipsVo();
				ubcv.setCmd(Definition.BACKCHIPS);
				ubcv.setCode(Definition.SUCCESS_CODE);
				ubcv.setRd(item.getRcount().intValue());
				ubcv.setPt(item.getSumtime().intValue());
				ubcv.setCc(item.getChangechips());
				/**
				 * wtu.edit 2015-12-17  赢利面板显示积分原为 除100，现扩大10倍
				 */
				ubcv.setP(item.getPoints().doubleValue() / 10.0);
				ubcv.setId(op.getId());
				ubcv.setT(DateUtils.dateToString(new Date(), DateUtils.PATTERN_YMDHMS));
				String label = "";
				if (ubcv.getCc() < defchips / 2) {
					label = "";
				} else if (ubcv.getCc() < defchips) {
					label = "得心应手 ";
				} else if (ubcv.getCc() < defchips * 2) {
					label = "技艺超群 ";
				} else if (ubcv.getCc() >= defchips * 2) {
					label = "登峰造极 ";
				}
				if (!"".equals(label)) {// 发送赢利数据到客户端
					ubcv.setLab(label);
					LogicChannelUtil.sendToTargets(ubcv, Lists.newArrayList(op.getId().toString()));
				}
				if(ubcv.getCc()>0)
				{
					//LobbyUserHelper.updateUserSaveCost(op.getId(),ubcv.getCc(),1,"普通场游戏返回");
				}
				
				//LobbyUserHelper.updateUserFund(op.getId(),ubcv.getCc(),1,"普通场游戏返还");

			} else {
				LOGGER.error("call_p_back_chips data error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// DbUtils.close(rs);
			// DbUtils.close(stat);
			// DbUtils.close(conn);
		}
	}

	/**
	 * 开启服务器启停
	 */
	public static void startServerStop(long begintime, long endtime, long gametime, long matchtime) {
		ServerStopVo serverStopVo = LocalMatchCache.SERVER_STOP;
		serverStopVo.setStopserver(true);
		serverStopVo.setBegintime(begintime);
		serverStopVo.setEndtime(endtime);
		serverStopVo.setGametime(gametime);
		serverStopVo.setMatchtime(matchtime);
		serverStopVo.setStopgame(false);
		serverStopVo.setStopmatch(false);
		serverStopVo.setIsnoticeapp(false);
	}

	/**
	 * 停止服务启停
	 */
	public static void stopServerStop() {
		ServerStopVo serverStopVo = LocalMatchCache.SERVER_STOP;
		serverStopVo.setStopserver(false);
		serverStopVo.setBegintime(0l);
		serverStopVo.setEndtime(0l);
		serverStopVo.setGametime(0l);
		serverStopVo.setMatchtime(0l);
		serverStopVo.setStopgame(false);
		serverStopVo.setStopmatch(false);
		serverStopVo.setIsnoticeapp(false);
	}

}
