package com.badugi.poker.oddscalcu;

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
import com.badugi.poker.pokerhand.RecogniseHand;
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

public class RecogniseHandSix {

/**
 * 根据六张牌识别成手最大扑克牌
 *
 * @param cardArr
 * @return
 */
public static PokerHandBase recognise(final Card[] cardArr) {
//	if (cardArr == null
//			|| cardArr.length != TexasConstant.RECOGNISE_CARD_NUM) {
//		return InvalidHand.getInstance();
//	}
	Arrays.sort(cardArr);// 自然排序升序---小牌面�?的在前面
	Map<Integer, List<Card>> suitMap = getSuitMap(cardArr);
	// 1 是否同花及其同花�?-此时不可能有四条和葫�?--故就是最大的�?
	List<Card> suitLi = getFlushCards(suitMap);
	if (suitLi != null) {// 具有同花
		List<Card> suitStraightLi = getStraightCards(suitLi
				.toArray(new Card[suitLi.size()]));
		if (suitStraightLi != null) {// 同花�?
			if (suitStraightLi.get(suitStraightLi.size() - 1).getValue() == TexasConstant.CardValueType.TEN
					.getValue()) {// 皇家同花�?
				return new RoyalFlush(suitStraightLi);
			}
			// 同花�?
			return new StraightFlush(suitStraightLi);
		} // 同花
		return new Flush(suitLi.size() > 5 ? suitLi.subList(
				suitLi.size() - 5, suitLi.size()) : suitLi);
	}
	// 2 是否有顺�?-此时不可能有四条和葫�?--故就是最大的�?
	List<Card> straightLi = getStraightCards(cardArr);
	if (straightLi != null) {// 顺子
		return new Straight(straightLi);
	}

	// 3 判断牌�?处理
	Map<Integer, List<Card>> valueMap = getCardValueMap(cardArr);
	int max = getMaxSameValueCardsCount(valueMap);
	if (max == 4) {// 四条
		return new FourKind(getFourKindCards(valueMap, cardArr));
	}
	if (max == 3) {// 葫芦或是三条
		if (valueMap.size() == 4) {// 三条
			return new ThreeKind(getThreeKindCards(valueMap, cardArr));
		}
		return new FullHouse(getFullHouseCards(valueMap, cardArr));// 葫芦
	}
	if (max == 2) {// 两对或是一对
		if (valueMap.size() == 3) {// 两对(三对中的两对)
			return new TwoPair(getTwoPairCards2(valueMap, cardArr));
		}
		if (valueMap.size() == 4) {// 两对
			return new TwoPair(getTwoPairCards1(valueMap, cardArr));
		}
		if (valueMap.size() == 5) {// �?��
			return new Pair(getPairCards(valueMap, cardArr));
		}
	}
	// 高牌
	return new HighCard(cardArr[5], cardArr[4], cardArr[3], cardArr[2],
			cardArr[1]);
}

public static PokerHandBase recogniseHand(Card[] preFlopcards,
		Card[] afterFlopcards) {
	if (preFlopcards == null || preFlopcards.length != 2
			|| preFlopcards[0] == null || preFlopcards[1] == null) {
		return RecogniseHand.recognise(null);
	}
	if (afterFlopcards == null || afterFlopcards.length != 5
			|| afterFlopcards[0] == null || afterFlopcards[1] == null
			|| afterFlopcards[2] == null || afterFlopcards[3] == null
			|| afterFlopcards[4] == null) {
		return RecogniseHand.recognise(null);
	}
	Card[] cardArr = new Card[7];
	for (int i = 0; i < 5; i++) {
		cardArr[i] = afterFlopcards[i];
	}
	cardArr[5] = preFlopcards[0];
	cardArr[6] = preFlopcards[1];
	return RecogniseHand.recognise(cardArr);
}

public static void main(String[] arg) {
	// for (PokerHandBase ph : PokerHandCache.values()) {
	// System.out.println(ph.getPokerHandType());
	// }
	 PokerHandBase ph, ph1;
	 Card[] card1Arr = new Card[5];
	 System.out.println(Card.newCard(0).toString());//方块
	 System.out.println(Card.newCard(1).toString());//梅花
	 System.out.println(Card.newCard(2).toString());//红桃
	 System.out.println(Card.newCard(3).toString());//黑桃
	 card1Arr[0] = Card.newCard(5);
	 card1Arr[1] = Card.newCard(25);
	 card1Arr[2] = Card.newCard(12);
	 card1Arr[3] = Card.newCard(44);
	 card1Arr[4] = Card.newCard(47);
	 Card[] card1Arr1 = new Card[6];
	 card1Arr1[0] = Card.newCard(35);
	 card1Arr1[1] = Card.newCard(36);
	 card1Arr1[2] = Card.newCard(40);
	 card1Arr1[3] = Card.newCard(47);
	 card1Arr1[4] = Card.newCard(50);
	 card1Arr1[5] = Card.newCard(1);
	 printCard(card1Arr);
	 ph = RecogniseHandFive.recogniseFiveCard(card1Arr);
	 System.out.println(ph.getPokerHandType());
	 System.out.println("---------");
	 printCard(card1Arr1);
	 ph1 = recognise(card1Arr1);
	 System.out.println(ph1.getPokerHandType());
	 System.out.println(ph.compareTo(ph1));
	 System.out.println(ph1.compareTo(ph));
	// System.out.println("---------------");
	//
	// printCard(card1Arr1);
	// ph1 = recognise(card1Arr1);
	// System.out.println(ph1.getPokerHandType());
	// printCard(ph1.getCards());
	//
	// System.out.println(ph.compareTo(ph1));
	// Card[] card2Arr = new Card[5];
	// card2Arr[0] = new Card(27);
	// card2Arr[1] = new Card(25);
	// card2Arr[2] = new Card(44);
	// card2Arr[3] = new Card(28);
	// card2Arr[4] = new Card(13);
	// printCard(card2Arr);
	// cardArr[5] = new Card(26);
	// cardArr[6] = new Card(2);
	// System.out.println(new TwoPair(Arrays.asList(card1Arr)).compareTo(new
	// TwoPair(Arrays.asList(card2Arr))));
	// ph = recognise(cardArr);
	// System.out.println(ph.getPokerHandType());
	// printCard(ph.getCards());
	// for (int j = 0; j < 10; j++) {
	// poker = new Poker();
	// cardArr = new Card[7];
	// for (int i = 0; i < 7; i++) {
	// cardArr[i] = poker.pullOut();
	// ;
	// }
	// printCard(cardArr);
	// ph = recognise(cardArr);
	// System.out.println(ph.getPokerHandType());
	// printCard(ph.getCards());
	// System.out.println("NO" + (j+1)+" : ---------------- END");
	// }
	System.out.println("=-----------ph -----------");
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
 * 两对(三对中的两对)
 *
 * @param valueMap
 * @param cardArr
 * @return
 */
private static List<Card> getTwoPairCards2(
		final Map<Integer, List<Card>> valueMap, final Card[] cardArr) {
	List<Card> licnew = new ArrayList<Card>(5);
		licnew.add(cardArr[cardArr.length - 1]);
		licnew.add(cardArr[cardArr.length - 2]);
		licnew.add(cardArr[cardArr.length - 3]);
		licnew.add(cardArr[cardArr.length - 4]);
		licnew.add(cardArr[cardArr.length - 5]);
	return licnew;
}

/**
 * 两对
 *
 * @param valueMap
 * @param cardArr
 * @return
 */
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

/**
 * �?��
 *
 * @param valueMap
 * @param cardArr
 * @return
 */
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

/**
 * 得到葫芦（一个三�?两对或是两个三条+单张 或是�?��三条+�?�� +两单�?
 *
 * @param valueMap
 * @param cardArr
 * @return
 */
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
			} else {
				lic2 = lic;
				break;
			}
		}
	}
	if (lic2 != null) {// 两个三条+单张
		licnew.addAll(lic1.get(0).compareTo(lic2.get(0)) > 0 ? lic1 : lic2);
		licnew.add(lic1.get(0).compareTo(lic2.get(0)) < 0 ? lic1.get(0)
				: lic2.get(0));
		licnew.add(lic1.get(0).compareTo(lic2.get(0)) < 0 ? lic1.get(1)
				: lic2.get(1));
		return licnew;
	}
	licnew.addAll(lic1);// �?��三条
	for (List<Card> lic : clic) {
		if (lic.size() == 2) {//
			if (i == 1) {
				lic1 = lic;
			}
		}
	}
	if(lic1.size()==2){
		licnew.addAll(lic1);// �?��三条+�?��
	}else{
		return null;
	}
	
	return licnew;
}

/**
 * 三条
 *
 * @param valueMap
 * @param cardArr
 * @return
 */
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

/**
 * 四条
 *
 * @param valueMap
 * @param cardArr
 * @return
 */
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

/**
 * 重复牌的�?��数目
 *
 * @param valueMap
 * @return
 */
private static int getMaxSameValueCardsCount(
		final Map<Integer, List<Card>> valueMap) {
	int max = 0;
	Collection<List<Card>> clic = valueMap.values();
	for (List<Card> lic : clic) {
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
private static List<Card> getFlushCards(
		final Map<Integer, List<Card>> suitMap) {
	if (suitMap.size() == 3)
		return null;
	// Collection<List<Card>> clic = suitMap.values();
	for (List<Card> lic : suitMap.values()) {
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
			cardList = new ArrayList<Card>(7);
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
