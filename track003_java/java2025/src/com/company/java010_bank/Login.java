package com.company.java010_bank;

import java.util.Scanner;

public class Login {
private UserInfo userinfo;
private boolean exit_check = false;
	public Login() { super();  }
	public Login(UserInfo userinfo) { super(); this.userinfo = userinfo; }
	
	public boolean isExit_check() {
		return exit_check;
	}
	public void setExit_check(boolean exit_check) {
		this.exit_check = exit_check;
	}
	/*
	public int exec() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("아이디를 입력하세요 : ");
		String tempid = scanner.next();
		System.out.print("비밀번호를 입력하세요 : ");
		String temppass = scanner.next();
		
		return tempid.equals(this.userinfo.getId()) && temppass.equals(this.userinfo.getPass())? 1:-1;
	}
	*/
	
	public void exec() {
		Scanner scanner = new Scanner(System.in);
		String id;
		String idok;
		String pass;
		String passok;
		System.out.print("아이디를 입력하세요 : ");
		id = scanner.nextLine();
		System.out.print("비밀번호를 입력하세요 : ");
		pass = scanner.nextLine();
		idok = this.userinfo.getId();
		passok = this.userinfo.getPass();
		if(id.equals(idok) && pass.equals(passok)) {
			setExit_check(true);
			}
		else {System.out.println("비밀번호가 틀립니다."); setExit_check(false);}
	}
	
	

}
