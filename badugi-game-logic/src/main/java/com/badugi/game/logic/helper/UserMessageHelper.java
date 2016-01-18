package com.badugi.game.logic.helper;

import java.sql.Timestamp;

import com.badugi.game.logic.dao.UsersDao;
import com.badugi.game.logic.model.cache.MessageManager;
import com.badugi.game.logic.model.utils.common.CalendarUtil;
import com.badugi.game.logic.util.AppContext;

public class UserMessageHelper {

	/**
	 * 新增用户消息记录 系统发送给用户时调用该方法
	 */
	public static void insertUserMessage(Long uid, UserMessageHelper.Message message) throws Exception {

		insertUserMessage(Long.valueOf(MessageManager.SYSTEM_ID), uid, message);
	}

	/**
	 * 新增用户消息记录
	 */
	public static void insertUserMessage(Long fromid, Long uid, UserMessageHelper.Message message) throws Exception {

		AppContext.getBean(UsersDao.class).execSQL(getSql(fromid, uid, message));

	}

	/**
	 * 新增用户消息记录 并返还主键
	 */
	public static int isnertUserMessageRetKey(Long fromid, Long uid, UserMessageHelper.Message message) throws Exception {
		int affect = AppContext.getBean(UsersDao.class).execSQL(getSql(fromid, uid, message));
		return affect;
	}

	private static String getSql(Long fromid, Long uid, UserMessageHelper.Message message) throws Exception {

		short type = message.getType();

		// 转换为有效期
		Timestamp validTime = getValidTime(type);

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ").append("\n");
		sql.append("	user_msg(from_id, u_id, type, subtype, title, content, status, cre_time, valid_time)").append("\n");
		sql.append("VALUES(").append("\n");
		sql.append("	").append(fromid).append(",").append("\n");
		sql.append("	").append(uid).append(",").append("\n");
		sql.append("	").append(message.getType()).append(",").append("\n");
		sql.append("	'").append(message.getSubtype()).append("',").append("\n");
		sql.append("	'").append(message.getTitle()).append("',").append("\n");
		sql.append("	'").append(message.getContent()).append("',").append("\n");
		sql.append("	").append(MessageManager.Status.UNREAD.getValue()).append(",").append("\n");
		sql.append("	now(),").append("\n");
		sql.append("	'").append(validTime.toString()).append("'").append("\n");
		sql.append(")");

		System.out.println(sql.toString());
		return sql.toString();
	}

	public static Timestamp getValidTime(short type) throws Exception {

		// 有效天数
		Integer validDays = MessageManager.VALID_DAYS;
		if (type == MessageManager.Type.PAY.getValue())
			validDays = MessageManager.PAY_MESSAGE_VALID_DAYS;

		// 转换为有效期
		return CalendarUtil.getTimeBy(validDays * CalendarUtil.MAX_HOUR_OF_DAY);
	}

	public static class Message {

		private String title;

		private String content;

		private Short type;

		private String subtype;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Short getType() {
			return type;
		}

		public void setType(Short type) {
			this.type = type;
		}

		public String getSubtype() {
			return subtype;
		}

		public void setSubtype(String subtype) {
			this.subtype = subtype;
		}

		@Override
		public String toString() {
			return "Message [title=" + title + ", content=" + content + ", type=" + type + ", subtype=" + subtype + "]";
		}
	}
}
