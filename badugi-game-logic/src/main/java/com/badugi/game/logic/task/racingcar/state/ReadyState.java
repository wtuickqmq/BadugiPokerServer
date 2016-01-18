package com.badugi.game.logic.task.racingcar.state;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.dao.RacingCarInitDao;
import com.badugi.game.logic.model.cache.CarCache;
import com.badugi.game.logic.model.entity.RacingcarInit;
import com.badugi.game.logic.model.lobby.helper.GameCarHelper;
import com.badugi.game.logic.model.vo.robot.RobotVo;
import com.badugi.game.logic.model.vo.supreme.PlayerInfoInSupremeRoom;
import com.badugi.game.logic.model.vo.supreme.PrizeItem;
import com.badugi.game.logic.task.DealerThread;
import com.badugi.game.logic.task.RacingcarMainThread;
import com.badugi.game.logic.task.racingcar.RacingCarGame;
import com.badugi.game.logic.task.racingcar.constants.GameStateName;
import com.badugi.game.logic.util.AppContext;
import com.badugi.game.logic.util.IdGenerator;
import com.joker.game.common.constant.Definition;

public class ReadyState extends GameState {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReadyState.class);

	
	public ReadyState(RacingCarGame carGame) {
		super(carGame);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void init() {
		LOGGER.debug("游戏准备状态初始化【开始】");
		CarCache.STARTRACINGCAR = System.currentTimeMillis();
		
		CarCache.RACINGCARID = IdGenerator.getNextId();
		LOGGER.info("游戏初始ID[{}]",CarCache.RACINGCARID);
		CarCache.STARTRACINGCAR = System.currentTimeMillis();
		RacingcarInit racingcarinit = AppContext.getBean(RacingCarInitDao.class).initRobotData(); // CarCache.SYSTEMREWARDPOOL.get("systemRewardPool");//系统奖池筹码量
		CarCache.REWAREPOOL = racingcarinit.getSystemPoolInitChips();
//		System.out.println("------重新设置每局游戏开始-------");
		CarCache.SUPREMEROOMS.clear(); // 清空游戏房间信息
		CarCache.MINVWCHIPS.clear(); // 清空小大众押注筹码信息
		CarCache.MINVWCHIPSMAP.clear();// 清空小大众押注筹码
		CarCache.MINBMWCHIPS.clear();// 清空小大众押注筹码
		CarCache.MINBMWCHIPSMAP.clear();// 清空小宝马单门押注筹码构成及数量
		CarCache.MINBENZCHIPS.clear(); // 清空小奔驰押注筹码数
		CarCache.MINBENZCHIPSMAP.clear();// 清空小奔驰单门押注筹码构成及数量
		CarCache.MINPORSCHECHIPS.clear();// 清空小保时捷押注筹码数
		CarCache.MINPORSCHECHIPSMAP.clear();// 清空小宝时捷单门押注筹码构成及数量
		CarCache.BIGVWCHIPS.clear();// 清空大大众押注筹码数
		CarCache.BIGVWCHIPSMAP.clear();// 清空大大众单门押注筹码构成及数量
		CarCache.BIGBMWCHIPS.clear();// 清空大宝马押注筹码数
		CarCache.BIGBMWCHIPSMAP.clear();// 清空大宝马单门押注筹码构成及数量
		CarCache.BIGBENZCHIPS.clear();// 清空大奔驰押注筹码数
		CarCache.BIGBENZCHIPSMAP.clear();// 清空大奔驰单门押注筹码构成及数量
		CarCache.BIGPORSCHECHIPS.clear();// 清空大保时捷押注筹码数
		CarCache.BIGPORSCHECHIPSMAP.clear();// 清空大宝时捷单门押注筹码构成及数量
		// CarCache.CHIPSSET.values().clear(); //清空8个门类中每门的押注筹码量
		CarCache.CHIPSSET.put(PrizeItem.MINVW.getItem(), 0L);
		CarCache.CHIPSSET.put(PrizeItem.MINBMW.getItem(), 0L);
		CarCache.CHIPSSET.put(PrizeItem.MINBENZ.getItem(), 0L);
		CarCache.CHIPSSET.put(PrizeItem.MINPORSCHE.getItem(), 0L);
		CarCache.CHIPSSET.put(PrizeItem.BIGVW.getItem(), 0L);
		CarCache.CHIPSSET.put(PrizeItem.BIGBMW.getItem(), 0L);
		CarCache.CHIPSSET.put(PrizeItem.BIGBENZ.getItem(), 0L);
		CarCache.CHIPSSET.put(PrizeItem.BIGPORSCHE.getItem(), 0L);
		// 清空每个门类中每位玩家的押注额
		CarCache.BETKINDPERPLAYER.put(PrizeItem.MINVW.getItem(), new HashMap<Long, Long>());
		CarCache.BETKINDPERPLAYER.put(PrizeItem.MINBMW.getItem(), new HashMap<Long, Long>());
		CarCache.BETKINDPERPLAYER.put(PrizeItem.MINBENZ.getItem(), new HashMap<Long, Long>());
		CarCache.BETKINDPERPLAYER.put(PrizeItem.MINPORSCHE.getItem(), new HashMap<Long, Long>());
		CarCache.BETKINDPERPLAYER.put(PrizeItem.BIGVW.getItem(), new HashMap<Long, Long>());
		CarCache.BETKINDPERPLAYER.put(PrizeItem.BIGBMW.getItem(), new HashMap<Long, Long>());
		CarCache.BETKINDPERPLAYER.put(PrizeItem.BIGBENZ.getItem(), new HashMap<Long, Long>());
		CarCache.BETKINDPERPLAYER.put(PrizeItem.BIGPORSCHE.getItem(), new HashMap<Long, Long>());
		CarCache.BETKINDPERPLAYER.put(PrizeItem.SUMCHIPS.getItem(), new HashMap<Long, Long>());
		
		
		CarCache.EACHWINSUMCHIPS.put(PrizeItem.SUMCHIPS.getItem(), 0L);// 清空每局游戏闲家押注总量
		CarCache.WINPLAYERSINFO.clear(); // 清空当前局获胜赢闲家信息
		CarCache.WEALTHLIST.clear(); // 清空该局押中奖项的闲家信息

		CarCache.REMITTINFO.clear();// 清空该局所有闲家押注信息(包括押中奖者和未押中奖者)
		CarCache.BETFULLITEMS.clear();// 清空当前局中押注满的门类
		Definition.TIMEPOINTS.clear();
		CarCache.ROBOTSBETCHIPS = 0L;
		CarCache.BETCHIPSROBOTS.clear();// 清空每局押注机器人
		CarCache.BETROBOTCHIPS.put(PrizeItem.MINVW.getItem(), new HashMap<Long, Long>()); // 清空押注机器人下注明细<item,<fbId,chips>>
		CarCache.BETROBOTCHIPS.put(PrizeItem.MINBMW.getItem(), new HashMap<Long, Long>());
		CarCache.BETROBOTCHIPS.put(PrizeItem.MINBENZ.getItem(), new HashMap<Long, Long>());
		CarCache.BETROBOTCHIPS.put(PrizeItem.MINPORSCHE.getItem(), new HashMap<Long, Long>());
		CarCache.BETROBOTCHIPS.put(PrizeItem.BIGVW.getItem(), new HashMap<Long, Long>());
		CarCache.BETROBOTCHIPS.put(PrizeItem.BIGBMW.getItem(), new HashMap<Long, Long>());
		CarCache.BETROBOTCHIPS.put(PrizeItem.BIGBENZ.getItem(), new HashMap<Long, Long>());
		CarCache.BETROBOTCHIPS.put(PrizeItem.BIGPORSCHE.getItem(), new HashMap<Long, Long>());
		CarCache.BETROBOTCHIPS.put(PrizeItem.SUMCHIPS.getItem(), new HashMap<Long, Long>());
		
		CarCache.ROBOTCHIPS.put(PrizeItem.MINVW.getItem(), 0L);
		CarCache.ROBOTCHIPS.put(PrizeItem.MINBMW.getItem(), 0L);
		CarCache.ROBOTCHIPS.put(PrizeItem.MINBENZ.getItem(), 0L);
		CarCache.ROBOTCHIPS.put(PrizeItem.MINPORSCHE.getItem(), 0L);
		CarCache.ROBOTCHIPS.put(PrizeItem.BIGVW.getItem(), 0L);
		CarCache.ROBOTCHIPS.put(PrizeItem.BIGBMW.getItem(), 0L);
		CarCache.ROBOTCHIPS.put(PrizeItem.BIGBENZ.getItem(), 0L);
		CarCache.ROBOTCHIPS.put(PrizeItem.BIGPORSCHE.getItem(), 0L);
		;// 清空机器人的每门押注
		Definition.TIMEPOINTS.putAll(Definition.TIMEPOINTSBACKUP); // 重置30个下注时间点下注数
		CarCache.ROBOTBETSMAP.put(PrizeItem.MINVW.getItem(), new HashMap<Long, Long>()); // 重置系统押注筹码详细信息
		CarCache.ROBOTBETSMAP.put(PrizeItem.MINBMW.getItem(), new HashMap<Long, Long>());
		CarCache.ROBOTBETSMAP.put(PrizeItem.MINBENZ.getItem(), new HashMap<Long, Long>());
		CarCache.ROBOTBETSMAP.put(PrizeItem.MINPORSCHE.getItem(), new HashMap<Long, Long>());
		CarCache.ROBOTBETSMAP.put(PrizeItem.BIGVW.getItem(), new HashMap<Long, Long>());
		CarCache.ROBOTBETSMAP.put(PrizeItem.BIGBMW.getItem(), new HashMap<Long, Long>());
		CarCache.ROBOTBETSMAP.put(PrizeItem.BIGBENZ.getItem(), new HashMap<Long, Long>());
		CarCache.ROBOTBETSMAP.put(PrizeItem.BIGPORSCHE.getItem(), new HashMap<Long, Long>());

		new DealerThread().Start();

		
		CarCache.ROBOTINNING++;
		if (CarCache.ROBOTINNING > 3) {// 连续超过3局,重置局数设置,清空房间内所有玩家(包括机器人),(机器人每3局换一批)
			CarCache.PLAYER_INFO_IN_SUPREMEROOM.clear();
			CarCache.ROBOTINNING = 0;
		}
		PlayerInfoInSupremeRoom player = null;
		Enumeration<PlayerInfoInSupremeRoom> elements = CarCache.PLAYER_INFO_IN_SUPREMEROOM.elements();
		while (elements.hasMoreElements()) {// 若房间内有玩家(即在3局以内),则移除真实玩家,保留机器人
			player = elements.nextElement();
			if (!player.isRobot()) {
				CarCache.PLAYER_INFO_IN_SUPREMEROOM.remove(player.getFbId());
			}
		}
		Random rd = new Random();
		int random = -1;
		int playerSize = CarCache.PLAYER_INFO_IN_SUPREMEROOM.size();
		if (playerSize == 0) { // 若游戏房间有空,即连续超过3局,已清空房间,则重新生成机器人
			Integer size = CarCache.ROBOTSVO.size();
			List<RobotVo> list = new ArrayList<RobotVo>(CarCache.ROBOTSVO.values());
			Set<Integer> set = new HashSet<Integer>();
			RobotVo robot = null;
			do {
				do {
					random = rd.nextInt(size);
				} while (random < 0 || random >= size || set.contains(random));
				robot = list.get(random);
				if (robot != null && !CarCache.PLAYER_INFO_IN_SUPREMEROOM.containsKey(robot.getRobotFbId())) {
					CarCache.PLAYER_INFO_IN_SUPREMEROOM.put(robot.getRobotFbId(),
							new PlayerInfoInSupremeRoom(robot.getRobotFbId(), robot.getNickName(), true, robot.getImageUrl(), robot.getChips()));
					set.add(random);
				}
			} while (CarCache.PLAYER_INFO_IN_SUPREMEROOM.size() < 20);
		}
		Collection<PlayerInfoInSupremeRoom> betplayers = CarCache.PLAYER_INFO_IN_SUPREMEROOM.values();
		PlayerInfoInSupremeRoom[] playersArray = new PlayerInfoInSupremeRoom[6];// 取游戏房间内的6个机器人为下注者
		PlayerInfoInSupremeRoom plsr = null;
		playersArray = betplayers.toArray(playersArray);
		do {
			random = rd.nextInt(betplayers.size());
			plsr = playersArray[random];
			CarCache.BETCHIPSROBOTS.put(plsr.getFbId(), plsr);
		} while (CarCache.BETCHIPSROBOTS.size() <= 6);
		
		Long[] fbIds = new Long[CarCache.BETCHIPSROBOTS.size()];
		final Long[] fbIdArray = CarCache.BETCHIPSROBOTS.keySet().toArray(fbIds);// 押注者FbId
	
        //wtu.add
		GameCarHelper.InitItem();
		LOGGER.debug("游戏准备状态初始化【结束】");
	}

	public void begin() {
		init();
		this.getCarGame().turnNextState(this.getNextGameState());
	}

	public GameStateName getGameStateName() {
		return GameStateName.Ready;
	}


	@Override
	public void clear() {
	}
	
}
