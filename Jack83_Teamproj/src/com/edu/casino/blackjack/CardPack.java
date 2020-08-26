package com.edu.casino.blackjack;

import java.util.ArrayList;

public class CardPack {
	ArrayList<CardOne> cards;
	ArrayList<CardOne> cardPack;
	public CardPack() {
		// TODO Auto-generated constructor stub
		cardPack = new ArrayList<CardOne>();
		makeCardPack();
	}
	private void makeCardPack() {
		for(int i = 0; i < 4; i++) {
			cards = new ArrayList<CardOne>();
			while(cards.size() < CardOne.SHAPE.length * CardOne.NUMBER.length ) {
				CardOne card = new CardOne();
				if(!cards.contains(card)) {
					cards.add(card);
				}
			}
			cardPack.addAll(cards);
		}
	}

	public CardOne getOneCard() {
		int cardnum =(int)( Math.random() * cardPack.size() ) ;
		CardOne card = cardPack.get(cardnum);
		cardPack.remove(cardnum);
		return card;
	}
	public int size() {
		return cardPack.size();
	}
}
