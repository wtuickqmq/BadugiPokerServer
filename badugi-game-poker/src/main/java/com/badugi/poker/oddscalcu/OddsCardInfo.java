package com.badugi.poker.oddscalcu;
/**
 * 深圳市辰富科�?��限公�?.inc
 * Texas Poker Game App V1.0
 */


import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import com.badugi.poker.Card;

/**
 * author yuesheng.yin createTime 2012-1-4 下午06:03:59
 */
/**
 * �?��计算的玩家牌信息
 */
public class OddsCardInfo implements Comparable<OddsCardInfo>, Serializable {

	private static final long serialVersionUID = -6751281522898956092L;

	private final static AtomicInteger idCount = new AtomicInteger(0);// 总计算次�?

	private volatile int totalCalcus = 0; // 总计算次�?

	private final AtomicInteger winCounts = new AtomicInteger(0);// 赢的次数

	private final AtomicInteger tieCounts = new AtomicInteger(0);// 平局次数

	private final int[] cards = new int[2];// 两张底牌

	private final int id;

	private final ThreadLocal<PokerHandBaseOdds> pokerHand = new ThreadLocal<PokerHandBaseOdds>();

	private final ThreadLocal<Card[]> SevenCards = new ThreadLocal<Card[]>();

	/**
	 * 用户手中的两张底�?逗号分隔传入
	 * 
	 * @param cards
	 */
	public OddsCardInfo(int serialNo1, int serialNo2) {
		cards[0] = serialNo1;
		cards[1] = serialNo2;
		id = idCount.incrementAndGet();
//		for (int i = 0; i < 10; i++) {
//			counts.put(i, new AtomicInteger(0));
//		}
	}

	/**
	 * @return the totalCalcus
	 */
	public int getTotalCalcus() {
		return totalCalcus;
	}

	/**
	 * @param totalCalcus
	 *            the totalCalcus to set
	 */
	public void setTotalCalcus(int totalCalcus) {
		this.totalCalcus = totalCalcus;
	}

	/**
	 * @return the winCounts
	 */
	public AtomicInteger getWinCounts() {
		return winCounts;
	}

	/**
	 * @return the tieCounts
	 */
	public AtomicInteger getTieCounts() {
		return tieCounts;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	public void reset() {
		this.winCounts.set(0);
		this.tieCounts.set(0);
		this.totalCalcus = 0;
	}

	/**
	 * 设置�?��成手牌的五张扑克�?
	 */
	public void initFiveCards(final Card... cardArr) {
		pokerHand.set(RecogniseHandOdd.recogniseOptimized(cardArr));
	}

	public void initSevenCards(final Card... cardArr) {
		Arrays.sort(cardArr);
		SevenCards.set(cardArr);
	}

	/**
	 * @return the sevenCards
	 */
	public Card[] getSevenCardsArr() {
		return SevenCards.get();
	}

	public int compareTo(OddsCardInfo odds) {
		return this.pokerHand.get().compareTo(odds.pokerHand.get());
	}

	public int[] getCards() {
		return cards;
	}

	@Override
	public String toString() {
		return Card.newCard(cards[0]) + " , " + Card.newCard(cards[1]);
	}

}