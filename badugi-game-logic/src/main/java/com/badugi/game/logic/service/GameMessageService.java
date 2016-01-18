package com.badugi.game.logic.service;

import com.badugi.game.logic.model.callback.LogicRequest;
import com.badugi.game.logic.model.callback.RPCService;

public interface GameMessageService extends RPCService {

	/**
	 * 测试
	 * 
	 * @param request
	 */
	void call_test(LogicRequest request);
	
	/**
	 * 更新房间数据
	 * 
	 * @param request
	 */
	void call_updaterooms(LogicRequest request);

	/**
	 * 更新房间等级
	 * 
	 * @param request
	 */
	void call_updatelevels(LogicRequest request);

	/**
	 * 删除房间数据
	 * 
	 * @param request
	 */
	void call_removerooms(LogicRequest request);
	
	/***
	 * 更新房间用户
	 * @param request
	 */
	void call_updateroomplayers(LogicRequest request);
	
	/***
	 * 通知游戏开始
	 * @param request
	 */
	void call_gamebegin(LogicRequest request);
	
	/***
	 * 通知游戏结束
	 * @param request
	 */
	void call_gameend(LogicRequest request);
	
	/***
	 * 通知玩家离开房间或进入房间
	 * @param request
	 */
	void call_player_join_or_leave(LogicRequest request);
	/***
	 * 通知玩家更新筹码
	 * @param request
	 */
	void call_update_chips_info(LogicRequest request);
	/***
	 * 通知玩家离开房间返回筹码
	 * @param request
	 */
	void call_p_back_chips(LogicRequest request);
}
