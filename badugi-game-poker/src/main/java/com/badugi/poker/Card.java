/**
 * 娣卞湷甯傝景瀵岀锟�锟斤拷闄愬叕锟�.inc
 * Texas Poker Game App V1.0
 */
/**
 * author  yuesheng.yin
 * createTime 2011-1-20涓嬪崍05:06:01
 */
package com.badugi.poker;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.badugi.poker.TexasConstant.CardValueType;

public class Card implements Comparable<Card>, Serializable {

	private static final long serialVersionUID = 426071376460560068L;

	/** 绛夊緟琚祴鍊肩殑绌虹墝 鑺辫壊鍜岄潰鍊煎悓锟�1 */
	public final static Card NULL = new Card(CardValueType.NULL.getValue());

	/**
	 * 缂撳瓨鐗岀被
	 */
	private final static Map<Integer, Card> CardCache = new ConcurrentHashMap<Integer, Card>(
			70);

	private final static Map<String, Integer> CardSerialNoStrToIntegerCache = new ConcurrentHashMap<String, Integer>(
			70);

	static {
		for (int i = -1; i < TexasConstant.CARD_NUM; i++) {
			CardCache.put(i, new Card(i));
			CardSerialNoStrToIntegerCache.put("" + i, i);
		}
	}

	/**
	 * 鏈夌墝搴忓彿寰楀埌鏌愬紶鍏蜂綋鐨勬墤鍏嬬墝
	 */
	public static Card newCard(int serialNo) {
		return CardCache.get(serialNo);
	}

	/**
	 * 鏈夌墝搴忓彿寰楀埌鏌愬紶鍏蜂綋鐨勬墤鍏嬬墝
	 */
	public static Card newCard(String serialNo) {
		return CardCache.get(CardSerialNoStrToIntegerCache.get(serialNo));
	}

	/**
	 * 瀛楃涓茬殑鎺掑簭鍒楀彿杞负鏁村瀷
	 * 
	 * @param serialNo
	 * @return
	 */
	public static Integer convertStringToInteger(String serialNo) {
		return CardSerialNoStrToIntegerCache.get(serialNo);
	}

	private Card(int serialNo) {
		/** 锟�~51. 0-3 鍒嗗埆琛ㄧず鍑轰竴绉嶈姳锟�*/
		if (CardValueType.NULL.getValue() == serialNo) {
			this.serialNo = serialNo;
			this.suit = CardValueType.NULL.getValue();
			this.value = CardValueType.NULL.getValue();
		} else {
			this.serialNo = serialNo;
			this.suit = serialNo % TexasConstant.SUIT_NUM;
			this.value = serialNo / TexasConstant.SUIT_NUM;
		}
	}

	private final int serialNo;// 鐗屽簭鍒楀彿
	private final int suit;// 鐗岃姳锟�
	private final int value;// 鐗岄潰锟�

	public int getValue() {
		return value;
	}

	public int getSuit() {
		return suit;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public int compareTo(Card arg0) {// 鍗曞紶鎵戝厠鐗屾瘮杈冿紙澶ц繑鍥炴锟�灏忎簬杩斿洖璐熸暟,鐩哥瓑杩斿洖0锟�
		return this.value - arg0.getValue();
	}

	@Override
	public String toString() {
		return (this.serialNo + " : " + TexasConstant.CardSuitMap.get(this.suit) + " : " + TexasConstant.CardValueMap
				.get(this.value));
	}
	
	public static void main(String[] arg) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 52; i++) {
			sb.append(i).append(",");
			System.out.println(CardCache.get(i));
		}
		System.out.println(sb.toString());
	}

}
