package com.edu.casino.blackjack;

import java.util.ArrayList;

public class DealerRules implements Rules {



	@Override
	public int getState(int cardpackSize, int score) {

		int state = 0;
		if(score > 21 ) {
			state = STATE_BURST;
			//			System.out.printf("【BURST】\n");
		}else if(score == 21 && cardpackSize ==2) {
			state = STATE_BLACK;
			//			System.out.printf("【BLACK JACK】\n");
		}else if(score > D_CHECK ) {
			state = STATE_STAY;
			//			System.out.printf("【STAY】\n");
		}else {

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
		switch (s) {
		case "blind":
			System.out.print(cards.get(0).blindtoString());
			System.out.println(cards.get(1));
			break;
		default:
			for (CardOne card : cards) {
				System.out.print(card);
			}
			System.out.printf("【%d】", calculScore(cards));
			switch (getState(cards.size(), calculScore(cards))) {
			case 0:
				System.out.printf("【OneMoerCard】\n");
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
			break;
		}
	}
}
