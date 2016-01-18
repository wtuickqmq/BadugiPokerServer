package com.badugi.game.logic.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.badugi.game.logic.dao.GameUserlogDao;
import com.badugi.game.logic.model.entity.GameUserlog;


@Repository("gameUserlogDao")
public class GameUserlogDaoHibernate extends GenericDaoHibernate<GameUserlog, Long> implements GameUserlogDao {

	public GameUserlogDaoHibernate() {
		super(GameUserlog.class);
	}

	
}