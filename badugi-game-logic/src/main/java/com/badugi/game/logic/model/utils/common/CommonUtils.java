/*
 * <p>Title: CommonUtil.java </p>
 * <p>Description:  </p>
 * <p>Copyright: D3space (c) 2005 </p>
 * <p>Company: ����ռ���Ϣ�������޹�˾</p>
 */
package com.badugi.game.logic.model.utils.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * @author msy 2007-10-23
 * @version FanQ v2.0
 */

public final class CommonUtils {

	public static boolean verifyMemberid(String memberid) {
		if (!verifyNull(memberid)) {
			final String idRegexp = "^([0-9]{2,10})$";
			try {
				final Pattern pattern = Pattern.compile(idRegexp);
				if (pattern.matcher(memberid).find())
					return true;
			} catch (Exception e) {
				;
			}
		}
		return false;
	}

	public  static boolean verifyMobile(String mobile) {
		if (!verifyNull(mobile)) {
			final String mobileRegexp = "^[0]{0,1}1[3,5,8][0-9]{9}$";
			try {
				final Pattern pattern = Pattern.compile(mobileRegexp);
				if (pattern.matcher(mobile).find())
					return true;
			} catch (Exception e) {
				;
			}
		}
		return false;
	}

	public  static boolean verifyNumber(String number) {
		if (!verifyNull(number)) {
			final String numberRegexp = "^([0-9]+)$";
			try {
				final Pattern pattern = Pattern.compile(numberRegexp);
				if (pattern.matcher(number.trim()).find()) {
					return true;
				}
			} catch (Exception e) {
				;
			}
		}
		return false;
	}

	public static  boolean verifyFloat(String number) {
		if (!verifyNull(number)) {
			final String numberRegexp = "^([0-9]+)[.]*([0-9]*)$";
			try {
				final Pattern pattern = Pattern.compile(numberRegexp);
				if (pattern.matcher(number.trim()).find()) {
					return true;
				}
			} catch (Exception e) {
				;
			}
		}
		return true;
	}

	public static  boolean verifyNull(String info) {
		boolean result = false;
		if (info == null)
			result = true;
		else if (info.trim().length() <= 0)
			result = true;
		return result;
	}

	public static  boolean verifyEmail(String email) {

		if (email == null || email.equals(""))
			return false;

		email = email.toLowerCase().trim();

		final String emailRegexp = "^([a-zA-Z0-9_]+[\\.a-zA-Z0-9_-]*){1,}@([a-zA-Z0-9-]+\\.){1,}(com|org|net|edu|ac|ad|ae|af|ag|ai|al|am|an|ao|aq|ar|as|at|au|aw|az|ax|ba|bb|bd|be|bf|bg|bh|bi|bj|bm|bn|bo|br|bs|bt|bv|bw|by|bz|ca|cc|cd|cf|cg|ch|ci|ck|cl|cm|cn|co|cr|cs|cu|cv|cx|cy|cz|de|dj|dk|dm|do|dz|ec|ee|eg|eh|er|es|et|eu|fi|fj|fk|fm|fo|fr|ga|gb|gd|ge|gf|gg|gh|gi|gl|gm|gn|gp|gq|gr|gsslands|gt|gu|gw|gy|hk|hm|hn|hr|ht|hu|id|ie|il|im|in|io|iq|ir|is|it|je|jm|jo|jp|ke|kg|kh|ki|km|kn|kp|kr|kw|ky|kz|la|lb|lc|li|lk|lr|ls|lt|lu|lv|ly|ma|mc|md|mg|mh|mkc of|ml|mm|mn|mo|mp|mq|mr|ms|mt|mu|mv|mw|mx|my|mz|na|nc|ne|nf|ng|ni|nl|no|np|nr|nu|nz|om|pa|pe|pf|pg|ph|pk|pl|pm|pn|pr|ps|pt|pw|py|qa|re|ro|ru|rw|sa|sb|sc|sd|se|sg|sh|si|sj|sk|sl|sm|sn|so|sr|st|sv|sy|sz|tc|td|tf|tg|th|tj|tk|tl|tm|tn|to|tp|tr|tt|tv|tw|tz|ua|ug|uk|um|us|uy|uz|va|vc|ve|vg|vi|vn|vu|wf|ws|ye|yt|yu|za|zm|zw)$";
		try {
			final Pattern patternemail = Pattern.compile(emailRegexp);
			if (patternemail.matcher(email).find())
				return true;

		} catch (Exception e) {
			;
		}
		return false;
	}

	public static  boolean verifyLoginName(String loginname) {
		if (!verifyNull(loginname)) {
			final String loginnameRegexp = "^([[^\\x00-\\xff]*a-zA-Z0-9\\s_-]+)$";
			try {
				final Pattern patternname = Pattern.compile(loginnameRegexp);
				if (patternname.matcher(loginname).find())
					return true;
			} catch (Exception e) {
				;
			}
		}
		return false;
	}

	/**
	 * Convert object to string. If object is null or "", then return null.
	 * 
	 * @param objValue
	 *            it would be handle object value.
	 * @return String
	 */
	public  static String obj2String(Object objValue) {
		return (objValue == null || objValue.equals("")) ? null : objValue
				.toString();
	}

	public static  Object convertObj(Object objValue) {
		return (objValue == null || objValue.equals("")) ? null : objValue;
	}

	public static  String convertString(String strValue) {
		return (strValue == null || strValue.equals("")) ? "" : strValue;
	}

	public static  String convertString(Object strValue) {
		return (strValue == null || strValue.equals("")) ? "" : strValue
				.toString();
	}

	public static  String toBr(String value) {
		if (value != null)
			return value.replaceAll("\\r\\n", "<br>");
		return "";
	}

	public static  final Long getMemberDirname(Long memberId) {
		return memberId / 4000;
	}

	/**
	 * ȡ��Ŀ��ҳ
	 * 
	 * @param targetPage
	 * @param records
	 * @param pageSize
	 * @return
	 */
	public static  int verifyTargetPage(int targetPage, int records, int pageSize) {
		if (targetPage < 0)
			targetPage = 1;
		final int pageCount = (records / pageSize)
				+ (records % pageSize == 0 ? 0 : 1);
		if (targetPage > pageCount)
			targetPage = pageCount;
		return targetPage;
	}

	public static  String preparedForValueSet(Object value) {
		return value == null ? "" : value + "";
	}

	public static  void delFile(String filePath) {
		File picFile = new File(filePath);
		if (picFile.exists()) {
			picFile.delete();
		}
		picFile = null;
	}

	public static  int copyFile(String src, String to) {
		return copyFile(new File(src), new File(to));
	}

	public static  int copyFile(File in, File out) {

		try {
			FileInputStream fis = new FileInputStream(in);
			FileOutputStream fos = new FileOutputStream(out);

			byte[] buf = new byte[1024];
			int i = 0;
			while ((i = fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}
			fis.close();
			fos.close();
			fis = null;
			fos = null;
		} catch (Exception e) {
			System.err.println(e);
			return -1;
		}
		return 1;
	}

	public static  Double round(Double doubleValue, int scale) {
		return round(doubleValue.doubleValue(), scale);
	}

	public static  Double round(double doubleValue, int scale) {
		BigDecimal bd = new BigDecimal(doubleValue).setScale(scale,
				BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}
	
	public static String getRandomNum(int pwd_len) {
		  String randomStr = "abcdefghijklmnopqrstuvwxyz0123456789";
		  final int maxNum = 36;
		  int i;
		  int count = 0;
		  char[] str = randomStr.toCharArray();
		  StringBuffer pwd = new StringBuffer("");
		  Random r = new Random();
		  while(count<pwd_len){
			   i = Math.abs(r.nextInt(maxNum));
			   if(i>0 && i<str.length){
				   pwd.append(str[i]);
				   count++;
			   }
		  }
		  return pwd.toString();
	}
}
