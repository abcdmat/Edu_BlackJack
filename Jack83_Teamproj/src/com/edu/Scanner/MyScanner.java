package com.edu.Scanner;

import java.util.Scanner;


public class MyScanner {
	public static final int Min_Betting_Money = 100;
	public static int input_money(String name , int max) {
		int m = 0;
		
		while (true) {
			Scanner scan = new Scanner(System.in);
			try {
				System.out.printf("%s, please insert Betting Money. Now : %d $\n",name, max);
				System.out.printf("Minimum Betting is %d$ , Maxinmun Betting is %d$\n",Min_Betting_Money, max);
				System.out.printf("Your Bet  : ");
				
				 m = scan.nextInt();
				if(max>=m && Min_Betting_Money<=m) {
					if( m == max ) {
						System.out.printf("%s All In", name);
					}
					break;
				
				}else if(Min_Betting_Money>m) {
					System.out.println("Minimum Betting is 100$. please bet more");
				
				}else if(max<m) { // 
					System.out.printf("%d is Out of Bound \n", m);
				}
				
			} catch (Exception e) {
				System.out.println("Please Input Number.");
			}  
		}
		return m;
	}


	public static boolean decision() {
		boolean isc = false;
		while (true) {
			Scanner scan = new Scanner(System.in);
			
				System.out.println("Do You Want to More Card?");
				String answer = scan.nextLine();
				if(answer.trim().toLowerCase().equals("y")) {
					isc = true;
					break;
				}else if(answer.trim().toLowerCase().equals("n")) {
					isc = false;
					break;
				}else if(answer != "n" && answer != "y") {
					System.out.println("");
				}
		}
		return isc; 
	}

	
	

	// 
	public static boolean endgame() throws InterruptedException {
		boolean isc = false;
		System.out.println("One More Playing?");
		String answer;
			Scanner scan = new Scanner(System.in);
			answer = scan.nextLine();
			if (answer.equalsIgnoreCase("exit") || answer.equalsIgnoreCase("end") || answer.equalsIgnoreCase("quit")
					|| answer.equalsIgnoreCase("out") || answer.equalsIgnoreCase("yes")
					|| answer.equalsIgnoreCase("y")) {
				System.out.println("GameRestart");
				for(int i =0; i < 15; i++) {
					for(int j=0; j<=i ; j++) {
						System.out.print("■");
					}
					for(int j=i; j<15 ; j++) {
						System.out.print("□");
					}
					System.out.println();
					Thread.sleep(200);
				}
				isc = false;
			} else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
				isc = true;
				System.out.println("Game Out");
			} else {
				System.out.println("Game Out");
				isc = true;
			}

		return isc;
	}
}
