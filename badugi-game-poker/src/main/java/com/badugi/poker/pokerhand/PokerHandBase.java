/**
 * 深圳市辰富科�?��限公�?.inc
 * Texas Poker Game App V1.0
 */
/**
 * author  yuesheng.yin
 * createTime 2011-1-21下午02:26:32
 */
package com.badugi.poker.pokerhand;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.badugi.poker.Card;
import com.badugi.poker.TexasConstant;
import com.badugi.poker.TexasConstant.PokerHandType;


/**
 * 成手牌超�?
 * 
 * @author yuesheng.yin
 * @param <PokerHand>
 * 
 */
public abstract class PokerHandBase implements Comparable<PokerHandBase>,
		Cloneable, Serializable {

	private static final long serialVersionUID = -1027406300932868527L;

	private final static AtomicInteger autoID = new AtomicInteger(0);

	public int getNewID() {
		this.id = autoID.getAndIncrement();
		return this.id;
	}

	/** 存储牌序号的数组�?*/
	private Card[] cards = { Card.NULL, Card.NULL, Card.NULL, Card.NULL,
			Card.NULL };

	private int id;

	/** 获取当前成手的类型�? */
	public PokerHandType getPokerHandType() {
		return PokerHandType.NULL;
	}

	/**
	 * 获取指定索引号的�?
	 * 
	 * @param index
	 *            - 指定的索引号�?
	 * @return 返回索引号指定的�?如果索引号非法，将返回Card.NULL�?
	 */
	public Card getCard(int index) {
		if (index >= 0 && index < TexasConstant.POKER_HAND_NUM) {
			return cards[index];
		}
		return Card.NULL;
	}

	public String getCardStr() {
		StringBuffer sb = new StringBuffer();
		sb.append(cards[0].getSerialNo()).append(",").append(
				cards[1].getSerialNo()).append(",").append(
				cards[2].getSerialNo()).append(",").append(
				cards[3].getSerialNo()).append(",").append(
				cards[4].getSerialNo());
		return sb.toString();
	}
	
	public String getCardStrBySize() {
		StringBuffer sb = new StringBuffer();
		List<Integer> cardSerialNoList = new ArrayList<Integer>();
		for(int i = 0; i < cards.length; i++){
			cardSerialNoList.add(cards[i].getSerialNo());
		}
		
		Collections.sort(cardSerialNoList);
		
		sb.append(cardSerialNoList.get(0)).append(",").append(
				cardSerialNoList.get(1)).append(",").append(
				cardSerialNoList.get(2)).append(",").append(
				cardSerialNoList.get(3)).append(",").append(
				cardSerialNoList.get(4));
		
		return sb.toString();
	}

	/**
	 * 设置指定的排�?
	 * 
	 * @param index
	 * @param card
	 * @return
	 */
	protected boolean setCard(int index, Card card) {
		if (index < 0 || index >= TexasConstant.POKER_HAND_NUM) {
			return false;
		}
		cards[index] = card;
		return true;
	}

	protected Card[] getCards() {
		return cards;
	}

	protected void setCards(Card[] cards) {
		this.cards = cards;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "type : " + getPokerHandType() + " ; cards : " + getCardDetail();
	}

	private String getCardDetail() {
		StringBuffer sb = new StringBuffer();
		for (Card card : cards) {
			sb.append(card.toString()).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
