package com.badugi.game.logic.dao.hibernate;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.badugi.game.logic.dao.UserFundDao;
import com.badugi.game.logic.model.entity.UserFund;

@Repository("userFundDao")
public class UserFundDaoHibernate extends GenericDaoHibernate<UserFund, Long> implements UserFundDao {

	public UserFundDaoHibernate() {
		super(UserFund.class);
	}

	public UserFund getUserFundById(Long fbId) {
		StringBuffer sql = new StringBuffer("SELECT u.u,u.fbName,uf.chips");
		sql.append(" FROM users u");
		sql.append(" INNER JOIN user_fund uf ON uf.fbid=u.FbId");
		sql.append(" WHERE u.FbId=" + fbId);
		// try(ResultSet rs = stmt.executeQuery(sql.toString())){
		try {
			List<Map<String, Object>> listMap = querySQLListWithMap(sql.toString());
			System.out.println(listMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Object[]> list = super.querySQLList(sql.toString());
		if (null != list && !list.isEmpty()) {
			Object[] item = list.get(0);
			com.badugi.game.logic.model.entity.UserFund uf = new com.badugi.game.logic.model.entity.UserFund();
			uf.setFbid((Long) item[0]);
			uf.setFbname((String) item[1]);
			uf.setChips((Double) item[2]);
			return uf;
		}
		return null;
	}

}