package com.badugi.game.logic.service.processtask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.badugi.game.logic.helper.LobbyUserHelper;
import com.badugi.game.logic.model.cache.LocalCache;
import com.badugi.game.logic.model.domain.vo.flash.Definition;
import com.badugi.game.logic.model.domain.vo.flash.ResultVo;
import com.badugi.game.logic.model.domain.vo.flash.api.JewelBoxVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.SysConfigVo;
import com.badugi.game.logic.model.message.BetJewelOp;
import com.badugi.game.logic.util.MathExtendUtils;
import com.google.common.collect.Lists;

public class BetJewelTask {
	
	/** 随机类***/
	private static final Random random = new Random();
	
	public BetJewelTask() {
		super();
		
	}

	public ResultVo Task(BetJewelOp op)
	{
		ResultVo vo=null;
		Long roundid=op.getRid();
		Long fbid=op.getUid();
		Long allmoney = 0L;
		Long newmoney = 0L;
		Long singlebet=0L;
		Long code=Definition.BET_SUCCESS;
		
		if(roundid!=null && fbid!=null)
		{
			synchronized (roundid) {
				
				List<SysConfigVo> slist=LobbyUserHelper.getJewelBoxConfig();
				
				 Iterator<SysConfigVo> sitr=slist.iterator();
				 while(sitr.hasNext())
				 {
					 SysConfigVo svo=(SysConfigVo)sitr.next();
					 if("jewelboxmoney".equals(svo.getConfigkey()))
					 {
						 allmoney=Double.valueOf(svo.getConfigvalue()).longValue();//总下注彩池，初始为2000000
					 }
					 else  if("jewelsinglebet".equals(svo.getConfigkey()))
					 {
						 singlebet=Double.valueOf(svo.getConfigvalue()).longValue();//单次下注金额
					 }
				 }
				 newmoney=allmoney;
				
			}
			Double chips=LocalCache.getChips(op.getUid());
				if(chips!=null)
				{
					//验证下注金额是否足够
					if (MathExtendUtils.subtract(chips, singlebet) >= 0) {
						JewelBoxVo item=new JewelBoxVo();
						//LobbyUserHelper.updateJewelBox(item);
						
						 // 更新用户金额
						 // 通知大厅用户金额改动
						 LobbyUserHelper.updateUserFund(fbid, -singlebet.doubleValue(),2,"聚宝盆【下注】");
						 //LobbyUserHelper.updateUserChips(fbid,-singlebet.doubleValue());
						 Date now = new Date();
						 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH-mm-ss");// 可以方便地修改日期格式
						 String wintime = dateFormat.format(now);
						 
						item.setRoundID(roundid);
						item.setFbid(fbid);
						item.setBetMoney(singlebet);
						item.setWinTime(wintime);
						LobbyUserHelper.addJewelBox(item);
						allmoney+=(singlebet-200);
						
						//下注成功
						LobbyUserHelper.updateJewelBoxChips(allmoney.doubleValue());//总奖金池更新入库
						
					}
					else
					{
						code=Definition.BET_MONEY_NOT_ENOUGH;//下注失败
					}
				}
				else
				{
					code=Definition.BET_UNKNOW;//下注失败
				}
			
			//Threadpool.executorOtherPool.execute(new DealwithJewelBoxOpenThread(roundid,(short) 7,"51,51,51,51,11"));
		}
		else
		{
			code=Definition.BET_UNKNOW;//下注失败
		}
		LobbyUserHelper.sendJewelBoxMoney(fbid.toString(), allmoney);
		vo = new ResultVo(Definition.JEWELBOXBET, Long.valueOf(code),Lists.newArrayList(allmoney));
 		return vo;
		
	}
	
	

}
