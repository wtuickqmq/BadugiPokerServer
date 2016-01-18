package com.badugi.game.logic.service.processtask;

import com.badugi.game.logic.model.cache.LocalMatchCache;
import com.badugi.game.logic.model.domain.vo.flash.Definition;
import com.badugi.game.logic.model.domain.vo.flash.operators.ServerStopVo;
import com.badugi.game.logic.model.domain.vo.flash.operators.ServerstopResultVo;

/**
 * @author wtu.edit
 * @date 2015年9月18日
 * @version qq1.0
 * @email wtuickqmq@163.com
 */
public class ServerStopTask {
	
	
	
	// 系统是否启动
	public ServerStopTask() {
		super();
		
	}
	//返回null则没有维护信息，否则有维护
	public ServerstopResultVo isServerStop()
	{
		ServerStopVo serverStopVo = LocalMatchCache.SERVER_STOP;
		ServerstopResultVo svo=null;
		if (serverStopVo.getStopserver() && serverStopVo.getStopgame()) {
			svo = new ServerstopResultVo(Definition.JOINROOM, Definition.SERVER_STOP_CODE,
					serverStopVo.getBegintime(), serverStopVo.getEndtime(), serverStopVo.getGametime(), serverStopVo.getMatchtime());
			
			
		}
	    return svo;
	}
				


}
