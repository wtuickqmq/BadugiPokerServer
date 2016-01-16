package com.inkstd.badugi.game.common.constant;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/****
 * @createTime: 2012-10-22
 * @description:统一接口定义
 */
public class Definition {

	/************ cmd ***********/

	public final static String LOGIN = "login";
	public final static String GAMETYPE = "gametype";
	public final static String ROOMLEVEL = "gamelevel";
	public final static String ROOMS = "games";
	public final static String GAMEHB = "gamehb";
	public final static String JOINROOM = "joinroom";
	public final static String QUICKJOINROOM = "fastplay";
	public final static String ADDEXPVALUE = "addexpvalue";
	public final static String ADDMASTERVALUE = "addmastervalue";
	public final static String NEWLEVEL = "newlevel";
	public final static String LOBBYUSERFUND = "lobbyuserfundinfo";
	public final static String GETOFFROOMS = "offrooms";
	public final static String GAMEDETAILS = "gamedetail";
	public final static String MSGS = "msgs";
	public final static String NOTICES = "notices";
	public final static String FEEDBACKS = "feedbacks";
	public final static String OTHERPLAYLOGIN = "otherplaylogin";
	public final static String LEVELGETCHIPSMSG = "levelgetchipsmsg";
	public final static String MSGPROMPT = "msgprompt";
	
	public final static String MSGMATCH = "msgmatch";
	
	// add by fengpeijie 20150618 begin
	public final static String HORNMSGS = "hornmsgs"; // 用喇叭发消息
	
	public final static String DRAGON_BUY = "dragon_buy_q"; // 处理完q点购买神龙礼包返回大厅

	public final static String PLOTLINE = "plotline"; // 处理完q点购买神龙礼包返回大厅

	// add by fengpeijie 20150618 end

	/**
	 * 运营
	 */
	public final static String PRESENTCHIPSNOTICE = "presentchipsnotice";
	public final static String PRESENTPHONECARDNOTICE = "presentphonecard";
	public static final String NEWUSERCHIPS = "presentchips";
	public static final String GETCHIPSTIP = "getchipstip";
	public static final String PLEASEHELP = "pleasehelp";
	public static final String SPREADUSER = "spreaduser";
	public static final String HAVECHIPS = "havechips";
	public final static String USERCLICK = "userclick";
	public static final String TASKCOMPLETE = "taskcomplete";
	public static final String NEWTASKCOMPLETE = "newtaskcomplete";
	public static final String USERMSG = "usermsg";
	public static final String GLORYMSG = "glorymsg";
	public static final String DAYTASKCOMPLETE = "daytaskcompile";
	public static final String DAYTASKCOMPLETEINFO = "daytaskcompileinfo";
	public static final String DAYTASKCOMPLETERESULT = "daytaskcompileresult";
	public static final String NEWTASKCOMPLETEINFO = "newtaskcompileinfo";
	public static final String BOXCOMPLETEINFO = "boxcompileinfo";
	public static final String BOXTASKCOMPLETE = "boxtaskcomplete";
	public static final String FLAGTIPMSGS = "flagtipmsgs";
	public static final String WINPROMPT = "winprompt";
	public final static String FIRSTWIN = "firstwin";
	public final static String ONLINEMSG = "onlinemsg";
	public final static String LEAVEROOMMSG = "leaveroommsg";
	public final static String FREECHIPSTASKCOMPLETE = "freechipstaskcomplete";
	public final static String GAMETASKCOMPLETE = "gametaskcomplete";
	public final static String NUBOXCOMPLETE = "nuboxcomplete";
	public final static String SUCCESSBUYCHIPS = "successbuychips";
	public final static String GETDECORATE = "getdecorate";

	/****
	 * 比赛
	 */
	public final static String MATCHTYPES = "matchtype";
	public final static String MATCHLEVELS = "matchlevel";
	public final static String MATCHS = "matchlist";
	public final static String CMATCHS = "championships";
	public final static String FLASH_BEGIN = "joinmatchroom";
	public final static String LOOKMATCHPLAYDETAIL = "lookmatchplaydetail";
	public final static String CLEARMMRSOCKET = "cleartmrsocket";
	public final static String MATCHPLAYDETAIL = "matchplaydetail";
	public final static String MATCHROOMINFO = "matchroominfo";
	public final static String MATCHROOMDETAIL = "matchroomdetail";
	public final static String MATCHRANK = "matchrank";
	public final static String MYMATCHRANK = "mymatchrank";
	public final static String MATCHREWARDAMOUNT = "rewardmatchamount";
	public final static String JOINMATCHROOM = "joinmatchroom";
	public final static String SYSCANCELMATCH = "syscancelmatch";
	public final static String MATCHSOONBEGIN = "matchsoonbegin";
	public final static String MATCHRETURN = "matchreturn";
	public final static String LOOKMATCHWAITDETAIL = "lookmatchwaitdetail";
	public final static String CLOSEMWRSOCKET = "closemwsocket";
	public final static String TODAYMATCHDETAIL = "todaymatchdetail";
	public final static String SNGMATCHDETAIL = "sngmatchdetail";
	
	/***
	 * 聚宝盆
	 */
	public final static String JEWELBOXUPDATEMONEY = "jewelboxupdatemoney";//更新奖金
	public final static String JEWELBOXOPEN = "jewelboxopen";//聚宝盆开奖
	public final static String SENDJEWELBOXMONEY="jewelboxupdate";
	
	/***
	 * 摇摇乐
	 */
	public final static String SHAKEOPEN="shakeopen";//摇摇乐开奖
	
	public final static String INVITATIONS="invitations";//牌桌内邀请好友
	
	// add by fengpeijie 20150518 begin
	public final static String PRESENTGIFT="presentgift";//赠送礼物
	// add by fengpeijie 20150518 end
	
	/**
	 * wtu.edit
	 * 返回赢利数据
	 */
	public final static String BACKCHIPS="backchips";
	/**
	 * wtu.edit
	 * 返回小游戏服务器IP和端口
	 */
	public final static String JOINCARSROOM = "joincarsroom";
	
	
	/***
	 * 操作成功
	 */
	public final static long SUCCESS_CODE = 20000L;

	/***
	 * 未登录
	 */
	public final static long NOLOGIN_CODE = 20001L;

	/***
	 * 参数错误
	 */
	public final static long ARG_CODE = 20005L;

	/***
	 * 房间不存在
	 */
	public final static long NOROOM_CODE = 20007L;

	/***
	 * 打开房间超出最大数
	 */
	public final static long OUTSET_CODE = 20011L;

	/***
	 * 同一父账号不能同一桌
	 */
	public final static long REPEAT_CODE = 20012L;

	/**
	 * 已经用完帮助次数
	 */
	public final static long HELPOUT_CODE = 20014L;

	/*****
	 * 筹码不够足以快速开始选房间
	 */
	public final static long NO_ENO_CHIPS = 20015L;
	

	/**
	 * 签名错误
	 */
	public final static long SIGN_ERROR_CODE = 20016L;
	
	/**
	 * 筹码不足引导用户冲值
	 */
	public final static long PLEASE_RE_CHARGE = 20017L;
	
	/**
	 * 房间玩家已满
	 */
	public final static long FULL_ROOM_CODE = 20018L;
	
	/**
	 * 房间满时的人数
	 */
	public final static int FULL_ROOM_MANS = -99999999;
	
	/*------------------摇摇乐-----------------*/

	/**
	 * 下注成功，并开奖
	 */
	public final static long BET_SUCCESS = 20100L;
	
	/**
	 * 下注用户不存在
	 */
	public final static long BET_USER_NOT = 20101L;
	
	/**
	 * 下注金额不足
	 */
	public final static long BET_MONEY_NOT_ENOUGH = 20102L;
	
	/**
	 * 下注未知错误
	 */
	public final static long BET_UNKNOW = 20200L;

	/*****
	 * 服务器启停
	 */
	public final static long SERVER_STOP_CODE = 22222L;

	/***
	 * 操作失败
	 */
	public final static long UNKNOW_CODE = 29999L;

	/** 消息类型
	 *  {type ,value} 1 九客币，2 Q点，3 筹码，4 VIP积分
	 * */
	public static final short[] MSG_TYPES = {1,2,3,4,5,6};
	
	
/********************************极品豪车小游戏 start*****************************/
	
	public final static Long SUPREMECAR_ROOM_NOTEXISTS = 20106L;//小游戏房间不存在
	public final static Long JOIN_RACINGCAR_ROOM_FAILED_CODE = 20107L;//加入极品飞车房间异常
	public final static Long JOIN_RACINGCAR_ROOM_FULL_CODE = 20108L; //加入极品飞车房间已满
	public final static Long RACINGCAR_SUCCESS_CODE = 20109L; //加入小游戏房间成功	
	public final static Long PLAYER_ALREADY_DEALER_CODE=20110L;//当前上庄玩家已经在上庄列表
	public final static Long BETCOMPLETE_SUCCESS_CODE = 20111L;//押注完成,开始跑灯
	public final static Long NO_ENOUTH_CHIPS_CODE=20112L;//上庄或押注筹码不足
	public final static String ONDEALER_INVALID_CHIPS = "您上庄筹码或大厅筹码不足以上庄,请充值";
	public final static String BET_INVALID_CHIPS = "您大厅筹码不足以押注,请充值";
	public final static String WEALTHKEY = "wealthkey";  //前三位玩家的土豪榜键值
	//public final static String DEAL_BET_EXCEPTION = "deal_bet_exception";
	//public final static String DEAL_BET_COMPLETE="deal_bet_complete";//押注完成,开始跑灯
	public final static String OPERTYPE = "欢迎玩家进入极品豪车游戏";
	public final static String OPERCONTENT = "欢迎玩家进入极品豪车游戏";
	public final static String OPERREMARK = "欢迎玩家进入极品豪车游戏";
	public final static String OPERTYPEFULL = "玩家进入极品豪车游戏房间已满";
	public final static String OPERCONTENTFULL = "玩家进入极品豪车游戏房间已满";
	public final static String OPERREMARKFULL = "玩家进入极品豪车游戏房间已满";
	public final static String OPERTYPEERROR = "玩家进入极品豪车游戏出现异常";
	public final static String OPERCONTENTERROR = "玩家进入极品豪车游戏出现异常";
	public final static String OPERREMARKERROR = "玩家进入极品豪车游戏出现异常";
	public final static String DOWN_DEALER_DESCRIPTION = "该局结束后您会自动下庄";
	public final static String COLLECTIONBET_EXCEPTION ="collectionbet_exception";
	public final static String COLLECTIONBET_EXCEPTION_TYPE ="闲家下注异常";
	
	/**
	 * 15个投注时间点数组
	 */
	//public static Integer [] TIMEARRAY = new Integer[]{};
	/**
	 * 枚举30个模拟下注时间点
	 */
	@SuppressWarnings("serial")
	public final static TreeMap<Integer,Integer> TIMEPOINTS = new TreeMap<Integer,Integer>(){{
		put(0,0);put(1,0);put(2,0);put(3,0);put(4,0);put(5,0);put(6,0);put(7,0);put(8,0);put(9,0);put(10,0);
		put(11,0);put(12,0);put(13,0);put(14,0);put(15,0);put(16,0);put(17,0);put(18,0);put(19,0);put(20,0);
		put(21,0);put(22,0);put(23,0);put(24,0);put(25,0);put(26,0);put(27,0);put(28,0);put(29,0);}};//下注时间点(秒点)
	@SuppressWarnings("serial")
	public final static TreeMap<Integer,Integer> TIMEPOINTSBACKUP = new TreeMap<Integer,Integer>(){{
		put(0,0);put(1,0);put(2,0);put(3,0);put(4,0);put(5,0);put(6,0);put(7,0);put(8,0);put(9,0);put(10,0);
		put(11,0);put(12,0);put(13,0);put(14,0);put(15,0);put(16,0);put(17,0);put(18,0);put(19,0);put(20,0);
		put(21,0);put(22,0);put(23,0);put(24,0);put(25,0);put(26,0);put(27,0);put(28,0);put(29,0);}};//下注时间点(秒点)(备份)(重置初始值)
	public final static Integer[] CHIPSET = new Integer[] {1,2,5,10,20,50,100,200,500,(int) 1E3,(int) 2E3,(int) 5E3,(int) 1E4,(int) 2E4,(int) 5E4,(int) 1E5};//15种下注筹码
	public final static Integer[] SUBCHIPSET = new Integer[] {10,20,50,100,200,500,(int)1E3,(int) 2E3,(int) 5E3,(int) 1E4};//用于系统模拟玩家下注
	@SuppressWarnings("serial")
	public final static List<Integer> CHIPSLEVEL1 = new ArrayList<Integer>(){{add(1);add(2);add(5);}};
	@SuppressWarnings("serial")
	public final static List<Integer> CHIPSLEVEL2 = new ArrayList<Integer>(){{add(10);add(20);add(50);}};
	@SuppressWarnings("serial")
	public final static List<Integer> CHIPSLEVEL3 = new ArrayList<Integer>(){{add(100);add(200);add(500);}};
	@SuppressWarnings("serial")
	public final static List<Integer> CHIPSLEVEL4 = new ArrayList<Integer>(){{add((int)1e3);add((int)2e3);add((int)5e3);}};
	@SuppressWarnings("serial")
	public final static List<Integer> CHIPSLEVEL5 = new ArrayList<Integer>(){{add((int)1e4);add((int)2e4);add((int)5e4);}};
	/**
	 * 定义飞车游戏押注异常类别
	 */
	@SuppressWarnings("serial")
	public final static List<String> EXCEPTIONS = new ArrayList<String>(){{
		add("登录异常");
		add("抢庄异常");
		add("上庄异常");
		add("坐庄异常");
		add("下庄异常");
		add("下注异常");
		add("结算异常");
		add("卡住异常");
		add("筹码返回异常");
		add("收发消息异常");
	}};
	/********************************极品豪车小游戏  end*****************************/
	/**
	 * 狂暴飞车
	 */
	public final static String JOINRACINGCAR = "joinracingcar";
	public final static String SUPREMECARROOMNOTEXISTS = "supremecarroomnotexists" ;
	public final static String JOINRACINGCARROOMFAILED = "joinracingcarroomfailed";
	public final static String JOINSUPREMECARROOMSUCCESS = "joinsupremecarroomsuccess";
	public final static String JOINRACINGCARROOMFULL = "joinracingcarroomfull";
	
}
