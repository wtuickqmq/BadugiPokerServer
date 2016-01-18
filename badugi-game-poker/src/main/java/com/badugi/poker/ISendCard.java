package com.badugi.poker;

/**
 * 翻牌接口：执行发�?
 * 
 */
public interface ISendCard {
	// 发牌
	public Card send();
	public Card[] sendPreFlopCards();
	public Card[] sendFlopCards();
	public Card sendTurnCards();
	public Card sendRiverCards();

	public void clear();
	
	public Card[] sendFiveCards();
}
