/**
 * 深圳市辰富科技有限公司 .inc
 * Texas Poker Game App V1.0
 */
/**
 * author  yuesheng.yin
 * createTime 2011-1-21下午03:51:17
 */
package com.badugi.poker.pokerhand.handtype;

import java.util.List;

import com.badugi.poker.Card;
import com.badugi.poker.TexasConstant.PokerHandType;
import com.badugi.poker.pokerhand.PokerHandBase;

/**
 * 一对
 * 
 * @author yuesheng.yin
 * 
 */
public class Pair extends PokerHandBase implements Cloneable{

	private static final long serialVersionUID = -2449771089276843820L;

	public Pair(List<Card> cardLi) {
		super.setCards(cardLi.toArray(new Card[cardLi.size()]));
	}

	public Pair() {
		
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.texas.logic.pokerhand.PokerHand#getPokerHandType()
	 */
	@Override
	public PokerHandType getPokerHandType() {
		// TODO Auto-generated method stub
		return PokerHandType.PAIR;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(PokerHandBase o) {
		if (getPokerHandType().getValue() != o.getPokerHandType().getValue())
			return getPokerHandType().getValue() - o.getPokerHandType().getValue();
		if (super.getCard(0).compareTo(o.getCard(0)) == 0) {// 同种类型的牌的比对规则
			if (super.getCard(2).compareTo(o.getCard(2)) == 0) {
				if (super.getCard(3).compareTo(o.getCard(3)) == 0) {
					return super.getCard(4).compareTo(o.getCard(4));
				}
				return super.getCard(3).compareTo(o.getCard(3));
			}
			return super.getCard(2).compareTo(o.getCard(2));
		}
		return super.getCard(0).compareTo(o.getCard(0));
	}
	
	@Override
	protected Object clone() {
		Pair flush = null;
		try {
			flush = (Pair) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return flush;
	}

}
