package com.badugi.game.logic.dao;

import com.badugi.game.logic.model.entity.RacingPool;


public interface RacingCarPoolsDao extends GenericDao<RacingPool, String> {

	void saveRacingPools(RacingPool racingPool);

}
