package com.company.java010_bank;

import java.util.Scanner;

public class Deposit {
	private UserInfo userinfo;

	public Deposit() { super();  }
	public Deposit(UserInfo userinfo) { super(); this.userinfo = userinfo; }
	
		
	public void exec() {// 입금기능
		Scanner scanner = new Scanner(System.in);
	//	double num = 0;
	//	double origin = 0;
		System.out.print("입금 금액을 입력하시오 : ");
		double balance = scanner.nextDouble();
		
	//  num = this.userinfo.getBalance();
	//	origin = this.userinfo.setBalance(num+origin);
		
		this.userinfo.setBalance(this.userinfo.getBalance()+balance);
		
		System.out.println("입금 완료 " + this.userinfo);
		
	}
}


