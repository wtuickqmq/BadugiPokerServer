package com.badugi.game.logic.model.lobby.helper;

import io.nadron.client.util.ObjectBeanUtil;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.badugi.game.logic.model.cache.LobbyParamCache;
import com.badugi.game.logic.model.utils.common.BeanUtils;
import com.badugi.game.logic.model.vo.api.ApiResultVo;
import com.badugi.game.logic.model.vo.api.poker.param.GetAppFriendsVo;
import com.badugi.game.logic.model.vo.api.poker.param.ParamSuper;
import com.badugi.game.logic.model.vo.api.poker.param.ReachieveVo;
import com.badugi.game.logic.util.HttpClientUtil;
import com.badugi.game.logic.util.LogicExecutorUtil;
import com.joker.game.common.constant.Definition2;

public class WealthApiHelper {

	private static final Logger LOGGER = Logger.getLogger(WealthApiHelper.class);
	/**
	 * 比赛玩家名次，转给商城
	 */
	public static final String MatchEnd = "/match/takeaward.html";
	/**
	 * 请求商城重新计算成就
	 */
	public static final String REACHIEVE = "/lobbyapi/reachieve.html";

	/**
	 * 游戏结束后请求商城处理
	 */
	public static final String GAME_END = "/lobbyapi/gameend.html";

	/**
	 * 新手礼包
	 */
	public static final String NOVICE = "/lobbyapi/novice.html";

	/**
	 * qq好友
	 */
	public static final String GET_APP_FRIENDS = "/lobbyapi/getappfriends.html";

	/**
	 * 成就子类型
	 */
	public static enum AchieveSubtype {

		threeKind("threeKind"), // 三条 --------------牌型类---------------
		straight("straight"), // 顺子
		flush("flush"), // 同花
		fullHouse("fullHouse"), // 葫芦
		fourKind("fourKind"), // 四条
		straightFlush("straightFlush"), // 同花顺
		royalFlush("royalFlush"), // 皇家
		win("win"), // 胜利 --------------战绩类---------------
		lost("lost"), // 失败
		count("count"), // 累计局数
		friends("friends"), // 添加好友-----------社交类---------------
		inviteFriend("inviteFriend"), // 邀请好友
		sendSutff("sendSutff"), // 赠送礼物
		shares("shares"), // 分享
		chips("chips"), // 筹码--------------财富类----------------
		deposit("deposit"), // 充值
		exp("exp");// 等级--------------等级类----------------

		private final String value;

		private AchieveSubtype(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * 同步发送请求
	 */
	public static String api(ParamSuper reqParam, String path) {

		try {
			String url = getUrl(reqParam, path);

			String result = HttpClientUtil.Get(url);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e);

			ApiResultVo vo = new ApiResultVo(Definition2.SUCCESS_CODE, Definition2.SUCCESS_DESCRIPTION);
			try {
				return ObjectBeanUtil.JACKSON.writeValueAsString(vo);
			} catch (IOException e1) {
				LOGGER.error("", e1);
			}
		}
		return null;
	}

	/**
	 * 异步发送请求
	 */
	public static void asynapi(ParamSuper reqParam, String path) {

		try {
			String url = getUrl(reqParam, path);
			LOGGER.info("-->path:" + url);
			// Threadpool.executorOtherPool.execute(new Asynchronization(url));
			LogicExecutorUtil.getLogicService().execute(new Asynchronization(url));
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
	}

	/**
	 * 成就计算请求
	 */
	public static void reachieve(Long uid, String subtype) {

		ReachieveVo reqParam = new ReachieveVo();
		reqParam.setSubtype(subtype);
		reqParam.setUid(uid);

		asynapi(reqParam, REACHIEVE);
	}

	/**
	 * 拉取用户qq好友
	 */
	public static void getAppFriends(String openid, String openkey, String pf) {

		GetAppFriendsVo reqParam = new GetAppFriendsVo();
		reqParam.setOpenid(openid);
		reqParam.setOpenkey(openkey);
		reqParam.setPf(pf);

		asynapi(reqParam, GET_APP_FRIENDS);
	}

	/**
	 * 得到请求URL
	 */
	public static String getUrl(ParamSuper reqParam, String path) throws Exception {

		if (reqParam == null)
			throw new Exception("reqParam == null");

		if (StringUtils.isEmpty(path))
			throw new Exception("StringUtils.isEmpty(path)");

		reqParam.setSign(LobbyParamCache.POKER_SIGN);
		StringBuilder url = new StringBuilder(LobbyParamCache.WEALTH_URL);
		url.append(path).append("?");
		url.append(BeanUtils.toParam(reqParam));

		return url.toString();
	}

	private static class Asynchronization implements Runnable {

		private String url;

		public Asynchronization(String url) {
			super();
			this.url = url;
		}

		@Override
		public void run() {
			try {
				HttpClientUtil.Get(url);
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		}
	}
}
