package com.badugi.game.logic.model.cache;

/**
 * 用户消息管理 
 */
public class MessageManager {

	/**
	 * 系统消息id（消息为系统给用户发出时使用该id表示用户消息的来源id） 
	 */
	public static final int SYSTEM_ID = 0;
	
	/**
	 * 消息保留天数 
	 */
	public static final int VALID_DAYS = 7;
	
	/**
	 * 九客币消费消息保留天数 
	 */
	public static final int PAY_MESSAGE_VALID_DAYS = 30;
	
	/**
	 * 1系统消息 2互动消息 3支付消息 
	 */
	public static enum Type{
		
		/** 全部*/
		ALL((short)0),
		
		/** 系统消息*/
		SYS((short)1),
		
		/** 互动消息*/
		INT((short)2),
		
		/** 支付消息*/
		PAY((short)3);
			
		private final short value;

		private Type(short value) {
			this.value = value;
		}

		public short getValue() {
			return value;
		}
		
		public static boolean contain(Short type){
			
			if(type == null) return false;
			
			Type[] values = values();
			
			for (Type t : values) 
			{
				if(t.getValue() == type) return true;
			}	
			return false;
		}
	}
	
	/**
	 * 消息子类型 
	 */
	public static enum Subtype{
		// add by fengpeijie 20150521 begin
		/** 礼物赠送*/
		present("present"),
		// add by fengpeijie 20150521 end
		
		/** 九客币变动消息*/
		pay("pay"),
		
		/** 玩家互动消息*/
		interaction("interaction"),
		
		/** 牌友添加请求*/
		friendreq("friendreq"),
		
		/** 赞用户*/
		praise("praise"),
		
		/** 赠送*/
		give("give"),
		
		/** 公告消息*/
		notice("notice"),
		
		/** 系统消息*/
		sys("sys"),
		
		/** 赛事相关*/
		match("match"),
		
		/** 用户私信*/
		usermsg("usermsg"),
		
		/** 系统奖品 如比赛获奖*/
		award("award");
		
		private final String value;
		
		private Subtype(String value){
			this.value = value;
		}
		public String getValue(){
			return value;
		}
		
		/**
		 * 是否是公告 公告保存在notice表里 跟用户消息操作不一样 
		 */
		public static boolean isNotice(String subtype){
			
			return notice.getValue().equals(subtype);
		}
	}
	
	/**
	 * 状态 0未读 1已读 2已删
	 */
	public static enum Status{
		
		/** 未读*/
		UNREAD((short)0),
		
		/** 已读*/
		READ((short)1),
		
		/** 已删*/
		DELETE((short)2);
			
		private final short value;

		private Status(short value) {
			this.value = value;
		}

		public short getValue() {
			return value;
		}
	}
}
