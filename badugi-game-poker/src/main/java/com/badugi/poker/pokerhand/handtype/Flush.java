/**
 * 深圳市辰富科技有限公司 .inc
 * Texas Poker Game App V1.0
 */
/**
 * author  yuesheng.yin
 * createTime 2011-1-21下午03:56:38
 */
package com.badugi.poker.pokerhand.handtype;

import java.util.Collections;
import java.util.List;

import com.badugi.poker.Card;
import com.badugi.poker.TexasConstant;
import com.badugi.poker.TexasConstant.PokerHandType;
import com.badugi.poker.pokerhand.PokerHandBase;

/**
 * 同花(同一花色)
 * 
 * @author yuesheng.yin
 * 
 */
public class Flush extends PokerHandBase implements Cloneable {

	/**
	 * 同花的牌序按照自然顺序存放
	 */
	private static final long serialVersionUID = -5978840386776258770L;

	public Flush(List<Card> cardLi) {
		Collections.reverse(cardLi);
		super.setCards(cardLi.toArray(new Card[cardLi.size()]));
	}

	public Flush() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.texas.logic.pokerhand.PokerHand#getPokerHandType()
	 */
	@Override
	public PokerHandType getPokerHandType() {
		// TODO Auto-generated method stub
		return PokerHandType.FLUSH;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(PokerHandBase o) {
		if (getPokerHandType().getValue() != o.getPokerHandType().getValue())
			return getPokerHandType().getValue()
					- o.getPokerHandType().getValue();
		for (int i = 0; i < TexasConstant.POKER_HAND_NUM; i++) {
			if (super.getCard(i).compareTo(o.getCard(i)) == 0)
				continue;
			return super.getCard(i).compareTo(o.getCard(i));
		}
		return 0;// 同种类型的牌的比对规则
	}

	@Override
	protected Object clone() {
		Flush flush = null;
		try {
			flush = (Flush) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return flush;
	}

}
