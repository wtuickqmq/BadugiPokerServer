package com.badugi.game.logic.model.lobby.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.model.domain.vo.flash.Definition;
import com.badugi.game.logic.model.domain.vo.flash.user.MsgSendVo;
import com.badugi.game.logic.model.utils.common.DateUtils;
import com.badugi.game.logic.model.vo.supreme.PrizeItem;
import com.badugi.game.logic.service.GameCarService;
import com.badugi.game.logic.util.AppContext;
import com.badugi.game.logic.util.LogicChannelUtil;
import com.google.common.collect.Lists;




/**
 * 小游戏活动
 * @author wtu.edit
 * @date 2015年12月3日
 * @version qq1.0
 * @email wtuickqmq@163.com
 */
public class GameCarActiveHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(GameCarActiveHelper.class);
	private static final List<Map<String,String>> mulActiveTime=new ArrayList<Map<String,String>>();
	private static final List<Integer> tipsArr=new ArrayList<Integer>();
	private static final String mulActiveEndTime="2015-12-1 0:0:0";
	private static final int[] mulArray={0,1,2,4,8,16};
	static{
		{// key=奖项,value=赔率
			Map<String,String> time1=new HashMap<String,String>();
			Map<String,String> time2=new HashMap<String,String>();
			
			time1.put("tips1", "13:50:00");
			time1.put("isShow1","0");
			time1.put("tips2", "13:55:00");
			time1.put("isShow2","0");
			time1.put("start", "14:00:00");
			time1.put("end", "16:00:00");
			
			
			time2.put("tips1", "19:50:00");
			time2.put("isShow1","0");
			time2.put("tips2", "19:55:00");
			time2.put("isShow2","0");
			time2.put("start", "20:00:00");
			time2.put("end", "22:00:00");
			
			/*测试
			time2.put("tips1", "19:00:00");
			time2.put("isShow1","0");
			time2.put("tips2", "19:05:00");
			time2.put("isShow2","0");
			time2.put("start", "10:10:00");
			time2.put("end", "12:00:00");*/
			
			mulActiveTime.add(time1); 
			mulActiveTime.add(time2);
			
			
		}
	};
	/**
	 * 测试是否关闭游戏
	 * @return
	 */
	public static boolean isMulActiveOff()
	{
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Date endDate=sf.parse(mulActiveEndTime);
			if((new Date()).getTime()>=endDate.getTime())
			{
				return true;
			}
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	public static boolean checkOpenMulTime()
	{
		Iterator<Map<String,String>> itr= mulActiveTime.iterator();
		while(itr.hasNext())
		{
			Map<String,String> item=itr.next();
			
			String start=item.get("start");
			String end=item.get("end");
			if(checkNowInTime(start,end))
			{
				return true;
			}
		}
		return false;
	}
	public static boolean checkNowInTime(String start,String end)
	{
		try {
			Date nowDate = new Date(); //第一个时间
			
			
			SimpleDateFormat f1 = new SimpleDateFormat("HH:mm:ss"); //格式化为 hhmmss
						
			Long t1 = DateUtils.TimeStringToDate(f1.format(nowDate)).getTime(); //将第一个时间格式化后转为int
			Long t2 = DateUtils.TimeStringToDate(start).getTime();
			Long t3 = DateUtils.TimeStringToDate(end).getTime();
			//LOGGER.info("now:{}",DateUtils.TimeStringToDate(f1.format(nowDate)));
			//LOGGER.info("t1:{},t2:{}",DateUtils.TimeStringToDate(start),DateUtils.TimeStringToDate(end));
			if(t1>=t2 && t1<t3)
			{
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * 检测是否弹出提示  true 弹出，false 不弹
	 */
	public static int checkShowTips()
	{
		
		Iterator<Map<String,String>> itr= mulActiveTime.iterator();
		
		while(itr.hasNext())
		{
			Map<String,String> item=itr.next();
			String isShow1=item.get("isShow1");
			String isShow2=item.get("isShow2");
			String tips1=item.get("tips1");
			String tips2=item.get("tips2");
			String start=item.get("start");
			String end=item.get("end");
			
			if(checkTime(tips1,"0".equals(isShow1)?false:true,start))
			{
				tipsArr.clear();
				item.put("isShow1","1");
				return 1;
			}
			else if(checkTime(tips2,"0".equals(isShow2)?false:true,start))
			{
				item.put("isShow2","1");
				return 2;
			}
			else if(checkStartTime(start))
			{
				item.put("isShow1","0");
				item.put("isShow2","0");
				return 3;
			}
		}
		//return true;//测试直接弹出提示
		return 0;
	}
	public static boolean checkTime(String tipsTime,boolean isShow,String startTime)
	{
		
		try {
			Date nowDate = new Date(); //第一个时间
			SimpleDateFormat f1 = new SimpleDateFormat("HH:mm:ss"); //格式化为 hhmmss
			
			Long t1 = DateUtils.TimeStringToDate(f1.format(nowDate)).getTime(); //将第一个时间格式化后转为int
			Long t2 = DateUtils.TimeStringToDate(tipsTime).getTime();
			Long t3 = DateUtils.TimeStringToDate(startTime).getTime();
			
			if(t1>=t2 && !isShow && t1<t3)
			{
				return true;
			}
			//LOGGER.debug("time1:{},time2:{}",t1,t2);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		
		return false;
	}
	
	public static boolean checkStartTime(String startTime)
	{
		
		try {
			Date nowDate = new Date(); //第一个时间
			SimpleDateFormat f1 = new SimpleDateFormat("HH:mm:ss"); //格式化为 hhmmss
			
			Long t1 = DateUtils.TimeStringToDate(f1.format(nowDate)).getTime(); //将第一个时间格式化后转为int
			Long t2 = DateUtils.TimeStringToDate(startTime).getTime();
			
			Long t4=((t1-t2)/1000)/600;
			boolean inList=false;
			if(tipsArr.indexOf(t4.intValue())>=0)
			{
				inList=true;
			}
			
			if(t1>=t2 && !inList)
			{
				tipsArr.add(t4.intValue());
				return true;
			}
			//LOGGER.debug("time1:{},time2:{}",t1,t2);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		
		return false;
	}
	/**
	 * 返回连继开奖倍数
	 * 
	 * @param dlist 历史开奖列表
	 * @param winItem 当前开奖
	 * @return 返回倍数，1-5倍，没有连继则为0
	 */
	public static int getMulForItem(List<String> dlist,String winItem)
	{
		int mul=0;
		if(dlist!=null)
		{
			if(dlist.size()>1)
			{
				int i=1;
				for(i=1;i<dlist.size();i++)
				{
					
					//LOGGER.debug(i+"--->>:{}-----{}--->"+String.valueOf(dlist.get(i)).equals(String.valueOf(winItem.toString()))
					//		,dlist.get(i).toString(),winItem.toString());
					if(String.valueOf(dlist.get(i)).equals(String.valueOf(winItem.toString())))
					{
						mul++;
						if(mul>=5){ 
							mul=5;
							return mulArray[mul];}
					}
					else
					{
						return mulArray[mul];
					}
				}
				
			}
		}
		return mulArray[mul];
	}
	
	public static void SendNoticesForTips()
	{
		if(!GameCarActiveHelper.isMulActiveOff())
		{//大喇叭通知游戏翻倍活动
			String content=null;
			if(GameCarActiveHelper.checkShowTips()==1)
			{
				content="极品豪车赚翻天活动将在10分钟后开启，赚钱好机会，千万别错过！";
			}
			else if(GameCarActiveHelper.checkShowTips()==2)
			{
				content="极品豪车赚翻天活动将在5分钟后开启，赚钱好机会，千万别错过！";
			}
			else if(GameCarActiveHelper.checkShowTips()==3)
			{
				content="极品豪车赚翻天活动火热进行中，赚钱好机会，千万别错过！";
			}
			if(content!=null){
				MsgSendVo msgvo = new MsgSendVo(Definition.NOTICES,1, content, DateUtils.dateToString(new Date(), DateUtils.PATTERN_YMDHMS));
				// 发送
				//LogicChannelUtil.sendToAll(msgvo);
				AppContext.getBean(GameCarService.class).sendToServerAll(msgvo);
			}
		}
	}
	
	
	public static void SendNoticesForWin(String nick,Long mulChips,Integer mul)
	{
		String content="恭喜  "+nick+" 在“豪车赚翻天”活动中，额外获得"+mul+"倍筹码奖励："+mulChips+"筹码";
		MsgSendVo msgvo = new MsgSendVo(Definition.NOTICES,2, content, DateUtils.dateToString(new Date(), DateUtils.PATTERN_YMDHMS));
		// 发送
		AppContext.getBean(GameCarService.class).sendToServerAll(msgvo);
		//LogicChannelUtil.sendToAll(msgvo);
	}
	
	
}
