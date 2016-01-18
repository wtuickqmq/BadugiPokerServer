package com.badugi.game.logic.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.model.domain.vo.flash.Definition;
import com.badugi.game.logic.model.domain.vo.flash.operators.RobotRoomVo;
import com.badugi.game.logic.model.domain.vo.flash.user.UserInRoom;
import com.badugi.game.logic.util.LogicChannelUtil;

/**
 * 机器人管理
 * 
 * @author wtu.edit
 * @date 2015年10月20日
 * @version qq1.0
 * @email wtuickqmq@163.com
 */
public class RobotHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(RobotHelper.class);

	/**
	 * wtu.add 2015-10-12 检测房间人数，通知是否加入机器人
	 * 
	 * @param room
	 *            要加入的房间信息
	 * @param cc
	 *            在线人数
	 * @param maxcount
	 *            最大人数
	 * @param isRobot
	 *            是否是机器人
	 * @param rt
	 *            新老用户分组
	 */
	public static void CheckRoomToRobot(UserInRoom room, int cc, int maxcount, boolean isRobot, int rt, String gid,boolean isSitDown) {
		if (isRobot)
			return;
		int playercount = cc ;
		if (playercount ==0 || !isSitDown) {
			RobotRoomVo rrv = new RobotRoomVo(Definition.SENDROBOTROOM, Definition.SUCCESS_CODE, room, maxcount, playercount, rt, gid);
			LogicChannelUtil.sendToRobot(rrv);
			LOGGER.info("ready CheckRoomToRobot");
		} else {
			LOGGER.info("can Not CheckRoomToRobot");
		}

	}

}
