/**
 * 深圳市辰富科�?��限公�?.inc
 * Texas Poker Game App V1.0
 */
/**
 * author  yuesheng.yin
 * createTime 2011-1-21上午10:58:27
 */
package com.badugi.poker;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class TexasConstant implements Serializable {

	private static final long serialVersionUID = 9076103735581870676L;

	/** 总共牌数�?*/
	public static final int CARD_NUM = 52;
	/** 13张牌 */
	public final static int VALUE_NUM = 13;
	/** 4种花�?*/
	public final static int SUIT_NUM = 4;

	/** 成手由五张牌组成�?*/
	public final static int POKER_HAND_NUM = 5;

	public final static int RECOGNISE_CARD_NUM = 7;

	public static enum CardValueType {// 牌面值类型定�?
		NULL(-1), TWO(0), THREE(1), FOUR(2), FIVE(3), SIX(4), SEVEN(5), EIGHT(6), NINE(
				7), TEN(8), J(9), Q(10), K(11), A(12);
		private int value;

		private CardValueType(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	public final static Map<Integer, String> CardValueMap = new HashMap<Integer, String>(
			16);
	public final static Map<Integer, String> CardSuitMap = new HashMap<Integer, String>(
			6);

	static {
		CardValueMap.put(-1, "-1");
		CardValueMap.put(0, "2");
		CardValueMap.put(1, "3");
		CardValueMap.put(2, "4");
		CardValueMap.put(3, "5");
		CardValueMap.put(4, "6");
		CardValueMap.put(5, "7");
		CardValueMap.put(6, "8");
		CardValueMap.put(7, "9");
		CardValueMap.put(8, "10");
		CardValueMap.put(9, "J");
		CardValueMap.put(10, "Q");
		CardValueMap.put(11, "K");
		CardValueMap.put(12, "A");

		CardSuitMap.put(-1, "无效");
		CardSuitMap.put(0, "方块");
		CardSuitMap.put(1, "梅花");
		CardSuitMap.put(2, "红桃");
		CardSuitMap.put(3, "黑桃");
	}

	public static enum CardSuitType {// 牌花色定�?
		DIAMOND(0), CLUB(1), HEART(2), SPADE(3);
		private int value;

		private CardSuitType(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	public static enum PokerHandType {// 成手�?0种类�?-从小至大
		NULL(-1), HIGH_CARD(0), PAIR(1), TWO_PAIR(2), THREE_OF_A_KIND(3), STRAIGHT(
				4), FLUSH(5), FULL_HOUSE(6), FOUR_OF_A_KIND(7), STRAIGHT_FLUSH(
				8), ROYAL_FLUSH(9);
		private int value;

		private PokerHandType(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

}
