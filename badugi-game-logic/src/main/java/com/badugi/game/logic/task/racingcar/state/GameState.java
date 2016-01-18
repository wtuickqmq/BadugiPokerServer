package com.badugi.game.logic.task.racingcar.state;

import com.badugi.game.logic.task.racingcar.RacingCarGame;
import com.badugi.game.logic.task.racingcar.constants.GameStateName;



public abstract class GameState{

	private GameState nextGameState;
	
	private RacingCarGame carGame;

	public GameState(RacingCarGame carGame) {
		this.carGame=carGame;
	}

	public abstract void init();

	public void begin() {
		init();
	}

	// 状态结束
	public void end() {
		
	}

	public abstract GameStateName getGameStateName();

	public GameState getNextGameState(){
		return nextGameState;
	}

	public void setNextGameState(GameState nextGameState) {
		this.nextGameState = nextGameState;
	}
	
	

	
	/**
	 * @return carGame
	 */
	public RacingCarGame getCarGame() {
		return carGame;
	}

	
	// 清除每圈信息
	public void clear() {
		
	}

}
