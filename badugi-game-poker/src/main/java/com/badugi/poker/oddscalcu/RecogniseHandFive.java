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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badugi.poker.Card;
import com.badugi.poker.TexasConstant;
import com.badugi.poker.TexasConstant.CardValueType;
import com.badugi.poker.pokerhand.PokerHandBase;
import com.badugi.poker.pokerhand.handtype.Flush;
import com.badugi.poker.pokerhand.handtype.FourKind;
import com.badugi.poker.pokerhand.handtype.FullHouse;
import com.badugi.poker.pokerhand.handtype.HighCard;
import com.badugi.poker.pokerhand.handtype.InvalidHand;
import com.badugi.poker.pokerhand.handtype.Pair;
import com.badugi.poker.pokerhand.handtype.RoyalFlush;
import com.badugi.poker.pokerhand.handtype.Straight;
import com.badugi.poker.pokerhand.handtype.StraightFlush;
import com.badugi.poker.pokerhand.handtype.ThreeKind;
import com.badugi.poker.pokerhand.handtype.TwoPair;

/**
 *
 * 缓存计算使用
 *
 * @author yuesheng.yin
 *
 */
public class RecogniseHandFive {

	/**
	 * 五张扑克牌中
	 *
	 * @param cardArr
	 * @return
	 */
	public static PokerHandBase recogniseFiveCard(
			final Card... cardArr) {
		if (isInvalidHand(cardArr)) {
			return InvalidHand.getInstance();
		}
		Arrays.sort(cardArr);// 自然排序升序---小牌面�?的在前面
		Map<Integer, List<Card>> suitMap = getSuitMap(cardArr);
		// 1 是否同花及其同花�?-此时不可能有四条和葫�?--故就是最大的�?
		if (suitMap.size() == 1) {// 具有同花
			List<Card> suitStraightLi = getStraightCards(cardArr);
			if (suitStraightLi != null) {// 同花�?
				if (suitStraightLi.get(suitStraightLi.size() - 1).getValue() == TexasConstant.CardValueType.TEN
						.getValue()) {// 皇家同花�?
					return new RoyalFlush(suitStraightLi);
				}
				// 同花�?
				return new StraightFlush(suitStraightLi);
			} // 同花
			return new Flush(suitMap.get(cardArr[0].getSuit()));
		}
		// 2 是否有顺�?-此时不可能有四条和葫�?--故就是最大的�?
		List<Card> straightLi = getStraightCards(cardArr);
		if (straightLi != null) {// 顺子
			return new Straight(straightLi);
		}

		// 3 判断牌�?处理
		Map<Integer, List<Card>> valueMap = getCardValueMap(cardArr);
		int valueMapSize = valueMap.size();
		int max = getMaxSameValueCardsCount(valueMap);
		if (max == 4) {// 四条
			return new FourKind(getFourKindCards(valueMap, cardArr));
		}
		if (max == 3) {// 葫芦或是三条
			if (valueMapSize == 3) {// 三条
				return new ThreeKind(getThreeKindCards(valueMap, cardArr));
			}
			return new FullHouse(getFullHouseCards(valueMap,cardArr));// 葫芦
		}
		if (max == 2) {// 两对或是�?��
			if (valueMapSize == 3) {// 两对(三对中的两对)
				return new TwoPair(getTwoPairCards1(valueMap, cardArr));
			}
			return new Pair(getPairCards(valueMap, cardArr));
		}
		// 高牌
		return new HighCard(cardArr[4], cardArr[3], cardArr[2], cardArr[1], cardArr[0]);
	}
	private static List<Card> getFourKindCards(
			final Map<Integer, List<Card>> valueMap, final Card[] cardArr) {
		Collection<List<Card>> clic = valueMap.values();
		for (List<Card> lic : clic) {
			if (lic.size() == 4) {// 存在四条
				if (lic.get(0).getValue() == cardArr[cardArr.length - 1]
						.getValue()) {
					lic.add(cardArr[cardArr.length - 5]);
				} else {
					lic.add(cardArr[cardArr.length - 1]);
				}
				return lic;
			}
		}
		return null;
	}
	private static List<Card> getThreeKindCards(
			final Map<Integer, List<Card>> valueMap, final Card[] cardArr) {
		Collection<List<Card>> clic = valueMap.values();
		for (List<Card> lic : clic) {
			if (lic.size() == 3) {//
				int j = 0;
				for (int i = cardArr.length - 1; i >= 0 && j < 2; i--) {
					if (cardArr[i].getValue() == lic.get(0).getValue())
						continue;
					lic.add(cardArr[i]);
					j++;
				}
				return lic;
			}
		}
		return null;
	}
	private static List<Card> getFullHouseCards(
			final Map<Integer, List<Card>> valueMap, final Card[] cardArr) {
		Collection<List<Card>> clic = valueMap.values();
		List<Card> licnew = new ArrayList<Card>(5);
		List<Card> lic1 = null, lic2 = null;
		int i = 0;
		for (List<Card> lic : clic) {
			if (lic.size() == 3) {//
				if (i == 0) {
					lic1 = lic;
					i++;
				}
			}else if(lic.size()==2){
				lic2=lic;
			}
		}
		if(lic1!=null&&lic2!=null){
			licnew.addAll(lic1);// �?��三条
			licnew.addAll(lic2);
		}else{
			return null;
		}

		return licnew;
	}
	private static List<Card> getTwoPairCards1(
			final Map<Integer, List<Card>> valueMap, final Card[] cardArr) {
		Collection<List<Card>> clic = valueMap.values();
		List<Card> licnew = new ArrayList<Card>(5);
		List<Card> lic1 = null, lic2 = null;
		int i = 0;
		for (List<Card> lic : clic) {
			if (lic.size() == 2) {//
				if (i == 0) {
					lic1 = lic;
					i++;
				} else {
					lic2 = lic;
					break;
				}
			}
		}
		licnew.addAll(lic1.get(0).compareTo(lic2.get(0)) > 0 ? lic1 : lic2);
		licnew.addAll(lic1.get(0).compareTo(lic2.get(0)) < 0 ? lic1 : lic2);
		int k = 0;
		for (int j = cardArr.length - 1; j >= 0 && k < 1; j--) {
			if (cardArr[j].getValue() == lic1.get(0).getValue()
					|| cardArr[j].getValue() == lic2.get(0).getValue())
				continue;
			licnew.add(cardArr[j]);
			k++;
		}
		return licnew;
	}
	private static List<Card> getPairCards(
			final Map<Integer, List<Card>> valueMap, final Card[] cardArr) {
		Collection<List<Card>> clic = valueMap.values();
		for (List<Card> lic : clic) {
			if (lic.size() == 2) {//
				int j = 0;
				for (int i = cardArr.length - 1; i >= 0 && j < 3; i--) {
					if (cardArr[i].getValue() == lic.get(0).getValue())
						continue;
					lic.add(cardArr[i]);
					j++;
				}
				return lic;
			}
		}
		return null;
	}
	public static boolean isInvalidHand(final Card... cardArr){
		if (cardArr != null && cardArr.length == TexasConstant.POKER_HAND_NUM){
			for(Card card : cardArr){
				if(card.getSerialNo() == -1){
					return true;
				}
			}
			return false;
		}
		return true;
	}

	public static void main(String[] arg) {
		int[] is = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
				17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32,
				33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48,
				49, 50, 51 };

			 PokerHandBase ph = recogniseFiveCard(Card.newCard(is[0]), Card.newCard(is[1]),Card.newCard(is[2]), Card.newCard(is[3]), Card.newCard(is[4]));
			 System.out.println(ph.getPokerHandType());
			 System.out.println(ph.getCardStr());
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
	 * 如有顺子返回�?��的顺子牌�?无返回NULL
	 *
	 * @param cardArr
	 *            --升序牌数�?
	 * @return
	 */
	private static List<Card> getStraightCards(Card[] cardArr) {
		Map<Integer, Card> filterMap = new HashMap<Integer, Card>(10);
		for (Card card : cardArr) {
			if (filterMap.get(card.getValue()) == null)
				filterMap.put(card.getValue(), card);
		}
		if (filterMap.size() < TexasConstant.POKER_HAND_NUM) {
			return null;
		}
		cardArr = new Card[filterMap.size()];
		int c = 0;
		for (Card card : filterMap.values()) {
			cardArr[c++] = card;
		}
		Arrays.sort(cardArr);
		int count = 0;
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
		return null;
	}

	// 根据花色分类的Map
	private static Map<Integer, List<Card>> getSuitMap(final Card[] cardArr) {
		Map<Integer, List<Card>> suitMap = new HashMap<Integer, List<Card>>(8);
		List<Card> cardList = null;
		for (Card card : cardArr) {
			cardList = suitMap.get(card.getSuit());
			if (suitMap.get(card.getSuit()) == null) {
				cardList = new ArrayList<Card>(5);
				cardList.add(card);
				suitMap.put(card.getSuit(), cardList);
				continue;
			}
			cardList.add(card);
		}
		return suitMap;
	}

	// 根据牌面值分类的Map
	private static Map<Integer, List<Card>> getCardValueMap(final Card[] cardArr) {
		Map<Integer, List<Card>> valueMap = new HashMap<Integer, List<Card>>(8);
		for (Card card : cardArr) {
			if (valueMap.get(card.getValue()) == null) {
				List<Card> cl = new ArrayList<Card>();
				cl.add(card);
				valueMap.put(card.getValue(), cl);
				continue;
			}
			valueMap.get(card.getValue()).add(card);
		}
		return valueMap;
	}

}
