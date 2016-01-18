package com.badugi.game.logic.dao.hibernate;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.badugi.game.logic.dao.RacingCarDao;
import com.badugi.game.logic.model.entity.RacingCar;
import com.badugi.game.logic.model.entity.RacingPool;

@Repository("racingCarDao")
public class RacingCarDaoHibernate extends GenericDaoHibernate<RacingCar, String> implements RacingCarDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(RacingCarDaoHibernate.class);

	public RacingCarDaoHibernate() {
		super(RacingCar.class);
	}

	/**
	 * 保存游戏信息
	 * 
	 * @param racingcar
	 */
	public void saveRacingCar(RacingCar racingcar) {
		LOGGER.info("***********小游戏日志***********RacingcarId=" + racingcar.toString()+ ";time=" + new Date());
		String sql = "insert into racing_car(racingcar_id,launch_time,dealer_id,player_counts,dealer_win_chips,draw_id,systempool_chips,sum_chips,robot_chips,playerWin,robotWin,dealerCommission) values ('" + racingcar.getRacingcarId()
				+ "','" + racingcar.getLaunchTime() + "'," + racingcar.getDealerId() + "," + racingcar.getPlayerCounts() + "," + racingcar.getDealerWinChips() + ",'" + racingcar.getDrawId() + "',"
				+ racingcar.getSystemPoolChips() + "," + racingcar.getSumChips() + "," + racingcar.getRobotChips() +","+racingcar.getPlayerWin()+","+racingcar.getRobotWin()+ ","+racingcar.getDealerCommission()+")";
		try {
			this.execSQL(sql);
		} catch (Exception e) {
			LOGGER.error("sql-->", sql);
			LOGGER.error("", e);
		}
		LOGGER.info("=========================sql" + sql);
	}
	
	

}
