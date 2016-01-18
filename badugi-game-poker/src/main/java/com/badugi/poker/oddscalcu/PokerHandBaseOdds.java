package com.badugi.poker.oddscalcu;
/**
 * 深圳市辰富科�?��限公�?.inc
 * Texas Poker Game App V1.0
 */
/**
 * author  yuesheng.yin
 * createTime 2011-1-21下午02:26:32
 */


import java.io.Serializable;
import java.util.List;

import com.badugi.poker.Card;
import com.badugi.poker.TexasConstant.PokerHandType;
import com.badugi.poker.oddscalcu.RecogniseHandOdd.Recognise;

/**
 * 成手牌超�?
 * 
 * @author yuesheng.yin
 * @param <PokerHand>
 * 
 */
public abstract class PokerHandBaseOdds implements Comparable<PokerHandBaseOdds>,
		Cloneable, Serializable {

	private static final long serialVersionUID = -1027406300932868527L;
	
	//protected  Logger logger = LoggerFactory.getLogger(PokerHandBaseOdds.class);

	/**
	 * 传入的待识别的牌序号
	 */
	private Recognise recoge;

	/**
	 * 是否未识别过
	 */
	private boolean unrecognised = true;

	/**
	 * 识别后的成手牌（5张）
	 */
	private List<Card> cards;

	/**
	 * @return the cards
	 */
	protected List<Card> getCards() {
		return cards;
	}

	/**
	 * @param cards
	 *            the cards to set
	 */
	protected void setCards(List<Card> cards) {
		this.cards = cards;
	}

	/** 获取当前成手的类型�? */
	public abstract PokerHandType getPokerHandType();

	/**
	 * 识别对应牌型中的�?��牌序�?
	 */
	public abstract void recognise();

	public String getCardStr() {
		StringBuffer sb = new StringBuffer();
		return sb.toString();
	}

	@Override
	public String toString() {
		return "type : " + getPokerHandType() + " ; cards : " + getCardDetail();
	}

	

	/**
	 * @return the cards
	 */
	public Card getCard(int i) {
		return cards.get(i);
	}

	
	
	/**
	 * @return the unrecognised
	 */
	public boolean isUnrecognised() {
		return unrecognised;
	}

	/**
	 * @param unrecognised the unrecognised to set
	 */
	public void setUnrecognised(boolean unrecognised) {
		this.unrecognised = unrecognised;
	}

	/**
	 * @return the recoge
	 */
	protected Recognise getRecoge() {
		return recoge;
	}

	/**
	 * @param recoge the recoge to set
	 */
	protected void setRecoge(Recognise recoge) {
		this.recoge = recoge;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
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
