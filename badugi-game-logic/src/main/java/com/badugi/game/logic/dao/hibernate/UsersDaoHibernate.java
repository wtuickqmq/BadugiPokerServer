package com.badugi.game.logic.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.badugi.game.logic.dao.UsersDao;
import com.badugi.game.logic.model.entity.Users;

@Repository("usersDao")
public class UsersDaoHibernate extends GenericDaoHibernate<Users, Long> implements UsersDao {

	public UsersDaoHibernate() {
		super(Users.class);
	}

	
}