package com.badugi.game.logic.model.domain.vo.flash;

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
	
	// add by fengpeijie 20150618 begin
	public final static String HORNMSGS = "hornmsgs"; // 用喇叭发消息
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
	public final static String JEWELBOXBET="jewelboxbet";//聚宝盆下注
	public final static String JEWELBOXOPEN = "jewelboxopen";//聚宝盆开奖
	public final static String SENDJEWELBOXMONEY="jewelboxupdate";
	
	/***
	 * 摇摇乐
	 */
	public final static String SHAKECONFIG="shakeconfig";//摇摇乐开奖
	public final static String SHAKEOPEN="shakeopen";//摇摇乐开奖
	
	
	public final static String INVITATIONS="invitations";//牌桌内邀请好友
	
	public final static String GET_INVITATIONS_LIST="invitations_list";//牌桌内邀请好友
	
	
	
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
	
	/**
	 * wtu.add 2015-10-12
	 * 通知机器人，有人加入房间，并发送房间数据
	 *
	 */
	public final static String SENDROBOTROOM="sendrobotroom";
	
	/**
	 * wtu.add 2015-10-12
	 * 返回牌桌追踪数据
	 */
	public final static String TRACK="track";
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

	/** 消息类型*/
	public static final short[] MSG_TYPES = {1,2,3,4,5,6};
}
