package com.company.java010_bank;

import java.util.Scanner;

//1. 클래스는 부품객체
//2. 상태와 행위
public class Bank_Main {
	//상태 : 멤버변수
	UserInfo userinfo;		// 정보보관용도 - model - db
	Add add;
	Show show;
	Deposit deposit;
	Delete delete;
	Login login;
	Withdraw withdraw;
	
	//행위 : 멤버함수
	public Bank_Main() {
		this.userinfo = new UserInfo();
		this.add = new Add(this.userinfo);
		this.show = new Show(this.userinfo);
		this.deposit = new Deposit(this.userinfo);
		this.delete = new Delete(this.userinfo);
		this.login = new Login(this.userinfo);
		this.withdraw = new Withdraw(this.userinfo);
	}
	public void run() {
		Scanner scanner = new Scanner(System.in);
		int num=-1;
		while(num!=9) {
		//	System.out.println("Main : "+this.userinfo + "\t" + System.identityHashCode(this.userinfo));
			System.out.println("=====BANK=====");
			System.out.println("* 1.추가");
			System.out.println("* 2.조회");
			System.out.println("* 3.입금");
			System.out.println("* 4.출금");
			System.out.println("* 5.삭제");
			System.out.println("* 9.종료");
			System.out.print("입력 : ");
	          num = scanner.nextInt();
	          scanner.nextLine();
	          switch(num) {
	          case 1 : this.add.exec(); break;
	          case 2: case 3 : case 4 : case 5:
	      			this.login.exec();
	      			if( this.login.isExit_check()==true) {}
	      			else {break;}
	        	  switch(num) { 
	        	  case 2 : this.show.exec(); break;
		          case 3 : this.deposit.exec(); break;
		          case 4 : this.withdraw.exec(); break;
		          case 5 : this.delete.exec(); break;
	        	  } break;
	          
	          case 9 : System.out.println("시스템을 종료합니다."); break;
	          
	          }
		}
		
		
	}
	

	public static void main(String[] args) {
		Bank_Main bank = new Bank_Main();
		bank.run();
	}
}
	
