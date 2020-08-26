package com.edu.casino.blackjack;

import java.util.ArrayList;

import com.edu.Scanner.MyScanner;
import com.edu.database.dto.CasinoDto;

public class BlackJack_Run {
	private static BlackJack_Run instance;
	private BlackJack_Run() {}

	public static BlackJack_Run getInstance() {
		if(instance == null) {
			instance = new BlackJack_Run();
		}
		return instance;
	}


	public void run(ArrayList<CasinoDto> dto) throws InterruptedException {

		CardPack cp = new CardPack();

		ArrayList<Gamer> gamer = new ArrayList<Gamer>();
		for(CasinoDto user : dto ) {
			gamer.add(new Gamer(user));
		}
		
		Gamer dealer = new Gamer();
		boolean isPlaying = true;
		do {
			for (Gamer user : gamer) {
				user.setBetmoney(MyScanner.input_money(user.getName(), user.getMoney()));
				user.setMoney(user.getMoney() - user.getBetmoney());
			}
			for (Gamer user : gamer) {
				for (int i = 0; i < 2; i++) {
					user.addCard(cp.getOneCard());
				}
				user.print();
			}
			dealer.addCard(cp.getOneCard());
			dealer.addCard(cp.getOneCard());
			dealer.print("blind");
			//Player logic
			int isAllStay = 0;
			while (isAllStay < dto.size() - 1) {
				isAllStay = 0;
				for (Gamer user : gamer) {
					if (user.getState() == 0) {
						Thread.sleep(300);
						user.print();
						if (MyScanner.decision()) {
							user.addCard(cp.getOneCard());
							Thread.sleep(300);
							user.print();
						} else {
							user.setIsState(1);
						}
					} else {
						isAllStay++;
					}
				}
			}
			//dealer logic
			dealer.print("blind");
			if (dealer.getState() == 0) {
				while (dealer.getState() == 0) {
					dealer.addCard(cp.getOneCard());
					Thread.sleep(400);
					dealer.print();
				}
			} else {
				Thread.sleep(400);

				dealer.print();
			}
			//Score Compare 
			System.out.println("Starting CalculScore");
			for (Gamer user : gamer) {
				user.isWin(user, dealer);
			} 
			
			int index =0;
//			for(Gamer user : gamer) {
//				if(user.getMoney() < 100) {
//					System.out.printf("%s Don't have enough money. %s is out" , user.getMoney(), user.getMoney());
//					gamer.remove(index);
//				}
//				index++;
//			}
			
			isPlaying = MyScanner.endgame();
			
		} while (! isPlaying);

	}
	public CasinoDto run(CasinoDto dto) throws InterruptedException {
		CardPack cp = new CardPack();
		
		cardZone cpp = cardZone.getinstance();
		
		Gamer user = new Gamer(dto);
		Gamer dealer = new Gamer();
		boolean isPlaying = true;
		do {
			
			//Beting process
			user.setBetmoney(MyScanner.input_money(user.getName(), user.getMoney()));
			user.setMoney(user.getMoney() - user.getBetmoney());
			//Base Setting
			for(int i = 0 ; i<2; i++) {
				user.addCard(cp.getOneCard());
				dealer.addCard(cp.getOneCard());
			}
			
			//Split Checker
			
			
			
			user.print();			
			dealer.print("blind");
			
			// Player logic
			while (user.getState() == 0) {
				Thread.sleep(300);
				user.print();
				if (MyScanner.decision()) {
					user.addCard(cp.getOneCard());
					Thread.sleep(300);
					user.print();
				} else {
					user.setIsState(1);
				}
			}
			//dealer logic
			dealer.print("blind");
			if (dealer.getState() == 0) {
				while (dealer.getState() == 0) {
					dealer.addCard(cp.getOneCard());
					Thread.sleep(400);
					dealer.print();
				}
			} else {
				Thread.sleep(400);

				dealer.print();
			}
			//Score Compare 
			System.out.println("Starting CalculScore");
			user.isWin(user, dealer);
			
			isPlaying = MyScanner.endgame();
			user.reset();
			dealer.reset();
		} while (! isPlaying);
		
		
		return new CasinoDto(dto.getSEQ(), dto.getID(), 
				dto.getPASSWORD(), dto.getNAME(), user.getMoney(), dto.getFIRST_VISIT(), 
				dto.getRECENT_VISIT(), dto.getJOB());
	}
}
