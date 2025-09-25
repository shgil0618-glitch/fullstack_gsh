package com.company.java010_bank;

import java.util.Scanner;

// 1. 부품객체
// 2. 상태와 행위
public class Add {
	// 상태 : 멤버변수
	private UserInfo userinfo;

	public Add() { super();  }
	public Add(UserInfo userinfo) { super(); this.userinfo = userinfo; }
	
	@Override public String toString() { return "Add [userinfo=" + userinfo + "]"; }
	
	// 행위 : 멤버함수
	public void exec() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("[1]아이디 입력 : ");
		this.userinfo.setId(scanner.next());
		System.out.print("[2]비밀번호 입력 : ");
		this.userinfo.setPass(scanner.next());		
		System.out.print("[3]잔액 입력 : ");
		this.userinfo.setBalance(scanner.nextDouble());
		scanner.nextLine();	
		
		
		//this.userinfo = new UserInfo(id,pass,balance);
		System.out.println("사용자 추가 완료 : " + this.userinfo);
	}
	
}

/*
 기능 : 유저추가
  
 */
