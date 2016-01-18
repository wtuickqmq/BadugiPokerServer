package com.badugi.game.logic.helper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.dao.UsersDao;
import com.badugi.game.logic.model.entity.Notices;
import com.badugi.game.logic.model.utils.common.DateUtils;
import com.badugi.game.logic.util.AppContext;

public class LobbyMsgHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(LobbyMsgHelper.class);

	/**
	 * 获取最后一条公告
	 */
	public static Notices getLastNotice() {
		Notices notices = null;
		try {
			StringBuffer sql = new StringBuffer("SELECT Content,BeginTime,EndTime,ManagerName,OperatedTime FROM notices ORDER BY EndTime DESC LIMIT 1");

			List<Map<String, Object>> list = AppContext.getBean(UsersDao.class).querySQLListWithMap(sql.toString());

			if (!list.isEmpty()) {
				Map<String, Object> map = list.get(0);
				Object Content = map.get("Content");
				Object BeginTime = map.get("BeginTime");
				Object EndTime = map.get("EndTime");
				Object ManagerName = map.get("ManagerName");
				Object OperatedTime = map.get("OperatedTime");
				notices = new Notices();
				notices.setContent(null != Content ? Content.toString() : null);
				notices.setBeginTime(null != BeginTime ? new Timestamp(DateUtils.StringToDate(BeginTime.toString()).getTime()) : null);
				notices.setEndTime(null != EndTime ? new Timestamp(DateUtils.StringToDate(EndTime.toString()).getTime()) : null);
				notices.setManagerName(null != ManagerName ? ManagerName.toString() : null);
				notices.setOperatedTime(null != OperatedTime ? new Timestamp(DateUtils.StringToDate(OperatedTime.toString()).getTime()) : null);
			}
			// while(rs.next()){
			// notices = new Notices(rs.getString(1), rs.getTimestamp(2),
			// rs.getTimestamp(3),
			// rs.getString(4), rs.getTimestamp(5));
			// }
		} catch (Exception e) {
			LOGGER.error("", e);
			e.printStackTrace();
		} finally {
		}
		return notices;
	}

}
