package com.edu.casino.blackjack;

public class CardOne {
	static final String[] SHAPE = {"♥","♣","♠","◆"} ;
	static final String[] NUMBER = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"} ;
	
	private String card;
	
	
	public CardOne() {
		// TODO Auto-generated constructor stub
		makeCard();
	}
	private void makeCard() {
		int s =(int) (Math.random() * SHAPE.length ) +1;
		int n =(int) (Math.random() *NUMBER.length) +1;
		card = SHAPE[s-1].concat(NUMBER[n-1]);
	}
	
	public void printcard() {
		System.out.println(card);
	}
	@Override
	public String toString() {
		return "【" + card + "】";
	}
	@Override
	public int hashCode() {
		return card.hashCode() + 137;
	}
	public String blindtoString() {
		return "【  ?  】";		
	}
	@Override
	public boolean equals(Object obj) {
		CardOne other = (CardOne)obj;
		boolean isc = (this.card.equals(other))? true : false;
		return isc;
	}
	public String getCardNum() {
		return this.card.substring(1,card.length());
	}
}
