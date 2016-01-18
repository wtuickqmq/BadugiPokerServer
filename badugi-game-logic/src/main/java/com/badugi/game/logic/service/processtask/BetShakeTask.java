package com.badugi.game.logic.service.processtask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.helper.LobbyUserHelper;
import com.badugi.game.logic.model.cache.LocalCache;
import com.badugi.game.logic.model.domain.vo.flash.Definition;
import com.badugi.game.logic.model.domain.vo.flash.ResultVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.ShakeOpenVo;
import com.badugi.game.logic.model.lobby.helper.WealthApiHelper;
import com.badugi.game.logic.model.message.BetShakeOp;
import com.badugi.game.logic.util.LogicChannelUtil;
import com.badugi.game.logic.util.MathExtendUtils;
import com.google.common.collect.Lists;
import com.texas.poker.Card;
import com.texas.poker.TexasConstant;
import com.texas.poker.TexasConstant.PokerHandType;
import com.texas.poker.oddscalcu.RecogniseHandFive;
import com.texas.poker.pokerhand.PokerHandBase;

public class BetShakeTask {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BetShakeTask.class);
	
	private static final List<Integer> cardList = new ArrayList<Integer>(52);
	/** 随机类�? */
	private static final Random random = new Random();
	
	private BetShakeOp op;
	
	
	public BetShakeTask(BetShakeOp op) {
		super();
		this.op = op;
	}

	public ResultVo Task()
	{
		ResultVo vo=null;
	    Double chips=LocalCache.getChips(op.getUid());
	    try
	    {
			//验证下注金额是否足够
			if (MathExtendUtils.subtract(chips, op.getChip()) >= 0 && op.getChip()>0) {
				/********开奖过程*********/
				//随机产生五张牌

				Card[] card1Arr = new Card[7];
				 
				 
				    BetShakeTask.inflater();
				  


					 card1Arr[0] = BetShakeTask.pullOut();
					 card1Arr[1] = BetShakeTask.pullOut();
					 card1Arr[2] = BetShakeTask.pullOut();
					 card1Arr[3] = BetShakeTask.pullOut();
					 card1Arr[4] = BetShakeTask.pullOut();
					
				 
			    PokerHandBase ph =  RecogniseHandFive.recogniseFiveCard(card1Arr[0],card1Arr[1],card1Arr[2],card1Arr[3],card1Arr[4]);
					
				 // ph=RecogniseHandFive.recogniseFiveCard(card1Arr);
				 //ph = RecogniseHand.recognise(card1Arr);		 
				 
				int wintype=ph.getPokerHandType().getValue();//五张牌类型
				Long winmoney=0L;//赢得的奖金
				if(PokerHandType.HIGH_CARD.getValue()==wintype)//高牌
				{
					winmoney=0L;
				}
				else if(PokerHandType.PAIR.getValue()==wintype)//对子
				{
					winmoney=op.getChip();
				}
				else if(PokerHandType.TWO_PAIR.getValue()==wintype)//两对
				{
					winmoney=op.getChip()*3;
				}
				else if(PokerHandType.THREE_OF_A_KIND.getValue()==wintype)//三条
				{
					winmoney=op.getChip()*5;
				}
				else if(PokerHandType.STRAIGHT.getValue()==wintype)//顺子
				{
					winmoney=op.getChip()*10;
				}
				else if(PokerHandType.FLUSH.getValue()==wintype)//同花
				{
					winmoney=op.getChip()*20;
				}
				else if(PokerHandType.FULL_HOUSE.getValue()==wintype)//葫芦
				{
					winmoney=op.getChip()*80;
				}
				else if(PokerHandType.FOUR_OF_A_KIND.getValue()==wintype)//四条
				{
					winmoney=op.getChip()*200;
				}
				else if(PokerHandType.STRAIGHT_FLUSH.getValue()==wintype)//同花顺
				{
					winmoney=op.getChip()*1000;
				}
				else if(PokerHandType.ROYAL_FLUSH.getValue()==wintype)//皇家同花顺
				{
					winmoney=op.getChip()*10000;
				}
				if(wintype>0)
				{//当赢利超过10万，则广播中奖信息
					if(wintype>=3)
					{//当牌型超过3，则发出分享提示
						
					}
				}
				Integer upmoney=winmoney.intValue()-op.getChip().intValue();//扣除下注费用，如果赢利为0，则为负值
				if(op.getChip().intValue()<0)return null;	
				
				String fbname=LocalCache.getNickName(op.getUid());
				
				ShakeOpenVo	svo=new ShakeOpenVo(Definition.SHAKEOPEN,Definition.BET_SUCCESS,op.getRid(),op.getUid(),fbname,wintype,ph.getCardStr(),winmoney);
				
				
				if(wintype>=PokerHandType.FLUSH.getValue())
				{//当牌型 大于等于同花时推给所有用户
					
					
					LogicChannelUtil.sendToAll(svo);
					
				}
				else
				{//小于则发送给下注玩家自己
					LogicChannelUtil.sendToTargets(svo, Lists.newArrayList(op.getUid().toString()));
				}
				
				try {
				
					Thread.sleep(2*1000);//3秒后更新游戏数据库
				} catch (Exception e) {
					LOGGER.error("BetShakeThread error  " + e.getMessage(),e);
				}
				
				if(upmoney!=0)
				{
				   LobbyUserHelper.updateUserFund(op.getUid(), upmoney.doubleValue(),3,"摇摇乐");
				   //LobbyUserHelper.updateUserChips(op.getUid(),upmoney.doubleValue());//更新玩家筹码
				  
				  WealthApiHelper.reachieve(op.getUid(), WealthApiHelper.AchieveSubtype.chips.getValue());//检测是否有筹码
				}
				//更新数据库日志
				LobbyUserHelper.saveBetShakeLog(op.getUid(), wintype, ph.getCardStr(), op.getChip(), winmoney);
				
				
			    
				vo=new ResultVo(Definition.SHAKEOPEN, Definition.BET_SUCCESS);//下注并开奖成功
			}
			else
			{
				vo=new ResultVo(Definition.SHAKEOPEN, Definition.BET_MONEY_NOT_ENOUGH);
			}
	
		
	}
    catch (Exception e) {
	     vo = new ResultVo(Definition.SHAKEOPEN, Definition.UNKNOW_CODE);
	     LOGGER.error("deal with shakeopen error  !!!",e);
    }
 		return vo;
		
	}
	
	public static void inflater() {
		cardList.clear();
		for (int i = 0; i < TexasConstant.CARD_NUM; i++) {
			cardList.add(i);
		}
	}
	public static com.texas.poker.Card pullOut() {
		int pos = random.nextInt(cardList.size());
		int serialNo = cardList.get(pos);
		// Card card = new Card(serialNo);
		com.texas.poker.Card card = com.texas.poker.Card.newCard(serialNo);
		cardList.remove(pos);
		return card;
	}

}
