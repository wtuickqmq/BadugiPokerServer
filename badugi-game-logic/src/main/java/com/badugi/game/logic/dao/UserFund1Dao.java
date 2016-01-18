package com.badugi.game.logic.dao;

import com.badugi.game.logic.model.entity.UserFund1;

public interface UserFund1Dao extends GenericDao<UserFund1, Long> {

	UserFund1 getUserFundById(Long fbId);
}
