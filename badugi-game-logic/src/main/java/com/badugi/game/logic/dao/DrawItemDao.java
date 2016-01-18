package com.badugi.game.logic.dao;

import java.util.List;

import com.badugi.game.logic.model.entity.DrawItem;

public interface DrawItemDao extends GenericDao<DrawItem, String>{
	
	String findItemId(String item);
	
	List<DrawItem> ListDrawItem();
	
}
