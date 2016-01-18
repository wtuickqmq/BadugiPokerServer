package com.badugi.game.logic.model.vo.supreme;

import com.badugi.game.logic.util.LogicPropertyUtil;
/**
 * 游戏配置文件静态变量/常量池
 * @author qazwsxedc
 *
 */
public class ConstantPool {
	public final static String DEALERQUEUE = "dealerqueue";
	public static Double MAXCHIPS = null;
	public static Double MINCHIPS = null;
	public static Integer PLAYERCOUNTS = 0;
    public static String IP  = null;//游戏服务器配置
 	public static Integer PT = null;
 	public static Integer PORT = null;//监听端口
 	public static String FLASHKEY = null;
 	public static Float REWARDRATE = null;
 	public static Long 	REWARDPOOL = null;
 	public static Float BETRATE1 = null;
 	public static Float BETRATE2 = null;
	public static Float BETRATE3 = null;
	public static Integer MINPLAYERS = null;
	public static Float ROBOTINRATE1 = null;
	public static Float ROBOTINRATE2 = null;
	public static Float ROBOTINRATE3 = null;
	public static Float ROBOTINRATE4 = null;
	public static Float BETPROBABLY1 = null;
	public static Float BETPROBABLY2 = null;
	public static Float BETPROBABLY3 = null;
	public static Float BETPROBABLY4 = null;
	public static Float BETPROBABLY5 = null;
	public static Float BETPROBABLY6 = null;
	public static Integer INTERZONE1 = null;
	public static Integer INTERZONE2 = null;
	public static Integer INTERZONE3 = null;
	public static Integer INTERZONE4 = null;
	public static Integer INTERZONE5 = null;
	public static Float MINVWRATE = null;
 	public static Float MINBMWRATE = null;
 	public static Float MINBENZRATE = null;
	public static Float MINPORSCHERATE = null;
	public static Float BIGVWRATE = null;
	public static Float BIGBMWRATE = null;
	public static Float BIGBENZRATE = null;
	public static Float BIGPORSCHERATE = null;
	public static Float MINVWPROBABLY = null;
	public static Float MINBMWPROBABLY = null;
	public static Float MINBENZPROBABLY = null;
	public static Float MINPORSCHEPROBABLY = null;
	public static Float BIGVWPROBABLY = null;
	public static Float BIGBMWPROBABLY = null;
	public static Float BIGBENZPROBABLY = null;
	public static Float BIGPORSCHEPROBABLY = null;
	public static Long DRAWWATER = null;
	public static Float DRAWWATERRATE = null;
	public static Float DEALERDRAWWATERRATE = null;
	public static Integer LIMITINNING = null;
	public static Integer ENABLEINNING = null;
	public static Long MININITPOOL = null;
	public static Long MINROBOTCHIPS = null;
	   static{
		   try { 
			   MINROBOTCHIPS = LogicPropertyUtil.getLong("supremecar.mininit.robotchips");
			   MININITPOOL = LogicPropertyUtil.getLong("supremecar.initpool.min");
			   ENABLEINNING = LogicPropertyUtil.getInteger("supremecar.dealer.enablelnning") ;
			   LIMITINNING = LogicPropertyUtil.getInteger("supermecar.dealer.limitLnning"); //连续上庄局数限制
			   DEALERDRAWWATERRATE = LogicPropertyUtil.getFloat("supremecar.settleaccount.dealerpumprate");//庄家税收比率
			   DRAWWATERRATE = LogicPropertyUtil.getFloat("supremecar.settleaccount.pumprate");//闲家税收比率
			   DRAWWATER = LogicPropertyUtil.getLong("supremecar.settleaccount.pump");//盈利税收区间
			   BIGPORSCHEPROBABLY = LogicPropertyUtil.getFloat("supremecar.bigPorsche.betprobably");//大保时捷投注概率
			   BIGBENZPROBABLY = LogicPropertyUtil.getFloat("supremecar.bigBenz.betprobably");//大奔驰投注概率
			   BIGBMWPROBABLY = LogicPropertyUtil.getFloat("supremecar.bigBMW.betprobably");//大宝马投注概率
			   BIGVWPROBABLY = LogicPropertyUtil.getFloat("supremecar.bigVW.betprobably");//大大众投注概率
			   MINPORSCHEPROBABLY = LogicPropertyUtil.getFloat("supremecar.minPorsche.betprobably");//小保时捷投注概率
			   MINBENZPROBABLY = LogicPropertyUtil.getFloat("supremecar.minBenz.betprobably");//小奔驰投注概率
			   MINBMWPROBABLY = LogicPropertyUtil.getFloat("supremecar.minBMW.betprobably");//小宝马投注概率
			   MINVWPROBABLY = LogicPropertyUtil.getFloat("supremecar.minVW.betprobably");//小大众投注概率
			   
			   BIGPORSCHERATE = LogicPropertyUtil.getFloat("supremecar.bigPorsche.betrate");//大保时捷投注额占比
			   BIGBENZRATE = LogicPropertyUtil.getFloat("supremecar.bigBenz.betrate");//大奔驰投注额占比
			   BIGBMWRATE = LogicPropertyUtil.getFloat("supremecar.bigBMW.betrate");//大宝马投注额占比
			   BIGVWRATE = LogicPropertyUtil.getFloat("supremecar.bigVW.betrate");//大大众投注额占比
			   MINPORSCHERATE = LogicPropertyUtil.getFloat("supremecar.minPorsche.betrate");//小保时捷投注额占比
			   MINBENZRATE = LogicPropertyUtil.getFloat("supremecar.minBenz.betrate");//小奔驰投注额占比
			   MINBMWRATE = LogicPropertyUtil.getFloat("supremecar.minBMW.betrate");//小宝马投注额占比
			   MINVWRATE= LogicPropertyUtil.getFloat("supremecar.minVW.betrate");//小大众投注额占比
			   
			   INTERZONE5 = LogicPropertyUtil.getInteger("supremecar.interzone.bet5");//押注区间点5
			   INTERZONE4 = LogicPropertyUtil.getInteger("supremecar.interzone.bet4");//押注区间点4
			   INTERZONE3 = LogicPropertyUtil.getInteger("supremecar.interzone.bet3");//押注区间点3
			   INTERZONE2 = LogicPropertyUtil.getInteger("supremecar.interzone.bet2");//押注区间点2
			   INTERZONE1 = LogicPropertyUtil.getInteger("supremecar.interzone.bet1");//押注区间点1
			   
			   BETPROBABLY6 = LogicPropertyUtil.getFloat("supremecar.robotIn.betprobably6");
			   BETPROBABLY5 = LogicPropertyUtil.getFloat("supremecar.robotIn.betprobably5");
			   BETPROBABLY4 = LogicPropertyUtil.getFloat("supremecar.robotIn.betprobably4");
			   BETPROBABLY3 = LogicPropertyUtil.getFloat("supremecar.robotIn.betprobably3");
			   BETPROBABLY2 = LogicPropertyUtil.getFloat("supremecar.robotIn.betprobably2");
			   BETPROBABLY1 = LogicPropertyUtil.getFloat("supremecar.robotIn.betprobably1");//闲家人数少于一定人数时相应返奖率的出现概率
			   
			   ROBOTINRATE4 = LogicPropertyUtil.getFloat("supremecar.robotIn.betrate4");
			   ROBOTINRATE3 = LogicPropertyUtil.getFloat("supremecar.robotIn.betrate3");
			   ROBOTINRATE2 = LogicPropertyUtil.getFloat("supremecar.robotIn.betrate2");
			   ROBOTINRATE1 = LogicPropertyUtil.getFloat("supremecar.robotIn.betrate1");//闲家人数少于一定人数时相应返奖率
			   
			   MINPLAYERS = LogicPropertyUtil.getInteger("supremecar.systembet.minPlayers");//闲家人数少于一定人数的阀值
			   
			   BETRATE3 = LogicPropertyUtil.getFloat("supremecar.rewardpool.betrate3");
			   BETRATE2 = LogicPropertyUtil.getFloat("supremecar.rewardpool.betrate2");
			   BETRATE1 = LogicPropertyUtil.getFloat("supremecar.rewardpool.betrate1");//系统奖池开奖概率的3个阀值
			   
			   REWARDRATE = LogicPropertyUtil.getFloat("supremecar.system.rewardrate");  //系统返奖回收率
			   REWARDPOOL = LogicPropertyUtil.getLong("supremecar.system.rewardpool");  //系统奖池
			   FLASHKEY = LogicPropertyUtil.getString("option.flash.key");
			   PORT = LogicPropertyUtil.getInteger("supremecar.listener.port");
			   PT = LogicPropertyUtil.getInteger("option.racingcar.port");
			   IP = LogicPropertyUtil.getString("option.racingcar.ip");
			   MAXCHIPS = LogicPropertyUtil.getDouble("supremecar.dealer.maxChips");//-9999999,玩家所有筹码标识
			   MINCHIPS = LogicPropertyUtil.getDouble("supremecar.dealer.minChips");//小游戏上庄最低筹码
			PLAYERCOUNTS = LogicPropertyUtil.getInteger("supremecar.room.maxPlayers"); //房间容纳玩家数
			} catch (Exception e) {
				e.printStackTrace();
			}
		    System.out.println("playerCounts="+PLAYERCOUNTS);
		}
}
