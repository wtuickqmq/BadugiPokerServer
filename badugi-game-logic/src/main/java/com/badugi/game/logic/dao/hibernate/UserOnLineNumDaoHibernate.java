package com.badugi.game.logic.dao.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.badugi.game.logic.dao.UserOnLineNumDao;
import com.badugi.game.logic.model.entity.UserOnLineNum;

@Repository("UserOnLineNumDao")
public class UserOnLineNumDaoHibernate extends GenericGMDaoHibernate<UserOnLineNum, Integer> implements UserOnLineNumDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserOnLineNumDaoHibernate.class);
	
	public UserOnLineNumDaoHibernate() {
		super(UserOnLineNum.class);
	}

	public void addUserOnLineNum(com.badugi.game.logic.model.entity.UserOnLineNum onlineNum) {
		String sql = "insert into user_online_num(id,time,num) values('" + onlineNum.getCreate_time() + "','" + onlineNum.getNum() + "') ";
		this.execSQL(sql);
		
		LOGGER.trace("=========================sql" + sql);
	}
}
