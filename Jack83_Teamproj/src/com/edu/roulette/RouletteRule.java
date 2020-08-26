package com.edu.roulette;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.edu.casino.blackjack.Rules;

public class RouletteRule implements Rules {
//	Map<String , Integer> bet = new HashMap<String, Integer>();
	@Override
	public void print(ArrayList<Object> obj, String name, String s) {
		// TODO Auto-generated method stub

	}
	
	public void print(Map<String , Integer> bet , int money) {
		
	}

	@Override
	public int getState(int cardpackSize, int score) {
		// TODO Auto-generated method stub
		return 0;
	}

}
