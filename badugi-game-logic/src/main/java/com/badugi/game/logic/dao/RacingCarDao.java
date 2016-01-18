package com.badugi.game.logic.dao;

import com.badugi.game.logic.model.entity.RacingCar;
import com.badugi.game.logic.model.entity.RacingPool;

public interface RacingCarDao extends GenericDao<RacingCar, String> {

	void saveRacingCar(RacingCar racingcar) ;
	
}
