package com.edu.casino.blackjack;

import java.util.ArrayList;

public class cardZone {
	private static cardZone instance;
	private ArrayList<CardOne>  cp;
	
	private cardZone() {
		cp= new ArrayList<CardOne>();
		
	}
	
	public static cardZone getinstance() {
		if(instance ==null) {
			instance = new cardZone();
		}
		return instance;
	}
	
	public CardOne getOneCard() {
		int cardnum =(int)( Math.random() * cp.size() ) ;
		CardOne card = cp.get(cardnum);
		cp.remove(cardnum);
		return card;
	}
	public int size() {
		return cp.size();
	}
	
}
