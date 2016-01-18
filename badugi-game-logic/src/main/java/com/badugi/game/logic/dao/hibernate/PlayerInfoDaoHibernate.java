package com.badugi.game.logic.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.badugi.game.logic.dao.PlayerInfoDao;
import com.badugi.game.logic.model.entity2.PlayerInfo;

@Repository("playerInfoDao")
public class PlayerInfoDaoHibernate extends GenericDaoHibernate<PlayerInfo, Long> implements PlayerInfoDao {

	public PlayerInfoDaoHibernate() {
		super(PlayerInfo.class);
	}

	
}