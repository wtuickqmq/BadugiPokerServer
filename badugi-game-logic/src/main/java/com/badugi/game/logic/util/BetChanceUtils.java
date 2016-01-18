package com.badugi.game.logic.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.model.lobby.helper.GameCarHelper;


public class BetChanceUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(BetChanceUtils.class);


	private static Map<Integer,Integer[]> baseChance=new HashMap<Integer,Integer[]>();
	static{
		//0为普通随机开奖
		Integer[] b0={198,198,198,198,99,50,33,25};//一般随机分布
		//1-3为3类特殊开奖，按下注赔付最少的开奖
		Integer[] b1={192,192,192,192,96,48,32,24};//96%
		Integer[] b2={144,144,144,144,72,36,24,18};//72%
		Integer[] b3={96,96,96,96,48,24,18,12};//48%
		//满足派奖
		Integer[] b4={0,0,0,0,100,200,300,400};
		
		//压到基本赔率比中
		baseChance.put(0, b0);
		baseChance.put(1, b1);
		baseChance.put(2, b2);
		baseChance.put(3, b3);
		baseChance.put(4, b4);
	}
	private static String[] baseChanceStr={"随机","96%","72%","48%","派奖"};
	private static Integer[] addChance={32,274,514};
	
	private static boolean openLottery=true;
	
	private static Integer curChance=0;
	
	                                          
	private static Integer[] chanceThreshold={100000000,110000000,120000000};
	
	private static Integer[] openThreshold={120000000,125000000,130000000};
	
/**
 * 返回随机选中开奖
 * 
 * @param type 使用基本赔率表
 * @param id 赔付最少的id
 * @return
 */
	public static int getChanceNumber(int type,int id){
		 
		Integer[] listitem=baseChance.get(type).clone();
		if(type>=1 && type <=3)
		{//id 的为1-8 要减去1（数组是0-7）
			id--;
			listitem[id]=listitem[id]+addChance[type-1];
		}
		LOGGER.debug("赔率类型：【{}】,得到的赔率表:[{}]",type,listitem);
		ArrayList<ChanceItem> list=new ArrayList<ChanceItem>();
		ChanceItem oitem=null;
		for(int i=0;i<listitem.length;i++)
		{
			ChanceItem item=new ChanceItem();
			item.id=i+1;
			item.value=listitem[i];
			if(item.value!=0)
			{
				if(oitem!=null)
				{
					item.start=oitem.end+1;
					item.end=item.start+item.value-1;
				}
				else
				{
					item.start=1;
					item.end=item.start+item.value-1;
				}
				oitem=item;
			}
			
			list.add(item);
		}
		Random random = new Random(System.currentTimeMillis());
		int s=random.nextInt(1000);
		
		int selectid=1;
		for(ChanceItem ci:list)
		{
			if(s>=ci.start && s<=ci.end)
			{
				selectid=ci.id;
				break;
			}
		}
		LOGGER.debug("随机数：{},最终选择id:[{}]",s,selectid);
		return selectid;
	}
	/**
	 * 根据系统奖池金额确定，选择基本赔率表类型
	 * 
	 * 如果没有到系统最大开奖值，则保持原赔率类型
	 * 
	 * @param chips 系统奖池
	 * 
	 * @return 返回当前的赔率类型
	 */
	public static int getThreeKinds(Long chips)
	{
		
		
		int tChance=2;//本次最小赔率
		if(chips<chanceThreshold[0])
		{
			tChance=2;
		}
		else if(chips<chanceThreshold[1])
		{
			tChance=1;
		}
		else if(chips<chanceThreshold[2])
		{
			tChance=0;
		}
		else
		{
			tChance=0;
		}
		LOGGER.debug("系统奖池：{},最小赔率:{}",chips,tChance);
		
		LOGGER.debug("是否开过奖：{}",openLottery);
		//如果开过奖
		if(openLottery && chips<chanceThreshold[0])
		{
			curChance=2;
			openLottery=false;
		}
		else if(openLottery && chips<chanceThreshold[1])
		{
			curChance=1;
			openLottery=false;
		}
		else if(openLottery && chips<chanceThreshold[2])
		{
			curChance=0;
			openLottery=false;
		}
		
		LOGGER.debug("原赔率:{}",curChance);
		
		if(tChance>curChance)
		{//取本次最小概率
			curChance=tChance;
		}
		
		
		return curChance;
	}
	
	public static boolean checkOpenLottery(int type,Long chips)
	{
		LOGGER.debug("--》测试派奖状态:{},金额：{},类型：{}"+type+",对应派奖线金额：{}"+openThreshold[type],openLottery,chips);
		if(!openLottery && chips>openThreshold[type])
		{
			openLottery=true;
		}
		return openLottery;
	}
	/**
	 * 获取当前概率类型字符串
	 * @return
	 */
	public static final String getChanceStr()
	{
		int type=curChance+1;
		if(type>=0 && type<=4)
		{
			return	baseChanceStr[type];
		}
		return "错误";
	}

}
class ChanceItem
{
	public int id;
	public int value;
	public int start;
	public int end;
	@Override
	public String toString() {
		return "ChanceItem [id=" + id + ", value=" + value + ", start=" + start
				+ ", end=" + end + "]";
	}
	
}
