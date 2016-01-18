package com.badugi.game.logic.dao.hibernate;

import io.nadron.client.util.ObjectBeanUtil;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.badugi.game.logic.dao.RacingCarInitDao;
import com.badugi.game.logic.model.entity.RacingcarInit;

@Repository("racingCarInitDao")
public class RacingCarInitDaoHibernate extends GenericDaoHibernate<RacingcarInit, Long> implements RacingCarInitDao {

	public RacingCarInitDaoHibernate() {
		super(RacingcarInit.class);
	}

	/**
	 * 
	 * @param fbId
	 * @return
	 */
	public RacingcarInit initRobotData() {
		RacingcarInit sic = new RacingcarInit();
		// String hql = "from deposit where u_id = :fbId";
		// String sql = "select * from racingcar_init  ";
		try {
			List<RacingcarInit> list = this.getAll();
			if (!list.isEmpty()) {
				sic = list.get(0);
				return sic;
			} else {
				String sql = "select * from racingcar_init  ";
				List<Map<String, Object>> tlist = this.querySQLListWithMap(sql);
				//list = this.querySQLList2(sql, RacingcarInit.class);
				if(!tlist.isEmpty()){
					//[{racingcar_id=1, robot_init_chips=10000000, racingcar_init_id=1, systempool_init_chips=17435102}]
					Map<String, Object> item=tlist.get(0);
					sic.setRacingcarId(Long.valueOf(item.get("racingcar_id").toString()));
					sic.setRobotInitChips(Long.valueOf(item.get("robot_init_chips").toString()));
					sic.setRacingcarInitId(Long.valueOf(item.get("racingcar_init_id").toString()));
					sic.setSystemPoolInitChips(Long.valueOf(item.get("systempool_init_chips").toString()));
					
					
					return sic;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 重置系统机器人信息
	 */
	public void resetRacingRobotChips() {
		String sql = "update racingcar_init set robot_init_chips = " + 1e4;
		this.execSQL(sql);
	}

	/**
	 * 重置系统奖池初始化信息
	 * 
	 * @param
	 */
	public void resetRacingSystemPool() {
		String sql = "";
		/*
		 * if(sic.getSystemPoolInitChips() != null &&
		 * !sic.getSystemPoolInitChips().equals("") && sic.getRobotInitChips()
		 * != null && !sic.getRobotInitChips().equals("")){ sql =
		 * "update racingcar_init set systempool_init_chips = "
		 * +5e6+" , robot_init_chips = "+1e4; }
		 */
		sql = "update racingcar_init set systempool_init_chips = " + 5e6;
		this.execSQL(sql);
	}

	/**
	 * 更新机器人筹码值
	 * 
	 * @param sic
	 */
	public void updateRacing(RacingcarInit sic) {
		String sql = "";
		if (sic.getSystemPoolInitChips() != null && !sic.getSystemPoolInitChips().equals("") && sic.getRobotInitChips() != null && !sic.getRobotInitChips().equals("")) {
			sql = "update racingcar_init set systempool_init_chips = systempool_init_chips+" + sic.getSystemPoolInitChips().longValue() + " , robot_init_chips = robot_init_chips+"
					+ sic.getRobotInitChips().longValue();
		}
		if (sic.getSystemPoolInitChips() != null && !sic.getSystemPoolInitChips().equals("")) {
			sql = "update racingcar_init set systempool_init_chips = systempool_init_chips+" + sic.getSystemPoolInitChips().longValue();
		}
		if (sic.getRobotInitChips() != null && !sic.getRobotInitChips().equals("")) {
			sql = "update racingcar_init set robot_init_chips = robot_init_chips+" + sic.getRobotInitChips().longValue();
		}
		System.out.println("更新系统筹码信息:" + sql.toString());
		this.execSQL(sql);
	}

}
