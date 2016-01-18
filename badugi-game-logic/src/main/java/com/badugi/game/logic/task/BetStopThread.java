package com.badugi.game.logic.task;

import com.badugi.game.logic.model.vo.supreme.StopBetVo;
import com.badugi.game.logic.service.GameCarService;
import com.badugi.game.logic.util.AppContext;
import com.joker.game.common.constant.EventDefinition;

public class BetStopThread  {


	public void run() {
		StopBetVo obj = new StopBetVo(EventDefinition.EVENT_STOP_BET); // "{\"cmd\":\""+
																		// EventDefinition.EVENT_STOP_BET+"\"}";
		AppContext.getBean(GameCarService.class).sendToAll(obj);
	}

	public void start(){
		this.run();
	}
}
