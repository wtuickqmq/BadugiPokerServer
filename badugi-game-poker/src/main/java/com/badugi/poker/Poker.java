/**
 * 深圳市辰富科�?��限公�?.inc
 * Texas Poker Game App V1.0
 */
/**
 * author  yuesheng.yin
 * createTime 2011-1-21上午11:38:26
 */
package com.badugi.poker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Poker implements Serializable {

	private static final long serialVersionUID = 7778264351729110994L;

	private final List<Integer> cardList = new ArrayList<Integer>(52);
	
	private int specialCardFlag = 0;

	/** 随机类�? */
	private final Random random = new Random();

	public Poker() {
		this.specialCardFlag = 0;
		inflater();// 生成扑克
	}
	
	
	public Poker(int specialCard) {
		this.specialCardFlag = specialCard;
		inflater();// 生成扑克
	}



	/** 生成�?��扑克牌，�?~51. 0-3 分别表示出一种花�?*/
	public void inflater() {
		cardList.clear();
		if (specialCardFlag == 1) {
		    for (int i = 0; i < TexasConstant.CARD_NUM - 12; i++) {
				cardList.add(i + 12);
			}
			return;
		}
		
		//测试用，生成9张扑克
		/*for (int i = 0; i < TexasConstant.CARD_NUM - 35; i++) {
			cardList.add(i + 12);
		}*/
	

		for (int i = 0; i < TexasConstant.CARD_NUM; i++) {
			cardList.add(i);
		}
		//切牌数量，当为52张时切25张，当为40张时切15张;
		/*int CutCards=cardList.size()==52?25:15;
		for(int i=0;i<CutCards;i++)
		{
			pullOut();
		}*/
	}

	/**
	 * 随机抽出�?���?
	 *
	 * @return
	 */
	public Card pullOut() {
		int pos = random.nextInt(cardList.size());
		int serialNo = cardList.get(pos);
		// Card card = new Card(serialNo);
		Card card = Card.newCard(serialNo);
	
		cardList.remove(pos);
		return card;
	}
	
	/**
	 * 随机抽出5张牌
	 *
	 * @return
	 */
	public Card[] pullOutFiveCard() {
		//Logger logger = Logger.getLogger(Poker.class);
		List<Integer> newCardList = new ArrayList<Integer>();
		Card[] cards = new Card[5];
		for(int i = 0; i < 5; i++){
			int pos = random.nextInt(cardList.size());
			int serialNo = cardList.get(pos);
			newCardList.add(serialNo);
			cards[i] = Card.newCard(serialNo);
			cardList.remove(pos);
		}
		
		cardList.clear();
		cardList.addAll(newCardList);
		//logger.info("pullOutFiveCard cardList = " + cardList);
		return cards;
	}
	
	
	public static void main(String[] args) {
		Poker poker = new Poker(1);
		for (int i = 0; i < 23; i++) {
			poker.pullOut();
		}
	}

}
