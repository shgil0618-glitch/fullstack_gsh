package com.company.bank005_interface;

import java.util.List;

public class Add implements BankController {

	@Override
	public void exec(List<UserInfo> users) {
		users.add("0","0",1);
		System.out.println(users);
		
	}

}
