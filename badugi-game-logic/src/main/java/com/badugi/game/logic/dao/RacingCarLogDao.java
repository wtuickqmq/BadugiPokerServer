package com.badugi.game.logic.dao;

import java.util.List;

import com.badugi.game.logic.model.entity.RacingCarLog;


public interface RacingCarLogDao extends GenericDao<RacingCarLog, String>{

	 List<RacingCarLog> getSupremeCarList(Long fbId) throws Exception;
	 
	 void saveSupremeCarLLog(Long fbId, String type, String content, String remark);
}
