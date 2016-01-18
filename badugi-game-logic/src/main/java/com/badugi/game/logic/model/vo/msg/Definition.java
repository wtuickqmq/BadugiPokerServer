package com.badugi.game.logic.model.vo.msg;


/****
 * @createTime: 2012-10-22
 * @description:统一接口定义
 */
public class Definition {
	
	
	/***
	 * 操作成功
	 */
	public final static long SUCCESS_CODE = 10000L;
	public final static String SUCCESS_DESCRIPTION = "success";
	
	/***
	 * 未知错误
	 */
	public final static long NUKNOW_CODE = 19999L;
	public final static String NUKNOW_DESCRIPTION = "nuknow error";
	
	/***
	 * 参数错误
	 */
	public final static long ERROR_ARGS_CODE = 10001L;
	public final static String ERROR_ARGS_DESCRIPTION = "the params error! please check it.";
	
}
