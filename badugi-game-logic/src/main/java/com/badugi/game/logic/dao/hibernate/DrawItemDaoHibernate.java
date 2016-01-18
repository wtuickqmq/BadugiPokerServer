package com.badugi.game.logic.dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.badugi.game.logic.dao.DrawItemDao;
import com.badugi.game.logic.model.entity.DrawItem;
import com.badugi.game.logic.model.lobby.helper.GameCarHelper;

@Repository("drawItemDao")
public class DrawItemDaoHibernate extends GenericDaoHibernate<DrawItem, String> implements DrawItemDao {

	public DrawItemDaoHibernate() {
		super(DrawItem.class);
	}

	public String findItemId(String item) {
		/*
		String sql = "select item_id	from draw_item where item_alias = '" + item + "'";
		List<Map<String, Object>> list = this.querySQLListWithMap(sql);
		if (list.isEmpty()) {
			return null;
		}
		Map<String, Object> map = list.get(0);

		if (map.containsKey("item_id")) {
			return map.get("item_id").toString();
		}*/
		
		return String.valueOf(GameCarHelper.getItemSort(item));
	}

	/**
	 * 读取奖项信息
	 * 
	 * @param racingcar
	 */
	public List<DrawItem> ListDrawItem() {
		List<DrawItem> drawItems = new ArrayList<DrawItem>();
		String sql = " select * from draw_item ";
		List<Map<String, Object>> list = querySQLListWithMap(sql);
		if (list != null && list.size() > 0) {

			for (Map<String, Object> map : list) {
				DrawItem item = new DrawItem();
				item.setItemId(map.get("item_id").toString());
				item.setItem(map.get("item").toString());
				item.setItemAlias(map.get("item_alias").toString());
				drawItems.add(item);
			}
		}
		return drawItems;
	}
}
