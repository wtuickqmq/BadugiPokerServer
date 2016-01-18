package com.badugi.game.logic.model.lobby.helper;


import io.nadron.client.util.ObjectBeanUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.dao.RacingCarInitDao;
import com.badugi.game.logic.dao.RacingCarPoolsDao;
import com.badugi.game.logic.helper.LobbyUserHelper;
import com.badugi.game.logic.model.cache.CarCache;
import com.badugi.game.logic.model.domain.vo.flash.Definition;
import com.badugi.game.logic.model.domain.vo.flash.user.MsgSendVo;
import com.badugi.game.logic.model.entity.RacingPool;
import com.badugi.game.logic.model.entity.RacingcarInit;
import com.badugi.game.logic.model.entity.UserFund;
import com.badugi.game.logic.model.utils.common.DateUtils;
import com.badugi.game.logic.model.vo.supreme.ConstantPool;
import com.badugi.game.logic.model.vo.supreme.DealerStatus;
import com.badugi.game.logic.model.vo.supreme.PrizeEntry;
import com.badugi.game.logic.model.vo.supreme.PrizeItem;
import com.badugi.game.logic.model.vo.supreme.SimulateBet;
import com.badugi.game.logic.service.GameCarService;
import com.badugi.game.logic.service.impl.GameCarServiceImpl;
import com.badugi.game.logic.util.AppContext;
import com.badugi.game.logic.util.BetChanceUtils;
import com.badugi.game.logic.util.LogicChannelUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.joker.game.db.redis.RedisLogin;

/**
 * @author wtu.add
 * @date 2015年11月13日
 * @version qq1.0
 * @email wtuickqmq@163.com
 */


public class GameCarHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(GameCarHelper.class);

	/**
	 * 返回 每种car类型排序项
	 * @param item car类型
	 * @return 返回排序号
	 */
	public static int getItemSort(String item)
	{
		
		if (PrizeItem.MINVW.getItem().equals(item)) // 小大众
		{
			return 1;

		} else if (PrizeItem.MINBMW.getItem().equals(item)) // 小宝马
		{
			return 2;

		} else if (PrizeItem.MINBENZ.getItem().equals(item)) // 小奔驰
		{
			return 3;

		} else if (PrizeItem.MINPORSCHE.getItem().equals(item)) // 小保时捷
		{
			return 4;

		} else if (PrizeItem.BIGVW.getItem().equals(item)) // 大大众
		{
			return 5;

		} else if (PrizeItem.BIGBMW.getItem().equals(item)) // 大宝马
		{
			return 6;

		} else if (PrizeItem.BIGBENZ.getItem().equals(item)) // 大奔驰
		{
			return 7;

		} else if (PrizeItem.BIGPORSCHE.getItem().equals(item)) // 大保时捷
		{
			return 8;
		}
		return 0;
	}
	/**
	 * 根据排序编号返回car类型
	 * @param sort 排序编号
	 * @return
	 */
	public static String getItemForSort(int sort)
	{
		
		if (sort==1) // 小大众
		{
			return PrizeItem.MINVW.getItem();

		} else if (sort==2) // 小宝马
		{
			return PrizeItem.MINBMW.getItem();

		} else if (sort==3) // 小奔驰
		{
			return PrizeItem.MINBENZ.getItem();

		} else if (sort==4) // 小保时捷
		{
			return PrizeItem.MINPORSCHE.getItem();

		} else if (sort==5) // 大大众
		{
			return PrizeItem.BIGVW.getItem();

		} else if (sort==6) // 大宝马
		{
			return PrizeItem.BIGBMW.getItem();

		} else if (sort==7) // 大奔驰
		{
			return PrizeItem.BIGBENZ.getItem();

		} else if (sort==8) // 大保时捷
		{
			return PrizeItem.BIGPORSCHE.getItem();
		}
		
		return null;
	}

	/**
	 * wtu.add 2015-11-14 初始化实时监控数据 全部设为0
	 */
	public static void InitItem()
	{
		try {
			PrizeItem[] prizeItemList = PrizeItem.values();
			boolean flag = false;
			RedisLogin redisBet = AppContext.getBean(RedisLogin.class);
			
			for (PrizeItem prizeItem : prizeItemList) {
				Map<String, String> rtabetInfo = Maps.newHashMap();
				rtabetInfo.put("robotBetNum", String.valueOf(0));
				rtabetInfo.put("playerBetNum", String.valueOf(0));
				rtabetInfo.put("playerNum", String.valueOf(0));
				rtabetInfo.put("fbWin", String.valueOf(0));
				rtabetInfo.put("sort", String.valueOf(GameCarHelper.getItemSort(prizeItem.getItem())));
				rtabetInfo.put("item", String.valueOf(prizeItem.getItem()));
				
				String keyBet = "playersBetNum:"+prizeItem.getItem();
				
				redisBet.hmset( keyBet, rtabetInfo);
				redisBet.sadd("betItemList",  keyBet);
			}
			//设置当局开奖结果为空
			GameCarHelper.setCurRoundItem("");
			
			GameCarHelper.betRankDel();
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("后台监控数据初始化错误，{}",e);
			e.printStackTrace();
		}
		
		
		
	}
	/**
	 * 实时监控设置庄家信息到redis数据库
	 * 
	 * @param currDealer  庄家信息 
	 */
	public static void setDealerStatusInfo(DealerStatus currDealer) {
		try {
			Map<String, String> rtafbInfo = Maps.newHashMap();
			
			rtafbInfo.put("curId", String.valueOf(CarCache.RACINGCARID)); //当前局号
			rtafbInfo.put("dealerId", String.valueOf(currDealer.getFbId())); //庄id
			rtafbInfo.put("stime", String.valueOf(CarCache.STARTRACINGCAR)); //当前开始时间
			rtafbInfo.put("fbName", currDealer.getFbName()); //庄家昵称
			rtafbInfo.put("lobbyLeftChips", currDealer.getUpDealerChips().toString()); //庄家上庄筹码
			rtafbInfo.put("wining", currDealer.getWining().toString()); //庄家当前连赢局数
			rtafbInfo.put("etime", String.valueOf(CarCache.STARTRACINGCAR + CarCache.LASTINGTIME)); //当局结束时间
			rtafbInfo.put("chance", BetChanceUtils.getChanceStr());//当前赔率字符串
			RedisLogin redisBet = AppContext.getBean(RedisLogin.class);
			redisBet.hmset("bet", rtafbInfo);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("实时监控设置庄家信息错误，{}",e);
			e.printStackTrace();
		}
		
		
	}
	/**
	 * 设置当前局选中
	 * @param car_id
	 * @param item
	 */
	public static void setCurRoundItem(String item)
	{
		try {
			long curtime=System.currentTimeMillis();
			if(curtime<(CarCache.STARTRACINGCAR + CarCache.LASTINGTIME))
			{//当传来数据，超过游戏时间则不设置
				Map<String, String> rtabetInfo = Maps.newHashMap();
				rtabetInfo.put("item", String.valueOf(item));
				String keyBet = "playersBetNum:"+"select";
				//记录到redis缓存数据库中回显
				RedisLogin redisBet = AppContext.getBean(RedisLogin.class);
				redisBet.hmset( keyBet, rtabetInfo);
				redisBet.sadd("betItemList",  keyBet);
				//设置进程内缓存
				CarCache.OpenItem=item;
			}
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("设置当前局选中错误，{}",e);
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 实时监控玩家押注信息
	 * 
	 * @param item
	 *            押注区域
	 * @param sessionId
	 *            玩家id(不包含机器人帐号)
	 */
	public static void betRtaCalc() {
		String item="";
		try {
			
			 DealerStatus dealer = CarCache.CURRENTDEALER.peek();// 上庄庄家
             PrizeItem[] items = PrizeItem.values();
             RedisLogin redisBet = AppContext.getBean(RedisLogin.class);
             
			for (PrizeItem i : items) {
				item=i.getItem();
				if(i.getItem().equals(PrizeItem.SUMCHIPS.getItem()))
				{
					continue;
				}
				Map<String, String> rtabetInfo = Maps.newHashMap();
				rtabetInfo.put("robotBetNum", String.valueOf(CarCache.ROBOTCHIPS.get(item)));
				rtabetInfo.put("playerBetNum", String.valueOf(CarCache.CHIPSSET.get(item)));
				rtabetInfo.put("playerNum", String.valueOf(CarCache.BETKINDPERPLAYER.get(item).size()));

				// 赔付金额
				long rate = GameCarServiceImpl.PRIZESET.get(item).getOdds(); // 赔率
				Long pchips=CarCache.CHIPSSET.get(item);
				pchips=pchips==null?0:pchips;
				long pay = pchips * rate;
				
				
				Long betrobotchips = CarCache.ROBOTCHIPS.get(item);// 机器人押中门类的总押注
				betrobotchips=betrobotchips==null?0:betrobotchips;
				long robotpay = betrobotchips * rate;
			
				

				Long totalBet = CarCache.EACHWINSUMCHIPS.get(PrizeItem.SUMCHIPS.getItem()) + CarCache.ROBOTSBETCHIPS; // 闲家总押注

				long fbWin = totalBet - pay - robotpay; // 庄家盈利
				
				if(dealer.isRobot())
				{//庄是机器人，庄的赢利计算
					totalBet = CarCache.EACHWINSUMCHIPS.get(PrizeItem.SUMCHIPS.getItem());
					fbWin = totalBet - pay;
				}
				
				
				rtabetInfo.put("fbWin", String.valueOf(fbWin));
				rtabetInfo.put("sort", String.valueOf(GameCarHelper.getItemSort(item)));
				rtabetInfo.put("item", String.valueOf(item));

				String keyBet = "playersBetNum:"+item;
				
				redisBet.hmset( keyBet, rtabetInfo);
				redisBet.sadd("betItemList",  keyBet);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("下注倍数{},--{}  ----{}",GameCarServiceImpl.PRIZESET,item);
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 实时监控玩家押注排行
	 * 
	 * @param item
	 *            押注区域
	 * @param sessionId
	 *            玩家id(不包含机器人帐号)
	 * @param userFund
	 *            玩家信息
	 */
	public static void betRankCalc(String item, String sId, UserFund userFund) {
		try {
			RedisLogin redisBet = AppContext.getBean(RedisLogin.class);
			if(sId==null)return;
			Long sessionId=Long.valueOf(sId);
			if(sessionId==null)return;
			
			Double totalbet = 0d;
			PrizeItem[] items = PrizeItem.values();
			
			Map<String,String> mp=new HashMap<String,String>();
			mp.put("id", sId);
			mp.put("name", LobbyUserHelper.getUserNick(sId));
			for (PrizeItem i : items) {
				
				if (CarCache.BETKINDPERPLAYER.get(i.getItem()).get(sessionId) != null) {
					
					mp.put(i.getItem(), CarCache.BETKINDPERPLAYER.get(i.getItem()).get(sessionId).toString());
					
				}
			}
		
			 Map<Long, Long> sumMap = CarCache.BETKINDPERPLAYER.get(PrizeItem.SUMCHIPS.getItem());
			 if(sumMap!=null)
			 {
				 if(sumMap.get(Long.valueOf(sessionId))!=null)
				 {
					    LOGGER.info("PlayerBet:{}",sumMap.get(sessionId));
					 totalbet=sumMap.get(sessionId).doubleValue();
				 }
				 else
				 {
						LOGGER.info("PlayerBet:{}",-1);
				 }
			 }
			 
			LOGGER.info("AllPlayerBet:{}",CarCache.BETKINDPERPLAYER);
			LOGGER.info("[{}--->add in redis]{}",sessionId,ObjectBeanUtil.JACKSON.writeValueAsString(mp));

			redisBet.zadd("playersBetRank", totalbet, sId);
			redisBet.zRemRangeByRank("playersBetRank", 0, -7); // 保留分数最高的前6名
			
			Double flag = redisBet.zscore("playersBetRank", sId);
			if (flag != null && !("").equals(flag)) {
				/*Map<String, String> playerBetInfo = Maps.newHashMap();
				playerBetInfo.put("id", sId);
				playerBetInfo.put("uname", LobbyUserHelper.getUserNick(sId));
				if (CarCache.BETKINDPERPLAYER.get(item).get(sessionId) != null) {
					playerBetInfo.put(item, CarCache.BETKINDPERPLAYER.get(item).get(sessionId).toString());
				}
				*/
				String keyBet = "playerBetInfo:"+sId;
				redisBet.hmset(keyBet, mp);
				redisBet.expireAt("playerBetInfo", System.currentTimeMillis() / 1000 + 3600);
			}
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("实时监控玩家押注排行错误，{}",e);
			e.printStackTrace();
		}
		
	}
	/**
	 * 删除实时监控集合 
	 */
	public static void betRankDel()
	{
		try {
			RedisLogin redisBet = AppContext.getBean(RedisLogin.class);
			redisBet.del("playersBetRank");
			
			redisBet.delKeys("playerBetInfo:*");
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("删除实时监控集合 错误，{}",e);
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 系统坐庄时候，按BetChanceUtil中基本赔率表开奖
	 * @return 返回开奖结果
	 */
	public static PrizeEntry robotOpenLottery()
	{
		Long rewarePool = CarCache.REWAREPOOL;// 系统奖池
		
		ConcurrentHashMap<String, Long> robotchips = CarCache.ROBOTCHIPS;
		ConcurrentHashMap<String, Long> chipsset = CarCache.CHIPSSET;
		PrizeItem[] items = PrizeItem.values();
		Long oldchips=-1L;
		PrizeEntry value=new PrizeEntry();
		List<PrizeEntry> list=new ArrayList<PrizeEntry>();
		
		for (PrizeItem item : items) {
		
			if(item.getItem().equals(PrizeItem.SUMCHIPS.getItem()))
			{
				continue;
			}
			Long rchips=robotchips.get(item.getItem());//机器人当前下注总和
			Long pchips=chipsset.get(item.getItem());//玩家当前下注总和
			Integer mul=GameCarServiceImpl.PRIZESET.get(item.getItem()).getOdds();
			Long sum=(rchips+pchips)*mul;//计算本门总赔付
			if(sum<oldchips || oldchips.equals(-1L))
			{//取得最小赔付门
				value.setItem(item.getItem());
				value.setOdds(mul);
				list.clear();
				list.add(value);
				oldchips=sum;
			}
			else if(oldchips==sum)
			{//取得相同大小的赔
				PrizeEntry newValue=new PrizeEntry();
				newValue.setItem(item.getItem());
				newValue.setOdds(mul);
				list.add(newValue);
			}
		}
		LOGGER.debug("--------下注赔付最小的【{}】",list);
		if(list.size()>1)
		{//如果有多个相同最小开奖，则随机选定一下
			Random rand=new Random();
			value=list.get(rand.nextInt(list.size()));
		}
		LOGGER.debug("--------选定赔付最小的【{}】",value);
		int type=BetChanceUtils.getThreeKinds(rewarePool);
		if(BetChanceUtils.checkOpenLottery(type, rewarePool))
		{//检测是否到达对应派奖级别（派送大奖）
			type=4;
		}
		else
		{//得到1-3基本赔率，并且叠到最小赔付 
			type++;
		}
		LOGGER.debug("--------基本赔率类型【{}】",type);
		/**
		 * 取得最终随机开奖结果
		 */
		String openItem=getItemForSort(BetChanceUtils.getChanceNumber(type, getItemSort(value.getItem())));
		Integer mul=GameCarServiceImpl.PRIZESET.get(openItem).getOdds();
		value.setItem(openItem);
		value.setOdds(mul);
		LOGGER.debug("--------最终随机赔率类型【{}】",value);
		return value;
	}
	/**
	 * 当玩家坐庄或系统坐庄但没有玩家参与，按最基本赔率随机开奖
	 * @return
	 */
	public static PrizeEntry randOpenLottery()
	{
		PrizeEntry value=new PrizeEntry();
		String openItem=getItemForSort(BetChanceUtils.getChanceNumber(0,0));
		Integer mul=GameCarServiceImpl.PRIZESET.get(openItem).getOdds();
		value.setItem(openItem);
		value.setOdds(mul);
		return value;
	}
	/**
	 * 检测玩家是否下注 
	 * @return true 有下注   false 没有下注
	 */
	public static boolean isPlayerBet()
	{
		Long betchips=CarCache.EACHWINSUMCHIPS.get(PrizeItem.SUMCHIPS.getItem());
		if(betchips!=null)
		{
			if(betchips>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	/**
	 * wtu.add 2015-12-2
	 * 保存系统奖池变更
	 * @param gameId 游戏id
	 * @param u_id   庄家id
	 * @param winItem 赢得选项
	 * @param mul     赢得倍数
	 * @param isDealerRobot 是否是机器人
	 * @param dpump 庄家扣税
	 */
	
	public static void savePools(String gameId,Long u_id,String winItem,Integer mul,int isDealerRobot,Long dwinChips,Long dpump)
	{
		RacingPool rp=new RacingPool();
		
		Map<String,Double> playerChipsInfo=null;
		Long playerChipsSum=CarCache.EACHWINSUMCHIPS
	            .get(PrizeItem.SUMCHIPS.getItem());//玩家总下注
		Double poolsChips=0.0;//入奖池金额
		
		rp.setRid(gameId);//保存游戏id
		rp.setUId(u_id);//庄家id 
		rp.setDisRobot(isDealerRobot);//是否是机器人坐庄
		
		if(playerChipsSum<=0 && isDealerRobot==1)
		{//如果没有玩家则不计算(玩家下注为0 ，并且玩家不是庄)
			return;
		}
		
		playerChipsInfo=getPlayerWin(winItem,mul);
		//玩家所有下注-所有赢取总和
		poolsChips=playerChipsSum-playerChipsInfo.get("winChips");
		rp.setFwinchips(-poolsChips);//闲家输赢
		if(isDealerRobot==1)
		{//机器人坐庄
			
			
			rp.setDpump(0.0);//系统做庄不抽水
			rp.setDwinchips(0.0);
		}
		else
		{//玩家坐庄
			poolsChips=getRobotWin(winItem,mul);
			
			//玩家和机器人总下注
			/*Long allBetChips =0L;//CarCache.EACHWINSUMCHIPS.get(PrizeItem.SUMCHIPS.getItem()) + CarCache.ROBOTSBETCHIPS; // 初始化庄家盈利为闲家总押注
			//总下注减去，玩家和机器人赢取（不能去抽水，因为玩家实际赔付包含抽水）
			Long pchips=playerChipsInfo.get("winChips").longValue();
			
			if(pchips<0)allBetChips+=Math.abs(-pchips);
			if(poolsChips<0)allBetChips+=Math.abs(poolsChips.longValue());//如果机器人赢利则需要减去
			
			if (dwin > ConstantPool.DRAWWATER) // 需要扣税
			{
				
				double need = dwin * ConstantPool.DEALERDRAWWATERRATE;
				rp.setDpump(need);//做庄被抽水（玩家做庄）
			}
			else
			{
				rp.setDpump(0.0);
			}*/
			
			rp.setDwinchips(dwinChips.doubleValue()+dpump.doubleValue());
			rp.setDpump(dpump.doubleValue());
			LOGGER.debug("玩家坐庄，庄家扣除抽水:{},机器人输赢：{}",rp.getDpump(),poolsChips);
			
		}
		
		if(poolsChips>0)
		{
			rp.setChips(poolsChips*CarCache.SYS_POOLS);//90%  放入池中
			rp.setPoolPump(poolsChips*CarCache.SYS_POOLS_END);//10%放入奖池抽水
		}
		else
		{
			rp.setChips(poolsChips);
			rp.setPoolPump(0.0);
		}
		rp.setFpump(playerChipsInfo.get("pumpChips"));//闲家抽水（只算玩家 ）
		rp.setOldPoolChips(CarCache.REWAREPOOL.doubleValue());//原系统奖池金额
		
		RacingcarInit sic = new RacingcarInit(rp.getChips().longValue());
		AppContext.getBean(RacingCarInitDao.class).updateRacing(sic);// 更新系统奖池
		rp.setCreateTime(new Date());
		AppContext.getBean(RacingCarPoolsDao.class).saveRacingPools(rp); // 更新系统奖池
		LOGGER.debug("系统奖池表：{}",rp);
	}
	
	
	/**
	 * 取得玩家总共赢利和总抽水
	 * @param winItem 赢得选项
	 * @param mul  选项翻倍倍数
	 * @return Map<String,Double> 
	 *      result.put("winChips", winChips); 总赢利
			result.put("pumpChips", pumpChips);总抽水
	 */	
	public static Map<String,Double> getPlayerWin(String winItem,Integer mul)
	{
		ConcurrentHashMap<String, Map<Long, Long>> betkindperplayer = CarCache.BETKINDPERPLAYER; // 每个门类中每位玩家的押注额
		
		Map<Long, Long> betPlayers = null; // <fbId,betchips>
		Map<Long, Long> sumPlayers= null;
		Iterator<Long> fbIds = null;
		
		Long fbId = null;
		    Double winChips=0.0;//总赢利
		    Double pumpChips=0.0;//总抽水
		    Double oneChips=0.0;//单个用户下注额
		    Double onePumpChips=0.0;
		    Float num = ConstantPool.DRAWWATERRATE; // 需要扣除的比例
		    
		    betPlayers = betkindperplayer.get(winItem);
		    sumPlayers = betkindperplayer.get(PrizeItem.SUMCHIPS.getItem());
		    
			fbIds = betPlayers.keySet().iterator();
			while (fbIds.hasNext()) {
				fbId = fbIds.next();
				oneChips=Double.valueOf(betPlayers.get(fbId)*mul);
				Long oneSum=sumPlayers.get(fbId);
				if ((oneChips-oneSum) > ConstantPool.DRAWWATER) {
					onePumpChips = Math.floor((oneChips-oneSum) * (num)+0.5);// 抽水筹码
					//oneChips =  Math.floor(oneChips - onePumpChips);//抽水后筹码
				}
					
				winChips+=oneChips;//玩家赢利累计
				pumpChips+=onePumpChips;//玩家总抽水累计
			}
			Map<String,Double> result=new HashMap<String,Double>();
			result.put("winChips", winChips);
			result.put("pumpChips", pumpChips);
		
		return result;
	}
	/**
	 * 得到机器人入池结果
	 * @param winItem 赢得选项
	 * @param mul  选项翻倍倍数
	 * @return
	 */
	public static Double getRobotWin(String winItem,Integer mul)
	{
		ConcurrentHashMap<String, Map<Long, Long>> betrobotchips = CarCache.BETROBOTCHIPS;
		Iterator<Long> fbIds = null;
		Long fbId = null;

		  Map<Long, Long> allsum = CarCache.BETROBOTCHIPS.get(PrizeItem.SUMCHIPS.getItem());
		  Iterator<Entry<Long, Long>> itrs=allsum.entrySet().iterator();
		  Long sumchips=0L;
		  while(itrs.hasNext())
		  {
			   Entry<Long, Long> item = itrs.next();
			   sumchips+=item.getValue();
		  }
		  
		  Map<Long, Long> betPlayers = betrobotchips.get(winItem);
		  fbIds = betPlayers.keySet().iterator();
		  
		  Double winChips=0.0;//总赢利
		  Double pumpChips=0.0;//总抽水
		  Double oneChips=0.0;//单个用户下注额
		  Double onePumpChips=0.0;
		  Float num = ConstantPool.DRAWWATERRATE; // 需要扣除的比例
		  
			while (fbIds.hasNext()) {
				fbId = fbIds.next();
				oneChips=Double.valueOf(betPlayers.get(fbId)*mul);
				winChips+=oneChips;//玩家赢利累计
				
			}
		
		winChips-=sumchips;//机器人赢利-机器人总下注
	    return winChips;
	}
	
	/**
	 * 取得单个玩家压注返回
	 * @param u_id 玩家id
	 * @param winItem 赢得选项
	 * @param mul  选项翻倍倍数
	 * @return long 是否下注赢利 

	 */	
	public static Long getOnePlayerWin(Long u_id,String winItem,Integer mul)
	{
		ConcurrentHashMap<String, Map<Long, Long>> betkindperplayer = CarCache.BETKINDPERPLAYER; // 每个门类中每位玩家的押注额
		
		Map<Long, Long> betPlayers = null; // <fbId,betchips>
		
		    betPlayers = betkindperplayer.get(winItem);
		    Long betChips=betPlayers.get(u_id);
		    Long sumChips=0L;
		    if(betChips!=null)
		    {
		    	/**
		    	 * wtu.edit 2015-12-10 跟据运营需求修改 下注金额
		    	 * 原本为获奖金额 
		    	 * sumChips=betChips*mul;
		    	 */
		    	sumChips=betChips;
		    }
		
			
		return sumChips;
	}
	
	/**
	 * 取得单个玩家或机器人压注返回
	 * @param u_id 玩家id
	 * @param winItem 赢得选项
	 * @param mul  选项翻倍倍数
	 * @return long 是否下注赢利 

	 */	
	public static Long getOneWin(Long u_id,String winItem,Integer mul)
	{
		ConcurrentHashMap<String, Map<Long, Long>> betkindperplayer = CarCache.BETKINDPERPLAYER; // 每个门类中每位玩家的押注额
		
		Map<Long, Long> betPlayers = null; // <fbId,betchips>
		
		    betPlayers = betkindperplayer.get(winItem);
		    Long betChips=betPlayers.get(u_id);
		    Long sumChips=0L;
		    if(betChips!=null)
		    {
		    	if(betChips!=0)
		    	{
		    		/**
			    	 * wtu.edit 2015-12-10 跟据运营需求修改 下注金额
			    	 * 原本为获奖金额 
			    	 * sumChips=betChips*mul;
			    	 */
		    		sumChips=betChips;
		    	    return sumChips;
		    	}
		    }
		    ConcurrentHashMap<String, Map<Long, Long>> betrobotchips = CarCache.BETROBOTCHIPS;
			
		    Map<Long, Long> betRobots = betrobotchips.get(winItem);				
		        betChips=betRobots.get(u_id);
		        if(betChips!=null)
		        {
		    	    sumChips=betChips*mul;
		        }				
			
			
		return sumChips;
	}
	
	
	//wtu.add 2015-12-11  迁移原RacingcarMainThread中的函数
	
	/**
	 * 计算每门押注上限
	 * 
	 * @param item
	 * @param chip
	 * @return
	 */
	public static Map<String, Long> simulateBetLimit() {
		Map<String, Long> betLimits = new HashMap<String, Long>();
		Iterator<DealerStatus> it = CarCache.CURRENTDEALER.iterator();
		Map<String, PrizeEntry> prizeset = GameCarServiceImpl.PRIZESET;
		Long sumChips = CarCache.EACHWINSUMCHIPS.get(PrizeItem.SUMCHIPS.getItem()) + CarCache.ROBOTSBETCHIPS;// 每局押注总筹码量
		DealerStatus ds = null;
		// Long dealerId = null;
		if (it.hasNext()) {
			ds = it.next();
			// dealerId = ds.getFbId();
		}
		;
		// 小大众押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.MINVW.getItem())) {
			long minvmBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.MINVW.getItem()).getOdds() == 0l ? 1000L
					: (((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.MINVW.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.MINVW.getItem(), minvmBetLimit);
		}
		// 小宝马押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.MINBMW.getItem())) {
			long minbmwBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.MINBMW.getItem()).getOdds() == 0l ? 1000L
					: (((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.MINBMW.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.MINBMW.getItem(), minbmwBetLimit);
		}
		// 小奔驰押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.MINBENZ.getItem())) {
			long minbenzBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.MINBENZ.getItem()).getOdds() == 0l ? 1000L : (((ds != null ? ds.getUpDealerChips()
					: 0) + sumChips) / prizeset.get(PrizeItem.MINBENZ.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.MINBENZ.getItem(), minbenzBetLimit);
		}
		// 小宝时捷押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.MINPORSCHE.getItem())) {
			long minporscheBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.MINPORSCHE.getItem()).getOdds() == 0l ? 1000L : (((ds != null ? ds
					.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.MINPORSCHE.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.MINPORSCHE.getItem(), minporscheBetLimit);
		}
		// 大大众押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.BIGVW.getItem())) {
			long bigvmBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.BIGVW.getItem()).getOdds() == 0l ? 1000L
					: (((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.BIGVW.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.BIGVW.getItem(), bigvmBetLimit);
		}
		// 大宝马押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.BIGBMW.getItem())) {
			long bigbmwBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.BIGBMW.getItem()).getOdds() == 0l ? 1000L
					: (((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.BIGBMW.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.BIGBMW.getItem(), bigbmwBetLimit);
		}
		// 大奔驰押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.BIGBENZ.getItem())) {
			long bigbenzBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.BIGBENZ.getItem()).getOdds() == 0l ? 1000L : (((ds != null ? ds.getUpDealerChips()
					: 0) + sumChips) / prizeset.get(PrizeItem.BIGBENZ.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.BIGBENZ.getItem(), bigbenzBetLimit);
		}
		// 大宝时捷押注上限
		if (!CarCache.BETFULLITEMS.containsKey(PrizeItem.BIGPORSCHE.getItem())) {
			long bigporscheBetLimit = ((ds != null ? ds.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.BIGPORSCHE.getItem()).getOdds() == 0l ? 1000L : (((ds != null ? ds
					.getUpDealerChips() : 0) + sumChips) / prizeset.get(PrizeItem.BIGPORSCHE.getItem()).getOdds()) + 1;
			betLimits.put(PrizeItem.BIGPORSCHE.getItem(), bigporscheBetLimit);
		}
		// System.out.println("RacingcarMainThread机器人模拟玩家押注+真人玩家押注当前押注筹码总额:"+sumChips+"庄家押注额为:"+(ds
		// != null ? ds.getUpDealerChips() :
		// 0)+"当前各门押注上限为:"+betLimits.toString());
		return betLimits;
	}

	/**
	 * 每门押注是否已满
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, Boolean> betIsFull(Map<String, Long> map, Long chips) {
		Map<String, Boolean> betsIsFull = new HashMap<String, Boolean>();// 每门是否已经满,比如<minVW,true>,<bigVW,false>
		ConcurrentHashMap<String, Long> robotchips = CarCache.ROBOTCHIPS;
		ConcurrentHashMap<String, Long> chipsset = CarCache.CHIPSSET;
		if (map.containsKey(PrizeItem.MINVW.getItem())) {
			betsIsFull.put(PrizeItem.MINVW.getItem(), robotchips.get(PrizeItem.MINVW.getItem()) + chipsset.get(PrizeItem.MINVW.getItem()) + chips == map.get(PrizeItem.MINVW.getItem()));
		}
		if (map.containsKey(PrizeItem.MINBMW.getItem())) {
			betsIsFull.put(PrizeItem.MINBMW.getItem(), robotchips.get(PrizeItem.MINBMW.getItem()) + chipsset.get(PrizeItem.MINBMW.getItem()) + chips == map.get(PrizeItem.MINBMW.getItem()));
		}
		if (map.containsKey(PrizeItem.MINBENZ.getItem())) {
			betsIsFull.put(PrizeItem.MINBENZ.getItem(), robotchips.get(PrizeItem.MINBENZ.getItem()) + chipsset.get(PrizeItem.MINBENZ.getItem()) + chips == map.get(PrizeItem.MINBENZ.getItem()));
		}
		if (map.containsKey(PrizeItem.MINPORSCHE.getItem())) {
			betsIsFull.put(PrizeItem.MINPORSCHE.getItem(),
					robotchips.get(PrizeItem.MINPORSCHE.getItem()) + chipsset.get(PrizeItem.MINPORSCHE.getItem()) + chips == map.get(PrizeItem.MINPORSCHE.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGVW.getItem())) {
			betsIsFull.put(PrizeItem.BIGVW.getItem(), robotchips.get(PrizeItem.BIGVW.getItem()) + chipsset.get(PrizeItem.BIGVW.getItem()) + chips == map.get(PrizeItem.BIGVW.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGBMW.getItem())) {
			betsIsFull.put(PrizeItem.BIGBMW.getItem(), robotchips.get(PrizeItem.BIGBMW.getItem()) + chipsset.get(PrizeItem.BIGBMW.getItem()) + chips == map.get(PrizeItem.BIGBMW.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGBENZ.getItem())) {
			betsIsFull.put(PrizeItem.BIGBENZ.getItem(), robotchips.get(PrizeItem.BIGBENZ.getItem()) + chipsset.get(PrizeItem.BIGBENZ.getItem()) + chips == map.get(PrizeItem.BIGBENZ.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGPORSCHE.getItem())) {
			betsIsFull.put(PrizeItem.BIGPORSCHE.getItem(),
					robotchips.get(PrizeItem.BIGPORSCHE.getItem()) + chipsset.get(PrizeItem.BIGPORSCHE.getItem()) + chips == map.get(PrizeItem.BIGPORSCHE.getItem()));
		}
		return betsIsFull;
	}

	/**
	 * 每门押注是否已超押注上限
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, Boolean> betIsExceeding(Map<String, Long> map, Long chips) {
		Map<String, Boolean> betIsExceeding = new HashMap<String, Boolean>();// 每门是否达到押注上限,比如<minVW,true>,<bigVW,false>
		ConcurrentHashMap<String, Long> robotchips = CarCache.ROBOTCHIPS;
		ConcurrentHashMap<String, Long> chipsset = CarCache.CHIPSSET;
		if (map.containsKey(PrizeItem.MINVW.getItem())) {
			betIsExceeding.put(PrizeItem.MINVW.getItem(), robotchips.get(PrizeItem.MINVW.getItem()) + chipsset.get(PrizeItem.MINVW.getItem()) + chips > map.get(PrizeItem.MINVW.getItem()));
		}
		if (map.containsKey(PrizeItem.MINBMW.getItem())) {
			betIsExceeding.put(PrizeItem.MINBMW.getItem(), robotchips.get(PrizeItem.MINBMW.getItem()) + chipsset.get(PrizeItem.MINBMW.getItem()) + chips > map.get(PrizeItem.MINBMW.getItem()));
		}
		if (map.containsKey(PrizeItem.MINBENZ.getItem())) {
			betIsExceeding.put(PrizeItem.MINBENZ.getItem(), robotchips.get(PrizeItem.MINBENZ.getItem()) + chipsset.get(PrizeItem.MINBENZ.getItem()) + chips > map.get(PrizeItem.MINBENZ.getItem()));
		}
		if (map.containsKey(PrizeItem.MINPORSCHE.getItem())) {
			betIsExceeding.put(PrizeItem.MINPORSCHE.getItem(),
					robotchips.get(PrizeItem.MINPORSCHE.getItem()) + chipsset.get(PrizeItem.MINPORSCHE.getItem()) + chips > map.get(PrizeItem.MINPORSCHE.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGVW.getItem())) {
			betIsExceeding.put(PrizeItem.BIGVW.getItem(), robotchips.get(PrizeItem.BIGVW.getItem()) + chipsset.get(PrizeItem.BIGVW.getItem()) + chips > map.get(PrizeItem.BIGVW.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGBMW.getItem())) {
			betIsExceeding.put(PrizeItem.BIGBMW.getItem(), robotchips.get(PrizeItem.BIGBMW.getItem()) + chipsset.get(PrizeItem.BIGBMW.getItem()) + chips > map.get(PrizeItem.BIGBMW.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGBENZ.getItem())) {
			betIsExceeding.put(PrizeItem.BIGBENZ.getItem(), robotchips.get(PrizeItem.BIGBENZ.getItem()) + chipsset.get(PrizeItem.BIGBENZ.getItem()) + chips > map.get(PrizeItem.BIGBENZ.getItem()));
		}
		if (map.containsKey(PrizeItem.BIGPORSCHE.getItem())) {
			betIsExceeding.put(PrizeItem.BIGPORSCHE.getItem(),
					robotchips.get(PrizeItem.BIGPORSCHE.getItem()) + chipsset.get(PrizeItem.BIGPORSCHE.getItem()) + chips > map.get(PrizeItem.BIGPORSCHE.getItem()));
		}
		return betIsExceeding;
	}

	/**
	 * 模拟玩家下注
	 * 
	 * @param simulatebet
	 */
	public static void writeDateToChannel(SimulateBet simulatebet) {
		AppContext.getBean(GameCarService.class).sendToAll(simulatebet);
		
		
	}
	
	

	/**
	 * 计算每门押注玩家筹码量+机器人押注筹码量
	 * 
	 * @param item
	 * @return
	 */
	public static Map<String, Long> itemChips() {
		Map<String, Long> chipsMap = new HashMap<String, Long>();
		String[] prizearray = GameCarServiceImpl.PRIZEARRAY;
		Long chips = 0L;
		for (String key : prizearray) {
			chips = (CarCache.ROBOTCHIPS.get(key) != null ? CarCache.ROBOTCHIPS.get(key) : 0) + (CarCache.CHIPSSET.get(key) != null ? CarCache.CHIPSSET.get(key) : 0);
			chipsMap.put(key, chips);
		}
		return chipsMap;
	}
	
	
}
