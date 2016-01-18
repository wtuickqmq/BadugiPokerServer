package com.badugi.poker.oddscalcu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badugi.poker.Card;
import com.badugi.poker.TexasConstant;

/**
 * author yuesheng.yin
 * createTime 2012-1-17 下午04:33:34
 */
/**
 * @author yuesheng.yin
 * 
 */
public class Calculator implements Serializable {

	private static final long serialVersionUID = 3530908503435862734L;

	private final Map<Integer, OddsCardInfo> oddsMap = new HashMap<Integer, OddsCardInfo>(
			12);

	private final Map<Integer, List<Card>> sameSuitMap = new HashMap<Integer, List<Card>>(
			12);

	public Calculator(final OddsCardInfo[] oddsInfo, final int[] cardSerialArr) {
		for (OddsCardInfo odds : oddsInfo) {
			odds.initSevenCards(Card.newCard(cardSerialArr[0]), Card
					.newCard(cardSerialArr[1]), Card.newCard(cardSerialArr[2]),
					Card.newCard(cardSerialArr[3]), Card
							.newCard(cardSerialArr[4]), Card.newCard(odds
							.getCards()[0]), Card.newCard(odds.getCards()[1]));
			oddsMap.put(odds.getId(), odds);
		}
	}

	
	private static List<Card> getSameSuitList(final Card[] cardArr) {
		Map<Integer, List<Card>> suitMap = new HashMap<Integer, List<Card>>(6);
		for (Card card : cardArr) {
			if (suitMap.get(card.getSuit()) == null) {
				List<Card> c1 = new ArrayList<Card>(7);
				c1.add(card);
				suitMap.put(card.getSuit(), c1);
			} else {
				suitMap.get(card.getSuit()).add(card);
			}
		}
		if (suitMap.size() == 4)
			return null;
		for (List<Card> lic : suitMap.values()) {
			if (lic.size() >= TexasConstant.POKER_HAND_NUM) {
				return lic;
			}
		}
		return null;
	}

	private static Map<Integer, List<Card>> getSameValueList(
			final Card[] cardArr) {
		Map<Integer, List<Card>> valueMap = new HashMap<Integer, List<Card>>(10);
		for (Card card : cardArr) {
			if (valueMap.get(card.getValue()) == null) {
				List<Card> cl = new ArrayList<Card>(4);
				cl.add(card);
				valueMap.put(card.getValue(), cl);
			} else {
				valueMap.get(card.getValue()).add(card);
			}
		}
		return valueMap;
	}

	/**
	 * 重复牌的�?��数目
	 * 
	 * @param valueMap
	 * @return
	 */
	private static int getMaxSameValueCardsCount(
			final Map<Integer, List<Card>> valueMap) {
		int max = 0, size = 0;
		for (List<Card> lic : valueMap.values()) {
			size = lic.size();
			max = size > max ? size : max;
		}
		return max;
	}

}
