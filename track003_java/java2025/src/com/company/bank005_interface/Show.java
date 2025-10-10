package com.company.bank005_interface;

import java.util.List;

public class Show implements BankController {

	@Override
	public int exec(List<UserInfo> users, int find) {  // Show    : users.get(유저번호)	 
		//출력 - users.get(유저번호).getId() ,  users.get(유저번호).getPass() users.get(유저번호).getBalance()
		
		UserInfo info = users.get(find);
		
		System.out.println(  "ID > "      + info.getId() );
		System.out.println(  "PASS > "    + info.getPass() );
		System.out.println(  "BALANCE > " + info.getBalance() );
		
		// users.add(  new UserInfo("id" , "pw" , 1))
		// users.get(0) 0번째유저
		// users.size()  유저의 갯수
		// users.remove(0) 0번째유저 삭제
		return 0;
	}
}
