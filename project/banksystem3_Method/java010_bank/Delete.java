package com.company.java010_bank;

import java.util.Scanner;

public class Delete {
private UserInfo userinfo;
	
	public Delete() { super();  }
	public Delete(UserInfo userinfo) { super(); this.userinfo = userinfo; }
	
	public void exec() {
			this.userinfo.setId(""); 
			this.userinfo.setPass(""); 
			this.userinfo.setBalance(0); 
			System.out.println("정보를 삭제했습니다.");

	}
	
}
