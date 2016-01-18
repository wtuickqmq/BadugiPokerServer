/**
 * 深圳市辰富科技有限公司 .inc
 * Texas Poker Game App V1.0
 */
/**
 * author  yuesheng.yin
 * createTime 2011-1-21下午03:55:15
 */
package com.badugi.poker.pokerhand.handtype;

import java.util.List;

import com.badugi.poker.Card;
import com.badugi.poker.TexasConstant.PokerHandType;
import com.badugi.poker.pokerhand.PokerHandBase;

/**
 * 三条(三张相同 + 两张单张)
 * 
 * @author yuesheng.yin
 * 
 */
public class ThreeKind extends PokerHandBase implements Cloneable{

	private static final long serialVersionUID = 6837877364649346768L;

	public ThreeKind(List<Card> cardLi) {
		super.setCards(cardLi.toArray(new Card[cardLi.size()]));
	}
	
	public ThreeKind() {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.texas.logic.pokerhand.PokerHand#getPokerHandType()
	 */
	@Override
	public PokerHandType getPokerHandType() {
		// TODO Auto-generated method stub
		return PokerHandType.THREE_OF_A_KIND;
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
			if (super.getCard(3).compareTo(o.getCard(3)) == 0) {
				return super.getCard(4).compareTo(o.getCard(4));
			}
			return super.getCard(3).compareTo(o.getCard(3));
		}
		return super.getCard(0).compareTo(o.getCard(0));
	}
	
	@Override
	protected Object clone() {
		ThreeKind flush = null;
		try {
			flush = (ThreeKind) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return flush;
	}

}
