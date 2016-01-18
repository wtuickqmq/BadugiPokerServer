package com.badugi.game.logic.dao.hibernate;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.badugi.game.logic.dao.RacingCarPoolsDao;
import com.badugi.game.logic.model.entity.RacingPool;


/**
 * @author wtu.edit
 * @date 2015年12月2日
 * @version qq1.0
 * @email wtuickqmq@163.com
 */
@Repository("racingCarPoolsDao")
public class RacingCarPoolsDaoHibernate extends GenericDaoHibernate<RacingPool, String> implements RacingCarPoolsDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(RacingCarPoolsDaoHibernate.class);

	public RacingCarPoolsDaoHibernate() {
		super(RacingPool.class);
	}

	/**
	 * 保存系统奖池数据
	 * 
	 */
	@Override
	public void saveRacingPools(RacingPool racingPool) {
		// TODO 自动生成的方法存根
		String sql = "insert into racing_pool( rid,u_id,dIsRobot,dwinchips,fwinchips,chips,old_pool_chips,"
				+ "dpump,fpump,pool_pump,create_time) "
				+ "values ('" + racingPool.getRid()+ "'," + racingPool.getUId() + "," 
				+ racingPool.getDisRobot() + "," + racingPool.getDwinchips() + ","
			    + racingPool.getFwinchips() + "," + racingPool.getChips() + "," 
				+ racingPool.getOldPoolChips() + "," + racingPool.getDpump() + ","
				+ racingPool.getFpump() + "," + racingPool.getPoolPump() + ",NOW())";
		//String sql="insert into racing_pool(rid) values ('sjdfksjfslkdfj')";
		try {
			this.execSQL(sql);
		} catch (Exception e) {
			LOGGER.error("sql-->", sql);
			//LOGGER.error("", e);
		}
	}

}
