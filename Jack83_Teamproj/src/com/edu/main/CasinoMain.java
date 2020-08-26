package com.edu.main;


import com.edu.Scanner.MyScanner;
import com.edu.casino.blackjack.BlackJack_Run;
import com.edu.database.dao.CasinoDao;
import com.edu.database.dto.CasinoDto;
import com.edu.login.Login;

public class CasinoMain {

	public static void main(String[] args) throws InterruptedException {
		//깃에 저장하기 위한 작업
		
	
		boolean isEnd = false;
		boolean isTest = false;
		if(!isTest) {
		do {			
			CasinoDao jdbc = new CasinoDao();
			
			CasinoDto  dto = Login.login(jdbc);
			dto= BlackJack_Run.getInstance().run(dto);
			jdbc.update(dto);
			isEnd = MyScanner.endgame();
		}while(!isEnd);
		}else {
			CasinoDto dto = new CasinoDto(90, "dudtj", "dudtj", "�迵��", 4000, null, null, "P");
			BlackJack_Run.getInstance().run(dto);
		}
			
		
//		BlackJack_Run.getInstance().run(jdbc.selectAll());
		
		
	}

}

