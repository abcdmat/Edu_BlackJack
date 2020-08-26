package com.edu.login;

import java.util.Scanner;

import com.edu.database.dao.CasinoDao;
import com.edu.database.dto.CasinoDto;

public class Login {
	public static CasinoDto login(CasinoDao jdbc) {
		CasinoDto dto;
		boolean loginState = false;
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println(">>>>>>>>>LOGIN<<<<<<<<<");
			System.out.print("【  I  D 】 : ");
			String id = scan.next();
			System.out.print("【 P W 】: ");
			String password = scan.next();
			dto = jdbc.selectOne(id, password);
			try {
				if(dto.getID().equals(id) && dto.getPASSWORD().equals(password)) {
					System.out.println("LOGIN SUCCESS!");
					loginState = true;
				}else {
					System.out.println("LOGIN Failure");
					System.out.println("Input id : "+id);
					System.out.println("Input pw : "+password);
					System.out.println("Please Check Current ID");

				}
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println("Not Found ID.");
			}
		}while(!loginState);
		return dto;

	}
}
