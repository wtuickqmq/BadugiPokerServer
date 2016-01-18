package com.badugi.game.logic.dao.hibernate;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.badugi.game.logic.dao.UserFund1Dao;
import com.badugi.game.logic.model.entity.UserFund1;

@Repository("userFund1Dao")
public class UserFund1DaoHibernate extends GenericDaoHibernate<UserFund1, Long> implements UserFund1Dao {

	public UserFund1DaoHibernate() {
		super(UserFund1.class);
	}

	public UserFund1 getUserFundById(Long fbId) {
		StringBuffer sql = new StringBuffer("SELECT u.FbId,u.FbName,uf.chips,uf.ExpValue,uf.CurrVipValue,uf.VipPoints,uf.VipLevel,");
		sql.append("u.IsRobot,u.LoginDays,uf.praiseNum,uf.MasterValue,uf.GoldValue,u.RegTime,u.city,u.Sex,uf.roundmaxchips");
		sql.append(" FROM users u");
		sql.append(" INNER JOIN user_fund1 uf ON uf.fbid=u.FbId");
		sql.append(" WHERE u.FbId=" + fbId);
		// try(ResultSet rs = stmt.executeQuery(sql.toString())){
		try {
			List<Map<String, Object>> listMap = querySQLListWithMap(sql.toString());
			if(!listMap.isEmpty()){
				Map<String, Object> result = listMap.get(0);
//				Long fbId = Long.valueOf(result.get("FbId").toString());
				String FbName = result.get("FbName").toString();
				Double chips = Double.valueOf(result.get("chips").toString());
				com.badugi.game.logic.model.entity.UserFund1 uf = new com.badugi.game.logic.model.entity.UserFund1();
				uf.setFbId(fbId);
				uf.setFbName(FbName);
				uf.setChips(chips);
				return uf;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		List<Object[]> list = super.querySQLList(sql.toString());
//		if (null != list && !list.isEmpty()) {
//			Object[] item = list.get(0);
//			com.joker.game.logic.model.entity.UserFund1 uf = new com.joker.game.logic.model.entity.UserFund1();
//			uf.setFbId((Long) item[0]);
//			uf.setFbName((String) item[1]);
//			uf.setChips((Double) item[2]);
//			return uf;
//		}
		return null;
	}

}