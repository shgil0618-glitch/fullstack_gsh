package com.company.bank005_interface;

import com.company.bank005_interface.Add;
import com.company.bank005_interface.UserInfo;
import com.company.bank005_interface.Login;
import com.company.bank005_interface.WidthDraw;
import com.company.bank005_interface.Deposit;
import com.company.bank005_interface.Delete;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Bank_Main {

	private List<UserInfo> users;	// add, get, size, remove, contains
	private BankController[] controller;

	public void Bank_Main() {
		users = new ArrayList<>();
		controller = new BankController[] { new Login(), new Show(), new Add(), new WidthDraw(), new Deposit(), new Delete() };
	}

	//멤버함수 (메뉴판)
	public void menu() {
		// 변수
		int level = 0;
		Scanner scanner = new Scanner(System.in);
		// 입력 + 처리
		/*
		   System.out.println("\n===== GSH_BANK MENU =====");
                    System.out.println("1. 추가 (회원가입)");
                    System.out.println("2. 조회");
                    System.out.println("3. 입금");
                    System.out.println("4. 출금");
                    System.out.println("5. 삭제");
                    System.out.println("9. 종료");
                    System.out.print("입력 : ");
                    level = scanner.nextInt();
                    scanner.nextLine();
		 
		 
			//1. 유저추가
			//2,3,4,5 
			// 1) Login 2) 2,3,4,5 각각의 처리해야할 일
		
		Q1) 무한반복 + 각번호 입력받으면 ~ 기능입니다 출력
		Q2) 입력받은 번호가 1번이면 유저추가
		Q3) 입력받은 번호가 2,3,4,5 이면
			1) Login
			2) 2,3,4,5 각각에서 처리해야 할일
			
			
		 */
		
		
		
		while (level != 9) {
			System.out.println("\n===== GSH_BANK MENU =====");
			System.out.println("1. 추가 (회원가입)");
			System.out.println("2. 조회");
			System.out.println("3. 입금");
			System.out.println("4. 출금");
			System.out.println("5. 삭제");
			System.out.println("9. 종료");
			System.out.print("입력 : ");
			level = scanner.nextInt();
			scanner.nextLine();

			switch (level) {
			case 1:
				controller[1].exec(users);
				break;
			case 2: case 3: case 4: case 5:
				controller[0].exec(users);
				switch (level) {
				case 2:
					controller[2].exec(users); break;
				case 3:
					controller[3].exec(users); break; 
				case 4:
					controller[4].exec(users); break; 
				case 5:
					controller[5].exec(users); break; 
				}
			case 9 : 
				System.out.println("프로그램을 종료 합니다.");
				break;
			}
			

		}
		
		
	}

	public static void main(String[] args) {
		new Bank_Main().menu();
	}
}
