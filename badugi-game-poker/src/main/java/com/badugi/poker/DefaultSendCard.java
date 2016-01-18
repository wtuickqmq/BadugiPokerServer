package com.badugi.poker;

public class DefaultSendCard implements ISendCard {

	private Poker poker;

	public DefaultSendCard(Poker poker) {
		this.poker = poker;
	}

	// 发牌
	public Card send() {
		return poker.pullOut();
	}

	public void clear() {
		poker.inflater();
	}

	public Card[] sendPreFlopCards() {
		Card[] cards = new Card[2];
		cards[0] = poker.pullOut();
		cards[1] = poker.pullOut();
		return cards;
	}

	public Card[] sendFlopCards() {
		Card[] cards = new Card[3];
		cards[0] = poker.pullOut();
		cards[1] = poker.pullOut();
		cards[2] = poker.pullOut();
		return cards;
	}
	
	public Card[] sendFiveCards() {
		return poker.pullOutFiveCard();
	}

	public Card sendRiverCards() {
		return poker.pullOut();
	}

	public Card sendTurnCards() {
		return poker.pullOut();
	}

}
