package com.badugi.game.logic.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.badugi.game.logic.model.callback.LogicRequest;
import com.badugi.game.logic.model.callback.RPCReponse;
import com.badugi.game.logic.service.MatchService;
import com.badugi.game.logic.util.LogicChannelUtil;
import com.google.common.collect.Maps;
import com.joker.game.common.constant.EventDefinition;

@Service("matchService")
public class MatchServiceImpl implements MatchService {

	@RPCReponse("e_test_match")
	public void e_test_match(LogicRequest logicRequest){
		// 返回给客户端的信息
		Map<String,Object> map = Maps.newHashMap();
		map.put("name", "match");
		map.put("code", 1);
		map.put("event", "e_test_match");
		LogicChannelUtil.sendToTarget(map, logicRequest.getSession());
	}
	
	/**
	 * 获取比赛类型
	 * 
	 * @param logicRequest
	 */
	@RPCReponse(EventDefinition.EVENT_MATCHTYPE)
	public void e_matchtype(LogicRequest logicRequest) {

	}

	/**
	 * 大厅比赛等级信息
	 * 
	 * @param logicRequest
	 */
	@RPCReponse(EventDefinition.EVENT_GET_MATCH_LEVELS)
	public void e_matchlevels(LogicRequest logicRequest) {

	}

	/**
	 * 大厅比赛信息
	 * 
	 * @param logicRequest
	 */
	@RPCReponse(EventDefinition.EVENT_GET_MATCH)
	public void e_matchlists(LogicRequest logicRequest) {

	}

	/**
	 * 大厅锦标赛房间信息
	 * 
	 * @param logicRequest
	 */
	@RPCReponse(EventDefinition.EVENT_GET_CMATCH)
	public void e_championships(LogicRequest logicRequest) {

	}
}
