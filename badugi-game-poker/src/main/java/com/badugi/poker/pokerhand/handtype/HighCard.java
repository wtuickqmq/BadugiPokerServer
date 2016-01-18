/**
 * 深圳市辰富科技有限公司 .inc
 * Texas Poker Game App V1.0
 */
/**
 * author  yuesheng.yin
 * createTime 2011-1-21下午03:35:45
 */
package com.badugi.poker.pokerhand.handtype;
import com.badugi.poker.Card;
import com.badugi.poker.TexasConstant;
import com.badugi.poker.TexasConstant.PokerHandType;
import com.badugi.poker.pokerhand.PokerHandBase;


/**
 * 高牌
 * 
 * @author yuesheng.yin
 * 
 */
public class HighCard extends PokerHandBase implements Cloneable {

	private static final long serialVersionUID = 742470822385062272L;

	public HighCard(Card... card) {
		super.setCards(card);
	}
	
	public HighCard() {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.texas.logic.pokerhand.PokerHand#getPokerHandType()
	 */
	@Override
	public PokerHandType getPokerHandType() {
		// TODO Auto-generated method stub
		return PokerHandType.HIGH_CARD;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(PokerHandBase o) {
		if (getPokerHandType().getValue() != o.getPokerHandType().getValue())
			return getPokerHandType().getValue() - o.getPokerHandType().getValue();
		for (int i = 0; i < TexasConstant.POKER_HAND_NUM; i++) {
			if (super.getCard(i).compareTo(o.getCard(i)) == 0)
				continue;
			return super.getCard(i).compareTo(o.getCard(i));
		}
		return 0;// 同种类型的牌的比对规则
	}
	
	@Override
	protected Object clone() {
		HighCard flush = null;
		try {
			flush = (HighCard) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return flush;
	}

}
