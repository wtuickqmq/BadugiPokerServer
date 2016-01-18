package com.badugi.game.logic.service;

import com.badugi.game.logic.model.callback.LogicRequest;
import com.badugi.game.logic.model.callback.RPCService;
import com.badugi.game.logic.model.domain.vo.flash.ResultVo;
import com.badugi.game.logic.model.domain.vo.flash.user.GameDetailVo;
import com.badugi.game.logic.model.domain.vo.flash.user.LoginVo;

public interface PlayerService extends RPCService {

	/**
	 * 用户断开连接
	 * 
	 * @param args
	 */
	void logout(LogicRequest args);

	LoginVo login(LogicRequest args);

	ResultVo getRoomLevels(LogicRequest args);

	ResultVo getRooms(LogicRequest args);

	ResultVo getGameType(LogicRequest args);

	ResultVo joinGameRoom(LogicRequest args);

	ResultVo getOffRooms(LogicRequest args);

	ResultVo Quick_Game(LogicRequest args);

	ResultVo betShake(LogicRequest args);

	ResultVo getShakeConfig(LogicRequest args);

	ResultVo betJewelBox(LogicRequest args);
	
	Object e_LookMatchDetail(LogicRequest args);
	
	ResultVo e_matchtype(LogicRequest args);
	
	ResultVo e_matchlevels(LogicRequest args);
	
	ResultVo e_matchlists(LogicRequest args);
	
	ResultVo e_championships(LogicRequest args);

	GameDetailVo getGameRoomInfo(LogicRequest args);

	void getJewelBoxChips(LogicRequest args);
}
