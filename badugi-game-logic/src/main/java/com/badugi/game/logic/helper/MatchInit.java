package com.badugi.game.logic.helper;

import java.util.List;

import com.badugi.game.logic.model.cache.CarCache;
import com.badugi.game.logic.model.vo.robot.RobotVo;

/**
 * @copyright：
 * @author:
 * @email:
 * @createTime:
 * @description：比赛初始化
 */
public class MatchInit {

	/**
	 * 启动极品飞车游戏中机器人初始筹码配置
	 */
	public static void initRacingCarRobots() {
		CarCache.ROBOTSVO.clear();// 清空缓存中机器人
		List<RobotVo> robots = LobbyUserHelper.loadAllRobots();
		for (RobotVo robot : robots) {
			CarCache.ROBOTSVO.putIfAbsent(robot.getRobotFbId(), robot);
		}
	}

}
