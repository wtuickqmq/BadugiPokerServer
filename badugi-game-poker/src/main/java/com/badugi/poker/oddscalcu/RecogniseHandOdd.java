package com.badugi.poker.oddscalcu;
/**
 * 深圳市辰富科�?��限公�?.inc
 * Texas Poker Game App V1.0
 */
/**
 * author  yuesheng.yin
 * createTime 2011-1-21下午04:42:06
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badugi.poker.Card;
import com.badugi.poker.TexasConstant;
import com.badugi.poker.TexasConstant.CardValueType;
import com.badugi.poker.TexasConstant.PokerHandType;

/**
 * 概率统计识别
 * 
 * @author yuesheng.yin
 * 
 */
public class RecogniseHandOdd {
	//private static Logger logger=LoggerFactory.getLogger(RecogniseHandOdd.class);
	public static void main(String[] arg) {
		final Card[] cardArr = new Card[7];
		cardArr[0] = Card.newCard(10);
		cardArr[1] = Card.newCard(11);

		cardArr[2] = Card.newCard(35);
		cardArr[3] = Card.newCard(39);
		cardArr[4] = Card.newCard(43);
		cardArr[5] = Card.newCard(47);
		cardArr[6] = Card.newCard(51);

		final Card[] cardArr1 = new Card[7];
		cardArr1[0] = Card.newCard(0);
		cardArr1[1] = Card.newCard(1);

		cardArr1[2] = Card.newCard(35);
		cardArr1[3] = Card.newCard(39);
		cardArr1[4] = Card.newCard(43);
		cardArr1[5] = Card.newCard(47);
		cardArr1[6] = Card.newCard(51);

		System.out.println(recognise(cardArr).getPokerHandType());
		System.out.println(recognise(cardArr1).getPokerHandType());
	}

	/**
	 * 根据七张牌识别成手最大扑克牌
	 * 
	 * @param cardArr
	 * @return
	 */
	public static PokerHandBaseOdds recogniseOptimized(final Card[] cardArr) {
		Arrays.sort(cardArr);// 自然排序升序---小牌面�?的在前面
		Recognise r = new Recognise(cardArr);
		switch (r.getValueSize()) {
		case 2:
			return getPokerHandUnrecognised(PokerHandType.FOUR_OF_A_KIND, r);
		case 3:
			return getMaxSameValueCardsCount(r.getValueMap()) == 4 ? getPokerHandUnrecognised(
					PokerHandType.FOUR_OF_A_KIND, r)
					: getPokerHandUnrecognised(PokerHandType.FULL_HOUSE, r);
		case 4:
			int max = getMaxSameValueCardsCount(r.getValueMap());
			return (max == 4) ? getPokerHandUnrecognised(
					PokerHandType.FOUR_OF_A_KIND, r)
					: (max == 3) ? getPokerHandUnrecognised(
							PokerHandType.FULL_HOUSE, r)
							: getPokerHandUnrecognised(PokerHandType.TWO_PAIR,
									r);
		case 5:
			r.initSuitMap();
			List<Card> suitLi = getFlushCards(r);
			if (suitLi == null) {
				if (getStraightCards(r)) {
					return getPokerHandUnrecognised(PokerHandType.STRAIGHT, r);
				}
				max = getMaxSameValueCardsCount(r.getValueMap());
				return max == 3 ? getPokerHandUnrecognised(
						PokerHandType.THREE_OF_A_KIND, r)
						: getPokerHandUnrecognised(PokerHandType.TWO_PAIR, r);
			}
			return getSameSuitPokerHand(suitLi);
		case 6:
			r.initSuitMap();
			suitLi = getFlushCards(r);
			if (suitLi == null) {
				if (getStraightCards(r)) {
					return getPokerHandUnrecognised(PokerHandType.STRAIGHT, r);
				}
				return getPokerHandUnrecognised(PokerHandType.PAIR, r);
			}
			return getSameSuitPokerHand(suitLi);
		case 7:
			r.initSuitMap();
			suitLi = getFlushCards(r);
			if (suitLi == null) {
				if (getStraightCards(r)) {
					return getPokerHandUnrecognised(PokerHandType.STRAIGHT, r);
				}
				return getPokerHandRecognised(PokerHandType.HIGH_CARD, Arrays
						.asList(cardArr[6], cardArr[5], cardArr[4], cardArr[3],
								cardArr[2]));
			}
			return getSameSuitPokerHand(suitLi);
		default:
			return getPokerHandRecognised(PokerHandType.ROYAL_FLUSH, null);
		}
	}

	private static PokerHandBaseOdds getSameSuitPokerHand(
			final List<Card> suitLi) {
		int suitLiSize = suitLi.size();
		List<Card> suitStraightLi = getStraightCardsSuit(suitLi
				.toArray(new Card[suitLiSize]));
		return (suitStraightLi == null) ? getPokerHandRecognised(
				PokerHandType.FLUSH, suitLiSize > 5 ? suitLi.subList(
						suitLiSize - 5, suitLiSize) : suitLi)
				: (suitStraightLi.get(suitStraightLi.size() - 1).getValue() == TexasConstant.CardValueType.TEN
						.getValue()) ? getPokerHandRecognised(
						PokerHandType.ROYAL_FLUSH, suitStraightLi)
						: getPokerHandRecognised(PokerHandType.STRAIGHT_FLUSH,
								suitStraightLi);
	}

	/**
	 * 根据七张牌识别成手最大扑克牌
	 * 
	 * @param cardArr
	 * @return
	 */
	public static PokerHandBaseOdds recognise(final Card[] cardArr) {
		Arrays.sort(cardArr);// 自然排序升序---小牌面�?的在前面
		Recognise r = new Recognise(cardArr);
		// 1 是否同花及其同花�?-此时不可能有四条和葫�?--故就是最大的�?
		r.initSuitMap();
		List<Card> suitLi = getFlushCards(r);
		if (suitLi == null) {
			// return new InvalidHand();
			// r.initValueMap();
			// 3 判断牌�?处理
			int max = getMaxSameValueCardsCount(r.getValueMap());
			if (max == 4) {// 四条
				return getPokerHandUnrecognised(PokerHandType.FOUR_OF_A_KIND, r);
			}
			if (max == 3 && r.getValueSize() < 5) {
				// 葫芦
				return getPokerHandUnrecognised(PokerHandType.FULL_HOUSE, r);
			}
			if (r.getValueSize() >= 5 && getStraightCards(r)) {
				// 顺子
				return getPokerHandUnrecognised(PokerHandType.STRAIGHT, r);
			}
			if (max == 3 && r.getValueSize() == 5) {// 三条
				return getPokerHandUnrecognised(PokerHandType.THREE_OF_A_KIND,
						r);
			}
			if (max == 2) {// 两对或是�?��
				if (r.getValueSize() == 4 || r.getValueSize() == 5) {// 两对(三对中的两对)
					return getPokerHandUnrecognised(PokerHandType.TWO_PAIR, r);
				}
				if (r.getValueSize() == 6) {// �?��
					return getPokerHandUnrecognised(PokerHandType.PAIR, r);
				}
			}
			// 高牌
			return getPokerHandRecognised(PokerHandType.HIGH_CARD, Arrays
					.asList(cardArr[6], cardArr[5], cardArr[4], cardArr[3],
							cardArr[2]));
		} else {
			// 2 是否有顺�?-此时不可能有四条和葫�?--故就是最大的�?
			int suitLiSize = suitLi.size();
			List<Card> suitStraightLi = getStraightCardsSuit(suitLi
					.toArray(new Card[suitLiSize]));
			if (suitStraightLi == null) {// 同花
				return getPokerHandRecognised(PokerHandType.FLUSH,
						suitLiSize > 5 ? suitLi.subList(suitLiSize - 5,
								suitLiSize) : suitLi);
			} else {// 同花�?
				if (suitStraightLi.get(suitStraightLi.size() - 1).getValue() == TexasConstant.CardValueType.TEN
						.getValue()) {// 皇家同花�?
					return getPokerHandRecognised(PokerHandType.ROYAL_FLUSH,
							suitStraightLi);
				}
				// 同花�?
				return getPokerHandRecognised(PokerHandType.STRAIGHT_FLUSH,
						suitStraightLi);
			}
		}
	}

	private static PokerHandBaseOdds getPokerHandUnrecognised(
			PokerHandType handType, final Recognise recognise) {
		try {
			PokerHandBaseOdds poherHand = (PokerHandBaseOdds) PokerHandInstanceCache
					.get(handType).clone();
			poherHand.setRecoge(recognise);
			return poherHand;
		} catch (CloneNotSupportedException e) {
			//logger.error(e.getMessage(), e);
		}
		return null;
	}

	private static PokerHandBaseOdds getPokerHandRecognised(
			PokerHandType handType, List<Card> cardList) {
		try {
			PokerHandBaseOdds poherHand = (PokerHandBaseOdds) PokerHandInstanceCache
					.get(handType).clone();
			poherHand.setCards(cardList);
			poherHand.setUnrecognised(false);
			return poherHand;
		} catch (CloneNotSupportedException e) {
			//logger.error(e.getMessage(), e);
		}
		return null;
	}

	private final static Map<PokerHandType, PokerHandBaseOdds> PokerHandInstanceCache = new HashMap<PokerHandType, PokerHandBaseOdds>(
			16);

	static {
		for (PokerHandType handType : TexasConstant.PokerHandType.values()) {
			switch (handType) {
			case HIGH_CARD:
				PokerHandInstanceCache
						.put(
								handType,
								prepareClassObject("com.texas.poker.oddscalcu.handtype.HighCardOdds"));
				break;
			case PAIR:
				PokerHandInstanceCache
						.put(
								handType,
								prepareClassObject("com.texas.poker.oddscalcu.handtype.PairOdds"));
				break;
			case TWO_PAIR:
				PokerHandInstanceCache
						.put(
								handType,
								prepareClassObject("com.texas.poker.oddscalcu.handtype.TwoPairOdds"));
				break;
			case THREE_OF_A_KIND:
				PokerHandInstanceCache
						.put(
								handType,
								prepareClassObject("com.texas.poker.oddscalcu.handtype.ThreeKindOdds"));
				break;
			case STRAIGHT:
				PokerHandInstanceCache
						.put(
								handType,
								prepareClassObject("com.texas.poker.oddscalcu.handtype.StraightOdds"));
				break;
			case FLUSH:
				PokerHandInstanceCache
						.put(
								handType,
								prepareClassObject("com.texas.poker.oddscalcu.handtype.FlushOdds"));
				break;
			case FULL_HOUSE:
				PokerHandInstanceCache
						.put(
								handType,
								prepareClassObject("com.texas.poker.oddscalcu.handtype.FullHouseOdds"));
				break;
			case FOUR_OF_A_KIND:
				PokerHandInstanceCache
						.put(
								handType,
								prepareClassObject("com.texas.poker.oddscalcu.handtype.FourKindOdds"));
				break;
			case STRAIGHT_FLUSH:
				PokerHandInstanceCache
						.put(
								handType,
								prepareClassObject("com.texas.poker.oddscalcu.handtype.StraightFlushOdds"));
				break;
			case ROYAL_FLUSH:
				PokerHandInstanceCache
						.put(
								handType,
								prepareClassObject("com.texas.poker.oddscalcu.handtype.RoyalFlushOdds"));
				break;
			default:
				PokerHandInstanceCache
						.put(
								handType,
								prepareClassObject("com.texas.poker.oddscalcu.handtype.InvalidHandOdds"));
				break;
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static PokerHandBaseOdds prepareClassObject(String className) {
		try {
			Class clazz = Class.forName(className);
			if (clazz != null) {
				Object o = clazz.newInstance();
				return (PokerHandBaseOdds) o;
			}
		} catch (ClassNotFoundException e) {
			//logger.error(e.getMessage(), e);
		} catch (InstantiationException e) {
			//logger.error(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			//logger.error(e.getMessage(), e);
		}
		return null;
	}

	private static void printCard(Card[] cardArr) {
		StringBuffer sb = new StringBuffer();
		for (Card c : cardArr) {
			sb.append(TexasConstant.CardSuitMap.get(c.getSuit())).append(" ")
					.append(TexasConstant.CardValueMap.get(c.getValue()))
					.append(",");
		}
		System.out.println(sb.toString());
	}

	/**
	 * 重复牌的�?��数目
	 * 
	 * @param valueMap
	 * @return
	 */
	private static int getMaxSameValueCardsCount(
			final Map<Integer, List<Card>> valueMap) {
		int max = 0;
		for (List<Card> lic : valueMap.values()) {
			max = lic.size() > max ? lic.size() : max;
		}
		return max;
	}

	/**
	 * 是否是同�?如有同花返回同花列表,如无返回NULL
	 * 
	 * @param suitMap
	 * @return
	 */
	private static List<Card> getFlushCards(final Recognise r) {
		if (r.getSuitSize() == 4)
			return null;
		for (List<Card> lic : r.getSuitMap().values()) {
			if (lic.size() >= TexasConstant.POKER_HAND_NUM) {
				return lic;
			}
		}
		return null;
	}

	/**
	 * 如有顺子返回�?��的顺子牌�?无返回NULL
	 * 
	 * @param cardArr
	 *            --升序牌数�?
	 * @return
	 */
	private static boolean getStraightCards(final Recognise r) {
		final Card[] cardArr = new Card[r.getValueSize()];
		int count = 0;
		for (List<Card> cardList : r.getValueMap().values()) {
			cardArr[count++] = cardList.get(0);
		}
		Arrays.sort(cardArr);
		count = cardArr.length >> 1;
		if (cardArr[count].compareTo(cardArr[count - 1]) == 1) {
			count = 0;
			for (int i = cardArr.length - 1; i > 0 && count < 4; i--) {// 遍历�?��
				if (cardArr[i].compareTo(cardArr[i - 1]) == 1) {
					count++;
				} else if (count < 4) {
					count = 0;
				}
			}
			if (count >= 4
					|| count == 3
					&& cardArr[0].getValue() == CardValueType.TWO.getValue()
					&& cardArr[cardArr.length - 1].getValue() == CardValueType.A
							.getValue()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 如有顺子返回�?��的顺子牌�?无返回NULL
	 * 
	 * @param cardArr
	 *            --升序牌数�?
	 * @return
	 */
	private static List<Card> getStraightCardsSuit(Card[] cardArr) {
		// Arrays.sort(cardArr);
		int count = cardArr.length >> 1;
		if (cardArr[count].compareTo(cardArr[count - 1]) == 1) {
			count = 0;
			int pos = -1;
			for (int i = cardArr.length - 1; i > 0 && count < 4; i--) {// 遍历�?��
				if (cardArr[i].compareTo(cardArr[i - 1]) == 1) {
					count++;
					if (count == 1) {
						pos = i;
					}
				} else if (count < 4) {
					count = 0;
				}
			}
			if (count >= 4) {
				List<Card> cli = new ArrayList<Card>(5);
				cli.add(cardArr[pos]);
				cli.add(cardArr[pos - 1]);
				cli.add(cardArr[pos - 2]);
				cli.add(cardArr[pos - 3]);
				cli.add(cardArr[pos - 4]);
				return cli;
			}
			if (count == 3
					&& cardArr[0].getValue() == CardValueType.TWO.getValue()
					&& cardArr[cardArr.length - 1].getValue() == CardValueType.A
							.getValue()) {
				List<Card> cli = new ArrayList<Card>(5);
				cli.add(cardArr[cardArr.length - 1]);
				cli.add(cardArr[0]);
				cli.add(cardArr[1]);
				cli.add(cardArr[2]);
				cli.add(cardArr[3]);
				return cli;
			}
		}
		return null;
	}

	public static class Recognise {

		private final Map<Integer, List<Card>> valueMap;

		private Map<Integer, List<Card>> suitMap;

		private final int valueSize;

		private int suitSize;

		private final Card[] cardArr;

		public Recognise(final Card[] cardArr) {
			this.cardArr = cardArr;
			valueMap = new HashMap<Integer, List<Card>>();
			for (Card card : cardArr) {
				if (valueMap.get(card.getValue()) == null) {
					List<Card> cl = new ArrayList<Card>(4);
					cl.add(card);
					valueMap.put(card.getValue(), cl);
				} else {
					valueMap.get(card.getValue()).add(card);
				}
			}
			valueSize = valueMap.size();
		}

		protected void initSuitMap() {
			suitMap = new HashMap<Integer, List<Card>>(6);
			for (Card card : cardArr) {
				if (suitMap.get(card.getSuit()) == null) {
					List<Card> c1 = new ArrayList<Card>(7);
					c1.add(card);
					suitMap.put(card.getSuit(), c1);
				} else {
					suitMap.get(card.getSuit()).add(card);
				}
			}
			suitSize = suitMap.size();
		}

		/**
		 * @return the valueMap
		 */
		public Map<Integer, List<Card>> getValueMap() {
			return valueMap;
		}

		/**
		 * @return the suitMap
		 */
		protected Map<Integer, List<Card>> getSuitMap() {
			return suitMap;
		}

		/**
		 * @return the valueSize
		 */
		public int getValueSize() {
			return valueSize;
		}

		/**
		 * @return the suitSize
		 */
		protected int getSuitSize() {
			return suitSize;
		}

		/**
		 * @return the cardArr
		 */
		public Card[] getCardArr() {
			return cardArr;
		}

	}

}
