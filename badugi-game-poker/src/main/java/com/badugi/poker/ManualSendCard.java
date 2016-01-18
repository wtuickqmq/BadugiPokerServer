package com.badugi.poker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * 测试�?
 * 两人:1,2,3,4,5|1,2|1,2
 * 三人:1,2,3,4,5|1,2|1,2|1,2
 */
public class ManualSendCard implements ISendCard {

	//public static Logger logger = Logger.getLogger(ManualSendCard.class);

	private List<List<String>> cardList =  new ArrayList<List<String>>(); //�?��游戏牌列�?

	private int roundCount = 0; // �?��
	private int playerCount = 5;
	private int publicCardCount = 0;

	public ManualSendCard(){
		initCards();
	}

	
	public Card send() {
		if (roundCount < cardList.size()){
			return Card.newCard(cardList.get(roundCount).get(publicCardCount++).trim());
		} else {
			return Card.NULL;
		}
	}

	
	public Card[] sendPreFlopCards() {

		Card[] cards = new Card[] {Card.NULL,Card.NULL};
		if (roundCount < cardList.size()){
			List<String> ls = cardList.get(roundCount);
			if(playerCount < ls.size()){
				cards[0] = Card.newCard(ls.get(playerCount++).trim());
				cards[1] = Card.newCard(ls.get(playerCount++).trim());
			}
		}
		return cards;
	}

	
	public Card[] sendFlopCards() {

		Card[] cards = new Card[]{Card.NULL,Card.NULL,Card.NULL};
		if (roundCount < cardList.size()){
			cards[0] = Card.newCard(cardList.get(roundCount).get(publicCardCount++).trim());
			cards[1] = Card.newCard(cardList.get(roundCount).get(publicCardCount++).trim());
			cards[2] = Card.newCard(cardList.get(roundCount).get(publicCardCount++).trim());
		}
		return cards;
	}

	public Card[] sendFiveCards() {

		Card[] cards = new Card[]{Card.NULL,Card.NULL,Card.NULL,Card.NULL,Card.NULL};
		if (roundCount < cardList.size()){
			cards[0] = Card.newCard(cardList.get(roundCount).get(publicCardCount++).trim());
			cards[1] = Card.newCard(cardList.get(roundCount).get(publicCardCount++).trim());
			cards[2] = Card.newCard(cardList.get(roundCount).get(publicCardCount++).trim());
			cards[3] = Card.newCard(cardList.get(roundCount).get(publicCardCount++).trim());
			cards[4] = Card.newCard(cardList.get(roundCount).get(publicCardCount++).trim());
		}
		return cards;
	}
	
	public Card sendTurnCards() {
		if (roundCount < cardList.size()){
			return Card.newCard(cardList.get(roundCount).get(publicCardCount++).trim());
		} else {
			return Card.NULL;
		}
	}

	
	public Card sendRiverCards() {
		if (roundCount < cardList.size()){
			return Card.newCard(cardList.get(roundCount).get(publicCardCount++).trim());
		} else {
			return Card.NULL;
		}
	}

	
	public void clear() {
		if(++roundCount >= cardList.size()){
			roundCount = 0;
		}
		playerCount = 5;
		publicCardCount = 0;
	}

	private void initCards(){

		String context = "";
//		try {
////			context = FileUtils.file2String(ProjectUtils.getRootPath() + "config/cards.txt");
//
//			logger.debug("---------ManualSendCard:"+context+"--------");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}

		List<String> cardLine = new ArrayList<String>();

		try {
			String classpath=ClassLoader.getSystemResource("").getPath();
			FileReader  fr = new FileReader(classpath+"config/cards.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			do{
				line = br.readLine();
				if(line == null){
					break;
				}
				cardLine.add(line.replaceAll("\\|", ","));
			}while(true);


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for(String cl : cardLine){
			cardList.add(Arrays.asList(cl.split(",")));
		}

	}

	public List<List<String>> getCardList() {
		return cardList;
	}

	public void setCardList(List<List<String>> cardList) {
		this.cardList = cardList;
	}

}
