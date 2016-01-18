package com.badugi.game.logic.dao;

import com.badugi.game.logic.model.entity.RacingcarDealer;

public interface RacingCarDealerDao extends GenericDao<RacingcarDealer, String> {

	
	void saveRacingCarDealer(RacingcarDealer racingcardealer);;
}
