package com.badugi.poker.oddscalcu;
/**
 * 深圳市辰富科�?��限公�?.inc
 * Texas Poker Game App V1.0
 */


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badugi.poker.Card;
import com.badugi.poker.oddscalcu.helper.Combine;
import com.badugi.poker.pokerhand.PokerHandBase;

/**
 * author yuesheng.yin
 * createTime 2012-1-14 下午03:57:39
 */
/**
 * 
 * 缓存牌型序列�?
 */
public class PokerHandCache implements Serializable {

	private static final long serialVersionUID = 8106556750229916844L;

	private static final Object object = new Object();

	private static final Map<Integer, Object> RoyalFlushCache = new HashMap<Integer, Object>();

	private static final Map<Integer, Object> StraightFlushCache = new HashMap<Integer, Object>();

	private static final Map<Integer, Object> FourKindCache = new HashMap<Integer, Object>();

	private static final Map<Integer, Object> FullHouseCache = new HashMap<Integer, Object>();

	private static final Map<Integer, Object> FlushCache = new HashMap<Integer, Object>();

	private static final Map<Integer, Object> STRAIGHTCache = new HashMap<Integer, Object>();

	private static final Map<Integer, Object> THREEKINDCache = new HashMap<Integer, Object>();

	private static final Map<Integer, Object> TWOPAIRCache = new HashMap<Integer, Object>();

	private static final Map<Integer, Object> PAIRCache = new HashMap<Integer, Object>();

	// private static final Map<Integer, Object> HIGHCARDCache = new
	// HashMap<Integer, Object>();

	/**
	 * @return the royalflushcache
	 */
	public static boolean isNotRoyalflushcache(int i) {
		return RoyalFlushCache.get(i) == null;
	}

	/**
	 * @return the straightflushcache
	 */
	public static boolean isNotStraightflushcache(int i) {
		return StraightFlushCache.get(i) == null;
	}

	/**
	 * @return the fourkindcache
	 */
	public static boolean isNotFourkindcache(int i) {
		return FourKindCache.get(i) == null;
	}

	/**
	 * @return the fullhousecache
	 */
	public static boolean isNotFullhousecache(int i) {
		return FullHouseCache.get(i) == null;
	}

	/**
	 * @return the flushcache
	 */
	public static boolean isNotFlushcache(int i) {
		return FlushCache.get(i) == null;
	}

	/**
	 * @return the straightcache
	 */
	public static boolean isNotStraightcache(int i) {
		return STRAIGHTCache.get(i) == null;
	}

	/**
	 * @return the threekindcache
	 */
	public static boolean isNotThreekindcache(int i) {
		return THREEKINDCache.get(i) == null;
	}

	/**
	 * @return the twopaircache
	 */
	public static boolean isNotTwopaircache(int i) {
		return TWOPAIRCache.get(i) == null;
	}

	/**
	 * @return the paircache
	 */
	public static boolean isNotPaircache(int i) {
		return PAIRCache.get(i) == null;
	}

	// /**
	// * @return the highcardcache
	// */
	// public static boolean isHighcardcache(int i) {
	// return HIGHCARDCache.get(i) == null;
	// }

	public static void main(String[] arg) {
		int[] s = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
				17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32,
				33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48,
				49, 50, 51 };
		List<int[]> arrList = Combine.getCombineListQuick(s, 5);
		PokerHandBase ph;
		for (int[] iss : arrList) {
			ph = RecogniseHandFive.recogniseFiveCard(Card.newCard(iss[0]), Card
					.newCard(iss[1]), Card.newCard(iss[2]), Card
					.newCard(iss[3]), Card.newCard(iss[4]));
			switch (ph.getPokerHandType().getValue()) {
			case 9:
				initCahce(RoyalFlushCache, iss);
				break;
			case 8:
				initCahce(StraightFlushCache, iss);
				break;
			case 7:
				initCahce(FourKindCache, iss);
				break;
			case 6:
				initCahce(FullHouseCache, iss);
				break;
			case 5:
				initCahce(FlushCache, iss);
				break;
			case 4:
				initCahce(STRAIGHTCache, iss);
				break;
			case 3:
				initCahce(THREEKINDCache, iss);
				break;
			case 2:
				initCahce(TWOPAIRCache, iss);
				break;
			case 1:
				initCahce(PAIRCache, iss);
				break;
			}
		}

	}

	private static void initCahce(Map<Integer, Object> cacheMap,
			int[] cardSerialArr) {
		for (int i : cardSerialArr) {
			cacheMap.put(i, object);
		}
	}
}
