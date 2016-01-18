package com.badugi.game.logic.dao;

import java.util.List;

import com.badugi.game.logic.model.entity.DrawRecord;

public interface DrawRecordDao extends GenericDao<DrawRecord, String>{

	List<String> readUserDraw();
	
	void addUserDraw(com.badugi.game.logic.model.entity.DrawRecord drawrecord);
}
