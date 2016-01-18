package com.badugi.game.logic.helper;

import io.nadron.client.util.ObjectBeanUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;

import com.badugi.game.logic.dao.UsersDao;
import com.badugi.game.logic.model.domain.vo.flash.user.ExpLevelConfigVo;
import com.badugi.game.logic.util.AppContext;

import org.slf4j.Logger;

public class ExpHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExpHelper.class);

	/* 经验值 等级 */
	private static List<ExpLevelConfigVo> expList;

	static {

		// initExp();
	}

	public static void initExp() {
		if (expList == null) {
			try {
				expList = initExpDate();
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		}
	}

	private static List<ExpLevelConfigVo> initExpDate() {
		String sql = "SELECT level,value,totalvalue,chips from exp_config";
		List<ExpLevelConfigVo> rlist = new ArrayList<ExpLevelConfigVo>();
		List<Map<String, Object>> rs = AppContext.getBean(UsersDao.class).querySQLListWithMap(sql.toString());

		Iterator<Map<String, Object>> itr = rs.iterator();
		while (itr.hasNext()) {
			ExpLevelConfigVo item = ObjectBeanUtil.JACKSON.convertValue(itr.next(), ExpLevelConfigVo.class);
			if (item != null)
				rlist.add(item);
		}
		return rlist;

	}

	/**
	 * 得到经验值所在的等级
	 */
	public static int getExpLvBy(int expValue) {

		if (expValue <= 0)
			return 1;
		if (expList == null)
			return 1;
		for (ExpLevelConfigVo ec : expList) {

			if (ec.getTotalvalue() <= expValue)
				continue;

			return (short) (ec.getLevel() - 1);
		}
		return expList.get(expList.size() - 1).getLevel();
	}

	/**
	 * 根据用户经验值得到对应的等级信息
	 */
	public static ExpLevelConfigVo getExpConfigBy(int expValue) {

		int size = expList.size();
		for (int i = 0; i < size; i++) {

			ExpLevelConfigVo ec = expList.get(i);
			if (ec.getTotalvalue() <= expValue)
				continue;

			return expList.get(i - 1);
		}
		return expList.get(size - 1);
	}

	/**
	 * 根据经验值等级得到下一级所经验值配置 如果没有下一级 返回空
	 */
	public static ExpLevelConfigVo getNextExpConfigBy(int expLevel) {

		int size = expList.size();

		/* 提前返回 防止下标越界 */
		int maxLevel = expList.get(size - 1).getLevel();
		if (expLevel >= maxLevel)
			return null;

		for (int i = 0; i < size; i++) {

			ExpLevelConfigVo ec = expList.get(i);
			if (expLevel == ec.getLevel())
				return expList.get(i + 1);
		}
		return null;
	}

}
