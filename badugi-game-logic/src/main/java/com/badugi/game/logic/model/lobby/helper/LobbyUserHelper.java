package com.badugi.game.logic.model.lobby.helper;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.dao.UserFundDao;
import com.badugi.game.logic.util.AppContext;


public class LobbyUserHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(LobbyUserHelper.class);
	
	
	/**
	 * 修改用户的账上数据
	 * get_gold_log和get_master_log记录自己保存
	 */
	public static void updateUserFund(Long fbid, Integer g, Integer m, Integer chips) {
		try {
			Double c = 0D;
			if (chips != null) {
				c = Double.valueOf(chips);
			}
			updateUserFund(fbid, g, m, c, "updateUserFund");
		}
		catch (Exception e) {
			LOGGER.error("updateUserFund error:" + e.getMessage(), e);
		}
	}
	
	public static void updateUserFund(Long fbid, Double chips) {
		try {
			Double c = 0D;
			if (chips != null) {
				c =  chips ;
			}
			updateUserFund(fbid, null,	null, c, "updateUserFund更新用户筹码");
		}
		catch (Exception e) {
			LOGGER.error("updateUserFund error:" + e.getMessage(), e);
		}
	}
	
	
	/**
	 * 修改用户的账上数据
	 * get_gold_log和get_master_log记录自己保存
	 */
	public static void updateUserFund(Long fbid, Integer g, Integer m, Double chips, String com) {
		try {
			StringBuffer sql = new StringBuffer();
			if (g != null && g != 0) {
				if (StringUtils.isNotEmpty(sql.toString())) {
					sql.append(",");
				}
				sql.append("GoldValue=GoldValue+" + g);
			}
			if (m != null && m != 0) {
				if (StringUtils.isNotEmpty(sql.toString())) {
					sql.append(",");
				}
				sql.append("MasterValue=MasterValue+" + m);
			}
			if (chips != null && chips != 0) {
				if (StringUtils.isNotEmpty(sql.toString())) {
					sql.append(",");
				}
				sql.append("Chips=Chips+" + chips);
			}
			if (StringUtils.isNotEmpty(sql.toString()) && chips != null) {
				String updateSql = " UPDATE user_fund SET " + sql.toString() + " WHERE FbId=" + fbid;
//				DbUtils.exeSql(updateSql);
				AppContext.getBean(UserFundDao.class).execSQL(updateSql);
				// 筹码变动通知大厅
//				LobbyUserHelper.sendLobbyUserFundChangeInfo(fbid, chips, LobbyParamCache.CURRENCY_TYPE[2], true,com);
				
			}
		}

		catch (Exception e) {
			LOGGER.error("updateUserFund error:" + e.getMessage(), e);
		}
	}
}
