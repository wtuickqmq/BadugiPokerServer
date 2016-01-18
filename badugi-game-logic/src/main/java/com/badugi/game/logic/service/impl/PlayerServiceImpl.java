package com.badugi.game.logic.service.impl;

import io.nadron.client.event.Event;
import io.nadron.client.util.ObjectBeanUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badugi.game.logic.dao.UserFundDao;
import com.badugi.game.logic.dao.UsersDao;
import com.badugi.game.logic.helper.LobbyMsgHelper;
import com.badugi.game.logic.helper.LobbyUserHelper;
import com.badugi.game.logic.helper.UserMessageHelper;
import com.badugi.game.logic.model.cache.LocalCache;
import com.badugi.game.logic.model.cache.LocalMatchCache;
import com.badugi.game.logic.model.cache.MessageManager;
import com.badugi.game.logic.model.callback.LogicRequest;
import com.badugi.game.logic.model.callback.ProxyResponse;
import com.badugi.game.logic.model.callback.ProxyResponseBuilder;
import com.badugi.game.logic.model.callback.RPCReponse;
import com.badugi.game.logic.model.domain.vo.api.match.matchplayinfo.QuickVo;
import com.badugi.game.logic.model.domain.vo.flash.Definition;
import com.badugi.game.logic.model.domain.vo.flash.ResultVo;
import com.badugi.game.logic.model.domain.vo.flash.api.ShakeConfigVo;
import com.badugi.game.logic.model.domain.vo.flash.api.ShakeTypeVo;
import com.badugi.game.logic.model.domain.vo.flash.match.Match;
import com.badugi.game.logic.model.domain.vo.flash.match.MatchUser;
import com.badugi.game.logic.model.domain.vo.flash.match.TodayMatchs;
import com.badugi.game.logic.model.domain.vo.flash.operators.RoomLevels;
import com.badugi.game.logic.model.domain.vo.flash.operators.ServerstopResultVo;
import com.badugi.game.logic.model.domain.vo.flash.user.GameDetailVo;
import com.badugi.game.logic.model.domain.vo.flash.user.Invitations;
import com.badugi.game.logic.model.domain.vo.flash.user.InvitationsRoomVo;
import com.badugi.game.logic.model.domain.vo.flash.user.LoginVo;
import com.badugi.game.logic.model.domain.vo.flash.user.MsgSendVo;
import com.badugi.game.logic.model.domain.vo.flash.user.PlayerInfoInRoom;
import com.badugi.game.logic.model.domain.vo.flash.user.UserFundDetails;
import com.badugi.game.logic.model.domain.vo.flash.user.UserInRoom;
import com.badugi.game.logic.model.domain.vo.game.Rooms;
import com.badugi.game.logic.model.domain.vo.game.RoomsAsBB;
import com.badugi.game.logic.model.entity.Notices;
import com.badugi.game.logic.model.message.BetJewelOp;
import com.badugi.game.logic.model.message.BetShakeOp;
import com.badugi.game.logic.model.message.FlashLoginOp;
import com.badugi.game.logic.model.message.InvitationOp;
import com.badugi.game.logic.model.redis.RedisListSimple;
import com.badugi.game.logic.model.redis.RedisMapList;
import com.badugi.game.logic.model.redis.RedisMapMap;
import com.badugi.game.logic.model.redis.RedisMapSimple;
import com.badugi.game.logic.model.utils.common.DateUtils;
import com.badugi.game.logic.model.vo.api.match.MatchOp;
import com.badugi.game.logic.model.vo.flash.match.ChampionshipsVo;
import com.badugi.game.logic.model.vo.flash.match.MatchPlayDetailVo;
import com.badugi.game.logic.service.GameCarService;
import com.badugi.game.logic.service.PlayerService;
import com.badugi.game.logic.service.processtask.BetJewelTask;
import com.badugi.game.logic.service.processtask.BetShakeTask;
import com.badugi.game.logic.service.processtask.ChangeTableTask;
import com.badugi.game.logic.service.processtask.GetGameRoomInfoTask;
import com.badugi.game.logic.service.processtask.JoinGameRoomTask;
import com.badugi.game.logic.service.processtask.QuickJoinRooms;
import com.badugi.game.logic.service.processtask.ServerStopTask;
import com.badugi.game.logic.service.processtask.trackTask;
import com.badugi.game.logic.util.AppContext;
import com.badugi.game.logic.util.LogicChannelUtil;
import com.badugi.game.logic.util.LogicPropertyUtil;
import com.badugi.game.logic.util.MapUtils;
import com.google.common.collect.Lists;
import com.joker.game.common.constant.EventDefinition;
import com.joker.game.common.constant.RedisKeys;
import com.joker.game.db.redis.RedisLogin;
import com.joker.game.db.util.SpringUtils;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService {

	static final Logger LOGGER = LoggerFactory.getLogger(PlayerServiceImpl.class);
	static final String USER_INFO_CECHED_PRDFIX = "user.info.";

	@Autowired
	private RedisLogin redis;

	@Autowired
	private UserFundDao userFundDao;

	@Autowired
	private UsersDao usersDao;
	
	// Key:matchconfigId
	// Value:Match对象
	private Map<Integer, Match> matchMap = new HashMap<Integer, Match>();

	private RedisMapSimple<Integer, MatchPlayDetailVo> matchDetailMap = new RedisMapSimple<Integer, MatchPlayDetailVo>("MatchPlayDetail", Integer.class, MatchPlayDetailVo.class);

	private long lastUpdateTime = 0;	// 最后更新时间, 目的用于减少缓存压力

	@RPCReponse("e_test")
	public Object e_test(LogicRequest args) {
		return "hello world";
	}

	@Override
	@RPCReponse("e_login")
	public LoginVo login(LogicRequest args) {
		// ConcurrentHashMap<Long, PlayerInfoInSupremeRoom> inRoomQueue =
		// CarCache.PLAYER_INFO_IN_SUPREMEROOM;
		// System.out.println(inRoomQueue);
		FlashLoginOp rpcMap = null;
		try {
			rpcMap = ObjectBeanUtil.JACKSON.readValue(args.getData(), FlashLoginOp.class);
		} catch (IOException e) {
			LOGGER.warn("", e);
		}
		// Users uf = usersDao.get(rpcMap.getFbid());

		/*
		 * UserFundInfoVo users = LocalCache.USER_FUNDS.get(rpcMap.getFbid());
		 * if (users == null) {// 从本地调试或手机端登录的账，这里进入系统缓存 String imgurl = "";
		 * 
		 * imgurl = LobbyUserHelper.getFigureurl(rpcMap.getFbid(), null);
		 * 
		 * UserFund userFund = LobbyUserHelper.getUserFund(rpcMap.getFbid());//
		 * userFundDao.get(rpcMap.getFbid()); if (userFund != null) {
		 * userFund.setImgurl(imgurl); users =
		 * LobbyUserHelper.saveUserInfoToCache(userFund, false);
		 * 
		 * } }
		 */
		String userNick = null;
		RedisLogin redis = SpringUtils.getBean(RedisLogin.class);
		String uname = redis.hget(USER_INFO_CECHED_PRDFIX + rpcMap.getFbid(), "name");

		if (uname == null)
			userNick = "joker";
		else
			userNick = uname;

		List<TodayMatchs> matchs = null;// MatchService.getTodayMatchs();// 今日大赛
		// 返回值
		/**
		 * String cmd, long code, int isn, int isg, double gchips, long
		 * sessionid, String name, int lds, double ldcs, double ldms,
		 * List<TodayMatchs> matchs
		 */
		LoginVo vo = new LoginVo(Definition.LOGIN, Definition.SUCCESS_CODE, LobbyUserHelper.isLoginNewUser(rpcMap.getFbid()), userNick, matchs);
		String key = "";
		boolean isenablerk = true; // OptionUtils.convertToBoolean(OptionUtils.getDefaultOption("option.api.appkey.reload.enable",
									// "true"));
		if (isenablerk) {// 重连的时候需要重置sign
			key = UUID.randomUUID().toString();
			// LobbyUserHelper.updateUserSign(fbId, key);
		}
		vo.setKey(key);

		// 获取用户sessionid
		String sessionId = args.getSession();
		// 获取用户所在的映射服务器
		String targetMapping = redis.hget(RedisKeys.KEY_LOGIN_MAPPING, sessionId);

		if (null == targetMapping) // 没有登陆
		{
			String proxyId = LogicPropertyUtil.getString("proxy.id", "proxy1");
			String keyProxyMap = String.format(RedisKeys.KEY_LOGIN_PROXY, proxyId);
			// 保存映射
			redis.hset(RedisKeys.KEY_LOGIN_MAPPING, sessionId, String.format("%s@%s", proxyId, args.getChannelId()));
			redis.hset(keyProxyMap, args.getSession(), args.getChannelId());

		} else// 已经登陆
		{

			boolean isPlayGame = LobbyUserHelper.isPlay(Long.valueOf(sessionId)); // TODO
																					// 是否在游戏当中

			String[] mappingInfo = targetMapping.split("@");

			String targetRouter = mappingInfo[0];
			String targetChannelId = mappingInfo[1];
			if (isPlayGame) // 正在玩游戏
			{
				// TODO 通知当前通信的客户端下线
				vo = new LoginVo(Definition.LOGIN, Definition.REPEAT_CODE);
				return vo;

			} else {
				LoginVo event = new LoginVo(Definition.OTHERPLAYLOGIN, Definition.REPEAT_CODE);

				// 踢出前一个正在操作的对象
				ProxyResponse response = new ProxyResponse();
				response.setChannelId(targetChannelId);
				response.setSession(sessionId);
				response.setReponse(event);
				response.setIsRoute(1);
				response.setProxy(targetRouter);
				Event responseEvent = io.nadron.client.event.Events.dataInEvent(ProxyResponseBuilder.build(response));
				LogicChannelUtil.writeObjectToChannel(responseEvent);
				// 保存映射关系
				String proxyId = LogicPropertyUtil.getString("proxy.id");
				String keyProxyMap = String.format(RedisKeys.KEY_LOGIN_PROXY, proxyId);
				// 保存映射
				redis.hset(RedisKeys.KEY_LOGIN_MAPPING, sessionId, String.format("%s@%s", proxyId, args.getChannelId()));
				redis.hset(keyProxyMap, args.getSession(), args.getChannelId());

			}
			LobbyUserHelper.deleteAllUserInRoom(sessionId);
		}
		LobbyUserHelper.sendJewelBoxMoneyFromData(sessionId);

		// 发送公告
		Notices n = LobbyMsgHelper.getLastNotice();
		if (n != null && System.currentTimeMillis() < n.getEndTime().getTime()) {
			MsgSendVo msgvo = new MsgSendVo(Definition.NOTICES, n.getContent(), DateUtils.dateToString(new Date(n.getOperatedTime().getTime()), DateUtils.PATTERN_YMDHMS));
			// 发送
			LogicChannelUtil.sendToTargets(msgvo, Lists.newArrayList(sessionId));
		}
		//
		return vo;
	}

	@Override
	@RPCReponse("e_gametype")
	public ResultVo getGameType(LogicRequest args) {
		// TODO 自动生成的方法存根
		FlashLoginOp op = null;
		try {
			op = ObjectBeanUtil.JACKSON.readValue(args.getData(), FlashLoginOp.class);
		} catch (IOException e) {
			LOGGER.warn("", e);
		}
		List list = new ArrayList();
		ResultVo vo = new ResultVo(Definition.ROOMLEVEL, Definition.SUCCESS_CODE, op.getFlag(), list);
		return vo;
	}

	@Override
	@RPCReponse("e_roomlevels")
	public ResultVo getRoomLevels(LogicRequest args) {

		// TODO 自动生成的方法存根
		FlashLoginOp op = null;
		try {
			op = ObjectBeanUtil.JACKSON.readValue(args.getData(), FlashLoginOp.class);
			// LogicChannelUtil.broadcast(ObjectBeanUtil.readValueAsMap("{\"hello\":\"welcome\"}",
			// String.class, String.class)
			// ,Lists.newArrayList(op.getFbid().toString()));
			// LogicChannelUtil.broadcast(ObjectBeanUtil.readValueAsMap("{\"hello\":\"welcome\"}",
			// String.class, String.class) ,null);
		} catch (IOException e) {
			LOGGER.warn("", e);
		}
		List<RoomLevels> list = new ArrayList<RoomLevels>();
		// 查询出房间等级，填充到list
		Iterator iter = LocalCache.ROOM_LEVELS.entrySet().iterator(); // 获得map的Iterator
		RoomLevels level = null;
		while (iter.hasNext()) {
			Entry entry = (Entry) iter.next();
			level = (RoomLevels) entry.getValue();
			if (op.getGt() == level.getGt()) {
				list.add(level);
			}
		}
		ResultVo vo = new ResultVo(Definition.ROOMLEVEL, Definition.SUCCESS_CODE, list);
		return vo;
	}

	@Override
	@RPCReponse("e_rooms")
	public ResultVo getRooms(LogicRequest args) {
		// TODO 自动生成的方法存根

		Map<Integer, Object> _count = null;
		Map<Long, PlayerInfoInRoom> omIds = null;
		// 查询更新房间，填充到list
		FlashLoginOp op = null;
		try {
			op = ObjectBeanUtil.JACKSON.readValue(args.getData(), FlashLoginOp.class);
		} catch (IOException e) {
			LOGGER.warn("", e);
		}
		// 保存节点记录
		if (op.getGl() > 0) {
			if (op.getGl() == 1) {
				// LobbyUserHelper.saveUserNodeLog(fbid,
				// UserNodeLog.USER_NODE_TALBE_LOW, 0);
			} else if (op.getGl() == 2) {
				// LobbyUserHelper.saveUserNodeLog(fbid,
				// UserNodeLog.USER_NODE_TALBE_MID, 0);
			} else if (op.getGl() == 3) {
				// LobbyUserHelper.saveUserNodeLog(fbid,
				// UserNodeLog.USER_NODE_TALBE_HIG, 0);
			}
		}

		// 显示最大空座数
		Integer maxEmptyLevelRoom = LogicPropertyUtil.getInteger("option.max.empty.level.room", 1);

		Map<String, Map<Integer, Integer>> emptyLevelRoom = new HashMap<String, Map<Integer, Integer>>();// 某个房间等级下几人场空的房间
		Map<Double, Map<Integer, Integer>> lock = new HashMap<Double, Map<Integer, Integer>>();// 小盲对应的锁
		// 通过roomId比较排序
		Map<String, Rooms> sortRooms = MapUtils.sortKey(LocalCache.ROOMS);
		Iterator iter = sortRooms.entrySet().iterator(); // 获得map的Iterator
		Map<Integer, Integer> mc = null;
		ResultVo vo = null;

		if (op.getGt() == 1) {// 简洁
								// ----------------------------------1----------------------------------
			Rooms room = null;
			Map<String, RoomsAsBB> roomlist = new HashMap<String, RoomsAsBB>();
			List<RoomsAsBB> list = new ArrayList<RoomsAsBB>();

			while (iter.hasNext()) {
				try {
					Entry entry = (Entry) iter.next();
					room = (Rooms) entry.getValue();

					if (op.getGt() == room.getGl()) {
						omIds = LocalCache.PLAYER_ON_ROOM.get(room.getRid());
						room.setCc(omIds == null ? 0 : omIds.size());

						RoomsAsBB rbb = roomlist.get(room.getGid());
						if (rbb != null) {
							rbb.setCc(rbb.getCc() + room.getCc());
						} else {
							rbb = new RoomsAsBB();
							rbb.setGr(room.getGid());
							rbb.setSb(room.getSb());
							rbb.setBb(room.getBb());
							rbb.setDefc(room.getDefc());
							rbb.setCc(room.getCc());
							rbb.setRn("");
						}
						roomlist.put(room.getGid(), rbb);

					}

				} catch (Exception e) {
					// TODO: handle exception
				}
			}

			if (roomlist.size() > 0) {

				Iterator<Entry<String, RoomsAsBB>> riter = roomlist.entrySet().iterator();
				while (riter.hasNext()) {
					try {
						Map.Entry<String, RoomsAsBB> entry = riter.next();

						RoomsAsBB rbb = entry.getValue();
						list.add(rbb);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}

			}
			vo = new ResultVo(Definition.ROOMS, Definition.SUCCESS_CODE, list, op.getGt());

		} else if (op.getGt() == 2) {// 复杂
										// --------------------------------2-----------------------------------
			List<Rooms> list = new ArrayList<Rooms>();

			Rooms room = null;
			while (iter.hasNext()) {
				try {
					Entry entry = (Entry) iter.next();
					room = (Rooms) entry.getValue();
					if (op.getGl() == 0 || op.getGl() == room.getGl()) {
						omIds = LocalCache.PLAYER_ON_ROOM.get(room.getRid());
						room.setCc(omIds == null ? 0 : omIds.size());

						// 状态类型筛选
						if (op.getSt() > 0) {
							if (op.getSt() == 5) {// 隐藏满员桌
								if (room.getCc() == room.getMc()) {
									continue;
								}
							} else if (op.getSt() == 6) {// 隐藏空桌
								if (room.getCc() == 0) {
									continue;
								}
							} else if (op.getSt() == 56) {// 满足上面两个情况
								if (room.getCc() == room.getMc() || room.getCc() == 0) {
									continue;
								}
							}
						}

						// 记录空房间数量
						if (omIds == null || omIds.size() == 0) {
							if (emptyLevelRoom.containsKey(room.getGid())) {
								mc = emptyLevelRoom.get(room.getGid());
								if (mc != null && mc.containsKey(room.getMc())) {
									mc.put(room.getMc(), mc.get(room.getMc()) + 1);
								} else {
									mc = new HashMap<Integer, Integer>();
									mc.put(room.getMc(), 1);
								}
								emptyLevelRoom.put(room.getGid(), mc);
							} else {
								mc = new HashMap<Integer, Integer>();
								mc.put(room.getMc(), 1);
								emptyLevelRoom.put(room.getGid(), mc);
							}

							// 空房间数量是否超过设置
							if (mc.get(room.getMc()) > maxEmptyLevelRoom) {
								continue;
							}
						}
						/*
						 * if(omIds != null && omIds.size() > 0){ _count =
						 * getAp(room.getRid());
						 * room.setAp(Double.valueOf(_count.get
						 * (0).toString()).intValue());
						 * room.setFr(Double.valueOf(_count
						 * .get(1).toString()).intValue());
						 * room.setRh(Integer.valueOf
						 * (_count.get(2).toString())); }else{ room.setAp(0D);
						 * room.setFr(0D); room.setRh(0);
						 * LobbyCache.GAME_ROOMS_END.remove(room.getRid()); }
						 * room.setSt(omIds != null && omIds.containsKey(fbid) ?
						 * true : false); //锁 Map<Integer,Integer> lockroom =
						 * null; if(lock.containsKey(room.getSb())){ lockroom =
						 * lock.get(room.getSb()); }else{ lockroom =
						 * LobbyUserHelper.getRoomLock(fbid, room.getSb(),
						 * room.getBb()); lock.put(room.getSb(), lockroom); }
						 * room.setClk(lockroom.get(0));
						 * room.setLk(lockroom.get(1));
						 */
						if (room.getCc() > room.getMc()) {// 出现不同步的情况下应急处理
							room.setCc(room.getMc());
						}
						list.add(room);
					}
				} catch (Exception e) {
					break;
				}
			}
			vo = new ResultVo(Definition.ROOMS, Definition.SUCCESS_CODE, list, op.getGl());

		} else if (op.getGt() == 3) {// 比赛
										// ---------------------------------3-------------------------------
		}

		return vo;
	}

	@Override
	@RPCReponse("e_joinrooms")
	public ResultVo joinGameRoom(LogicRequest args) {
		// TODO 自动生成的方法存根
		ResultVo vo = null;
		Long fbid = null;
		vo = (new JoinGameRoomTask()).Task(args);
		return vo;
	}

	@Override
	@RPCReponse("e_gamedetail")
	public GameDetailVo getGameRoomInfo(LogicRequest args) {
		// TODO 自动生成的方法存根
		GameDetailVo vo = null;
		Long fbid = null;
		vo = (new GetGameRoomInfoTask()).Task(args);
		return vo;
	}

	@Override
	@RPCReponse("e_logout")
	public void logout(LogicRequest args) {
		String channelId = args.getChannelId();
		String sessionId = args.getSession();

		AppContext.getBean(GameCarService.class).removeUser(sessionId);

		String proxyId = LogicPropertyUtil.getString("proxy.id");
		String keyProxyMap = String.format(RedisKeys.KEY_LOGIN_PROXY, proxyId);

		String targetMapping = redis.hget(RedisKeys.KEY_LOGIN_MAPPING, sessionId);
		if (null != targetMapping) {
			String[] mappingInfo = targetMapping.split("@");
			String targetRouter = mappingInfo[0];
			String targetChannelId = mappingInfo[1];
			if (proxyId.equals(targetRouter) && targetChannelId.equals(channelId)) {
				// 删除登陆记录
				redis.hdel(RedisKeys.KEY_LOGIN_MAPPING, sessionId);
			}
		}

		String oldChannelId = redis.hget(keyProxyMap, sessionId);
		if (null != oldChannelId && oldChannelId.equals(channelId)) {
			// 删除登陆记录
			redis.hdel(keyProxyMap, sessionId);
		}

	}

	@Override
	@RPCReponse("e_fastplay")
	public ResultVo Quick_Game(LogicRequest args) {
		ResultVo vo = null;
		
		LobbyUserHelper.checkStopGame();
		ServerstopResultVo srv = (new ServerStopTask()).isServerStop();
		if (srv == null) {
			QuickVo op = null;
			try {
				op = ObjectBeanUtil.JACKSON.readValue(args.getData(), QuickVo.class);
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
			QuickJoinRooms jr = new QuickJoinRooms();
			return jr.task(op);
		} else {
			return srv;
		}
	}

	@Override
	@RPCReponse("e_getshakeconfig")
	public ResultVo getShakeConfig(LogicRequest args) {
		ResultVo vo = null;

		Map<String, Class> classes = new HashMap<String, Class>();
		classes.put("list", ShakeTypeVo.class);
		// {"maxb":200,"minb":100,"list":
		// [{"type":1,"chip":200},{"type":2,"chip":2000},{"type":3,"chip":20000},{"type":4,"chip":200000},{"type":5,"chip":2000000}]}
		String bsconfig = "{\"maxb\":200,\"minb\":100,\"list\": [{\"type\":1,\"chip\":200},{\"type\":2,\"chip\":2000},{\"type\":3,\"chip\":20000},{\"type\":4,\"chip\":200000},{\"type\":5,\"chip\":2000000}]}";// LogicPropertyUtil.getString("option.texas.shake");

		try {

			ShakeConfigVo svo = ObjectBeanUtil.JACKSON.readValue(bsconfig, ShakeConfigVo.class);
			svo.setCmd(Definition.SHAKECONFIG);
			svo.setCode(Definition.SUCCESS_CODE);
			return svo;
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

		return vo;
	}

	@Override
	@RPCReponse("e_betshake")
	public ResultVo betShake(LogicRequest args) {
		ResultVo vo = null;
		try {
			BetShakeOp op = ObjectBeanUtil.JACKSON.readValue(args.getData(), BetShakeOp.class);
			if (op.getUid() != null && op.getUid().toString().trim().equals(args.getSession()))
				vo = (new BetShakeTask(op)).Task();
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
		return vo;
	}

	@Override
	@RPCReponse("e_betjewelbox")
	public ResultVo betJewelBox(LogicRequest args) {
		ResultVo vo = null;
		try {
			BetJewelOp op = ObjectBeanUtil.JACKSON.readValue(args.getData(), BetJewelOp.class);
			if (op.getUid() != null && op.getUid().toString().trim().equals(args.getSession())) {
				vo = (new BetJewelTask()).Task(op);
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
		return vo;
	}

	@Override
	@RPCReponse("e_getoffrooms")
	public ResultVo getOffRooms(LogicRequest args) {
		// TODO 自动生成的方法存根
		ResultVo vo = null;
		Long fbid = null;
		try {
			FlashLoginOp op = ObjectBeanUtil.JACKSON.readValue(args.getData(), FlashLoginOp.class);
			if (op != null) {
				fbid = op.getFbid();
				List<UserInRoom> resultList = new ArrayList<UserInRoom>();
				List<UserInRoom> userInRoomList = LocalCache.USER_IN_ROOM.get(String.valueOf(op.getFbid()));// 普通房间
				if (userInRoomList != null) {
					UserInRoom inRoom = null;
					Rooms room = null;
					for (int i = 0; i < userInRoomList.size(); i++) {
						inRoom = userInRoomList.get(i);
						if (inRoom.getIsSit() == 1 || inRoom.getIsSit() == 2) {
							room = LocalCache.getRoom(inRoom.getRid());
							if (room != null) {
								inRoom.setGt(room.getGt());
								// 强制更新
								userInRoomList.set(i, inRoom);
							}
							resultList.add(inRoom);
						}
					}
				}
				// 技术债务, 比赛房间断线重连
				RedisMapMap<Integer /*playerId*/, UserInRoom> roomMapCache = new RedisMapMap<Integer /*playerId*/, UserInRoom>("matchroom", Integer.class, UserInRoom.class);
				RedisMapSimple<Integer /*roomId*/, UserInRoom> roommap = roomMapCache.get(op.getFbid());
				if (null != roommap) {
					for (UserInRoom inRoom : roommap.values()) {
						resultList.add(inRoom);
					}
				}

//				List<UserInRoom> matchUserInRoomList = LocalMatchCache.MATCH_USER_IN_ROOM.get(String.valueOf(op.getFbid()));// 比赛房间
//				if (matchUserInRoomList != null) {
//					UserInRoom inRoom = null;
//					for (int i = 0; i < matchUserInRoomList.size(); i++) {
//						inRoom = matchUserInRoomList.get(i);
//						if (inRoom.getIsSit() == 1 || inRoom.getIsSit() == 2) {
//							Match match = LocalMatchCache.MATCHS.get(inRoom.getMi());
//							if (match != null) {
//								MatchUser mu = match.getUsers().get(op.getFbid());
//								if (mu != null && mu.getRanking() == 0) {// 没有淘汰
//									resultList.add(inRoom);
//								}
//							}
//						}
//					}
//				}
				// 成功
				vo = new ResultVo(Definition.GETOFFROOMS, Definition.SUCCESS_CODE, resultList);
			} else {
				vo = new ResultVo(Definition.GETOFFROOMS, Definition.ARG_CODE, null);
				// Logger.error("deal with getoffroom arg error!!!");
			}
		} catch (Exception e) {
			vo = new ResultVo(Definition.GETOFFROOMS, Definition.UNKNOW_CODE, null);
			// Logger.error("deal with getoffroom error  !!!",e);
		}

		return vo;
	}

	/**
	 * 邀请好友列表
	 * 
	 * @param args
	 * @return
	 */
	@RPCReponse("e_invitation_list")
	public ResultVo invitationlist(LogicRequest args) {
		ResultVo vo = null;
		Long uid = null;
		try {
			FlashLoginOp op = ObjectBeanUtil.JACKSON.readValue(args.getData(), FlashLoginOp.class);
			if (op != null) {
				uid = op.getFbid();
			}

			if (uid == null || uid <= 0) {
				vo = new ResultVo(Definition.GET_INVITATIONS_LIST, Definition.ARG_CODE);
				return vo;
			}

			List<Invitations> relations = LobbyUserHelper.getInvitationUser(uid.toString());
			vo = new ResultVo(Definition.GET_INVITATIONS_LIST, Definition.SUCCESS_CODE, relations);

		} catch (Exception e) {
			vo = new ResultVo(Definition.GET_INVITATIONS_LIST, Definition.UNKNOW_CODE);

		}
		return vo;
	}

	/**
	 * 邀请好友
	 * 
	 * @param args
	 */
	@RPCReponse("e_invitation")
	public void invitation(LogicRequest args) {
		Long uid;// 用户id
		Long rid;// 房间id
		List<String> list;// 好友id列表
		List<String> onlinelist = new ArrayList<String>();
		try {
			InvitationOp op = ObjectBeanUtil.JACKSON.readValue(args.getData(), InvitationOp.class);
			if (op != null) {
				uid = op.getUid();
				rid = op.getRid();
				list = op.getList();
				String uName = "";
				String roomName = "";
				UserFundDetails uinfo = LobbyUserHelper.getUserInfo(uid);
				uName = uinfo.getNn();
				Rooms r = LocalCache.ROOMS.get(rid.toString());
				if (r != null) {
					roomName = r.getRn();
				}
				InvitationsRoomVo iRV = new InvitationsRoomVo(Definition.INVITATIONS, Definition.SUCCESS_CODE, rid, roomName, uid, uName);
				System.out.println(list);
				if (list != null && list.size() > 0) {
					Iterator itr = list.iterator();
					while (itr.hasNext()) {
						Long otherId = Long.valueOf(itr.next().toString());
						if (LobbyUserHelper.isLobby(otherId)) {// 大厅中存在该用户

							// 建立消息通道

							onlinelist.add(otherId.toString());

							// 存储消息邮件
							UserMessageHelper.Message message = new UserMessageHelper.Message();
							message.setTitle("牌局邀请");
							message.setContent(iRV.toString());
							message.setType(MessageManager.Type.INT.getValue());
							message.setSubtype(MessageManager.Subtype.interaction.getValue());
							UserMessageHelper.insertUserMessage(otherId, message);

							// MessageSendUtil.sendAddUserMsgTipToUser(otherId);//更新TOP菜单栏消息提示
							LobbyUserHelper.sendMsgTips(uid);

						}
					}

					LogicChannelUtil.sendToTargets(iRV, onlinelist);

				}

			}
		} catch (Exception e) {
			LOGGER.error("", e);
			e.printStackTrace();
		}

	}

	@RPCReponse(EventDefinition.EVENT_MIN_CHIPS)
	public void e_havechips(LogicRequest args) {
		// MinChipsResultVo vo = null;
		// try {
		// QuickVo op = (QuickVo) JsonUtils.json2Object(msg, QuickVo.class);
		// List<Double> funds = LobbyUserHelper.getUserPlayFund(op.getFbid());//
		// 游戏未返还和报名比赛未开始的金额
		// Double nchips = 0D;
		// for (int i = 0; i < funds.size(); i++) {
		// nchips = MathExtendUtils.add(nchips, funds.get(i));
		// }
		// // 是否需要赠送
		// LobbyUserHelper.presentChips(op.getFbid(), 1);
		// // 赠送完之后判断用户金额是否够补足
		// UserFund uf = LobbyUserHelper.getUserFund(op.getFbid());
		// nchips = MathExtendUtils.add(uf.getChips(), nchips);
		// // 是否有钱进最低可进入场
		// Double min =
		// Double.valueOf(ConfigUtils.getConfigJsonString("min_chips_common_room"));
		// vo = new MinChipsResultVo(Definition.HAVECHIPS,
		// Definition.SUCCESS_CODE, nchips, min);
		// if (nchips < min) {// 当用户金额小于最小场的时候进入获取筹码页
		// LobbyUserHelper.saveUserNodeLog(op.getFbid(),
		// UserNodeLog.USER_NODE_GETCHIPS, new Long(op.getSessionid()), (short)
		// 0);
		// }
		// }
		// catch (Exception e) {
		// vo = new MinChipsResultVo(Definition.HAVECHIPS,
		// Definition.UNKNOW_CODE);
		// Logger.error("deal with min chips error  !!!", e);
		// }
		// return vo;

	}

	@RPCReponse("e_getjewelchips")
	public void getJewelBoxChips(LogicRequest args) {
		// TODO 自动生成的方法存根
		String sessionId = args.getSession();
		LobbyUserHelper.sendJewelBoxMoneyFromData(sessionId);

	}

	@RPCReponse("e_changetable")
	public ResultVo changeTable(LogicRequest args) {
		// TODO 自动生成的方法存根
		String sessionId = args.getSession();
		LobbyUserHelper.sendJewelBoxMoneyFromData(sessionId);

		ResultVo vo = (new ChangeTableTask()).Task(args);
		return vo;
	}
	
	@RPCReponse("e_track")
	public ResultVo track(LogicRequest args) {
		// TODO 自动生成的方法存根
		String sessionId = args.getSession();
		
		ResultVo vo= (new trackTask()).Task(args);
		return vo;
	}
	
	
	
	//------------------------------------以下为比赛接--------------------------------------
	
	
	
	
	/**
	 * 打开比赛详情面板
	 * 
	 * @param logicRequest
	 */
	@RPCReponse(EventDefinition.EVENT_LOOKMATCHDETAIL)
	public Object e_LookMatchDetail(LogicRequest logicRequest) {

		try {
			// 1. 读取用户数据
			MatchOp packet = ObjectBeanUtil.JACKSON.readValue(logicRequest.getData(), MatchOp.class);
			Long fbid=packet.getFbid();
			int matchconfigId = packet.getMi();

			if (matchDetailMap.containsKey(matchconfigId) == false) return null;

			// 返回比赛详情信息
			return matchDetailMap.get(matchconfigId);
			
		} catch (Exception e) {
		}

		return null;
	}
	
	/**
	 * 获取比赛类型(废弃)
	 * 
	 * @param logicRequest
	 */
	@RPCReponse(EventDefinition.EVENT_MATCHTYPE)
	public ResultVo e_matchtype(LogicRequest logicRequest) {

		try {
			//MatchOp op = (MatchOp)JsonUtils.json2Object(msg, MatchOp.class);
			// List<MatchType> list = matchTypeMap.get(op.getGt());
			// vo = new ResultVo(Definition.MATCHTYPES, Definition.SUCCESS_CODE, list);
		} catch (Exception e) {
		}
		
		return null;
	}

	/**
	 * 大厅比赛等级信息(废弃)
	 * 
	 * @param logicRequest
	 */
	@RPCReponse(EventDefinition.EVENT_GET_MATCH_LEVELS)
	public ResultVo e_matchlevels(LogicRequest logicRequest) {
		return null;
	}

	/**
	 * 大厅比赛信息
	 * 
	 * @param logicRequest
	 */
	@RPCReponse(EventDefinition.EVENT_GET_MATCH)
	public ResultVo e_matchlists(LogicRequest logicRequest) {
		return null;
	}

	// 更新比赛缓存数据
	private void updateMatchCacheData() {
		Date now = new Date();
		long nowtime = now.getTime();

		long resultminute = (nowtime - lastUpdateTime)/(1000*60);
		if (resultminute < 1) return;	// 每次更新时间不得小于1分钟

		RedisListSimple<Match> matchInfo = new RedisListSimple<Match>("matchmanager_server", Match.class);
		List<Match> matchlist = matchInfo.getAll();	// 获取所有列表数据
		for (Match match : matchlist) {
			// 更新内存数据
			matchMap.put(match.getConfId(), match);
		}
	}

	/**
	 * 大厅比赛列表信息获取
	 * 
	 * @param logicRequest
	 */
	@RPCReponse(EventDefinition.EVENT_GET_CMATCH)
	public ResultVo e_championships(LogicRequest args) {

		ResultVo resultvo = null;	// 返回值
		List<ChampionshipsVo> resultList = new ArrayList<ChampionshipsVo>();		
		try {
			// 1. 读取用户数据
			MatchOp packet = ObjectBeanUtil.JACKSON.readValue(args.getData(), MatchOp.class);
			Long fbid=packet.getFbid();
			int gt = packet.getGt();	// 一级分类
			int mt = packet.getMt();	// 比赛类型
			int ml = packet.getMl();	// 比赛等级
			
			Map<Integer,Integer> emptyMatch = new HashMap<Integer, Integer>();	//空比赛<类型ID，count>

			// 更新缓存数据
			updateMatchCacheData();

			// 从缓存获取比赛列表信息
			for (Entry<Integer, Match> entry : matchMap.entrySet()) {
				Match match = entry.getValue();

				//如果为定时赛开放登记时间不到不显示
				Date beginTime = match.getBt();
				if( beginTime != null && System.currentTimeMillis() < beginTime.getTime()) continue;

				if(match.getIsOn() == false) continue;
				if(gt != match.getGt()) continue;
				if(mt != 0 && match.getMt() != mt) continue;
				if(ml != 0 && match.getMl() != ml) continue;
				//if(match.getEt() > 0) continue;	// 设置显示空桌

				if(match.getSt() == Match.MATCH_STATUS_OPEN) {
					if(emptyMatch.containsKey(match.getConfId()))
						emptyMatch.put(match.getConfId(), emptyMatch.get(match.getConfId()) + 1);
					else
						emptyMatch.put(match.getConfId(), 1);
					
					if(emptyMatch.get(match.getConfId()) > match.getEt())//超过预留空座不添加到集合
						continue;
				}

				if(match.getSpt()!=null&&match.getSpt().getTime()<=System.currentTimeMillis()&&Match.MATCH_STATUS_DOING!=match.getSt()&&Match.MATCH_STATUS_OVER!=match.getSt())
					match.setSt(Match.MATCH_STATUS_ENDREGISTER);//报名截止

				//状态筛选
				boolean it = isJoinMatch(match.getConfId(), fbid);
				if(packet.getSt() > -1) {
					if(packet.getSt() == 11){//已登记
						if(it != true || match.getSt()==Match.MATCH_STATUS_OVER)//未登记和已结束
							continue;
					} else if(packet.getSt() != match.getSt()) {
						continue;
					}
				}

				String pattern = "yyyy-MM-dd HH:mm";
				String spt = match.getSpt() != null ? (new SimpleDateFormat(pattern)).format(match.getSpt()) : "";
				String stt = match.getStt() != null ? (new SimpleDateFormat(pattern)).format(match.getStt()) : "";
				double aa = match.getMnc() * add(match.getMa(), -match.getFwc(), -match.getRc());

				if(isToday(match.getSpt()))
					spt="今天  "+String.copyValueOf(spt.toCharArray(), 11, 5);
				if(isToday(match.getStt()))
					stt="今天  "+String.copyValueOf(stt.toCharArray(), 11, 5);

				// 计算比赛开始时间，（秒）
				long now = System.currentTimeMillis();//报名截止时间
				int lst = Integer.parseInt(String.valueOf((match.getSpt().getTime() - now) / 1000));// 分钟
				
				//是否为密码房间
				boolean ispwd=!"".equals(match.getPwd());
				ChampionshipsVo mvo = new ChampionshipsVo(match.getMi(),match.getMn(),match.getSp(),match.getMa(),match.getSt(),match.getMc(),match.getMnc(),match.getMt(),match.getMl(),
						String.valueOf(match.getMc()),spt,stt,aa,lst,ispwd,match.getJfc(),match.getFwc(),match.getRc());
				mvo.setMatchServerId(match.getMatchServerId());
				//我的参赛状态
				mvo.setIt(it ? 1 : 0);
				//奖品图片路径
				mvo.setPin(match.getToprcfg());
				mvo.setSv(match.getConfId());
				//是否为坐满就玩
				if(match.getUct() == 0)
					mvo.setGs(1);
				//Logger.info("cv:"+mvo);
				resultList.add(mvo);
			}
		} catch (Exception e) {
			//LOGGER.error("大厅比赛列表信息获取 error !!!",e);
			e.printStackTrace();
			resultvo = new ResultVo("championships", /*Definition.UNKNOW_CODE*/29999L);
		}

		resultvo = new ResultVo("championships", Definition.SUCCESS_CODE, resultList);
		return resultvo;
	}
	
	public boolean isToday(java.util.Date aDate) {
		final Date now = new Date();
		if (aDate != null) {
			String nowtime = (new SimpleDateFormat("yyyyMMdd")).format(now).toString();
			String createtime = (new SimpleDateFormat("yyyyMMdd")).format(aDate).toString();
			return nowtime.equals(createtime);
		}
		else {
			return false;
		}
	}
	
	public double add(double...ds) {
		BigDecimal b = BigDecimal.ZERO;
		for(double d:ds){
			b=b.add(BigDecimal.valueOf(d));
		}
		return b.doubleValue();
	}
	
	// 玩家是否加入指定比赛
	public boolean isJoinMatch(Integer matchconfigId, Long fbid) {
	
		RedisMapSimple<Integer, String> matchPlayerMap =  new RedisMapSimple<Integer, String>("matchplayer"+matchconfigId, Integer.class, String.class);
		if (matchPlayerMap.containsKey(fbid)) return true;
		
		return false;
		
	}

}
