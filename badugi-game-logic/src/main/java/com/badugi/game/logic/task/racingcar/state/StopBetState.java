package com.badugi.game.logic.task.racingcar.state;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.task.BetStopThread;
import com.badugi.game.logic.task.SettleAccountThread;
import com.badugi.game.logic.task.racingcar.RacingCarGame;
import com.badugi.game.logic.task.racingcar.constants.GameStateName;

public class StopBetState extends GameState {

	private static final Logger LOGGER = LoggerFactory.getLogger(StartState.class);


	public StopBetState(RacingCarGame carGame) {
		super(carGame);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void init() {
		

	}

	public void begin() {
		LOGGER.debug("停止下注状态【开始】");
		new BetStopThread().start();
		LOGGER.debug("-------BetStopThread停止接收筹码,开始跑灯--------");
		new SettleAccountThread().start();
		LOGGER.debug("停止下注状态【结束】");
		try {
			Thread.sleep(14*1000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		this.getCarGame().turnNextState(getNextGameState());
	}
	

	public GameStateName getGameStateName() {
		return GameStateName.StopBet;
	}


	@Override
	public void clear() {
	}
	
}
