package com.badugi.game.logic.helper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.model.vo.flash.operators.JewelBoxListVo;
import com.badugi.game.logic.model.vo.flash.operators.JewelBoxVo;
import com.badugi.game.logic.util.LogicChannelUtil;
import com.joker.game.common.constant.Definition;

public final class JewelBoxHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(JewelBoxHelper.class);

	/**
	 * 发送聚宝盆总金额到flash
	 * 
	 * @param el
	 *            新的等级
	 */
	public static void sendMoneyToAllUser(Long chips) {
		try {
			JewelBoxListVo vo = new JewelBoxListVo();
			vo.setCode(Definition.SUCCESS_CODE);
			vo.setCmd(Definition.JEWELBOXUPDATEMONEY);
			vo.setChips(chips);
			// 发送所有用户
			LogicChannelUtil.sendToAll(vo);
			LOGGER.info("彩池金额变动,发送到Flash---->");
		} catch (Exception e) {
			LOGGER.error("sendMoneyToAllUser error:" + e.getMessage(), e);
		}
	}

	/**
	 * 发送聚宝盆获奖公告flash
	 * 
	 * @param el
	 *            新的等级
	 */
	public static void sendWinMoneyToAllUser(Integer roomid, Long chips, List<JewelBoxVo> list) {
		try {
			JewelBoxListVo vo = new JewelBoxListVo();
			vo.setCode(Definition.SUCCESS_CODE);
			vo.setCmd(Definition.JEWELBOXOPEN);
			vo.setRoomid(roomid);
			vo.setChips(chips);
			vo.setList(list);
			LogicChannelUtil.sendToAll(vo);
			// 发送所有用户
			LOGGER.info("聚宝盆获奖公告,发送到Flash---->");
		} catch (Exception e) {
			LOGGER.error("sendWinMoneyToAllUser error:" + e.getMessage(), e);
		}
	}

	public static void sendJewelBoxMoney(Long chips) {
		JewelBoxListVo vo = new JewelBoxListVo();
		vo.setCode(Definition.SUCCESS_CODE);
		vo.setCmd(Definition.SENDJEWELBOXMONEY);
		vo.setRoomid(0);
		vo.setChips(chips);
		vo.setList(null);
		LogicChannelUtil.sendToAll(vo);
		// 发送所有用户
		LOGGER.info("聚宝盆总筹码更新,发送到Flash---->");
	}

}
