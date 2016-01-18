package com.badugi.game.logic.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.badugi.game.logic.dao.RacingCarDealerDao;
import com.badugi.game.logic.model.entity.RacingcarDealer;

@Repository("racingCarDealerDao")
public class RacingCarDealerDaoHibernate extends GenericDaoHibernate<RacingcarDealer, String> implements RacingCarDealerDao {


	public RacingCarDealerDaoHibernate() {
		super(RacingcarDealer.class);
	}

	/**
	 * 保存游戏庄家信息
	 * 
	 * @param racingcar
	 */
	public void saveRacingCarDealer(RacingcarDealer racingcardealer) {
		String sql = "insert into racingcar_dealer(racing_dealer_id,dealer_id,updealer_chips,racingcar_id,dealer_time) values ('" + racingcardealer.getRacingDealerId() + "',"
				+ racingcardealer.getDealerId() + "," + racingcardealer.getUpdealerChips() + ",'" + racingcardealer.getRacingcarId() + "',now())";
		// DbUtils.exeSql(sql);
		this.execSQL(sql);
	}

}
