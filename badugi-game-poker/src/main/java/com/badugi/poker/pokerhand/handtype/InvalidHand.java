/**
 * 深圳市辰富科技有限公司 .inc
 * Texas Poker Game App V1.0
 */
/**
 * author  yuesheng.yin
 * createTime 2011-1-21下午04:53:08
 */
package com.badugi.poker.pokerhand.handtype;

import com.badugi.poker.TexasConstant.PokerHandType;
import com.badugi.poker.pokerhand.PokerHandBase;

/**
 * 非法牌型
 *
 * @author yuesheng.yin
 *
 */
public class InvalidHand extends PokerHandBase implements Cloneable{

	private static final long serialVersionUID = -3784149107567811128L;

	private static InvalidHand invalidHand = new InvalidHand();

	/*
	 * (non-Javadoc)
	 *
	 * @see com.texas.logic.pokerhand.PokerHand#getPokerHandType()
	 */
	@Override
	public PokerHandType getPokerHandType() {
		// TODO Auto-generated method stub
		return PokerHandType.NULL;
	}

	private InvalidHand() {
	}

	public static InvalidHand getInstance(){
		return invalidHand;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(PokerHandBase o) {
		if (o.getPokerHandType().getValue() == this.getPokerHandType().getValue())
			return 0;
		return -1;
	}

	@Override
	protected Object clone() {
		InvalidHand flush = null;
		try {
			flush = (InvalidHand) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return flush;
	}

}
