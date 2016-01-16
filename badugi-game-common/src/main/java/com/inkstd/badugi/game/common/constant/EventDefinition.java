package com.inkstd.badugi.game.common.constant;
/**
 * @description：事件定义
 */
public class EventDefinition {
	
	
	/***
	 * 与FALSH 交互定义------------------------------------------------------------------------------------
	 */
	
	
	/****
	 * 退出
	 */
	public static final String EVENT_BEY = "e_bye";
	
	/***
	 * 登录
	 */
	public static final String EVENT_LOGIN = "e_login";
	
	/***
	 * 游戏类型
	 */
	public static final String EVENT_GAMETYPE = "e_gametype";
	
	/**
	 * 游戏大厅跟flash心跳
	 */
	public static final String EVENT_GAMEHB = "e_gamehb";
	
	/***
	 * 获取房间等级信息
	 */
	public static final String EVENT_GET_ROOM_LEVELS = "e_roomlevels";
	
	/***
	 * 获取房间信息
	 */
	public static final String EVENT_GET_ROOM = "e_rooms";
	
	/***
	 * 登录房间
	 */
	public static final String EVENT_JOIN_ROOM = "e_joinroom";
	
	/**
	 * 大厅用户信息
	 */
	public static final String EVENT_LOBBY_USERFUND_INFO = "e_lobbyuserfundinfo";
	
	/**
	 * 断线房间列表
	 */
	public static final String EVENT_GETOFF_ROOMS = "e_getoffrooms";
	
	/**
	 * 大厅房间详情信息
	 */
	public static final String EVENT_GAME_DETAIL = "e_gamedetail";
	
	/**
	 * 消息
	 */
	public static final String EVENT_MSGS = "e_msgs";
	
	/**
	 * 公告
	 */
	public static final String EVENT_NOTICES = "e_notices";
	
	/**
	 * 意见反馈
	 */
	public static final String EVENT_FEEDBACKS = "e_feedbacks";
	
	/*****
	 * 最小筹码
	 */
	public static final String EVENT_MIN_CHIPS = "e_havechips";
	
	
	/*******
	 * 比赛 相关定义 ---------------------------------------------------------------------------------------
	 */
	
	/***
	 * 类型定义
	 */
	public static final String EVENT_MATCHTYPE = "e_matchtype";

	/***
	 * 获取比赛房间等级信息
	 */
	public static final String EVENT_GET_MATCH_LEVELS = "e_matchlevels";

	/***
	 * 获取比赛房间信息
	 */
	public static final String EVENT_GET_MATCH = "e_matchlists";
	
	/***
	 * 获取锦标赛房间信息
	 */
	public static final String EVENT_GET_CMATCH = "e_championships";
	
	/**
	 * 打开比赛详情面板
	 */
	public static final String EVENT_LOOKMATCHDETAIL = "e_lookmatchplaydetail";
	/**
	 * 关闭比赛详情面板
	 */
	public static final String EVENT_CLOSEMRSOCKET = "e_cleartmrsocket";
	/**
	 * 查看赛事房间详情
	 */
	public static final String EVENT_MATCHROOMDETAIL = "e_matchroomdetail";
	/**
	 * 进入比赛房间
	 */
	public static final String EVENT_JOINMATCHROOM = "e_joinmatchroom";
	/**
	 * 打开比赛等待面板
	 */
	public static final String EVENT_LOOKMATCHWAITDETAIL = "e_lookmatchwaitdetail";
	/**
	 * 关闭比赛等待面板
	 */
	public static final String EVENT_CLOSEMWSOCKET = "e_closemwsocket";
	/**
	 * SNG坐满就玩狂欢赛 
	 */
	public static final String EVENT_SNGMATCHDETIAL = "e_sngmatchdetail";
	
	
	/****************************运营相关**************************************/
	/**
	 * 第一次获取赠送筹码
	 */
	public static final String EVENT_NEWUSER_CHIPS = "e_presentchips";
	
	/**
	 * 帮助弹出层
	 */
	public static final String EVENT_PLEASEHELP_CHIPS = "e_pleasehelp";
	
	/**
	 * 点击获取筹码面板中推广员弹窗
	 */
	public static final String EVENT_SPREAD_USERS = "e_spreaduser";
	/***
	 * 快速开始
	 */
	public static final String EVENT_FAST_PLAY = "e_fastplay";
	/**
	 * 用户操作
	 */
	public static final String EVENT_USERCLICK = "e_userclick";
	
	/**
	 * 荣誉消息推送
	 */
	public static final String EVENT_GLORYMSG = "e_glorymsg";
	
	
	/*****
	 * 与MQ 交互定义 -------------------------------------------------------------------------------------------
	 */
	
	/***
	 * 房间等级
	 */
	public static final String UPDATE_ROOM_LEVELS = "updatelevels";
	
	/***
	 * 房间等级
	 */
	public static final String UPDATE_ROOM = "updaterooms";
	/***
	 * 删除房间
	 */
	public static final String DELETE_ROOM = "removerooms";
	/****
	 * 登录房间
	 */
	public static final String UPDATE_USERINFO_ROOM = "updateroomplayers";
	
	/************************************摇摇乐相关*****************************/
	public static final String EVENT_BET_SHAKE="e_betshake";
	
	/********************************奔驰宝马小游戏start*********************************/
	
	/**
	 * 登录/重置游戏racingcar返回命令
	 */
	public static final String EVENT_LAUNCH_RACING_RETURN = "launch_racing";
	/**
	 * 登录/重置游戏racingcar
	 */
	public static final String EVENT_LAUNCH_RACING = "e_launch_racing";
	/**
	 * 玩家申请上庄命令
	 */
	public static final String 	EVENT_UP_DEALER = "e_up_dealer";
	/**
	 * 玩家申请上庄返回信息命令
	 */
	public static final String 	EVENT_UP_DEALER_RETURN = "up_dealer";
	/**
	 * 系统投注命令
	 */
	public static final String EVENT_SYSTEM_BET = "system_bet";
	/**
	 * 开始进入游戏押注环节
	 */
	public static final String EVENT_START_BET = "start_bet";
	/**
	 * 玩家进入押注
	 */
	public static final String EVENT_E_BET = "e_bet";
	/**
	 * 押注完成,开始跑灯
	 */
	public static final String EVENT_STOP_BET = "stop_bet";
	/**
	 * 停止跑灯
	 */
	public static final String EVENT_STOP_CHASE = "stop_chase";
	/**
	 * 返回客户端的押注筹码
	 */
	public static final String BET_CHIPS_CMD="bet_chips";
	/**
	 * 玩家押注时某一门超过押注上限时
	 */
	public static final String BET_HIT_MAXLIMIT = "bet_hit_maxlimit";
	/**
	 * 玩家押注时某一门刚好达到押注上限时
	 */
	public static final String BET_HIT_FULL = "bet_hit_full";
	/**
	 * 游戏跑灯结束,计算庄家/玩家筹码结果
	 */
	public static final String EVENT_WIN_RESULT = "win_result";
	/**
	 * 每局游戏开始更新庄家信息
	 */
	public static final String EVENT_UPDATE_DEALER = "update_dealer";
	
	/**
	 * 庄家结算结果命令
	 */
	public static final String EVENT_DEALER_RESULT = "dealer_result";
	/**
	 * 庄家与玩家结算结果信息
	 */
	public static final String EVENT_PLAYER_DEALER = "player_dealer";
	/**
	 * 庄家连续坐庄信息
	 */
	public static final String 	EVENT_DEALER_INFO = "dealerInfo";
	/**
	 * 开奖结算
	 */
	public static final String EVENT_PRIZE_CALCULATE = "prize_calculate";
	/**
	 * 开奖异常
	 */
	public static final String EVENT_WIN_EXCEPTION = "win_exception";
	/**
	 * 闲家进入并开始游戏
	 */
	public static final String EVENT_JOINANDSTART_SUPREMECAR = "joinandstart_supremecar";
	/**
	 * 庄家申请下庄
	 */
	public static final String EVENT_E_DOWN_DEALER = "e_down_dealer";
	/**
	 * 庄家申请下庄返回
	 */
	public static final String EVENT_DOWN_DEALER = "down_dealer";
	/**
	 * 申请下庄异常返回
	 */
	public static final String EVENT_DOWNDEALER_EXCEPTION = "downdealer_exception";
	/**
	 * 庄家退出游戏
	 */
	public static final String EVENT_EXIT_SUPREMECAR = "escape_exit";
	/**
	 * 玩家之间公共聊天(发送消息)
	 */
	public static final String EVENT_PLAYER_IM_SEND = "player_im_send";
	/**
	 * 玩家之间公共聊天(接收消息)
	 */
	public static final String EVENT_PLAYER_IM_RECEIVE = "player_im_receive";
	/*******************************奔驰宝马小游戏end***********************************/
	/**
	 * 狂暴飞车
	 */
	public final static String JOINRACINGCAR = "joinracingcar";
	public final static String SUPREMECARROOMNOTEXISTS = "supremecarroomnotexists" ;
	public final static String JOINRACINGCARROOMFAILED = "joinracingcarroomfailed";
	public final static String JOINSUPREMECARROOMSUCCESS = "joinsupremecarroomsuccess";
	public final static String JOINRACINGCARROOMFULL = "joinracingcarroomfull";
		
	
}
