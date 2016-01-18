package com.badugi.game.logic.model.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.badugi.game.logic.dao.DrawRecordDao;
import com.badugi.game.logic.dao.UsersDao;
import com.badugi.game.logic.model.domain.vo.flash.operators.GameBeginVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.GameLogVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.GameType;
import com.badugi.game.logic.model.domain.vo.flash.user.PlayerInfoInRoom;
import com.badugi.game.logic.model.domain.vo.flash.user.UserFundInfoVo;
import com.badugi.game.logic.model.domain.vo.flash.user.UserInRoom;
import com.badugi.game.logic.model.vo.robot.RobotVo;
import com.badugi.game.logic.model.vo.supreme.ConstantPool;
import com.badugi.game.logic.model.vo.supreme.DealerQueueVo;
import com.badugi.game.logic.model.vo.supreme.DealerStatus;
import com.badugi.game.logic.model.vo.supreme.PlayerInfoInSupremeRoom;
import com.badugi.game.logic.model.vo.supreme.PrizeItem;
import com.badugi.game.logic.model.vo.supreme.SupremeRooms;
import com.badugi.game.logic.model.vo.supreme.WealthVo;
import com.badugi.game.logic.util.AppContext;
import com.badugi.game.logic.util.IdGenerator;
import com.badugi.game.logic.util.LogicPropertyUtil;
import com.google.common.collect.Maps;

/**
 * @createTime:
 * @description：信息缓存
 */
public final class CarCache {

	/***
	 * 游戏类型
	 */
	public static final Map<Integer, GameType> GAME_TYPES = new HashMap<Integer, GameType>();

	/************************************** 小游戏常量池start *******************************************/
	/**
	 * 小游戏房间缓存
	 */
	public static final ConcurrentHashMap<String, com.badugi.game.logic.model.vo.supreme.SupremeRooms> SUPREMEROOMS = new ConcurrentHashMap<String, com.badugi.game.logic.model.vo.supreme.SupremeRooms>();
	/**
	 * 小大众押注筹码数,fbId,<chiptype,chiptypecount>
	 */
	public static final ConcurrentHashMap<Long, Map<String, String>> MINVWCHIPS = new ConcurrentHashMap<Long, Map<String, String>>();
	/**
	 * 小大众单门押注筹码构成及数量
	 */
	public static final ConcurrentHashMap<String, String> MINVWCHIPSMAP = new ConcurrentHashMap<String, String>();
	/**
	 * 小宝马押注筹码数,fbId,<chiptype,chiptypecount>
	 */
	public static final ConcurrentHashMap<Long, Map<String, String>> MINBMWCHIPS = new ConcurrentHashMap<Long, Map<String, String>>();
	/**
	 * 小宝马单门押注筹码构成及数量
	 */
	public static final ConcurrentHashMap<String, String> MINBMWCHIPSMAP = new ConcurrentHashMap<String, String>();
	/**
	 * 小奔驰押注筹码数,fbId,<chiptype,chiptypecount>
	 */
	public static final ConcurrentHashMap<Long, Map<String, String>> MINBENZCHIPS = new ConcurrentHashMap<Long, Map<String, String>>();
	/**
	 * 小奔驰单门押注筹码构成及数量
	 */
	public static final ConcurrentHashMap<String, String> MINBENZCHIPSMAP = new ConcurrentHashMap<String, String>();
	/**
	 * 小保时捷押注筹码数,fbId,<chiptype,chiptypecount>
	 */
	public static final ConcurrentHashMap<Long, Map<String, String>> MINPORSCHECHIPS = new ConcurrentHashMap<Long, Map<String, String>>();
	/**
	 * 小宝时捷单门押注筹码构成及数量
	 */
	public static final ConcurrentHashMap<String, String> MINPORSCHECHIPSMAP = new ConcurrentHashMap<String, String>();
	/**
	 * 大大众押注筹码数,fbId,<chiptype,chiptypecount>
	 */
	public static final ConcurrentHashMap<Long, Map<String, String>> BIGVWCHIPS = new ConcurrentHashMap<Long, Map<String, String>>();
	/**
	 * 大大众单门押注筹码构成及数量
	 */
	public static final ConcurrentHashMap<String, String> BIGVWCHIPSMAP = new ConcurrentHashMap<String, String>();
	/**
	 * 大宝马押注筹码数,fbId,<chiptype,chiptypecount>
	 */
	public static final ConcurrentHashMap<Long, Map<String, String>> BIGBMWCHIPS = new ConcurrentHashMap<Long, Map<String, String>>();
	/**
	 * 大宝马单门押注筹码构成及数量
	 */
	public static final ConcurrentHashMap<String, String> BIGBMWCHIPSMAP = new ConcurrentHashMap<String, String>();
	/**
	 * 大奔驰押注筹码数,fbId,<chiptype,chiptypecount>
	 */
	public static final ConcurrentHashMap<Long, Map<String, String>> BIGBENZCHIPS = new ConcurrentHashMap<Long, Map<String, String>>();
	/**
	 * 大奔驰单门押注筹码构成及数量
	 */
	public static final ConcurrentHashMap<String, String> BIGBENZCHIPSMAP = new ConcurrentHashMap<String, String>();
	/**
	 * 大保时捷押注筹码数,fbId,<chiptype,chiptypecount>
	 */
	public static final ConcurrentHashMap<Long, Map<String, String>> BIGPORSCHECHIPS = new ConcurrentHashMap<Long, Map<String, String>>();
	/**
	 * 大宝时捷单门押注筹码构成及数量
	 */
	public static final ConcurrentHashMap<String, String> BIGPORSCHECHIPSMAP = new ConcurrentHashMap<String, String>();
	/**
	 * 当前局游戏押注满的门类<item,chips(本门满时押注筹码量)>
	 */
	public static final ConcurrentHashMap<String, Long> BETFULLITEMS = new ConcurrentHashMap<String, Long>();
	/**
	 * 8个种类中的筹码<item,<ftId,<bettype,bettypecount>>>
	 */
	@SuppressWarnings("serial")
	public final static Map<String, ConcurrentHashMap<Long, Map<String, String>>> PRIZESET = new HashMap<String, ConcurrentHashMap<Long, Map<String, String>>>() {
		{// key=奖项,value=赔率
			put(PrizeItem.MINVW.getItem(), MINVWCHIPS); // 小大众
			put(PrizeItem.MINBMW.getItem(), MINBMWCHIPS); // 小宝马
			put(PrizeItem.MINBENZ.getItem(), MINBENZCHIPS); // 小奔驰
			put(PrizeItem.MINPORSCHE.getItem(), MINPORSCHECHIPS);// 小保时捷
			put(PrizeItem.BIGVW.getItem(), BIGVWCHIPS); // 大大众
			put(PrizeItem.BIGBMW.getItem(), BIGBMWCHIPS);// 大宝马
			put(PrizeItem.BIGBENZ.getItem(), BIGBENZCHIPS);// 大奔驰
			put(PrizeItem.BIGPORSCHE.getItem(), BIGPORSCHECHIPS);// 大保时捷
		}
	};
	/**
	 * 8个门类中每门的押注筹码量
	 */
	@SuppressWarnings("serial")
	public final static ConcurrentHashMap<String, Long> CHIPSSET = new ConcurrentHashMap<String, Long>() {
		{// key=奖项,value=奖项押注额
			put(PrizeItem.MINVW.getItem(), 0L);
			put(PrizeItem.MINBMW.getItem(), 0L);
			put(PrizeItem.MINBENZ.getItem(), 0L);
			put(PrizeItem.MINPORSCHE.getItem(), 0L);
			put(PrizeItem.BIGVW.getItem(), 0L);
			put(PrizeItem.BIGBMW.getItem(), 0L);
			put(PrizeItem.BIGBENZ.getItem(), 0L);
			put(PrizeItem.BIGPORSCHE.getItem(), 0L);
		}
	};
	/**
	 * 每个门类中每位玩家的押注额
	 */
	@SuppressWarnings("serial")
	public static final ConcurrentHashMap<String, Map<Long, Long>> BETKINDPERPLAYER = new ConcurrentHashMap<String, Map<Long, Long>>() {
		{
			put(PrizeItem.MINVW.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.MINBMW.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.MINBENZ.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.MINPORSCHE.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.BIGVW.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.BIGBMW.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.BIGBENZ.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.BIGPORSCHE.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.SUMCHIPS.getItem(),new HashMap<Long,Long>());
		}
	};

	@SuppressWarnings("serial")
	public final static Map<String, String> REWARDITEM = new HashMap<String, String>() {
		{
			put(PrizeItem.MINVW.getItem().toUpperCase(), PrizeItem.MINVW.getItem());
			put(PrizeItem.MINBMW.getItem().toUpperCase(), PrizeItem.MINBMW.getItem());
			put(PrizeItem.MINBENZ.getItem().toUpperCase(), PrizeItem.MINBENZ.getItem());
			put(PrizeItem.MINPORSCHE.getItem().toUpperCase(), PrizeItem.MINPORSCHE.getItem());
			put(PrizeItem.BIGVW.getItem().toUpperCase(), PrizeItem.BIGVW.getItem());
			put(PrizeItem.BIGBMW.getItem().toUpperCase(), PrizeItem.BIGBMW.getItem());
			put(PrizeItem.BIGBENZ.getItem().toUpperCase(), PrizeItem.BIGBENZ.getItem());
			put(PrizeItem.BIGPORSCHE.getItem().toUpperCase(), PrizeItem.BIGPORSCHE.getItem());
			put(PrizeItem.SUMCHIPS.getItem().toUpperCase(), PrizeItem.SUMCHIPS.getItem());
		}
	};
	/**
	 * 每局游戏闲家押注总量
	 */
	public static final Map<String, Long> EACHWINSUMCHIPS =  Maps.newConcurrentMap();
	/**
	 * 上庄队列
	 */
	public static final Map<String, ConcurrentLinkedQueue<DealerQueueVo>> DEALERQUEUE = Maps.newConcurrentMap();
	/**
	 * 当前庄家上庄信息<fbId,DealerStatus>,当前庄家上庄次数,仅保存当前唯一庄家信息
	 */
	public static final ConcurrentLinkedQueue<DealerStatus> CURRENTDEALER = new ConcurrentLinkedQueue<DealerStatus>();

	public static final long LASTINGTIME = 29000;// 下注持续时间29秒,考虑网络传输延迟可按30秒

	public static long STARTRACINGCAR = 0;// 游戏开始时间

	public static long BETDEADTIME = 0; // 游戏截止押注时间

	public static final long SETTLEACCOUNTSLEEP = 4000L;// 指定结算线程睡眠时间+进入时间-执行完毕时间

	public static long ROBOTSBETCHIPS = 0L;// 小游戏中机器人总押注

	public static String RACINGCARID = IdGenerator.getNextId(); // 当前游戏ID

	public static Long REWAREPOOL = 0L;// 当前局游戏奖池

	public static Integer ROBOTINNING = 0;// 机器人局数
	
	public static String OpenItem="";//开奖选项
	
	/**
	 * wtu.edit 2015-12-10 系统奖池入池比列
	 */
	public static final double SYS_POOLS=0.8;
	public static final double SYS_POOLS_END=0.2;

	public static final ConcurrentHashMap<Long, PlayerInfoInSupremeRoom> BETCHIPSROBOTS = new ConcurrentHashMap<Long, PlayerInfoInSupremeRoom>();// 每局的押注机器人
	/**
	 * 押注机器人下注明细<item,<fbId,chips>>
	 */
	@SuppressWarnings("serial")
	public static final ConcurrentHashMap<String, Map<Long, Long>> BETROBOTCHIPS = new ConcurrentHashMap<String, Map<Long, Long>>() {
		{
			put(PrizeItem.MINVW.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.MINBMW.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.MINBENZ.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.MINPORSCHE.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.BIGVW.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.BIGBMW.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.BIGBENZ.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.BIGPORSCHE.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.SUMCHIPS.getItem(),new HashMap<Long, Long>());
		}
	};
	/**
	 * 系统押注筹码<门类,<筹码面额,该类面额量>>
	 */
	@SuppressWarnings("serial")
	public static final ConcurrentHashMap<String, Map<Long, Long>> ROBOTBETSMAP = new ConcurrentHashMap<String, Map<Long, Long>>() {
		{
			put(PrizeItem.MINVW.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.MINBMW.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.MINBENZ.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.MINPORSCHE.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.BIGVW.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.BIGBMW.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.BIGBENZ.getItem(), new HashMap<Long, Long>());
			put(PrizeItem.BIGPORSCHE.getItem(), new HashMap<Long, Long>());
		}
	};

	/**
	 * 机器人每门押注<门类,该门总押注>
	 */
	@SuppressWarnings("serial")
	public static final ConcurrentHashMap<String, Long> ROBOTCHIPS = new ConcurrentHashMap<String, Long>() {
		{
			put(PrizeItem.MINVW.getItem(), 0L);
			put(PrizeItem.MINBMW.getItem(), 0L);
			put(PrizeItem.MINBENZ.getItem(), 0L);
			put(PrizeItem.MINPORSCHE.getItem(), 0L);
			put(PrizeItem.BIGVW.getItem(), 0L);
			put(PrizeItem.BIGBMW.getItem(), 0L);
			put(PrizeItem.BIGBENZ.getItem(), 0L);
			put(PrizeItem.BIGPORSCHE.getItem(), 0L);
		}
	};
	/**
	 * 当前庄家上庄次数,仅保存当前唯一庄家信息
	 */
	// public static final ConcurrentHashMap<Long,Integer> DEALERSINNING = new
	// ConcurrentHashMap<Long,Integer>();

	/**
	 * 当前局押中一奖项闲家信息<fbId,Chips>
	 */
	public static final ConcurrentHashMap<Long, Long> WINPLAYERSINFO = new ConcurrentHashMap<Long, Long>();
	/**
	 * 当前局所有闲家押注信息(包括押中奖者和未押中奖者)
	 */
	public static final ConcurrentHashMap<Long, Long> REMITTINFO = new ConcurrentHashMap<Long, Long>();

	/**
	 * 系统奖池额
	 */
	@SuppressWarnings("serial")
	public static final ConcurrentHashMap<String, Long> SYSTEMREWARDPOOL = new ConcurrentHashMap<String, Long>() {
		{ // 系统初始奖池筹码量,可配置,默认为2000W
			try {
				put("systemRewardPool", LogicPropertyUtil.getLong("supremecar.system.rewardpool"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
	/**
	 * 系统庄返奖率
	 */
	@SuppressWarnings("serial")
	public static final ConcurrentHashMap<String, Float> SYSTEMREWARDRATE = new ConcurrentHashMap<String, Float>() {
		{ // 系统庄返奖概率
			try {
				put("systemRewardRate", LogicPropertyUtil.getFloat("supremecar.system.rewardrate"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
	/**
	 * 财富排行榜
	 */
	@SuppressWarnings("serial")
	public static final ConcurrentHashMap<String, List<WealthVo>> WEALTHLIST = new ConcurrentHashMap<String, List<WealthVo>>(3) {
		{
		}
	};
	/**
	 * 极品飞车机器人Long robotId
	 */
	public static final ConcurrentHashMap<Long, RobotVo> ROBOTSVO = new ConcurrentHashMap<Long, RobotVo>();
	/************************************** 小游戏常量池end *******************************************/

	/**
	 * 用户账户信息 Long fbid
	 */
	public static final ConcurrentHashMap<Long, UserFundInfoVo> USER_FUNDS = new ConcurrentHashMap<Long, UserFundInfoVo>();

	/**
	 * 新用户 Long fbid
	 */
	public static final ConcurrentHashMap<Long, Long> NEW_USERS = new ConcurrentHashMap<Long, Long>();

	/****
	 * 用户所在房间信息 String fbid
	 */
	public static final ConcurrentHashMap<String, ArrayList<UserInRoom>> USER_IN_ROOM = new ConcurrentHashMap<String, ArrayList<UserInRoom>>();
	/****
	 * 玩家小游戏racingcar信息 String fbId 
	 */
	public static final ConcurrentHashMap<Long, PlayerInfoInSupremeRoom> PLAYER_INFO_IN_SUPREMEROOM = new ConcurrentHashMap<Long, PlayerInfoInSupremeRoom>();
	/**
	 * 玩家离开房间
	 */
	public static final ConcurrentLinkedQueue<PlayerInfoInSupremeRoom> OFFLINEPLAYERS = new ConcurrentLinkedQueue<PlayerInfoInSupremeRoom>();
	/****
	 * 用户游戏信息 String fbid
	 */
	public static final ConcurrentHashMap<String, ArrayList<PlayerInfoInRoom>> PLAYER_INFO_IN_ROOM = new ConcurrentHashMap<String, ArrayList<PlayerInfoInRoom>>();

	/**
	 * 牌桌上用户玩家信息 String roomid Long fbid
	 */
	public static final ConcurrentHashMap<String, ConcurrentHashMap<Long, PlayerInfoInRoom>> PLAYER_ON_ROOM = new ConcurrentHashMap<String, ConcurrentHashMap<Long, PlayerInfoInRoom>>();

	/****
	 * 游戏开始信息vo String roomid
	 */
	public static final ConcurrentHashMap<String, GameBeginVo> GAME_ROOMS_BEGIN = new ConcurrentHashMap<String, GameBeginVo>();

	/****
	 * 游戏开始信息vo String gid
	 */
	public static final ConcurrentHashMap<String, GameBeginVo> GAME_ROOMS_BEGIN_ROUND = new ConcurrentHashMap<String, GameBeginVo>();

	/****
	 * 游戏结束信息vo(最近几十局) String roomid
	 */
	public static final ConcurrentHashMap<String, ArrayList<GameLogVo>> GAME_ROOMS_END = new ConcurrentHashMap<String, ArrayList<GameLogVo>>();

	public static final List<String> DRAW_RECORDS=new ArrayList<String>();
	
	
	/**
	 * 是否赠送筹码(第一次进入系统)<br/>
	 * Long fbid <br/>
	 * Integer 1:是否赠送筹码 2:登录赠送经验3:是否为新用户4:赠送充值卡通知 5:用户应急处理机制提示
	 */
	// public static final
	// ConcurrentHashMap<Long,ConcurrentHashMap<Integer,Object>> LOGINNOTICES =
	// new ConcurrentHashMap<Long,ConcurrentHashMap<Integer,Object>>();

	static {
		GameType type1 = new GameType(0, "0");// 多语言
		GAME_TYPES.put(0, type1);
		initOtherGameType();
	}
	
	
	public static synchronized final List<String> getDrawRecords()
	{
		if(DRAW_RECORDS!=null)
		{
			if(DRAW_RECORDS.size()>0)
			{
				return DRAW_RECORDS;
			}
		}
		List<String> tlist=AppContext.getBean(DrawRecordDao.class).readUserDraw();
		CarCache.DRAW_RECORDS.clear();
		CarCache.DRAW_RECORDS.addAll(tlist);
		return DRAW_RECORDS; 
	}
	
	public static synchronized final void setDrawRecords(List<String> recordlist)
	{
		CarCache.DRAW_RECORDS.clear();
		CarCache.DRAW_RECORDS.addAll(recordlist);
	}

	public static void initOtherGameType() {
		// 比赛其他信息
		String sql = "select CateId1,CateName1,Language from match_category1 WHERE Status=1";
		List<Map<String, Object>> list = AppContext.getBean(UsersDao.class).querySQLListWithMap(sql);
		for (Map<String, Object> item : list) {
			;
			Integer id = Integer.valueOf(item.get("CateId1").toString());
			// String name = rsct.getString("CateName1");
			String name = item.get("Language").toString();
			GameType gt = new GameType(id, name);
			CarCache.GAME_TYPES.put(id, gt);

		}
	}

	/**
	 * 返回房间map集合
	 */
	public static com.badugi.game.logic.model.domain.vo.game.Rooms getRoom(String rid) {
		if (LocalCache.ROOMS.containsKey(rid)) {
			return LocalCache.ROOMS.get(rid);
		}
		return null;
	}

	/**
	 * 返回小游戏玩家所在房间ConcurrentLinkedQueue
	 */
	public static PlayerInfoInSupremeRoom getPlayerInSupremeRoom(String fbId) {
		if (CarCache.PLAYER_INFO_IN_SUPREMEROOM.containsKey(fbId)) {
			return CarCache.PLAYER_INFO_IN_SUPREMEROOM.get(fbId);
		}
		return null;
	}

	/**
	 * 返回小游戏当前庄家
	 */
	public static DealerQueueVo getDealer(Long fbId) {
		DealerQueueVo currInRoom = CarCache.DEALERQUEUE.get(ConstantPool.DEALERQUEUE).element();
		if (currInRoom.getFbId().longValue() == fbId.longValue()) {
			return currInRoom;
		}
		return null;
	}

	/**
	 * 设置小游戏房间最大玩家数
	 */
	public static void setSupremeRoomsMc() {
		Integer playerCounts;
		try {
			playerCounts = LogicPropertyUtil.getInteger("supremecar.room.maxPlayers");
			Collection<SupremeRooms> supremerooms = SUPREMEROOMS.values();
			for (Iterator<SupremeRooms> it = supremerooms.iterator(); it.hasNext();) {
				SupremeRooms sr = it.next();
				sr.setMc(playerCounts);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}