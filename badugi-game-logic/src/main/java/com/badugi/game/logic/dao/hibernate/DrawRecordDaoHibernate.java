package com.badugi.game.logic.dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.badugi.game.logic.dao.DrawRecordDao;
import com.badugi.game.logic.dao.UsersDao;
import com.badugi.game.logic.model.entity.DrawRecord;
import com.badugi.game.logic.util.AppContext;

@Repository("drawRecordDao")
public class DrawRecordDaoHibernate extends GenericDaoHibernate<DrawRecord, String> implements DrawRecordDao {

	public DrawRecordDaoHibernate() {
		super(DrawRecord.class);
	}

	/**
	 * 
	 * @param fbId
	 * @return
	 */
	public List<String> readUserDraw() {
		List<String> records = new ArrayList<String>();
		// DrawRecord dr = new DrawRecord();
		try {
			String sql = " select * from (select dr.item_id,di.item_alias from draw_record dr left join draw_item di on dr.item_id = di.item_id order by dr.draw_time desc) dr limit 0,15 ";
			List<Map<String, Object>> list = super.querySQLListWithMap(sql);
//			String drawId = "";
			if (list != null && list.size() > 0) {

				for (Map<String, Object> beanMap : list) {
					if(beanMap.containsKey("item_alias")){
						String drawItem = beanMap.get("item_alias").toString();
						records.add(drawItem);
						
					}
				}
				return records;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param drawrecord
	 */
	public void addUserDraw(com.badugi.game.logic.model.entity.DrawRecord drawrecord) {
		String sql = "insert into draw_record(draw_id,item_id,draw_time,draw_racingcar) values('" + drawrecord.getDrawId() + "','" + drawrecord.getItemId() + "',now(),'"
				+ drawrecord.getDrawRacingcar() + "') ";
		AppContext.getBean(UsersDao.class).execSQL(sql);
		// saveAndFlush(drawrecord);
		//LOGGER.debug("affect :{}",affect);
	}

}
