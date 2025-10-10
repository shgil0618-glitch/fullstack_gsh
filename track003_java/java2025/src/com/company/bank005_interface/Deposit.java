package com.company.bank005_interface;

import java.util.List;
import java.util.Scanner;

public class Deposit implements BankController {
	@Override
	public int exec(List<UserInfo> users, int find) { 
		// Deposit : users.get(유저번호)
		// 변수
		Scanner scanner = new Scanner(System.in);
		// 입력 - 금액입력받기
		System.out.println("입금할 금액을 입력 > "); double balance = scanner.nextDouble();
		// 처리 - 해당유저의 금액에 추가
		UserInfo u = users.get(find);
		u.setBalance(  u.getBalance()  +  balance);
		// 출력 - 입금이 완료되었습니다.
		System.out.println("입금이 완료되었습니다. > " +  u );
		return 0;
	}
}
// users.add(  new UserInfo("id" , "pw" , 1))
// users.get(0) 0번째유저
// users.size()  유저의 갯수
// users.remove(0) 0번째유저 삭제