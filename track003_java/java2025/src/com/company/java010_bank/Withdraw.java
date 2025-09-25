package com.company.java010_bank;

import java.util.Scanner;

public class Withdraw {
	private UserInfo userinfo;

	public Withdraw() { super();  }
	public Withdraw(UserInfo userinfo) { super(); this.userinfo = userinfo; }
	
	public void exec() {
		Scanner scanner = new Scanner(System.in);
		//double num = 0;
	//	double origin = 0;
		System.out.print("출금 금액을 입력하시오 : ");
		double balance = scanner.nextDouble();
		//num = scanner.nextDouble();
		//origin = this.userinfo.getBalance();
		//this.userinfo.setBalance(origin-num);
		this.userinfo.setBalance(this.userinfo.getBalance()-balance);
	
		System.out.println("출금 완료 " + this.userinfo);
	}
	
}
