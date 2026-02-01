package com.company.java010_bank;


public class Show {
	
	private UserInfo userinfo;
	
	public Show() { super();  }
	public Show(UserInfo userinfo) { super(); this.userinfo = userinfo; }
	
	
	public void exec() {
		System.out.println("\nID : "+this.userinfo.getId()+ 
				"\nPASS : "+this.userinfo.getPass()+ 
				"\nBALANCE : "+this.userinfo.getBalance());
	}
	
	
}
/*
 기능 : 유저정보 보여주기 
 
*/