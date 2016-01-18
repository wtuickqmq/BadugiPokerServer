package com.badugi.game.logic.model.domain.vo.flash.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.helper.LobbyUserHelper;
import com.badugi.game.logic.model.domain.vo.flash.api.JewelBoxVo;
import com.badugi.game.logic.model.domain.vo.flash.user.UserFundDetails;
import com.badugi.game.logic.model.entity.GameUserlog;
import com.badugi.game.logic.model.lobby.helper.WealthApiHelper;
import com.badugi.game.logic.model.message.GameUserMessage;
import com.badugi.game.logic.model.vo.api.poker.param.GameendVo;
import com.badugi.game.logic.model.vo.flash.operators.FishEnemyVo;
import com.badugi.game.logic.service.processtask.JewelBoxTask;
import com.badugi.game.logic.util.LogicPropertyUtil;


public class DealwithFishEnemyThread extends Thread {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealwithFishEnemyThread.class);
	
	private final Integer roundId;

	public DealwithFishEnemyThread(Integer roundId) {
		super();
		this.roundId = roundId;
	}

	@Override
	public void run() {
		FishEnemyVo vo = null;
		// Long sendFbid=0L;
		LOGGER.info("局号:" + roundId + " 结束，时入是否标敌人或者Fish判断");
		try {
			int count = LogicPropertyUtil.getInteger("option.fishenemy.count",0);
			int bbei = LogicPropertyUtil.getInteger("option.fishenemy.before.bei",0);
			int abei = LogicPropertyUtil.getInteger("option.fishenemy.after.bei",0);

			List<GameUserlog> gameUserlogList = LobbyUserHelper.getGameUserlogList(roundId);

			Short handCardType=-1;
			String handCard=null;
			Long lostFbid = 0L;
			Double lostchangeChips = 0.0;
			Long winFbid = 0L;
			Double winchangeChips = 0.0;
			// Double sb=0.0;
			Double bb = 0.0;
			Integer roomId = 0;
			Map<Long, Long> winFbPrompt = new HashMap<Long, Long>();
//			List<GameUserMessage> gulist = new ArrayList<GameUserMessage>();
			GameUserMessage gum = null;
			ArrayList<JewelBoxVo> jewellist=new ArrayList<JewelBoxVo>();
			
			for (GameUserlog gu : gameUserlogList) {
				
				
				double changeChips = gu.getChangeChips();
				long uid = gu.getFbId();
				if (changeChips < lostchangeChips.doubleValue()) {
					lostFbid = uid;
					lostchangeChips = gu.getChangeChips();
				}
				if (changeChips > winchangeChips.doubleValue()) {
					winFbid = uid;
					winchangeChips = gu.getChangeChips();
				}
				// sb=gu.getSmallBlind();
				bb = gu.getBigBlind();
				roomId = gu.getRoomId();
				if (changeChips > 0) {
					winFbPrompt.put(uid, Math.round(changeChips));
				}
				
//				gum = new GameUserMessage(uid, Math.round(changeChips), gu.getHoleCards(), gu.getWinChips() == null ? 0 : gu.getWinChips().longValue());
//				gulist.add(gum);
				Integer wtype=gu.getHandCardType().intValue();
				//if(wtype>=0)
				{
					JewelBoxVo item=new JewelBoxVo();
					item.setRoundID(roundId.longValue());
					item.setFbid(uid);
					item.setNickname(gu.getNickName());
					item.setHolecards(gu.getHoleCards());
					item.setWinCards(gu.getRoundMaxCards());
					item.setIsWiner(gu.getWinMainPool());
					//item.setWincards("23,24,25,26,27");
					item.setWinType(wtype);
					//item.setWintype((short) 6);
					jewellist.add(item);
				}
				
				UserFundDetails uf = LobbyUserHelper.getUserInfo(uid);
				
				LOGGER.info("uf :{}",uf);
				if(uf == null || uf.getTp() != 0) continue;
				
				// 通知商城处理
				GameendVo reqParam = new GameendVo();
				reqParam.setUid(uid);
				reqParam.setUlogId(gu.getUlogId());
				
				WealthApiHelper.asynapi(reqParam, WealthApiHelper.GAME_END);
			}
			///进入聚宝盆处理线程
			JewelBoxTask.Task(roundId.longValue(), roomId, jewellist);
//			Threadpool.executorOtherPool.execute(new DealwithJewelBoxOpenThread(roundId.longValue(),roomId,jewellist));
//			// 用户关系改变通知商城 begin
//			com.fasterxml.jackson.databind.ObjectMapper jscksonObjectMapper = SpringLoader.getInstance("com.fasterxml.jackson.databind.ObjectMapper", com.fasterxml.jackson.databind.ObjectMapper.class);
//			org.springframework.amqp.rabbit.core.RabbitTemplate rabbitTemplate = SpringLoader.getInstance("org.springframework.amqp.rabbit.core.RabbitTemplate", org.springframework.amqp.rabbit.core.RabbitTemplate.class);
//			// public GameOverMessage(Integer gid, Integer gtime, Integer betround, String publiccard, List<GameUserMessage> list)
//			GameOverMessage gameOverMessage = new GameOverMessage(roundId, gameLog.getPlayTime(), gameLog.getBetRound().intValue(), gameLog.getPublicCards(), gameLog.getSmallBlind().intValue(), gulist);
//	 		String jsonString = jscksonObjectMapper.writeValueAsString(gameOverMessage);
//			Logger.info("================游戏结束后传送游戏情况到商城===updateRelationString=================\n" + jsonString);
//			rabbitTemplate.convertAndSend(xusage.lobby.common.message.GameOverMessage.ROUTING_KEY, jsonString);
			// 用户关系改变通知商城 end

			/*更新用户 汇总信息*/
//			Logger.info("局号:" + roundId + " 大盲:" + bb + "; lostFbid:" + lostFbid + "(lostchangeChips:" + lostchangeChips + ");winFbid:" + winFbid + "(winchangeChips:" + winchangeChips + ");bbei:" + bbei + ";abei:" + abei + ";count:" + count);
//			// 求是否标敌人
//			if ((0 - lostchangeChips) > bbei * bb) {
//				UserInfo ui = LobbyUserHelper.getUserInfo(lostFbid);
//				if (ui == null || ui.getPopRelaWinCount() < count || (ui.getPopRelaWinCount() >= count && lostchangeChips > abei * bb)) {// 如果是前count(现默认为3)次 ,并且输赢bbei(现默认20)个大盲,或者已经超过前count(现默认为3)次，并且输赢abei(现默认100)个大盲
//					List<UserRelation> list = LobbyUserHelper.findUserRelationList(lostFbid, winFbid, UserRelation.FLAG_FOE);
//					if (list == null || list.size() <= 0) {// 如果目前不是敌人则标示
//						UserFund uf = LobbyUserHelper.getUserFund(winFbid);
//						Integer isf = 0;// 是否反标
//						List<UserRelation> flist = LobbyUserHelper.findUserRelationList(winFbid, lostFbid, UserRelation.FLAG_FISH);
//						if (flist == null || flist.size() == 0) {
//							isf = 1;
//						}
//						vo = new FishEnemyVo(Definition.FLAGTIPMSGS, Definition.SUCCESS_CODE, 2, roomId, winFbid, uf.getFbName(), isf);
//						if (ui == null) {
//							LobbyUserHelper.updateUserInfo(1, lostFbid);
//						}
//						else {
//							LobbyUserHelper.updateUserInfo(2, lostFbid);
//						}
//						Logger.info("DealwithFishEnemyThread " + lostFbid + "标" + winFbid + "敌人:");
//						String msg = JsonUtils.beanToJson(vo);
//						LobbyService.SendMsg2User(lostFbid, msg);
//						Logger.info("DealwithFishEnemyThread " + lostFbid + "标" + winFbid + "敌人:" + msg);
//					}
//
//				}
//			}
//
//			// 求是否标Fish
//			if (winchangeChips > bbei * bb) {
//				UserInfo ui = LobbyUserHelper.getUserInfo(winFbid);
//				if (ui == null || ui.getPopRelaWinCount() < count || (ui.getPopRelaWinCount() >= count && winchangeChips > abei * bb)) {// 如果是前count(现默认为3)次 ,并且输赢bbei(现默认20)个大盲,或者已经超过前count(现默认为3)次，并且输赢abei(现默认100)个大盲
//					List<UserRelation> list = LobbyUserHelper.findUserRelationList(winFbid, lostFbid, UserRelation.FLAG_FISH);
//					if (list == null || list.size() <= 0) {// 如果目前不是Fish则标示
//						UserFund uf = LobbyUserHelper.getUserFund(lostFbid);
//						Integer isf = 0;// 是否反标
//						List<UserRelation> flist = LobbyUserHelper.findUserRelationList(lostFbid, winFbid, UserRelation.FLAG_FOE);
//						if (flist == null || flist.size() == 0) {
//							isf = 1;
//						}
//						vo = new FishEnemyVo(Definition.FLAGTIPMSGS, Definition.SUCCESS_CODE, 1, roomId, lostFbid, uf.getFbName(), isf);
//						if (ui == null) {
//							LobbyUserHelper.updateUserInfo(1, winFbid);
//						}
//						else {
//							LobbyUserHelper.updateUserInfo(2, winFbid);
//						}
//						winFbPrompt.remove(winFbid);
//						Logger.info("DealwithFishEnemyThread " + winFbid + "标" + lostFbid + "为Fish:");
//						String msg = JsonUtils.beanToJson(vo);
//						LobbyService.SendMsg2User(winFbid, msg);
//						Logger.info("DealwithFishEnemyThread " + winFbid + "标" + lostFbid + "为Fish:" + msg);
//					}
//
//				}
//			}
//
//			Set<Map.Entry<Long, Long>> set = winFbPrompt.entrySet();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			int popcount = OptionUtils.convertToInteger(OptionUtils.getOption("option.winpop.count"));
//			int popbbcount = OptionUtils.convertToInteger(OptionUtils.getOption("option.winpop.min.bb"));
//			String now = sdf.format(new Date());
//			for (Iterator<Map.Entry<Long, Long>> it = set.iterator(); it.hasNext();) {
//				Map.Entry<Long, Long> entry = it.next();
//				Long fbId = entry.getKey();
//				Long chips = entry.getValue();
//				UserInfo ui = LobbyUserHelper.getUserInfo(fbId);
//				// WINPROMPTfbId
//				if (ui == null || ui.getPopWinDayTime() == null || !now.equals(sdf.format(ui.getPopWinDayTime())) || (now.equals(sdf.format(ui.getPopWinDayTime())) && ui.getPopWinCount() < popcount)) {
//					if (winchangeChips >= popbbcount * bb) {
//						WinPromptVo vo_ = new WinPromptVo(Definition.WINPROMPT, Definition.SUCCESS_CODE, roomId, chips);
//						if (ui == null) {
//							LobbyUserHelper.updateUserInfoForWinPop(1, fbId);
//						}
//						else if (ui.getPopWinDayTime() == null || !now.equals(sdf.format(ui.getPopWinDayTime()))) {
//							LobbyUserHelper.updateUserInfoForWinPop(3, fbId);
//						}
//						else {
//							LobbyUserHelper.updateUserInfoForWinPop(2, fbId);
//						}
//						Logger.debug("----------------" + fbId + "赢钱并提示了begin");
//						String msg = JsonUtils.beanToJson(vo_);
//						LobbyService.SendMsg2User(fbId, msg);
//						Logger.debug("----------------" + fbId + "赢钱并提示了end");
//					}
//				}
//			}
		}
		catch (Exception e) {
			LOGGER.error("deal with DealwithFishEnemyThread error  !!!", e);
		}
	}
}