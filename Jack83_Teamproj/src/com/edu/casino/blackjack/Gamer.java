package com.edu.casino.blackjack;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.edu.database.dto.CasinoDto;

public class Gamer {
	private ArrayList<CardOne> cards;
	private String name;
	private Rules rule;
	private int money;
	private int betmoney;
	private int isState;
	private int score;

	public Gamer() {
		// TODO Auto-generated constructor stub
		cards = new ArrayList<CardOne>();
		this.isState = 0;
		this.name = "Dealer";
		this.rule = new DealerRules();
		this.money = 50000;
		System.out.printf("Players Ready, Play Game.\n");
	}

	public Gamer(CasinoDto dto) {
		// TODO Auto-generated constructor stub
		cards = new ArrayList<CardOne>();
		this.isState = 0;

//		int year = Integer.parseInt(dto.getFIRST_VISIT().substring(0, 4));
//		int month = Integer.parseInt(dto.getFIRST_VISIT().substring(5, 7));
//		String date = dto.getFIRST_VISIT().substring(8, 10);

		switch (dto.getJOB().charAt(0)) {
		case 'P':
			System.out.printf("%s's enterence . ", dto.getNAME());
			System.out.printf("in hand : %d.\n", dto.getMONEY());
			this.rule = new PlayerRules();
			break;
		}
		this.name = dto.getNAME();
		this.money = dto.getMONEY();

	}

	public void print() {
		print("default");
}

	public void print(String s) {
		ArrayList<Object> obj = new ArrayList<Object>();
		for(CardOne card : cards) {
			obj.add( (CardOne) card);
		}
		rule.print(obj, name, s);
	}


	public void isWin(Gamer user, Gamer dealer) {
		rule.isWin(user, dealer);
	}
	public void reset() {
		this.cards.clear();
		this.score = 0;
		this.betmoney = 0;
		this.isState = 0;
	}
	
	
	/**
	 * @return true = player false = dealer
	 */

	public void addCard(CardOne card) {
		System.out.printf("%s Get Card! \n", name);
		cards.add(card);
		this.score = rule.calculScore(cards);
		this.isState = rule.getState(cards.size(), this.score);
	}

	public Rules getRule() {
		return rule;
	}

	public int getState() {
		return isState;
	}

	public void setIsState(int isState) {
		this.isState = isState;
	}

	public int getScore() {
		return score;
	}
	public ArrayList<CardOne> getCards() {
		return cards;
	}
	public void setBetmoney(int betmoney) {
		this.betmoney = betmoney;
	}
	public int getBetmoney() {
		return betmoney;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}


}
