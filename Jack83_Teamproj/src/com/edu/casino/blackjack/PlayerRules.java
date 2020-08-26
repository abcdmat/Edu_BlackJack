package com.edu.casino.blackjack;

import java.util.ArrayList;

public class PlayerRules implements Rules {

	@Override
	public int getState(int cardPackSize, int score) {
		int state = 0;
		if (score > 21) {
			state = STATE_BURST;
		} else if (score == 21 && cardPackSize == 2) {
			state = STATE_BLACK;
		} else if (score == 21) {
			state = STATE_STAY;
		}
		return state;
	}

	@Override
	public void print(ArrayList<Object> obj, String name, String s) {
		ArrayList<CardOne> cards = new ArrayList<CardOne>();
		for(Object o : obj) {
			cards.add( (CardOne) o);
		}
		// TODO Auto-generated method stub
		System.out.printf("%s's card :", name);
		for (CardOne card : cards) {
			System.out.print(card);
		}
		System.out.printf("【%d】", calculScore(cards));
		switch (getState(cards.size(), calculScore(cards))) {
		case 0:
			System.out.println();
			break;
		case 1:
			System.out.printf("【STAY】\n");
			break;
		case 2:
			System.out.printf("【BURST】\n");
			break;
		case 3:
			System.out.printf("【BLACK JACK】\n");
			break;
		}
	}
}