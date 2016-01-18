package com.badugi.game.logic.dao.hibernate;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.badugi.game.logic.dao.RacingCarBetChipsDao;
import com.badugi.game.logic.model.entity.RacingcarBetChips;

@Repository("racingcarBetChipsDao")
public class RacingCarBetChipsDaoHibernate extends GenericDaoHibernate<RacingcarBetChips, String> implements RacingCarBetChipsDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(RacingCarBetChipsDaoHibernate.class);
	
	public RacingCarBetChipsDaoHibernate() {
		super(RacingcarBetChips.class);
	}
	
	
	
	/**
	 * 保存玩家押注信息
	 * @param racingcar
	 */
	public  void saveRacingcarBetChips(RacingcarBetChips racingcarbetchips) {
		LOGGER.trace("***********小游戏押注日志***********BetChipId=" + racingcarbetchips.getBetChipId() + ";chip=" + racingcarbetchips.getChip() + ";RacingcarIdRacingcarId=" + racingcarbetchips.getRacingcarId() + ";dealerId=" + racingcarbetchips.getDealerId()+";time="+new Date());
		String sql = "insert into racingcar_betchips(chip,chip_player,chip_time,racingcar_id,dealer_id,item_id) values ("+racingcarbetchips.getChip() + "," + racingcarbetchips.getChipPlayer()+",now(),'" + racingcarbetchips.getRacingcarId()+ "'," + racingcarbetchips.getDealerId()+ ",'"+racingcarbetchips.getItemId()+"'"+")";
		this.execSQL(sql);
		LOGGER.trace("=========================sql" + sql);
	}
	
}
