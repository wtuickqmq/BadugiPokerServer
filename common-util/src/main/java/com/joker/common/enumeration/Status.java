package com.joker.common.enumeration;

public enum Status {

	/*********************************************************
	 * 		                 3xxx 充值相关
	 *********************************************************/
	/** 3802 远程充值超时 **/
	CHARGE_DO_TIMEOUT 					(3802, "远程充值超时"),
	/** 3801 远程充值成功 **/
	CHARGE_DO_SUCESS 					(3801, "远程充值成功"),
	/** 3800 远程充值失败 **/
	CHARGE_DO_FAIL 						(3800, "远程充值失败"),
	
	/** 3502 充值验证失败 **/
	CHARGE_VERIFY_APPSTORE_TIMEOUT 		(3502, "appstore充值验证超时"),
	/** 3501 充值验证失败 **/
	CHARGE_VERIFY_APPSTORE_SUCESS 		(3501, "appstore充值验证成功"),
	/** 3500 充值验证失败 **/
	CHARGE_VERIFY_APPSTORE_FAIL 		(3500, "appstore充值验证失败"),
	
	/** 3102 充值验证失败 **/
	CHARGE_VERIFY_TIMEOUT 		(3102, "充值验证超时"),
	/** 3101 充值验证失败 **/
	CHARGE_VERIFY_SUCESS 		(3101, "充值验证成功"),
	/** 3100 充值验证失败 **/
	CHARGE_VERIFY_FAIL 			(3100, "充值验证失败"),
	
	/** 3006 重复充值 **/
	CHARGE_REPEAT 				(3006, "重复充值"),
	/** 3001 充值成功 **/
	CHARGE_SUCESS 				(3001, "充值成功"),
	/** 3000 充值错误 **/
	CHARGE_ERROR 				(3000, "充值错误"),
	
	/*********************************************************
	 * 		                 2xxx 用户相关
	 *********************************************************/

	/** 2170 用户资料更新错误 **/
	USER_UPDATA_ERROR 				(2170, "用户资料更新错误"),
	/** 2171 用户状态更新错误 **/
	USER_UPDATA_EMAIL_ERROR 		(2171, "用户邮箱更新错误"),	
	/** 2172 用户状态更新错误 **/
	USER_UPDATA_STATUS_ERROR 		(2172, "用户状态更新错误"),
	
	/** 2160 用户错误,格式错误 **/
	USER_FORMAT_ERROR 				(2160, "用户格式错误"),
	/** 2161 用户错误,格式错误,用户名格式错误 **/
	USER_FORMAT_UESRNAME_ERROR 		(2161, "用户名格式错误"),
	/** 2162 用户错误,格式错误,密码格式错误 **/
	USER_FORMAT_PASSWORD_ERROR 		(2162, "密码格式错误"),
	/** 2163 用户错误,格式错误,电子邮箱格式错误 **/
	USER_FORMAT_EMAIL_ERROR 		(2163, "电子邮箱格式错误"),
	/** 2164 用户错误,格式错误,用户姓名格式错误 **/
	USER_FORMAT_GIVENNAME_ERROR 	(2164, "用户姓名格式错误"),
	
	/** 2150 用户错误,注册错误,用户注册失败,包含格式错误 **/
	USER_REGISTER_ERROR 			(2150, "注册错误,用户注册失败,包含格式错误"),
	/** 2151 用户错误,注册错误,用户名验证失败,包含格式错误 **/
	USER_REGISTER_UESRNAME_ERROR  	(2151, "注册错误,用户名验证失败,包含格式错误"),
	/** 2152 用户错误,注册错误,密码效验失败,包含格式错误 **/
	USER_REGISTER_PASSWORD_ERROR  	(2152, "注册错误,密码效验失败,包含格式错误"),
	/** 2153 用户错误,注册错误,电子邮箱效验失败,包含格式错误 **/
	USER_REGISTER_EMAIL_ERROR  		(2153, "注册错误,电子邮箱效验失败,包含格式错误"),
	/** 2154 用户错误,注册错误,用户姓名效验失败,包含格式错误 **/
	USER_REGISTER_GIVENNAME_ERROR  	(2154, "注册错误,用户姓名效验失败,包含格式错误"),
	
	/** 2140 邮件地址已存在 **/
	USER_REGISTER_EMAIL_EXISTENCE 			(2140, "电子邮件已存在"),
	/** 2141 邮件地址不存在 **/
	USER_REGISTER_EMAIL_NOT_EXISTENCE		(2141, "电子邮件不存在"),
	/** 2142 电子邮件发送失败 **/
	USER_REGISTER_EMAIL_SEND_SUCESS			(2142, "电子邮件发送失败"),
	/** 2143 电子邮件发送成功 **/
	USER_REGISTER_EMAIL_SEND_FAIL 			(2143, "电子邮件发送成功"),
	/** 2144 电子邮件已通过验证 **/
	USER_REGISTER_EMAIL_VERIFIED 			(2144, "电子邮件已通过验证"),
	/** 2145 电子邮件未通过验证 **/
	USER_REGISTER_EMAIL_NOT_VERIFIED 		(2145, "电子邮件未通过验证"),
	
	/** 2001 用户名已存在 **/
	USER_EXISTENCE 			    (2001, "用户名已存在"),
	/** 2002 用户名不存在 **/
	USER_NOT_EXISTENCE 		    (2002, "用户名不存在"),

	/** 2010 用户授权成功 **/
	USER_AUTHORIZED_SUCESS		(2010, "用户授权成功"),
	/** 2011 用户授权失败 **/
	USER_AUTHORIZED_FAIL 		(2011, "用户授权失败"),
	
	/** 1011 缺少参数 **/
	PARAMETER_MISSING			(1050, "缺少参数"),
	/** 1020 标签错误 **/
	PARAMETER_TAG_10			(1020, "标签错误"),
	/** 1019 标签错误 **/
	PARAMETER_TAG_9				(1019, "标签错误"),
	/** 1018 标签错误 **/
	PARAMETER_TAG_8				(1018, "标签错误"),
	/** 1017 标签错误 **/
	PARAMETER_TAG_7				(1017, "标签错误"),
	/** 1016 标签错误 **/
	PARAMETER_TAG_6				(1016, "标签错误"),
	/** 1015 标签错误 **/
	PARAMETER_TAG_5				(1015, "标签错误"),
	/** 1014 标签错误 **/
	PARAMETER_TAG_4				(1014, "标签错误"),
	/** 1013 标签错误 **/
	PARAMETER_TAG_3				(1013, "标签错误"),
	/** 1012 标签错误 **/
	PARAMETER_TAG_2				(1012, "标签错误"),
	/** 1011 标签错误 **/
	PARAMETER_TAG_1				(1011, "标签错误"),
	/** 1010 参数错误 **/
	PARAMETER_ERROR				(1010, "参数错误"),
	
	/** 1006 重复刷新 **/
	REPEAT						(1006, "函数重复提交"),
	/** 1001 函数执行成功 **/
	SUCESS						(1001, "函数执行成功"),
	/** 1000 函数发生错误 **/
	ERROR						(1000, "函数发生错误"),
	/** 0 函数状态未知 **/
	UNKNOWN						(0, "函数状态未知");

	/**
	 * Code value
	 */
	private int value;

	/**
	 * Status description
	 */
	private String description;

	/**
	 * construction
	 * @param value
	 * String Code value
	 * @param description
	 * String Status description
	 */
	private Status(int value, String description){
		this.value = value;
		this.description = description;
	}

	/**
	 * Get Code value
	 * @return
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Get Status description
	 * @return
	 */
	public String getDescription() {
		return description;
	}
}
