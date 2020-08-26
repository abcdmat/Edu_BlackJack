package com.edu.casino.blackjack;

import java.util.ArrayList;
import java.util.List;

public interface Rules {
	static final int D_CHECK = 16;
	static final int STATE_STAY = 1;
	static final int STATE_BURST = 2;
	static final int STATE_BLACK = 3;
	static final double BLACK_JACK_RATE = 2.5;
	static final int PRIZE_RATE = 2;
	
	
	default int calculScore(ArrayList<CardOne> cards) {
		int score = 0;
		int aceNum = 0;
		for(CardOne card : cards) {
			if(card.getCardNum().equals("J") ||  
					card.getCardNum().equals("Q") ||
					card.getCardNum().equals("K") ) {
				score +=10;
			}else if(card.getCardNum().equals("A")) {
				aceNum ++;
			}else {
				score += Integer.parseInt(card.getCardNum());
			}
		}
		if( aceNum != 0 ) {
			int selectOne = score + aceNum;
			int selectElev = score +10 +aceNum;

			if( selectOne ==21 ||  selectElev == 21) {
				score = 21;
			}else if( 21 - selectOne > 21 - selectElev && 21-selectElev >0) {
				score = selectElev;
			}else {
				score = selectOne;
			}

		}
		return score;
	}
	public void print(ArrayList<Object> obj,String name, String s);
	public int getState(int cardpackSize , int score);


	/**
	 * @return 0 = win  1= draw  2 = defeated 
	 * */
	default void isWin(Gamer user, Gamer dealer) {
		System.out.printf("%s", user.getName());
		int result = user.getBetmoney();
		if(user.getState() ==STATE_BLACK) { 				//  플레이어의 상태가 블랙잭일때
			if (dealer.getState() ==STATE_BLACK) {		//  딜러가 블랙잭이면 비기고 나머지 모든 경우에는 승리
				draw();

			}else {
				win();
				result = (int)(user.getBetmoney() * BLACK_JACK_RATE) ;
			}
		}else if(user.getState() ==STATE_BURST){ 	// 플레이어의 상태가 버스트일때
			if (dealer.getState() ==STATE_BURST) { 	// 딜러가 버스트면 비김
				draw();
			}else {																// 딜러가 다른 무슨 상태든지 진다.
				result=0;
				defeated();
			}
		}else {																		//플레이어의 상태가 스테이 일때
			if( dealer.getState() ==STATE_BLACK ) { // 딜러가 블랙잭이면 패배
				result = 0;
				defeated();
			}else if(dealer.getState()!=STATE_BURST){	//딜러가 버스트가 아니면 ( 위에서 블랙잭인 경우는 걸러졌기 때문에) 승부 확인
				if(user.getScore() > dealer.getScore()) {
					win();
					result *= PRIZE_RATE;
				}else if( user.getScore() == dealer.getScore()) {
					draw();
				}else {
					result=0;
					defeated();
				}
			}else {
				result *= PRIZE_RATE;
				win();

			}
		}
		user.setMoney(user.getMoney() +result);
		System.out.printf("《%s》 Bet 【%d$】 《%s》 have【%d$】 \n", 
				user.getName(),user.getBetmoney(), user.getName(), user.getMoney() );

	}
	
	default void win() {
		System.out.printf("is Win!! ");
		System.out.println("Congraturation!");

	}
	default void draw() {
		System.out.printf(" is Draw ");
		System.out.println("too Close");

	}
	default void defeated() {
		System.out.printf(" is Defeated...");
		System.out.println("So bad..");
	}

}
