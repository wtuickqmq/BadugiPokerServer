package com.badugi.game.logic.helper;

import io.nadron.client.util.ObjectBeanUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.dao.UsersDao;
import com.badugi.game.logic.model.cache.LocalCache;
import com.badugi.game.logic.model.cache.LocalMatchCache;
import com.badugi.game.logic.model.domain.vo.api.match.matchplayinfo.QuickVo;
import com.badugi.game.logic.model.domain.vo.flash.api.JewelBoxVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.JewelBoxListVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.ServerStopVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.SysConfigVo;
import com.badugi.game.logic.model.domain.vo.flash.user.Invitations;
import com.badugi.game.logic.model.domain.vo.flash.user.PlayerInfoInRoom;
import com.badugi.game.logic.model.domain.vo.flash.user.UserChipsChangeVo;
import com.badugi.game.logic.model.domain.vo.flash.user.UserFundDetails;
import com.badugi.game.logic.model.domain.vo.flash.user.UserInRoom;
import com.badugi.game.logic.model.domain.vo.game.Rooms;
import com.badugi.game.logic.model.domain.vo.poker.PokerMsgVo;
import com.badugi.game.logic.model.entity.GameCost;
import com.badugi.game.logic.model.entity.GameUserlog;
import com.badugi.game.logic.model.entity.UserFund;
import com.badugi.game.logic.model.vo.flash.Definition;
import com.badugi.game.logic.model.vo.robot.RobotVo;
import com.badugi.game.logic.util.AppContext;
import com.badugi.game.logic.util.DateUtils;
import com.badugi.game.logic.util.LogicChannelUtil;
import com.badugi.game.logic.util.LogicPropertyUtil;
import com.badugi.game.logic.util.MapUtils;
import com.google.common.collect.Lists;
import com.joker.common.util.StringUtil;
import com.joker.game.common.constant.RedisKeys;
import com.joker.game.db.redis.RedisLogin;
import com.joker.game.db.util.SpringUtils;

/**
 * @author wtu.edit
 * @date 2015年9月18日
 * @version qq1.0
 * @email wtuickqmq@163.com
 */
public class LobbyUserHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(LobbyUserHelper.class);

	/**
	 * 返回用户头像URL
	 */
	public static String getFigureurl(Long fbid, String pf) {
		String url = null;
		/*
		 * Connection conn = null; Statement stat = null; ResultSet rs = null;
		 * try { String sql = "SELECT figureurl FROM user_basic WHERE userid=" +
		 * fbid; if (pf != null && !pf.equals("")) { sql += " and pf='" + pf +
		 * "'"; } Logger.info("-----------------getFigureurl----sql:" + sql);
		 * conn = DbUtils.getConnection(); stat = conn.createStatement(); rs =
		 * stat.executeQuery(sql.toString()); while (rs.next()) { url =
		 * rs.getString(1); } if (LobbyCache.USER_FUNDS.containsKey(fbid)) {
		 * LobbyCache.USER_FUNDS.get(fbid).setImgurl(url); } } catch (Exception
		 * e) { Logger.error("getFigureurl error:" + e.getMessage(), e); }
		 * finally { DbUtils.close(rs); DbUtils.close(stat);
		 * DbUtils.close(conn); }
		 */
		return url;
	}

	/**
	 * 只返回fbid,fbname,chips,expvalue,currvipvalue,vippoints,viplevel,isrobot,
	 * logindays
	 */
	public static UserFund getUserFund(Long fbId) {

		UserFund uf = new UserFund();

		try {

			// StringBuffer sql = new
			// StringBuffer("SELECT u.fbid,u.fbname,uf.chips,uf.exp,uf.bill,uf.points,uc.viplv,u.IsRobot,u.LoginDays,uc.praise_count,u.RegTime,u.city,");
			// sql.append("u.Sex,uc.round_max_chips,uc.max_chips,uc.vip_valid_time ");
			// sql.append(" FROM users u,user_count uc,user_fund uf");
			// sql.append(" WHERE uf.u_id=u.fbid and uc.u_id=u.fbid and u.fbid="
			// + fbId);
			StringBuffer sql = new StringBuffer("SELECT u.u_id,u.nickname,u.figureurl,uf.chips,uf.exp,uf.bill,uf.points,u.is_robot,uc.praise_count,u.reg_time,u.city,");
			sql.append(" u.gender,uc.round_max_chips,uc.max_chips");
			sql.append(" FROM user_info u,user_count uc,user_fund uf");
			sql.append(" WHERE uf.u_id=u.u_id and uc.u_id=u.u_id and u.u_id=" + fbId);

			List<Map<String, Object>> rs = AppContext.getBean(UsersDao.class).querySQLListWithMap(sql.toString());

			Iterator<Map<String, Object>> itr = rs.iterator();
			if (itr.hasNext()) {
				Map<String, Object> map = itr.next();
				uf = ObjectBeanUtil.JACKSON.convertValue(map, UserFund.class);
				if (map.containsKey("is_robot")) {
					uf.setIsRobot(Integer.valueOf(map.get("is_robot").toString()));
				}
				if (map.containsKey("figureurl")) {
					uf.setImgurl(map.get("figureurl").toString());
				}
				if (map.containsKey("exp")) {
					uf.setExp(Double.valueOf(map.get("exp").toString()));
				}
				if (map.containsKey("bill")) {
					uf.setBill(Integer.valueOf(map.get("bill").toString()));
				}
				if (map.containsKey("nickname")) {
					uf.setFbname(map.get("nickname").toString());
				}
				if (map.containsKey("u_id")) {
					uf.setFbid(Long.valueOf(map.get("u_id").toString()));
				}
				if (map.containsKey("chips")) {
					uf.setChips(Double.parseDouble(map.get("chips").toString()));
				}
			}

			// Logger.info(uf.getFbId()+" "+uf.getFbName());
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("getUserFund error " + e.getMessage());
		} finally {

		}
		return uf;
	}

	/**
	 * 用户是否在游戏中
	 */
	public static boolean isPlay(Long fbId) {
		boolean isPlay = false;
		try {
			List<UserInRoom> userInRoomList = LocalCache.USER_IN_ROOM.get(String.valueOf(fbId));// 普通房间
			if (userInRoomList != null) {
				UserInRoom inRoom = null;
				for (int i = 0; i < userInRoomList.size(); i++) {
					inRoom = userInRoomList.get(i);
					if (inRoom.getIsSit() == 1 || inRoom.getIsSit() == 2) {
						isPlay = true;
						break;
					}
				}
			}
			if (!isPlay) {
				List<UserInRoom> matchUserInRoomList = LocalMatchCache.MATCH_USER_IN_ROOM.get(String.valueOf(fbId));// 比赛房间
				if (matchUserInRoomList != null) {
					UserInRoom inRoom = null;
					for (int i = 0; i < matchUserInRoomList.size(); i++) {
						inRoom = matchUserInRoomList.get(i);
						if (inRoom.getIsSit() == 1 || inRoom.getIsSit() == 2) {
							isPlay = true;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isPlay;
	}

	/**
	 * 是否在大厅
	 *
	 * @param fbId
	 * @return
	 */
	public static boolean isLobby(Long fbid) {
		boolean isLobby = false;
		if (fbid == null)
			return false;
		RedisLogin redis = SpringUtils.getBean(RedisLogin.class);
		String targetMapping = redis.hget(RedisKeys.KEY_LOGIN_MAPPING, fbid.toString().trim());
		if (null != targetMapping) // 没有登陆
		{
			isLobby = true;
		}
		return isLobby;

	}

	/**
	 * 用户加入房间提示
	 */
	public static void userOnline(Long fbid) {
		boolean isenable = false;// OptionUtils.convertToBoolean(OptionUtils.getOption("option.login.online.enable"));
		if (isenable) {
			// 启用线程处理
			// Threadpool.executorOtherPool.execute(new
			// UserOnlineExecuterThread(fbid));

		}
	}

	public static List<Invitations> getInvitationUser(String fbid) {
		List<Invitations> friendlist = new ArrayList<Invitations>();
		StringBuffer sql = new StringBuffer("SELECT friend_id AS uid FROM user_friends WHERE u_id =");
		sql.append(fbid.toString());
		sql.append(" UNION ALL SELECT u_id AS uid FROM user_friends WHERE friend_id =");
		sql.append(fbid.toString());

		String sqlstr = " select distinct uid from (" + sql.toString() + ") uf";
		List<Map<String, Object>> rs = AppContext.getBean(UsersDao.class).querySQLListWithMap(sqlstr);

		Iterator<Map<String, Object>> itr = rs.iterator();
		while (itr.hasNext()) {
			Long uid = Long.valueOf(itr.next().get("uid").toString());
			if (LobbyUserHelper.isLobby(uid)) {
				UserFundDetails uinfo = LobbyUserHelper.getUserInfo(uid);
				Invitations vo = new Invitations();
				vo.setUid(uid);
				vo.setName(uinfo.getNn());
				vo.setFlag(1);
				vo.setImgUrl(uinfo.getImgurl());
				vo.setViplevel(uinfo.getVl());
				vo.setMtype(1);
				if (LobbyUserHelper.isPlay(uid)) {
					vo.setMtype(2);
				}
				friendlist.add(vo);

			}
		}
		return friendlist;

	}

	/**
	 * 用户离开房间提示
	 */
	public static void userLeaveRoom(Long fbid) {
		boolean isenable = false;// OptionUtils.convertToBoolean(OptionUtils.getOption("option.login.online.enable"));
		if (isenable) {
			// 启用线程处理
			// Threadpool.executorOtherPool.execute(new
			// UserLeaveExecuterThread(fbid));
		}
	}

	/**
	 * 删除用户所在房间
	 */
	public static void deleteUserInRoom(List<UserInRoom> inrooms, String rid) {
		try {
			if (inrooms != null && inrooms.size() > 0) {
				UserInRoom inRoom = null;
				List<UserInRoom> indexs = new ArrayList<UserInRoom>();
				for (int i = 0; i < inrooms.size(); i++) {
					inRoom = inrooms.get(i);
					if (rid.equals(inRoom.getRid())) {
						indexs.add(inRoom);
					}
				}
				// 执行删除
				for (int i = 0; i < indexs.size(); i++) {
					inRoom = indexs.get(i);
					inrooms.remove(inRoom);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除用户所在房间
	 */
	public static void deleteUserInRoom(ArrayList<UserInRoom> inrooms, Integer matchId, String rid) {
		try {
			if (inrooms != null && inrooms.size() > 0) {
				UserInRoom inRoom = null;
				List<UserInRoom> indexs = new ArrayList<UserInRoom>();
				for (int i = 0; i < inrooms.size(); i++) {
					inRoom = inrooms.get(i);
					if (StringUtil.isEmpty(rid)) {// 当不传房间ID则删除该比赛的在房间数据
						if (inRoom.getMi() == matchId) {
							indexs.add(inRoom);
						}
					} else {
						if (inRoom.getMi() == matchId && rid.equals(inRoom.getRid())) {
							indexs.add(inRoom);
						}
					}
				}
				// 执行删除
				for (int i = 0; i < indexs.size(); i++) {
					inRoom = indexs.get(i);
					inrooms.remove(inRoom);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除用户所在房间
	 */
	public static void deleteUserInRoom(ArrayList<UserInRoom> inrooms, Integer matchId, String rid, String cuid) {
		try {
			if (inrooms != null && inrooms.size() > 0) {
				UserInRoom inRoom = null;
				List<UserInRoom> indexs = new ArrayList<UserInRoom>();
				for (int i = 0; i < inrooms.size(); i++) {
					inRoom = inrooms.get(i);
					if (StringUtil.isEmpty(rid)) {// 当不传房间ID则删除该比赛的在房间数据
						if (inRoom.getMi() == matchId) {
							indexs.add(inRoom);
						}
					} else {
						if (inRoom.getMi() == matchId && rid.equals(inRoom.getRid()) && cuid.equalsIgnoreCase(inRoom.getUid())) {
							indexs.add(inRoom);
						}
					}
				}
				// 执行删除
				for (int i = 0; i < indexs.size(); i++) {
					inRoom = indexs.get(i);
					inrooms.remove(inRoom);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除用户在房间的所有数据
	 */
	public static void deleteAllUserInRoom(String fbId) {
		try {
			LocalCache.USER_IN_ROOM.remove(fbId);// 普通房间
			LocalMatchCache.MATCH_USER_IN_ROOM.remove(fbId);// 比赛房间

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 当大厅用户金额有变动时发送信息到flash(以下参数如果没有变动值为null)
	 *
	 * @param fbid
	 *            用户id
	 * @param amount
	 *            变动的金额
	 * @param currencyType
	 *            货币类型
	 * @param from
	 *            来自
	 * @param issend
	 *            是否需要通知客户端
	 */
	public static Double sendLobbyChipsChange(long fbid, Double amount) {

		if (amount == 0)
			return 0.0;

		Double aamount = 0.0;// 更新后金额
		RedisLogin redis = SpringUtils.getBean(RedisLogin.class);
		aamount = (redis.hincrBy(LocalCache.USER_FUND_CECHED_PRDFIX + fbid, "chips", amount.longValue())).doubleValue();

		UserChipsChangeVo vo = new UserChipsChangeVo();
		vo.setCode(Definition.SUCCESS_CODE);
		vo.setCmd(Definition.LOBBYUSERFUND);
		vo.setId(fbid);
		vo.setType(3);
		vo.setValue(aamount);
		LogicChannelUtil.sendToTargets(vo, Lists.newArrayList(String.valueOf(fbid)));

		return aamount;
	}

	public static int isLoginNewUser(Long fbid) {
		// TODO 自动生成的方法存根
		return 0;
	}

	/**
	 * 用户是否为机器人
	 */
	public static boolean isRobot(Long fbId) {
		boolean isRobot = false;
		RedisLogin redis = SpringUtils.getBean(RedisLogin.class);
		String isstr = redis.hget(LocalCache.USER_INFO_CECHED_PRDFIX + fbId, "isRobot");
		if (isstr != null && !"".equals(isstr)) {
			if (Integer.valueOf(isstr) == 1)
				isRobot = true;
		}
		return isRobot;
	}

	/**
	 * wtu.add 2015-10-12 获取用户等级
	 */
	public static Integer getUserLv(Long fbId) {
		Integer lv = 0;
		RedisLogin redis = SpringUtils.getBean(RedisLogin.class);
		String lvstr = redis.hget(LocalCache.USER_INFO_CECHED_PRDFIX + fbId, "lv");
		if (lvstr != null && !"".equals(lvstr)) {
			lv = Integer.valueOf(lvstr);
		}
		return lv;
	}
	/**
	 * wtu.add 2015-11-26 获取用户vip等级
	 */
	public static Integer getUserVipLv(Long fbId) {
		Integer lv = 0;
		RedisLogin redis = SpringUtils.getBean(RedisLogin.class);
		String lvstr = redis.hget(LocalCache.USER_VIP_CECHED_PRDFIX + fbId, "lv");
		if (lvstr != null && !"".equals(lvstr)) {
			lv = Integer.valueOf(lvstr);
		}
		return lv;
	}
	
	/**
	 * wtu.add 2015-11-26 获取用户礼物
	 */
	public static String getUserAdron(Long fbId) {
		String lv = "";
		RedisLogin redis = SpringUtils.getBean(RedisLogin.class);
		String lvstr = redis.hget(LocalCache.USER_INFO_CECHED_PRDFIX + fbId, "adorn");
		if (lvstr != null && !"".equals(lvstr)) {
			lv = lvstr;
		}
		return lv;
	}
	/**
	 * 取得用户呢称
	 * @param fbid
	 * @return
	 */
	public static String getUserNick(String fbid){
		//重缓存读取
		RedisLogin redis = SpringUtils.getBean(RedisLogin.class);
		Map<String, String> infostr = redis.hgetAll(LocalCache.USER_INFO_CECHED_PRDFIX + fbid);
		if (infostr != null && !"".equals(infostr)) {
			try {
				return infostr.get("name");
			} catch (Exception e) {
				LOGGER.warn("", e);
			}
		}
		
		
	    //缓存读取失败，从数据库读取
		StringBuffer sql = new StringBuffer("SELECT nickname");
		sql.append(" FROM user_info ");
		sql.append(" WHERE u_id=" + fbid);
		List<Map<String, Object>> rs = AppContext.getBean(UsersDao.class).querySQLListWithMap(sql.toString());
		Iterator<Map<String, Object>> itr = rs.iterator();
		if (itr.hasNext()) {
			Map<String, Object> map = itr.next();
			
			if (map.containsKey("nickname")) {
				return map.get("nickname").toString();
			}
			
		}
		return "";
		
	}

	/**
	 * wtu.add 2015-10-13 获取用户信息
	 */
	public static UserFundDetails getUserInfo(Long fbid) {
		UserFundDetails ufd = new UserFundDetails();
		ufd.setUid(fbid);

		RedisLogin redis = SpringUtils.getBean(RedisLogin.class);
		String vipstr = redis.hget(LocalCache.USER_VIP_CECHED_PRDFIX + fbid, "lv");
		if (vipstr != null && !"".equals(vipstr)) {
			ufd.setVl(Integer.valueOf(vipstr));
		}

		Map<String, String> infostr = redis.hgetAll(LocalCache.USER_INFO_CECHED_PRDFIX + fbid);
		if (infostr != null && !"".equals(infostr)) {
			try {
				ufd.setNn(infostr.get("name"));
				ufd.setImgurl(infostr.get("furl"));
				if (infostr.containsKey("lv")) {
					String value = infostr.get("lv");
					if (!StringUtil.isEmpty(value) && StringUtil.isNumeric(value)) {
						ufd.setEl(Integer.valueOf(value));
					}
				}
				if (infostr.containsKey("isRobot")) {
					String value = infostr.get("isRobot");
					if (!StringUtil.isEmpty(value) && StringUtil.isNumeric(value)) {
						ufd.setTp(Integer.valueOf(value));
					} else {
						ufd.setTp(0);
					}
				}
			} catch (Exception e) {
				LOGGER.warn("", e);
			}

		}

		return ufd;
	}
	
	

	/**
	 * 更改用户坐下状态
	 */
	public static void updateUserSitStatus(String puid, String rid, int isset) {
		List<UserInRoom> ulist = LocalCache.USER_IN_ROOM.get(puid);
		if (ulist != null && ulist.size() > 0) {
			UserInRoom inRoom = null;
			for (int i = 0; i < ulist.size(); i++) {
				inRoom = ulist.get(i);
				if (inRoom.getRid().equals(rid)) {
					inRoom.setIsSit(isset);// 已经加入房间

					// 强制更新
					ulist.set(i, inRoom);

				}
			}
		}
	}

	/****
	 * 普通场快速入座 (筛选1/10筹码级可进入场——>好友——>真实用户——>最低/高级场)
	 *
	 * @type type 新手默认进
	 * @return roomId
	 */
	public static String quickJoinInRoom(Long fbId, double myChips, Integer type) throws Exception {
		double part = LogicPropertyUtil.getInteger("option.room.part.min", 1).doubleValue();// V20121107改成十分之一

		// 查找筹码的1/10可进的场
		Map<String, Rooms> canJoinRooms = new HashMap<String, Rooms>();// 1/10筹码可参与桌
		Map<Double, Map<String, Rooms>> conJoinRoomsBB = new HashMap<Double, Map<String, Rooms>>();// 可进入房间的大盲<bb,<rid,Rooms>>

		String maxChipsRoomId = null;// 最高筹码桌
		String mipChipsRoomId = null;// 最低筹码桌
		double mip = 500000000;
		double mxp = 0;
		Double minChipsRoom = LogicPropertyUtil.getInteger("option.room.min.chips", 100).doubleValue();
		if (type == QuickVo.QUICK_1) {// 新手快速开始进默认的房间
			Iterator<Entry<String, Rooms>> iter = LocalCache.ROOMS.entrySet().iterator(); // 获得map的Iterator
			Integer defaultSb = LogicPropertyUtil.getInteger("option.room.min.chips", 100);
			while (iter.hasNext()) {// 查找可进入的牌桌
				Rooms room = iter.next().getValue();
				if (defaultSb == Integer.valueOf(Double.valueOf(room.getSb()).intValue())) {
					if (room.getMc() > room.getCc()) {// 人数未满

						// Map<Long,PlayerInfoInRoom> piiMap =
						// LobbyCache.PLAYER_ON_ROOM.get(room.getRid());
						List<UserInRoom> userInRooms = LocalCache.USER_IN_ROOM.get(String.valueOf(fbId));
						boolean isInRoom = LobbyUserHelper.isInRoom(userInRooms, room.getRid());
						if (!isInRoom) {// 排除自己在过的房间(包括旁观)

							if (room.getMip() <= mip) {
								mip = room.getMip();
								mipChipsRoomId = room.getRid();
							}
							if (room.getMxp() >= mxp) {
								mxp = room.getMxp();
								maxChipsRoomId = room.getRid();
							}
							canJoinRooms.put(room.getRid(), room);
						}
					}
				}
			}
		} else {// 除新手第一次快速入座之外的
			Iterator<Entry<String, Rooms>> iter = LocalCache.ROOMS.entrySet().iterator(); // 获得map的Iterator
			Map<String, Rooms> cjbb = new HashMap<String, Rooms>();
			// Double minCanToRoom =
			// Double.valueOf(OptionUtils.getOption("option.cannot.join.room.mincp"));
			while (iter.hasNext()) {// 查找可进入的牌桌
				Rooms room = iter.next().getValue();
				/*
				 * if(myChips >= minCanToRoom && room.getMip() ==
				 * minChipsRoom){//超过3000不能进入1/2的场 continue; }
				 */
				// 如果锁场了则不能进入
				if (isLockRoom(fbId, room.getSb(), room.getBb()) == 1) {
					continue;
				}

				if (room.getMxp() <= (myChips * part)) {

					if (room.getMc() > room.getCc()) {// 人数未满

						// Map<Long,PlayerInfoInRoom> piiMap =
						// LobbyCache.PLAYER_ON_ROOM.get(room.getRid());
						List<UserInRoom> userInRooms = LocalCache.USER_IN_ROOM.get(String.valueOf(fbId));
						boolean isInRoom = LobbyUserHelper.isInRoom(userInRooms, room.getRid());
						if (!isInRoom) {// 排除自己在过的房间(包括旁观)

							if (room.getMip() <= mip) {
								mip = room.getMip();
								mipChipsRoomId = room.getRid();
							}
							if (room.getMxp() >= mxp) {
								mxp = room.getMxp();
								maxChipsRoomId = room.getRid();
							}
							canJoinRooms.put(room.getRid(), room);

							// 能进入房间的大盲
							int lc = room.getMc() - room.getCc();
							if (room.getCc() > 0 && lc > 1) {// 房间人数大于1
								if (conJoinRoomsBB.containsKey(room.getBb())) {
									conJoinRoomsBB.get(room.getBb()).put(room.getRid(), room);
								} else {
									cjbb = new HashMap<String, Rooms>();
									cjbb.put(room.getRid(), room);
									conJoinRoomsBB.put(room.getBb(), cjbb);
								}
							}
						}
					}
				}
			}
		}// ef 1/10可进房间

		boolean isnj = false;// 是否无可进入房间进最低场
		// 无可进入房间
		if (canJoinRooms.size() == 0) {
			isnj = true;
			Iterator<Entry<String, Rooms>> iter2 = LocalCache.ROOMS.entrySet().iterator(); // 获得map的Iterator
			double mip2 = 500000000;
			double mxp2 = 0;
			Map<String, Rooms> cjbb = new HashMap<String, Rooms>();
			while (iter2.hasNext()) {// 查找可进入的牌桌
				Rooms room = iter2.next().getValue();
				// 如果锁场了则不能进入
				if (isLockRoom(fbId, room.getSb(), room.getBb()) == 1) {
					continue;
				}

				if (myChips >= room.getMip() && room.getMip() <= minChipsRoom) {// 进最低级别场

					List<UserInRoom> userInRooms = LocalCache.USER_IN_ROOM.get(String.valueOf(fbId));
					boolean isInRoom = LobbyUserHelper.isInRoom(userInRooms, room.getRid());
					if (!isInRoom) {// 排除自己在过的房间(包括旁观)

						if (room.getMc() > room.getCc()) {// 人数未满

							if (room.getMip() <= mip2) {
								mip2 = room.getMip();
								mipChipsRoomId = room.getRid();
							}
							if (room.getMxp() >= mxp2) {
								mxp2 = room.getMxp();
								maxChipsRoomId = room.getRid();
							}
							canJoinRooms.put(room.getRid(), room);

							// 能进入房间的大盲
							if (room.getCc() > 0) {
								if (conJoinRoomsBB.containsKey(room.getBb())) {
									conJoinRoomsBB.get(room.getBb()).put(room.getRid(), room);
								} else {
									cjbb = new HashMap<String, Rooms>();
									cjbb.put(room.getRid(), room);
									conJoinRoomsBB.put(room.getBb(), cjbb);
								}
							}
						}
					}
				}
			}

		}// ef canJoinRooms.size() == 0

		return getQuickJoinRoomId(fbId, myChips, maxChipsRoomId, canJoinRooms, conJoinRoomsBB, isnj);
	}

	/**
	 * 进入同大小盲的房间
	 */
	public static String quickJoinInRoom(Long fbId, double myChips, double sb, double bb) {
		Map<String, Rooms> canJoinRooms = new HashMap<String, Rooms>();// 可参与桌
		Map<Double, Map<String, Rooms>> conJoinRoomsBB = new HashMap<Double, Map<String, Rooms>>();// 可进入房间的大盲<bb,<rid,Rooms>>

		String maxChipsRoomId = null;// 最高筹码桌
		String mipChipsRoomId = null;// 最低筹码桌
		double mip = 500000000;
		double mxp = 0;

		Iterator<Entry<String, Rooms>> iter = LocalCache.ROOMS.entrySet().iterator(); // 获得map的Iterator
		Map<String, Rooms> cjbb = new HashMap<String, Rooms>();
		// Double minCanToRoom =
		// Double.valueOf(OptionUtils.getOption("option.cannot.join.room.mincp"));
		while (iter.hasNext()) {// 查找可进入的牌桌
			Rooms room = iter.next().getValue();
			/*
			 * if(myChips >= minCanToRoom && room.getMip() ==
			 * minChipsRoom){//超过3000不能进入1/2的场 continue; }
			 */
			if (room.getSb() != sb || room.getBb() != bb) {// 只找相同盲注的房间
				continue;
			}
			// 如果锁场了则不能进入
			if (isLockRoom(fbId, room.getSb(), room.getBb()) == 1) {
				continue;
			}

			if (room.getMc() > room.getCc()) {// 人数未满
				List<UserInRoom> userInRooms = LocalCache.USER_IN_ROOM.get(String.valueOf(fbId));
				boolean isInRoom = LobbyUserHelper.isInRoom(userInRooms, room.getRid());
				if (!isInRoom) {// 排除自己在过的房间(包括旁观)

					if (room.getMip() <= mip) {
						mip = room.getMip();
						mipChipsRoomId = room.getRid();
					}
					if (room.getMxp() >= mxp) {
						mxp = room.getMxp();
						maxChipsRoomId = room.getRid();
					}
					canJoinRooms.put(room.getRid(), room);

					// 能进入房间的大盲
					int lc = room.getMc() - room.getCc();
					if (room.getCc() > 0 && lc > 1) {// 房间人数大于1
						if (conJoinRoomsBB.containsKey(room.getBb())) {
							conJoinRoomsBB.get(room.getBb()).put(room.getRid(), room);
						} else {
							cjbb = new HashMap<String, Rooms>();
							cjbb.put(room.getRid(), room);
							conJoinRoomsBB.put(room.getBb(), cjbb);
						}
					}
				}
			}
		}

		// 返回房间
		return getQuickJoinRoomId(fbId, myChips, maxChipsRoomId, canJoinRooms, conJoinRoomsBB, false);
	}

	/**
	 * 是否锁住该房间
	 */
	public static int isLockRoom(Long fbid, Double sb, Double bb) {
		int islock = 0;
		try {
			Map<Integer, Integer> roomLock = getRoomLock(fbid, sb, bb);
			if (roomLock.get(0) == 1 || roomLock.get(1) == 1) {
				islock = 1;
			}
		} catch (Exception e) {
			// Logger.error("isLockRoom error:" + e.getMessage(), e);
		}
		return islock;
	}

	/**
	 * 房间锁 return key:0 筹码超出锁住，1筹码不足并等级不够
	 */
	public static Map<Integer, Integer> getRoomLock(Long fbid, Double sb, Double bb) {
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		result.put(0, 0);// 默认都未锁住
		result.put(1, 0);
		boolean isenable = LogicPropertyUtil.getBoolean("option.lock.room.enable", false);
		if (isenable) {
			/*
			 * try { if (ConfigUtils.roomLockMap.containsKey(sb)) {
			 * RoomLockConfigVo roomLock = ConfigUtils.roomLockMap.get(sb);
			 * UserFundInfoVo userFund = LocalCache.USER_FUNDS.get(fbid); if
			 * (userFund != null) { // 如果配置锁场,筹码超出而锁场 if (roomLock.getLkc() > 0
			 * && userFund.getC() >= roomLock.getLkc()) { result.put(0, 1); }
			 * 
			 * } else {// 不存在用户账户信息一律锁住 result.put(0, 1); result.put(1, 1); } }
			 * } catch (Exception e) { Logger.error("getRoomLock error:" +
			 * e.getMessage(), e); }
			 */
		}
		return result;
	}

	/**
	 * 查找某个用户是否存在于该房间
	 */
	public static boolean isInRoom(List<UserInRoom> inrooms, String rid) {
		boolean iscons = false;
		if (inrooms != null && inrooms.size() > 0) {
			UserInRoom inRoom = null;
			for (int i = 0; i < inrooms.size(); i++) {
				inRoom = inrooms.get(i);
				if (inRoom.getRid().equals(rid)) {
					iscons = true;
					break;
				}
			}
		}
		return iscons;
	}

	/**
	 * 通过筛选规则筛选房间
	 *
	 * @param fbId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static String getQuickJoinRoomId(Long fbId, Double myChips, String maxChipsRoomId, Map<String, Rooms> canJoinRooms, Map<Double, Map<String, Rooms>> conJoinRoomsBB, boolean isnj) {

		Map<String, Integer> fInRooms = new HashMap<String, Integer>();// 好友分布
		Map<String, Integer> realUserInRooms = new HashMap<String, Integer>();// 真实人员分布
		List<String> robotUserInRooms = new ArrayList<String>();// 机器人分布
		Map<String, Rooms> conJoinMaxBBRooms = new HashMap<String, Rooms>();// 能进入的最大大盲房间组

		// 筛选我进入的对应盲注房间

		if (conJoinRoomsBB.size() > 0) {
			List<Map.Entry<Object, Object>> r = null;
			if (isnj) {
				r = MapUtils.sortKey2(conJoinRoomsBB);// 进入最小场
			} else {
				r = MapUtils.descKey2(conJoinRoomsBB);// 我可进入的最大
			}
			Map.Entry<Object, Object> jm = r.get(0);

			conJoinMaxBBRooms = (Map<String, Rooms>) jm.getValue();
		}

		/***************************** 好友条件筛选 ******************************************/
		// FriendUImpl fi = new FriendUImpl();
		// List<String> fbids = fi.getAppFriend(fbId, 1, 500);
		List<Long> fbids = LobbyUserHelper.getMyFriendIds(fbId);
		if (fbids != null && fbids.size() > 0) {// 有好友
			for (Integer i = 0; i < fbids.size(); i++) {
				String friendFbid = fbids.get(i).toString();
				List<UserInRoom> myFriendInRooms = LocalCache.USER_IN_ROOM.get(friendFbid);
				if (myFriendInRooms != null && myFriendInRooms.size() > 0) {
					for (int j = 0; j < myFriendInRooms.size(); j++) {
						UserInRoom uir = myFriendInRooms.get(j);
						Rooms r = canJoinRooms.get(uir.getRid());
						if (r == null) {
							continue;
						}
						// 优先进我能进入的最大盲注有用户房间
						if (conJoinMaxBBRooms.size() > 0 && !conJoinMaxBBRooms.containsKey(uir.getRid())) {
							continue;
						}
						// 筛选好友
						if (r != null && !fInRooms.containsKey(uir.getRid())) {
							fInRooms.put(uir.getRid(), 1);
						} else if (r != null && fInRooms.containsKey(uir.getRid())) {
							fInRooms.put(uir.getRid(), fInRooms.get(uir.getRid()) + 1);
						}
					}
				}
			}
			if (fInRooms.size() > 0) {// 有好友在牌桌
				String reValRoomId = null;
				int maxUserCount = 0;
				Iterator<Entry<String, Integer>> realUserCountIter = fInRooms.entrySet().iterator();
				while (realUserCountIter.hasNext()) {// 查找好友最多的牌桌
					Entry<String, Integer> temp = realUserCountIter.next();
					if (reValRoomId == null) {
						reValRoomId = temp.getKey();
						maxUserCount = temp.getValue();
					} else {
						if (temp.getValue().intValue() > maxUserCount) {
							reValRoomId = temp.getKey();
							maxUserCount = temp.getValue();
						}
					}
				}
				// Logger.info("quickJoinInRoom returnRoomId>> fbId = " + fbId +
				// ", myChips = " + myChips + ". 有好友,返回桌号：" + reValRoomId);
				return reValRoomId;
			}
		}

		/***************************** 真实用户条件筛选 ******************************************/
		Iterator<Entry<String, Rooms>> realUserIter = canJoinRooms.entrySet().iterator();
		while (realUserIter.hasNext()) {// 查找真实用户
			Entry<String, Rooms> canjoinRoom = realUserIter.next();
			Map<Long, PlayerInfoInRoom> realUserMap = LocalCache.PLAYER_ON_ROOM.get(canjoinRoom.getKey());
			if (realUserMap != null) {
				Iterator<Entry<Long, PlayerInfoInRoom>> tempUserRoom = realUserMap.entrySet().iterator();
				while (tempUserRoom.hasNext()) {
					PlayerInfoInRoom temp = tempUserRoom.next().getValue();
					if (temp == null) {
						continue;
					}
					// 优先进我能进入的最大盲注有用户房间
					if (conJoinMaxBBRooms.size() > 0 && !conJoinMaxBBRooms.containsKey(temp.getRid())) {
						continue;
					}
					// 筛选真人
					if (!temp.isRobot()) {
						if (!realUserInRooms.containsKey(canjoinRoom.getKey())) {
							realUserInRooms.put(canjoinRoom.getKey(), 1);
						} else {
							realUserInRooms.put(canjoinRoom.getKey(), realUserInRooms.get(canjoinRoom.getKey()) + 1);
						}
					}
				}
			}
		}
		if (realUserInRooms.size() > 0) {// 有真实用户
			String reValRoomId = null;
			int maxRealUserCount = 0;
			Iterator<Entry<String, Integer>> realUserCountIter = realUserInRooms.entrySet().iterator();
			while (realUserCountIter.hasNext()) {// 查找真实用户最多的牌桌
				Entry<String, Integer> temp = realUserCountIter.next();
				if (reValRoomId == null) {
					reValRoomId = temp.getKey();
					maxRealUserCount = temp.getValue();
				} else {
					if (temp.getValue().intValue() > maxRealUserCount) {
						reValRoomId = temp.getKey();
						maxRealUserCount = temp.getValue();
					}
				}
			}
			// Logger.info("quickJoinInRoom returnRoomId>> fbId = " + fbId +
			// ", myChips = " + myChips + ". 有真实用户,返回桌号：" + reValRoomId);
			return reValRoomId;
		}

		/***************************** 牌桌有人条件筛选 ******************************************/
		// 无真实用户，那么只有机器人了
		Iterator<Entry<String, Rooms>> robotsUserIter = canJoinRooms.entrySet().iterator();
		while (robotsUserIter.hasNext()) {// 查找机器人桌
			Entry<String, Rooms> canjoinRoom = robotsUserIter.next();
			if (canjoinRoom == null) {
				continue;
			}
			// 优先进我能进入的最大盲注有用户房间
			if (conJoinMaxBBRooms.size() > 0 && !conJoinMaxBBRooms.containsKey(canjoinRoom.getKey())) {
				continue;
			}
			// 筛选机器人
			Map<Long, PlayerInfoInRoom> realUserMap = LocalCache.PLAYER_ON_ROOM.get(canjoinRoom.getKey());
			if (realUserMap != null && realUserMap.size() != 0) {
				robotUserInRooms.add(canjoinRoom.getValue().getRid());
			}
		}
		if (robotUserInRooms.size() > 0) {// 有机器人桌
			int size = robotUserInRooms.size();
			Random r = new Random();
			int rel = r.nextInt(size);
			String relRoomid = robotUserInRooms.get(rel);
			// Logger.info("quickJoinInRoom returnRoomId>> fbId = " + fbId +
			// ", myChips = " + myChips + ". 只有返回机器人桌号：" + relRoomid);
			return relRoomid;
		}

		// gger.info("quickJoinInRoom returnRoomId>> fbId = " + fbId +
		// ", myChips = " + myChips + ". 最后返回桌号：" + maxChipsRoomId);
		return maxChipsRoomId;
	}

	public static List<Long> getMyFriendIds(Long fbId) {
		return getMyFriendIds(fbId, false);
	}

	/**
	 * 获取我的好友Id集合
	 *
	 * @param isexblack
	 *            是否包含黑名单
	 */
	public static List<Long> getMyFriendIds(Long fbId, boolean isexblack) {
		List<Long> list = new ArrayList<Long>();
		/*
		 * Connection conn = null; Statement stat = null; ResultSet rs = null;
		 * try { conn = DbUtils.getConnection(); stat = conn.createStatement();
		 * StringBuffer sql = new
		 * StringBuffer("SELECT ObjectFbId FROM user_relation");
		 * sql.append(" WHERE RelationType IN (1,2)"); if (!isexblack) {
		 * sql.append(" AND RelationFlag != " + UserRelation.FLAG_BKLIST); }
		 * sql.append(" AND FbId=" + fbId); sql.append(" GROUP BY ObjectFbId");
		 * rs = stat.executeQuery(sql.toString()); while (rs.next()) {
		 * list.add(rs.getLong(1)); }
		 * 
		 * } catch (Exception e) { Logger.error("getMyFriendIds error:" +
		 * e.getMessage(), e); } finally { DbUtils.close(rs);
		 * DbUtils.close(stat); DbUtils.close(conn); }
		 */
		return list;
	}
	/**
	 * 保存到游戏记筹码记录表
	 * @param gc
	 */
	public static void saveGameCost(GameCost gc)
	{
		
		String insSql = "INSERT INTO game_cost(u_id,type,bill_before,bill,create_time,remark) "
				+ "VALUES(" + gc.getUId() + "," + gc.getType() + "," + gc.getBillBefore() 
				+ "," + gc.getBill() + ",'"+ DateUtils.dateToString(new Date(), DateUtils.PATTERN_YMDHMS) 
				+ "','"+gc.getRemark()+"');";
		int affect = AppContext.getBean(UsersDao.class).execSQL(insSql.toString());
	}
	
	public static Long getUserChips(Long fbid)
	{
		Long aamount = 0L;// 更新后金额
		try {
			RedisLogin redis = SpringUtils.getBean(RedisLogin.class);
			String oldChips = redis.hget(LocalCache.USER_FUND_CECHED_PRDFIX + fbid, "chips");
			if(oldChips!=null)
			{
				aamount=Long.valueOf(oldChips);
				return aamount;
			}
	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			String sql = "select chips from  user_fund WHERE u_id=" + fbid;
			List<Map<String, Object>> rc = AppContext.getBean(UsersDao.class).querySQLListWithMap(sql);
			if(rc!=null)
			{
				Map<String, Object> row=rc.get(0);
				if(row!=null)
				{
					if(row.get("chips")!=null)
					{aamount=Long.valueOf(row.get("chips").toString());}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return aamount;
	}
	/**
	 * 修改用户的账上数据 get_gold_log和get_master_log记录自己保存
	 */
	public static void updateUserFund(Long fbid, Double chips,Integer type,String remark) {
		Long oldChips=getUserChips(fbid);
		GameCost gc=new GameCost(fbid,type,oldChips,chips.intValue(),remark);
        saveGameCost(gc);
        
		updateUserChips(fbid, chips);
	}
	public static void updateUserSaveCost(Long fbid, Double chips,Integer type,String remark) {
		Long oldChips=getUserChips(fbid);
		GameCost gc=new GameCost(fbid,type,oldChips,chips.intValue(),remark);
        saveGameCost(gc);
        
		
	}

	/**
	 * 修改用户的账上数据 get_gold_log和get_master_log记录自己保存
	 */
	public static double updateUserFund(Long fbid, Double chips) {
	       return updateUserChips(fbid, chips);
	}

	/**
	 * 修改用户的账上数据 并通知缓存，和客户端
	 */
	public static double updateUserChips(Long fbid, Double chips) {
		try {
			StringBuffer sql = new StringBuffer();

			if (chips != null && chips != 0) {
				sql.append(" chips=chips+" + chips);
				String updateSql = "UPDATE user_fund SET " + sql.toString() + " WHERE u_id=" + fbid;
				int affect = AppContext.getBean(UsersDao.class).execSQL(updateSql);
				LOGGER.trace("affect={}", affect);
			return	sendLobbyChipsChange(fbid, chips);
			}

			// 更新缓存服务器金额、通知客户端

		}

		catch (Exception e) {
			LOGGER.error("updateUserChips error:" + e.getMessage(), e);
		}
		return 0.0;
	}

	/**
	 * 修改用户的账上积分
	 */
	public static void updateUserPoints(Long fbid, Long points) {
		try {
			StringBuffer sql = new StringBuffer();
			if (points != null && points != 0) {
				sql.append(" points=points+" + points);
				String updateSql = "UPDATE user_fund SET " + sql.toString() + " WHERE u_id=" + fbid;
				int affect = AppContext.getBean(UsersDao.class).execSQL(updateSql);
				
				Double aamount = 0.0;// 更新缓存中基分
				RedisLogin redis = SpringUtils.getBean(RedisLogin.class);
				aamount = (redis.hincrBy(LocalCache.USER_FUND_CECHED_PRDFIX + fbid, "points", points)).doubleValue();

				LOGGER.trace("affect={}", affect);
			} else {
				LOGGER.debug("fbid:{} points:{}", fbid, points);
			}
		} catch (Exception e) {
			LOGGER.error("updateUserChips error:{} ,{} ", e.getMessage(), e);
		}
	}

	/**
	 * 保存摇摇乐下注日志
	 * 
	 * @param fbid
	 * @param cardtype
	 * @param cardvalue
	 * @param betchips
	 * @param winchips
	 */
	public static void saveBetShakeLog(Long fbid, int cardtype, String cardvalue, double betchips, double winchips) {
		String updateSql = "INSERT INTO betShake_log(FbId,cardtype,cardvalue,betchips,winchips,bettime)VALUES(" + fbid + "," + cardtype + ",'" + cardvalue + "'," + betchips + "," + winchips + ",'"
				+ DateUtils.dateToString(new Date(), DateUtils.PATTERN_YMDHMS) + "');";
		int affect = AppContext.getBean(UsersDao.class).execSQL(updateSql.toString());
		LOGGER.trace("affect={}", affect);
	}

	public static List<SysConfigVo> getJewelBoxConfig() {

		List<SysConfigVo> list = new ArrayList<SysConfigVo>();
		try {

			StringBuffer sql = new StringBuffer("select configkey,configvalue from sys_config where configkey=\"jewelboxmoney\" or configkey=\"jewelsinglebet\"");
			List<Map<String, Object>> rs = AppContext.getBean(UsersDao.class).querySQLListWithMap(sql.toString());

			Iterator<Map<String, Object>> itr = rs.iterator();
			while (itr.hasNext()) {
				SysConfigVo scv = ObjectBeanUtil.JACKSON.convertValue(itr.next(), SysConfigVo.class);
				list.add(scv);
			}
			return list;

			// Logger.info(uf.getFbId()+" "+uf.getFbName());
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("getUserFund error " + e.getMessage());
		} finally {

		}
		return null;
	}

	/**
	 * 修改聚宝盆金额 get_gold_log和get_master_log记录自己保存
	 */
	public static void updateJewelBoxChips(Double chips) {
		try {
			StringBuffer sql = new StringBuffer();

			if (chips != null && chips != 0) {
				sql.append(" configvalue=\"" + chips + "\"");
				String updateSql = " UPDATE sys_config SET " + sql.toString() + " WHERE configkey=\"jewelboxmoney\"";
				int affect = AppContext.getBean(UsersDao.class).execSQL(updateSql.toString());
				LOGGER.trace("affect={}", affect);
			}

			// 更新缓存服务器金额、通知客户端

		}

		catch (Exception e) {
			LOGGER.error("updateUserChips error:" + e.getMessage(), e);
		}
	}

	/**
	 * 发送聚宝盆总金额到flash
	 * 
	 * @param el
	 *            新的等级
	 */
	public static void sendMoneyToAllUser(Long chips) {
		try {
			JewelBoxListVo vo = new JewelBoxListVo();
			vo.setCode(Definition.SUCCESS_CODE);
			vo.setCmd(Definition.JEWELBOXUPDATEMONEY);
			vo.setChips(chips);
			LogicChannelUtil.sendToTargets(vo, null);

		} catch (Exception e) {
			LOGGER.error("sendMoneyToAllUser error:" + e.getMessage(), e);
		}
	}

	/**
	 * 发送聚宝盆获奖公告flash
	 * 
	 * @param el
	 *            新的等级
	 */
	public static void sendWinMoneyToAllUser(Integer roomid, Long chips, List<JewelBoxVo> list) {
		try {
			JewelBoxListVo vo = new JewelBoxListVo();
			vo.setCode(Definition.SUCCESS_CODE);
			vo.setCmd(Definition.JEWELBOXOPEN);
			vo.setRoomid(roomid);
			vo.setChips(chips);
			vo.setList(list);

			// 发送所有用户
			LogicChannelUtil.sendToTargets(vo, null);

		} catch (Exception e) {
			LOGGER.error("sendWinMoneyToAllUser error:" + e.getMessage(), e);
		}
	}

	public static void sendJewelBoxMoney(Long chips) {
		JewelBoxListVo vo = new JewelBoxListVo();
		vo.setCode(Definition.SUCCESS_CODE);
		vo.setCmd(Definition.SENDJEWELBOXMONEY);
		vo.setRoomid(0);
		vo.setChips(chips);
		vo.setList(null);

		// 发送所有用户
		LogicChannelUtil.sendToTargets(vo, null);
	}

	public static void sendJewelBoxMoney(String fbid, Long chips) {
		JewelBoxListVo vo = new JewelBoxListVo();
		vo.setCode(Definition.SUCCESS_CODE);
		vo.setCmd(Definition.SENDJEWELBOXMONEY);
		vo.setRoomid(0);
		vo.setChips(chips);
		vo.setList(null);

		List<String> list = new ArrayList<String>();
		list.add(fbid.toString());
		// 发送所有用户
		LogicChannelUtil.sendToTargets(vo, list);
	}

	public static void sendJewelBoxMoneyFromData(String fbid) {
		List<SysConfigVo> slist = LobbyUserHelper.getJewelBoxConfig();
		Long allmoney = 0L;
		Iterator<SysConfigVo> sitr = slist.iterator();
		while (sitr.hasNext()) {
			SysConfigVo svo = (SysConfigVo) sitr.next();
			if ("jewelboxmoney".equals(svo.getConfigkey())) {
				allmoney = Double.valueOf(svo.getConfigvalue()).longValue();
				break;
			}

		}
		LobbyUserHelper.sendJewelBoxMoney(fbid, allmoney);
	}

	/**
	 * 添加聚宝盆记录项
	 * 
	 */
	public static void addJewelBox(JewelBoxVo jbv) {
		StringBuffer sql = new StringBuffer();
		try {
			

			if (jbv == null)
				return;

			if (jbv.getRoundID() != null) {

				sql.append("\"" + jbv.getRoundID() + "\"");
			}

			if (jbv.getFbid() != null) {

				sql.append(",\"" + jbv.getFbid() + "\"");
			}
			if (jbv.getBetMoney() != null) {

				sql.append(",\"" + jbv.getBetMoney() + "\"");
			}
			if (jbv.getWinTime() != null) {

				sql.append(",\"" + jbv.getWinTime() + "\"");
			}

			if (sql.length() > 0) {
				String updateSql = "INSERT INTO jewel_box(RoundID,Fbid,BetMoney,WinTime) VALUES (" + sql.toString() + ") ";

				int affect = AppContext.getBean(UsersDao.class).execSQL(updateSql.toString());

				LOGGER.trace("affect={}", affect);
			}
			// 更新缓存服务器金额、通知客户端
			// sendLobbyChipsChange(fbid,chips);

		}

		catch (Exception e) {
			LOGGER.info("Sql:"+sql.toString());
			LOGGER.error("updateUserChips error:" + e.getMessage(), e);
		}
	}

	/**
	 * 修改聚宝盆记录项
	 * 
	 */
	public static void updateJewelBox(JewelBoxVo jbv) {
		try {
			StringBuffer sql = new StringBuffer();

			if (jbv == null)
				return;

			if (jbv.getWinType() != null) {
				if(jbv.getWinType()<0)jbv.setWinType(0);

				sql.append(" WinType=" + jbv.getWinType());

			}
			if (jbv.getWinCards() != null) {

				sql.append(" ,WinCards=\"" + jbv.getWinCards() + "\"");

			}
			if (jbv.getWinMoney() != null) {

				sql.append(" ,WinMoney=" + jbv.getWinMoney());

			}
			

			if ("".equals(sql.toString()))
				return;

			sql.append(" ,isGet=1 where RoundID=" + jbv.getRoundID() + " and Fbid=" + jbv.getFbid());

			String updateSql = " UPDATE jewel_box SET " + sql.toString() + " ";

			int affect = AppContext.getBean(UsersDao.class).execSQL(updateSql.toString());

			LOGGER.trace("affect={}", affect);
			// 更新缓存服务器金额、通知客户端
			// sendLobbyChipsChange(fbid,chips);

		}

		catch (Exception e) {
			LOGGER.error("updateUserChips error:" + e.getMessage(), e);
		}
	}

	/**
	 * 加载所有机器人
	 * 
	 * @return
	 */
	public static List<RobotVo> loadAllRobots() {
		String updatesql = "update user_fund uf left join users us on uf.u_id = us.fbid set uf.chips=100000 where uf.chips < 1000 and us.isrobot=true";
		// DbUtils.exeSql(updatesql);//若机器人筹码小于1000,则将其补满10W

		try {
			AppContext.getBean(UsersDao.class).execSQL(updatesql);// //若机器人筹码小于1000,则将其补满10W
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		List<RobotVo> list = new ArrayList<RobotVo>();
		RobotVo robot = null;
		// String sql =
		// "select us.fbid AS robotFbId,us.fbname as robotFbName,uf.chips as chips,uf.expvalue as expValue,uf.totalvipvalue as totalVipValue,uf.viplevel as vipLevel, "
		// +
		// "uf.vippoints as vipPoints,uf.maxChips as maxChips,uf.roundMaxChips as roundMaxChips,ub.nickname as nickName,ub.figureurl as imageUrl  "
		// + "FROM users us left join user_fund uf on us.fbid=uf.fbid " +
		// "left join user_basic ub on us.fbid=ub.userid " +
		// "WHERE us.isRobot = TRUE";
		String sql = "select us.u_id AS robotFbId,us.is_robot as isRobot,us.nickname as robotFbName,uf.chips as chips,uf.exp as expValue, " + "uf.points as vipPoints,us.figureurl as imageUrl  "
				+ "FROM user_info us left join user_fund uf on us.u_id=uf.u_id " + "left join user_basic ub on us.u_id=ub.userid " + "WHERE us.is_robot = TRUE";
		try {
			List<Map<String, Object>> queryList = AppContext.getBean(UsersDao.class).querySQLListWithMap(sql);

			for (Map<String, Object> item : queryList) {
				robot = new RobotVo();
				Long fbId = Long.valueOf(item.get("robotFbId").toString());
				String robotFbName = String.valueOf(item.get("robotFbName").toString());
				Double chips = Double.valueOf(item.get("chips").toString());
				Double expValue = Double.valueOf(item.get("expValue").toString());
				// Double totalVipValue =
				// Double.valueOf(item.get("totalVipValue").toString());
				// Integer vipLevel =
				// Integer.valueOf(item.get("vipLevel").toString());
				// Double vipPoints =
				// Double.valueOf(item.get("vipPoints").toString());
				// Double maxChips =
				// Double.valueOf(item.get("maxChips").toString());
				// Double roundMaxChips =
				// Double.valueOf(item.get("roundMaxChips").toString());
				// String nickName =
				// String.valueOf(item.get("nickName").toString());
				String imageUrl = String.valueOf(item.get("imageUrl").toString());
				// String isRobot =
				// String.valueOf(item.get("isRobot").toString());

				robot.setRobotFbId(fbId);
				robot.setRobotFbName(robotFbName);
				robot.setChips(chips);
				robot.setExpValue(expValue);
				// robot.setTotalVipValue(totalVipValue);
				// robot.setVipLevel(vipLevel);
				// robot.setVipPoints(vipPoints);
				// robot.setMaxChips(maxChips);
				// robot.setRoundMaxChips(roundMaxChips);
				robot.setNickName(robotFbName);
				robot.setImageUrl(imageUrl);
				list.add(robot);
			}
		} catch (Exception e) {
			list.clear();
			LOGGER.error("", e);
		}
		return list;
	}

	/**
	 * 获取某局游戏用户游戏记录详情
	 */
	public static List<GameUserlog> getGameUserlogList(Integer roundId) {

		StringBuffer sql = new StringBuffer("SELECT gu.FbId,gu.ChangeChips,gu.BigBlind,gu.RoomID,gu.HoleCards,gu.WinChips,gu.RoundMaxCards,gu.HandCardType,gu.ULogID,gu.WinMainPool");
		sql.append(" FROM game_userlog gu");
		sql.append(" WHERE gu.roundId=" + roundId);

		List<Map<String, Object>> queryList = AppContext.getBean(UsersDao.class).querySQLListWithMap(sql.toString());

		List<GameUserlog> list = Lists.newArrayListWithCapacity(queryList.size());
		for (Map<String, Object> item : queryList) {
			GameUserlog gu = new GameUserlog();
			gu.setUlogId(Integer.valueOf(item.get("ULogID").toString()));
			gu.setFbId(Long.valueOf(item.get("FbId").toString()));
			gu.setChangeChips(Double.valueOf(item.get("BigBlind").toString()));
			gu.setBigBlind(Double.valueOf(item.get("BigBlind").toString()));
			gu.setRoomId(Integer.valueOf(item.get("RoomID").toString()));
			gu.setHoleCards(item.get("HoleCards").toString());
			gu.setWinChips(Double.valueOf(item.get("WinChips").toString()));
			gu.setRoundMaxCards(item.get("RoundMaxCards").toString());
			gu.setHandCardType(Short.valueOf(item.get("HandCardType").toString()));
			gu.setWinMainPool(Short.valueOf(item.get("WinMainPool").toString()));
			list.add(gu);
		}
		// {
		// GameUserlog gu = null;
		// while (rs.next()) {
		// gu = new GameUserlog();
		// gu.setFbId(rs.getLong(1));
		// gu.setChangeChips(rs.getDouble(2));
		// gu.setBigBlind(rs.getDouble(3));
		// gu.setRoomId(rs.getInt(4));
		// gu.setHoleCards(rs.getString(5));
		// gu.setWinChips(rs.getDouble(6));
		// gu.setRoundMaxCards(rs.getString(7));
		// gu.setHandCardType(rs.getShort(8));
		// gu.setUlogId(rs.getInt(9));
		// gu.setWinMainPool(rs.getShort(10));
		// list.add(gu);
		// }
		// }
		return list;
	}
	public static void checkStopGame()
	{
		ServerStopVo serverStopVo = LocalMatchCache.SERVER_STOP;
		long now = System.currentTimeMillis();
		if(serverStopVo.getStopgame() == false && now >= serverStopVo.getGametime() && serverStopVo.getGametime()>serverStopVo.getBegintime()){
			serverStopVo.setStopgame(true);
		}
	}

	public static void sendMsgTips(Long uid) {
		PokerMsgVo msgvo = new PokerMsgVo(Definition.SUCCESS_CODE, Definition.MSGPROMPT, uid, Definition.MSG_TYPES[4], null);
		LogicChannelUtil.sendToTargets(msgvo, Lists.newArrayList(String.valueOf(uid)));
	}

	public static void sendMsgTips(List<String> ulist) {
		PokerMsgVo msgvo = new PokerMsgVo(Definition.SUCCESS_CODE, Definition.MSGPROMPT, null, Definition.MSG_TYPES[4], null);
		LogicChannelUtil.sendToTargets(msgvo, ulist);
	}

}
