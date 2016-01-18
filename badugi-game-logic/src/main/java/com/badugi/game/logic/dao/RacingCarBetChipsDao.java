package com.badugi.game.logic.dao;

import com.badugi.game.logic.model.entity.RacingcarBetChips;


public interface RacingCarBetChipsDao extends GenericDao<RacingcarBetChips, String>{

	@Override
	public RacingcarBetChips save(RacingcarBetChips object);
	
	void saveRacingcarBetChips(RacingcarBetChips racingcarbetchips);
}
