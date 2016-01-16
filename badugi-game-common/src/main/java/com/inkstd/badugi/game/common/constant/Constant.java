package com.inkstd.badugi.game.common.constant;

/**
 * 常量类
 * 
 * @author lion
 */
public final class Constant {
	/**
	 * 默认排序
	 */
	public static final int ORDER_BY_DEFAULT = 0;
	/**
	 * 降序排序
	 */
	public static final int ORDER_BY_DESC = 1;
	/**
	 * 升序排序
	 */
	public static final int ORDER_BY_ASC = 2;
	/**
	 * 单抽次数给紫卡
	 */
	public static final int TAKE_PURPLE_TIME = 10;
	/**
	 * 竞技场最大世界战报数量
	 */
	public static final int MAX_ARENA_REPORT_NUM_COMMON = 3;
	/**
	 * 跨服竞技场最大世界战报数量
	 */
	public static final int MAX_CROSS_REPORT_NUM_COMMON = 10;
	/**
	 * 竞技场最大玩家战报数量
	 */
	public static final int MAX_ARENA_REPORT_NUM_ROLE = 7;
	/**
	 * 获取最大的登录天数
	 */
	public static final int MAX_LOGIN_DAY = 31;
	/**
	 * 本地数值更新
	 */
	public static final int UPGRADE_BY_LOACAL = 1;
	/**
	 * 远程数值更新
	 */
	public static final int UPGRADE_BY_REMOTE = 2;
	/**
	 * 活动更新
	 */
	public static final int UPGRADE_ALL = 3;
	/**
	 * 关卡类型:普通关卡
	 */
	public static final int LEVEL_TYPE_SIMPLE = 1;
	/**
	 * 关卡类型:活动关卡
	 */
	public static final int LEVEL_TYPE_ACTIVE = 2;
	/**
	 * 关卡类型:英雄关卡
	 */
	public static final int LEVEL_TYPE_HERO = 3;
	/**
	 * 关卡类型:新手关卡
	 */
	public static final int LEVEL_TYPE_NEW = 4;
	/**
	 * 消息推送
	 */
	public static final int JPUSH_CUSTOM_MESSAGE = 1;
	/**
	 * 通知推送
	 */
	public static final int JPUSH_NOTIFICATION = 2;
	/**
	 * 系统类型
	 */
	public static final byte TYPE_SYSTEM = 1;
	/**
	 * 玩家类型
	 */
	public static final byte TYPE_ROLE = 2;
	/**
	 * 消息类型: 抽卡
	 */
	public static final int MSG_TYPE_CARD_TAKE = 3;
	/**
	 * 消息类型: 进化/升级
	 */
	public static final int MSG_TYPE_CARD_DJ = 4;
	/**
	 * 消息类型: 竞技场
	 */
	public static final int MSG_TYPE_ARENA = 5;
	/**
	 * 消息类型:点金手
	 */
	public static final int MSG_TYPE_DOGOLD = 6;
	/**
	 * 消息类型:帮助信息
	 */
	public static final int MSG_TYPE_HELP = 7;
	/**
	 * 竞技场每日可以免费挑战的次数
	 * 
	 */
	public static final int MAX_ARENA_TIMES = 10;
	/**
	 * 竞技场新增挑战次数消耗钻石的金额
	 */
	public static final int PRICE_ARENA_TIMES = 50;
	/**
	 * 一天的秒数
	 */
	public static final int ONE_DAY_SEC = 60 * 60 * 24;
	/**
	 * 一小时的秒数
	 */
	public static final int ONE_HOUR_SEC = 60 * 60;
	/**
	 * 抽取卡牌所需要的友情点 .
	 */
	public static final int CARD_TAKE_FRIENDPOINT = 100;
	/**
	 * 抽取卡牌所需要的点券 .
	 */
	public static final int CARD_TAKE_CASH = 240;
	/**
	 * 10连抽
	 */
	public static final int CARD_TAKE_10 = 2000;
	/**
	 * 高级抽卡
	 */
	public static final int CARD_TAKE_ADVANCED = 880;
	/**
	 * 默认卡牌背包数量 .
	 */
	public static final int DEFAULT_CARD_BAGS = 100;
	/**
	 * 默认血迹卡背包数量 .
	 */
	public static final int DEFAULT_AFCARD_BAGS = 100;
	/**
	 * 最大体力值 .
	 */
	public static final int DEFAULT_POWER = 100;
	/**
	 * 最大背包 .
	 */
	public static final int MAX_BAGS = 300;
	/**
	 * 最大竞技场点数 .
	 */
	public static final int MAX_MATCH_POINT = 3;
	/**
	 * 5分鐘恢復2點体力 .
	 */
	public static final int RESTORE_POWER = 5 * 60 * 1000;
	/**
	 * 一小时恢复一点体力 .
	 */
	public static final int RESTORE_MATCH_POINT = 60 * 60 * 1000;
	/**
	 * 钻石价格
	 */
	public static final int MALL_PRICE_DIAMOND = 30;

	/**
	 * 体力价格
	 */
	public static final int MALL_PRICE_POWER = 30;

	/**
	 * 背包价格
	 */
	public static final int MALL_PRICE_BAGS = 50;

	/**
	 * 竞技场价格
	 */
	public static final int MALL_PRICE_MATCH = 50;

	/**
	 * 邮件最大数量
	 */
	public static final int MAIL_MAX_NUM = 50;
	// /**
	// * 进行中
	// */
	// public static final int ACTION_CONDUCT = 0;
	// /**
	// * 完成
	// */
	// public static final int ACTION_FINISHED = 1;
	//
	// /**
	// * 完成过
	// */
	// public static final int ACTION_COMPLETED = 1;
	//

	/**
	 * 账户类型:RMB
	 */
	public static final int TYPE_RMB = 0;
	/**
	 * 账户类型:金币
	 */
	public static final int TYPE_GOLD = 1;
	/**
	 * 账户类型:钻石
	 */
	public static final int TYPE_CASH = 2;
	/**
	 * 账户类型:卡牌
	 */
	public static final int TYPE_CARD = 3;
	/**
	 * 账户类型:体力
	 */
	public static final int TYPE_POWER = 4;
	/**
	 * 账户类型:友情点
	 */
	public static final int TYPE_FRIENDPOINT = 5;
	/**
	 * 账户类型: 勋章
	 */
	public static final int TYPE_MEDAL = 6;
	/**
	 * 账户类型: 兵粮丸
	 */
	public static final int TYPE_ARENAGOLD = 7;
	/**
	 * 账户类型: 勾玉
	 */
	public static final int TYPE_BOSSGOLD = 8;
	/**
	 * 账户类型: 普通碎片
	 */
	public static final int TYPE_DEBRIS1 = 9;
	/**
	 * 账户类型: 特级碎片
	 */
	public static final int TYPE_DEBRIS2 = 10;
	/**
	 * 账户类型: 影级碎片
	 */
	public static final int TYPE_DEBRIS3 = 11;
	/**
	 * 账户类型: 血迹
	 */
	public static final int TYPE_AFBLOOD = 12;
	/**
	 * 账户类型: 装备
	 */
	public static final int TYPE_EQUIP = 13;
	/**
	 * 账户类型: 随机卡牌
	 */
	public static final int TYPE_RANDOM_CARD = 14;
	/**
	 * 账户类型: 卡框
	 */
	public static final int TYPE_BG_EFFECT = 15;
	/**
	 * 房间最大数量
	 */
	public static final int ROOM_MAX_NUM = 32;

	/**
	 * 卡牌获得来源:建角送卡
	 */
	public static final int CARD_FROM_CREATE_ROLE = 9000;
	/**
	 * 卡牌获得来源:友情抽卡
	 */
	public static final int CARD_FROM_TAKE_FRIENDSHIP = 9001;
	/**
	 * 卡牌获得来源:点券单抽
	 */
	public static final int CARD_FROM_TAKE_SIMPLE = 9002;
	/**
	 * 卡牌获得来源:点券十连抽
	 */
	public static final int CARD_FROM_TAKE_TEN = 9003;
	/**
	 * 卡牌获得来源:普通副本掉落
	 */
	public static final int CARD_FROM_DROP_POLT = 9004;
	/**
	 * 卡牌获得来源:活动副本掉落
	 */
	public static final int CARD_FROM_DROP_ACTIVE = 9005;
	/**
	 * 卡牌获得来源:每日登陆奖励
	 */
	public static final int CARD_FROM_AWARD_LOGIN = 9006;
	/**
	 * 卡牌获得来源:充值VIP,领取奖励获得
	 */
	public static final int CARD_FROM_AWARD_VIP = 9007;
	/**
	 * 卡牌获得来源:系统后台发放
	 */
	public static final int CARD_FROM_SEND = 9008;
	/**
	 * 卡牌获得来源:CDK兑换
	 */
	public static final int CARD_FROM_CDKEY = 9009;
	/**
	 * 卡牌获得来源:竞技场奖励
	 */
	public static final int CARD_FROM_AWARD_MATCH = 9010;
	/**
	 * 卡牌获得来源:卡牌满级赠送
	 */
	public static final int CARD_FROM_SYSTEM_LEVEL = 9011;
	/**
	 * 卡牌获得来源:活动奖励
	 */
	public static final int CARD_FROM_AWARD_ACTIVE = 9012;
	/**
	 * 卡牌获得来源:进化获得
	 */
	public static final int CARD_FROM_CARD_DJ = 9013;
	/**
	 * 卡牌获得来源:新手引导
	 */
	public static final int CARD_FROM_ROLE_NEW = 9014;
	/**
	 * 卡牌获得来源:邮件收取
	 */
	public static final int CARD_FROM_GAMEMAIL = 9015;
	/**
	 * 卡牌获得来源:邀请获得
	 */
	public static final int CARD_FROM_INVITE = 9016;
	/**
	 * 卡牌获得来源:膜拜获得
	 */
	public static final int CARD_FROM_WORSHIP = 9017;
	/**
	 * 卡牌获得来源:勋章兑换获得
	 */
	public static final int CARD_FROM_MEDAL = 9018;
	/**
	 * 卡牌获得来源:关卡星级奖励
	 */
	public static final int CARD_FROM_AWARD_STAR = 9019;
	/**
	 * 卡牌获得来源:新手教程获得
	 */
	public static final int CARD_FROM_TAKE_NEW = 9020;
	/**
	 * 卡牌获得来源:扫荡获得
	 */
	public static final int CARD_FROM_SWEEPING = 9021;
	/**
	 * 卡牌获得来源:竞技场货币兑换
	 */
	public static final int CARD_FROM_AREAN_GOLD = 9022;
	/**
	 * 卡牌获得来源: 勾玉兑换
	 */
	public static final int CARD_FROM_BOSSGOLD_GET = 9023;
	/**
	 * 卡牌获得来源: 分解获得
	 */
	public static final int CARD_FROM_MARKS = 9024;
	/**
	 * 卡牌获得来源: 高级抽卡
	 */
	public static final int CARD_FROM_TAKE_ADVANCED = 9025;
	/**
	 * 卡牌获得来源: 置换1
	 */
	public static final int CARD_FROM_REPLACE1 = 9026;
	/**
	 * 卡牌获得来源: 置换2
	 */
	public static final int CARD_FROM_REPLACE2 = 9027;
	/**
	 * 卡牌获得来源: 普卡碎片兑换
	 */
	public static final int CARD_FROM_DEBRIS1 = 9028;
	/**
	 * 卡牌获得来源: 特卡碎片兑换
	 */
	public static final int CARD_FROM_DEBRIS2 = 9029;
	/**
	 * 卡牌获得来源: 影卡碎片兑换
	 */
	public static final int CARD_FROM_DEBRIS3 = 9030;
	/**
	 * 卡牌获得来源: 钻石礼包
	 */
	public static final int CARD_FROM_PACKAGE_CASH = 9031;
	/**
	 * 卡牌获得来源: 卡牌复制
	 */
	public static final int CARD_FROM_COPY = 9032;
	/**
	 * 卡牌获得来源: 无尽试炼奖励
	 */
	public static final int CARD_FROM_BATTLE_MORE = 9033;

	/**
	 * 每日最大赠送好友体力的数量
	 */
	public static final int FRIEND_POWER_MAX_SEND = 12;
	// /**
	// * 每日最大接收好友赠送的体力数量
	// */
	public static final int FRIEND_POWER_MAX_GET = 10;
	/**
	 * 每日最大接收好友赠送的体力数量
	 */
	// public static final int FRIEND_POWER_MAX_GET = 20;
	/**
	 * 好友体力赠送的数量
	 */
	public static final int FRIEND_POWER_ADD = 6;

	/**
	 * 钻石消耗途径:点券单抽
	 */
	public static final int EXPEND_CASH_TAKE_SIGN = 7001;
	/**
	 * 钻石消耗途径:点券十连抽
	 */
	public static final int EXPEND_CASH_TAKE_TEN = 7002;
	/**
	 * 钻石消耗途径:购买体力
	 */
	public static final int EXPEND_CASH_BUY_POWER = 7003;
	/**
	 * 钻石消耗途径:购买背包
	 */
	public static final int EXPEND_CASH_BUY_BAGS = 7004;
	/**
	 * 钻石消耗途径:购买竞技场点数
	 */
	public static final int EXPEND_CASH_BUY_MATCHPOINT = 7005;
	/**
	 * 钻石消耗途径:队长技能学习
	 */
	public static final int EXPEND_CASH_RANDOMCAPTAIN = 7006;
	/**
	 * 钻石消耗途径:战斗全体复活
	 */
	public static final int EXPEND_CASH_BATTLE_RELIVEALL = 7007;
	/**
	 * 金币消耗途径:战斗复活
	 */
	public static final int EXPEND_GOLD_BATTLE_RELIVE = 7008;
	/**
	 * 金币消耗途径:卡牌进化
	 */
	public static final int EXPEND_GOLD_CARD_DJ = 7009;
	/**
	 * 金币消耗途径:卡牌合成
	 */
	public static final int EXPEND_GOLD_CARD_HC = 7010;
	/**
	 * 钻石消耗途径:清空竞技场CD
	 */
	public static final int EXPEND_CASH_BUY_ARENA_CD = 7011;
	/**
	 * 钻石消耗途径:点金手
	 */
	public static final int EXPEND_CASH_DOGOLD = 7012;
	/**
	 * 钻石消耗途径:刷新竞技场商城
	 */
	public static final int EXPEND_CASH_REFRESHMALLMATCH = 7013;
	/**
	 * 钻石消耗途径:购买活动副本次数
	 */
	public static final int EXPEND_CASH_BUY_TIMES_ACTIVE = 7014;
	/**
	 * 钻石消耗途径:购买英雄副本次数
	 */
	public static final int EXPEND_CASH_BUY_TIMES_HERO = 7015;
	/**
	 * 钻石消耗途径:世界boss购买cd
	 */
	public static final int EXPEND_CASH_BUY_BOSS_CD = 7016;
	/**
	 * 钻石消耗途径:扫荡
	 */
	public static final int EXPEND_CASH_SWEEPING = 7017;
	/**
	 * 钻石消耗途径:分解
	 */
	public static final int EXPEND_CASH_MARKS = 7018;
	/**
	 * 勋章消耗途径: 兑换卡牌
	 */
	public static final int EXPEND_MEDAL_GETCARD = 7019;
	/**
	 * 钻石消耗途径:高级抽卡
	 */
	public static final int EXPEND_CASH_TAKE_ADVANCED = 7020;
	/**
	 * 金币消耗途径: 置换预览
	 */
	public static final int EXPEND_GOLD_REPLACEPREVIEW = 7021;
	/**
	 * 金币消耗途径:世界boss购买cd
	 */
	public static final int EXPEND_GOLD_BUY_BOSS_CD = 7022;
	/**
	 * 钻石消耗途径:购买竞技场次数
	 */
	public static final int EXPEND_CASH_BUY_ARENA_TIME = 7023;
	/**
	 * 钻石消耗途径:淘汰赛押注
	 */
	public static final int EXPEND_CASH_CROSS_BATTTING = 7024;
	/**
	 * 钻石消耗途径:卡牌复制
	 */
	public static final int EXPEND_CASH_CARD_COPY = 7025;
	/**
	 * 钻石消耗途径：纲手赌馆
	 */
	public static final int EXPEND_CASH_DAMBLE = 12031;
	/**
	 * 兵粮丸消耗途径: 兑换卡牌
	 */
	public static final int EXPEND_ARENAGOLD_CARD = 12000;
	/**
	 * 勾玉消耗途径: 兑换卡牌
	 */
	public static final int EXPEND_BOSSGOLD_CARD = 12001;
	/**
	 * 兵粮丸消耗途径:刷新竞技场商城
	 */
	public static final int EXPEND_ARENAGOLD_REFRESHMALLMATCH = 12002;
	/**
	 * 普通碎片消耗途径：碎片商城兑换
	 */
	public static final int EXPEND_DEBRIS1_MALL_BUY = 12003;
	/**
	 * 特级碎片消耗途径：碎片商城兑换
	 */
	public static final int EXPEND_DEBRIS2_MALL_BUY = 12004;
	/**
	 * 影级碎片消耗途径：碎片商城兑换
	 */
	public static final int EXPEND_DEBRIS3_MALL_BUY = 12005;
	/**
	 * 钻石消耗途径: 钻石礼包
	 */
	public static final int EXPEND_CASH_PACKAGECASH = 200001;
	/**
	 * 钻石消耗途径: 刷新任务
	 */
	public static final int EXPEND_CASH_TASK_REFRESH = 200003;
	/**
	 * 钻石获得途径:每日登陆奖励
	 */
	public static final int GETWAY_CASH_AWARD_LOGIN = 8003;
	/**
	 * 金币获得途径:每日登陆奖励
	 */
	public static final int GETWAY_GOLD_AWARD_LOGIN = 8004;
	/**
	 * 钻石获得途径:竞技场每日领取奖励
	 */
	public static final int GETWAY_CASH_AWARD_MATCH = 8005;
	/**
	 * 金币获得途径:竞技场每日领取奖励
	 */
	public static final int GETWAY_GOLD_AWARD_MATCH = 8006;
	/**
	 * 钻石获得途径:月卡奖励
	 */
	public static final int GETWAY_CASH_AWARD_MONTH = 8007;
	/**
	 * 钻石获得途径:CDK
	 */
	public static final int GETWAY_CASH_CDK = 8008;
	/**
	 * 金币获得途径:CDK
	 */
	public static final int GETWAY_GOLD_CDK = 8009;
	/**
	 * 钻石获得途径:竞技场升级奖励
	 */
	public static final int GETWAY_CASH_AWARD_MATCH_LEVEL_UP = 8010;
	/**
	 * 钻石获得途径:通关奖励
	 */
	public static final int GETWAY_CASH_LEVEL_PASS = 8011;
	/**
	 * 钻石获得途径:VIP奖励
	 */
	public static final int GETWAY_CASH_VIP = 8012;
	/**
	 * 金币获得途径:VIP奖励
	 */
	public static final int GETWAY_GOLD_VIP = 8013;
	/**
	 * 钻石获得途径: 系统后台发放
	 */
	public static final int GETWAY_CASH_SEND = 8014;
	/**
	 * 金币获得途径: 系统后台发放
	 */
	public static final int GETWAY_GOLD_SEND = 8015;
	/**
	 * 钻石获得途径: 邮件获得
	 */
	public static final int GETWAY_CASH_GMAEMAIL = 8016;
	/**
	 * 金币获得途径: 邮件获得
	 */
	public static final int GETWAY_GOLD_GMAEMAIL = 8017;
	/**
	 * 钻石获得途径: 充值获得
	 */
	public static final int GETWAY_CASH_PAY = 8018;
	/**
	 * 金币获得途径: 活动奖励
	 */
	public static final int GETWAY_GOLD_ACTIVE = 8019;
	/**
	 * 金币获得途径: 卡牌出售
	 */
	public static final int GETWAY_GOLD_CARD_SELL = 8020;
	/**
	 * 金币获得途径: 通关奖励
	 */
	public static final int GETWAY_GOLD_LEVEL_PASS = 8021;
	/**
	 * 金币活动途径: 点金手
	 */
	public static final int GETWAY_GOLD_DOGOLD = 8022;
	/**
	 * 勋章获得途径: 新手抽取卡牌
	 */
	public static final int GETWAY_MEDAL_CARD_TAKE_NEW = 8023;
	/**
	 * 勋章获得途径: 免费抽卡
	 */
	public static final int GETWAY_MEDAL_CARD_TAKE_FREE = 8024;
	/**
	 * 勋章获得途径: 点券单抽
	 */
	public static final int GETWAY_MEDAL_CARD_TAKE_ONE = 8025;
	/**
	 * 勋章获得途径: 十连抽
	 */
	public static final int GETWAY_MEDAL_CARD_TAKE_TEN = 8026;
	/**
	 * 勋章获得途径: 活动奖励
	 */
	public static final int GETWAY_MEDAL_ACTIVE = 8027;
	/**
	 * 勋章获得途径: 邮件
	 */
	public static final int GETWAY_MEDAL_GAMEMAIL = 8028;
	/**
	 * 勋章获得途径: 过关星级奖励
	 */
	public static final int GETWAY_MEDAL_LEVEL_STAR = 8029;
	/**
	 * 金币获得途径: 过关星级奖励
	 */
	public static final int GETWAY_GOLD_LEVEL_STAR = 8030;
	/**
	 * 钻石获得途径: 过关星级奖励
	 */
	public static final int GETWAY_CASH_LEVEL_STAR = 8031;
	/**
	 * 勋章获得途径: 高级抽
	 */
	public static final int GETWAY_MEDAL_CARD_TAKE_ADVANCED = 8032;
	/**
	 * 兵粮丸获得途径: 竞技场奖励
	 */
	public static final int GETWAY_ARENAGOLD_AWARD_MATCH = 8033;
	/**
	 * 兵粮丸获得途径: 邮件
	 */
	public static final int GETWAY_ARENAGOLD_GMAEMAIL = 8034;
	/**
	 * 兵粮丸获得途径: 活动
	 */
	public static final int GETWAY_ARENAGOLD_ACTIVE = 8035;
	/**
	 * 勾玉获得途径: 邮件
	 */
	public static final int GETWAY_BOSSGOLD_GAMEMAIL = 8036;
	/**
	 * 钻石获得途径: 活动奖励
	 */
	public static final int GETWAY_CASH_ACTIVE = 8037;

	/**
	 * 钻石获得途径：累积登陆
	 */
	public static final int GETWAY_CASH_LOGIN = 12003;

	/**
	 * 金币获得途径：累积登陆
	 */
	public static final int GETWAY_GOLD_LOGIN = 12004;

	/**
	 * 友情点获得途径：累积登陆
	 */
	public static final int GETWAY_FRIENDPOINT_LOGIN = 12005;

	/**
	 * 勋章获得途径：累积登陆
	 */
	public static final int GETWAY_MEDAL_LOGIN = 12006;

	/**
	 * 兵粮丸获得途径：累积登陆
	 */
	public static final int GETWAY_ARENAGOLD_LOGIN = 12007;

	/**
	 * 勾玉获得途径：累积登陆
	 */
	public static final int GETWAY_BOSSGOLD_LOGIN = 12008;

	/**
	 * 普通碎片获得途径：累积登陆
	 */
	public static final int GETWAY_DEBRIS1_LOGIN = 12009;

	/**
	 * 特级碎片获得途径：累积登陆
	 */
	public static final int GETWAY_DEBRIS2_LOGIN = 12010;

	/**
	 * 影级碎片获得途径：累积登陆
	 */
	public static final int GETWAY_DEBRIS3_LOGIN = 12011;

	/**
	 * 钻石获得途径：等级礼包
	 */
	public static final int GETWAY_CASH_LEVEL = 12012;

	/**
	 * 金币获得途径：等级礼包
	 */
	public static final int GETWAY_GOLD_LEVEL = 12013;

	/**
	 * 友情点获得途径：等级礼包
	 */
	public static final int GETWAY_FRIENDPOINT_LEVEL = 12014;

	/**
	 * 勋章获得途径：等级礼包
	 */
	public static final int GETWAY_MEDAL_LEVEL = 12015;

	/**
	 * 兵粮丸获得途径：等级礼包
	 */
	public static final int GETWAY_ARENAGOLD_LEVEL = 12016;

	/**
	 * 勾玉获得途径：等级礼包
	 */
	public static final int GETWAY_BOSSGOLD_LEVEL = 12017;

	/**
	 * 普通碎片获得途径：等级礼包
	 */
	public static final int GETWAY_DEBRIS1_LEVEL = 12018;

	/**
	 * 特级碎片获得途径：等级礼包
	 */
	public static final int GETWAY_DEBRIS2_LEVEL = 12019;

	/**
	 * 影级碎片获得途径：等级礼包
	 */
	public static final int GETWAY_DEBRIS3_LEVEL = 12020;

	/**
	 * 钻石获得途径：充值奖励
	 */
	public static final int GETWAY_CASH_CHARGE = 12021;

	/**
	 * 金币获得途径：充值奖励
	 */
	public static final int GETWAY_GOLD_CHARGE = 12022;

	/**
	 * 友情点获得途径：充值奖励
	 */
	public static final int GETWAY_FRIENDPOINT_CHARGE = 12023;

	/**
	 * 勋章获得途径：充值奖励
	 */
	public static final int GETWAY_MEDAL_CHARGE = 12024;

	/**
	 * 兵粮丸获得途径：充值奖励
	 */
	public static final int GETWAY_ARENAGOLD_CHARGE = 12025;

	/**
	 * 勾玉获得途径：充值奖励
	 */
	public static final int GETWAY_BOSSGOLD_CHARGE = 12026;

	/**
	 * 普通碎片获得途径：充值奖励
	 */
	public static final int GETWAY_DEBRIS1_CHARGE = 12027;

	/**
	 * 特级碎片获得途径：充值奖励
	 */
	public static final int GETWAY_DEBRIS2_CHARGE = 12028;

	/**
	 * 影级碎片获得途径：充值奖励
	 */
	public static final int GETWAY_DEBRIS3_CHARGE = 12029;
	/**
	 * 钻石获得途径：纲手赌馆
	 */
	public static final int GETWAY_CASH_DAMBLE = 12030;
	/**
	 * 勾玉获得途径 活动获得
	 */
	public static final int GETWAY_BOSSGOLD_ACTIVE = 12032;

	/**
	 * 普通碎片获得途径：每日登陆奖励
	 */
	public static final int GETWAY_DEBRIS1_AWARD_LOGIN = 12033;
	/**
	 * 特级碎片获得途径：每日登陆奖励
	 */
	public static final int GETWAY_DEBRIS2_AWARD_LOGIN = 12034;
	/**
	 * 影级碎片获得途径：每日登陆奖励
	 */
	public static final int GETWAY_DEBRIS3_AWARD_LOGIN = 12035;
	/**
	 * 普通碎片获得途径：卡牌分解
	 */
	public static final int GETWAY_DEBRIS1_CARD_MARK = 12036;
	/**
	 * 特级碎片获得途径：卡牌分解
	 */
	public static final int GETWAY_DEBRIS2_CARD_MARK = 12037;
	/**
	 * 影级碎片获得途径：卡牌分解
	 */
	public static final int GETWAY_DEBRIS3_CARD_MARK = 12038;
	/**
	 * 普通碎片获得途径：活动
	 */
	public static final int GETWAY_DEBRIS1_ACTIVE = 12039;
	/**
	 * 特级碎片获得途径：活动
	 */
	public static final int GETWAY_DEBRIS2_ACTIVE = 12040;
	/**
	 * 影级碎片获得途径：活动
	 */
	public static final int GETWAY_DEBRIS3_ACTIVE = 12041;
	/**
	 * 普通碎片获得途径：英雄副本
	 */
	public static final int GETWAY_DEBRIS1_LEVELHERO = 12042;
	/**
	 * 特级碎片获得途径：英雄副本
	 */
	public static final int GETWAY_DEBRIS2_LEVELHERO = 12043;
	/**
	 * 影级碎片获得途径：英雄副本
	 */
	public static final int GETWAY_DEBRIS3_LEVELHERO = 12044;
	/**
	 * 普通碎片获得途径：邮件
	 */
	public static final int GETWAY_DEBRIS1_GAMEMAIL = 12045;
	/**
	 * 特级碎片获得途径：邮件
	 */
	public static final int GETWAY_DEBRIS2_GAMEMAIL = 12046;
	/**
	 * 影级碎片获得途径：邮件
	 */
	public static final int GETWAY_DEBRIS3_GAMEMAIL = 12047;
	/**
	 * 钻石获得途径：新手引导赠送
	 */
	public static final int GETWAY_CASH_THENEW = 12048;
	/**
	 * 金币消耗途径：血迹抽卡
	 */
	public static final int GOLD_EXPEND_BLOOD = 12049;
	/**
	 * 金币获得途径：血迹抽卡
	 */
	public static final int GETWAY_GOLD_BLOOD = 12050;
	/**
	 * 体力获得途径：血迹抽卡
	 */
	public static final int GETWAY_POWER_BLOOD = 12051;
	/**
	 * 友情点获得途径：血迹抽卡
	 */
	public static final int GETWAY_FRIENDPOINT_BLOOD = 12052;
	/**
	 * 勋章获得途径：血迹抽卡
	 */
	public static final int GETWAY_MEDAL_BLOOD = 12053;
	/**
	 * 金币消耗途径：血迹卡升级
	 */
	public static final int GOLD_EXPEND_BLOODUP = 12054;
	/**
	 * 钻石消耗途径：血迹卡牌背包扩展
	 */
	public static final int CASH_EXPEND_BLOODEX = 12055;
	/**
	 * 金币获得途径：血迹卖卡
	 */
	public static final int GETWAY_GOLD_BLOODSELL = 12056;
	/**
	 * 勾玉获得途径: 关卡奖励
	 */
	public static final int GETWAY_BOSSGOLD_LEVEL_PASS = 12057;
	/**
	 * 勾玉获得途径: 任务完成
	 */
	public static final int GETWAY_BOSSGOLD_TASK_FINISH = 12058;
	/**
	 * 金币消耗途径：装备卡牌升级
	 */
	public static final int GOLD_EXPEND_EQUIPEX = 12058;
	/**
	 * 金币消耗途径：装备卡牌进化
	 */
	public static final int GOLD_EXPEND_EQUIPUP = 12059;
	/**
	 * 金币消耗途径：装备卡牌进化
	 */
	public static final int BOSSGOLD_EXPEND_EQUIPUP = 12060;
	/**
	 * 钻石消耗途径：装备卡牌背包扩展
	 */
	public static final int CASH_EXPEND_EQUIPBAGEX = 12061;
	/**
	 * 金币消耗途径：装备卡牌属性洗练
	 */
	public static final int GOLD_EXPEND_EQUIPPROPEX = 12062;
	/**
	 * 金币获得途径：卖装备卡牌
	 */
	public static final int GETWAY_GOLD_EQUIPSELL = 12063;
	/**
	 * 钻石消耗途径：装备九宫格刷新
	 */
	public static final int CASH_EXPEND_EQUIPREASH = 12064;
	/**
	 * 钻石消耗途径：装备九宫格抽卡
	 */
	public static final int CASH_EXPEND_EQUIPEXTRACT = 12065;
	/**
	 * 勾玉获得途径：装备分解
	 */
	public static final int GETWAY_BOSSGOLD_EQUIPDEC = 12066;
	/**
	 * 勾玉消耗途径：兑换整装勾玉
	 */
	public static final int BOSSGOLD_EXPEND_EQUIPDEX = 12067;
	/**
	 * 金币获得途径：小游戏奖励
	 */
	public static final int GETWAY_GOLD_GAME = 12068;
	/**
	 * 血迹获得途径：邮件领取
	 */
	public static final int GETWAY_AFBLOOD_GAMEMAIL = 12069;
	/**
	 * 血迹获得途径：任务
	 */
	public static final int GETWAY_AFBLOOD_TASK = 12070;
	/**
	 * 血迹获得途径：一键抽取
	 */
	public static final int GETWAY_AFBLOOD_TAKE = 12071;
	/**
	 * 血迹获得途径：活动
	 */
	public static final int GETWAY_AFBLOOD_ACTIVE = 12072;
	/**
	 * 装备获得途径：九宫格
	 */
	public static final int GETWAY_EQUIP_GRID_TAKE = 12073;
	/**
	 * 装备获得途径：初级勾玉兑换整装勾玉
	 */
	public static final int GETWAY_EQUIP_BOSSGOLD_TO = 12074;
	/**
	 * 装备获得途径：勾玉兑换
	 */
	public static final int GETWAY_EQUIP_CONVERT = 12075;
	/**
	 * 装备获得途径：小游戏-打地鼠
	 */
	public static final int GETWAY_EQUIP_SMALL_GAME1 = 12076;
	/**
	 * 装备获得途径：小游戏-猜结印
	 */
	public static final int GETWAY_EQUIP_SMALL_GAME2 = 12077;
	/**
	 * 装备获得途径：碎片兑换
	 */
	public static final int GETWAY_EQUIP_DEBRISMALLBUY = 12078;
	/**
	 * 装备获得途径：邮件
	 */
	public static final int GETWAY_EQUIP_GAMEMAIL = 12079;
	/**
	 * 装备获得途径：邮件
	 */
	public static final int GETWAY_EQUIP_THE_NEW = 12080;
	/**
	 * 装备获得途径：任务
	 */
	public static final int GETWAY_EQUIP_TASK = 12081;
	/**
	 * 装备获得途径：活动
	 */
	public static final int GETWAY_EQUIP_ACTIVE = 12082;
	/**
	 * 卡框获得途径：邮件
	 */
	public static final int GETWAY_BG_EFFECT_GAMEMAIL = 12083;
	/**
	 * 装备获得途径：无尽试炼
	 */
	public static final int GETWAY_EQUIP_MORE_BATTLE = 12084;

	/**
	 * 卡牌消耗途径: 升级合成
	 */
	public static final int CARD_EXPEND_HC = 10001;
	/**
	 * 卡牌消耗途径: 进化
	 */
	public static final int CARD_EXPEND_DJ = 10002;
	/**
	 * 卡牌消耗途径: 卡牌出售
	 */
	public static final int CARD_EXPEND_SALE = 10003;
	/**
	 * 钻石消耗途径:世界聊天
	 */
	public static final int CASH_EXPEND_CHAT_WORLD = 100004;
	/**
	 * 人民币充值
	 */
	public static final int RMB_PAY = 88888;

	/**
	 * 自定义事件类型,RPC服务器广播
	 */
	public static final int EVENT_TYPE_BROADCAST = -1;

	/**
	 * 自定义事件类型,指定用户广播
	 */
	public static final int EVENT_TYPE_TARGETS = -2;

	/**
	 * 自定义事件类型,转发给机器人
	 */
	public static final int EVENT_TYPE_ROBOT = -3;

	/**
	 * 自定义事件类型,RPC服务器广播
	 */
	public static final int EVENT_TYPE_BROADCAST_RPC = 999;
	/**
	 * 最大重连的次数
	 */
	public static final int MAX_RECONNECT_TIMES = 1000;
	/**
	 * 人民币礼包每日最多显示的次数
	 */
	public static final int PACKAGE_RMB_MAX_SHOW = 1;
	/**
	 * 钻石礼包每日最多显示的次数
	 */
	public static final int PACKAGE_CASH_MAX_SHOW = 1;
	/**
	 * 钻石礼包过期时间1800秒(半个小时)
	 */
	public static final int PACK_CASH_TIMEOUT_SECONDS = 1800;
	/**
	 * 免费刷新任务的次数
	 */
	public static final int TASK_REFRESH_FREE = 2;
	/**
	 * 世界聊天所需要的钻石数量
	 */
	public static final int CHAT_WORLD_PRICE = 1;
}
