package com.badugi.game.logic.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.badugi.game.logic.dao.RacingCarWinLogDao;
import com.badugi.game.logic.model.entity.RacingCarWinLog;

@Repository("racingCarWinLogDao")
public class RacingCarWinLogDaoHibnate extends GenericDaoHibernate<RacingCarWinLog, Long> implements RacingCarWinLogDao {

	public RacingCarWinLogDaoHibnate() {
		super(RacingCarWinLog.class);
	}

}
