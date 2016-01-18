package com.badugi.game.logic.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.badugi.game.logic.dao.RacingCarLogDao;
import com.badugi.game.logic.model.entity.RacingCarLog;
import com.badugi.game.logic.util.IdGenerator;

@Repository("racingCarLogDao")
public class RacingCarLogDaoHibernate extends GenericDaoHibernate<RacingCarLog, String> implements RacingCarLogDao {

	public RacingCarLogDaoHibernate() {
		super(RacingCarLog.class);
	}
	
	
	/**
	 *  
	 * 小游戏操作日志
	 * @param fbid
	 * @return
	 * @throws Exception
	 */
	public List<RacingCarLog> getSupremeCarList(Long fbId) throws Exception {
		List<RacingCarLog> supermecarlogList = new ArrayList<RacingCarLog>();
		try {
			RacingCarLog supermecarlog = null;
			Date date = com.badugi.game.logic.model.utils.common.DateUtils.addDate(new Date(), 5, -15);
			String beginTime = com.badugi.game.logic.model.utils.common.DateUtils.getDateStr(date);

			StringBuffer sql = new StringBuffer(" SELECT sc_id,fbid,opertype,opercontent,operremark,opertime ");
			sql.append(" FROM racingcar_log ");
			sql.append(" where 1=1 and  opertime >'" + beginTime + " 00:00:00' and fbid=" + fbId);
			sql.append(" order by opertime desc  limit 15");

			List<Object[]> list = this.querySQLList(sql.toString());
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					Object[] o = null;
					o = (Object[]) list.get(i);
					supermecarlog = new RacingCarLog();
					supermecarlog.setScId(o[0] == null ? "" : o[0].toString());
					supermecarlog.setFbId(o[1] == null ? 0 : Long.parseLong(o[1].toString()));
					supermecarlog.setOperType(o[2] == null ? "" : o[2].toString());
					supermecarlog.setOperContent(o[3] == null ? "" : o[3].toString());
					supermecarlog.setOperRemark(o[4] == null ? "" : o[4].toString());
					supermecarlog.setOperTime(o[5] == null ? new Date() : (Date)o[5]);
					supermecarlogList.add(supermecarlog);
				}
			}
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		return supermecarlogList;
	}

	/**
	 * 
	 * 
	 * @param userId
	 * @param type
	 * @param name
	 * @param comments
	 *           
	 */
	public void saveSupremeCarLLog(Long fbId, String type, String content, String remark) {
		String sql = "insert into racingcar_log(sc_id,fbId,opertype,opercontent,operremark,opertime) values ('"+IdGenerator.getNextId()+"'," + fbId + ",'" + type + "','" + content + "','" + remark + "',NOW())";
//		DbUtils.exeSql(sql);
		this.execSQL(sql);
		//SupremeCarLog supremecarlog = new SupremeCarLog();
		//supremecarlog
		//sysMsgToUser.setComment(comments);
		//sysMsgToUser.setGtime(DateUtils.getDateStr_(new Date()));
		//sysMsgToUser.setId(0);
		//sysMsgToUser.setName("【" + name + "】");
		//Threadpool.executorOtherPool.execute(new DealwithSysMsgToUserThread(sysMsgToUser, userId));
	}
	
	
}
