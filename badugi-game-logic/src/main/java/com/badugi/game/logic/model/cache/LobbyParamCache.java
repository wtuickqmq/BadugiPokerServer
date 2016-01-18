package com.badugi.game.logic.model.cache;

import java.util.HashMap;
import java.util.Map;

import com.badugi.game.logic.util.LogicPropertyUtil;


public class LobbyParamCache {
	/*输赢状态 表示 -1输，0平  1赢 */
	public static final short[] LOST_WIN_STATUS = {-1,0,1};
	
	public static final int MAX_LAST_ROUND = LogicPropertyUtil.getInteger("option.exec.round.max", 0);
	
	//荣誉最小赢取的大盲数
	public static final int MIN_BB =LogicPropertyUtil.getInteger("option.glory.min.bb", 0) ;
	
	public static final String WEALTH_URL = LogicPropertyUtil.getString("wealth.url");
	
	public static final String POKER_SIGN = LogicPropertyUtil.getString("option.api.sign.poker.special");
	
	/*系统类型 1九客币2 Q点 3筹码 4VIP积分*/
	public static final short[] CURRENCY_TYPE = {1,2,3,4};
	
	/*输赢保存的列名*/
//	private static final Map<Short, String> lostWinColMap = new HashMap<Short, String>();
	/*货币类型  货币名*/
	private static final Map<Short, String> currencyNameMap = new HashMap<Short, String>();

	private static final Map<Short, String> currencyProMap = new HashMap<Short, String>();
	
	static{
//		lostWinColMap.put(LOST_WIN_STATUS[0], "lost");
//		lostWinColMap.put(LOST_WIN_STATUS[1], "draw");
//		lostWinColMap.put(LOST_WIN_STATUS[2], "win");
		
		currencyNameMap.put(CURRENCY_TYPE[0], "九客币");
		currencyNameMap.put(CURRENCY_TYPE[1], "Q点");
		currencyNameMap.put(CURRENCY_TYPE[2], "筹码");
		currencyNameMap.put(CURRENCY_TYPE[3], "VIP积分");
		
		currencyProMap.put(CURRENCY_TYPE[0], "g");
		currencyProMap.put(CURRENCY_TYPE[2], "c");
		currencyProMap.put(CURRENCY_TYPE[3], "p");
	}
	
	/**
	 * 根据输赢状态 得到需要更新的数据库字段 
	 */
//	public static String getLostWinColNameBy(Short lostWinCode){
//		
//		return lostWinColMap.get(lostWinCode);
//	}
	
	public static String getCurrencyNameBy(Short currencyType){
		
		return currencyNameMap.get(currencyType);
	}
	
	public static String getCurrencyProNameBy(Short currencyType){
		
		return currencyProMap.get(currencyType);
	}
}
