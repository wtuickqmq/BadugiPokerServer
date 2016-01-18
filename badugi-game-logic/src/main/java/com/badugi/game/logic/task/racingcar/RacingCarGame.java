package com.badugi.game.logic.task.racingcar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.dao.RacingCarInitDao;
import com.badugi.game.logic.model.cache.CarCache;
import com.badugi.game.logic.model.entity.RacingcarInit;
import com.badugi.game.logic.model.lobby.helper.GameCarHelper;
import com.badugi.game.logic.model.vo.robot.RobotVo;
import com.badugi.game.logic.model.vo.supreme.PlayerInfoInSupremeRoom;
import com.badugi.game.logic.model.vo.supreme.PrizeItem;
import com.badugi.game.logic.task.racingcar.constants.GameStateName;
import com.badugi.game.logic.task.racingcar.state.GameState;
import com.badugi.game.logic.task.racingcar.state.ReadyState;
import com.badugi.game.logic.task.racingcar.state.StartState;
import com.badugi.game.logic.task.racingcar.state.StopBetState;
import com.badugi.game.logic.util.AppContext;
import com.badugi.game.logic.util.IdGenerator;
import com.joker.game.common.constant.Definition;

/**
 * 小游戏主程序
 * @author wtu.edit
 * @date 2015年12月11日
 * @version qq1.0
 * @email wtuickqmq@163.com
 */
public class RacingCarGame {
	private static final Logger LOGGER = LoggerFactory.getLogger(RacingCarGame.class);
	

	private static RacingCarGame ins;
	
	private Map<GameStateName , GameState> gameStateMap = new HashMap<GameStateName, GameState>();

	public RacingCarGame() {
		// TODO 自动生成的构造函数存根
		initGame();
	}
	
    /**
     * 
     * 创建小游戏单例模式
	 * @return ins
	 */
	public static synchronized final RacingCarGame getIns() {
		if(ins==null)
		{
			ins=new RacingCarGame();
		}
		return ins;
	}

	

/**
 * 初始化游戏
 */
	public void initGame()
	{
		LOGGER.debug("初始化小游戏状态");
		
		GameState readyState = new ReadyState(this);
		GameState startState = new StartState(this);
		GameState stopBetState = new StopBetState(this);
		readyState.setNextGameState(startState);
		startState.setNextGameState(stopBetState);
		stopBetState.setNextGameState(readyState);
		gameStateMap.put(readyState.getGameStateName(), readyState);
		gameStateMap.put(startState.getGameStateName(), startState);
		gameStateMap.put(stopBetState.getGameStateName(), stopBetState);
		
		readyState.begin();
		
	}
	/**
	 * 切换到下一游戏状态
	 * @param nextGameState
	 */
	public void turnNextState(GameState nextGameState) {
		LOGGER.debug("切换下一游戏状态【{}】",nextGameState.getGameStateName());
		nextGameState.begin();
	}
	
	/**
	 * @return gameStateMap
	 */
	public Map<GameStateName, GameState> getGameStateMap() {
		return gameStateMap;
	}

	/**
	 * @param gameStateMap 要设置的 gameStateMap
	 */
	public void setGameStateMap(Map<GameStateName, GameState> gameStateMap) {
		this.gameStateMap = gameStateMap;
	}



}
