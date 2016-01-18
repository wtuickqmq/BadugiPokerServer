package com.badugi.game.logic.dao;

import com.badugi.game.logic.model.entity.RacingcarInit;

public interface RacingCarInitDao extends GenericDao<RacingcarInit, Long> {

	RacingcarInit initRobotData();

	void resetRacingRobotChips();

	void resetRacingSystemPool();

	void updateRacing(RacingcarInit sic);
}
