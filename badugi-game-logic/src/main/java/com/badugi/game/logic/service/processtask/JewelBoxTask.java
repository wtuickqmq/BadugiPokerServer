package com.badugi.game.logic.service.processtask;

import io.nadron.client.util.ObjectBeanUtil;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.dao.UsersDao;
import com.badugi.game.logic.helper.LobbyUserHelper;
import com.badugi.game.logic.model.domain.vo.flash.ResultVo;
import com.badugi.game.logic.model.domain.vo.flash.api.JewelBoxVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.SysConfigVo;
import com.badugi.game.logic.model.entity.UserFund;
import com.badugi.game.logic.model.lobby.helper.WealthApiHelper;
import com.badugi.game.logic.service.impl.PlayerServiceImpl;
import com.badugi.game.logic.util.AppContext;
import com.texas.poker.Card;

public class JewelBoxTask {
	
	static final Logger LOGGER = LoggerFactory.getLogger(JewelBoxTask.class);
	private ResultVo rvo;
    
	public JewelBoxTask(ResultVo rvo) {
		super();
		this.rvo = rvo;
	}

	public static ResultVo Task(Long roundId,Integer roomId,List<JewelBoxVo> jewellist) {
		try{

			synchronized (roundId) {
				
				StringBuffer sql = new StringBuffer("select jb.*,ui.nickname from jewel_box jb,user_info ui ");
				sql.append("where jb.roundid=" + roundId);
				sql.append(" and jb.fbid=ui.u_id");
				
				List<Map<String, Object>> rs = AppContext.getBean(UsersDao.class).querySQLListWithMap(sql.toString());
				
				Iterator<Map<String, Object>> itr = rs.iterator();
		        System.out.println(rs);
		        ArrayList<JewelBoxVo> jlist =new ArrayList<JewelBoxVo>();
				while(itr.hasNext())
				{ 
					JewelBoxVo jbv=new JewelBoxVo();
					Map<String, Object> obj=itr.next();
					jbv.setId(Integer.valueOf(obj.get("Id").toString()));
					jbv.setFbid(Long.valueOf(obj.get("Fbid").toString())); 
					jbv.setBetMoney(Long.valueOf(obj.get("BetMoney").toString()));
					jbv.setNickname(obj.get("nickname").toString());
					jbv.setRoundID(Long.valueOf(obj.get("RoundID").toString()));
					
					jlist.add(jbv);
				}

				if(jlist == null)return null;
				if(jewellist==null || jewellist.size()==0)return null;
				
				Long allmoney = 0L;
				Long newmoney = 0L;
				Long singlebet=0L;
				int winCount=0;
				int cardType=0;
				List<JewelBoxVo> BetList=new ArrayList<JewelBoxVo>();
				List<JewelBoxVo> OpenList=new ArrayList<JewelBoxVo>();
				List<SysConfigVo> slist=LobbyUserHelper.getJewelBoxConfig();
				
				 Iterator sitr=slist.iterator();
				 while(sitr.hasNext())
				 {
					 SysConfigVo svo=(SysConfigVo)sitr.next();
					 if("jewelboxmoney".equals(svo.getConfigkey()))
					 {
						 allmoney=Double.valueOf(svo.getConfigvalue()).longValue();
					 }
					 else  if("jewelsinglebet".equals(svo.getConfigkey()))
					 {
						 singlebet=Double.valueOf(svo.getConfigvalue()).longValue();
					 }
				 }
				 newmoney=allmoney;
				
			
				 Date now = new Date();
				 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH-mm-ss");// 可以方便地修改日期格式
				 String wintime = dateFormat.format(now);

				for(JewelBoxVo jv:jlist)
				{
					jv.setHolecards("");
					jv.setWinCards("");
					jv.setIsWiner((short)0);
					jv.setWinType( -1);
					jv.setWinTime(wintime);
					for(JewelBoxVo item : jewellist)
					{
						if(jv.getFbid().equals(item.getFbid()))
						{
							jv.setHolecards(item.getHolecards());
							jv.setWinCards(item.getWinCards());
							

							if(item.getIsWiner()==1 && item.getWinType()>5)
							{

								String handCard=item.getWinCards();
								String[] holdCards=item.getHolecards().split(",");
								

								if((((handCard.indexOf(holdCards[0])!=-1) && (handCard.indexOf(holdCards[1])!=-1)) && item.getWinType()!=7) ||
										(isHandPair(holdCards) && item.getWinType()==6 && ((handCard.indexOf(holdCards[0])!=-1) || (handCard.indexOf(holdCards[1])!=-1))) ||
										((handCard.indexOf(holdCards[0])!=-1) && (handCard.indexOf(holdCards[1])!=-1) && item.getWinType()==7 && findFourCardInList(holdCards,handCard.split(","))))
								{
									jv.setIsWiner(item.getIsWiner());
									jv.setWinType(item.getWinType());
									winCount++;//投注聚宝盆、并且赢得主池、牌型要是获奖牌型\四条手中必须是一对

								}
							}
						}

					}
					BetList.add(jv);
				}


				for(JewelBoxVo item : BetList)
				{//分配奖金，并且记录入数据库，socket通知客户端领奖
					Long WinMoney = 0L;
					Long prizeMoney = 0L;
					
					Integer MaxCardType=item.getWinType().intValue();
					if (MaxCardType > 5) {
						if (MaxCardType == 6) {// 葫芦
							WinMoney = (long) (allmoney * 0.01);
						} else if (MaxCardType == 7) {// 四条
							WinMoney = (long) (allmoney * 0.10);
						} else if (MaxCardType == 8) {// 同花顺
							WinMoney = (long) (allmoney * 0.30);
						} else if (MaxCardType >= 9) {// 皇家同花顺
							WinMoney = (long) (allmoney * 0.80);
						}
						newmoney -= WinMoney/winCount;// 扣除中奖金额,winCount>1时为多人中奖
						prizeMoney= WinMoney/winCount;
						
									
					}
					item.setWinMoney(prizeMoney);
					
					//Map<Integer, Object> result=JewelBoxDao.CreateJewelBoxInfo(item);//保存投注信息
					
					LobbyUserHelper.updateJewelBox(item);
					//测试暂时注解，是否发送得奖信息
					if (prizeMoney > 0 && MaxCardType > 5) 
					{
						// 成生获奖奖品信息
						if(prizeMoney!=0)
						{
							LobbyUserHelper.updateUserFund(item.getFbid(), prizeMoney.doubleValue(),2,"聚宝盆【获奖】");
							//LobbyUserHelper.updateUserChips(item.getFbid(),prizeMoney.doubleValue());//更新玩家筹码

							WealthApiHelper.reachieve(item.getFbid(), WealthApiHelper.AchieveSubtype.chips.getValue());//检测是否有筹码
						}
						Timestamp mnow = new Timestamp(System.currentTimeMillis());
						
						// 获奖信息发送到Flash客户端

						OpenList.add(item);

				
					}


				}	

				if (OpenList.size()>0)
				{
					if(newmoney<0)newmoney=0L;
					
					LobbyUserHelper.sendWinMoneyToAllUser(roomId,newmoney,OpenList);//发送中奖玩家列表
					
					if(newmoney!=allmoney)
					{//发总奖金消息到客户端
						// 更新系统彩池
						LobbyUserHelper.updateJewelBoxChips(newmoney.doubleValue());

						LobbyUserHelper.sendJewelBoxMoney(newmoney);
					}
				}

				
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("deal with JewelBoxOpen  error  !!!", e);
		}

		return null;

	}
	
	private static boolean findFourCardInList(String[] hcards,String[] bcards)
	{
		List<Card> blist=new ArrayList<Card>();
		if(bcards!=null)
		{
			for(int i=0;i<bcards.length;i++)
			{
				blist.add(Card.newCard(bcards[i]));
			}
			Card hcard1=Card.newCard(hcards[0]);
			Card hcard2=Card.newCard(hcards[1]);
			int count=0;
			if(hcard1.getValue()==hcard2.getValue())
			{
				return true;
			}
			/*for(Card tc:blist)
			{
				if(tc.getValue()==hcard1.getValue() && tc.getSuit()!=hcard1.getSuit()  || tc.getValue()==hcard2.getValue() && tc.getSuit()!=hcard2.getSuit())
				{
					count++;
				}
			}
		
			if(count>=4)
			{
					return true;
			}*/

		}
		return false;
	}
	
	private static boolean isHandPair(String[] hcards)
	{
		Card hcard1=Card.newCard(hcards[0]);
		Card hcard2=Card.newCard(hcards[1]);
		if(hcard1.getValue()==hcard2.getValue())
		{
			return true;
		}
	    return false;
	}
	private static boolean findCardInList(String[] hcards,String[] bcards)
	{
		List<Card> blist=new ArrayList<Card>();
		if(bcards!=null)
		{
			for(int i=0;i<bcards.length;i++)
			{
				blist.add(Card.newCard(bcards[i]));
			}
			Card hcard1=Card.newCard(hcards[0]);
			Card hcard2=Card.newCard(hcards[1]);
			int count=0;
			
			for(Card tc:blist)
			{
				if(tc.getValue()==hcard1.getValue() || tc.getValue()==hcard2.getValue())
				{
					count++;
				}
			}
			if(hcard1.getValue()==hcard2.getValue())
			{
				if(count<=1)
				{
					return true;
				}
			}
			else
			{
				if(count>=5)
				{
					return true;
				}
			}
		
			
		}
		return false;
	}



}
