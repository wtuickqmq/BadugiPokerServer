/**
 * 深圳市辰富科技有限公司 .inc
 * Texas Poker Game App V1.0
 */
/**
 * author  yuesheng.yin
 * createTime 2011-1-21下午03:55:45
 */
package com.badugi.poker.pokerhand.handtype;
import java.util.List;

import com.badugi.poker.Card;
import com.badugi.poker.TexasConstant.PokerHandType;
import com.badugi.poker.pokerhand.PokerHandBase;


/**
 * 顺子(花色不一样的顺子)
 * 
 * @author yuesheng.yin
 * 
 */
public class Straight extends PokerHandBase implements Cloneable{

	private static final long serialVersionUID = -6787916968771546096L;

	public Straight(List<Card> cardLi) {
		super.setCards(cardLi.toArray(new Card[cardLi.size()]));
	}
	
	public Straight() {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.texas.logic.pokerhand.PokerHand#getPokerHandType()
	 */
	@Override
	public PokerHandType getPokerHandType() {
		// TODO Auto-generated method stub
		return PokerHandType.STRAIGHT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(PokerHandBase o) {
		if (getPokerHandType().getValue() != o.getPokerHandType().getValue())
			return getPokerHandType().getValue() - o.getPokerHandType().getValue();
		/*
		int size = super.getCard(0).compareTo(o.getCard(0));// 同种类型的牌的比对规则
		if (size < 0 && (o.getCard(0).getValue() == CardValueType.A.getValue()) || size > 0
				&& (super.getCard(0).getValue() == CardValueType.A.getValue())) {
			return -size;
		}
		return size;
		*/
		return super.getCard(2).compareTo(o.getCard(2));
		
	}
	
	@Override
	protected Object clone() {
		Straight flush = null;
		try {
			flush = (Straight) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return flush;
	}

}
