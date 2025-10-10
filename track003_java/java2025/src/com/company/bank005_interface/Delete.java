package com.company.bank005_interface;

import java.util.List;

public class Delete implements BankController {
	@Override
	public int exec(List<UserInfo> users, int find) {
		//변수
		//처리
		UserInfo  u = users.remove(find);
		//출력
		System.out.println("정보를 삭제했습니다 > " + u);
		return 0;
	}
}
//users.add(  new UserInfo("id" , "pw" , 1))
//users.get(0) 0번째유저
//users.size()  유저의 갯수
//users.remove(0) 0번째유저 삭제
