package com.company.bank006_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank_Main {
	//멤버변수
	private List<UserInfo> users;   // add, get, size, remove, contains
	private Bank_Controller [] controller;
	
	public Bank_Main() {
		users      = new ArrayList<>();
		controller = new Bank_Controller[]{
			new Login(),     new Add(), new Show(),new Deposit(),new Withdraw(), new Transfer(), new TransactionHistory(), new Delete() 
			//controller[0]     1           2             3              4             5				6				7
		};	
	}
	//멤버함수
	public void menu() {
		//변수
		Scanner scanner = new Scanner(System.in);
		int num = -1;
		//입력 + 처리
		while(num!=9) {
			System.out.print("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟\n" + 
		             "\n[1] ➕ 계좌 추가" + "\n[2] 🔍 계좌 조회" + "\n[3] 💵 입금하기" + "\n[4] 💸 출금하기" + "\n[5] 계좌 이체  " + "\n[6] 거래 내역" + "\n[7] 🗑️ 계좌 삭제"
		             +"\n\n👉 번호를 선택하세요:");
			
			num = scanner.nextInt();
			int find = 1;
			//Add : users.add(입력값), 
			/////// Login - 
			//Show : users.get(user번호),  remove
			//Deposit : users.get(user번호) ,setBalance
			//Delete : users.remove(user번호), 
			//  리턴값 메서드명 (파라미터)
			//  int  exec(users, user번호)
			
			if(num>=2 && num<=7) {find = controller[0].exec(users, 0);
				if(find == -1) {continue;}
			}
			controller[num].exec(users, find);
			
		}
	}
		/*	
		 * 뱅크 시스템
		 * 1. 계좌추가
		 * 2. 계좌조회
		 * 3. 입금하기
		 * 4. 출금하기
		 * 5. 계좌삭제
		 * 
		 * 번호선택 : 
		 * 
		 * 
		 * 
		 * Q1. 무한반복 + 각번호 입력받으면 ~기능입니다 출력
		 * Q2. 입력받은 번호가 1번이면 유저 추가
		 * Q3. 입력받은 번호가 2,3,4,5 이면
		 * 1) Login 
		 * 2) 2,3,4,5 각각 할일
		 */
	
	public static void main(String[] args) {
		//start
		new Bank_Main().menu(); 
		
	}

}
