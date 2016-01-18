/**
 * 深圳市辰富科技有限公司 .inc
 * Texas Poker Game App V1.0
 */
/**
 * author  yuesheng.yin
 * createTime 2011-1-21下午03:59:41
 */
package com.badugi.poker.pokerhand.handtype;

import java.util.List;

import com.badugi.poker.Card;
import com.badugi.poker.TexasConstant.PokerHandType;
import com.badugi.poker.pokerhand.PokerHandBase;
/**
 * 皇家同花顺 (同一花色最大的顺子)
 * 
 * @author yuesheng.yin
 * 
 */
public class RoyalFlush extends PokerHandBase implements Cloneable{

	private static final long serialVersionUID = 7002086081577732796L;

	public RoyalFlush(List<Card> cardLi) {
		super.setCards(cardLi.toArray(new Card[cardLi.size()]));
	}
	
	public RoyalFlush() {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.texas.logic.pokerhand.PokerHand#getPokerHandType()
	 */
	@Override
	public PokerHandType getPokerHandType() {
		// TODO Auto-generated method stub
		return PokerHandType.ROYAL_FLUSH;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(PokerHandBase o) {
		if (getPokerHandType().getValue() != o.getPokerHandType().getValue())
			return getPokerHandType().getValue() - o.getPokerHandType().getValue();
		return 0;// 同种类型的牌的比对规则
	}
	
	@Override
	protected Object clone() {
		RoyalFlush flush = null;
		try {
			flush = (RoyalFlush) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return flush;
	}

}
